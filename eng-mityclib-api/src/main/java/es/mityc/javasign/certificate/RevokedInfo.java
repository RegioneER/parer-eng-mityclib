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
 * Almacena informacion sobre el estado de revocacion de un certificado.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class RevokedInfo {

    /** Motivo de revocacion. */
    private Object revokedReason;
    /** Fecha de revocacion. */
    private Date revokedDate;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param reason
     *            Motivo de la revocacion
     * @param date
     *            Fecha de la revocacion
     */
    public RevokedInfo(Object reason, Date date) {
        this.revokedReason = reason;
        this.revokedDate = date;
    }

    /**
     * <p>
     * Devuelve el motivo de revocacion.
     * </p>
     * 
     * @return Object que indica el motivo de revocacion
     */
    public Object getRevokedReason() {
        return revokedReason;
    }

    /**
     * <p>
     * Devuelve la fecha de revocacion.
     * </p>
     * 
     * @return fecha de revocacion
     */
    public Date getRevokedDate() {
        return revokedDate;
    }

    /**
     * <p>
     * Clona el objeto y la fecha, pero no el motivo de revocacion.
     * </p>
     * 
     * @return clonado del objeto
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {
        Date date = (revokedDate != null) ? (Date) revokedDate.clone() : null;
        return new RevokedInfo(revokedReason, date);
    }

}
