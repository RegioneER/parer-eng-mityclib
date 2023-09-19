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

package es.mityc.javasign.bridge;

import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Document;

/**
 * <p>
 * Fachada de servicios relacionados con firma electronica que ha de implementar el sistema de firma electronica
 * utilizado.
 * </p>
 * 
 * <p>
 * Estos servicios son:
 * <ul>
 * <li>Acceso a almacén de certificados</li>
 * <li>Validacion de certificado</li>
 * <li>Firma electronica</li>
 * <li>Validacion de firma electronica</li>
 * </ul>
 * 
 * <p>
 * La clase que implemente el interfaz debera tener disponible un constructor sin parametros para ser instanciado por la
 * factoría.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ISignFacade {

    /**
     * <p>
     * Inicializa el facade con propiedades de comportamiento que pueden ser requeridas para su correcto funcionamiento.
     * </p>
     * 
     * @param props
     *            Conjunto de propiedades necesarias para que el facade puede inicializarse
     * 
     * @throws ConfigurationException
     *             lanzada cuando falta algún parametro de configuracion necesario para el facade
     */
    void init(Properties props) throws ConfigurationException;

    /**
     * <p>
     * Consigue la lista de certificados para firmar disponibles en el almacén de certificados.
     * </p>
     * 
     * @return Lista de certificados obtenida
     */
    List<X509Certificate> getSignCertificates();

    /**
     * <p>
     * Comprueba la validez del certificado indicado.
     * </p>
     * 
     * @param cert
     *            Certificado a validar
     * 
     * @throws InvalidCertificateException
     *             lanzada cuando el certificado es invalido, desconocido o se ha tenido alguna dificultad en la
     *             validacion
     */
    void validateCert(X509Certificate cert) throws InvalidCertificateException;

    /**
     * <p>
     * Firma el documento XML indicado utilizando el certificado.
     * </p>
     * 
     * @param cert
     *            Certificado con el que realizar la firma
     * @param doc
     *            documento con el que realizar la firma
     * 
     * @return devuelve el documento con la firma incluida
     * 
     * @throws SigningException
     *             lanzada cuando se produce un error al intentar realizar la firma.
     */
    Document sign(X509Certificate cert, Document doc) throws SigningException;

    /**
     * <p>
     * Valida una firma XML.
     * </p>
     * 
     * @param doc
     *            Documento XML con la firma a validar
     * 
     * @return Mapa con un conjunto de informacion sobre la firma
     * 
     * @throws InvalidSignatureException
     *             lanzada cuando la firma es invalida
     */
    Map<String, Object> validate(Document doc) throws InvalidSignatureException;

}
