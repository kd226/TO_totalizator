package agh.to.lab.totalizator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameManager {
	private static int nextGameId = 1;
	private Map<Integer, Game> games = new HashMap<>();
	private SubscriptionManager subscriptionManager;

	public GameManager(SubscriptionManager subscriptionManager) {
	    this.subscriptionManager = subscriptionManager;
	    this.games = new HashMap<>();
    }
	
	public Collection<Game> getAvailableGames(){
		return games.values();
	}
	
	public void addGame(Game game) {
		game.setId(nextGameId);
		nextGameId++;
		game.setManager(this);
		games.put(game.getId(), game);
		subscriptionManager.addGameId(game.getId());
	}
	
	public void gameStateChanged(Integer gameId) {
		try {
            String result = games.get(gameId).getResults();
            subscriptionManager.sendResult(gameId, result);
		} catch (GameNotFinishedYetException e) {
			// Do nothing, someone incorrectly called this function
		}
	}
}