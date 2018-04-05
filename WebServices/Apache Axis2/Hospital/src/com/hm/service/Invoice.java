package com.hm.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://apollo.com/invoice/wsdl", portName = "InvoiceSOAPPort", serviceName = "InvoiceService", name = "Invoice")
public class Invoice {
	@WebMethod(action = "http://apollo.com/invoice/wsdl#generateBill")
	@WebResult(name = "amount")
	public float generateBill(@WebParam(name = "patient_id") String patientId) {
		return 353.4f;
	}
}
