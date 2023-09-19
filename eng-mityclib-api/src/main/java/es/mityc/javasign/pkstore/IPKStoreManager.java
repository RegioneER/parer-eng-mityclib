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

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * <p>
 * Interfaz para la manipulacion de claves públicas/privadas y certificados en un ambiente de firma digital.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */

public interface IPKStoreManager {

    /**
     * <p>
     * Provider que permite el acceso a funciones criptograficas relacionadas con los certificados (PK) disponibles en
     * el almacén.
     * </p>
     * 
     * @param cert
     *            Certificado para el que se necesita acceso al provider
     * 
     * @return Provider que define sus servicios
     */
    Provider getProvider(X509Certificate cert);

    /**
     * <p>
     * Obtiene un listado de los certificados del almacén que pueden realizar labores de firma.
     * </p>
     * 
     * @return los certificados como un listado de X509Certificate
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén
     */
    List<X509Certificate> getSignCertificates() throws CertStoreException;

    /**
     * <p>
     * Obtiene un listado de los certificados de las entidades de confianza disponibles en el almacén.
     * </p>
     * 
     * @return los certificados como un listado de X509Certificate
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén
     */
    List<X509Certificate> getTrustCertificates() throws CertStoreException;

    /**
     * <p>
     * Obtiene la cadena de certificados asociada al certificado indicado.
     * </p>
     * 
     * @param certificate
     *            Certificado del que se quiere la cadena
     * 
     * @return CertPath construido con los certificados del almacén
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén de certificados o el almacén no contiene el certificado
     *             indicado
     */
    CertPath getCertPath(X509Certificate certificate) throws CertStoreException;

    /**
     * <p>
     * Devuelve la clave privada que tiene el almacén asociado al certificado indicado.
     * </p>
     * 
     * @param certificate
     *            Certificado del que se quiere la clave privada
     * 
     * @return PrivateKey relacionada con el certificado (puede ser una clase proxy)
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén de certificados o no hay clave privada asociada
     */
    PrivateKey getPrivateKey(X509Certificate certificate) throws CertStoreException;
}
