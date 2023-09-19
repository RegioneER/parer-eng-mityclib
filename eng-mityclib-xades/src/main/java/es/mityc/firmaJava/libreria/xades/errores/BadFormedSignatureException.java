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

package es.mityc.firmaJava.libreria.xades.errores;

/**
 * Excepcion en la implementacion de un esquema XAdES
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class BadFormedSignatureException extends XMLError {
    /**
     * Crea una nueva instancia de XMLError sin el detalle mensaje
     */
    public BadFormedSignatureException() {
    }

    /**
     * Crea una instancia de BadFormedSignatureException con el detalle de mensaje especificado
     * 
     * @param msg
     *            El detalle mensaje
     */
    public BadFormedSignatureException(String msg) {
        super(msg);
    }

    public BadFormedSignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadFormedSignatureException(Throwable cause) {
        super(cause);
    }
}
