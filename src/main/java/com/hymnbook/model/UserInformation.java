package com.hymnbook.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_informations")
public class UserInformation extends SuperTable {
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="device_name")
	private String deviceName;
	
	@Column(name="grant_permission")
	private boolean grantPermission;
	
	@Column(name="last_visit")
	private Timestamp lastVisit;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public boolean isGrantPermission() {
		return grantPermission;
	}

	public void setGrantPermission(boolean grantPermission) {
		this.grantPermission = grantPermission;
	}

	public Timestamp getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Timestamp lastVisit) {
		this.lastVisit = lastVisit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInformation [ipAddress=");
		builder.append(ipAddress);
		builder.append(", deviceName=");
		builder.append(deviceName);
		builder.append(", grantPermission=");
		builder.append(grantPermission);
		builder.append(", lastVisit=");
		builder.append(lastVisit);
		builder.append(", now=");
		builder.append(now);
		builder.append(", id=");
		builder.append(id);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}
	
}
