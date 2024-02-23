package protocolos;

import javax.crypto.Cipher;
import java.security.*;

public class RSAEncriptacion {
    // Métodos para generar claves RSA, cifrar y descifrar
    // Comentarios Javadoc para explicar parámetros y retorno
    /**
     * Genera un par de claves RSA pública y privada.
     * @return KeyPair Par de claves RSA
     */
    public static KeyPair generaRSAParClaves() throws NoSuchAlgorithmException {
        // Implementación para generar claves RSA
        KeyPairGenerator generadorParClaves = KeyPairGenerator.getInstance("RSA");
        generadorParClaves.initialize(2048);
        return generadorParClaves.generateKeyPair();
    }

    /**
     * Cifra un mensaje utilizando una clave pública RSA.
     * @param clavePublica Clave pública RSA
     * @param mensaje Mensaje a cifrar
     * @return byte[] Mensaje cifrado
     */
    public static byte[] cifrarRSA(PublicKey clavePublica, byte[] mensaje) throws Exception {
        // Implementación para cifrar con RSA
        Cipher cifrar = Cipher.getInstance("RSA");
        cifrar.init(Cipher.ENCRYPT_MODE, clavePublica);
        return cifrar.doFinal(mensaje);
    }

    /**
     * Descifra un mensaje utilizando una clave privada RSA.
     * @param clavePrivada Clave privada RSA
     * @param mensajeEncriptado Mensaje cifrado
     * @return byte[] Mensaje descifrado
     */
    public static byte[] descrifrarRSA(PrivateKey clavePrivada, byte[] mensajeEncriptado) throws Exception{
        // Implementación para descifrar con RSA
        Cipher cifrar = Cipher.getInstance("RSA");
        cifrar.init(Cipher.DECRYPT_MODE, clavePrivada);
        return cifrar.doFinal(mensajeEncriptado);
    }
}
