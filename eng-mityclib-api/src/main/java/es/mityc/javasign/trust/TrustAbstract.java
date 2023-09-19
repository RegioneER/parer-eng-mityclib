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
