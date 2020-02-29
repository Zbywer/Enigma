package controllers;

import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable { // dzięki temu interfejsowi nasz fxlm może być parsowany


    @FXML
    TextArea textArea;

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String encode = cesarCipher.encode(userText);
            textArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String decode = cesarCipher.decode(userText);
            textArea.setText(decode);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

