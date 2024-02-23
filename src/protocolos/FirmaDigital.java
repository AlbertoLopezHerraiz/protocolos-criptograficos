package protocolos;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class FirmaDigital {
    // Métodos para generar y verificar firmas digitales
    // Comentarios Javadoc para explicar parámetros y retorno
    /**
     * Genera una firma digital para un mensaje utilizando una clave privada RSA.
     * @param clavePrivada Clave privada RSA
     * @param mensaje Mensaje a firmar
     * @return byte[] Firma digital
     */
    public static byte[] generaFirma(PrivateKey clavePrivada, byte[] mensaje) throws Exception{
        // Implementación para generar firma digital
        Signature firma = Signature.getInstance("SHA256withRSA");
        firma.initSign(clavePrivada);
        firma.update(mensaje);
        return firma.sign();
    }

    /**
     * Verifica una firma digital utilizando una clave pública RSA.
     * @param clavePublica Clave pública RSA
     * @param mensaje Mensaje original
     * @param firma Firma digital a verificar
     * @return boolean Verdadero si la firma es válida, falso en caso contrario
     */
    public static boolean verificaFirma(PublicKey clavePublica, byte[] mensaje, byte[] firma) throws Exception {
        // Implementación para verificar firma digital
        Signature verificar = Signature.getInstance("SHA256withRSA");
        verificar.initVerify(clavePublica);
        verificar.update(mensaje);
        return verificar.verify(firma);

    }
}
