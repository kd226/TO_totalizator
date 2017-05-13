package agh.to.lab.totalizator;

import java.net.URI;

public class Device {
	private DeviceType deviceType;
	private Integer userId;
	private URI uri;
	
	public Device(DeviceType deviceType, Integer userId, URI uri) {
		this.deviceType = deviceType;
		this.userId = userId;
		this.uri = uri;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public Integer getUserId() {
		return userId;
	}

	public URI getUri() {
		return uri;
	}

}
