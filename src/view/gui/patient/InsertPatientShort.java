/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gui.patient;

import java.sql.Date;
import javax.swing.JOptionPane;
import models.classes.patient.BasicComplaints;
import models.classes.patient.ContactDetailsAddress;
import models.classes.patient.ContactDetailsContact;
import models.classes.patient.ImportantMedicalComplaints;
import models.classes.patient.Lifestyle;
import models.classes.patient.NextOfKin;
import models.classes.patient.PatientShort;
import models.classes.patient.PersonalDetails;
import models.classes.patient.ProffesionDetails;
import models.repo.Repository;

/**
 *
 * @author amd
 */
public class InsertPatientShort extends javax.swing.JFrame {

    /**
     * Creates new form InsertPatientShort
     */
    Repository repo = new Repository();

    public InsertPatientShort() {
        super("Virgo Hospital - Insert short patient");
        initComponents();
        rbtnMale.setSelected(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private ContactDetailsAddress generateContactDetailsAddress() throws Exception {
        ContactDetailsAddress address = new ContactDetailsAddress();

        address.setArea("-");
        address.setCity("-");
        address.setDoorNumber("-");
        address.setPincode("-");
        address.setState("-");
        address.setStreet("-");

        address.setIdContactDetailsAddress(repo.insertContactDetailsAddress(
                repo.getSource(),
                address.getDoorNumber(),
                address.getStreet(),
                address.getArea(),
                address.getCity(),
                address.getState(),
                address.getPincode()));

        return address;
    }

    private ContactDetailsContact generateContactDetailsContact() throws Exception {
        ContactDetailsContact contact = new ContactDetailsContact();

        contact.setEmail("-");
        contact.setFax("-");
        contact.setPager("-");
        contact.setTelephoneHome("-");
        contact.setTelephoneMobile("-");
        contact.setTelephoneWork("-");

        contact.setIdContactDetailsContact(repo.insertContactDetailsContact(
                repo.getSource(),
                contact.getTelephoneWork(),
                contact.getTelephoneHome(),
                contact.getTelephoneMobile(),
                contact.getPager(),
                contact.getFax(),
                contact.getEmail()));

        return contact;
    }

    private ImportantMedicalComplaints generateImportantMedicalComplaints() throws Exception {
        ImportantMedicalComplaints importantComplaints = new ImportantMedicalComplaints();

        importantComplaints.setCardiacCondition("-");
        importantComplaints.setDigestiveCondition("-");
        importantComplaints.setOrthopedicCondition("-");
        importantComplaints.setMuscularCondition("-");
        importantComplaints.setNeurologicalCondition("-");
        importantComplaints.setKnownAllegries("-");
        importantComplaints.setKnownReactionToDrugs("-");
        importantComplaints.setMajorSurgeries("-");

        importantComplaints.setIdImportantMedicalComplaints(
                repo.insertImportantMedicalComplaints(
                        repo.getSource(),
                        false,
                        false,
                        importantComplaints.getCardiacCondition(),
                        importantComplaints.getDigestiveCondition(),
                        importantComplaints.getOrthopedicCondition(),
                        importantComplaints.getMuscularCondition(),
                        importantComplaints.getNeurologicalCondition(),
                        importantComplaints.getKnownAllegries(),
                        importantComplaints.getKnownReactionToDrugs(),
                        importantComplaints.getMajorSurgeries())
        );
        return importantComplaints;
    }

    private BasicComplaints generateBasicComplaints() throws Exception {
        BasicComplaints basicComplaints = new BasicComplaints();

        basicComplaints.setHistoryOfPreviousTreatment("-");
        basicComplaints.setPhysicianOrHospital("-");
        basicComplaints.setStatementOfComplaint("-");

        basicComplaints.setIdBasicComplaints(repo.insertBasicComplaints(repo.getSource(),
                basicComplaints.getStatementOfComplaint(),
                basicComplaints.getHistoryOfPreviousTreatment(),
                basicComplaints.getPhysicianOrHospital()));
        return basicComplaints;
    }

    private Lifestyle generateLifestyleDetails() throws Exception {
        Lifestyle lifestyle = new Lifestyle();
        lifestyle.setUseStimulants("-");
        lifestyle.setIdLifestyle(repo.insertLifestyle(repo.getSource(),
                false, 0, false, 0, lifestyle.getUseStimulants(), 0, 0, false, false, false));
        return lifestyle;
    }

    private ProffesionDetails generateProffessionDetails() throws Exception {
        ProffesionDetails professionDetails = new ProffesionDetails();

        professionDetails.setGrossAnnualIncome(0);
        professionDetails.setOccupation("-");

        professionDetails.setIdProffessionDetails(repo.insertProffessionDetails(
                repo.getSource(),
                professionDetails.getOccupation(),
                professionDetails.getGrossAnnualIncome()));
        return professionDetails;
    }

    private PersonalDetails generatePersonalDetails() throws Exception {
        PersonalDetails personalDetails = new PersonalDetails();

        personalDetails.setBloodType("-");
        personalDetails.setHeight("-");
        personalDetails.setMaritalStatus("-");
        personalDetails.setNumberOfDependents("-");
        personalDetails.setWeight("-");

        personalDetails.setIdPersonalDetails(repo.insertPersonalDetails(
                repo.getSource(),
                personalDetails.getMaritalStatus(),
                personalDetails.getNumberOfDependents(),
                personalDetails.getHeight(),
                personalDetails.getWeight(),
                personalDetails.getBloodType()));
        return personalDetails;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSexGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtMiddlename = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhone1 = new javax.swing.JTextField();
        txtPhone2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStatementOfComplaint = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNokName = new javax.swing.JTextField();
        txtNokSurname = new javax.swing.JTextField();
        txtNokMiddlename = new javax.swing.JTextField();
        txtNokRelationship = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic details"));

        jLabel1.setText("Name:");

        jLabel2.setText("Surname:");

        jLabel3.setText("Middlename:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Sex:");

        btnSexGroup.add(rbtnMale);
        rbtnMale.setText("Male");

        btnSexGroup.add(rbtnFemale);
        rbtnFemale.setText("Female");

        jLabel5.setText("Phone 1:");

        jLabel6.setText("Phone 2:");

        jLabel7.setText("Statement of complaint:");

        txtStatementOfComplaint.setColumns(20);
        txtStatementOfComplaint.setRows(5);
        jScrollPane1.setViewportView(txtStatementOfComplaint);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName)
                                    .addComponent(txtSurname)
                                    .addComponent(txtMiddlename)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rbtnMale)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtnFemale))
                                    .addComponent(txtPhone1)
                                    .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(rbtnMale)
                        .addComponent(rbtnFemale))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Next of kin"));
        jPanel2.setToolTipText("");

        jLabel8.setText("Name:");

        jLabel9.setText("Surname:");

        jLabel10.setText("Middlename:");

        jLabel11.setText("Relationship:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNokName)
                    .addComponent(txtNokSurname)
                    .addComponent(txtNokMiddlename)
                    .addComponent(txtNokRelationship, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNokName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNokSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNokMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNokRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 109, Short.MAX_VALUE)
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnInsert)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            NextOfKin nok = new NextOfKin();
            nok.setName(txtNokName.getText().trim());
            nok.setSurname(txtNokSurname.getText().trim());
            nok.setMiddlename(txtNokMiddlename.getText().trim());
            nok.setRelationship(txtNokRelationship.getText().trim());
            nok.setAddressDetails(generateContactDetailsAddress());
            nok.setContactDetails(generateContactDetailsContact());
            nok.setIdNextOfKin(repo.insertNextOfKin(repo.getSource(),
                    nok.getName(),
                    nok.getSurname(),
                    nok.getMiddlename(),
                    nok.getRelationship(),
                    generateContactDetailsContact().getIdContactDetailsContact(),
                    generateContactDetailsAddress().getIdContactDetailsAddress()));

            PatientShort temp = new PatientShort();
            temp.setName(txtName.getText().trim());
            temp.setSurname(txtSurname.getText().trim());
            temp.setMiddlename(txtMiddlename.getText().trim());
            temp.setContact_1(txtPhone1.getText().trim());
            temp.setContact_2(txtPhone2.getText().trim());
            temp.setSex(rbtnMale.isSelected() ? "M" : "F");
            temp.setIsFollowUp(false);
            temp.setNextOfKin(nok);
            temp.setStatementOfComplaint(txtStatementOfComplaint.getText().trim());

            temp.setIdPatient(repo.insertPatient(repo.getSource(),
                    temp.getName(),
                    temp.getSurname(),
                    temp.getMiddlename(),
                    temp.getSex(),
                    temp.getStatementOfComplaint(),
                    temp.getContact_1(),
                    temp.getContact_2(),
                    temp.getNextOfKin().getIdNextOfKin(),
                    temp.isIsFollowUp()));

            repo.insertPatientFull(repo.getSource(),
                    temp.getIdPatient(),
                    new Date(0),
                    generateContactDetailsAddress().getIdContactDetailsAddress(),
                    generateContactDetailsAddress().getIdContactDetailsAddress(),
                    generatePersonalDetails().getIdPersonalDetails(),
                    generateProffessionDetails().getIdProffessionDetails(),
                    generateLifestyleDetails().getIdLifestyle(),
                    generateBasicComplaints().getIdBasicComplaints(),
                    generateImportantMedicalComplaints().getIdImportantMedicalComplaints(),
                    generateContactDetailsContact().getIdContactDetailsContact()
            );

            JOptionPane.showMessageDialog(this, "Patient added sucessfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsertPatientShort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertPatientShort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertPatientShort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertPatientShort.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertPatientShort().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsert;
    private javax.swing.ButtonGroup btnSexGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JTextField txtMiddlename;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNokMiddlename;
    private javax.swing.JTextField txtNokName;
    private javax.swing.JTextField txtNokRelationship;
    private javax.swing.JTextField txtNokSurname;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtPhone2;
    private javax.swing.JTextArea txtStatementOfComplaint;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
