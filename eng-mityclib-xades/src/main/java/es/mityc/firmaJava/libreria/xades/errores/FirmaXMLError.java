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
 * Excepciones en la firma o validacion del XML
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class FirmaXMLError extends Exception {

    /**
     * Crea una nueva instancia de FirmaXMLError sin el mensaje de detalle.
     */
    public FirmaXMLError() {
    }

    /**
     * Crea una nueva instancia de FirmaXMLError con el mensaje de detalle.
     * 
     * @param msg
     *            El mensaje de detalle.
     */
    public FirmaXMLError(String msg) {
        super(msg);
    }

    /**
     * Crea una nueva instancia de FirmaXMLError con la Excepcion especificada.
     * 
     * @param e
     *            Exception
     */
    public FirmaXMLError(Exception e) {
        super(e);
    }

    /**
     * @param message
     * @param cause
     */
    public FirmaXMLError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public FirmaXMLError(Throwable cause) {
        super(cause);
    }

}
