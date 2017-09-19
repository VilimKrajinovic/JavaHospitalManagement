/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.repo;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import models.classes.appointment.Appointment;
import models.classes.bill.AccountItem;
import models.classes.bill.Bill;
import models.classes.doctor.Doctor;
import models.classes.doctor.Specialization;
import models.classes.patient.BasicComplaints;
import models.classes.patient.ContactDetailsAddress;
import models.classes.patient.ContactDetailsContact;
import models.classes.patient.ImportantMedicalComplaints;
import models.classes.patient.Lifestyle;
import models.classes.patient.NextOfKin;
import models.classes.patient.PatientFull;
import models.classes.patient.PatientShort;
import models.classes.patient.PersonalDetails;
import models.classes.patient.ProffesionDetails;

/**
 *
 * @author amd
 */
public class Repository implements IRepo {

    @Override
    public DataSource getSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("VILIMKRAJINOVIC");
        ds.setUser("sa");
        ds.setPassword("SQL");
        ds.setDatabaseName("VirgoHospital");
        ds.setPortNumber(1433);

        return ds;
    }

    @Override
    public int insertContactDetailsContact(DataSource ds, String telephoneWork, String telephoneHome, String mobile, String pager, String fax, String email) throws Exception {
        int idContactDetailsContact = -1;
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertContactDetailsContact(?,?,?,?,?,?)}")) {
            statement.setString(1, telephoneWork.trim());
            statement.setString(2, telephoneHome.trim());
            statement.setString(3, mobile.trim());
            statement.setString(4, pager.trim());
            statement.setString(5, fax.trim());
            statement.setString(6, email.trim());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idContactDetailsContact = rs.getInt(1);
            }
            return idContactDetailsContact;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int UpdateContactDetailsContact(DataSource ds, int idContactDetailsContact, String telephoneWork, String telephoneHome, String mobile, String pager, String fax, String email) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateContactDetailsContact(?,?,?,?,?,?,?)}")) {
            statement.setInt(1, idContactDetailsContact);
            statement.setString(2, telephoneWork.trim());
            statement.setString(3, telephoneHome.trim());
            statement.setString(4, mobile.trim());
            statement.setString(5, pager.trim());
            statement.setString(6, fax.trim());
            statement.setString(7, email.trim());

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ContactDetailsContact getContactDetailsContact(DataSource ds, int idContactDetailsContact) throws Exception {
        ContactDetailsContact tmp = new ContactDetailsContact();
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetContactDetailsContact(?)}")) {

            statement.setInt(1, idContactDetailsContact);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                tmp.setIdContactDetailsContact(idContactDetailsContact);
                tmp.setTelephoneWork(rs.getString("TelephoneWork"));
                tmp.setTelephoneHome(rs.getString("TelephoneHome"));
                tmp.setTelephoneMobile(rs.getString("Mobile"));
                tmp.setEmail(rs.getString("Email"));
                tmp.setFax(rs.getString("Fax"));
                tmp.setPager(rs.getString("Pager"));

            }
            return tmp;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertPatient(DataSource ds, String name, String surname, String middlename, String sex, String statementOfComplaint, String contactPhone1, String contactPhone2, int nextOfKinID, boolean isFollowUp) throws Exception {
        int idPatient = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertPatient(?,?,?,?,?,?,?,?,?)}")) {

            statement.setString(1, name.trim());
            statement.setString(2, surname.trim());
            statement.setString(3, middlename.trim());
            statement.setString(4, sex.trim());
            statement.setString(5, statementOfComplaint.trim());
            statement.setString(6, contactPhone1.trim());
            statement.setString(7, contactPhone2.trim());
            statement.setInt(8, nextOfKinID);
            statement.setBoolean(9, isFollowUp);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idPatient = rs.getInt(1);
            }

            return idPatient;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updatePatient(DataSource ds, int idPatient, String name, String surname, String middlename, String sex, String statementOfComplaint, String contactPhone1, String contactPhone2, boolean isFollowUp) throws Exception {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL UpdatePatientShort(?,?,?,?,?,?,?,?,?)}")) {
            stmt.setInt(1, idPatient);

            stmt.setString(2, name.trim());
            stmt.setString(3, surname.trim());
            stmt.setString(4, middlename.trim());
            stmt.setString(5, sex.trim());
            stmt.setString(6, statementOfComplaint.trim());
            stmt.setBoolean(7, isFollowUp);
            stmt.setString(8, contactPhone1.trim());
            stmt.setString(9, contactPhone2.trim());

            return stmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public PatientShort getPatientShort(DataSource ds, int idPatient) throws Exception {
        PatientShort patient = new PatientShort();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL GetPatient(?)}")) {
            stmt.setInt(1, idPatient);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                patient.setIdPatient(idPatient);
                patient.setName(rs.getString("Name"));
                patient.setSurname(rs.getString("Surname"));
                patient.setMiddlename(rs.getString("Middlename"));
                patient.setSex(rs.getString("Sex"));
                patient.setStatementOfComplaint(rs.getString("StatementOfComplaint"));
                patient.setContact_1(rs.getString("ContactPhone_1"));
                patient.setContact_2(rs.getString("ContactPhone_2"));
                patient.setNextOfKin(getNextOfKin(getSource(), rs.getInt("NextOfKinID")));
                patient.setIsFollowUp(rs.getBoolean("IsFollowUp"));
            }

            return patient;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<PatientShort> getPatients(DataSource ds) throws Exception {
        List<PatientShort> patients = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetPatients()}")) {
            statement.execute();

            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                PatientShort patient = new PatientShort();

                patient.setIdPatient(rs.getInt("IDPatient"));
                patient.setName(rs.getString("Name"));
                patient.setSurname(rs.getString("Surname"));
                patient.setMiddlename(rs.getString("Middlename"));
                patient.setSex(rs.getString("Sex"));
                patient.setStatementOfComplaint(rs.getString("StatementOfComplaint"));
                patient.setContact_1(rs.getString("ContactPhone_1"));
                patient.setContact_2(rs.getString("ContactPhone_2"));
                patient.setNextOfKin(getNextOfKin(getSource(), rs.getInt("NextOfKinID")));
                patient.setIsFollowUp(rs.getBoolean("IsFollowUp"));

                patients.add(patient);
            }

            return patients;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void insertSpecialization(DataSource ds, String specialization) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertSpecialization(?)}")) {
            statement.setString(1, specialization.trim());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int deleteSpecialization(DataSource ds, int idSpecialization) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL DeleteSpecialization(?)}")) {
            statement.setInt(1, idSpecialization);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateSpecialization(DataSource ds, int idSpecialization, String specializationName) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateSpecialization(?,?)}")) {
            statement.setInt(1, idSpecialization);
            statement.setString(2, specializationName);
            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Specialization> getSpecializations(DataSource ds) throws Exception {
        List<Specialization> list = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL getSpecializations()}")) {
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                Specialization temp = new Specialization();
                temp.setIdSpecialization(rs.getInt("IDSpecialization"));
                temp.setSpecializationName(rs.getString("Specialization"));

                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Specialization getSpecialization(DataSource ds, int idSpecialization) throws Exception {
        Specialization temp = new Specialization();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL getSpecialization(?)}")) {
            statement.setInt(1, idSpecialization);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                temp.setIdSpecialization(idSpecialization);
                temp.setSpecializationName(rs.getString("Specialization"));
            }
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ContactDetailsAddress getContactDetailsAddress(DataSource ds, int idContactDetailsAddress) throws Exception {
        ContactDetailsAddress contact = new ContactDetailsAddress();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetContactDetailsAddress(?)}")) {
            statement.setInt(1, idContactDetailsAddress);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                contact.setIdContactDetailsAddress(idContactDetailsAddress);
                contact.setDoorNumber(rs.getString("DoorNumber"));
                contact.setStreet(rs.getString("Street"));
                contact.setArea(rs.getString("Area"));
                contact.setCity(rs.getString("City"));
                contact.setState(rs.getString("State"));
                contact.setPincode(rs.getString("Pincode"));
            }

            return contact;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertContactDetailsAddress(DataSource ds, String doorNumber, String street, String area, String city, String state, String pincode) throws Exception {
        int idContactDetailsAddress = -1;
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertContactDetailsAddress(?,?,?,?,?,?)}")) {
            statement.setString(1, doorNumber.trim());
            statement.setString(2, street.trim());
            statement.setString(3, area.trim());
            statement.setString(4, city.trim());
            statement.setString(5, state.trim());
            statement.setString(6, pincode.trim());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idContactDetailsAddress = rs.getInt(1);
            }

            return idContactDetailsAddress;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateContactDetailsAddress(DataSource ds, int idContactDetailsAddress, String doorNumber, String street, String area, String city, String state, String pincode) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateContactDetailsAddress(?,?,?,?,?,?,?)}")) {
            statement.setInt(1, idContactDetailsAddress);
            statement.setString(2, doorNumber.trim());
            statement.setString(3, street.trim());
            statement.setString(4, area.trim());
            statement.setString(5, city.trim());
            statement.setString(6, state.trim());
            statement.setString(7, pincode.trim());

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Doctor getDoctor(DataSource ds, int idDoctor) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetDoctor(?)}")) {
            Doctor doctor = new Doctor();

            statement.setInt(1, idDoctor);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                doctor.setIdDoctor(idDoctor);
                doctor.setName(rs.getString("Name"));
                doctor.setSurname(rs.getString("Surname"));
                doctor.setIsWorking(rs.getBoolean("IsActive"));

                doctor.setSpecialization(getSpecialization(getSource(), rs.getInt("SpecializationID")));
                doctor.setAddressDetails(getContactDetailsAddress(getSource(), rs.getInt("ContactDetailsAddressID")));
                doctor.setContactDetails(getContactDetailsContact(getSource(), rs.getInt("ContactDetailsContactID")));
            }
            return doctor;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertDoctor(DataSource ds, String name, String surname, int specializationID, int contactDetailsContactID, int contactDetailsAddressID, boolean isActive) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertDoctor(?,?,?,?,?,?)}")) {
            statement.setString(1, name.trim());
            statement.setString(2, surname.trim());
            statement.setInt(3, specializationID);
            statement.setInt(4, contactDetailsContactID);
            statement.setInt(5, contactDetailsAddressID);
            statement.setBoolean(6, isActive);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateDoctor(DataSource ds, int idDoctor, String name, String surname, int specializationID) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateDoctor(?,?,?,?)}");) {
            statement.setInt(1, idDoctor);
            statement.setString(2, name.trim());
            statement.setString(3, surname.trim());
            statement.setInt(4, specializationID);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int deleteDoctor(DataSource ds, int idDoctor) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL DeleteDoctor(?)}")) {
            statement.setInt(1, idDoctor);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateDoctorStatus(DataSource ds, int idDoctor, boolean isActive) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateDoctorIsActive(?,?)}")) {
            statement.setInt(1, idDoctor);
            statement.setBoolean(2, isActive);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Doctor> getDoctors(DataSource ds) throws Exception {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetAllDoctors()}")) {
            statement.execute();

            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                Doctor doctor = new Doctor();

                doctor.setIdDoctor(rs.getInt("IDDoctor"));
                doctor.setName(rs.getString("Name"));
                doctor.setSurname(rs.getString("Surname"));
                doctor.setIsWorking(true);
                doctor.setContactDetails(getContactDetailsContact(getSource(), rs.getInt("ContactDetailsContactID")));
                doctor.setAddressDetails(getContactDetailsAddress(getSource(), rs.getInt("ContactDetailsAddressID")));
                doctor.setSpecialization(getSpecialization(getSource(), rs.getInt("SpecializationID")));

                doctors.add(doctor);
            }

            return doctors;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ProffesionDetails getProffesionDetails(DataSource ds, int idProffessionDetails) throws Exception {
        ProffesionDetails proffesionDetails = new ProffesionDetails();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetProffessionDetails(?)}")) {
            statement.setInt(1, idProffessionDetails);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                proffesionDetails.setIdProffessionDetails(idProffessionDetails);
                proffesionDetails.setOccupation(rs.getString("Occupation"));
                proffesionDetails.setGrossAnnualIncome(rs.getInt("GrossAnnualIncome"));
            }

            return proffesionDetails;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertProffessionDetails(DataSource ds, String occupation, int annualIncome) throws Exception {
        int idProffessionDetails = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertProffessionDetails(?,?)}")) {
            statement.setString(1, occupation.trim());
            statement.setInt(2, annualIncome);

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idProffessionDetails = rs.getInt(1);
            }

            return idProffessionDetails;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateProffessionDetails(DataSource ds, int idProffessionDetails, String occupation, int annualIncome) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateProffessionDetails(?,?,?)}")) {
            statement.setInt(1, idProffessionDetails);
            statement.setString(2, occupation.trim());
            statement.setInt(3, annualIncome);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public PersonalDetails getPersonalDetails(DataSource ds, int idPersonalDetails) throws Exception {
        PersonalDetails personalDetails = new PersonalDetails();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetPersonalDetails(?)}")) {
            statement.setInt(1, idPersonalDetails);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                personalDetails.setIdPersonalDetails(idPersonalDetails);
                personalDetails.setMaritalStatus(rs.getString("MaritalStatus"));
                personalDetails.setNumberOfDependents(rs.getString("NumberOfDependents"));
                personalDetails.setHeight(rs.getString("Height"));
                personalDetails.setWeight(rs.getString("Weight"));
                personalDetails.setBloodType(rs.getString("BloodType"));
            }
            return personalDetails;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertPersonalDetails(DataSource ds, String maritalStatus, String numberOfDependants, String height, String weight, String bloodType) throws Exception {
        int idPersonalDetains = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertPersonalDetails(?,?,?,?,?)}")) {
            statement.setString(1, maritalStatus.trim());
            statement.setString(2, numberOfDependants.trim());
            statement.setString(3, height.trim());
            statement.setString(4, weight.trim());
            statement.setString(5, bloodType.trim());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idPersonalDetains = rs.getInt(1);
            }

            return idPersonalDetains;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updatePersonalDetails(DataSource ds, int idPersonalDetails, String maritalStatus, String numberOfDependants, String height, String weight, String bloodType) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdatePersonalDetails(?,?,?,?,?,?)}")) {
            statement.setInt(1, idPersonalDetails);
            statement.setString(2, maritalStatus);
            statement.setString(3, numberOfDependants);
            statement.setString(4, bloodType);
            statement.setString(5, height);
            statement.setString(6, weight);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ImportantMedicalComplaints getImportantMedicalComplaints(DataSource ds, int idMedicalComplaints) throws Exception {
        ImportantMedicalComplaints medicalComplaints = new ImportantMedicalComplaints();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetImportantMedicalComplaints(?)}")) {
            statement.setInt(1, idMedicalComplaints);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                medicalComplaints.setIdImportantMedicalComplaints(idMedicalComplaints);
                medicalComplaints.setIsDiabetic(rs.getBoolean("Diabetic"));
                medicalComplaints.setIsHypertenisve(rs.getBoolean("Hypertensive"));
                medicalComplaints.setCardiacCondition(rs.getString("CardiacCondition"));
                medicalComplaints.setDigestiveCondition(rs.getString("DigestiveCondition"));
                medicalComplaints.setOrthopedicCondition(rs.getString("OrthopedicCondition"));
                medicalComplaints.setMuscularCondition(rs.getString("MuscularCondition"));
                medicalComplaints.setNeurologicalCondition(rs.getString("NeurogicalCondition"));
                medicalComplaints.setKnownAllegries(rs.getString("KnownAllergies"));
                medicalComplaints.setKnownReactionToDrugs(rs.getString("KnownReactionToSpecificDrugs"));
                medicalComplaints.setMajorSurgeries(rs.getString("MajorSurgeries"));
            }

            return medicalComplaints;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertImportantMedicalComplaints(DataSource ds, boolean isDiabetic, boolean isHypertensive, String cardiacCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAllergies, String knownReactionsToDrugs, String majorSurgeries) throws Exception {
        int idMedicalComplaints = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertImportantMedicalComplaints(?,?,?,?,?,?,?,?,?,?)}")) {
            statement.setBoolean(1, isDiabetic);
            statement.setBoolean(2, isHypertensive);
            statement.setString(3, cardiacCondition.trim());
            statement.setString(4, digestiveCondition.trim());
            statement.setString(5, orthopedicCondition.trim());
            statement.setString(6, muscularCondition.trim());
            statement.setString(7, neurologicalCondition.trim());
            statement.setString(8, knownAllergies.trim());
            statement.setString(9, knownReactionsToDrugs.trim());
            statement.setString(10, majorSurgeries.trim());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idMedicalComplaints = rs.getInt(1);
            }
            return idMedicalComplaints;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateImportantMedicalComplaints(DataSource ds, int idMedicalComplaints, boolean isDiabetic, boolean isHypertensive, String cardiacCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAllergies, String knownReactionsToDrugs, String majorSurgeries) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateImportantMedicalComplaints(?,?,?,?,?,?,?,?,?,?,?)}")) {
            statement.setInt(1, idMedicalComplaints);
            statement.setBoolean(2, isDiabetic);
            statement.setBoolean(3, isHypertensive);
            statement.setString(4, cardiacCondition.trim());
            statement.setString(5, digestiveCondition.trim());
            statement.setString(6, orthopedicCondition.trim());
            statement.setString(7, muscularCondition.trim());
            statement.setString(8, neurologicalCondition.trim());
            statement.setString(9, knownAllergies.trim());
            statement.setString(10, knownReactionsToDrugs.trim());
            statement.setString(11, majorSurgeries.trim());

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public BasicComplaints getBasicComplaints(DataSource ds, int idComplaint) throws Exception {
        BasicComplaints basicComplaints = new BasicComplaints();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetBasicComplaints(?)}")) {
            statement.setInt(1, idComplaint);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                basicComplaints.setIdBasicComplaints(idComplaint);
                basicComplaints.setStatementOfComplaint(rs.getString("StatementOfComplaint"));
                basicComplaints.setHistoryOfPreviousTreatment(rs.getString("PhysicianOrHospital"));
                basicComplaints.setPhysicianOrHospital(rs.getString("PhysicianOrHospital"));
            }
            return basicComplaints;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertBasicComplaints(DataSource ds, String statementOfComplaint, String treatmentHistory, String hospitalTreated) throws Exception {

        int idBasicComplaints = -1;
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertBasicComplaints(?,?,?)}")) {
            statement.setString(1, statementOfComplaint.trim());
            statement.setString(2, treatmentHistory.trim());
            statement.setString(3, hospitalTreated.trim());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idBasicComplaints = rs.getInt(1);
            }

            return idBasicComplaints;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateBasicComplaints(DataSource ds, int idComplaint, String statementOfComplaint, String treatmentHistory, String hospitalTreated) throws Exception {

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateBasicComplaints(?,?,?,?)}")) {
            statement.setInt(1, idComplaint);
            statement.setString(2, statementOfComplaint.trim());
            statement.setString(3, treatmentHistory.trim());
            statement.setString(4, hospitalTreated.trim());

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Lifestyle getLifestyle(DataSource ds, int idLifestyle) throws Exception {
        Lifestyle lifestyle = new Lifestyle();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetLifestyle(?)}")) {
            statement.setInt(1, idLifestyle);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                lifestyle.setIdLifestyle(idLifestyle);
                lifestyle.setIsSmoker(rs.getBoolean("Smoker"));
                lifestyle.setAverageNoOfCigarettes(rs.getInt("AverageNoOfCigarettes"));
                lifestyle.setIsAlcoholic(rs.getBoolean("Alcoholic"));
                lifestyle.setAverageNoOfDrinks(rs.getInt("AverageNoOfDrinks"));
                lifestyle.setUseStimulants(rs.getString("UseStimulants"));
                lifestyle.setConsumptionOfCoffeeAndTea(rs.getInt("ConsumptionOfCoffeeAndTea"));
                lifestyle.setConsumptionOfSoftDrinks(rs.getInt("ConsumptionOfCoffeeAndTea"));
                lifestyle.setHaveRegularMeals(rs.getBoolean("ConsumptionOfCoffeeAndTea"));
                lifestyle.setEatsHomeFood(rs.getBoolean("HomeFood"));
                lifestyle.setIsVegetarian(rs.getBoolean("Vegetarian"));
            }
            return lifestyle;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertLifestyle(DataSource ds, boolean isSmoker, int averageNoOfCigarettes, boolean isAlcoholic, int averageNoOfDrinks, String useStimulants, int consumptionOfCoffeeAndTea, int consumptionOfSoftDrinks, boolean haveRegularMeals, boolean eatsHomeFood, boolean isVegetarian) throws Exception {
        int idLifestyle = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertLifestyle(?,?,?,?,?,?,?,?,?,?)}")) {
            statement.setBoolean(1, isSmoker);
            statement.setInt(2, averageNoOfCigarettes);
            statement.setBoolean(3, isAlcoholic);
            statement.setInt(4, averageNoOfDrinks);
            statement.setString(5, useStimulants.trim());
            statement.setInt(6, consumptionOfCoffeeAndTea);
            statement.setInt(7, consumptionOfSoftDrinks);
            statement.setBoolean(8, haveRegularMeals);
            statement.setBoolean(9, eatsHomeFood);
            statement.setBoolean(10, isVegetarian);

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idLifestyle = rs.getInt(1);
            }

            return idLifestyle;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateLifestyle(DataSource ds, int idLifestyle, boolean isSmoker, int averageNoOfCigarettes, boolean isAlcoholic, int averageNoOfDrinks, String useStimulants, int consumptionOfCoffeeAndTea, int consumptionOfSoftDrinks, boolean haveRegularMeals, boolean eatsHomeFood, boolean isVegetarian) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateLifestyle(?,?,?,?,?,?,?,?,?,?,?)}")) {
            statement.setInt(1, idLifestyle);
            statement.setBoolean(2, isSmoker);
            statement.setInt(3, averageNoOfCigarettes);
            statement.setBoolean(4, isAlcoholic);
            statement.setInt(5, averageNoOfDrinks);
            statement.setString(6, useStimulants.trim());
            statement.setInt(7, consumptionOfCoffeeAndTea);
            statement.setInt(8, consumptionOfSoftDrinks);
            statement.setBoolean(9, haveRegularMeals);
            statement.setBoolean(10, eatsHomeFood);
            statement.setBoolean(11, isVegetarian);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public PatientFull getPatientFull(DataSource ds, int idPatientFull) throws Exception {
        PatientFull patient = new PatientFull();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetPatientFull(?)}")) {
            statement.setInt(1, idPatientFull);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                patient.setIdPatientFull(idPatientFull);
                patient.setDateOfBirth(rs.getDate("DateOfBirth"));
                patient.setPatientShortData(getPatientShort(getSource(), rs.getInt("PatientID")));
                patient.setPermanentAddress(getContactDetailsAddress(getSource(), rs.getInt("PermanentAdressID")));
                patient.setPresentAddress(getContactDetailsAddress(getSource(), rs.getInt("PresentAdressID")));
                patient.setPersonalDetails(getPersonalDetails(getSource(), rs.getInt("PersonalDetailsID")));
                patient.setProffesionDetails(getProffesionDetails(getSource(), rs.getInt("ProfessionDetailsID")));
                patient.setLifestyle(getLifestyle(getSource(), rs.getInt("LifestyleID")));
                patient.setBasicComplaints(getBasicComplaints(getSource(), rs.getInt("BasicComplaintsID")));
                patient.setMedicalComplaints(getImportantMedicalComplaints(getSource(), rs.getInt("ImportantMedicalComplaintsID")));
                patient.setContactDetails(getContactDetailsContact(getSource(), rs.getInt("ContactDetailsContactID")));
            }
            return patient;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<PatientFull> getAllPatientsFull(DataSource ds) throws Exception {
        List<PatientFull> patients = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetAllPatients()}")) {
            statement.execute();

            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                PatientFull patient = new PatientFull();

                patient.setIdPatientFull(rs.getInt("IDPatientFull"));
                patient.setPatientShortData(getPatientShort(getSource(), rs.getInt("PatientID")));
                patient.setDateOfBirth(rs.getDate("DateOfBirth"));
                patient.setPresentAddress(getContactDetailsAddress(getSource(), rs.getInt("PresentAdressID")));
                patient.setPermanentAddress(getContactDetailsAddress(getSource(), rs.getInt("PermanentAdressID")));
                patient.setPersonalDetails(getPersonalDetails(getSource(), rs.getInt("PersonalDetailsID")));
                patient.setProffesionDetails(getProffesionDetails(getSource(), rs.getInt("ProfessionDetailsID")));
                patient.setLifestyle(getLifestyle(getSource(), rs.getInt("LifestyleID")));
                patient.setBasicComplaints(getBasicComplaints(getSource(), rs.getInt("BasicComplaintsID")));
                patient.setMedicalComplaints(getImportantMedicalComplaints(getSource(), rs.getInt("ImportantMedicalComplaintsID")));
                patient.setContactDetails(getContactDetailsContact(getSource(), rs.getInt("ContactDetailsContactID")));

                patients.add(patient);
            }

            return patients;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertPatientFull(DataSource ds, int patientID, Date dateOfBirth, int permanentAddressID, int presentAddressID, int personalDetailsID, int proffessionDetailsID, int lifestyleID, int basicComplaintsID, int importantMedicalComplaintsID, int contactDetailsContactID) throws Exception {
        int idPatientFull = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertPatientFull(?,?,?,?,?,?,?,?,?,?)}")) {
            statement.setInt(1, patientID);
            statement.setDate(2, dateOfBirth);
            statement.setInt(3, permanentAddressID);
            statement.setInt(4, presentAddressID);
            statement.setInt(5, personalDetailsID);
            statement.setInt(6, proffessionDetailsID);
            statement.setInt(7, lifestyleID);
            statement.setInt(8, basicComplaintsID);
            statement.setInt(9, importantMedicalComplaintsID);
            statement.setInt(10, contactDetailsContactID);

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idPatientFull = rs.getInt(1);
            }

            return idPatientFull;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updatePatientFull(DataSource ds, int idPatientFull, Date dateofBirth) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdatePatientFull(?,?)}")) {

            statement.setInt(1, idPatientFull);
            statement.setDate(2, dateofBirth);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Bill getBill(DataSource ds, int idBill) throws Exception {
        Bill bill = new Bill();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetBill(?)}")) {
            statement.setInt(1, idBill);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                bill.setIdBill(idBill);
                bill.setPatientFull(getPatientFull(getSource(), rs.getInt("PatientFullID")));
                bill.setPaymentMethod(rs.getString("PaymentMethod"));
                bill.setBillDate(rs.getDate("BillDate"));
                bill.setBillTime(rs.getTime("BillTime"));
            }

            return bill;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Bill> getAllBills(DataSource ds) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetAllBills()}")) {
            ResultSet rs = statement.executeQuery();
            List<Bill> bills = new ArrayList<>();

            while (rs.next()) {
                Bill bill = new Bill();

                bill.setIdBill(rs.getInt("IDBill"));
                bill.setPatientFull(getPatientFull(getSource(), rs.getInt("PatientFullID")));
                bill.setPaymentMethod(rs.getString("PaymentMethod"));
                bill.setBillDate(rs.getDate("BillDate"));
                bill.setBillTime(rs.getTime("BillTime"));

                bills.add(bill);
            }

            return bills;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertBill(DataSource ds, String paymentMethod, int patientFullID, Date dateOfBill, Time timeOfBill) throws Exception {
        int idBill = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertBill(?,?,?,?)}")) {
            statement.setString(1, paymentMethod.trim());
            statement.setInt(2, patientFullID);
            statement.setDate(3, dateOfBill);
            statement.setTime(4, timeOfBill);

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idBill = rs.getInt(1);
            }
            return idBill;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<AccountItem> getAccountItems(DataSource ds, int billID) throws Exception {
        List<AccountItem> items = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetAccountItemsForBill(?)}")) {
            statement.setInt(1, billID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                AccountItem item = new AccountItem();

                item.setIdItem(rs.getInt("IDAccountItem"));
                item.setName(rs.getString("ItemName"));
                item.setQuantity(rs.getInt("ItemQuantity"));
                item.setBill(getBill(getSource(), rs.getInt("BillID")));
                item.setPrice(rs.getDouble("ItemPrice"));

                items.add(item);
            }

            return items;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertAccountItems(DataSource ds, List<AccountItem> items) throws Exception {
        int insertedItems = -1;
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertAccountItem (?,?,?,?)}")) {
            for (AccountItem item : items) {
                statement.setString(1, item.getName());
                statement.setFloat(2, (float) item.getPrice());
                statement.setInt(3, item.getQuantity());
                statement.setInt(4, item.getBill().getIdBill());

                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    insertedItems += rs.getInt(1);
                }
            }
            return insertedItems;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Appointment getAppointment(DataSource ds, int idAppointment) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetAppointmentByID(?)}")) {
            Appointment app = new Appointment();

            statement.setInt(1, idAppointment);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                app.setIdAppointment(idAppointment);
                app.setPatientFull(getPatientFull(getSource(), rs.getInt("PatientFullID")));
                app.setDoctor(getDoctor(getSource(), rs.getInt("DoctorID")));
                app.setApointmentDate(rs.getDate("DateOfAppointment"));
                app.setAppointmentStart(rs.getTime("TimeOfAppointmentStart"));
                app.setAppointmentEnd(rs.getTime("TimeOfAppointmentEnd"));
                app.setAppointmentSummary(rs.getString("AppointmentSummary"));
                app.setMedicine(rs.getString("PrescribedMedicine"));
                app.setOrderedTests(rs.getString("OrderedTests"));
                app.setTreatment(rs.getString("OrderedTreatment"));
            }

            return app;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Appointment> getAllAppointments(DataSource ds) throws Exception {
        List<Appointment> appointments = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetAllAppointments()}")) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Appointment app = new Appointment();

                app.setIdAppointment(rs.getInt("IDAppointment"));
                app.setPatientFull(getPatientFull(getSource(), rs.getInt("PatientFullID")));
                app.setDoctor(getDoctor(getSource(), rs.getInt("DoctorID")));
                app.setApointmentDate(rs.getDate("DateOfAppointment"));
                app.setAppointmentStart(rs.getTime("TimeOfAppointmentStart"));
                app.setAppointmentEnd(rs.getTime("TimeOfAppointmentEnd"));
                app.setAppointmentSummary(rs.getString("AppointmentSummary"));
                app.setMedicine(rs.getString("PrescribedMedicine"));
                app.setOrderedTests(rs.getString("OrderedTests"));
                app.setTreatment(rs.getString("OrderedTreatment"));

                appointments.add(app);
            }
            return appointments;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertAppointment(DataSource ds, Date date, Time startOfAppointment, Time endOfAppointment, int patientFullID, int doctorID, String appointmentSummary, String orderedTests, String prescribedMedicine, String orderedTreatement) throws Exception {
        int idAppointment = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertAppointment(?,?,?,?,?,?,?,?,?)}")) {
            statement.setDate(1, date);
            statement.setTime(2, startOfAppointment);
            statement.setTime(3, endOfAppointment);
            statement.setInt(4, patientFullID);
            statement.setInt(5, doctorID);
            statement.setString(6, appointmentSummary);
            statement.setString(7, orderedTests);
            statement.setString(8, prescribedMedicine);
            statement.setString(9, orderedTreatement);

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idAppointment = rs.getInt(1);
            }

            return idAppointment;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateAppointment(DataSource ds, int idAppointment, Date date, Time startOfAppointment, Time endOfAppointment, int patientFullID, int doctorID, String appointmentSummary, String orderedTests, String prescribedMedicine, String orderedTreatement) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateAppointment(?,?,?,?,?,?,?,?,?,?)}")) {
            statement.setInt(1, idAppointment);
            statement.setDate(2, date);
            statement.setTime(3, startOfAppointment);
            statement.setTime(4, endOfAppointment);
            statement.setInt(5, patientFullID);
            statement.setInt(6, doctorID);
            statement.setString(7, appointmentSummary);
            statement.setString(8, orderedTests);
            statement.setString(9, prescribedMedicine);
            statement.setString(10, orderedTreatement);

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int insertNextOfKin(DataSource ds, String name, String surname, String middlename, String relationship, int contactDetailsContactID, int contactDetailsAddressID) throws Exception {
        int idNextOfKin = -1;

        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL InsertNextOfKin(?,?,?,?,?,?)}")) {
            statement.setString(1, name);
            statement.setString(2, surname.trim());
            statement.setString(3, middlename.trim());
            statement.setString(4, relationship.trim());
            statement.setInt(5, contactDetailsContactID);
            statement.setInt(6, contactDetailsAddressID);

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idNextOfKin = rs.getInt(1);
            }

            return idNextOfKin;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateNextOfKin(DataSource ds, int idNextOfKin, String name, String surname, String middlename, String relationship) throws Exception {
        try (Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL UpdateNextOfKin(?,?,?,?,?)}")) {
            statement.setInt(1, idNextOfKin);
            statement.setString(2, name.trim());
            statement.setString(3, surname.trim());
            statement.setString(4, middlename.trim());
            statement.setString(5, relationship.trim());

            return statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    

    @Override
    public NextOfKin getNextOfKin(DataSource ds, int idNextOfKin) throws Exception {
                NextOfKin nextOfKin = new NextOfKin();

        try(Connection con = ds.getConnection();
                CallableStatement statement = con.prepareCall("{CALL GetNextOfKin(?)}"))
        {
            statement.setInt(1, idNextOfKin);
            ResultSet rs = statement.executeQuery();

            if (rs.next())
            {
                nextOfKin.setIdNextOfKin(idNextOfKin);
                nextOfKin.setName(rs.getString("Name"));
                nextOfKin.setSurname(rs.getString("Surname"));
                nextOfKin.setMiddlename(rs.getString("Middlename"));
                nextOfKin.setRelationship(rs.getString("Relationship"));
                nextOfKin.setContactDetails(getContactDetailsContact(getSource(), rs.getInt("ContactDetailsContactID")));
                nextOfKin.setAddressDetails(getContactDetailsAddress(getSource(), rs.getInt("ContactDetailsAddressID")));
            }

            return nextOfKin;
        } catch (Exception e)
        {
            throw e;
        }
    }
}
