package agh.to.lab.totalizator;

import java.util.HashMap;
import java.util.Map;

public class CommunicationManager {
	private Map<DeviceType, ISender> senders;
	private Map<Integer, Device> devices;
	
	public CommunicationManager(Map<DeviceType, ISender> senders) {
		this.senders = senders;
		this.devices = new HashMap<>();
	}

	public void register(Device device) {
		devices.put(device.getUserId(), device);
	}
	
	public void unregister(Integer id) {
		devices.remove(id);
	}
	
	public void send(Integer userId, String value) {
		Device target = devices.get(userId);
		senders.get(target.getDeviceType()).send(target.getUri(), value);
	}
}
