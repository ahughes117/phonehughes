/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Alex Hughes
 */
public class GUI extends JFrame {
    
    private GUI previousFrame;
    
    public static void setFrameLocationCenter(JFrame aFrame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = aFrame.getSize();

        int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
        int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);

        aFrame.setLocation(windowX, windowY);  // Don't use "f." inside constructor.
    }
    
    public void reloadInfoTable()throws SQLException {
        
    }
    
    public void popupMenuField(JTextField aTf) {

        JPopupMenu popupMenu = new JPopupMenu();
        ActionListener actionListener = new PopupActionListener(aTf);
        // Cut
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(actionListener);
        popupMenu.add(cutMenuItem);
        // Copy
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(actionListener);
        popupMenu.add(copyMenuItem);
        // Paste
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(actionListener);
        popupMenu.add(pasteMenuItem);

        aTf.setComponentPopupMenu(popupMenu);
    }

    public void popupMenuArea(JTextArea aTa) {

        JPopupMenu popupMenu = new JPopupMenu();
        ActionListener actionListener = new PopupActionListener(aTa);
        // Cut
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(actionListener);
        popupMenu.add(cutMenuItem);
        // Copy
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(actionListener);
        popupMenu.add(copyMenuItem);
        // Paste
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(actionListener);
        popupMenu.add(pasteMenuItem);

        aTa.setComponentPopupMenu(popupMenu);
    }
}

class PopupActionListener implements ActionListener {
    
    private JTextField tf;
    private JTextArea ta;

    public PopupActionListener(JTextField Tf) {
        tf = Tf;
    }

    public PopupActionListener(JTextArea Ta) {
        ta = Ta;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Cut")) {
            if (tf != null) {
                tf.cut();
            } else {
                ta.cut();
            }
        }
        if (actionEvent.getActionCommand().equals("Copy")) {
            if (tf != null) {
                tf.copy();
            } else {
                ta.copy();
            }
        }

        if (actionEvent.getActionCommand().equals("Paste")) {
            
            if (tf != null) {
                tf.paste();
            } else {
                ta.paste();
            }
        }
    }
}
