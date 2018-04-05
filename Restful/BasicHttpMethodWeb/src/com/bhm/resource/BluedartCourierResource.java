package com.bhm.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bhm.dto.ParcelInfo;

@Path("/bluedart")
public class BluedartCourierResource {
	private Map<Integer, ParcelInfo> parcelDataMap;
	private AtomicInteger index;

	public BluedartCourierResource() {
		parcelDataMap = new HashMap<Integer, ParcelInfo>();
		index = new AtomicInteger(0);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public int createParcel(InputStream is) {
		ParcelInfo parcelInfo = null;
		int awbNo = 0;

		try {
			parcelInfo = buildParcelInfo(is);
			awbNo = index.incrementAndGet();
			parcelInfo.setAwbNo(awbNo);
			parcelInfo.setStatus("New");
			parcelDataMap.put(awbNo, parcelInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return awbNo;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getParcelInfo(@QueryParam("awbNo") int awbNo) {
		ParcelInfo parcelInfo = null;
		String xml = null;

		parcelInfo = parcelDataMap.get(awbNo);
		if (parcelInfo != null) {
			xml = convert(parcelInfo);
		}
		return new ParcelInfoWriter(xml);
	}

	private final class ParcelInfoWriter implements StreamingOutput {
		private String xml;

		public ParcelInfoWriter(String xml) {
			this.xml = xml;
		}

		@Override
		public void write(OutputStream out) throws IOException,
				WebApplicationException {
			PrintWriter writer = null;

			writer = new PrintWriter(out);
			writer.print(xml);
			writer.close();
		}

	}

	private ParcelInfo buildParcelInfo(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		ParcelInfo parcelInfo = null;
		Document doc = null;
		Node root = null;
		NodeList children = null;
		Node child = null;

		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		doc = builder.parse(is);

		if (doc != null) {
			parcelInfo = new ParcelInfo();
			root = doc.getFirstChild();
			children = root.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				child = children.item(i);
				if (child.getNodeName().equals("awbNo")) {
					parcelInfo
							.setAwbNo(Integer.parseInt(child.getTextContent()));
				} else if (child.getNodeName().equals("src")) {
					parcelInfo.setSrc(child.getTextContent());
				} else if (child.getNodeName().equals("dest")) {
					parcelInfo.setDest(child.getTextContent());
				} else if (child.getNodeName().equals("descr")) {
					parcelInfo.setDescr(child.getTextContent());
				} else if (child.getNodeName().equals("status")) {
					parcelInfo.setStatus(child.getTextContent());
				}
			}
		}
		return parcelInfo;
	}

	private String convert(ParcelInfo parcelInfo) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		buffer.append("<?xml version='1.0' encoding='utf-8'?>")
				.append("<parcelInfo>").append("<awbNo>")
				.append(parcelInfo.getAwbNo()).append("</awbNo>");
		buffer.append("<src>").append(parcelInfo.getSrc()).append("</src>");
		buffer.append("<dest>").append(parcelInfo.getDest()).append("</dest>");
		buffer.append("<descr>").append(parcelInfo.getDescr())
				.append("</descr>");
		buffer.append("<status>").append(parcelInfo.getStatus())
				.append("</status>").append("</parcelInfo>");

		return buffer.toString();
	}

}
