/**
 * LICENCIA LGPL:
 * 
 * Esta librería es Software Libre; Usted puede redistribuirlo y/o modificarlo
 * bajo los términos de la GNU Lesser General Public License (LGPL)
 * tal y como ha sido publicada por la Free Software Foundation; o
 * bien la version 2.1 de la Licencia, o (a su eleccion) cualquier version posterior.
 * 
 * Esta librería se distribuye con la esperanza de que sea útil, pero SIN NINGUNA
 * GARANTÍA; tampoco las implícitas garantías de MERCANTILIDAD o ADECUACIoN A UN
 * PROPoSITO PARTICULAR. Consulte la GNU Lesser General Public License (LGPL) para mas
 * detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL)
 * junto con esta librería; si no es así, escriba a la Free Software Foundation Inc.
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA.
 * 
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
