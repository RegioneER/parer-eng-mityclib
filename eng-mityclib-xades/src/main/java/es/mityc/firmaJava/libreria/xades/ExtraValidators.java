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

import java.util.List;

import es.mityc.javasign.certificate.ICertStatusRecoverer;
import es.mityc.javasign.trust.TrustAbstract;
import es.mityc.javasign.xml.xades.policy.IValidacionPolicy;

/**
 * Esta clase contiene los validadores adicionales que se utilizaran al validar la firma XAdES.
 * 
 * <br/>
 * <br/>
 * Estos validadores contemplan la validacion de:
 * <ul>
 * <li>Validacion de política de firma: comprueban que la firma se ajuste a las políticas indicadas.</li>
 * <li>Validacion de certificado: si la firma es valida y no incluye informacion de estado de certificado, comprueba el
 * estado del certificado con este validador.</li>
 * <li>Confianza: comprueban que los elementos de la firma sean de entidades de confianza (certificados de firma,
 * respuestas de estados de certificados, sellos de tiempo, etc).</li>
 * </ul>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class ExtraValidators {

    private List<IValidacionPolicy> policies;
    private ICertStatusRecoverer certStatus;
    private TrustAbstract trusterOCSP;
    private TrustAbstract trusterCRL;
    private TrustAbstract trusterCerts;
    private TrustAbstract trusterTSA;

    /**
     * @param policies
     * @param certStatus
     * @param trusterCerts
     */
    public ExtraValidators(List<IValidacionPolicy> policies, ICertStatusRecoverer certStatus,
            TrustAbstract trusterCerts) {
        super();
        this.policies = policies;
        this.certStatus = certStatus;
        this.trusterCerts = trusterCerts;
    }

    /**
     * @return the policies
     */
    public List<IValidacionPolicy> getPolicies() {
        return policies;
    }

    /**
     * @param policies
     *            the policies to set
     */
    public void setPolicies(List<IValidacionPolicy> policies) {
        this.policies = policies;
    }

    /**
     * @return the certStatus
     */
    public ICertStatusRecoverer getCertStatus() {
        return certStatus;
    }

    /**
     * @param certStatus
     *            the certStatus to set
     */
    public void setCertStatus(ICertStatusRecoverer certStatus) {
        this.certStatus = certStatus;
    }

    /**
     * @return the trusterOCSP
     */
    public TrustAbstract getTrusterOCSP() {
        return trusterOCSP;
    }

    /**
     * @param trusterOCSP
     *            the trusterOCSP to set
     */
    public void setTrusterOCSP(TrustAbstract trusterOCSP) {
        this.trusterOCSP = trusterOCSP;
    }

    /**
     * @return the trusterCRL
     */
    public TrustAbstract getTrusterCRL() {
        return trusterCRL;
    }

    /**
     * @param trusterCRL
     *            the trusterCRL to set
     */
    public void setTrusterCRL(TrustAbstract trusterCRL) {
        this.trusterCRL = trusterCRL;
    }

    /**
     * @return the trusterCerts
     */
    public TrustAbstract getTrusterCerts() {
        return trusterCerts;
    }

    /**
     * @param trusterCerts
     *            the trusterCerts to set
     */
    public void setTrusterCerts(TrustAbstract trusterCerts) {
        this.trusterCerts = trusterCerts;
    }

    /**
     * @return the trusterTSA
     */
    public TrustAbstract getTrusterTSA() {
        return trusterTSA;
    }

    /**
     * @param trusterTSA
     *            the trusterTSA to set
     */
    public void setTrusterTSA(TrustAbstract trusterTSA) {
        this.trusterTSA = trusterTSA;
    }

}
