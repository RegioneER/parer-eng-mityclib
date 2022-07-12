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

import java.util.Map;

/**
 * <p>
 * Interfaz que ha de implementar la clase que gestione la recuperacion de elementos relacionados con certificados y sus
 * estados.
 * </p>
 * 
 * <p>
 * Se recomienda que los localizadores respondan a los elementos mas comunes de identificacion de elementos:
 * <ul>
 * <li><code>uri</code>: (String)uri donde se encuentra ubicado el elemento (certificado, crl y ocsp)</li>
 * <li><code>issuer.name</code>: (X500Principal) nombre del issuer emisor del elemento (certificado, crl y ocsp)</li>
 * <li><code>issuer.hash</code>: (byte[]) hash del nombre del issuer emisor del elemento (ocsp)</li>
 * <li><code>serial.number</code>: (BigInteger) número serie del elemento (certificado y crl)</li>
 * <li><code>emission.date</code>: (Date) emision del elemento (crl y ocsp)</li>
 * <li><code>digest.algorithm</code>: (String) nombre del algoritmo de digest aplicado al elemento (crl y ocsp)</li>
 * <li><code>digest.value</code>: (byte[]) valor del digest del elemento (crl y ocsp)</li>
 * </ul>
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IRecoverElements {

    /** Propiedad que indica la uri donde se encuentra disponible el elemento. */
    String PROP_URI = "uri";
    /** Propiedad que indica el nombre del emisor. */
    String PROP_ISSUER_NAME = "issuer.name";
    /** Propiedad que indica el hask de la public key del emisor. */
    String PROP_ISSUER_HASH = "issuer.hash";
    /** Propiedad que indica el número serie del elemento (si lo tiene). */
    String PROP_SERIAL_NUMBER = "serial.number";
    /** Propiedad que indica la fecha de emision del elemento (si la tiene). */
    String PROP_EMISSION_DATE = "emission.date";
    /** Propiedad que indica el algoritmo utilizar para calcular el digest del elemento. */
    String PROP_DIGEST_ALGORITHM = "digest.algorithm";
    /** Propiedad que indica el digest calculado del elemento. */
    String PROP_DIGEST_VALUE = "digest.value";

    /**
     * <p>
     * Recupera un elemento del tipo especificado según los datos indicados.
     * </p>
     * 
     * @param <T>
     *            Tipo de elemento devuelto
     * @param props
     *            Conjunto de propiedades utilizadas para identificar el elemento que se quiere recuperar
     * @param elementClass
     *            Tipo de objeto que se espera como respuesta de la consulta
     * 
     * @return Objeto del tipo indicado si se ha conseguido encontrar el elemento
     * 
     * @throws ElementNotFoundException
     *             lanzada cuando no se encuentra el elemento pedido con los datos provistos
     * @throws UnknownElementClassException
     *             lanzada cuando no se reconoce el tipo de dato que hay que resolver como elemento
     */
    <T> T getElement(Map<String, Object> props, Class<T> elementClass)
            throws ElementNotFoundException, UnknownElementClassException;

}
