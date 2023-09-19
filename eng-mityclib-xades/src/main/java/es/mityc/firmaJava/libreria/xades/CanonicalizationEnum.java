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

package es.mityc.firmaJava.libreria.xades;

import org.apache.xml.security.transforms.Transforms;

public enum CanonicalizationEnum {

    UNKNOWN("unknown"), C14N_OMIT_COMMENTS(Transforms.TRANSFORM_C14N_OMIT_COMMENTS),
    C14N_WITH_COMMENTS(Transforms.TRANSFORM_C14N_WITH_COMMENTS),
    C14N11_OMIT_COMMENTS(Transforms.TRANSFORM_C14N11_OMIT_COMMENTS),
    C14N11_WITH_COMMENTS(Transforms.TRANSFORM_C14N11_WITH_COMMENTS),
    C14N_EXCL_OMIT_COMMENTS(Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS),
    C14N_EXCL_WITH_COMMENTS(Transforms.TRANSFORM_C14N_EXCL_WITH_COMMENTS);

    private String value;

    private CanonicalizationEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static CanonicalizationEnum getCanonicalization(String value) {
        if (value != null) {
            if (Transforms.TRANSFORM_C14N_OMIT_COMMENTS.equals(value))
                return C14N_OMIT_COMMENTS;
            else if (Transforms.TRANSFORM_C14N_WITH_COMMENTS.equals(value))
                return C14N_WITH_COMMENTS;
            else if (Transforms.TRANSFORM_C14N_EXCL_OMIT_COMMENTS.equals(value))
                return C14N_EXCL_OMIT_COMMENTS;
            else if (Transforms.TRANSFORM_C14N_EXCL_WITH_COMMENTS.equals(value))
                return C14N_EXCL_WITH_COMMENTS;
            else if (Transforms.TRANSFORM_C14N11_OMIT_COMMENTS.equals(value))
                return C14N11_OMIT_COMMENTS;
            else if (Transforms.TRANSFORM_C14N11_WITH_COMMENTS.equals(value))
                return C14N11_WITH_COMMENTS;
        }
        return UNKNOWN;
    }

}
