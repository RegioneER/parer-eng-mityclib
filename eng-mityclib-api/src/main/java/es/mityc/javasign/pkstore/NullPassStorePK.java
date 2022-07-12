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
 * PassHandler que no da acceso a ninguna contraseña.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.1
 */
public class NullPassStorePK implements IPassStoreKS {
    /**
     * <p>
     * Devuelve una contraseña vacía en cualquier consulta.
     * </p>
     * 
     * @param certificate
     *            Certificado al que se accede
     * @param alias
     *            alias al que se accede
     * 
     * @return Contraseña vacía
     * 
     * @see es.mityc.javasign.pkstore.IPassStoreKS#getPassword(java.security.cert.X509Certificate, java.lang.String)
     */
    public char[] getPassword(final X509Certificate certificate, final String alias) {
        return new char[0];
    }
}
