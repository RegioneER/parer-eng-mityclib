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

/**
 * <p>
 * Interfaz que han de implementar las respuestas de los validadores de certificados.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface ICertStatus {

    /** Posibles estados de los certificados. */
    enum CERT_STATUS {
        /** Desconocido: no se conoce el estado del certificado. */
        unknown,
        /** Valido: el estado del certificado es valido. */
        valid,
        /** Revocado: el certificado se encuentra revocado. */
        revoked;
    }

    /**
     * <p>
     * Devuelve el estado del certificado consultado.
     * </p>
     * 
     * @return uno de los estados del enumerado que se ajuste al estado del certificado
     */
    CERT_STATUS getStatus();

    /**
     * <p>
     * Devuelve el certificado sobre el que se realizo la consulta de estado.
     * </p>
     * 
     * @return Certificado consultado
     */
    X509Certificate getCertificate();

    /**
     * <p>
     * Devuelve el estado del certificado en su forma original.
     * </p>
     * 
     * @return array de bytes con la forma original del estado del certificado
     */
    byte[] getEncoded();

    /**
     * <p>
     * Devuelve informacion sobre la revocacion del certificado.
     * </p>
     * 
     * @return Informacion de revocacion del certificado, <code>null</code> si no esta revocado
     */
    RevokedInfo getRevokedInfo();

}
