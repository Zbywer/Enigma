//import Ciphers.Cipher;
//import Ciphers.impl.CesarCipher;
//
//public class Test {
//    public static void main(String[] args) {
//        Cipher cesarCipher = new CesarCipher();
//        String example = cesarCipher.decode("");
//        System.out.println(example);
//        String decoded = cesarCipher.decode("rhkkouvvrdssce1234VCxZee");
//        System.out.println(decoded);
//    }
//
//}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMain extends Application {
    String resourcesPath = "/fxml/Test.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {  // stage - wycinek ekranu na monitorze, na tym możemy
        // tworzyć nasze scenes
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcesPath)); //resourcePath - odwołanie do
        // naszego pliku test.xmlm
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400); //stworzenie sceny
        primaryStage.setTitle("Enigma"); //ustawienie nazwy sceny
        primaryStage.setScene(scene); // ustawienie podstawowej scene na naszej stage, można przełączać
        primaryStage.show();
    }
}

