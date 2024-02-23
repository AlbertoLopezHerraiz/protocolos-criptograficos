import protocolos.*;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Generar un par de claves RSA
        KeyPair parClaves = RSAEncriptacion.generaRSAParClaves();
        // Generar una clave secreta AES
        SecretKey claveSecreta = AESEncriptacion.generaAESClave();

        // Mensaje a cifrar
        String mensaje = "Hola, ¡este es un mensaje secreto!";

        try {
            //RSA
            // Cifrar el mensaje utilizando la clave pública RSA
            byte[] encryptedMessageRSA =
                    RSAEncriptacion.cifrarRSA(parClaves.getPublic(), mensaje.getBytes());
            // Imprimir el mensaje cifrado
            System.out.println("Mensaje cifrado por RSA: " + new String(encryptedMessageRSA));

            // Descifrar el mensaje utilizando la clave privada RSA
            byte[] decryptedMessageRSA =
                    RSAEncriptacion.descrifrarRSA(parClaves.getPrivate(), encryptedMessageRSA);
            // Imprimir el mensaje descifrado
            System.out.println("Mensaje descifrado por RSA: " + new String(decryptedMessageRSA));

            //AES
            // Cifrar el mensaje utilizando la clave AES
            byte[] encryptedMessageAES =
                    AESEncriptacion.crifrarAES(claveSecreta, mensaje.getBytes());
            // Imprimir el mensaje cifrado
            System.out.println("Mensaje cifrado por AES: " + new String(encryptedMessageAES));
            // Descifrar el mensaje utilizando la clave AES
            byte[] decryptedMessageAES =
                    AESEncriptacion.descifrarAES(claveSecreta, encryptedMessageAES);

            // Imprimir el mensaje descifrado
            System.out.println("Mensaje descifrado por AES: " + new String(decryptedMessageAES));

            //Firma digital
            // Generar una firma digital para el mensaje
            byte[] signature =
                    FirmaDigital.generaFirma(parClaves.getPrivate(), mensaje.getBytes());
            // Imprimir la firma digital
            System.out.println("Firma digital: " + new String(signature));
            // Verificar la firma digital
            boolean isSignatureValid =
                    FirmaDigital.verificaFirma(parClaves.getPublic(), mensaje.getBytes(), signature);

            // Imprimir el resultado de la verificación
            System.out.println("La firma digital es válida: " + isSignatureValid);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }
}