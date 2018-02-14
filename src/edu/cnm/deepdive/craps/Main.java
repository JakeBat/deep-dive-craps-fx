package edu.cnm.deepdive.craps;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

  private static final String RESOURCES_BUNDLE_PATH = "resources/strings";
  private static final String FXML_PATH = "resources/main.fxml";
  private static final String WINDOW_TITLE_KEY = "windowTitle";
  private static final String ICON_PATH = "resources/icon.png";

  private ClassLoader cLoader; //classLoader
  private ResourceBundle rBundle; //bundle
  private FXMLLoader fLoader; //fxmlLoader
  private Controller control; //controller

  @Override
  public void start(Stage stage) throws Exception {
    setupLoaders();
    setupStage(stage,loadLayout());
  }

  private void setupLoaders() {
    cLoader = getClass().getClassLoader();
    rBundle = ResourceBundle.getBundle(RESOURCES_BUNDLE_PATH);
    fLoader = new FXMLLoader(cLoader.getResource(FXML_PATH), rBundle);
  }

  private Parent loadLayout() throws IOException {
    Parent pRoot /*root*/ = fLoader.load();
    control =fLoader.getController();
    // TODO - Do something with controller
    return pRoot;
  }

  private void setupStage(Stage window /*stage*/, Parent pRoot /*root*/) {
    Scene mScene= new Scene(pRoot);
    window.setTitle(rBundle.getString(WINDOW_TITLE_KEY));
    window.getIcons().add(new Image(cLoader.getResourceAsStream(ICON_PATH)));
    window.setResizable(false);
    window.setScene(mScene);
    window.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
