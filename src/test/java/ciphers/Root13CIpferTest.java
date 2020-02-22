package ciphers;

import Ciphers.Cipher;
import Ciphers.impl.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13CIpferTest {
    protected final String textWithAlphabeticLetters = "a";
    protected final String expectedTextForAlphabeticLetters = "n";
    protected final String textWithoutAlphabeticLetters = "().,;[]-=!  ???";
    protected Cipher root13Cipher = new Root13Cipher();

    @DisplayName("testing correction of encoding text with alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded() {
        String encode = root13Cipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, encode);
    }
@DisplayName(" testing if there are any non-alphabetic signs")
    @Test
    protected void testIfNoAlphabeticTextNoChange() {
        String decode = root13Cipher.decode((textWithoutAlphabeticLetters));
        Assertions.assertEquals(textWithoutAlphabeticLetters, decode);
    }
}


