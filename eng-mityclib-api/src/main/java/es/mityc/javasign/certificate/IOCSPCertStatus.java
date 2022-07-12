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

import java.util.Date;

/**
 * <p>
 * Interfaz que han de cumplir los objetos que recojan informacion de estado de un certificado en forma OCSP.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IOCSPCertStatus extends ICertStatus {

    /** Posibles tipos de identificacion del OCSP Responder. */
    enum TYPE_RESPONDER {
        /** Por nombre: la cadena que identifica al OCSP responder mediante un nombre X500. */
        BY_NAME,
        /** Por clave: una cadena en base64 de la clave pública del OCSP responder. */
        BY_KEY
    }

    /**
     * <p>
     * Devuelve una cadena que identifica al OCSP Responder que genera la respuesta.
     * </p>
     * 
     * @return Cadena que identifica al OCSP Responder
     */
    String getResponderID();

    /**
     * <p>
     * Devuelve el tipo de OCSP responder que ha generado la respuesta.
     * </p>
     * 
     * @return Tipo de OCSP responder
     */
    TYPE_RESPONDER getResponderType();

    /**
     * <p>
     * Devuelve la fecha de la respuesta.
     * </p>
     * 
     * @return fecha de generacion de la respuesta
     */
    Date getResponseDate();

}
