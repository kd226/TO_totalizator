package agh.to.lab.totalizator;

public class FootballSetGame extends Game {
	public final String teamA, teamB;
	public final int scoreA, scoreB;
	
	public FootballSetGame(String name, String teamA, int scoreA, String teamB, int scoreB) {
		super(name);
		this.teamA = teamA;
		this.teamB = teamB;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}
	
	@Override
	public void setManager(GameManager manager) {
		super.setManager(manager);
		Game game = this;
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                game.isFinished = true;
		                game.notifyManager();
		            }
		        }, 
		        5000 
		);
	}

	@Override
	public String getResults() {
		if( isFinished ) {
			throw new GameNotFinishedYetException();
		}
		return teamA + " " + scoreA + ":" + scoreB + " " + teamB;
	}

}
