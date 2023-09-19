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

package es.mityc.firmaJava.ts;

/**
 * <p>
 * Clase encargada de gestionar los errores producidos en TSCliente.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TSClienteError extends Exception {

    /**
     * <p>
     * Crea una nueva instancia de TSClienteError.
     * <p>
     */
    public TSClienteError() {
        super();
    }

    /**
     * <p>
     * Crea una nueva instancia de TSClienteError.
     * </p>
     * 
     * @param mensaje
     *            Valor del mensaje
     */
    public TSClienteError(String mensaje) {
        super(mensaje);
    }

    /**
     * <p>
     * Crea una nueva instancia de TSClienteError.
     * </p>
     * 
     * @param causa
     *            Excepcion original
     */
    public TSClienteError(Throwable causa) {
        super(causa);
    }

    /**
     * <p>
     * Crea una nueva instancia de TSClienteError.
     * </p>
     * 
     * @param mensaje
     *            Valor del mensaje
     * @param causa
     *            Excepcion original
     */
    public TSClienteError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    /**
     * <p>
     * Devuelve una descripcion corta de la excepcion.
     * </p>
     * 
     * @return "Nombre de la clase":"Mensaje de la excepcion"
     */
    public String toString() {
        return super.toString();
    }
}
