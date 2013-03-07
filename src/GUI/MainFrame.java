/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Sep 24, 2011, 5:33:32 PM
 */
package GUI;

import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sql.Connector;
import utilities.Export;
import utilities.FixedQueries;
import utilities.IDCreator;
import utilities.MessageDialog;
import utilities.StringValidation;
import utilities.TableParser;

/**
 *
 * @author Alex Hughes
 */
public class MainFrame extends GUI {

    private GUI previousFrame;
    private Connector connector;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(GUI aPreviousFrame, Connector aConnector) {
        previousFrame = aPreviousFrame;
        connector = aConnector;

        initComponents();
        nameField.requestFocusInWindow();

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                shutdown();
            }
        });

        initGroupCombo();
        searchButton();
        super.setFrameLocationCenter(this);
        this.setVisible(true);
    }

    private void initGroupCombo() {
        ResultSet groupR;
        groupCombo.removeAllItems();
        try {
            groupR = connector.sendQuery(""
                    + "SELECT * "
                    + "FROM cGroup ");

            while (groupR.next()) {
                groupCombo.addItem(StringValidation.unCamouflageString(groupR.getString("GroupName")));
            }
            groupCombo.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        emailArea = new javax.swing.JTextArea();
        searchBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        phoneField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        groupCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        newGroupBtn = new javax.swing.JButton();
        editGroupBtn = new javax.swing.JButton();
        delGroupBtn = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exportItem = new javax.swing.JMenuItem();
        disconnectItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PhoneHughes v1.0 beta");

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Contact"));

        jLabel1.setText("name:");

        nameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameFieldMousePressed(evt);
            }
        });
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
        });

        jLabel2.setText("surname:");

        surnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surnameFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                surnameFieldMousePressed(evt);
            }
        });
        surnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                surnameFieldKeyPressed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Addresses: "));

        emailArea.setColumns(20);
        emailArea.setLineWrap(true);
        emailArea.setRows(5);
        emailArea.setWrapStyleWord(true);
        emailArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailAreaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                emailAreaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(emailArea);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        searchBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBtnKeyPressed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        editBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editBtnKeyPressed(evt);
            }
        });

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });
        newBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newBtnKeyPressed(evt);
            }
        });

        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });
        delBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                delBtnKeyPressed(evt);
            }
        });

        phoneField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phoneFieldMousePressed(evt);
            }
        });
        phoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneFieldKeyPressed(evt);
            }
        });

        jLabel3.setText("phone:");

        jLabel4.setText("email:");

        emailField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                emailFieldMousePressed(evt);
            }
        });
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFieldKeyPressed(evt);
            }
        });

        groupCombo.setEditable(true);

        jLabel5.setText("Group:");

        newGroupBtn.setText("new");
        newGroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGroupBtnActionPerformed(evt);
            }
        });

        editGroupBtn.setText("edit");
        editGroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGroupBtnActionPerformed(evt);
            }
        });

        delGroupBtn.setText("delete");
        delGroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delGroupBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailField)
                            .addComponent(surnameField)
                            .addComponent(nameField)
                            .addComponent(phoneField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(editBtn)
                        .addGap(14, 14, 14)
                        .addComponent(newBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delBtn)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupCombo, 0, 255, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(newGroupBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editGroupBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delGroupBtn)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newGroupBtn)
                    .addComponent(editGroupBtn)
                    .addComponent(delGroupBtn)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delBtn)
                            .addComponent(newBtn)
                            .addComponent(editBtn)
                            .addComponent(searchBtn)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fileMenu.setText("File");

        exportItem.setText("Export to Google");
        exportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportItem);

        disconnectItem.setText("Disconnect");
        disconnectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectItemActionPerformed(evt);
            }
        });
        fileMenu.add(disconnectItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        mainMenuBar.add(fileMenu);

        aboutMenu.setText("Help");

        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutItem);

        mainMenuBar.add(aboutMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void surnameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surnameFieldKeyPressed
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            searchButton();
        }
    }//GEN-LAST:event_surnameFieldKeyPressed

    private void phoneFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneFieldKeyPressed
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            searchButton();
        }
    }//GEN-LAST:event_phoneFieldKeyPressed

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyPressed
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            searchButton();
        }
    }//GEN-LAST:event_emailFieldKeyPressed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        searchButton();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        editButton();
    }//GEN-LAST:event_editBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        newButton();
    }//GEN-LAST:event_newBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        delButton();
    }//GEN-LAST:event_delBtnActionPerformed

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            searchButton();
        }
    }//GEN-LAST:event_nameFieldKeyPressed

    private void disconnectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectItemActionPerformed
        try {
            connector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        previousFrame.setVisible(true);
    }//GEN-LAST:event_disconnectItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        if (!AboutFrame.isInstanceAlive()) {
            new AboutFrame();
        }
    }//GEN-LAST:event_aboutItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        try {
            connector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void searchBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchButton();
        }
    }//GEN-LAST:event_searchBtnKeyPressed

    private void editBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            editButton();
        }
    }//GEN-LAST:event_editBtnKeyPressed

    private void newBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            newButton();
        }
    }//GEN-LAST:event_newBtnKeyPressed

    private void delBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_delBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            delButton();
        }
    }//GEN-LAST:event_delBtnKeyPressed

    private void nameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameFieldMouseClicked
        popupMenuField(nameField);
    }//GEN-LAST:event_nameFieldMouseClicked

    private void nameFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameFieldMousePressed
        popupMenuField(nameField);
    }//GEN-LAST:event_nameFieldMousePressed

    private void surnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surnameFieldMouseClicked
        popupMenuField(surnameField);
    }//GEN-LAST:event_surnameFieldMouseClicked

    private void surnameFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surnameFieldMousePressed
        popupMenuField(surnameField);
    }//GEN-LAST:event_surnameFieldMousePressed

    private void phoneFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneFieldMouseClicked
        popupMenuField(phoneField);
    }//GEN-LAST:event_phoneFieldMouseClicked

    private void phoneFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneFieldMousePressed
        popupMenuField(phoneField);
    }//GEN-LAST:event_phoneFieldMousePressed

    private void emailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailFieldMouseClicked
        popupMenuField(emailField);
    }//GEN-LAST:event_emailFieldMouseClicked

    private void emailFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailFieldMousePressed
        popupMenuField(emailField);
    }//GEN-LAST:event_emailFieldMousePressed

    private void emailAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailAreaMouseClicked
        popupMenuArea(emailArea);
    }//GEN-LAST:event_emailAreaMouseClicked

    private void emailAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailAreaMousePressed
        popupMenuArea(emailArea);
    }//GEN-LAST:event_emailAreaMousePressed

    private void newGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGroupBtnActionPerformed
        newGroupButton();
    }//GEN-LAST:event_newGroupBtnActionPerformed

    private void editGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGroupBtnActionPerformed
        editGroupButton();
    }//GEN-LAST:event_editGroupBtnActionPerformed

    private void delGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delGroupBtnActionPerformed
        delGroupButton();
    }//GEN-LAST:event_delGroupBtnActionPerformed

    private void exportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportItemActionPerformed
        try {
            Export ex = new Export(connector);
        } catch (IOException ex1) {
            MessageDialog.fileError(this);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (SQLException ex1) {
            MessageDialog.conError(this);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }//GEN-LAST:event_exportItemActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton delGroupBtn;
    private javax.swing.JMenuItem disconnectItem;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editGroupBtn;
    private javax.swing.JTextArea emailArea;
    private javax.swing.JTextField emailField;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem exportItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JComboBox groupCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton newGroupBtn;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField surnameField;
    // End of variables declaration//GEN-END:variables

    private void searchButton() {
        String query = buildSearchQuery("std");
        String emailQuery = buildSearchQuery("email");
        try {
            fillResults(query);
            fillEmails(emailQuery);
        } catch (SQLException ex) {
            MessageDialog.conError(this);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String buildSearchQuery(String aQueryType) {
        String joinS;

        if (aQueryType.equalsIgnoreCase("std")) {
            joinS = "SELECT c.ContactID, c.Name, c.Surname, e.EmailAddress, t.TelephoneNumber, c.Comments, c._dateModified ";
        } else {
            joinS = "SELECT DISTINCT e.EmailAddress ";
        }

        joinS += "FROM Contact c "
                + "LEFT JOIN ContactEmail ce ON c.ContactID = ce.ContactID "
                + "LEFT JOIN Email e ON ce.EmailID = e.EmailID "
                + "LEFT JOIN ContactTelephone ct ON c.ContactID = ct.ContactID "
                + "LEFT JOIN Telephone t ON ct.TelephoneID = t.TelephoneID "
                + "LEFT JOIN ContactGroup cg ON cg.ContactID = c.ContactID "
                + "LEFT JOIN cGroup g ON g.cGroupID = cg.GroupID ";

        String whereS = "WHERE 1=1 ";
        if (!nameField.getText().equals("")) {
            whereS += "AND c.Name LIKE '%" + StringValidation.camouflageString(nameField.getText()) + "%' ";
        }
        if (!surnameField.getText().equals("")) {
            whereS += "AND c.Surname LIKE '%" + StringValidation.camouflageString(surnameField.getText()) + "%' ";
        }
        if (!phoneField.getText().equals("")) {
            whereS += "AND t.TelephoneNumber LIKE '%" + StringValidation.camouflageString(phoneField.getText()) + "%' ";
        }
        if (!emailField.getText().equals("")) {
            whereS += "AND e.EmailAddress LIKE '%" + StringValidation.camouflageString(emailField.getText()) + "%' ";
        }
        if (groupCombo.getSelectedIndex() != -1 && !groupCombo.getSelectedItem().equals("")) {
            whereS += "AND g.GroupName LIKE '%" + StringValidation.camouflageString((String) groupCombo.getSelectedItem()) + "%' ";
        }

        String groupS;
        if (aQueryType.equalsIgnoreCase("std")) {
            groupS = "GROUP BY c.ContactID ";
        } else {
            groupS = "";
        }

        return (joinS + whereS + groupS);
    }

    private void fillResults(String aQuery) throws SQLException {
        TableParser.fillTable(aQuery, resultTable, connector);
    }

    private void fillEmails(String aQuery) throws SQLException {
        int counter = 0;
        String emailS = "";
        ResultSet emailR = connector.sendQuery(aQuery);

        while (emailR.next()) {
            emailS += emailR.getString(1) + "; ";
            counter++;
        }
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Addresses: " + counter));
        emailArea.setText(emailS);
    }

    private void editButton() {
        int contactID = TableParser.checkRowsAndGetID(resultTable, this);

        if (contactID != -1) {
            new ContactFrame(this, connector, contactID);
            this.setVisible(false);
        }
    }

    private void newButton() {
        ContactFrame f = new ContactFrame(this, connector);
        this.setVisible(false);
    }

    private void delButton() {
        int answer = MessageDialog.deleteQuestion(this);

        if (answer == JOptionPane.YES_OPTION) {
            int contactID = TableParser.checkRowsAndGetID(resultTable, this);
            try {
                FixedQueries.deleteContact(connector, contactID);
                searchButton();
            } catch (SQLException ex) {
                MessageDialog.conError(this);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void newGroupButton() {
        boolean loopFlag = false;
        String groupName;
        int groupID = -1;
        ArrayList<String> comboNames = new ArrayList<String>();

        groupName = MessageDialog.addGroupDialog(this);

        if (groupName != null && !groupName.equals("")) {

            for (int i = 0; i < groupCombo.getItemCount(); i++) {
                comboNames.add((String) groupCombo.getItemAt(i));
            }

            groupName = StringValidation.camouflageString(groupName);
            if (!StringValidation.hasDuplicates(comboNames, groupName)) {
                try {
                    groupID = IDCreator.createID(connector, "cGroup");
                    connector.sendUpdate(""
                            + "INSERT INTO `cGroup` (`cGroupID`, `GroupName`) VALUES "
                            + "(" + groupID + ", '" + groupName + "') ");
                    initGroupCombo();
                    loopFlag = true;
                } catch (SQLException ex) {
                    MessageDialog.conError(this);
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                MessageDialog.duplicateError(this);
            }

        }
    }

    private void editGroupButton() {
        String groupName;
        int groupID;

        if (!hasSelectedGroup(groupCombo)) {
            MessageDialog.selectGroupError(this);
        } else {
            groupName = (String) groupCombo.getSelectedItem();
            try {
                groupID = getGroupID(groupName);
                if (groupID == -1) {
                    MessageDialog.validGroupError(this);
                } else {
                    new GroupContactFrame(this, connector, groupID);
                }
            } catch (SQLException ex) {
                MessageDialog.selectGroupError(this);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void delGroupButton() {
        String groupName;
        int answer;

        //no negative logic used here. Heh
        if (!hasSelectedGroup(groupCombo)) {
            MessageDialog.selectGroupError(this);
        } else {
            answer = MessageDialog.deleteQuestion(this);
            if (answer == JOptionPane.YES_OPTION) {
                groupName = (String) groupCombo.getSelectedItem();
                try {
                    connector.sendUpdate(""
                            + "DELETE FROM cGroup "
                            + "WHERE GroupName = '" + groupName + "' ");
                } catch (SQLException ex) {
                    MessageDialog.conError(this);
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                initGroupCombo();
            }
        }
    }

    private int getGroupID(String aGroupName) throws SQLException {
        int groupID = -1;
        int fetchCounter = 0;

        ResultSet groupR = connector.sendQuery(""
                + "SELECT cGroupID "
                + "FROM cGroup "
                + "WHERE GroupName = '" + aGroupName + "'");

        while (groupR.next()) {
            groupID = groupR.getInt(1); //only 1 column in select stmt
            fetchCounter++;
        }

        if (fetchCounter != 1) {
            groupID = -1;
        }

        return groupID;
    }

    private boolean hasSelectedGroup(JComboBox aCombo) {
        boolean hasSelected;

        if (aCombo.getSelectedIndex() == -1 || aCombo.getSelectedItem() == null) {
            hasSelected = false;
        } else {
            hasSelected = true;
        }
        return hasSelected;
    }

    private void shutdown() {
        try {
            connector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
}
