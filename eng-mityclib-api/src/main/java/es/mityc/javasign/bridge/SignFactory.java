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

package es.mityc.javasign.bridge;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.mityc.javasign.ConstantsAPI;
import es.mityc.javasign.i18n.I18nFactory;
import es.mityc.javasign.i18n.II18nManager;

/**
 * <p>
 * Factoría para los facades de servicios de firma.
 * </p>
 * 
 * <p>
 * Mediante esta factoría, bajo patron singleton, se instancia los facades que dan servicio de firma. Estos facades
 * deberan contar con un constructor sin parametros que sera el llamado para generar la instancia que se entregara.
 * </p>
 * <p>
 * Los facades a instanciar se configuran mediante un fichero de propiedades (<code>bridge/sign.properties</code>), a
 * través de su propiedad <code>facade.sign.class</code> en la cual se indica la clase facade:
 * 
 * <pre>
 * # Indica la clase que implementa el interfaz ISignFacade que dara los servicios de firma
 * facade.sign.class=
 * </pre>
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public final class SignFactory {
    /** Logger. */
    private static final Log LOG = LogFactory.getLog(SignFactory.class);
    /** Internacionalizador. */
    private static final II18nManager I18N = I18nFactory.getI18nManager(ConstantsAPI.LIB_NAME);

    /** Instancia única de la factoría. */
    private static SignFactory instance;
    /** Propiedades de configuracion de la factoría. */
    private Properties props = null;

    /** Nombre del fichero de propiedades que contiene la configuracion de la factoría. */
    private static final String SIGN_FILE_CONF = "bridge/sign.properties";
    /** Nombre de la propiedad que tiene la clase de facade de firma. */
    private static final String PROP_FACADE_CLASS = "facade.sign.class";

    /**
     * <p>
     * Constructor.
     * </p>
     * <p>
     * Recupera la configuracion de la factoría de los facade de firma.
     * </p>
     */
    private SignFactory() {
        // Carga las propiedades
        InputStream is = getClassLoader().getResourceAsStream(SIGN_FILE_CONF);
        if (is != null) {
            try {
                props = new Properties();
                props.load(is);
            } catch (IOException ex) {
                LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_1));
            }
        } else {
            LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_1));
        }
    }

    /**
     * <p>
     * Recupera el ClassLoader de contexto si esta disponible.
     * </p>
     * <p>
     * Si no esta disponible el de contexto devuelve el propio de la clase.
     * </p>
     * 
     * @return ClassLoader
     */
    private static ClassLoader getClassLoader() {
        try {
            ClassLoader cl = AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
                public ClassLoader run() {
                    ClassLoader classLoader = null;
                    try {
                        classLoader = Thread.currentThread().getContextClassLoader();
                    } catch (SecurityException ex) {
                    }
                    return classLoader;
                }
            });
            if (cl != null) {
                return cl;
            }
        } catch (Exception ex) {
        }
        return SignFactory.class.getClassLoader();
    }

    /**
     * Para evitar problemas de sincronismo se instancia la primera vez que se referencia
     */
    static {
        instance = getInstance();
    }

    /**
     * Devuelve una instancia la factoría de facades de servicios de firma.
     * 
     * @return Instancia de la factoría
     */
    public static SignFactory getInstance() {
        if (instance == null) {
            instance = new SignFactory();
        }
        return instance;
    }

    /**
     * <p>
     * Devuelve el facade configurado para dar servicios de firma.
     * </p>
     * 
     * @return Una instancia del validador de policy asociado o <code>null</code> si no hay ninguno asociado o no se
     *         puede instanciar.
     */
    public ISignFacade getSignFacade() {
        ISignFacade signFacade = null;
        if (props != null) {
            String classname = props.getProperty(PROP_FACADE_CLASS);
            if ((classname != null) && (!"".equals(classname.trim()))) {
                try {
                    ClassLoader cl = getClassLoader();
                    Class<?> classTemp = null;
                    if (cl != null) {
                        classTemp = cl.loadClass(classname);
                    } else {
                        classTemp = Class.forName(classname);
                    }
                    if (classTemp != null) {
                        signFacade = (ISignFacade) classTemp.getConstructor((Class[]) null).newInstance();
                    }
                } catch (InstantiationException ex) {
                    LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_2));
                    if (LOG.isDebugEnabled()) {
                        LOG.error("", ex);
                    }
                } catch (InvocationTargetException ex) {
                    LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_2));
                    if (LOG.isDebugEnabled()) {
                        LOG.error("", ex);
                    }
                } catch (IllegalAccessException ex) {
                    LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_3));
                    if (LOG.isDebugEnabled()) {
                        LOG.error("", ex);
                    }
                } catch (ClassNotFoundException ex) {
                    LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_4, classname));
                    if (LOG.isDebugEnabled()) {
                        LOG.error("", ex);
                    }
                } catch (ClassCastException ex) {
                    LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_5));
                    if (LOG.isDebugEnabled()) {
                        LOG.error("", ex);
                    }
                } catch (NoSuchMethodException ex) {
                    LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_5));
                    if (LOG.isDebugEnabled()) {
                        LOG.error("", ex);
                    }
                }
            } else {
                LOG.error(I18N.getLocalMessage(ConstantsAPI.I18N_BRIDGE_6));
            }
        }
        return signFacade;
    }

}
