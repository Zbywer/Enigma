package controllers;

import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;
import application.Main;
import file.utils.FileTool;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable { // dzięki temu interfejsowi nasz fxlm może być parsowany
private Stage mainStage;

    @FXML
    TextArea inputTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String encode = cesarCipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String decode = cesarCipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }


    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null); //plik wybrany przez użytkownika
        if (fileToSave != null) {
            String absolutePath = fileToSave.getAbsolutePath(); //ściągam absolutną scieżkę
            try {
                FileTool.writeFileContent(absolutePath, inputTextArea.getText());
            } finally {

            }
//            catch (IOException e) {
//                System.out.println("Could not save text file in file" + absolutePath + "exception :" + e);
            }
        }


    @FXML
    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load the file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToLoad = fileChooser.showOpenDialog(mainStage);
        if (null != fileToLoad){
        String fileContent = FileTool.getFileContent(fileToLoad.getAbsolutePath());
        inputTextArea.setText(fileContent);

            }
        }
    }