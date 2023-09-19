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
