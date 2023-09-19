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

package es.mityc.javasign.i18n;

import java.util.Locale;

/**
 * <p>
 * Manager devuelto cuando no se dispone de un diccionario asociado.
 * </p>
 * 
 * <p>
 * Esta clase evita que se produzcan errores en ejecucion si no se controlan errores al instanciar el manager.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class I18nDumbManager implements II18nManager {

    /** Espacio en blanco. */
    private static final String SPACE = " ";
    /** Cabecera fija del mensaje del internacionalizador. */
    private static final String DUMB_MESSAGE = "I18nDumbManager: no dictionary avalaible: ";

    /** Respuesta enviada como cabecera de todas las consultas a este internacionalizador. */
    private String response;

    /**
     * <p>
     * Construye una instancia de un manager no disponible.
     * </p>
     */
    public I18nDumbManager() {
    }

    /**
     * <p>
     * Inicializa el diccionario con el nombre del diccionario que se ha pedido.
     * </p>
     * 
     * @param dictionary
     *            Nombre del diccionario que no se ha encontrado
     * @param locale
     *            Localizador con el que se inicializa el manager
     * 
     * @throws DictionaryUnknownException
     *             No se lanza nunca
     */
    public void init(final String dictionary, final Locale locale) throws DictionaryUnknownException {
        response = DUMB_MESSAGE + dictionary;
        if (locale != null) {
            response = response + SPACE + locale;
        }
    }

    /**
     * <p>
     * Devuelve un mensaje de aviso de que el diccionario no se encuentra disponible.
     * </p>
     * 
     * @param message
     *            Clave del mensaje que se quiere internacionalizar
     * 
     * @return mensaje de aviso del error
     * 
     * @see es.mityc.javasign.i18n.II18nManager#getLocalMessage(java.lang.String)
     */
    public String getLocalMessage(final String message) {
        return response + SPACE + message;
    }

    /**
     * <p>
     * Devuelve un mensaje de aviso de que el diccionario no se encuentra disponible.
     * </p>
     * 
     * @param message
     *            Clave del mensaje que se quiere internacionalizar
     * @param varargs
     *            variables que se quieren introducir en el mensaje
     * 
     * @return mensaje de aviso del error
     * 
     * @see es.mityc.javasign.i18n.II18nManager#getLocalMessage(java.lang.String, java.lang.Object[])
     */
    public String getLocalMessage(final String message, final Object... varargs) {
        return response + SPACE + message;
    }

}
