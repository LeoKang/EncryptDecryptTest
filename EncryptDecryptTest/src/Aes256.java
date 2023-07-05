import javax.crypto.Cipher;
import javax.crypto.spec.*;
import java.util.Base64;

public class Aes256 {
    private String secretKey = "12345678901234567890123456789012";
    private String iv = "abcdefghijklmnop";

    public String encrypt(String text) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(secretKey.getBytes(), "AES"),
                    new IvParameterSpec(iv.getBytes()));

            return new String(Base64.getEncoder().encode(cipher.doFinal(text.getBytes("UTF-8"))));
        } catch(Exception e) {
            return text;
        }
    }

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    new SecretKeySpec(secretKey.getBytes(), "AES"),
                    new IvParameterSpec(iv.getBytes()));

            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText.getBytes("UTF-8"))));
        } catch(Exception e) {
            return encryptedText;
        }
    }
}
