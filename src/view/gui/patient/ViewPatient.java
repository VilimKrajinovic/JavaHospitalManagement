/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gui.patient;

import models.classes.patient.PatientFull;

/**
 *
 * @author amd
 */
public class ViewPatient extends javax.swing.JFrame {

    PatientFull patient = null;

    /**
     * Creates new form ViewPatient
     */
    public ViewPatient(PatientFull patient) {
        initComponents();
        setLocationRelativeTo(null);
        this.patient = patient;
        init(this.patient);
    }

    
    private void init(PatientFull patient) {
        txtPatientName.setText(patient.getPatientShortData().getName());
        txtPatientSurname.setText(patient.getPatientShortData().getSurname());
        txtPatientMiddlename.setText(patient.getPatientShortData().getMiddlename());
        if (patient.getPatientShortData().getSex().equals("M")) {
            rbtnMale.setSelected(true);
        } else {
            rbtnFemale.setSelected(true);
        }
        datePicker.setDate(patient.getDateOfBirth());

        txtOccupation.setText(patient.getProffesionDetails().getOccupation());
        txtAnnualIncome.setText(Integer.toString(patient.getProffesionDetails().getGrossAnnualIncome()));

        txtMaritalStatus.setText(patient.getPersonalDetails().getMaritalStatus());
        txtNumOfDependents.setText(patient.getPersonalDetails().getNumberOfDependents());
        txtHeight.setText(patient.getPersonalDetails().getHeight());
        txtWeight.setText(patient.getPersonalDetails().getWeight());
        txtBloodType.setText(patient.getPersonalDetails().getBloodType());

        txtPermAddrCity.setText(patient.getPermanentAddress().getCity());
        txtPermAddrStreet.setText(patient.getPermanentAddress().getStreet());
        txtPermAddrDoorNr.setText(patient.getPermanentAddress().getDoorNumber());
        txtPermAddrArea.setText(patient.getPermanentAddress().getArea());
        txtPermAddrPincode.setText(patient.getPermanentAddress().getPincode());
        txtPermAddrState.setText(patient.getPermanentAddress().getState());

        txtPresAddrCity.setText(patient.getPresentAddress().getCity());
        txtPresAddrStreet.setText(patient.getPresentAddress().getStreet());
        txtPresAddrDoorNr.setText(patient.getPresentAddress().getDoorNumber());
        txtPresAddrArea.setText(patient.getPresentAddress().getArea());
        txtPresAddrPincode.setText(patient.getPresentAddress().getPincode());
        txtPresAddrState.setText(patient.getPresentAddress().getState());

        txtPatPhoneHome.setText(patient.getContactDetails().getTelephoneHome());
        txtPatPhoneWork.setText(patient.getContactDetails().getTelephoneWork());
        txtPatMobile.setText(patient.getContactDetails().getTelephoneMobile());
        txtPatPager.setText(patient.getContactDetails().getPager());
        txtPatFax.setText(patient.getContactDetails().getFax());
        txtPatEmail.setText(patient.getContactDetails().getEmail());

        cbSmoker.setSelected(patient.getLifestyle().isIsSmoker());
        cbAlcoholic.setSelected(patient.getLifestyle().isIsAlcoholic());
        cbVegetarian.setSelected(patient.getLifestyle().isIsVegetarian());
        cbHomeFood.setSelected(patient.getLifestyle().isEatsHomeFood());
        cbRegularMeals.setSelected(patient.getLifestyle().isHaveRegularMeals());
        txtAverageCigarettes.setText(Integer.toString(patient.getLifestyle().getAverageNoOfCigarettes()));
        txtAverageDrinks.setText(Integer.toString(patient.getLifestyle().getAverageNoOfDrinks()));
        txtAverageSoftDrinks.setText(Integer.toString(patient.getLifestyle().getConsumptionOfSoftDrinks()));
        txtAverageCoffee.setText(Integer.toString(patient.getLifestyle().getConsumptionOfCoffeeAndTea()));
        txtStimulants.setText(patient.getLifestyle().getUseStimulants());

        txtSoC.setText(patient.getPatientShortData().getStatementOfComplaint());
        txtPrevTreatment.setText(patient.getBasicComplaints().getHistoryOfPreviousTreatment());
        txtPhysOrHosp.setText(patient.getBasicComplaints().getPhysicianOrHospital());

        cbDiabetic.setSelected(patient.getMedicalComplaints().isIsDiabetic());
        cbHypertensive.setSelected(patient.getMedicalComplaints().isIsDiabetic());
        txtCardiacCondition.setText(patient.getMedicalComplaints().getCardiacCondition());
        txtDigestiveCondition.setText(patient.getMedicalComplaints().getDigestiveCondition());
        txtOrthopedicCondition.setText(patient.getMedicalComplaints().getOrthopedicCondition());
        txtMuscularCondition.setText(patient.getMedicalComplaints().getMuscularCondition());
        txtNeurologicalCondition.setText(patient.getMedicalComplaints().getNeurologicalCondition());
        txtKnownAlergies.setText(patient.getMedicalComplaints().getKnownAllegries());
        txtReactionToDrugs.setText(patient.getMedicalComplaints().getKnownReactionToDrugs());
        txtMajorSurgeries.setText(patient.getMedicalComplaints().getMajorSurgeries());

        txtNokName.setText(patient.getPatientShortData().getNextOfKin().getName());
        txtNokSurname.setText(patient.getPatientShortData().getNextOfKin().getSurname());
        txtNokMiddlename.setText(patient.getPatientShortData().getNextOfKin().getMiddlename());

        txtNokPhoneHome.setText(patient.getPatientShortData().getNextOfKin().getContactDetails().getTelephoneHome());
        txtNokPhoneWork.setText(patient.getPatientShortData().getNextOfKin().getContactDetails().getTelephoneWork());
        txtNokMobile.setText(patient.getPatientShortData().getNextOfKin().getContactDetails().getTelephoneMobile());
        txtNokPager.setText(patient.getPatientShortData().getNextOfKin().getContactDetails().getPager());
        txtNokFax.setText(patient.getPatientShortData().getNextOfKin().getContactDetails().getFax());
        txtNokEmail.setText(patient.getPatientShortData().getNextOfKin().getContactDetails().getEmail());

        txtNokCity.setText(patient.getPatientShortData().getNextOfKin().getAddressDetails().getCity());
        txtNokStreet.setText(patient.getPatientShortData().getNextOfKin().getAddressDetails().getStreet());
        txtNokDoorNr.setText(patient.getPatientShortData().getNextOfKin().getAddressDetails().getDoorNumber());
        txtNokArea.setText(patient.getPatientShortData().getNextOfKin().getAddressDetails().getArea());
        txtNokPincode.setText(patient.getPatientShortData().getNextOfKin().getAddressDetails().getPincode());
        txtNokState.setText(patient.getPatientShortData().getNextOfKin().getAddressDetails().getState());

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabMain = new javax.swing.JTabbedPane();
        pnlPatientGeneralData = new javax.swing.JPanel();
        pnlBasicData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtPatientSurname = new javax.swing.JTextField();
        txtPatientMiddlename = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        pnlProffessionalDetails = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        txtAnnualIncome = new javax.swing.JFormattedTextField();
        pnlPersonalDetails = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        txtMaritalStatus = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtNumOfDependents = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtBloodType = new javax.swing.JTextField();
        pnlLifestyle = new javax.swing.JPanel();
        pnlPatientLifestyleDetails = new javax.swing.JPanel();
        cbSmoker = new javax.swing.JCheckBox();
        cbAlcoholic = new javax.swing.JCheckBox();
        cbVegetarian = new javax.swing.JCheckBox();
        cbHomeFood = new javax.swing.JCheckBox();
        cbRegularMeals = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        txtAverageCigarettes = new javax.swing.JFormattedTextField();
        txtAverageDrinks = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtAverageSoftDrinks = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        txtAverageCoffee = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        txtStimulants = new javax.swing.JTextField();
        pnlComplaints = new javax.swing.JPanel();
        pnlPatientBasicComplaintsDetails = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSoC = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPrevTreatment = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        txtPhysOrHosp = new javax.swing.JTextField();
        pnlPatientMedicalComplaintsDetails = new javax.swing.JPanel();
        cbDiabetic = new javax.swing.JCheckBox();
        cbHypertensive = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        txtCardiacCondition = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtDigestiveCondition = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtOrthopedicCondition = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtReactionToDrugs = new javax.swing.JTextField();
        txtKnownAlergies = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtNeurologicalCondition = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtMuscularCondition = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtMajorSurgeries = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nokGeneralData = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtNokName = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtNokSurname = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtNokMiddlename = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtNokRelationship = new javax.swing.JTextField();
        nokContactDetails = new javax.swing.JPanel();
        txtNokEmail = new javax.swing.JTextField();
        txtNokPhoneHome = new javax.swing.JTextField();
        txtNokPhoneWork = new javax.swing.JTextField();
        txtNokMobile = new javax.swing.JTextField();
        txtNokPager = new javax.swing.JTextField();
        txtNokFax = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        nokAddressDetails = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        txtNokCity = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtNokStreet = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtNokDoorNr = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtNokPincode = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtNokArea = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtNokState = new javax.swing.JTextField();
        pnlContactAndAddress = new javax.swing.JPanel();
        pnlPatientContactDetails = new javax.swing.JPanel();
        txtPatEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPatPhoneHome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPatPhoneWork = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPatMobile = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPatPager = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPatFax = new javax.swing.JTextField();
        pnlPatientAddressDetails = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtPermAddrCity = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPermAddrStreet = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPermAddrDoorNr = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPermAddrPincode = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPermAddrArea = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtPresAddrCity = new javax.swing.JTextField();
        txtPresAddrStreet = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtPresAddrDoorNr = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtPresAddrPincode = new javax.swing.JTextField();
        txtPresAddrArea = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtPermAddrState = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtPresAddrState = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBasicData.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Basic data")));

        jLabel1.setText("Name:");

        jLabel2.setText("Surname:");

        jLabel3.setText("Middlename:");

        jLabel4.setText("Sex:");

        rbtnMale.setText("M");

        rbtnFemale.setText("F");

        jLabel5.setText("Date of birth:");

        javax.swing.GroupLayout pnlBasicDataLayout = new javax.swing.GroupLayout(pnlBasicData);
        pnlBasicData.setLayout(pnlBasicDataLayout);
        pnlBasicDataLayout.setHorizontalGroup(
            pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBasicDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPatientName)
                    .addComponent(txtPatientMiddlename)
                    .addComponent(txtPatientSurname)
                    .addGroup(pnlBasicDataLayout.createSequentialGroup()
                        .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBasicDataLayout.createSequentialGroup()
                                .addComponent(rbtnMale)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnFemale))
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        pnlBasicDataLayout.setVerticalGroup(
            pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBasicDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPatientSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPatientMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbtnMale)
                    .addComponent(rbtnFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBasicDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProffessionalDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Proffesional details"));

        jLabel6.setText("Occupation:");

        jLabel7.setText("Annual income:");

        txtAnnualIncome.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout pnlProffessionalDetailsLayout = new javax.swing.GroupLayout(pnlProffessionalDetails);
        pnlProffessionalDetails.setLayout(pnlProffessionalDetailsLayout);
        pnlProffessionalDetailsLayout.setHorizontalGroup(
            pnlProffessionalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProffessionalDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProffessionalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnlProffessionalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOccupation, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtAnnualIncome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProffessionalDetailsLayout.setVerticalGroup(
            pnlProffessionalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProffessionalDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProffessionalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProffessionalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAnnualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPersonalDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal details"));

        jLabel60.setText("Marital status:");

        jLabel61.setText("Number of dependents:");

        jLabel62.setText("Height:");

        jLabel63.setText("Weight:");

        jLabel64.setText("Blood type:");

        javax.swing.GroupLayout pnlPersonalDetailsLayout = new javax.swing.GroupLayout(pnlPersonalDetails);
        pnlPersonalDetails.setLayout(pnlPersonalDetailsLayout);
        pnlPersonalDetailsLayout.setHorizontalGroup(
            pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel61)
                        .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumOfDependents, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlPersonalDetailsLayout.setVerticalGroup(
            pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalDetailsLayout.createSequentialGroup()
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txtNumOfDependents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(txtBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPatientGeneralDataLayout = new javax.swing.GroupLayout(pnlPatientGeneralData);
        pnlPatientGeneralData.setLayout(pnlPatientGeneralDataLayout);
        pnlPatientGeneralDataLayout.setHorizontalGroup(
            pnlPatientGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientGeneralDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPatientGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBasicData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProffessionalDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        pnlPatientGeneralDataLayout.setVerticalGroup(
            pnlPatientGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientGeneralDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPatientGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPersonalDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBasicData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProffessionalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        tabMain.addTab("Patient data", pnlPatientGeneralData);

        pnlPatientLifestyleDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient lifestyle"));

        cbSmoker.setText("Smoker");

        cbAlcoholic.setText("Alcoholic");

        cbVegetarian.setText("Vegeterian");

        cbHomeFood.setText("Eats home food");

        cbRegularMeals.setText("Has regular meals");

        jLabel28.setText("Average number of cigarettes:");

        txtAverageCigarettes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtAverageCigarettes.setText("0");

        txtAverageDrinks.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtAverageDrinks.setText("0");

        jLabel29.setText("Average number of drinks:");

        jLabel30.setText("Average consumption of soft drinks:");

        txtAverageSoftDrinks.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtAverageSoftDrinks.setText("0");

        jLabel31.setText("Average consumption of tea and coffee:");

        txtAverageCoffee.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtAverageCoffee.setText("0");

        jLabel32.setText("Stimulants used:");

        javax.swing.GroupLayout pnlPatientLifestyleDetailsLayout = new javax.swing.GroupLayout(pnlPatientLifestyleDetails);
        pnlPatientLifestyleDetails.setLayout(pnlPatientLifestyleDetailsLayout);
        pnlPatientLifestyleDetailsLayout.setHorizontalGroup(
            pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                        .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                                .addComponent(cbSmoker)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel28))
                            .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                                .addComponent(cbAlcoholic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAverageDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(txtAverageCigarettes)))
                    .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                        .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAverageSoftDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtStimulants, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAverageCoffee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(cbHomeFood)
                    .addComponent(cbRegularMeals)
                    .addComponent(cbVegetarian))
                .addContainerGap())
        );
        pnlPatientLifestyleDetailsLayout.setVerticalGroup(
            pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientLifestyleDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSmoker)
                    .addComponent(jLabel28)
                    .addComponent(txtAverageCigarettes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlcoholic)
                    .addComponent(jLabel29)
                    .addComponent(txtAverageDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbVegetarian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHomeFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRegularMeals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtAverageSoftDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtAverageCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientLifestyleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtStimulants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlLifestyleLayout = new javax.swing.GroupLayout(pnlLifestyle);
        pnlLifestyle.setLayout(pnlLifestyleLayout);
        pnlLifestyleLayout.setHorizontalGroup(
            pnlLifestyleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLifestyleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPatientLifestyleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        pnlLifestyleLayout.setVerticalGroup(
            pnlLifestyleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLifestyleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPatientLifestyleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        tabMain.addTab("Lifestyle", pnlLifestyle);

        pnlPatientBasicComplaintsDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient basic complaints"));

        jLabel33.setText("Statement of complaint:");

        txtSoC.setColumns(20);
        txtSoC.setRows(5);
        jScrollPane1.setViewportView(txtSoC);

        jLabel34.setText("Previous treatment history:");

        txtPrevTreatment.setColumns(20);
        txtPrevTreatment.setRows(5);
        jScrollPane2.setViewportView(txtPrevTreatment);

        jLabel35.setText("Physician or hospital treated:");

        javax.swing.GroupLayout pnlPatientBasicComplaintsDetailsLayout = new javax.swing.GroupLayout(pnlPatientBasicComplaintsDetails);
        pnlPatientBasicComplaintsDetails.setLayout(pnlPatientBasicComplaintsDetailsLayout);
        pnlPatientBasicComplaintsDetailsLayout.setHorizontalGroup(
            pnlPatientBasicComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPhysOrHosp)
            .addGroup(pnlPatientBasicComplaintsDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientBasicComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        pnlPatientBasicComplaintsDetailsLayout.setVerticalGroup(
            pnlPatientBasicComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientBasicComplaintsDetailsLayout.createSequentialGroup()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhysOrHosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlPatientMedicalComplaintsDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient important medical complaints"));

        cbDiabetic.setText("Diabetic");

        cbHypertensive.setText("Hypertensive");

        jLabel36.setText("Cardiac condition:");

        jLabel37.setText("Digestive condtion:");

        jLabel38.setText("Orthopedic condition:");

        jLabel39.setText("Known reactions to drugs:");

        jLabel40.setText("Known allergies:");

        jLabel41.setText("Neurological condition:");

        jLabel42.setText("Muscular condition:");

        jLabel43.setText("Major surgeries:");

        javax.swing.GroupLayout pnlPatientMedicalComplaintsDetailsLayout = new javax.swing.GroupLayout(pnlPatientMedicalComplaintsDetails);
        pnlPatientMedicalComplaintsDetails.setLayout(pnlPatientMedicalComplaintsDetailsLayout);
        pnlPatientMedicalComplaintsDetailsLayout.setHorizontalGroup(
            pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMajorSurgeries))
            .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createSequentialGroup()
                .addComponent(cbDiabetic)
                .addGap(18, 18, 18)
                .addComponent(cbHypertensive)
                .addGap(117, 133, Short.MAX_VALUE))
            .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKnownAlergies)
                    .addComponent(txtReactionToDrugs)))
            .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCardiacCondition)
                    .addComponent(txtDigestiveCondition)
                    .addComponent(txtMuscularCondition)
                    .addComponent(txtNeurologicalCondition)
                    .addComponent(txtOrthopedicCondition, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        pnlPatientMedicalComplaintsDetailsLayout.setVerticalGroup(
            pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDiabetic)
                    .addComponent(cbHypertensive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtCardiacCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtDigestiveCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtOrthopedicCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtMuscularCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtNeurologicalCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtKnownAlergies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtReactionToDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientMedicalComplaintsDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtMajorSurgeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlComplaintsLayout = new javax.swing.GroupLayout(pnlComplaints);
        pnlComplaints.setLayout(pnlComplaintsLayout);
        pnlComplaintsLayout.setHorizontalGroup(
            pnlComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComplaintsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPatientBasicComplaintsDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPatientMedicalComplaintsDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        pnlComplaintsLayout.setVerticalGroup(
            pnlComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComplaintsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPatientBasicComplaintsDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPatientMedicalComplaintsDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        tabMain.addTab("Complaints", pnlComplaints);

        nokGeneralData.setBorder(javax.swing.BorderFactory.createTitledBorder("Next of kin general data"));

        jLabel44.setText("Name:");

        jLabel45.setText("Surname:");

        jLabel46.setText("Middlename:");

        jLabel47.setText("Relationship:");

        javax.swing.GroupLayout nokGeneralDataLayout = new javax.swing.GroupLayout(nokGeneralData);
        nokGeneralData.setLayout(nokGeneralDataLayout);
        nokGeneralDataLayout.setHorizontalGroup(
            nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nokGeneralDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(nokGeneralDataLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nokGeneralDataLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nokGeneralDataLayout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nokGeneralDataLayout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        nokGeneralDataLayout.setVerticalGroup(
            nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nokGeneralDataLayout.createSequentialGroup()
                .addGroup(nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtNokName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtNokSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtNokMiddlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokGeneralDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtNokRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        nokContactDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Next of kin contact details"));

        jLabel52.setText("Fax:");

        jLabel51.setText("Pager:");

        jLabel50.setText("Mobile:");

        jLabel49.setText("Telephone work:");

        jLabel48.setText("Telephone home:");

        jLabel53.setText("Email:");

        javax.swing.GroupLayout nokContactDetailsLayout = new javax.swing.GroupLayout(nokContactDetails);
        nokContactDetails.setLayout(nokContactDetailsLayout);
        nokContactDetailsLayout.setHorizontalGroup(
            nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokContactDetailsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokContactDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokFax, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokContactDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokContactDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNokPager, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(nokContactDetailsLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel49)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNokPhoneWork, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(nokContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNokEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(nokContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNokPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        nokContactDetailsLayout.setVerticalGroup(
            nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokContactDetailsLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtNokEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtNokPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtNokPhoneWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtNokMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtNokPager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtNokFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        nokAddressDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Next of kin address details"));

        jLabel54.setText("City:");

        jLabel55.setText("Street:");

        jLabel56.setText("Door number:");

        jLabel58.setText("Pincode:");

        jLabel59.setText("Area:");

        jLabel57.setText("State:");

        javax.swing.GroupLayout nokAddressDetailsLayout = new javax.swing.GroupLayout(nokAddressDetails);
        nokAddressDetails.setLayout(nokAddressDetailsLayout);
        nokAddressDetailsLayout.setHorizontalGroup(
            nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokAddressDetailsLayout.createSequentialGroup()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNokArea, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokAddressDetailsLayout.createSequentialGroup()
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNokPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokAddressDetailsLayout.createSequentialGroup()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNokDoorNr, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokAddressDetailsLayout.createSequentialGroup()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNokStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokAddressDetailsLayout.createSequentialGroup()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNokCity, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nokAddressDetailsLayout.createSequentialGroup()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNokState, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nokAddressDetailsLayout.setVerticalGroup(
            nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nokAddressDetailsLayout.createSequentialGroup()
                .addGroup(nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtNokCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtNokStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtNokDoorNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtNokArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtNokPincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nokAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtNokState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nokGeneralData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nokContactDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nokAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nokGeneralData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nokContactDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nokAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        tabMain.addTab("Nex of kin", jPanel1);

        pnlPatientContactDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient contact details"));

        jLabel13.setText("Email:");

        jLabel8.setText("Telephone home:");

        jLabel9.setText("Telephone work:");

        jLabel10.setText("Mobile:");

        jLabel11.setText("Pager:");

        jLabel12.setText("Fax:");

        javax.swing.GroupLayout pnlPatientContactDetailsLayout = new javax.swing.GroupLayout(pnlPatientContactDetails);
        pnlPatientContactDetails.setLayout(pnlPatientContactDetailsLayout);
        pnlPatientContactDetailsLayout.setHorizontalGroup(
            pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientContactDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                        .addGap(0, 78, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatFax, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatPager, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientContactDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatPhoneWork, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlPatientContactDetailsLayout.setVerticalGroup(
            pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientContactDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPatPhoneHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPatPhoneWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPatMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPatPager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatientContactDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPatFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlPatientAddressDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient address details:"));

        jLabel14.setText("City:");

        jLabel15.setText("Street:");

        jLabel16.setText("Door number:");

        jLabel17.setText("Pincode:");

        jLabel18.setText("Area:");

        jLabel19.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel19.setText("Permanent address:");

        jLabel20.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel20.setText("Present address:");

        jLabel21.setText("City:");

        jLabel22.setText("Street:");

        jLabel23.setText("Door number:");

        jLabel24.setText("Pincode:");

        jLabel25.setText("Area:");

        jLabel26.setText("State:");

        jLabel27.setText("State:");

        javax.swing.GroupLayout pnlPatientAddressDetailsLayout = new javax.swing.GroupLayout(pnlPatientAddressDetails);
        pnlPatientAddressDetails.setLayout(pnlPatientAddressDetailsLayout);
        pnlPatientAddressDetailsLayout.setHorizontalGroup(
            pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPermAddrArea, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPermAddrPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPermAddrDoorNr, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPermAddrStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPermAddrCity, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel19)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientAddressDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPermAddrState, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPresAddrArea, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPresAddrPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPresAddrDoorNr, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPresAddrStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPresAddrCity, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPresAddrState, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20)))
        );
        pnlPatientAddressDetailsLayout.setVerticalGroup(
            pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtPresAddrCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtPresAddrStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtPresAddrDoorNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtPresAddrArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtPresAddrPincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtPresAddrState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPatientAddressDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtPermAddrCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtPermAddrStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtPermAddrDoorNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtPermAddrArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtPermAddrPincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientAddressDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtPermAddrState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContactAndAddressLayout = new javax.swing.GroupLayout(pnlContactAndAddress);
        pnlContactAndAddress.setLayout(pnlContactAndAddressLayout);
        pnlContactAndAddressLayout.setHorizontalGroup(
            pnlContactAndAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactAndAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPatientAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPatientContactDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlContactAndAddressLayout.setVerticalGroup(
            pnlContactAndAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactAndAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContactAndAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPatientAddressDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPatientContactDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        tabMain.addTab("Contact and Address", pnlContactAndAddress);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addContainerGap())
            .addComponent(tabMain, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabMain, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JCheckBox cbAlcoholic;
    private javax.swing.JCheckBox cbDiabetic;
    private javax.swing.JCheckBox cbHomeFood;
    private javax.swing.JCheckBox cbHypertensive;
    private javax.swing.JCheckBox cbRegularMeals;
    private javax.swing.JCheckBox cbSmoker;
    private javax.swing.JCheckBox cbVegetarian;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel nokAddressDetails;
    private javax.swing.JPanel nokContactDetails;
    private javax.swing.JPanel nokGeneralData;
    private javax.swing.JPanel pnlBasicData;
    private javax.swing.JPanel pnlComplaints;
    private javax.swing.JPanel pnlContactAndAddress;
    private javax.swing.JPanel pnlLifestyle;
    private javax.swing.JPanel pnlPatientAddressDetails;
    private javax.swing.JPanel pnlPatientBasicComplaintsDetails;
    private javax.swing.JPanel pnlPatientContactDetails;
    private javax.swing.JPanel pnlPatientGeneralData;
    private javax.swing.JPanel pnlPatientLifestyleDetails;
    private javax.swing.JPanel pnlPatientMedicalComplaintsDetails;
    private javax.swing.JPanel pnlPersonalDetails;
    private javax.swing.JPanel pnlProffessionalDetails;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JFormattedTextField txtAnnualIncome;
    private javax.swing.JFormattedTextField txtAverageCigarettes;
    private javax.swing.JFormattedTextField txtAverageCoffee;
    private javax.swing.JFormattedTextField txtAverageDrinks;
    private javax.swing.JFormattedTextField txtAverageSoftDrinks;
    private javax.swing.JTextField txtBloodType;
    private javax.swing.JTextField txtCardiacCondition;
    private javax.swing.JTextField txtDigestiveCondition;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtKnownAlergies;
    private javax.swing.JTextField txtMajorSurgeries;
    private javax.swing.JTextField txtMaritalStatus;
    private javax.swing.JTextField txtMuscularCondition;
    private javax.swing.JTextField txtNeurologicalCondition;
    private javax.swing.JTextField txtNokArea;
    private javax.swing.JTextField txtNokCity;
    private javax.swing.JTextField txtNokDoorNr;
    private javax.swing.JTextField txtNokEmail;
    private javax.swing.JTextField txtNokFax;
    private javax.swing.JTextField txtNokMiddlename;
    private javax.swing.JTextField txtNokMobile;
    private javax.swing.JTextField txtNokName;
    private javax.swing.JTextField txtNokPager;
    private javax.swing.JTextField txtNokPhoneHome;
    private javax.swing.JTextField txtNokPhoneWork;
    private javax.swing.JTextField txtNokPincode;
    private javax.swing.JTextField txtNokRelationship;
    private javax.swing.JTextField txtNokState;
    private javax.swing.JTextField txtNokStreet;
    private javax.swing.JTextField txtNokSurname;
    private javax.swing.JTextField txtNumOfDependents;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtOrthopedicCondition;
    private javax.swing.JTextField txtPatEmail;
    private javax.swing.JTextField txtPatFax;
    private javax.swing.JTextField txtPatMobile;
    private javax.swing.JTextField txtPatPager;
    private javax.swing.JTextField txtPatPhoneHome;
    private javax.swing.JTextField txtPatPhoneWork;
    private javax.swing.JTextField txtPatientMiddlename;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtPatientSurname;
    private javax.swing.JTextField txtPermAddrArea;
    private javax.swing.JTextField txtPermAddrCity;
    private javax.swing.JTextField txtPermAddrDoorNr;
    private javax.swing.JTextField txtPermAddrPincode;
    private javax.swing.JTextField txtPermAddrState;
    private javax.swing.JTextField txtPermAddrStreet;
    private javax.swing.JTextField txtPhysOrHosp;
    private javax.swing.JTextField txtPresAddrArea;
    private javax.swing.JTextField txtPresAddrCity;
    private javax.swing.JTextField txtPresAddrDoorNr;
    private javax.swing.JTextField txtPresAddrPincode;
    private javax.swing.JTextField txtPresAddrState;
    private javax.swing.JTextField txtPresAddrStreet;
    private javax.swing.JTextArea txtPrevTreatment;
    private javax.swing.JTextField txtReactionToDrugs;
    private javax.swing.JTextArea txtSoC;
    private javax.swing.JTextField txtStimulants;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
