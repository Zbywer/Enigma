package Ciphers.impl;

import Ciphers.Cipher;

public class CesarCipher implements Cipher {
    @Override
    public String encode(String textToEncode) {
        char[] lettersInMamaWord = textToEncode.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char sign : lettersInMamaWord) {
            boolean isUpperCase = Character.isUpperCase(sign);
            char codedLetter = Character.toUpperCase(sign);
            if (Character.isAlphabetic(sign)) {
                if (codedLetter == 88) {
                    codedLetter = 'A';
                } else if (codedLetter == 89) {
                    codedLetter = 'B';
                } else if (codedLetter == 90) {
                    codedLetter = 'C';
                } else {
                    codedLetter = (char) (codedLetter + 3);
                }
                if (!isUpperCase) {
                    codedLetter = Character.toLowerCase(codedLetter);
                }
                stringBuilder.append(codedLetter);
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String textToDecode) {
            char[] lettersInMamaWord = textToDecode.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char sign : lettersInMamaWord) {
                boolean isUpperCase = Character.isUpperCase(sign);
                char codedLetter = Character.toUpperCase(sign);
                if (Character.isAlphabetic(sign)) {
                    if (codedLetter == 65) {
                        codedLetter = 'X';
                    } else if (codedLetter == 66) {
                        codedLetter = 'Y';
                    } else if (codedLetter == 67) {
                        codedLetter = 'Z';
                    } else {
                        codedLetter = (char) (codedLetter - 3);
                    }
                    if (!isUpperCase) {
                        codedLetter = Character.toLowerCase(codedLetter);
                    }
                    stringBuilder.append(codedLetter);
                } else {
                    stringBuilder.append(sign);
                }
            }
            return stringBuilder.toString();

        }
    }

