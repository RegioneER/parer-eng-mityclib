/**
 * LICENCIA LGPL:
 * 
 * Esta librerÃ­a es Software Libre; Usted puede redistribuirlo y/o modificarlo
 * bajo los tÃ©rminos de la GNU Lesser General Public License (LGPL)
 * tal y como ha sido publicada por la Free Software Foundation; o
 * bien la versiÃ³n 2.1 de la Licencia, o (a su elecciÃ³n) cualquier versiÃ³n posterior.
 * 
 * Esta librerÃ­a se distribuye con la esperanza de que sea Ãºtil, pero SIN NINGUNA
 * GARANTÃ�A; tampoco las implÃ­citas garantÃ­as de MERCANTILIDAD o ADECUACIÃ“N A UN
 * PROPÃ“SITO PARTICULAR. Consulte la GNU Lesser General Public License (LGPL) para mÃ¡s
 * detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL)
 * junto con esta librerÃ­a; si no es asÃ­, escriba a la Free Software Foundation Inc.
 * 51 Franklin Street, 5Âº Piso, Boston, MA 02110-1301, USA o consulte
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright 2008 Ministerio de Industria, Turismo y Comercio
 * 
 */
package es.mityc.firmaJava.ts;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.Authenticator.RequestorType;

import org.apache.commons.httpclient.NTCredentials;

/**
 * <p>
 * Credenciales de autenticaciÃ³n para conectar el sistema de autenticaciÃ³n de Java con el sistema de credenciales de
 * la librerÃ­a httpclient.
 * </p>
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class AuthenticatorProxyCredentials extends NTCredentials {

    protected PasswordAuthentication pa = null;

    public AuthenticatorProxyCredentials(String host, String domain) {
        super("username", "password", host, domain);
    }

    private void refreshAuthenticator() {
        String proxyHost = System.getProperty("http.proxyHost");
        int proxyPort = 80;
        try {
            proxyPort = Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException ex) {
        }
        try {
            pa = Authenticator.requestPasswordAuthentication(proxyHost, null, proxyPort, "HTTP", "", "http", null,
                    RequestorType.PROXY);
        } catch (SecurityException ex) {
            pa = null;
        }
    }

    @Override
    public String getUserName() {
        refreshAuthenticator();
        if (pa == null)
            return super.getUserName();
        return pa.getUserName();
    }

    @Override
    public String getPassword() {
        if (pa == null)
            refreshAuthenticator();
        if (pa == null)
            return super.getPassword();
        return new String(pa.getPassword());
    }

}
