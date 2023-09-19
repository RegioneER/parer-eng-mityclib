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
 * Interfaz que ha de implementar una factoría de managers de internacionalizacion.
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public interface II18nFactory {

    /**
     * Devuelve una instancia de un manager de internacionalizacion.
     * 
     * @param dictionary
     *            Clave que identifica el diccionario
     * @param locale
     *            Localizacion de la que se quiere el diccionario
     * 
     * @return Instancia del manager de internacionalizacion
     */
    II18nManager getI18nManager(String dictionary, Locale locale);

}
