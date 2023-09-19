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

import java.security.cert.X509Certificate;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.ocsp.OCSPResp;

import es.mityc.firmaJava.libreria.utilidades.Base64Coder;
import es.mityc.firmaJava.trust.ConfianzaEnum;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class DatosOCSP {

    private ResponderID responderId = null;
    private String responderIdName = null;
    private Date fechaConsulta = null;
    private String certConsultado = null;
    private OCSPResp respuestaOCSP = null;
    private ConfianzaEnum esCertConfianza = ConfianzaEnum.NO_REVISADO;
    private X509Certificate[] certOCSPResponder = null;

    public DatosOCSP() {
    }

    /**
     * Almacena informacion referente a una consulta OCSP
     * 
     * @param responderId
     *            .- Identificador del emisor de la respuesta OCSP
     * @param fechaConsulta
     *            .- Fecha en la que se realizo la consulta
     * @param certConsultado
     *            .- Certificado consultado al servidor OCSP
     * @param respuestaOCSP
     *            .- El objeto OCSP que almacena la respuesta obtenida
     * @param esCertConfianza
     *            .- Booleano que indica si la respuesta es considerada de confianza
     * @param certOCSPResponder
     *            .- Cadena de certificados del OCSP Responder (su propia certificacion)
     */
    public DatosOCSP(ResponderID responderId, Date fechaConsulta, String certConsultado, OCSPResp respuestaOCSP,
            ConfianzaEnum esCertConfianza, X509Certificate[] certOCSPResponder) {
        this.responderId = responderId;
        updateResponderIDName(responderId);
        this.fechaConsulta = fechaConsulta;
        this.certConsultado = certConsultado;
        this.respuestaOCSP = respuestaOCSP;
        this.esCertConfianza = esCertConfianza;
        this.esCertConfianza = esCertConfianza;
        this.certOCSPResponder = certOCSPResponder;
    }

    public ResponderID getResponderId() {
        return responderId;
    }

    public void setResponderId(ResponderID responderId) {
        this.responderId = responderId;
        updateResponderIDName(responderId);
    }

    private void updateResponderIDName(ResponderID responderId) {
        if (responderId != null) {
            ASN1TaggedObject tagged = (ASN1TaggedObject) responderId.toASN1Object();
            switch (tagged.getTagNo()) {
            case 1:
                X509Principal certX509Principal = new X509Principal(
                        X509Name.getInstance(tagged.getObject()).toString());
                X500Principal cerX500Principal = new X500Principal(certX509Principal.getDEREncoded());
                responderIdName = cerX500Principal.getName();
                break;
            case 2:
                ASN1OctetString octect = (ASN1OctetString) tagged.getObject();
                responderIdName = new String(Base64Coder.encode(octect.getOctets()));
                break;
            }
        } else
            responderIdName = null;
    }

    public String getResponderIdName() {
        return responderIdName;
    }

    public String getCertConsultado() {
        return certConsultado;
    }

    public void setCertConsultado(String certConsultado) {
        this.certConsultado = certConsultado;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public OCSPResp getRespuestaOCSP() {
        return respuestaOCSP;
    }

    public void setRespuestaOCSP(OCSPResp respuestaOCSP) {
        this.respuestaOCSP = respuestaOCSP;
    }

    public ConfianzaEnum esCertConfianza() {
        return esCertConfianza;
    }

    public void setEsCertConfianza(ConfianzaEnum esCertConfianza) {
        this.esCertConfianza = esCertConfianza;
    }

    public X509Certificate[] getCertOCSPResponder() {
        return certOCSPResponder;
    }

    public void setCertOCSPResponder(X509Certificate[] certOCSPResponder) {
        this.certOCSPResponder = certOCSPResponder;
    }
}
