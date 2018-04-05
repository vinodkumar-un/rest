package com.ch.resource;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/aadhar")
public class AadharRegistration {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/inputstream")
	public String register(InputStream inputstream) throws IOException {
		int c = 0;
		StringBuffer buffer = null;
		BufferedInputStream bis = null;

		buffer = new StringBuffer();
		bis = new BufferedInputStream(inputstream);
		try {
			while ((c = bis.read()) != -1) {
				buffer.append((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bis.close();
			inputstream.close();
		}
		return buffer.toString();
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/reader")
	public String register(Reader reader) throws IOException {
		String line = null;
		BufferedReader br = null;
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		br = new BufferedReader(reader);
		try {
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
			reader.close();
		}
		return buffer.toString();
	}

	@Path("/byte")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String register(byte[] body) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		if (body != null && body.length > 0) {
			for (byte b : body) {
				buffer.append((char) b);
			}
		}
		return buffer.toString();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/phrase")
	public byte[] getDailyPhrase() {
		String responseBody = null;

		responseBody = "<phrase><msg>Drive safely!</msg></phrase>";
		return responseBody.getBytes();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/upload")
	public String uploadAadharData(File file) throws IOException {
		int c = 0;
		StringBuffer buffer = null;
		FileInputStream fis = null;

		buffer = new StringBuffer();
		if (file != null) {
			fis = new FileInputStream(file);
			while ((c = fis.read()) != -1) {
				buffer.append((char) c);
			}
		}
		return buffer.toString();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/form")
	public String register(MultivaluedMap<String, String> formData) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		for (String key : formData.keySet()) {
			buffer.append("key : ").append(key).append(" value : ")
					.append(formData.getFirst(key));
		}

		return buffer.toString();
	}

}
