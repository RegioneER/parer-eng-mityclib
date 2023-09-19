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

import es.mityc.javasign.certificate.ICertStatus;

/**
 * Interfaz que ha de implementar la clase que gestione el almacenamiento de elementos de una firma XAdES externos a la
 * firma (certificados, respuestas OCSP y CRLs) para los casos de firmas con elementos externos (XAdES-C y XAdES-X).
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IStoreElements {

    /**
     * Inicializa el almacenador de elementos indicandole cual es la URI base de la firma
     * 
     * @param baseURI
     */
    public void init(String baseURI);

    /**
     * Indica cual es el certificado y el status del certificado que hay que almacenar. Se espera de vuelta el nombre
     * que se le ha asignado a los dos elementos para referenciarlos en la firma XAdES.
     * 
     * @param certificate
     * @param certStatus
     * 
     * @return
     *         <ul>
     *         <li>String[0]: Nombre del elemento certificado</li>
     *         <li>String[1]: Nombre del elemento estado del certificado</li>
     *         </ul>
     */
    public String[] storeCertAndStatus(X509Certificate certificate, ICertStatus certStatus);

}
