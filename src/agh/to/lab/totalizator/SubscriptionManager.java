package agh.to.lab.totalizator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SubscriptionManager {
    protected Map<Integer, Set<Integer>> subscribers;
    private CommunicationManager communicationManager;

    public SubscriptionManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
        subscribers = new HashMap<>();
    }

    public void addSubscriber(Integer userId, Integer gameId) {
        if( !subscribers.containsKey(gameId) ) {
            throw new GameNotFoundException();
        }
        subscribers.get(gameId).add(userId);
    }

    public void removeSubscriber(Integer userId, Integer gameId) {
        subscribers.get(gameId).remove(userId);
    }

    public void sendResult(Integer gameId, String result) {
        subscribers.get(gameId).forEach(userId -> communicationManager.send(userId, result));
    }

}