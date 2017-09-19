/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.repo;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import javax.sql.DataSource;
import models.classes.appointment.Appointment;
import models.classes.bill.AccountItem;
import models.classes.bill.Bill;
import models.classes.doctor.Doctor;
import models.classes.doctor.Specialization;
import models.classes.patient.*;

/**
 *
 * @author amd
 */
public interface IRepo {

    public abstract DataSource getSource();

    public abstract int insertContactDetailsContact(DataSource ds, String telephoneWork, String telephoneHome, String mobile, String pager, String fax, String email) throws Exception;
    public abstract int UpdateContactDetailsContact(DataSource ds,int idContactDetailsContact,String telephoneWork, String telephoneHome, String mobile, String pager, String fax, String email) throws Exception;
    public abstract ContactDetailsContact getContactDetailsContact(DataSource ds,int idContactDetailsContact) throws Exception;
    
    

    public abstract int insertPatient(DataSource ds,String name,String surname,String middlename,String sex,String statementOfComplaint,String contactPhone1,String contactPhone2,int nextOfKinID,boolean isFollowUp) throws Exception;
    public abstract int updatePatient(DataSource ds,int idPatient,String name,String surname,String middlename,String sex,String statementOfComplaint,String contactPhone1,String contactPhone2 ,boolean isFollowUp) throws Exception;
    public abstract PatientShort getPatientShort(DataSource ds,int idPatient) throws Exception;
    public abstract List<PatientShort> getPatients(DataSource ds) throws Exception;
    
    

    public abstract int insertNextOfKin(DataSource ds,String name,String surname,String middlename,String relationship,int contactDetailsContactID,int contactDetailsAddressID) throws Exception;
    public abstract int updateNextOfKin(DataSource ds,int idNextOfKin,String name,String surname,String middlename,String relationship) throws Exception;
    public abstract NextOfKin getNextOfKin(DataSource ds, int idNextOfKin) throws Exception;


    
    
    public abstract void insertSpecialization(DataSource ds, String Specialization) throws Exception;
    public abstract int deleteSpecialization(DataSource ds, int idSpecialization) throws Exception;
    public abstract int updateSpecialization(DataSource ds, int idSpecialization, String specializationName) throws Exception;
    public abstract List<Specialization> getSpecializations (DataSource ds) throws Exception;
    public abstract Specialization getSpecialization(DataSource ds, int idSpecialization) throws Exception;
    
    
    public abstract ContactDetailsAddress getContactDetailsAddress(DataSource ds, int idContactDetailsAddress) throws Exception;
    public abstract int insertContactDetailsAddress(DataSource ds, String doorNumber, String street, String area, String city, String state, String pincode) throws Exception;
    public abstract int updateContactDetailsAddress(DataSource ds, int idContactDetailsAddress, String doorNumber, String street, String area, String city, String state, String pincode) throws Exception;
    
    
    public abstract Doctor getDoctor(DataSource ds, int idDoctor) throws Exception;
    public abstract int insertDoctor(DataSource ds, String name, String surname, int specializationID, int contactDetailsContactID, int contactDetailsAddressID, boolean isActive) throws Exception;
    public abstract int updateDoctor(DataSource ds, int idDoctor, String name, String surname, int specializationID) throws Exception;
    public abstract int deleteDoctor(DataSource ds, int idDoctor) throws Exception;
    public abstract int updateDoctorStatus(DataSource ds, int idDoctor, boolean isActive) throws Exception;
    public abstract List<Doctor> getDoctors(DataSource ds) throws Exception;
    
    
    
    public abstract ProffesionDetails getProffesionDetails(DataSource ds, int idProffessionDetails) throws Exception;
    public abstract int insertProffessionDetails(DataSource ds, String occupation, int annualIncome) throws Exception;
    public abstract int updateProffessionDetails(DataSource ds, int idProffessionDetails, String occupation, int annualIncome) throws Exception;
    
    
    
