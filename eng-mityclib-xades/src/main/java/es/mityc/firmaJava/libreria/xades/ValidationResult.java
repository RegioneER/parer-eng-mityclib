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

package es.mityc.firmaJava.libreria.xades;

import java.util.ArrayList;
import java.util.Iterator;

import es.mityc.firmaJava.libreria.ConstantesXADES;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */
public class ValidationResult {

    private boolean validado;
    private ArrayList log;

    /**
     * Crea una nueva instancia de ValidationResult()
     */
    public ValidationResult() {
        this.validado = false;
        this.log = new ArrayList<String>();
    }

    /**
     * Obtener el valor de log
     * 
     * @return
     */
    public ArrayList getLog() {
        return log;
    }

    /**
     * Establece el valor de log
     * 
     * @param log
     */
    public void setLog(ArrayList log) {
        this.log = log;
    }

    /**
     * Obtener el valor de validado
     * 
     * @return
     */
    public boolean isValidate() {
        return validado;
    }

    /**
     * Devuelve el valor de validado
     * 
     * @param validado
     */
    public void setValidate(boolean validado) {
        this.validado = validado;
    }

    /**
     * Este metodo añade un nuevo log a la lista
     */
    public void addLog(String log) {
        this.log.add(log);
    }

    /**
     * Esta clase devuelve todos los logs insertados
     * 
     * @return
     */
    public String writeLog() {
        StringBuffer log = new StringBuffer();
        for (Iterator<String> it = this.log.iterator(); it.hasNext();) {
            String _log = it.next();
            log.append(_log);
            log.append(ConstantesXADES.NUEVA_LINEA);
        }
        return log.toString();
    }

}
