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
 * 51 Franklin Street, 5º Piso, Boston, MA 02110-1301, USA o consulte
 * <http://www.gnu.org/licenses/>.
 *
 * Copyright 2008 Ministerio de Industria, Turismo y Comercio
 * 
 */

package es.mityc.javasign.pkstore;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import es.mityc.javasign.ConstantsAPI;
import es.mityc.javasign.i18n.I18nFactory;
import es.mityc.javasign.i18n.II18nManager;

/**
 * <p>
 * Dialogo para la peticion de contraseña de acceso a un dispositivo seguro.
 * </p>
 * 
 * @author Ministerio de Industria, Turismo y Comercio
 * 
 * @version 1.0
 */

class PINDialog {

    /** Internacionalizador. */
    private static final II18nManager I18N = I18nFactory.getI18nManager(ConstantsAPI.LIB_NAME);
    /** Estado de cancelacion del dialog. */
    private boolean cancelado = false;
    /** Enlace al dialogo de peticion de contraseña. */
    protected JDialog dialog = null;
    /** Etiqueta del mensaje de introduccion de PIN. */
    protected JLabel lblMessage = null;
    /** Boton para cancelar. */
    JButton cancelar = null;

    /** Accion de aceptar la contraseña introducida. */
    private static final String STR_OK = "OK";
    /** Accion de cancelar la contraseña introducida. */
    private static final String STR_CLOSE = "CLOSE";
    /** Ancho de la ventana de peticion de PIN. */
    private static final int DEFAULT_WIDTH = 300;
    /** Alto de la ventana de peticion de PIN. */
    private static final int DEFAULT_HEIGHT = 300;
    /** Icono por defecto del díalogo. */
    private static final String PIN_ICON = "/es/mityc/javasign/pkstore/Images/Candado.png";

    /**
     * <p>
     * Caja de texto del password para Proxy con autenticacion.
     * </p>
     */
    private JPasswordField pass = null;

    /**
     * <p>
     * Crea el dialogo y lo inicializa.
     * </p>
     * 
     * @param owner
     *            Frame padre del dialogo
     */
    public PINDialog(final Frame owner) {
        dialog = new JDialog(owner, I18N.getLocalMessage(ConstantsAPI.I18N_CERT_SMR_CARD_TITLE), true);
        dialogInit();
    }

