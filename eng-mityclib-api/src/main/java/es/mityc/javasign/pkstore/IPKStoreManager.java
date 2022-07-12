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
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA o consulte
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright 2008 Ministerio de Industria, Turismo y Comercio
 * 
 */
package es.mityc.javasign.pkstore;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * <p>
 * Interfaz para la manipulacion de claves públicas/privadas y certificados en un ambiente de firma digital.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */

public interface IPKStoreManager {

    /**
     * <p>
     * Provider que permite el acceso a funciones criptograficas relacionadas con los certificados (PK) disponibles en
     * el almacén.
     * </p>
     * 
     * @param cert
     *            Certificado para el que se necesita acceso al provider
     * 
     * @return Provider que define sus servicios
     */
    Provider getProvider(X509Certificate cert);

    /**
     * <p>
     * Obtiene un listado de los certificados del almacén que pueden realizar labores de firma.
     * </p>
     * 
     * @return los certificados como un listado de X509Certificate
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén
     */
    List<X509Certificate> getSignCertificates() throws CertStoreException;

    /**
     * <p>
     * Obtiene un listado de los certificados de las entidades de confianza disponibles en el almacén.
     * </p>
     * 
     * @return los certificados como un listado de X509Certificate
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén
     */
    List<X509Certificate> getTrustCertificates() throws CertStoreException;

    /**
     * <p>
     * Obtiene la cadena de certificados asociada al certificado indicado.
     * </p>
     * 
     * @param certificate
     *            Certificado del que se quiere la cadena
     * 
     * @return CertPath construido con los certificados del almacén
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén de certificados o el almacén no contiene el certificado
     *             indicado
     */
    CertPath getCertPath(X509Certificate certificate) throws CertStoreException;

    /**
     * <p>
     * Devuelve la clave privada que tiene el almacén asociado al certificado indicado.
     * </p>
     * 
     * @param certificate
     *            Certificado del que se quiere la clave privada
     * 
     * @return PrivateKey relacionada con el certificado (puede ser una clase proxy)
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén de certificados o no hay clave privada asociada
     */
    PrivateKey getPrivateKey(X509Certificate certificate) throws CertStoreException;
}
