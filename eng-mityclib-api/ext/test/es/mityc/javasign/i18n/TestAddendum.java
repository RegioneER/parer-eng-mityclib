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

/**
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
