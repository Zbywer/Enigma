package ciphers;

import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest { //testujemy przykładami tekstu, znamy nasze oczekiwania
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextForAlphabeticLetters = "defgg";
    protected final String mixedText = "123acc";
    protected final String getExpectedTextForMixedLetters = "123df//";
    protected final String getExpectedTextForAlphabeticLetters = "ABC";
    protected Cipher cesarCipher = new CesarCipher();

    @DisplayName("testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded() {
        String decode = cesarCipher.decode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decode);
    }

    @DisplayName("Testing correction of encoding text with alphabetic letters")
    @Test
    public void testIfEncodingModifyTextWithAlphabeticChars() {
        String encoded = cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, encoded);
    }

//    @DisplayName("Testing correction of decoding text with alphabetic letters")
//    @Test
//    public void testIfDecodingModifyTextWithAlphabeticChars() {
//        String decoded = cesarCipher.decode(textWithAlphabeticLetters, decode);

//    }
}

