package controllers;

import Ciphers.Cipher;
import Ciphers.impl.VigenereCipher;
import Factories.CipherFactory;
import Factories.impl.CipherFactoryImpl;
import application.Main;
import file.utils.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import static Factories.impl.CipherFactoryImpl.*;

public class MainController implements Initializable { // dzięki temu interfejsowi nasz fxlm może być parsowany
    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods = FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13,VIGENERE));
    private CipherFactory cipherFactory = new CipherFactoryImpl();


    ;

    @FXML
    TextArea inputTextArea;

    @FXML
    ChoiceBox<String> cipherChoiceBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cipherChoiceBox.setItems(possibleCipherMethods);
        cipherChoiceBox.setValue(CESAR);
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Please choose and remember it!");
                inputDialog.setContentText("Key");
                Optional<String> userInputOptional = inputDialog.showAndWait(); //czeka na działanie użytkownika
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
//                    if(userInputOptional.equals("")){
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Warning");
//                    alert.setHeaderText("Key value can not be empty");
//                    alert.showAndWait();
                    return;
                }

            }
            String encode = cipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
           if (cipher instanceof VigenereCipher) {
               TextInputDialog inputDialog = new TextInputDialog("Key");
               inputDialog.setHeaderText("If You know tke key, write it here");
               inputDialog.setContentText("Key:");
               Optional<String> userInputOptionl = inputDialog.showAndWait();
               if(userInputOptionl.isPresent() && !userInputOptionl.get().equals("")){
                   ((VigenereCipher)(cipher)).setKey((userInputOptionl.get()));
               } else {
                   return;
               }
           }
                String decoded = cipher.decode(userText);
                inputTextArea.setText(decoded);
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
        if (null != fileToLoad) {
            String fileContent = FileTool.getFileContent(fileToLoad.getAbsolutePath());
            inputTextArea.setText(fileContent);

        }
    }
}