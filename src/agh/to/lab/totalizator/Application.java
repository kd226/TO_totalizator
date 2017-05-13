package agh.to.lab.totalizator;

import java.util.HashMap;
import java.util.Map;
import java.net.URI;

public class Application {
	public static void main(String [] args)
	{
		Map<DeviceType,ISender> senders = new HashMap<>();
		senders.put(DeviceType.Android, new AndroidSender() );
		CommunicationManager communicationManager = new CommunicationManager(senders);
		SubscriptionManager subscriptionManager = new SubscriptionManager(communicationManager);
		GameManager gameManager = new GameManager(subscriptionManager);
		Game game = new FootballSetGame("Puchar świata w piłce nożnej", "Polska", 10, "Niemcy", 0);
		gameManager.addGame(game);
//		
		Device device = new Device(DeviceType.Android, 1, URI.create("test.pl"));
		communicationManager.register(device);
		subscriptionManager.addSubscriber(1, 1);
//		
		for( int i=0; i<10; i++ ) {
			try {
				System.out.println("Server is running");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
