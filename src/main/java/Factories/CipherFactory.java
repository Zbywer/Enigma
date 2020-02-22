package Factories;

import Ciphers.Cipher;

public interface CipherFactory {
    Cipher create(String type);

}
