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
package es.mityc.javasign.pkstore;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.cert.X509Certificate;

import javax.swing.ImageIcon;

import es.mityc.javasign.ConstantsAPI;
import es.mityc.javasign.i18n.I18nFactory;
import es.mityc.javasign.i18n.II18nManager;

/**
 * <p>
 * Proporciona un mecanismo por defecto para mostrar una ventana que pida al usuario la contraseña de acceso a un
 * certificado ubicado en un dispositivo seguro.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */
public class DefaultPassStoreKS implements IPassStoreKS {

    /** Internacionalizador. */
    private static final II18nManager I18N = I18nFactory.getI18nManager(ConstantsAPI.LIB_NAME);

    /** Título de la ventana de peticion de contraseña. */
    private String titleDialog = I18N.getLocalMessage(ConstantsAPI.I18N_CERT_SMR_CARD_TITLE);

    /** Título de la ventana de peticion de contraseña. */
    private String pinMessage = I18N.getLocalMessage(ConstantsAPI.I18N_CERT_SMR_CARD_PIN);

    /** Instancia de la ventana de dialogo para la peticion de contraseña. */
    private PINDialog pinDialog = null;

    /**
     * <p>
     * Muestra una ventana de dialogo para que el usuario introduzca una contraseña de acceso a un certificado ubicado
     * en un dispositivo seguro.
     * </p>
     * 
     * @param certificate
     *            Certificado al que se accede
     * @param alias
     *            Alias del certificado al que se accede
     * 
     * @return contraseña (PIN)
     */
    public char[] getPassword(final X509Certificate certificate, final String alias) {
        pinDialog = new PINDialog(null);
        processData(certificate, alias);
        pinDialog.setTitle(getTitle());
        pinDialog.setPINMessage(getPINMessage());
        pinDialog.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pinDialog.setLocation(screenSize.width / 2 - pinDialog.getWidth() / 2,
                screenSize.height / 2 - pinDialog.getHeight() / 2);
        pinDialog.setVisible(true);

        char[] pass = new char[0];
        if (!pinDialog.isCancelado()) {
            pass = pinDialog.getPassword();
        }
        pinDialog.dispose();

        return pass;
    }

    /**
     * <p>
     * Establece el icono que sera mostrado junto con el mensaje de peticion de PIN.
     * </p>
     * <p>
     * Este método se mantiene para facilitar la gestion de hijos sobre la informacion a mostrar. Sobreescribiéndolo se
     * puede preparar un dialogo adecuado al caso.
     * </p>
     * 
     * @param icon
     *            Icono a mostrar.
     */
    public void setIcon(final ImageIcon icon) {
        pinDialog.setIcon(icon);
    }

    /**
     * <p>
     * Establece el icono que sera mostrado junto con el mensaje de peticion de PIN.
     * </p>
     * 
     * @param isVisible
     *            <code>false</code> para hacer el boton invisible
     */
    public void setCancelBtnVisible(final boolean isVisible) {
        pinDialog.setCancelBtnVisible(isVisible);
    }

    /**
     * <p>
     * Procesa la informacion sobre el certificado del que se pide el acceso.
     * </p>
     * <p>
     * Este método se mantiene para facilitar la gestion de hijos sobre la informacion a mostrar. Sobreescribiéndolo se
     * puede preparar un título de ventana relacionado con los datos provistos.
     * </p>
     * 
     * @param certificate
     *            certificado del que se pide el acceso
     * @param alias
     *            Alias del certificado
     */
    protected void processData(final X509Certificate certificate, final String alias) {

    }

    /**
     * <p>
     * Permite indicar un título a la ventana de peticion de contraseña.
     * </p>
     * 
     * @param title
     *            Título de la ventana
     */
    public void setTitle(final String title) {
        this.titleDialog = new String(title);
    }

    /**
     * <p>
     * Devuelve el título configurado para la ventana de peticion de contraseña.
     * </p>
     * 
     * @return Título de la ventana
     */
    public String getTitle() {
        return titleDialog;
    }

    /**
     * <p>
     * Establece el mensaje de introduccion de PIN.
     * </p>
     * 
     * @param message
     *            nuevo mensage
     */
    public void setPINMessage(final String message) {
        this.pinMessage = new String(message);
    }

    /**
     * <p>
     * Devuelve el mensaje de PIN introducido.
     * </p>
     * 
     * @return mensaje de PIN
     */
    public String getPINMessage() {
        return pinMessage;
    }

}
