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

import java.util.Date;

/**
 * <p>
 * Interfaz que han de cumplir los objetos que recojan informacion de estado de un certificado en forma OCSP.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface IOCSPCertStatus extends ICertStatus {

    /** Posibles tipos de identificacion del OCSP Responder. */
    enum TYPE_RESPONDER {
        /** Por nombre: la cadena que identifica al OCSP responder mediante un nombre X500. */
        BY_NAME,
        /** Por clave: una cadena en base64 de la clave pública del OCSP responder. */
        BY_KEY
    }

    /**
     * <p>
     * Devuelve una cadena que identifica al OCSP Responder que genera la respuesta.
     * </p>
     * 
     * @return Cadena que identifica al OCSP Responder
     */
    String getResponderID();

    /**
     * <p>
     * Devuelve el tipo de OCSP responder que ha generado la respuesta.
     * </p>
     * 
     * @return Tipo de OCSP responder
     */
    TYPE_RESPONDER getResponderType();

    /**
     * <p>
     * Devuelve la fecha de la respuesta.
     * </p>
     * 
     * @return fecha de generacion de la respuesta
     */
    Date getResponseDate();

}
