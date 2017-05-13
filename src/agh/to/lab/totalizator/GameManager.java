package agh.to.lab.totalizator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GameManager {
	private static int nextGameId = 1;
	private Map<Integer, Set<Integer> > subscribers = new HashMap<>();
	private Map<Integer, Game> games = new HashMap<>();
	
	public Collection<Game> getAvailableGames(){
		return games.values();
	}
	
	public void addSubscriber(Integer userId, Integer gameId) {
		if( !games.containsKey(gameId) ) {
			throw new GameNotFoundException();
		}
		subscribers.get(gameId).add(userId);
	}
	
	public void addGame(Game game) {
		game.setId(nextGameId);
		nextGameId++;
		game.setManager(this);
		games.put(game.getId(), game);
		subscribers.put(game.getId(), new HashSet<Integer>());
	}
	
	public void gameStateChanged(Game game) {
		try {
			// TODO: Use communication manager to send information
		} catch (GameNotFinishedYetException e) {
			// Do nothing, someone incorrectly called this function
		}
	}
}