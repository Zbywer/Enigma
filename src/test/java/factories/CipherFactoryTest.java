package factories;

import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;
import Ciphers.impl.Root13Cipher;
import Factories.CipherFactory;
import Factories.impl.CipherFactoryImpl;
import exceptions.CipherNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {
    private static final String MESSAGE = "Type of cipher is not recognized: ";
    private CipherFactory factory = new CipherFactoryImpl();
        @Test
        protected void ifCesarCipherInstanceReturnedWithCesarTypeTest() {
            Cipher cipher = factory.create(CipherFactoryImpl.CESAR);  //tworzenie obiektów staje się polimorficzne
            Assertions.assertTrue(cipher instanceof CesarCipher);
        }

        @Test
        protected void ifRoot13CipherInstanceReturnedWithCesarTypeTest() {
            Cipher cipher = factory.create(CipherFactoryImpl.ROOT13);
            Assertions.assertTrue(cipher instanceof Root13Cipher);
        }

        @Test
        protected void shouldThrowExceptionWithGivenUnrecognizedType() {
            String unrecognized = "unrecognized";
            Assertions.assertThrows(CipherNotFoundException.class, () -> factory.create(unrecognized),
                    MESSAGE + unrecognized);
        }
    }


