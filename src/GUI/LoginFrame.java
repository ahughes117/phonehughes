/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginFrame.java
 *
 * Created on 16 Μαρ 2011, 1:18:32 μμ
 */
package GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.MySqlConnector;
import phoneHughes.Credentials;
import sql.Connector;
import sql.EmbeddedConnector;
import utilities.ScriptReader;
import utilities.IOCredentials;
import utilities.MessageDialog;

/**
 *
 * @author Alex Hughes
 */
public class LoginFrame extends GUI {

    public static Credentials credentials;
    private static boolean loadCredentials = false;
    private char passwordc[];
    private MySqlConnector c;
    private EmbeddedConnector emC;

    /** Creates new form LoginFrame */
    public LoginFrame() {

        initComponents();

        IOCredentials.loadCredentials();
        if (loadCredentials) {
            loadCredentials();
        }
        
        mysqlR.setSelected(true);
        super.setFrameLocationCenter(this);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbGroup = new javax.swing.ButtonGroup();
        StatusPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passOKButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        rememberMeCheckBox = new javax.swing.JCheckBox();
        cancelButton = new javax.swing.JButton();
        setupDatabaseBtn = new javax.swing.JButton();
        mysqlR = new javax.swing.JRadioButton();
        embedR = new javax.swing.JRadioButton();
        databaseLabelPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        databaseTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Management  (Java - MySQL)");
        setMinimumSize(new java.awt.Dimension(428, 280));
        setName("LoginFrame"); // NOI18N

        StatusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Java - MySQL interface. Developed by Alex Hughes");

        javax.swing.GroupLayout StatusPanelLayout = new javax.swing.GroupLayout(StatusPanel);
        StatusPanel.setLayout(StatusPanelLayout);
        StatusPanelLayout.setHorizontalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        StatusPanelLayout.setVerticalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        usernameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameTextFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usernameTextFieldMousePressed(evt);
            }
        });
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyPressed(evt);
            }
        });

        jLabel5.setText("Username:");

        jLabel6.setText("Password:");

        passOKButton.setText("OK");
        passOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passOKButtonActionPerformed(evt);
            }
        });
        passOKButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passOKButtonKeyPressed(evt);
            }
        });

        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordFieldMousePressed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        rememberMeCheckBox.setText("Remember me");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        cancelButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelButtonKeyPressed(evt);
            }
        });

        setupDatabaseBtn.setText("Setup Database");
        setupDatabaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setupDatabaseBtnActionPerformed(evt);
            }
        });

        dbGroup.add(mysqlR);
        mysqlR.setText("MySQL DB");

        dbGroup.add(embedR);
        embedR.setText("Embedded DB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameTextField)
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(passOKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rememberMeCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(setupDatabaseBtn)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mysqlR)
                            .addComponent(embedR))
                        .addGap(73, 73, 73))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mysqlR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rememberMeCheckBox)
                    .addComponent(embedR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passOKButton)
                    .addComponent(setupDatabaseBtn))
                .addContainerGap())
        );

        usernameTextField.getAccessibleContext().setAccessibleName("usernameTextField");
        passwordField.getAccessibleContext().setAccessibleName("passwordTextField");

        jLabel7.setText("database url:");

        javax.swing.GroupLayout databaseLabelPanelLayout = new javax.swing.GroupLayout(databaseLabelPanel);
        databaseLabelPanel.setLayout(databaseLabelPanelLayout);
        databaseLabelPanelLayout.setHorizontalGroup(
            databaseLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databaseLabelPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        databaseLabelPanelLayout.setVerticalGroup(
            databaseLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databaseLabelPanelLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        databaseTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                databaseTextFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                databaseTextFieldMousePressed(evt);
            }
        });
        databaseTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                databaseTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StatusPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(databaseLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(databaseTextField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(databaseLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(databaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("CredentialsPanel");
        databaseTextField.getAccessibleContext().setAccessibleName("dbmsURLTextField");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void passOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passOKButtonActionPerformed
        okButton();
    }//GEN-LAST:event_passOKButtonActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            okButton();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void usernameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            okButton();
        }
    }//GEN-LAST:event_usernameTextFieldKeyPressed

    private void databaseTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_databaseTextFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            okButton();
        }
    }//GEN-LAST:event_databaseTextFieldKeyPressed

    private void passOKButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passOKButtonKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            okButton();
        }
    }//GEN-LAST:event_passOKButtonKeyPressed

