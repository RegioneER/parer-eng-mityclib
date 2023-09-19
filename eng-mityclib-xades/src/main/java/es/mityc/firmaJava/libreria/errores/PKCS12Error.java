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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class PKCS12Error extends Exception {

    static Log log = LogFactory.getLog(PKCS12Error.class);

    /**
     * Crea una nueva instancia de un error PKCS12
     * 
     * @param causa
     *            causa del error
     */
    public PKCS12Error(String causa) {
        super(causa);
        log.error(causa);
    }

    /**
     * Crea una nueva instancia de un error PKCS12
     * 
     * @param e
     *            excepcion
     */
    public PKCS12Error(Exception e) {
        log.error(e.getMessage());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
