package com.yw.util;

import javax.xml.rpc.ServiceException;

import in.co.irct.rail.wsdl.Reservation;
import in.co.irct.rail.wsdl.ReservationService;
import in.co.irct.rail.wsdl.ReservationServiceLocator;

public class TrainInfoServiceLocator {
	public Reservation getReservationPort() throws ServiceException {
		ReservationService service = null;
		Reservation port = null;

		service = new ReservationServiceLocator();
		port = service.getReservationSOAPPort();

		return port;
	}
}