    public abstract PersonalDetails getPersonalDetails(DataSource ds, int idPersonalDetails) throws Exception;
    public abstract int insertPersonalDetails(DataSource ds, String maritalStatus, String numberOfDependants, String height, String weight, String bloodType) throws Exception;
    public abstract int updatePersonalDetails(DataSource ds, int idPersonalDetails, String martialStatus, String numberOfDependants, String height, String weight, String bloodType) throws Exception;
    
    
    
    public abstract ImportantMedicalComplaints getImportantMedicalComplaints(DataSource ds, int idMedicalComplaints) throws Exception;
    public abstract int insertImportantMedicalComplaints(DataSource ds, boolean isDiabetic, boolean isHypertensive, String cardiacCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAllergies, String knownReactionsToDrugs, String majorSurgeries) throws Exception;
    public abstract int updateImportantMedicalComplaints(DataSource ds, int idMedicalComplaints, boolean isDiabetic, boolean isHypertensive, String cardiacCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAllergies, String knownReactionsToDrugs, String majorSurgeries) throws Exception;
    
    
    
    public abstract BasicComplaints getBasicComplaints(DataSource ds, int idComplaint) throws Exception;
    public abstract int insertBasicComplaints(DataSource ds, String statement, String treatmentHistory, String hospitalTreated) throws Exception;
    public abstract int updateBasicComplaints(DataSource ds, int idComplaint, String statement, String treatmentHistory, String hospitalTreated) throws Exception;
    
    
    
    public abstract Lifestyle getLifestyle(DataSource ds, int idLifestyle) throws Exception;
    public abstract int insertLifestyle(DataSource ds, boolean isSmoker, int averageNoOfCigarettes, boolean isAlcoholic, int averageNoOfDrinks, String useStimulants, int consumptionOfCoffeeAndTea, int consumptionOfSoftDrinks, boolean haveRegularMeals, boolean eatsHomeFood, boolean isVegetarian) throws Exception;
    public abstract int updateLifestyle(DataSource ds, int idLifestyle, boolean isSmoker, int averageNoOfCigarettes, boolean isAlcoholic, int averageNoOfDrinks, String useStimulants, int consumptionOfCoffeeAndTea, int consumptionOfSoftDrinks, boolean haveRegularMeals, boolean eatsHomeFood, boolean isVegetarian) throws Exception;
    
    
    
    public abstract PatientFull getPatientFull(DataSource ds, int idPatientFull) throws Exception;
    public abstract List<PatientFull> getAllPatientsFull(DataSource ds) throws Exception;
    public abstract int insertPatientFull(DataSource ds, int patientID, Date dateOfBirth, int permanentAddressID, int persentAddressID, int personalDetailsID, int proffessionDetailsID, int lifestyleID, int basicComplaintsID, int importantMedicalComplaintsID, int contactDetailsContactID) throws Exception;
    public abstract int updatePatientFull(DataSource ds, int idPatientFull, Date dateofBirth) throws Exception;
    
    
    
    public abstract Bill getBill(DataSource ds, int idBill) throws Exception;
    public abstract List<Bill> getAllBills(DataSource ds) throws Exception;
    public abstract int insertBill(DataSource ds, String paymentMethod, int patientFullID, Date dateOfBill, Time timeOfBill) throws Exception;
    
    
    
    //TODO accountitems
    
    public abstract List<AccountItem> getAccountItems(DataSource ds, int billID) throws Exception;
    public abstract int insertAccountItems(DataSource ds, List<AccountItem> items) throws Exception;
    
    
    
    public abstract Appointment getAppointment(DataSource ds, int idAppointment) throws Exception;
    public abstract List<Appointment> getAllAppointments(DataSource ds) throws Exception;
    public abstract int insertAppointment(DataSource ds, Date date, Time startOfAppointment, Time endOfAppointment, int patientFullID, int doctorID, String appointmentSummary, String orderedTests, String prescribedMedicine, String orderedTreatement) throws Exception;
    public abstract int updateAppointment(DataSource ds, int idAppointment, Date date, Time startOfAppointment, Time endOfAppointment, int patientFullID, int doctorID, String appointmentSummary, String orderedTests, String prescribedMedicine, String orderedTreatement) throws Exception;

    

}
