package protocolos;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class AESEncriptacion {

    // Método para generar una clave AES
    // Comentarios Javadoc para explicar parámetros y retorno
    /**
     * genera una clave privada AES de 256 bits.
     * @return byte[] Mensaje cifrado
     */
    public static SecretKey generaAESClave() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamaño de clave de 256 bits
        return keyGenerator.generateKey();
    }
    // Métodos para cifrar y descifrar utilizando AES
    // Comentarios Javadoc para explicar parámetros y retorno
    /**
     * Cifra un mensaje utilizando una clave AES.
     * @param clave Clave AES
     * @param mensaje Mensaje a cifrar
     * @return byte[] Mensaje cifrado
     */
    public static byte[] crifrarAES(SecretKey clave, byte[] mensaje) throws Exception{
        // Implementación para cifrar con AES
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        return cipher.doFinal(mensaje);
    }

    /**
     * Descifra un mensaje utilizando una clave AES.
     * @param clave Clave AES
     * @param mensajeEncriptado Mensaje cifrado
     * @return byte[] Mensaje descifrado
     */
    public static byte[] descifrarAES(SecretKey clave, byte[] mensajeEncriptado) throws Exception{
        // Implementación para descifrar con AES
        Cipher cifrar = Cipher.getInstance("AES");
        cifrar.init(Cipher.DECRYPT_MODE, clave);
        return cifrar.doFinal(mensajeEncriptado);
    }
}
