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

package es.mityc.javasign.xml.refs;

import es.mityc.javasign.ConstantsXAdES;
import es.mityc.javasign.i18n.I18nFactory;
import es.mityc.javasign.i18n.II18nManager;
import es.mityc.javasign.xml.resolvers.IPrivateData;
import es.mityc.javasign.xml.resolvers.MITyCResourceResolver;
import es.mityc.javasign.xml.resolvers.ResolverPrivateData;
import es.mityc.javasign.xml.transform.Transform;

/**
 * <p>
 * Representa un objeto externo al XML (no definido) que debe ser firmado.
 * </p>
 * <p>
 * Para poder acceder al contenido y obtener su digest se debe proporcionar el digester adecuado que implemente el
 * interfaz <code>IPrivateDate</code>.
 * </p>
 * <p>
 * Este tipo de objetos delega la seguridad e integridad del contenido en el gestionador de la informacion privada, que
 * sera el responsable de asegurar que no se produce ningún ataque sobre la informacon.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class UnknownExternObjectToSign extends AbstractObjectToSign {

    /** Internacionalizador. */
    private static final II18nManager I18N = I18nFactory.getI18nManager(ConstantsXAdES.LIB_NAME);

    private String name;
    private IPrivateData digester;

    public UnknownExternObjectToSign(String name, IPrivateData privateDataDigester) {
        this.name = name;
        this.digester = privateDataDigester;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return
     */
    public IPrivateData getDigester() {
        return digester;
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#addTransform(es.mityc.javasign.xml.transform.Transform)
     */
    @Override
    public void addTransform(Transform t) {
        throw new IllegalArgumentException(I18N.getLocalMessage(ConstantsXAdES.I18N_SIGN_10));
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#getReferenceURI()
     */
    @Override
    public String getReferenceURI() {
        return name;
    }

    /**
     * @see es.mityc.javasign.xml.refs.AbstractObjectToSign#getResolver()
     */
    @Override
    public MITyCResourceResolver getResolver() {
        return new ResolverPrivateData(getDigester());
    }
}
