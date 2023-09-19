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

package es.mityc.firmaJava.libreria.errores;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * Excepcion general del lado del cliente
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */
public class ClienteError extends Exception {

    String mensaje = ConstantesXADES.CADENA_VACIA;

    /**
     * Crea una nueva instancia de ClienteError sin el mensaje de detalle
     */
    public ClienteError() {
    }

    /**
     * Crea una nueva instancia de ClienteError con el mensaje de detalle
     * 
     * @param msg
     *            Detalle del mensaje
     */
    public ClienteError(String msg) {
        super(msg);
        this.mensaje = msg;
    }

    /**
     * Crea una nueva instancia de ClienteError
     * 
     * @param msg
     *            Excepcion a propagar
     */
    public ClienteError(Throwable msg) {
        super(msg);
        this.mensaje = msg.getMessage();
    }

    public ClienteError(String msg, Throwable th) {
        super(msg, th);
        this.mensaje = msg;
    }

    /**
     * Este método obtiene el mensaje
     * 
     * @return mensaje Obtiene el mensaje
     */
    public String getMessage() {
        return mensaje;
    }
}
