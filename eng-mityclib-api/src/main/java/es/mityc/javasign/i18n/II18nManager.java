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
 * Interfaz que han de implementar los managers de internacionalizacion.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface II18nManager {

    /**
     * Inicializa el manager con el diccionario indicado.
     * 
     * @param dictionary
     *            diccionario que debera gestionar el manager
     * @param locale
     *            Locale establecido (<code>null</code> si no se especifica ninguno)
     * 
     * @throws DictionaryUnknownException
     *             cuando se desconoce el diccionario indicado
     */
    void init(String dictionary, Locale locale) throws DictionaryUnknownException;

    /**
     * <p>
     * Devuelve el mensaje identificado por la clave proporcionada según el diccionario gestionado por el manager.
     * </p>
     * 
     * @param message
     *            clave que identifica el mensaje
     * 
     * @return mensaje recuperado
     */
    String getLocalMessage(String message);

    /**
     * <p>
     * Devuelve el mensaje compuesto identificado por la clave proporcionada según el diccionario gestionado por el
     * manager.
     * </p>
     * 
     * @param message
     *            clave que identifica el mensaje
     * @param varargs
     *            variables que se deben insertar en el mensaje compuesto
     * 
     * @return mensaje recuperado con las variables indicadas incrustadas
     */
    String getLocalMessage(String message, Object... varargs);

}
