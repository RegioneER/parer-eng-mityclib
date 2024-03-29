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
import java.security.cert.X509Certificate;

import javax.swing.JPanel;

/**
 * <p>
 * Interfaz para el mantenimiento de un almacén de certificados.
 * </p>
 * <p>
 * Mediante la implementacion de este interfaz se obtiene acceso a la manipulacion de los certificados disponibles en el
 * almacén de certificados.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IPKStoreMaintainer {

    /**
     * <p>
     * Inicializa el acceso al almacén.
     * </p>
     * 
     * @throws CertStoreException
     *             lanzada si hay algún problema en el acceso al almacén
     */
    void init() throws CertStoreException;

    /**
     * <p>
     * Introduce un certificado de confianza en el almacén de certificados.
     * </p>
     * 
     * @param cert
     *            Certificado de confianza
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén
     */
    void addTrustCert(X509Certificate cert) throws CertStoreException;

    /**
     * <p>
     * Borra un certificado del almacén de certificados.
     * </p>
     * <p>
     * Si el certificado que se intenta eliminar no es un certificado de confianza, sino de firma, no se debera
     * eliminar.
     * </p>
     * 
     * @param cert
     *            Certificado de confianza a eliminar
     * 
     * @throws CertStoreException
     *             si hay algún problema en el acceso al almacén
     */
    void removeTrustCert(X509Certificate cert) throws CertStoreException;

    /**
     * <p>
     * Importa un certificado de firma (incluye clave privada) en el almacén.
     * </p>
     * 
     * @param pk
     *            Clave privada a importar
     * @param cert
     *            Certificado asociado a la clave pública relacionada con la clave privada importada
     * @param password
     *            Contraseña que se aplicara a la clave privada en el almacén
     * 
     * @throws CertStoreException
     *             lanzada si hay algún problema en la importacion de la clave privada y certificado
     */
    void importSignCert(PrivateKey pk, X509Certificate cert, char[] password) throws CertStoreException;

    /**
     * <p>
     * Elimina un certificado del almacén de certificados que esté asociado a una clave privada, junto con la clave
     * privada.
     * </p>
     * 
     * @param cert
     *            Certificado asociado a una clave privada a eliminar
     * 
     * @throws CertStoreException
     *             lanzada si hay algún problema en la eliminacion del certificado y de la clave privada
     */
    void removeSignCert(X509Certificate cert) throws CertStoreException;

    /**
     * <p>
     * Actualiza el certificado asociado a una clave privada, reemplazando el anterior asociado.
     * </p>
     * 
     * @param cert
     *            certificado actual
     * 
     * @throws CertStoreException
     *             lanzada si hay algún problema en la actualizacion del certificado
     */
    void updateSignCert(X509Certificate cert) throws CertStoreException;

    /**
     * <p>
     * Indica si un certificado se puede borrar del almacén de certificados.
     * </p>
     * 
     * @param cert
     *            .- Certificado a consultar
     * 
     * @return .- <code>true</code> si el certificado el borrable
     */
    boolean isDeletable(X509Certificate cert);

    /**
     * <p>
     * Devuelve el panel de configuracion propio de la implementacion del almacén.
     * </p>
     * 
     * @return Panel de configuracion del almacén.
     */
    JPanel getPreferencesPanel();
}
