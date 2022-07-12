/**
 * LICENCIA LGPL:
 * 
 * Esta librería es Software Libre; Usted puede redistribuirlo y/o modificarlo
 * bajo los términos de la GNU Lesser General Public License (LGPL)
 * tal y como ha sido publicada por la Free Software Foundation; o
 * bien la version 2.1 de la Licencia, o (a su eleccion) cualquier version posterior.
 * 
 * Esta librería se distribuye con la esperanza de que sea útil, pero SIN NINGUNA
 * GARANTÍA; tampoco las implícitas garantías de MERCANTILIDAD o ADECUACIoN A UN
 * PROPoSITO PARTICULAR. Consulte la GNU Lesser General Public License (LGPL) para mas
 * detalles
 * 
 * Usted debe recibir una copia de la GNU Lesser General Public License (LGPL)
 * junto con esta librería; si no es así, escriba a la Free Software Foundation Inc.
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA.
 * 
 */
package es.mityc.javasign.i18n;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Factoría de pruebas que genera instancias de managers para tests.</p>
 * <p>Permite asociar un tipo de manager antes de realizar los tests. Cachea los managers creados.</p>
 * @author  Ministerio de Industria, Turismo y Comercio
 * @version 1.0
 */
public class I18nTestFactory implements II18nFactory {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(I18nTestFactory.class);
	
	/** Clase indicada no es accesible: {0}. */
	private static final String ERROR_ACCESING_CLASS = "Clase indicada no es accesible: {0}";
	/** Error creando instancia de manager de internacionalizacion: {0}. */
	private static final String ERROR_INSTANTIATION_MANAGER = "Error creando instancia de manager de internacionalizacion: {0}";
	/** Clase indicada no es del tipo II18nManager: {0}. */
	private static final String ERROR_CASTING_MANAGER = "Clase indicada no es del tipo II18nManager: {0}";
	/** Clase indicada no tiene constructor nulo: {0}. */
	private static final String ERROR_IMPLEMENTED_CLASS = "Clase indicada no tiene constructor nulo: {0}";
	/** Error en la inicializacion del manager con el diccionario {0}. */
	private static final String ERROR_INIT_MANAGER = "Error en la inicializacion del manager con el diccionario {0}";
	
	/** Clase de internacionalizacion que se testeara. */
	private static Class< ? extends II18nManager> i18nManagerClass;
	/** Caché interna de managers de internacionalizacion. */
	private static HashMap<String, ManagerCached> cache = new HashMap<String, ManagerCached>();
	
	/**
	 * <p>Constructor vacío.</p> 
	 */
	public I18nTestFactory() {
	}

	/**
	 * <p>Devuelve una instancia inicializada del manager que se esta testeando.</p>
	 * @param dictionary Diccionario del manager
	 * @param locale Locale del manager
	 * @return Manager
	 * @see es.mityc.javasign.i18n.II18nFactory#getI18nManager(java.lang.String, java.util.Locale)
	 */
	public II18nManager getI18nManager(final String dictionary, final Locale locale) {
		synchronized (cache) {
			ManagerCached mc = cache.get(dictionary);
			if ((mc == null) || (!mc.isSameLocale(locale))) {
				mc = new ManagerCached(instantiateManager(dictionary, locale), locale);
				cache.put(dictionary, mc);
			}
			return mc.getI18nCached();
		}
	}
	
	/**
	 * <p>Instancia el manager pedido.</p>
	 * <p>Si no hay configurado ningún manager de internacionalizacion carga el manager por defecto ({@link I18nDefaultManager}). Si tiene problemas en
	 * la instanciacion del manager configurado devolvera un manager {@link I18nDumbManager}.</p>
	 * 
	 * @param dictionary Diccionario que debe gestionar el manager
	 * @param specificLocale Locale específico (<code>null</code> si no se especifica Locale)
	 * @return Manager instanciado e inicializado, I18nDumbManager si ha tenido problemas para encontrar el manager
	 * 			(ver {@link I18nDumbManager}).
	 */
	private static II18nManager instantiateManager(final String dictionary, final Locale specificLocale) {
		II18nManager manager = null;
		if (i18nManagerClass != null) {
			try {
				manager = i18nManagerClass.newInstance();
			} catch (InstantiationException ex) {
				LOG.error(getFormatedMessage(ERROR_INSTANTIATION_MANAGER, i18nManagerClass), ex);
			} catch (IllegalAccessException ex) {
				LOG.error(getFormatedMessage(ERROR_ACCESING_CLASS, i18nManagerClass), ex);
			} catch (ClassCastException ex) {
				LOG.error(getFormatedMessage(ERROR_CASTING_MANAGER, i18nManagerClass), ex);
			} catch (SecurityException ex) {
				LOG.error(getFormatedMessage(ERROR_ACCESING_CLASS, i18nManagerClass), ex);
			} catch (IllegalArgumentException ex) {
				LOG.error(getFormatedMessage(ERROR_IMPLEMENTED_CLASS, i18nManagerClass), ex);
			}
			try {
				manager.init(dictionary, specificLocale);
			} catch (DictionaryUnknownException ex) {
				LOG.error(getFormatedMessage(ERROR_INIT_MANAGER, dictionary), ex);
			}
		}
		// Inicializa el manager de internacionalizacion
		return manager;
	}

	
	/**
	 * <p>Genera una instancia a esta factoría.</p>
	 * @return nueva instancia de esta factoría
	 */
	public static II18nFactory newInstance() {
		return new I18nTestFactory();
	}
	
	/**
	 * <p>Establece la clase de internacionalizador que devolvera esta factoría.</p>
	 * @param classManager Clase internacionalizadora
	 */
	public static void setManager(final Class< ? extends II18nManager> classManager) {
		i18nManagerClass = classManager;
		clearCache();
	}
	
	/**
	 * <p>Limpia la caché de internacionalizadores cargados.</p>
	 */
	public static void clearCache() {
		cache.clear();
	}
	
	/**
	 * <p>Incluye parametros en un mensaje.</p>
	 * 
	 * @param message Mensaje a dar formato
	 * @param varargs Parametros a incluir en el mensaje
	 * @return Mensaje con los parametros incluidos
	 */
	private static String getFormatedMessage(final String message, final Object... varargs) {
		MessageFormat mf = new MessageFormat(message);
		return mf.format(varargs, new StringBuffer(), null).toString();
	}


}
