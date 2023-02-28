package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rps.bll.game.GameModel;
import rps.bll.game.Move;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {

    private GameModel model;

    @FXML
    public Label scoreLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new GameModel();
        scoreLabel.textProperty().bind(model.getScoreTextProperty());
    }

    public void handleRock(ActionEvent actionEvent) {
        model.playRound(Move.Rock);
    }

    public void handlePaper(ActionEvent actionEvent) {
        model.playRound(Move.Paper);
    }

    public void handleScissor(ActionEvent actionEvent) {
        model.playRound(Move.Scissor);
    }
}
