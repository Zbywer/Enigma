package Factories.impl;

import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;
import Ciphers.impl.Root13Cipher;
import exceptions.CipherNotFoundException;

public class CipherFactoryImpl implements Factories.CipherFactory {
    public static final String CESAR = "cesar";
    public static final String ROOT13 = "root13";

    @Override
    public Cipher create(String type) {
        if(type.equals(CESAR)){
            return new CesarCipher();
        }
        if(type.equals(ROOT13)){
            return new Root13Cipher();
        }
        throw new CipherNotFoundException(type);

    }
}
