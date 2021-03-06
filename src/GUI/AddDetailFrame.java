/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddDetailFrame.java
 *
 * Created on Sep 28, 2011, 9:11:35 PM
 */
package GUI;

import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import sql.Connector;
import sql.MySqlConnector;
import utilities.*;

/**
 *
 * @author Alex Hughes
 */
public class AddDetailFrame extends GUI {

    private static boolean instanceAlive = false; /*use it for not letting another detail frame to 
     *be initiated before inserting id of this one in dbase*/

    private GUI previousFrame;
    private Connector connector;
    private String category;
    //
    private int contactID;
    private int detailID;
    //
    private boolean newDetail;

    /** Creates new form AddDetailFrame || Constructor for NEW Detail Frame*/
    public AddDetailFrame(GUI aPreviousFrame, Connector aConnector, String aCategory, int aContactID) {
        previousFrame = aPreviousFrame;
        connector = aConnector;
        category = aCategory;
        contactID = aContactID;

        instanceAlive = true; //id has not been inserted in dbase
        newDetail = true;

        initComponents();
        detailTypeLabel.setText(category);

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });

        try {
            detailID = IDCreator.createID(connector, category); //creating the ID for the new category
        } catch (SQLException ex) {
            MessageDialog.conError(this);
            Logger.getLogger(AddDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.setFrameLocationCenter(this);
        this.setVisible(true);
    }

    //Constructor for EXISTING Detail Frame
    public AddDetailFrame(GUI aPreviousFrame, Connector aConnector, String aCategory, int aContactID, int aDetailID) {
        previousFrame = aPreviousFrame;
        connector = aConnector;
        category = aCategory;
        contactID = aContactID;
        detailID = aDetailID;

        instanceAlive = false; //id is already inserted in dbase
        newDetail = false;

        initComponents();
        detailTypeLabel.setText(category);

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });

        try {
            loadFields();   //sending the query and getting the results
        } catch (SQLException ex) {
            MessageDialog.conError(this);
            Logger.getLogger(AddDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.setFrameLocationCenter(this);
        this.setVisible(true);
    }

    private void loadFields() throws SQLException {
        ResultSet detailsR = connector.sendQuery(""
                + "SELECT * "
                + "FROM " + category
                + " WHERE " + category + "ID = " + detailID);

        while (detailsR.next()) {
            detailField.setText(StringValidation.unCamouflageString(detailsR.getString(2)));
            commentArea.setText(StringValidation.unCamouflageString(detailsR.getString("Comments")));
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        detailTypeLabel = new javax.swing.JLabel();
        detailField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        detailField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                detailFieldMousePressed(evt);
            }
        });
        detailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                detailFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailField, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comments"));

        commentArea.setColumns(20);
        commentArea.setLineWrap(true);
        commentArea.setRows(5);
        commentArea.setWrapStyleWord(true);
        commentArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentAreaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                commentAreaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(commentArea);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeFrame();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        commitButton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void detailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailFieldMouseClicked
        popupMenuField(detailField);
    }//GEN-LAST:event_detailFieldMouseClicked

    private void detailFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailFieldMousePressed
        popupMenuField(detailField);
    }//GEN-LAST:event_detailFieldMousePressed

    private void commentAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentAreaMouseClicked
        popupMenuArea(commentArea);
    }//GEN-LAST:event_commentAreaMouseClicked

    private void commentAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentAreaMousePressed
        popupMenuArea(commentArea);
    }//GEN-LAST:event_commentAreaMousePressed

    private void detailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detailFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            commitButton();
        }
    }//GEN-LAST:event_detailFieldKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commentArea;
    private javax.swing.JTextField detailField;
    private javax.swing.JLabel detailTypeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    // a bit hard coded but no need to soft code it according to my own requirements for the programme
    private void commitButton() {
        boolean parseSuccesfull;
        String detail = detailField.getText();
        String comments = commentArea.getText();

        parseSuccesfull = lengthValidation(detail, comments);

        if (parseSuccesfull) {
            detail = StringValidation.camouflageString(detail);
            comments = StringValidation.camouflageString(comments);
            try {
                if (newDetail) {    //inserting the new id
                    connector.sendUpdate("INSERT INTO `" + category + "` (`" + category + "ID`) "
                            + "VALUES (" + detailID + ")");

                    int ID = IDCreator.createID(connector, "Contact" + category);
                    connector.sendUpdate("" //making the correlation
                            + "INSERT INTO `Contact" + category + "` (`Contact" + category + "ID`, `ContactID`, `" + category + "ID`) VALUES "
                            + "(" + ID + ", " + contactID + ", " + detailID + ") ");

                    instanceAlive = false;
                    newDetail = false;
                }

                if (category.equals("Email")) {
                    connector.sendUpdate("" //filling info
                            + "UPDATE Email SET EmailAddress = '" + detail + "', "
                            + "Comments = '" + comments + "' "
                            + "WHERE EmailID = " + detailID);
                } else {
                    connector.sendUpdate("" //filling info
                            + "UPDATE Telephone SET TelephoneNumber = '" + detail + "', "
                            + "Comments = '" + comments + "' "
                            + "WHERE TelephoneID = " + detailID);
                }
                previousFrame.reloadInfoTable();
                closeFrame();
            } catch (SQLException x) {
                MessageDialog.conError(this);
                Logger.getLogger(AddDetailFrame.class.getName()).log(Level.SEVERE, null, x);
            }
        } else {
            MessageDialog.stringError(this);
        }

    }

    private boolean lengthValidation(String aDetail, String aComments) {
        boolean p1, p2;

        if (category.equals("Email")) {
            p1 = StringValidation.validStringLength(aDetail, 100);
        } else {
            p1 = StringValidation.validStringLength(aDetail, 45);
        }
        p2 = StringValidation.validStringLength(aComments, 200);

        return (p1 && p2);
    }

    public static boolean isInstanceAlive() {
        return instanceAlive;
    }

    private void closeFrame() {
        instanceAlive = false;
        this.dispose();
    }
}
