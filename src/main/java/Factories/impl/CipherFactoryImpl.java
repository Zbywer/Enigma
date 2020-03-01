package Factories.impl;

import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;
import Ciphers.impl.Root13Cipher;
import Ciphers.impl.VigenereCipher;
import exceptions.CipherNotFoundException;

public class CipherFactoryImpl implements Factories.CipherFactory {
    public static final String CESAR = "Cesar";
    public static final String ROOT13 = "Root13";
    public static final String VIGENERE = "Vigenere";

    @Override
    public Cipher create(String type) {
        if (type.equals(CESAR)) {
            return new CesarCipher();
        }
        if (type.equals(ROOT13)) {
            return new Root13Cipher();
        }
        if (type.equals(VIGENERE)){
            return (Cipher) new VigenereCipher();
        }
        throw new CipherNotFoundException(type);

    }
}
