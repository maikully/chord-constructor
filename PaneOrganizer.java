package ChordConstructor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Class for the PaneOrganizer. Contains the root pane and the quitbutton
 */
public class PaneOrganizer {
    private BorderPane _root;
    /**
     * Constructor for the pane organizer that creates the root BorderPane
     * and the quitbutton
     */
    public PaneOrganizer() {
        _root = new BorderPane();
        _root.setPrefSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        Pane constructorPane = new Pane();
        constructorPane.setPrefSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        new ChordConstructor(constructorPane);
        _root.setCenter(constructorPane);
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(new QuitHandler());
        _root.setTop(quitButton);
    }
    public BorderPane getRoot() {
        return _root;
    }
    private class QuitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.exit(0);
        }
    }
}