    /**
     * <p>
     * Inicializa el dialogo con los datos configurados.
     * </p>
     */
    protected void dialogInit() {
        try {
            JPanel distr = new JPanel();
            JButton aceptar = new JButton(I18N.getLocalMessage(ConstantsAPI.I18N_CERT_SMR_CARD_ACCEPT));
            cancelar = new JButton(I18N.getLocalMessage(ConstantsAPI.I18N_CERT_SMR_CARD_CANCEL));

            aceptar.setActionCommand(STR_OK);
            cancelar.setActionCommand(STR_CLOSE);

            pass = new JPasswordField(15);
            distr.setLayout(new GridBagLayout());
            dialog.setResizable(false);

            lblMessage = new JLabel(I18N.getLocalMessage(ConstantsAPI.I18N_CERT_SMR_CARD_PIN));
            lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
            lblMessage.setIcon(new ImageIcon(this.getClass().getResource(PIN_ICON)));
            lblMessage.setHorizontalTextPosition(JLabel.RIGHT);
            lblMessage.setIconTextGap(10);

            // Layout
            GridBagConstraints g = new GridBagConstraints();
            g.gridx = 0;
            g.gridy = 0;
            g.gridwidth = 4;
            g.insets = new Insets(10, 20, 5, 20);
            distr.add(lblMessage, g);

            g.gridx = 0;
            g.gridy = 1;
            g.gridwidth = 4;
            g.fill = GridBagConstraints.HORIZONTAL;
            g.weightx = 1.0;
            g.insets = new Insets(10, 35, 5, 35);
            distr.add(pass, g);

            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new FlowLayout(SwingConstants.CENTER, 50, 5));
            btnPanel.add(aceptar);
            btnPanel.add(cancelar);

            g = new GridBagConstraints();
            g.gridx = 0;
            g.gridy = 2;
            g.gridwidth = 4;
            g.anchor = GridBagConstraints.CENTER;
            g.insets = new Insets(15, 0, 15, 0);
            distr.add(btnPanel, g);

            distr.doLayout();
            dialog.add(distr);
            dialog.setResizable(false);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.getRootPane().setDefaultButton(aceptar);
            dialog.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation(screenSize.width / 2 - dialog.getWidth() / 2,
                    screenSize.height / 2 - dialog.getHeight() / 2);

            aceptar.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    if (e.getActionCommand().equals(STR_OK)) {
                        dialog.setVisible(false);
                    }
                }
            });

            cancelar.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    if (e.getActionCommand().equals(STR_CLOSE)) {
                        cancelado = true;
                        dialog.setVisible(false);
                    }
                }
            });
        } catch (Exception e) {
            // Nunca se produce
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Establece un título para la ventana de peticion de contraseña.
     * </p>
     * 
     * @param newTitle
     *            Nuevo título
     */
    public void setTitle(final String newTitle) {
        dialog.setTitle(new String(newTitle));
    }

    /**
     * <p>
     * Establece el mensaje de peticion de PIN.
     * </p>
     * 
     * @param newMessage
     *            Nuevo mensaje
     */
    public void setPINMessage(final String newMessage) {
        lblMessage.setText(new String(newMessage));
    }

    /**
     * <p>
     * Establece el icono que sera mostrado junto con el mensaje de peticion de PIN.
     * </p>
     * 
     * @param icon
     *            Icono a mostrar.
     */
    public void setIcon(final ImageIcon icon) {
        lblMessage.setIcon(icon);
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
        cancelar.setVisible(isVisible);
        pack();
    }

    /**
     * <p>
     * Ajusta los elementos graficos.
     * </p>
     */
    public void pack() {
        dialog.pack();
    }

    /**
     * <p>
     * Hace visible el dialogo de consulta.
     * </p>
     * 
     * @param flag
     *            si es <code>true</code> inicializa los valores introducidos previamente
     */
    public void setVisible(final boolean flag) {
        if (flag) {
            cancelado = false;
            pass.setText("");
        }
        dialog.setVisible(flag);
    }

    /**
     * <p>
     * Devuelve la última contraseña introducida en el dialogo.
     * </p>
     * 
     * @return Contraseña
     */
    public char[] getPassword() {
        return pass.getPassword();
    }

    /**
     * <p>
     * Libera el dialogo utilizado para pedir datos.
     * </p>
     */
    public void dispose() {
        dialog.dispose();
    }

    /**
     * <p>
     * Indica si la última accion en el dialogo fue la de cancelar el intento de acceso.
     * </p>
     * 
     * @return <code>true</code> si el último intento se cancelo, <code>false</code> en otro caso
     */
    public boolean isCancelado() {
        return cancelado;
    }

    /**
     * <p>
     * Devuelve el ancho del dialogo.
     * </p>
     * 
     * @return el ancho del dialogo
     */
    public int getWidth() {
        if (dialog != null) {
            return dialog.getWidth();
        } else {
            return 0;
        }
    }

    /**
     * <p>
     * Devuelve el alto del dialogo.
     * </p>
     * 
     * @return el alto del dialogo
     */
    public int getHeight() {
        if (dialog != null) {
            return dialog.getHeight();
        } else {
            return 0;
        }
    }

    /**
     * <p>
     * Coloca la esquina superior izquierda del dialogo en las coordenadas (x,y).
     * </p>
     * 
     * @param x
     *            Coordenada horizontal expresada en pixels
     * @param y
     *            Coordenada vertical expresada en pixels.
     */
    public void setLocation(final int x, final int y) {
        if (dialog != null) {
            dialog.setLocation(x, y);
        }
    }
}
