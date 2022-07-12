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

import org.junit.Test;
import static org.junit.Assert.fail;

/**
 * <p>Test de pruebas del manager de internacionalizacion de tipo addendum.</p>
 * 
 * @author  Ministerio de Industria, Turismo y Comercio
 * @version 1.0
 */
public class TestAddendum {
	
	/** Nombre del fichero de internacionalizacion. */
	private static final String I18N_TEST_FILE = "TestAddendum";
	/** Clave 1 del fichero de internacionalizacion. */
	private static final String I18N_TEST_KEY_1 = "i18n.test.addendum.1";
	/** Clave 1 del fichero de internacionalizacion. */
	private static final String I18N_TEST_KEY_2 = "i18n.test.addendum.2";
	/** Valor de la clave 1 del fichero de internacionalizacion. */
	private static final String I18N_TEST_VALUE_1 = "Test A";
	/** Valor de la clave 1 del fichero de internacionalizacion. */
	private static final String I18N_TEST_VALUE_2 = "Test C";
	
	/**
	 * <p>Comprueba que addendum apila correctamente las entradas.</p>
	 */
	@Test
	public void testAddendum() {
		I18nTestFactory.setManager(I18nAddendumManager.class);
		II18nManager i18n = I18nFactory.getI18nManager(I18N_TEST_FILE);
		if (!I18N_TEST_VALUE_1.equals(i18n.getLocalMessage(I18N_TEST_KEY_1))) {
			fail("Valor de la clave 1 no coincide con el fichero de internacionalizacion");
		}
		if (!I18N_TEST_VALUE_2.equals(i18n.getLocalMessage(I18N_TEST_KEY_2))) {
			fail("Valor de la clave 2 no coincide con el fichero de addendum");
		}
	}

}
