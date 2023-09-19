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

package es.mityc.firmaJava.role;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author dsantose
 *
 */
public class XadesLabsClaimedRole implements IClaimedRole {

    private String type;
    private boolean executiveDirector;
    private boolean shareHolder;
    private boolean vendor;
    private boolean purchaser;
    private boolean engineer;

    public XadesLabsClaimedRole(String type) {
        this.type = type;
    }

    public void setExecutiveDirector(boolean executiveDirector) {
        this.executiveDirector = executiveDirector;
    }

    public void setShareHolder(boolean shareHolder) {
        this.shareHolder = shareHolder;
    }

    public void setVendor(boolean vendor) {
        this.vendor = vendor;
    }

    public void setPurchaser(boolean purchaser) {
        this.purchaser = purchaser;
    }

    public void setEngineer(boolean engineer) {
        this.engineer = engineer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.mityc.firmaJava.role.IClaimedRole#createClaimedRoleContent(org.w3c.dom.Document)
     */
    public Node createClaimedRoleContent(Document doc) {
        Element root = doc.createElementNS("http://xadeslabs.com/xades", "xl:XadesLabs");
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xl", "http://xadeslabs.com/xades");
        Element roles = doc.createElementNS("http://xadeslabs.com/xades", "xl:Roles");
        roles.setAttributeNS(null, "type", type);
        root.appendChild(roles);
        Element child = doc.createElementNS("http://xadeslabs.com/xades", "xl:ExecutiveDirector");
        child.appendChild(doc.createTextNode(Boolean.toString(this.executiveDirector)));
        roles.appendChild(child);
        child = doc.createElementNS("http://xadeslabs.com/xades", "xl:ShareHolder");
        child.appendChild(doc.createTextNode(Boolean.toString(this.shareHolder)));
        roles.appendChild(child);
        child = doc.createElementNS("http://xadeslabs.com/xades", "xl:Vendor");
        child.appendChild(doc.createTextNode(Boolean.toString(this.vendor)));
        roles.appendChild(child);
        child = doc.createElementNS("http://xadeslabs.com/xades", "xl:Purchaser");
        child.appendChild(doc.createTextNode(Boolean.toString(this.purchaser)));
        roles.appendChild(child);
        child = doc.createElementNS("http://xadeslabs.com/xades", "xl:Engineer");
        child.appendChild(doc.createTextNode(Boolean.toString(this.engineer)));
        roles.appendChild(child);
        return root;
    }

}
