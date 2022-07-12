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
 * Base abstracta con metodología común para las clases que recogen estados de certificados.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class AbstractCertStatus implements ICertStatus {

    /** Estado del certificado. */
    protected CERT_STATUS certStatus = CERT_STATUS.unknown;
    /** Si el certificado esta revocado, informacion sobre la revocacion. */
    protected RevokedInfo revokedInfo = null;
    /** Certificado sobre el que se realiza la consulta. */
    protected X509Certificate certificate = null;

    /**
     * <p>
     * Certificado consultado.
     * </p>
     * 
     * @return X509Certificate consultado
     * 
     * @see es.mityc.javasign.certificate.ICertStatus#getCertificate()
     */
    public X509Certificate getCertificate() {
        return certificate;
    }

    /**
     * <p>
     * Codificacion binaria del estado del certificado.
     * </p>
     * <p>
     * La forma binaria depende de la especificacion del estado de certificado que se implementa.
     * </p>
     * 
     * @return byte[] con el contenido en binario del estado
     * 
     * @see es.mityc.javasign.certificate.ICertStatus#getEncoded()
     */
    public abstract byte[] getEncoded();

    /**
     * <p>
     * Informacion sobre la revocacion del certificado (si el estado es revocado).
     * </p>
     * 
     * @return datos de revocacion, <code>null</code> si no esta revocado
     * 
     * @see es.mityc.javasign.certificate.ICertStatus#getRevokedInfo()
     */
    public RevokedInfo getRevokedInfo() {
        return (revokedInfo != null) ? (RevokedInfo) revokedInfo.clone() : null;
    }

    /**
     * <p>
     * Estado del certificado.
     * </p>
     * 
     * @return estado del certificado según el enumerado {@link es.mityc.javasign.certificate.ICertStatus.CERT_STATUS}
     * 
     * @see es.mityc.javasign.certificate.ICertStatus#getStatus()
     */
    public CERT_STATUS getStatus() {
        return certStatus;
    }

    /**
     * <p>
     * Establece el estado del certificado.
     * </p>
     * 
     * @param status
     *            Estado del certificado según el enumerado
     *            {@link es.mityc.javasign.certificate.ICertStatus.CERT_STATUS}
     */
    protected void setCertStatus(final CERT_STATUS status) {
        this.certStatus = status;
    }

    /**
     * <p>
     * Establece informacion sobre el motivo de revocacion del certificado.
     * </p>
     * 
     * @param ri
     *            Informacion de revocacion
     */
    protected void setRevokedInfo(final RevokedInfo ri) {
        this.revokedInfo = (RevokedInfo) ri.clone();
    }

    /**
     * <p>
     * Establece el certificado sobre el que se realiza la consulta de estado.
     * </p>
     * 
     * @param cert
     *            Certificado consultado
     */
    protected void setCertificate(final X509Certificate cert) {
        this.certificate = cert;
    }

}
