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

package es.mityc.javasign.exception;

/**
 * <p>
 * Excepcion genérica de las funciones de este framework.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class SignMITyCException extends Exception {

    /** SerialVersionUID. */
    static final long serialVersionUID = 1L;

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public SignMITyCException() {
        super();
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param message
     *            Mensaje de error
     */
    public SignMITyCException(final String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param cause
     *            Causa de la excepcion
     */
    public SignMITyCException(final Throwable cause) {
        super(cause);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param message
     *            Mensaje de error
     * @param cause
     *            Causa de la excepcion
     */
    public SignMITyCException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
