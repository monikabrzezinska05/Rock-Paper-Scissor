package rps.bll.game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

public class GameModel {

    private GameManager gm;

    private StringProperty playerName;
    private StringProperty aiName;

    private StringProperty scoreText;

    private int playerWins = 0, aiWins = 0;

    public GameModel() {
        IPlayer player = new Player("Player", PlayerType.Human);
        IPlayer ai = new Player("Computer", PlayerType.AI);

        playerName = new SimpleStringProperty(player.getPlayerName());
        aiName = new SimpleStringProperty(ai.getPlayerName());
        scoreText = new SimpleStringProperty("");
        updateScoreLabelText();

        gm = new GameManager(player, ai);
    }

    public StringProperty getPlayerNameProperty() {
        return playerName;
    }

    public StringProperty getAiName() {
        return aiName;
    }

    public StringProperty getScoreTextProperty() {
        return scoreText;
    }

    public void playRound(Move playerMove) {
        gm.playRound(playerMove);
        var moves = gm.getGameState().getHistoricResults();

        var last = moves.stream().reduce((first, second) -> second).orElse(null);

        if(last == null) return;
        if(last.getWinnerPlayer().getPlayerType() == PlayerType.Human) playerWins++; else aiWins++;

        updateScoreLabelText();
    }

    private void updateScoreLabelText() {
        scoreText.set(playerWins + " - " + aiWins);
    }

}
