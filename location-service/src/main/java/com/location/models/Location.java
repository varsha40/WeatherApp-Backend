package com.location.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather_location")
public class Location{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer locationId;
	
	@Column(name = "location")
	String location;
	
	@Column(name = "location_order")
	Integer locationOrder;

	public Integer getLocationOrder() {
		return locationOrder;
	}

	public void setLocationOrder(Integer locationOrder) {
		this.locationOrder = locationOrder;
	}

	public Location() {
		super();
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	

	public Location(Integer locationId, Integer locationOrder, String location) {
		super();
		this.locationId = locationId;
		this.locationOrder = locationOrder;
		this.location = location;
	}

	public Location(String location, Integer locationOrder) {
		super();
		this.location = location;
		this.locationOrder = locationOrder;
	}
	
}
