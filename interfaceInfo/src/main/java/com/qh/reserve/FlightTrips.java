package com.qh.reserve;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * ∫Ω∞‡–≈œ¢
 * @author Administrator
 *
 */
public class FlightTrips {
	
	private List<FlightTrip> flightTrip;//
	@XmlElement(name="FlightTrip")
	public List<FlightTrip> getFlightTrip() {
		return flightTrip;
	}

	public void setFlightTrip(List<FlightTrip> flightTrip) {
		this.flightTrip = flightTrip;
	}

	public FlightTrips(List<FlightTrip> flightTrip) {
		super();
		this.flightTrip = flightTrip;
	}

	public FlightTrips() {
		super();
	}
	
	

}
