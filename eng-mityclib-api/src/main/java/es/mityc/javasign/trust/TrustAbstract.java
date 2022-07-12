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
package es.mityc.javasign.trust;

import java.security.cert.CertPath;
import java.security.cert.X509Certificate;

/**
 * <p>
 * Clase base para las clases encargadas de realizar labores de confianza.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public abstract class TrustAbstract {

    /**
     * Devuelve una instancia del validador.
     * 
     * Este método tiene que ser sobreescrito por la clase que extienda el validador.
     * 
     * @return Instancia del validador
     */
    public static TrustAbstract getInstance() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Indica si el objeto indicado es catalogado como de confianza.
     * </p>
     * 
     * @param data
     *            Objeto del que comprobar su confianza
     * 
     * @throws TrustException
     *             lanzada cuando el objeto no es de confianza o ha ocurrido algún error al intentar comprobarlo:
     *             <ul>
     *             <li>{@link UnknownTrustException} lanzada cuando se desconoce si el objeto es o no de confianza (el
     *             objeto es desconocido o no se puede comprobar su confianza).</li>
     *             <li>{@link NotTrustedException} lanzada cuando el objeto no es de confianza.</li>
     *             </ul>
     */
    public abstract void isTrusted(final Object data) throws TrustException;

    /**
     * <p>
     * Devuelve la cadena de certificados correspondiente al certificado parametrizado.
     * </p>
     * 
     * @param cert
     *            Certificado del cual se va a reconstruir su cadena
     * 
     * @return Cadena de certificados correspondiente
     * 
     * @throws UnknownTrustException
     *             Si no se dispone de la ruta de certificacion
     */
    public abstract CertPath getCertPath(X509Certificate cert) throws UnknownTrustException;

}
