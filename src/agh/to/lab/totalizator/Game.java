package agh.to.lab.totalizator;

abstract public class Game {
	private GameManager manager;
	private int id;
	public final String name;
	protected boolean isFinished = false;
	
	public Game(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setManager(GameManager manager) {
		this.manager = manager;
	}
	
	public abstract String getResults();
	
	protected void notifyManager() {
		if( !isFinished ) {
			throw new GameNotFinishedYetException();
		}
		if( manager != null ) {
			manager.gameStateChanged(this);
		}
	}
}
