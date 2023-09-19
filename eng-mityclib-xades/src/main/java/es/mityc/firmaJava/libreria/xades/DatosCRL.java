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

import java.security.cert.X509CRL;
import java.util.Date;

import es.mityc.firmaJava.trust.ConfianzaEnum;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class DatosCRL {

    private String issuer = null;
    private Date fechaEmision = null;
    private Date fechaCaducidad = null;
    private X509CRL x509CRL = null;
    private ConfianzaEnum esCertConfianza = ConfianzaEnum.NO_REVISADO;

    public DatosCRL() {
    }

    /**
     * Almacena informacion referente a una lista de revocacion de certificados
     * 
     * @param issuer
     *            .- Emisor de la CRL
     * @param fechaEmision
     *            .- La fecha de emision de la lista
     * @param fechaCaducidad
     *            .- La fecha de caducidad de la lista
     * @param x509CRL
     *            .- La lista propiamente dicha
     * @param esCertConfianza
     *            .- Booleano que indica si la CRL es considerada de confianza
     */
    public DatosCRL(String issuer, Date fechaEmision, Date fechaCaducidad, X509CRL x509CRL,
            ConfianzaEnum esCertConfianza) {
        this.issuer = issuer;
        this.fechaEmision = fechaEmision;
        this.fechaCaducidad = fechaCaducidad;
        this.x509CRL = x509CRL;
        this.esCertConfianza = esCertConfianza;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public X509CRL getX509CRL() {
        return x509CRL;
    }

    public void setX509CRL(X509CRL x509crl) {
        x509CRL = x509crl;
    }

    public ConfianzaEnum esCertConfianza() {
        return esCertConfianza;
    }

    public void setEsCertConfianza(ConfianzaEnum esCertConfianza) {
        this.esCertConfianza = esCertConfianza;
    }
}
