import Ciphers.Cipher;
import Ciphers.impl.CesarCipher;

public class Test {
    public static void main(String[] args) {
        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.decode("");
        System.out.println(example);
        String decoded = cesarCipher.decode("rhkkouvvrdssce1234VCxZee");
    }
}