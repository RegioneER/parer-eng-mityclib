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
package es.mityc.javasign.xml.transform;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * <p>
 * Guarda informacion sobre una transformada que se va a aplicar a un objeto a firmar.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class Transform {

    /** Algoritmo de la transformada. */
    private String algorithm;
    /** Generador de la informacion extra de la transformada. */
    private ITransformData data;

    /**
     * <p>
     * Construye una transformada general con el algoritmo indicado.
     * </p>
     * 
     * @param alg
     *            Algoritmo de la transformada
     * @param extraData
     *            Generador de los nodos de informacion extra, <code>null</code> si no hay informacion extra para la
     *            transformada
     */
    public Transform(String alg, ITransformData extraData) {
        this.algorithm = alg;
        this.data = extraData;
    }

    /**
     * <p>
     * Establece el generador de los nodos de informacion extra.
     * </p>
     * 
     * @param extraData
     */
    protected void setTransformData(ITransformData extraData) {
        this.data = extraData;
    }

    /**
     * <p>
     * Devuelve el algoritmo de la transformada.
     * </p>
     * 
     * @return the algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * <p>
     * Devuelve el listado de nodos de informacion extra que necesita la transformada.
     * </p>
     * 
     * @param doc
     *            Documento en el que ira la transformada
     * 
     * @return listado de nodos
     */
    public NodeList getExtraData(Document doc) {
        NodeList nl = null;
        if (data != null) {
            nl = data.getExtraData(doc);
        }
        return nl;
    }

}
