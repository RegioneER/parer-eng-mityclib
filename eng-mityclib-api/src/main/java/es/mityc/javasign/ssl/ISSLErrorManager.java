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

import java.security.cert.X509Certificate;

/**
 * <p>
 * Interfaz para comunicar de errores encontrados en la verificacion de la conexion SSL.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ISSLErrorManager {

    /**
     * <p>
     * Indica que se ha producido un error al comprobar la identidad del servidor.
     * </p>
     * <p>
     * El certificado del servidor y el nombre del host no coinciden.
     * </p>
     * 
     * @param actualHost
     *            Nombre resuelto del peer
     * @param certServer
     *            Certificado obtenido del servidor
     * 
     * @return <code>true</code> si se debe continuar, <code>false</code> si se debe parar el establecimiento del SSL
     */
    boolean continueErrorPeer(String actualHost, X509Certificate certServer);

}
