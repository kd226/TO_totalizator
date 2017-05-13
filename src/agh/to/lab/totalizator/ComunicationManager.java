package agh.to.lab.totalizator;

import java.util.HashMap;
import java.util.Map;

public class ComunicationManager {
	private Map<DeviceType, ISender> senders;
	private Map<Integer, Device> devices;
	private GameManager gameManager;
	
	public ComunicationManager(Map<DeviceType, ISender> senders,
			GameManager gameManager) {
		this.senders = senders;
		this.devices = new HashMap<>();
		this.gameManager = gameManager;
	}

	public void register(Device device) {
		devices.put(device.getUserId(), device);
	}
	
	public void unregister(Integer id) {
		devices.remove(id);
	}
	
	public void subscribeGame(Integer userId, Integer gameId) {
		gameManager.addSubscriber(userId, gameId);
	}
	
	public void send(Integer userId, String value) {
		Device target = devices.get(userId);
		senders.get(target.getDeviceType()).send(target.getUri(), value);
	}
}
