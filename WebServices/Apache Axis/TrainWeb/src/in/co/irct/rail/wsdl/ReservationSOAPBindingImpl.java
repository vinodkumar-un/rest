/**
 * ReservationSOAPBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.co.irct.rail.wsdl;

import in.co.irct.types.TicketInfo;

public class ReservationSOAPBindingImpl implements
		in.co.irct.rail.wsdl.Reservation {
	public in.co.irct.types.TicketInfo bookTicket(
			in.co.irct.types.TravelInfo tInfo,
			in.co.irct.types.PassengerInfo pInfo)
			throws java.rmi.RemoteException {
		TicketInfo ticketInfo = null;

		ticketInfo = new TicketInfo();
		ticketInfo.setPnr(pInfo.getSsn() + "-PNR");
		ticketInfo.setCoach("s1");
		ticketInfo.setBerth(1);
		ticketInfo.setStatus("CONFIRMED");

		return ticketInfo;
	}

}
