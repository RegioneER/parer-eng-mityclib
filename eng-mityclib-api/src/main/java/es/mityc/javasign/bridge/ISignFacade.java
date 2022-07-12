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
package es.mityc.javasign.bridge;

import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Document;

/**
 * <p>
 * Fachada de servicios relacionados con firma electronica que ha de implementar el sistema de firma electronica
 * utilizado.
 * </p>
 * 
 * <p>
 * Estos servicios son:
 * <ul>
 * <li>Acceso a almacén de certificados</li>
 * <li>Validacion de certificado</li>
 * <li>Firma electronica</li>
 * <li>Validacion de firma electronica</li>
 * </ul>
 * 
 * <p>
 * La clase que implemente el interfaz debera tener disponible un constructor sin parametros para ser instanciado por la
 * factoría.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ISignFacade {

    /**
     * <p>
     * Inicializa el facade con propiedades de comportamiento que pueden ser requeridas para su correcto funcionamiento.
     * </p>
     * 
     * @param props
     *            Conjunto de propiedades necesarias para que el facade puede inicializarse
     * 
     * @throws ConfigurationException
     *             lanzada cuando falta algún parametro de configuracion necesario para el facade
     */
    void init(Properties props) throws ConfigurationException;

    /**
     * <p>
     * Consigue la lista de certificados para firmar disponibles en el almacén de certificados.
     * </p>
     * 
     * @return Lista de certificados obtenida
     */
    List<X509Certificate> getSignCertificates();

    /**
     * <p>
     * Comprueba la validez del certificado indicado.
     * </p>
     * 
     * @param cert
     *            Certificado a validar
     * 
     * @throws InvalidCertificateException
     *             lanzada cuando el certificado es invalido, desconocido o se ha tenido alguna dificultad en la
     *             validacion
     */
    void validateCert(X509Certificate cert) throws InvalidCertificateException;

    /**
     * <p>
     * Firma el documento XML indicado utilizando el certificado.
     * </p>
     * 
     * @param cert
     *            Certificado con el que realizar la firma
     * @param doc
     *            documento con el que realizar la firma
     * 
     * @return devuelve el documento con la firma incluida
     * 
     * @throws SigningException
     *             lanzada cuando se produce un error al intentar realizar la firma.
     */
    Document sign(X509Certificate cert, Document doc) throws SigningException;

    /**
     * <p>
     * Valida una firma XML.
     * </p>
     * 
     * @param doc
     *            Documento XML con la firma a validar
     * 
     * @return Mapa con un conjunto de informacion sobre la firma
     * 
     * @throws InvalidSignatureException
     *             lanzada cuando la firma es invalida
     */
    Map<String, Object> validate(Document doc) throws InvalidSignatureException;

}
