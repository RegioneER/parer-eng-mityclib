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

package es.mityc.javasign.xml.xades.policy;

import java.net.URI;

/**
 * Estructura para la validacion de políticas de firma
 *
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 0.9 beta
 */

public class PolicyResult {

    public enum StatusValidation {
        unknown, valid, invalid
    };

    public class DownloadPolicy {
        public URI uri;
        public StatusValidation status;

        public DownloadPolicy(URI uri, StatusValidation status) {
            this.uri = uri;
            this.status = status;
        }
    }

    private StatusValidation result; // Almacena el resultado de la validacion
    private String descriptionResult; // Almacena una cadena descriptiva del resultado de la validacion
    private String description;
    private URI policyID;
    private URI[] documentation;
    private DownloadPolicy[] downloable;
    private String[] notices;
    private IValidacionPolicy policyVal; // Almacena el validador de la policy

    public PolicyResult() {
        result = StatusValidation.unknown;
    }

    public DownloadPolicy newDownloadPolicy(URI uri, StatusValidation status) {
        return new DownloadPolicy(uri, status);
    }

    public StatusValidation getResult() {
        return result;
    }

    public void setResult(StatusValidation result) {
        this.result = result;
    }

    public String getDescriptionResult() {
        return descriptionResult;
    }

    public void setDescriptionResult(String descriptionResult) {
        this.descriptionResult = descriptionResult;
    }

    public URI getPolicyID() {
        return policyID;
    }

    public void setPolicyID(URI policyID) {
        this.policyID = policyID;
    }

    public URI[] getDocumentation() {
        return documentation;
    }

    public void setDocumentation(URI[] documentation) {
        this.documentation = documentation;
    }

    public DownloadPolicy[] getDownloable() {
        return downloable;
    }

    public void setDownloable(DownloadPolicy[] downloable) {
        this.downloable = downloable;
    }

    public String[] getNotices() {
        return notices;
    }

    public void setNotices(String[] notices) {
        this.notices = notices;
    }

    /**
     * Get clase validadora de la policy
     * 
     * @return Instancia al validador de la policy
     */
    public IValidacionPolicy getPolicyVal() {
        return policyVal;
    }

    /**
     * Set clase validadora de la policy
     * 
     * @param Instancia
     *            del validador de la policy
     */
    public void setPolicyVal(IValidacionPolicy policyVal) {
        this.policyVal = policyVal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof IValidacionPolicy) && (policyVal != null)) {
            IValidacionPolicy val = (IValidacionPolicy) obj;
            if (policyVal.getIdentidadPolicy().equals(val.getIdentidadPolicy()))
                return true;
            return false;
        } else
            return super.equals(obj);
    }

    public void copy(PolicyResult pr) {
        setResult(pr.getResult());
        setPolicyID(pr.getPolicyID());
        setDescriptionResult(pr.getDescriptionResult());
        setDocumentation(pr.getDocumentation());
        setDownloable(pr.getDownloable());
        setNotices(pr.getNotices());
    }
}
