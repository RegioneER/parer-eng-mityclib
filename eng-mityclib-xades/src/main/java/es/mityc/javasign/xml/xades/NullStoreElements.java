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

package es.mityc.javasign.xml.xades;

import java.security.cert.X509Certificate;
import java.util.Map;

import es.mityc.javasign.certificate.ElementNotFoundException;
import es.mityc.javasign.certificate.ICertStatus;
import es.mityc.javasign.certificate.IRecoverElements;
import es.mityc.javasign.certificate.UnknownElementClassException;

/**
 * Con esta clase se indica que no se debe intentar recuperar ni guardar ninguno de los elementos relacionados con los
 * certificados de una firma.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class NullStoreElements implements IStoreElements, IRecoverElements {

    public static final NullStoreElements instance = new NullStoreElements();

    public NullStoreElements() {
    }

    /**
     * @see es.mityc.javasign.xml.xades.IStoreElements#init(java.lang.String)
     */
    public void init(String baseURI) {
    }

    /**
     * @see es.mityc.javasign.xml.xades.IStoreElements#storeCertAndStatus(java.security.cert.X509Certificate,
     *      es.mityc.firmaJava.certificates.status.ICertStatusElement)
     */
    public String[] storeCertAndStatus(X509Certificate certificate, ICertStatus certStatus) {
        return new String[0];
    }

    /**
     * @see es.mityc.javasign.certificate.IRecoverElements#getElement(java.util.Map, java.lang.Class)
     */
    public <T> T getElement(Map<String, Object> props, Class<T> elementClass)
            throws ElementNotFoundException, UnknownElementClassException {
        return null;
    }

}
