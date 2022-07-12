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
import java.util.List;

/**
 * <p>
 * Interfaz que deben implementar los recuperadores de estado de los certificados.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ICertStatusRecoverer {

    /**
     * <p>
     * Recupera el estado del certificado indicado.
     * </p>
     * 
     * @param cert
     *            Certificado que se consulta
     * 
     * @return Estado del certificado
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado del certificado
     */
    ICertStatus getCertStatus(X509Certificate cert) throws CertStatusException;

    /**
     * <p>
     * Recupera el estado de un conjunto de certificados.
     * </p>
     * 
     * @param certs
     *            Certificados que se consultan
     * 
     * @return Listado con el estado de cada uno de los certificados
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado de algún certificado
     */
    List<ICertStatus> getCertStatus(List<X509Certificate> certs) throws CertStatusException;

    /**
     * <p>
     * Recupera el estado de la cadena de certificacion del certificado indicado.
     * </p>
     * 
     * @param cert
     *            Certificado que se consulta
     * 
     * @return Lista de estados de la cadena de certificacion del certificado consultado. El primer elemento de la lista
     *         sera el estado del propio certificado.
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado del certificado
     */
    List<ICertStatus> getCertChainStatus(X509Certificate cert) throws CertStatusException;

    /**
     * <p>
     * Recupera el estado de la cadena de certificacion del conjunto de certificados indicados.
     * </p>
     * 
     * @param certs
     *            Certificados que se consultan
     * 
     * @return Listado con la lista de estados de la cadena de certificacion de cada uno de los certificados
     *         consultados. En cada lista el primer elemento sera el estado del propio certificado consultado
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado de algún certificado
     */
    List<List<ICertStatus>> getCertChainStatus(List<X509Certificate> certs) throws CertStatusException;

}