private void databaseTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseTextFieldMouseClicked
    popupMenuField(databaseTextField);
}//GEN-LAST:event_databaseTextFieldMouseClicked

private void databaseTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseTextFieldMousePressed
    popupMenuField(databaseTextField);
}//GEN-LAST:event_databaseTextFieldMousePressed

private void usernameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameTextFieldMouseClicked
    popupMenuField(usernameTextField);
}//GEN-LAST:event_usernameTextFieldMouseClicked

private void usernameTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameTextFieldMousePressed
    popupMenuField(usernameTextField);
}//GEN-LAST:event_usernameTextFieldMousePressed

private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
}//GEN-LAST:event_passwordFieldMouseClicked

private void passwordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMousePressed
// TODO add your handling code here:
}//GEN-LAST:event_passwordFieldMousePressed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelButtonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonKeyPressed

    private void setupDatabaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setupDatabaseBtnActionPerformed
        setupDatabaseButton();
    }//GEN-LAST:event_setupDatabaseBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel databaseLabelPanel;
    private javax.swing.JTextField databaseTextField;
    private javax.swing.ButtonGroup dbGroup;
    private javax.swing.JRadioButton embedR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mysqlR;
    private javax.swing.JButton passOKButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox rememberMeCheckBox;
    private javax.swing.JButton setupDatabaseBtn;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

    private void getInfo() {

        passwordc = passwordField.getPassword();

        credentials = new Credentials(databaseTextField.getText(),
                usernameTextField.getText(), new String(passwordc));
    }

    public static void setCredentials(Credentials aCredentials) {
        credentials = aCredentials;
        loadCredentials = true;
    }

    private void loadCredentials() {
        databaseTextField.setText(credentials.getURL());
        usernameTextField.setText(credentials.getUsername());
        passwordField.setText(credentials.getPassword());
    }

    private void okButton() {
        boolean connectionSuccesfull;

        LoadingForm l = new LoadingForm();
        this.setVisible(false);

        getInfo();

        Connector c;
        boolean error = false;
        MainFrame mainFrame = null;

        try {
            if(mysqlR.isSelected())
                c = new MySqlConnector(credentials);
            else
                c = new EmbeddedConnector(credentials);

            if (rememberMeCheckBox.isSelected()) {
                IOCredentials.saveCredentials();
            }

            l.dispose();
            mainFrame = new MainFrame(this, c);

        } catch (SQLException ex) {
            error = true;
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            error = true;
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (error) {
            l.dispose();
            MessageDialog.conError(this);
            this.setVisible(true);
            if (mainFrame != null) {
                mainFrame.dispose();
            }
            credentials.clear();
        }
    }

    private void setupDatabaseButton() {
        String dbaseName = MessageDialog.addDatabaseDialog(this);
        String createDB;

        if (dbaseName != null && !dbaseName.equals("")) {
            try {

                getInfo();
                if(mysqlR.isSelected())
                    c = new MySqlConnector(credentials);
                else
                    c = new MySqlConnector(credentials);

                c.sendUpdate("CREATE SCHEMA " + dbaseName);
                c.sendUpdate("USE " + dbaseName);

                ScriptReader.parseScript();
                for (int i = 0; i < ScriptReader.getQueryNumber(); i++)
                    if(ScriptReader.getQuery(i) != null)
                        c.sendUpdate(ScriptReader.getQuery(i));
                

                MessageDialog.saveSuccess(this);
            } catch (SQLException ex) {
                MessageDialog.scriptFileError(this);
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                MessageDialog.programError(this);
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                MessageDialog.scriptFileError(this);
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (dbaseName != null && dbaseName.equals("")) {
            MessageDialog.validDatabaseError(this);
        }
    }
}
