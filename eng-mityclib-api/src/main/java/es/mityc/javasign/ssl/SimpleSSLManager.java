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

package es.mityc.javasign.ssl;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/**
 * <p>
 * Gestion de la pasarela SSL de comunicacion del cliente TS.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SimpleSSLManager implements ISSLManager {

    /** Gestionador de la confianza para el otro punto de conexion. */
    private TrustManager truster;
    /** Gestionador de las claves para la autenticacion de este punto. */
    private KeyManager keyer;
    /** Gestionador de los errores del establecimiento de la sesion SSL. */
    private ISSLErrorManager errorManager;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param trustManager
     *            gestionador de la confianza
     * @param keyManager
     *            gestionador de la autenticacion
     */
    public SimpleSSLManager(TrustManager trustManager, KeyManager keyManager) {
        this.truster = trustManager;
        this.keyer = keyManager;
    }

    /**
     * <p>
     * Establece el gestionador de errores en las comunicaciones SSL.
     * </p>
     * 
     * @param errorMng
     *            Manager de errores
     */
    public void setSSLErrorManager(final ISSLErrorManager errorMng) {
        this.errorManager = errorMng;
    }

    /**
     * <p>
     * Devuelve el manager de errores establecido.
     * </p>
     * 
     * @return manager de errores
     * 
     * @see es.mityc.javasign.ssl.ISSLManager#getSSLErrorManager()
     */
    public ISSLErrorManager getSSLErrorManager() {
        return errorManager;
    }

    /**
     * <p>
     * Devuelve el gestionador de autenticacion de este punto.
     * </p>
     * 
     * @return gestionador de autenticacion
     * 
     * @see es.mityc.javasign.ssl.ISSLManager#getKeyManager()
     */
    public KeyManager getKeyManager() {
        return keyer;
    }

    /**
     * <p>
     * Devuelve el gestionador de confianza del otro punto.
     * </p>
     * 
     * @return gestionador de confianza
     * 
     * @see es.mityc.javasign.ssl.ISSLManager#getTrustManager()
     */
    public TrustManager getTrustManager() {
        return truster;
    }

}
