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
 * Interfaz que han de cumplir los gestionadores de las conexiones SSL del cliente.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ISSLManager {

    /**
     * <p>
     * Devuelve el gestionador de confianza del otro peer de la conexion.
     * </p>
     * 
     * @return gestor de confianza
     */
    TrustManager getTrustManager();

    /**
     * <p>
     * Devuelve el gestionador de la autenticacion por parte de este peer de la conexion.
     * </p>
     * 
     * @return gestionador de las claves
     */
    KeyManager getKeyManager();

    /**
     * <p>
     * Devuelve el gestionador ante errores en el establecimiento del SSL.
     * </p>
     * 
     * @return gestionador de errores, <code>null</code> si no se desea ninguno
     */
    ISSLErrorManager getSSLErrorManager();

}
