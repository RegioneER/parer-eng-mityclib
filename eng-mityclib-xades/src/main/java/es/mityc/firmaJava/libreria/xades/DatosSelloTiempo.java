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

import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.tsp.TimeStampToken;

import es.mityc.firmaJava.trust.ConfianzaEnum;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class DatosSelloTiempo {

    private Date fecha = null;
    private X500Principal emisor = null;
    private String algoritmo = null;
    private Long precision = null;
    private TipoSellosTiempo tipoSello = null;
    private TimeStampToken tst = null;
    private ConfianzaEnum esCertConfianza = ConfianzaEnum.NO_REVISADO;

    public DatosSelloTiempo() {
    }

    /**
     * Almacena informacion referente al sello de tiempo de una firma
     * 
     * @param java.util.Date
     *            fecha .- Fecha del sello de tiempo
     * @param String
     *            emisor .- Emisor del sello de tiempo
     * @param String
     *            algoritmo .- Algoritmo de calculo del hash del sello
     * @param TipoSellosTiempo
     *            .- Tipo de sello para la firma XAdES-X
     * @param TimeStampToken
     *            .- El objeto que almacena el sello de tiempo
     * @param esCertConfianza
     *            .- Indica si el certificado de la TSA es considerado de confianza
     */
    public DatosSelloTiempo(Date fecha, X500Principal emisor, String algoritmo, Long precision,
            TipoSellosTiempo tipoSello, TimeStampToken tst, ConfianzaEnum esCertconfianza) {

        this.fecha = fecha;
        this.emisor = emisor;
        this.algoritmo = algoritmo;
        this.precision = precision;
        this.tipoSello = tipoSello;
        this.tst = tst;
        this.esCertConfianza = esCertconfianza;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public X500Principal getEmisor() {
        return emisor;
    }

    public void setEmisor(X500Principal emisor) {
        this.emisor = emisor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
    }

    public TipoSellosTiempo getTipoSello() {
        return tipoSello;
    }

    public void setTipoSello(TipoSellosTiempo tipoSello) {
        this.tipoSello = tipoSello;
    }

    public TimeStampToken getTst() {
        return tst;
    }

    public void setTst(TimeStampToken tst) {
        this.tst = tst;
    }

    public ConfianzaEnum esCertConfianza() {
        return esCertConfianza;
    }

    public void setEsCertConfianza(ConfianzaEnum esCertConfianza) {
        this.esCertConfianza = esCertConfianza;
    }
}
