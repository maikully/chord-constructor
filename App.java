package ChordConstructor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The App class instantiates the PaneOrganizer and the Scene, and calls the launch method.
 */

public class App extends Application {

    public App() {
        // Constructor code goes here.
    }

    @Override
    public void start(Stage stage) throws Exception {
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Progression Constructor!");
        stage.show(); 
    }

    public static void main(String[] args) {
        launch(args); // launch is a method inherited from Application
    }
}
