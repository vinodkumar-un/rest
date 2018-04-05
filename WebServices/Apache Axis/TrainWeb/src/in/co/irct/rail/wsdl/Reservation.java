/**
 * Reservation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.co.irct.rail.wsdl;

public interface Reservation extends java.rmi.Remote {
	public in.co.irct.types.TicketInfo bookTicket(
			in.co.irct.types.TravelInfo tInfo,
			in.co.irct.types.PassengerInfo pInfo)
			throws java.rmi.RemoteException;
}
