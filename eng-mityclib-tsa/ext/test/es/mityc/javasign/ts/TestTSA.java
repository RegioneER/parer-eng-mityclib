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
package es.mityc.javasign.ts;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertStoreException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.bouncycastle.tsp.TSPException;
import org.junit.Before;
import org.junit.Test;

import es.mityc.firmaJava.ts.ConstantesTSA;
import es.mityc.firmaJava.ts.TSCliente;
import es.mityc.firmaJava.ts.TSClienteError;
import es.mityc.firmaJava.ts.TSValidator;

/**
 * <p>Tests de de peticiones de sellos de tiempo a TSA vía http.</p>
 * <p>Requisitos:<ul>
 * 	<li>El fichero de propiedades debe estar en la raíz de los recursos con el nombre <code>testTSA.properties</code>. El fichero
 * deber incluir la propiedad:
 * <pre>
 * # Ruta donde se encuentra la TSA que se utilizara para los tests
 * test.tsa.url=
 * </pre></li></ul>
 * </p>
 * 
 * @author  Ministerio de Industria, Turismo y Comercio
 * @version 1.0
 */
public class TestTSA {
	
	/** Ruta de la TSA de pruebas. */
	private String urlTSA = "";
	
	/**
	 * <p>Recupera la configuracion de acceso a la TSApara estas pruebas.</p>
	 */
	@Before 
	public void initialize() {
		try {
			ResourceBundle rb = ResourceBundle.getBundle("testTSA");
			urlTSA = rb.getString("test.tsa.url");
		} catch (MissingResourceException ex) {
			fail("No se encuentra disponible la configuracion específica para este test. Recuerde crear y configurar el fichero testTSA.properties");
		}
	}
	
	@Test
	public void testTSA() {
		TSCliente client = new TSCliente(urlTSA, ConstantesTSA.SHA1);
		byte result[] = null;
		byte data[] = new byte[1024];
		try {
			result = client.generarSelloTiempo(data);
		} catch (TSClienteError ex) {
			fail("Error obteniendo sello de tiempo de " + urlTSA + ": " + ex.getMessage());
		}
		try {
			TSValidator.validarSelloTiempo(data, result);
		} catch (NoSuchAlgorithmException ex) {
			fail("Error comprobando sello de tiempo obtenido: " + ex.getMessage());
		} catch (NoSuchProviderException ex) {
			fail("Error comprobando sello de tiempo obtenido: " + ex.getMessage());
		} catch (CertStoreException ex) {
			fail("Error comprobando sello de tiempo obtenido: " + ex.getMessage());
		} catch (TSPException ex) {
			fail("Error comprobando sello de tiempo obtenido: " + ex.getMessage());
		} catch (IOException ex) {
			fail("Error comprobando sello de tiempo obtenido: " + ex.getMessage());
		} catch (TSClienteError ex) {
			fail("Error comprobando sello de tiempo obtenido: " + ex.getMessage());
		}
	}


}
