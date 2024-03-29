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

package es.mityc.firmaJava.libreria.xades.elementos.xades;

import java.math.BigInteger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.errores.InvalidInfoNodeException;

/**
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class CertIDType extends AbstractXADESElement {

    private CertDigest digest;
    private IssuerSerial issuerSerial;

    public CertIDType(XAdESSchemas schema) {
        super(schema);
    }

    public CertIDType(XAdESSchemas schema, CertDigest digest, IssuerSerial issuerSerial) {
        super(schema);
        this.digest = digest;
        this.issuerSerial = issuerSerial;
    }

    public CertIDType(XAdESSchemas schema, String digestMethod, String digestValue, String issuerName,
            BigInteger serialNumber) {
        super(schema);
        this.digest = new CertDigest(schema, digestMethod, digestValue);
        this.issuerSerial = new IssuerSerial(schema, issuerName, serialNumber);
    }

    public CertIDType(XAdESSchemas schema, String digestMethod, byte[] digestValue, String issuerName,
            BigInteger serialNumber) throws InvalidInfoNodeException {
        super(schema);
        this.digest = new CertDigest(schema, digestMethod, digestValue);
        this.issuerSerial = new IssuerSerial(schema, issuerName, serialNumber);
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CertIDType) {
            CertIDType cit = (CertIDType) obj;
            if ((digest == null) || (issuerSerial == null)) {
                return false;
            }
            if (!digest.equals(cit.digest))
                return false;
            if (issuerSerial.equals(cit.issuerSerial))
                return true;
        }
        return false;
    }

    /**
     * @see es.mityc.firmaJava.libreria.xades.elementos.AbstractXMLElement#load(org.w3c.dom.Element)
     */
    @Override
    public void load(Element element) throws InvalidInfoNodeException {
        // TODO: tener en cuenta el namespace XAdES del elemento cargado

        Node node = getFirstNonvoidNode(element);

        CertDigest digest = new CertDigest(getSchema());
        if (!digest.isThisNode(node)) {
            throw new InvalidInfoNodeException("Se esperaba nodo CertDigest en CertIDType");
        }
        digest.load((Element) node);

        node = getNextNonvoidNode(node);
        IssuerSerial issuerSerial = new IssuerSerial(getSchema());
        if (!issuerSerial.isThisNode(node)) {
            throw new InvalidInfoNodeException("Se esperaba nodo IssuerSerial en CertIDType");
        }
        issuerSerial.load((Element) node);

        this.digest = digest;
        this.issuerSerial = issuerSerial;
    }

    public void setDigest(CertDigest digest) {
        this.digest = digest;
    }

    public void setDigest(String digestMethod, String digestValue) {
        this.digest = new CertDigest(schema, digestMethod, digestValue);
    }

    public void setDigest(String digestMethod, byte[] digestValue) throws InvalidInfoNodeException {
        this.digest = new CertDigest(schema, digestMethod, digestValue);
    }

    public CertDigest getCertDigest() {
        return this.digest;
    }

    public void setIssuerSerial(String issuerName, BigInteger serialNumber) {
        this.issuerSerial = new IssuerSerial(schema, issuerName, serialNumber);
    }

    public void setIssuerSerial(IssuerSerial issuerSerial) {
        this.issuerSerial = issuerSerial;
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

}
