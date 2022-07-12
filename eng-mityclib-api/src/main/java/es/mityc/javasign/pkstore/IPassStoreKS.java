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
package es.mityc.javasign.pkstore;

import java.security.cert.X509Certificate;

/**
 * <p>
 * Interfaz para acceder a las contraseñas pedidas cuando se accede a la clave asociada a un certificado.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IPassStoreKS {

    /**
     * <p>
     * Se llama a este método cuando el {@link IPKStoreManager} intenta acceder a la clave privada asociada a un
     * certificado contenido en el KeyStore.
     * </p>
     * 
     * @param certificate
     *            Certificado que tiene la clave
     * @param alias
     *            Alias del certificado
     * 
     * @return Se debe devolver la contraseña de acceso a la clave
     */
    char[] getPassword(X509Certificate certificate, String alias);

}
