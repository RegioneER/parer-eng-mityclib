/*
 * Engineering Ingegneria Informatica S.p.A.
 *
 * Copyright (C) 2023 Regione Emilia-Romagna
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
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
