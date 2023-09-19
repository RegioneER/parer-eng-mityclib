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

import es.mityc.javasign.certificate.ICertStatus;

/**
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */

public class RespYCerts {

    private String x509CertFile = null;
    private ICertStatus certstatus = null;
    private String idCertificado = null;
    private String idRespStatus = null;
    private String fileName = null;

    public RespYCerts() {
        // No hace nada
    }

    public String getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(String idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getIdRespStatus() {
        return idRespStatus;
    }

    public void setIdRespStatus(String idRespStatus) {
        this.idRespStatus = idRespStatus;
    }

    public String getX509CertFile() {
        return x509CertFile;
    }

    public void setX509CertFile(String certFile) {
        x509CertFile = certFile;
    }

    public ICertStatus getCertstatus() {
        return certstatus;
    }

    public void setCertstatus(ICertStatus certstatus) {
        this.certstatus = certstatus;
    }

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public String getFilename() {
        return fileName;
    }

    // public void loadCertFile(File certFile) {
    // try {
    // CertificateFactory cf = CertificateFactory.getInstance("X.509");
    // x509Cert = (X509Certificate)cf.generateCertificate(new FileInputStream(certFile));
    // x509CertFile = certFile.getAbsolutePath();
    // } catch (CertificateException ex) {
    // // TODO: dejar aviso
    // } catch (FileNotFoundException ex) {
    // // TODO: dejar aviso
    // }
    // }

}
