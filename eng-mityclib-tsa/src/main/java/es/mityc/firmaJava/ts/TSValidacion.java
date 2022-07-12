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
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA o consulte
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright 2008 Ministerio de Industria, Turismo y Comercio
 * 
 */

package es.mityc.firmaJava.ts;

import java.math.BigInteger;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.tsp.GenTimeAccuracy;
import org.bouncycastle.tsp.TimeStampToken;

/**
 * <p>
 * Estructura de datos para la validacion de un sello de tiempo.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class TSValidacion {

    /** Resultado de validacion del sello. */
    private boolean respuesta = false;
    /** fecha del sello de tiempo en formato String. */
    private String fecha = null;
    /** Fecha del sello en formato Date. */
    private Date fechaDate = null;
    /** Emisor del sello. */
    private X500Principal emisor = null;
    /** Precision del sello de tiempo. */
    private GenTimeAccuracy precision = null;
    /** Prexison en formato Long. */
    private long precisionLong = 0;
    /** Valor del sello. */
    private BigInteger sello = null;
    /** Nombre del algoritmo empleado en el sello de tiempo. */
    private String selloAlg = null;
    /** Valor del Digest obtenido. */
    private String firmaDigest = null;
    /** Valor de Digest calculado. */
    private String selloDigest = null;
    /** Token del sello. */
    private TimeStampToken tst = null;

    /**
     * <p>
     * devuelve la fecha extraida del sello de tiempo.
     * </p>
     * 
     * @return Fecha extraía del sello, o <code>null</code> si no existe
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * <p>
     * Almacena la fecha extraida del sello.
     * </p>
     * 
     * @param fecha
     *            Fecha a almacenar
     */
    public void setFecha(final String fecha) {
        this.fecha = fecha;
    }

    /**
     * <p>
     * Devuelve la fecha almacenada en formato Date.
     * </p>
     * 
     * @return Fecha almacenada, o <code>null</code> si no existe
     */
    public Date getFechaDate() {
        return fechaDate;
    }

    /**
     * <p>
     * Almacena la fecha extraída del sello de tiempo en formato Date.
     * </p>
     * 
     * @param fechaDate
     *            Fecha a almacenar
     */
    public void setFechaDate(final Date fechaDate) {
        this.fechaDate = fechaDate;
    }

    /**
     * <p>
     * Devuelve el emisor X500 extraído del sello.
     * </p>
     * 
     * @return Valor almacenado del emisor del sello, o <code>null</code> si no existe
     */
    public X500Principal getEmisor() {
        return emisor;
    }

    /**
     * <p>
     * Almacena el emisor extraído del sello de tiempo.
     * </p>
     * 
     * @param emisor
     *            Emisor X500 del sello de tiempo
     */
    public void setEmisor(final X500Principal emisor) {
        this.emisor = emisor;
    }

    /**
     * <p>
     * Devuelve el valor de digest extraído del sello de tiempo.
     * </p>
     * 
     * @return El valor de digest almacenado, o <code>null</code> si no existe
     */
    public String getFirmaDigest() {
        return firmaDigest;
    }

    /**
     * <p>
     * Almacena el valor de Digest extraído del sello de tiempo.
     * </p>
     * 
     * @param firmaDigest
     *            Valor de Digest extraído
     */
    public void setFirmaDigest(final String firmaDigest) {
        this.firmaDigest = firmaDigest;
    }

    /**
     * <p>
     * Devuelve la precision extraída del sello de tiempo.
     * </p>
     * 
     * @return Precision almacenada, o <code>null</code> si no existe
     */
    public GenTimeAccuracy getPrecision() {
        return precision;
    }

    /**
     * <p>
     * Almacena la precision extraída del sello de tiempo
     * 
     * @param precision
     *            Precision a almacenar
     */
    public void setPrecision(final GenTimeAccuracy precision) {
        this.precision = precision;
    }

    /**
     * <p>
     * Devuelve la precision extraída del sello de tiempo en formato Long.
     * </p>
     * 
     * @return Valor de la precision almacenada, o <code>0</code> si no existe
     */
    public long getPrecisionLong() {
        return precisionLong;
    }

    /**
     * <p>
     * Almacena la precision extraída del sello de tiempo en formato Long.
     * </p>
     * 
     * @param precisionLong
     *            Precision extraida del sello de tiempo
     */
    public void setPrecisionLong(final long precisionLong) {
        this.precisionLong = precisionLong;
    }

    /**
     * <p>
     * Indica si los datos extraídos se corresponden con un sello de tiempo.
     * </p>
     * 
     * @return <code>true</code> si se corresponde
     */
    public boolean isRespuesta() {
        return respuesta;
    }

    /**
     * <p>
     * Establece si la respuesta procesada esta bien formada.
     * </p>
     * 
     * @param respuesta
     *            <code>true</code> si esta bien formada
     */
    public void setRespuesta(final boolean respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * <p>
     * Devuelve el sello de tiempo extraído en formato BigInteger.
     * </p>
     * 
     * @return Valor del sello, o <code>null</code> si no existe
     */
    public BigInteger getSello() {
        return sello;
    }

    /**
     * <p>
     * Almacena el sello de tiempo en formato BigInteger.
     * </p>
     * 
     * @param sello
     *            Sello a almacenar
     */
    public void setSello(final BigInteger sello) {
        this.sello = sello;
    }

    /**
     * <p>
     * Devuelve el nombre del algoritmo empleado en el sello de tiempo.
     * </p>
     * 
     * @return Nombre del algoritmo de Digest, o <code>null</code> si no existe
     */
    public String getSelloAlg() {
        return selloAlg;
    }

    /**
     * <p>
     * Almacena el nombre del algoritmo empleado en el sello de tiempo.
     * </p>
     * 
     * @param selloAlg
     *            Nombre del algoritmo de Digest
     */
    public void setSelloAlg(final String selloAlg) {
        this.selloAlg = selloAlg;
    }

    /**
     * <p>
     * Devuelve el valor de Digest extraído del sello de tiempo.
     * </p>
     * 
     * @return Valor de Digest, o <code>null</code> si no existe
     */
    public String getSelloDigest() {
        return selloDigest;
    }

    /**
     * <p>
     * Establece el valor de Digest extraído del sello de tiempo.
     * <p>
     * 
     * @param selloDigest
     *            Valor de Digest
     */
    public void setSelloDigest(final String selloDigest) {
        this.selloDigest = selloDigest;
    }

    /**
     * <p>
     * Devuelve el token extraído del sello de tiempo.
     * </p>
     * 
     * @return Tst extraído, o <code>null</code> si no existe
     */
    public TimeStampToken getTst() {
        return tst;
    }

    /**
     * <p>
     * Almacena el token extraído del sello de tiempo.
     * </p>
     * 
     * @param tst
     *            Tst a almacenar
     */
    public void setTst(final TimeStampToken tst) {
        this.tst = tst;
    }
}
