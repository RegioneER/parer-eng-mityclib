/**
 * LICENCIA LGPL:
 * 
 * Esta librería es Software Libre; Usted puede redistribuirlo y/o modificarlo
 * bajo los términos de la GNU Lesser General Public License (LGPL)
 * tal y como ha sido publicada por la Free Software Foundation; o
 * bien la version 2.1 de la Licencia, o (a su eleccion) cualquier version posterior.
 * 
 * Esta librería se distribuye con la esperanza de que sea útil, pero SIN NINGUNA
 * GARANTÍA; tampoco las implícitas garantías de MERCANTILIDAD o ADECUACIoN A UN
 * PROPoSITO PARTICULAR. Consulte la GNU Lesser General Public License (LGPL) para mas
 * detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL)
 * junto con esta librería; si no es así, escriba a la Free Software Foundation Inc.
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA.
 * 
 */
package es.mityc.javasign.certificate;

import java.security.cert.X509Certificate;

/**
 * <p>
 * Interfaz que han de implementar las respuestas de los validadores de certificados.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ICertStatus {

    /** Posibles estados de los certificados. */
    enum CERT_STATUS {
        /** Desconocido: no se conoce el estado del certificado. */
        unknown,
        /** Valido: el estado del certificado es valido. */
        valid,
        /** Revocado: el certificado se encuentra revocado. */
        revoked;
    }

    /**
     * <p>
     * Devuelve el estado del certificado consultado.
     * </p>
     * 
     * @return uno de los estados del enumerado que se ajuste al estado del certificado
     */
    CERT_STATUS getStatus();

    /**
     * <p>
     * Devuelve el certificado sobre el que se realizo la consulta de estado.
     * </p>
     * 
     * @return Certificado consultado
     */
    X509Certificate getCertificate();

    /**
     * <p>
     * Devuelve el estado del certificado en su forma original.
     * </p>
     * 
     * @return array de bytes con la forma original del estado del certificado
     */
    byte[] getEncoded();

    /**
     * <p>
     * Devuelve informacion sobre la revocacion del certificado.
     * </p>
     * 
     * @return Informacion de revocacion del certificado, <code>null</code> si no esta revocado
     */
    RevokedInfo getRevokedInfo();

}
