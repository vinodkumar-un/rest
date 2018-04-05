package com.yw.delegate;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import in.co.irct.rail.wsdl.Reservation;
import in.co.irct.types.PassengerInfo;
import in.co.irct.types.TicketInfo;
import in.co.irct.types.TravelInfo;

import com.yw.dto.ReservationDTO;
import com.yw.dto.TicketDTO;
import com.yw.util.ReservationException;
import com.yw.util.TrainInfoServiceLocator;

public class ReservationDelegate {
	public TicketDTO bookTicket(ReservationDTO dto) throws ReservationException {
		TicketDTO ticket = null;
		Reservation port = null;
		TravelInfo travelInfo = null;
		TicketInfo ticketInfo = null;
		PassengerInfo passengerInfo = null;
		TrainInfoServiceLocator serviceLocator = null;

		try {
			travelInfo = new TravelInfo();
			travelInfo.setSrc(dto.getSrc());
			travelInfo.setDest(dto.getDest());
			travelInfo.setDoj(dto.getDoj());

			passengerInfo = new PassengerInfo();
			passengerInfo.setSsn(dto.getSsn());
			passengerInfo.setName(dto.getName());
			passengerInfo.setAge(dto.getAge());

			serviceLocator = new TrainInfoServiceLocator();
			port = serviceLocator.getReservationPort();
			ticketInfo = port.bookTicket(travelInfo, passengerInfo);

			ticket = new TicketDTO(ticketInfo.getPnr(), ticketInfo.getCoach(),
					ticketInfo.getBerth(), ticketInfo.getStatus());
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ReservationException("Unable to process reservation", e);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new ReservationException("Unable to process reservation", e);
		} finally {

		}

		return ticket;
	}
}
