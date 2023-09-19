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

package es.mityc.javasign.certificate;

import java.security.cert.X509Certificate;
import java.util.List;

/**
 * <p>
 * Interfaz que deben implementar los recuperadores de estado de los certificados.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ICertStatusRecoverer {

    /**
     * <p>
     * Recupera el estado del certificado indicado.
     * </p>
     * 
     * @param cert
     *            Certificado que se consulta
     * 
     * @return Estado del certificado
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado del certificado
     */
    ICertStatus getCertStatus(X509Certificate cert) throws CertStatusException;

    /**
     * <p>
     * Recupera el estado de un conjunto de certificados.
     * </p>
     * 
     * @param certs
     *            Certificados que se consultan
     * 
     * @return Listado con el estado de cada uno de los certificados
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado de algún certificado
     */
    List<ICertStatus> getCertStatus(List<X509Certificate> certs) throws CertStatusException;

    /**
     * <p>
     * Recupera el estado de la cadena de certificacion del certificado indicado.
     * </p>
     * 
     * @param cert
     *            Certificado que se consulta
     * 
     * @return Lista de estados de la cadena de certificacion del certificado consultado. El primer elemento de la lista
     *         sera el estado del propio certificado.
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado del certificado
     */
    List<ICertStatus> getCertChainStatus(X509Certificate cert) throws CertStatusException;

    /**
     * <p>
     * Recupera el estado de la cadena de certificacion del conjunto de certificados indicados.
     * </p>
     * 
     * @param certs
     *            Certificados que se consultan
     * 
     * @return Listado con la lista de estados de la cadena de certificacion de cada uno de los certificados
     *         consultados. En cada lista el primer elemento sera el estado del propio certificado consultado
     * 
     * @throws CertStatusException
     *             Lanzada cuando no se puede recuperar el estado de algún certificado
     */
    List<List<ICertStatus>> getCertChainStatus(List<X509Certificate> certs) throws CertStatusException;

}
