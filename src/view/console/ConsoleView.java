/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.console;

import View.View;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
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
import models.repo.Repository;

/**
 *
 * @author amd
 */
public class ConsoleView implements View {

    Scanner sc = new Scanner(System.in);
    Repository repo = new Repository();

    @Override
    public void initialize() {
        startMenu();
    }

    private void printStartMenu() {
        System.out.println("/////////////////////////////////////////////");
        System.out.println("/ 1. Patients administration");
        System.out.println("/ 2. Doctors administration");
        System.out.println("/ 3. Appointments administration");
        System.out.println("/ 4. Billings administration");
        System.out.println("/ Q. Exit application");
        System.out.println("/////////////////////////////////////////////");
        System.out.println(">   ");
    }

    public void startMenu() {
        while (true) {
            printStartMenu();

            String choice = sc.nextLine().toUpperCase().trim();

            switch (choice) {
                case "1":
                    menuPatients();
                    break;
                case "2":
                    menuDoctors();
                    break;
                case "3":
                    menuAppointments();
                    break;
                case "4":
                    menuBillings();
                    break;
                case "5":
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (choice.equals("Q")) {
                break;
            }
        }

    }

    private void printMenuPatients() {
        System.out.println("/////////////////////////////////////////////");
        System.out.println("/ 1. Print patient data");
        System.out.println("/ 2. Register new patient (short form)");
        System.out.println("/ 3. Register new patient (coprehensive form)");
        System.out.println("/ 4. Update patient data (coprehensive form)");
        System.out.println("/ 0. Back");
        System.out.println("/////////////////////////////////////////////");
        System.out.println(">   ");
    }

    private void menuPatients() {
        while (true) {
            printMenuPatients();

            String choice = sc.nextLine().toUpperCase().trim();
            switch (choice) {
                case "1":
                    printPatientData();
                    break;
                case "2":
                    registerPatientShort();
                    break;
                case "3":
                    registerPatientLong();
                    break;
                case "4":
                    updatePatientData();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if (choice.equals("0")) {
                break;
            }
        }
    }

    public void updatePatientData() {
        System.out.println("////    Update patient data    /////");
        System.out.println("Type 0 to CANCEL");
        System.out.print(">");

        try {
            if (!sc.nextLine().equals("0")) {

                String input;
                PatientFull patient = searchForPatient();
                if (patient == null) {
                    System.out.println("Patient not found");
                    return;
                }

                patient.setPatientShortData(patient.getPatientShortData()); // cant change short data

                System.out.println("Type '.' to accept existing data");
                while (true) {

                    System.out.println("Date of brith (dd-mm-yyyy) : ");
                    System.out.print(">");
                    input = sc.nextLine();
                    if (!input.equals(".")) {
                        try {
                            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                            java.util.Date tmpDate = date.parse(input);
                            patient.setDateOfBirth(new Date(tmpDate.getTime()));
                            break;
                        } catch (ParseException e) {
                            System.out.println("Wrong date format - registerPateintLong()");
                            System.out.printf("\n%s\n", e.getMessage());
                        }
                    } else {
                        break;
                    }
                }

                updatePatientData(patient.getPatientShortData().getIdPatient());

                repo.updatePatientFull(repo.getSource(), patient.getIdPatientFull(), patient.getDateOfBirth());

                System.out.println("\nPatient permanent address data:");
                System.out.println("Press '.' to skip update");
                updateAddressDetails(patient.getPermanentAddress().getIdContactDetailsAddress());

                System.out.println("\nPatient present address data:");
                System.out.println("Press '.' to skip update");
                updateAddressDetails(patient.getPresentAddress().getIdContactDetailsAddress());

                System.out.println("\nPatient contact details:");
                System.out.println("Press '.' to skip update");
                updateContactDetails(patient.getContactDetails().getIdContactDetailsContact());

                System.out.println("\nPatient personal details:");
                System.out.println("Press '.' to skip update");
                updatePersonalDetails(patient.getPersonalDetails().getIdPersonalDetails());

                System.out.println("\nPatient proffession details:");
                System.out.println("Press '.' to skip update");
                updateProffessionDetails(patient.getProffesionDetails().getIdProffessionDetails());

                System.out.println("\nPatient lifestyle details:");
                System.out.println("Press '.' to skip update");
                updateLifestyleDetails(patient.getLifestyle().getIdLifestyle());

                System.out.println("\nPatient basic complaints:");
                System.out.println("Press '.' to skip update");
                updateBasicComplaints(patient.getBasicComplaints().getIdBasicComplaints());

                System.out.println("\nPatient important medical complaints:");
                System.out.println("Press '.' to skip update");
                updateImportantMedicalComplaintsData(patient.getMedicalComplaints().getIdImportantMedicalComplaints());

            }
        } catch (Exception e) {
            System.out.println("Failed to update patient data");
        }

    }

    private void updateImportantMedicalComplaintsData(int idMedicalComplaints) throws Exception {
        boolean isUpdated = false;
        String scInput;
        ImportantMedicalComplaints medicalComplaints
                = repo.getImportantMedicalComplaints(
                        repo.getSource(),
                        idMedicalComplaints);

        while (true) {
            System.out.println("Diabetic: (Y/N)");
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    medicalComplaints.setIsDiabetic(true);
                    break;
                }
                if (scInput.equals("N")) {
                    medicalComplaints.setIsDiabetic(false);
                    break;
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Hypertensive: (Y/N)");
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    medicalComplaints.setIsHypertenisve(true);
                    break;
                }
                if (scInput.equals("N")) {
                    medicalComplaints.setIsHypertenisve(false);
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println(String.format("Cardiac condition: %s",
                medicalComplaints.getCardiacCondition()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            medicalComplaints.setCardiacCondition(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Digestive condition: %s",
                medicalComplaints.getDigestiveCondition()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            medicalComplaints.setDigestiveCondition(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Orthopedic condition: %s",
                medicalComplaints.getOrthopedicCondition()));
        System.out.print(">");
        if (!scInput.equals(".")) {
            medicalComplaints.setOrthopedicCondition(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Muscular condition: %s",
                medicalComplaints.getMuscularCondition()));
        System.out.print(">");
        if (!scInput.equals(".")) {
            medicalComplaints.setMuscularCondition(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Neurological condition: %s",
                medicalComplaints.getNeurologicalCondition()));
        System.out.print(">");
        if (!scInput.equals(".")) {
            medicalComplaints.setNeurologicalCondition(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Known allergies: %s",
                medicalComplaints.getKnownAllegries()));
        System.out.print(">");
        if (!scInput.equals(".")) {
            medicalComplaints.setKnownAllegries(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Known reactions to specific drugs: %s",
                medicalComplaints.getKnownReactionToDrugs()));
        System.out.print(">");
        if (!scInput.equals(".")) {
            medicalComplaints.setKnownReactionToDrugs(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Major surgeries: %s",
                medicalComplaints.getMajorSurgeries()));
        System.out.print(">");
        if (!scInput.equals(".")) {
            medicalComplaints.setMajorSurgeries(scInput);
            isUpdated = true;
        }

        if (isUpdated) {
            repo.updateImportantMedicalComplaints(repo.getSource(),
                    idMedicalComplaints,
                    medicalComplaints.isIsDiabetic(),
                    medicalComplaints.isIsHypertenisve(),
                    medicalComplaints.getCardiacCondition(),
                    medicalComplaints.getDigestiveCondition(),
                    medicalComplaints.getOrthopedicCondition(),
                    medicalComplaints.getMuscularCondition(),
                    medicalComplaints.getNeurologicalCondition(),
                    medicalComplaints.getKnownAllegries(),
                    medicalComplaints.getKnownReactionToDrugs(),
                    medicalComplaints.getMajorSurgeries());
        }
    }

    private void updateBasicComplaints(int idBasicComplaints) throws Exception {
        boolean isUpdated = false;
        String scInput;
        BasicComplaints basicComplaints = repo.getBasicComplaints(
                repo.getSource(),
                idBasicComplaints);

        System.out.println("Statement of complaint:");
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            basicComplaints.setStatementOfComplaint(scInput);
            isUpdated = true;
        }

        System.out.println("History of previous treatments:");
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            basicComplaints.setHistoryOfPreviousTreatment(scInput);
            isUpdated = true;
        }

        System.out.println("Treated by physican or hospital?");
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            basicComplaints.setPhysicianOrHospital(scInput);
            isUpdated = true;
        }

        if (isUpdated) {
            repo.updateBasicComplaints(repo.getSource(),
                    idBasicComplaints,
                    basicComplaints.getStatementOfComplaint(),
                    basicComplaints.getHistoryOfPreviousTreatment(),
                    basicComplaints.getPhysicianOrHospital());
        }
    }

    private void updateLifestyleDetails(int idLifestyle) throws Exception {
        boolean isUpdated = false;
        String scInput;
        Lifestyle lifestyle = repo.getLifestyle(
                repo.getSource(),
                idLifestyle);

        while (true) {
            System.out.println(String.format("Smoker: (Y/N) %s", lifestyle.isIsSmoker()));
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    lifestyle.setIsSmoker(true);
                    break;
                }
                if (scInput.equals("N")) {
                    lifestyle.setIsSmoker(false);
                    break;
                }
            } else {
                break;
            }
        }

        if (lifestyle.isIsSmoker()) {
            while (true) {
                System.out.println(String.format("Avarege number of cigarettes per day: %d",
                        lifestyle.getAverageNoOfCigarettes()));
                System.out.print(">");
                scInput = sc.nextLine();
                if (!scInput.equals(".")) {
                    try {
                        lifestyle.setAverageNoOfCigarettes(Integer.parseInt(scInput));
                        isUpdated = true;
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input, try again.");
                    }
                } else {
                    break;
                }
            }
        }

        while (true) {
            System.out.println(String.format("Alcoholic: (Y/N) %s", lifestyle.isIsAlcoholic()));
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    lifestyle.setIsAlcoholic(true);
                    break;
                }
                if (scInput.equals("N")) {
                    lifestyle.setIsAlcoholic(false);
                    break;
                }
            } else {
                break;
            }
        }

        if (lifestyle.isIsAlcoholic()) {
            while (true) {
                System.out.println(String.format("Average number of drinks per day: %d",
                        lifestyle.getAverageNoOfDrinks()));
                System.out.print(">");
                scInput = sc.nextLine();
                if (!scInput.equals(".")) {
                    isUpdated = true;
                    try {
                        lifestyle.setAverageNoOfDrinks(Integer.parseInt(scInput));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input, try again.");
                    }
                } else {
                    break;
                }
            }
        } else {
            lifestyle.setAverageNoOfDrinks(0);
        }

        System.out.println(String.format("Stimulants used: %s", lifestyle.getUseStimulants()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            lifestyle.setUseStimulants(scInput);
            isUpdated = true;
        }

        while (true) {
            System.out.println(String.format("Avarege consumption of coffee and tea per day: %d",
                    lifestyle.getConsumptionOfCoffeeAndTea()));
            System.out.print(">");
            scInput = sc.nextLine();
            if (!scInput.equals(".")) {
                isUpdated = true;
                try {
                    lifestyle.setConsumptionOfCoffeeAndTea(Integer.parseInt(scInput));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("Avarege consumption of soft drinks per day: %d",
                    lifestyle.getConsumptionOfSoftDrinks()));
            System.out.print(">");
            scInput = sc.nextLine();
            if (!scInput.equals(".")) {
                try {
                    lifestyle.setConsumptionOfSoftDrinks(Integer.parseInt(scInput));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("Has regular meals: (Y/N) %s",
                    lifestyle.isHaveRegularMeals()));
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    lifestyle.setHaveRegularMeals(true);
                    break;
                }
                if (scInput.equals("N")) {
                    lifestyle.setHaveRegularMeals(false);
                    break;
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("Eats homemade food: (Y/N) %s",
                    lifestyle.isEatsHomeFood()));
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    lifestyle.setEatsHomeFood(true);
                    break;
                }
                if (scInput.equals("N")) {
                    lifestyle.setEatsHomeFood(false);
                    break;
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("Vegetarian: (Y/N) %s",
                    lifestyle.isIsVegetarian()));
            System.out.print(">");
            scInput = sc.nextLine().toUpperCase();
            if (!scInput.equals(".")) {
                isUpdated = true;
                if (scInput.equals("Y")) {
                    lifestyle.setIsVegetarian(true);
                    break;
                }
                if (scInput.equals("N")) {
                    lifestyle.setIsVegetarian(false);
                    break;
                }
            } else {
                break;
            }
        }

        if (isUpdated) {

            repo.updateLifestyle(repo.getSource(),
                    idLifestyle,
                    lifestyle.isIsSmoker(),
                    lifestyle.getAverageNoOfCigarettes(),
                    lifestyle.isIsAlcoholic(),
                    lifestyle.getAverageNoOfDrinks(),
                    lifestyle.getUseStimulants(),
                    lifestyle.getConsumptionOfCoffeeAndTea(),
                    lifestyle.getConsumptionOfSoftDrinks(),
                    lifestyle.isHaveRegularMeals(),
                    lifestyle.isEatsHomeFood(),
                    lifestyle.isIsVegetarian());
        }
    }

    private void updateProffessionDetails(int idProffessionDetails) throws Exception {
        boolean isUpdated = false;
        String scInput;
        ProffesionDetails profDetails = repo.getProffesionDetails(
                repo.getSource(),
                idProffessionDetails);

        System.out.println(String.format("Occupation: %s", profDetails.getOccupation()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            profDetails.setOccupation(scInput);
            isUpdated = true;
        }

        while (true) {
            System.out.println(String.format("Gross annual income: %d", profDetails.getGrossAnnualIncome()));
            System.out.print(">");
            scInput = sc.nextLine();
            if (!scInput.equals(".")) {
                isUpdated = true;
                try {
                    profDetails.setGrossAnnualIncome(Integer.parseInt(scInput));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                break;
            }
        }

        if (isUpdated) {
            repo.updateProffessionDetails(repo.getSource(),
                    idProffessionDetails,
                    profDetails.getOccupation(),
                    profDetails.getGrossAnnualIncome());

        }
    }

    private void updatePersonalDetails(int idPersonalDetails) throws Exception {
        boolean isUpdated = false;
        String scInput;
        PersonalDetails personalDetails = repo.getPersonalDetails(
                repo.getSource(),
                idPersonalDetails);

        System.out.println(String.format("Marital status: %s", personalDetails.getMaritalStatus()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            personalDetails.setMaritalStatus(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Number of dependents: %s", personalDetails.getNumberOfDependents()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            personalDetails.setNumberOfDependents(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Height: %s", personalDetails.getHeight()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            personalDetails.setHeight(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Weight: %s", personalDetails.getWeight()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            personalDetails.setWeight(scInput);
            isUpdated = true;
        }

        System.out.println(String.format("Blood type: %s", personalDetails.getBloodType()));
        System.out.print(">");
        scInput = sc.nextLine();
        if (!scInput.equals(".")) {
            personalDetails.setBloodType(scInput);
            isUpdated = true;
        }

        if (isUpdated) {
            repo.updatePersonalDetails(
                    repo.getSource(),
                    idPersonalDetails,
                    personalDetails.getMaritalStatus(),
                    personalDetails.getNumberOfDependents(),
                    personalDetails.getHeight(),
                    personalDetails.getWeight(),
                    personalDetails.getBloodType());
        }
    }

    private void updatePatientData(int patientID) throws Exception {
        boolean isUpdated = false; //flag to check if update needs to be done, optimization
        String input;

        PatientShort patient = repo.getPatientShort(repo.getSource(), patientID);

        System.out.println(String.format("Name: %s", patient.getName()));
        System.out.print(">");
        input = sc.nextLine();
        if (!input.equals(".")) {
            patient.setName(input);
            isUpdated = true;
        }

        System.out.println(String.format("Surname: %s", patient.getSurname()));
        System.out.print(">");
        input = sc.nextLine();
        if (!input.equals(".")) {
            patient.setSurname(input);
            isUpdated = true;
        }

        System.out.println(String.format("Middlename: %s", patient.getMiddlename()));
        System.out.print(">");
        input = sc.nextLine();
        if (!input.equals(".")) {
            patient.setMiddlename(input);
            isUpdated = true;
        }

        while (true) {
            System.out.println(String.format("Sex: (M/F)", patient.getSex()));
            System.out.print(">");
            input = sc.nextLine().toUpperCase();
            if (!input.equals(".")) {
                if (input.matches("M|F")) {
                    patient.setSex(input);
                    isUpdated = true;
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println("Statement of complaint:");
        System.out.print(">");
        input = sc.nextLine();
        if (!input.equals(".")) {
            patient.setStatementOfComplaint(input);
            isUpdated = true;
        }

        while (true) {
            System.out.println(String.format("Is follow up patient: %s (Y/N)", patient.isIsFollowUp()));
            System.out.print(">");
            input = sc.nextLine().toUpperCase();
            if (!input.equals(".")) {
                if (input.equals("Y")) {
                    patient.setIsFollowUp(true);
                    isUpdated = true;
                    break;
                }
                if (input.equals("N")) {
                    patient.setIsFollowUp(false);
                    isUpdated = true;
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println("\nNEXT OF KIN DETAILS: (press 'a' to update)");
        System.out.print(">");
        if (sc.nextLine().equals(".")) {
            updateNextOfKin(patient.getNextOfKin().getIdNextOfKin());
        }

        if (isUpdated) {

            repo.updatePatient(repo.getSource(),
                    patient.getIdPatient(),
                    patient.getName(),
                    patient.getSurname(),
                    patient.getMiddlename(),
                    patient.getSex(),
                    patient.getStatementOfComplaint(),
                    patient.getContact_1(),
                    patient.getContact_2(),
                    patient.isIsFollowUp());
        }
    }

    private void updateNextOfKin(int idNextOfKin) throws Exception {
        boolean isUpdated = false;
        NextOfKin tmp = repo.getNextOfKin(repo.getSource(), idNextOfKin);

        System.out.println(String.format("Name: %s", tmp.getName()));
        System.out.print(">");
        String name = sc.nextLine();
        if (!name.equals(".")) {
            tmp.setName(name);
            isUpdated = true;
        }

        System.out.println(String.format("Surname: %s", tmp.getSurname()));
        System.out.print(">");
        String surname = sc.nextLine();
        if (!surname.equals(".")) {
            tmp.setSurname(surname);
            isUpdated = true;
        }

        System.out.println(String.format("Middlename: %s", tmp.getMiddlename()));
        System.out.print(">");
        String middlename = sc.nextLine();
        if (!middlename.equals(".")) {
            tmp.setMiddlename(middlename);
            isUpdated = true;
        }

        System.out.println(String.format("Relationship to patient: %s", tmp.getRelationship()));
        System.out.print(">");
        String relationship = sc.nextLine();
        if (!relationship.equals(".")) {
            tmp.setRelationship(relationship);
            isUpdated = true;
        }

        if (isUpdated) {
            repo.updateNextOfKin(repo.getSource(),
                    tmp.getIdNextOfKin(),
                    tmp.getName(),
                    tmp.getSurname(),
                    tmp.getMiddlename(),
                    tmp.getRelationship());
        }

        System.out.println("\nNext of kin contact details: (press . to update)");
        System.out.print(">");
        if (sc.nextLine().equals(".")) {
            updateContactDetails(tmp.getContactDetails().getIdContactDetailsContact());
        }
        System.out.println("\nNext of kin address details: (press . to update)");
        if (sc.nextLine().equals(".")) {
            updateAddressDetails(tmp.getAddressDetails().getIdContactDetailsAddress());
        }
    }

    private void updateContactDetails(int contactDetailsID) throws Exception {
        boolean isUpdated = false;
        ContactDetailsContact contactDetails = repo.getContactDetailsContact(
                repo.getSource(),
                contactDetailsID);

        System.out.println(String.format("Telephone work: %s", contactDetails.getTelephoneWork()));
        System.out.print(">");
        String telephoneWork = sc.nextLine();
        if (!telephoneWork.equals(".")) {
            contactDetails.setTelephoneWork(telephoneWork);
            isUpdated = true;
        }

        System.out.println(String.format("Telephone home: %s", contactDetails.getTelephoneHome()));
        System.out.print(">");
        String telephoneHome = sc.nextLine();
        if (!telephoneHome.equals(".")) {
            contactDetails.setTelephoneHome(telephoneHome);
            isUpdated = true;
        }

        System.out.println(String.format("Mobile phone: %s", contactDetails.getTelephoneMobile()));
        System.out.print(">");
        String telephoneMobile = sc.nextLine();
        if (!telephoneMobile.equals(".")) {
            contactDetails.setTelephoneMobile(telephoneMobile);
            isUpdated = true;
        }

        System.out.println(String.format("Pager: %s", contactDetails.getPager()));
        System.out.print(">");
        String pager = sc.nextLine();
        if (!pager.equals(".")) {
            contactDetails.setPager(pager);
            isUpdated = true;
        }

        System.out.println(String.format("Fax: %s", contactDetails.getFax()));
        System.out.print(">");
        String fax = sc.nextLine();
        if (!fax.equals(".")) {
            contactDetails.setFax(fax);
            isUpdated = true;
        }

        System.out.println(String.format("Email: %s", contactDetails.getEmail()));
        System.out.print(">");
        String email = sc.nextLine();
        if (!email.equals(".")) {
            contactDetails.setEmail(email);
            isUpdated = true;
        }

        if (isUpdated) {
            repo.UpdateContactDetailsContact(
                    repo.getSource(),
                    contactDetailsID,
                    contactDetails.getTelephoneWork(),
                    contactDetails.getTelephoneHome(),
                    contactDetails.getTelephoneMobile(),
                    contactDetails.getPager(),
                    contactDetails.getFax(),
                    contactDetails.getEmail());
        }
    }

    private void updateAddressDetails(int idAddressDetails) throws Exception {
        boolean dataUpdated = false;
        ContactDetailsAddress addressDetails = repo.getContactDetailsAddress(
                repo.getSource(),
                idAddressDetails);

        System.out.println(String.format("Street: %s", addressDetails.getStreet()));
        System.out.print(">");
        String street = sc.nextLine();
        if (!street.equals(".")) {
            addressDetails.setStreet(street);
            dataUpdated = true;
        }

        System.out.println(String.format("Door number: %s", addressDetails.getDoorNumber()));
        System.out.print(">");
        String doorNumber = sc.nextLine();
        if (!doorNumber.equals(".")) {
            addressDetails.setDoorNumber(doorNumber);
            dataUpdated = true;
        }

        System.out.println(String.format("City: %s", addressDetails.getCity()));
        System.out.print(">");
        String city = sc.nextLine();
        if (!city.equals(".")) {
            addressDetails.setCity(city);
            dataUpdated = true;
        }

        System.out.println(String.format("Area: %s", addressDetails.getArea()));
        System.out.print(">");
        String area = sc.nextLine();
        if (!area.equals(".")) {
            addressDetails.setArea(area);
            dataUpdated = true;
        }

        System.out.println(String.format("Pincode: %s", addressDetails.getPincode()));
        System.out.print(">");
        String pincode = sc.nextLine();
        if (!pincode.equals(".")) {
            addressDetails.setPincode(pincode);
            dataUpdated = true;
        }

        System.out.println(String.format("State: %s", addressDetails.getState()));
        System.out.print(">");
        String state = sc.nextLine();
        if (!state.equals(".")) {
            addressDetails.setState(state);
            dataUpdated = true;
        }

        if (dataUpdated) {

            repo.updateContactDetailsAddress(
                    repo.getSource(),
                    addressDetails.getIdContactDetailsAddress(),
                    addressDetails.getDoorNumber(),
                    addressDetails.getStreet(),
                    addressDetails.getArea(),
                    addressDetails.getCity(),
                    addressDetails.getState(),
                    addressDetails.getPincode());
        }

    }

    public void registerPatientLong() {

        System.out.println("////    Add new patient LONG    ////");
        System.out.print(">");

        try {
            PatientFull patient = new PatientFull();
            patient.setPatientShortData(insertShortPatientData());

            while (true) {
                System.out.println("Date of brith (dd-mm-yyyy) : ");
                System.out.print(">");

                try {
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date temp = date.parse(sc.nextLine());
                    patient.setDateOfBirth(new Date(temp.getTime()));
                    break;
                } catch (ParseException e) {
                    System.out.println("Wrong date format - registerPateintLong()");
                    System.out.printf("\n%s\n", e.getMessage());
                }
            }

            System.out.println("\nPatient permanent address data:");
            patient.setPermanentAddress(insertAddressDetails());

            System.out.println("\nPatient present address data:");
            patient.setPresentAddress(insertAddressDetails());

            System.out.println("\nPatient contact details:");
            patient.setContactDetails(insertContactDetails());

            System.out.println("\nPatient personal details:");
            patient.setPersonalDetails(insertPersonalDetails());

            System.out.println("\nPatient proffession details:");
            patient.setProffesionDetails(insertProffessionDetails());

            System.out.println("\nPatient lifestyle details:");
            patient.setLifestyle(insertLifestyleDetails());

            System.out.println("\nPatient basic complaints:");
            patient.setBasicComplaints(insertBasicComplaints());

            System.out.println("\nPatient important medical complaints:");
            patient.setMedicalComplaints(insertImportantMedicalComplaints());

            repo.insertPatientFull(repo.getSource(),
                    patient.getPatientShortData().getIdPatient(),
                    patient.getDateOfBirth(),
                    patient.getPermanentAddress().getIdContactDetailsAddress(),
                    patient.getPresentAddress().getIdContactDetailsAddress(),
                    patient.getPersonalDetails().getIdPersonalDetails(),
                    patient.getProffesionDetails().getIdProffessionDetails(),
                    patient.getLifestyle().getIdLifestyle(),
                    patient.getBasicComplaints().getIdBasicComplaints(),
                    patient.getMedicalComplaints().getIdImportantMedicalComplaints(),
                    patient.getContactDetails().getIdContactDetailsContact());

        } catch (Exception e) {
            System.out.println("Failed to register patient - registerPatientLong()");
            System.out.printf("\n%s", e.getMessage());
        }
    }

    private ImportantMedicalComplaints insertImportantMedicalComplaints() throws Exception {
        ImportantMedicalComplaints tmp = new ImportantMedicalComplaints();

        while (true) {
            System.out.println("Is diabetic: (Y/N)");
            String dummy = sc.nextLine().toUpperCase();
            if (dummy.equals("Y")) {
                tmp.setIsDiabetic(true);
                break;
            }
            if (dummy.equals("N")) {
                tmp.setIsDiabetic(false);
                break;
            }
        }

        while (true) {
            System.out.println("Is hypertensive: (Y/N)");
            String dummy = sc.nextLine().toUpperCase();
            if (dummy.equals("Y")) {
                tmp.setIsHypertenisve(true);
                break;
            }
            if (dummy.equals("N")) {
                tmp.setIsHypertenisve(false);
                break;
            }
        }

        System.out.println("Cardiac condition:");
        tmp.setCardiacCondition(sc.nextLine());

        System.out.println("Digestive condition:");
        tmp.setDigestiveCondition(sc.nextLine());

        System.out.println("Orthopedic condition:");
        tmp.setOrthopedicCondition(sc.nextLine());

        System.out.println("Muscular condition:");
        tmp.setMuscularCondition(sc.nextLine());

        System.out.println("Neurological condition:");
        tmp.setNeurologicalCondition(sc.nextLine());

        System.out.println("Known allergies:");
        tmp.setKnownAllegries(sc.nextLine());

        System.out.println("Known reactions to specific drugs:");
        tmp.setKnownReactionToDrugs(sc.nextLine());

        System.out.println("Major surgeries:");
        tmp.setMajorSurgeries(sc.nextLine());

        tmp.setIdImportantMedicalComplaints(repo.insertImportantMedicalComplaints(repo.getSource(),
                tmp.isIsDiabetic(),
                tmp.isIsHypertenisve(),
                tmp.getCardiacCondition(),
                tmp.getDigestiveCondition(),
                tmp.getOrthopedicCondition(),
                tmp.getMuscularCondition(),
                tmp.getNeurologicalCondition(),
                tmp.getKnownAllegries(),
                tmp.getKnownReactionToDrugs(),
                tmp.getMajorSurgeries()));

        return tmp;
    }

    private BasicComplaints insertBasicComplaints() throws Exception {

        BasicComplaints tmp = new BasicComplaints();

        System.out.println("Statemet of complaint:");
        tmp.setStatementOfComplaint(sc.nextLine());

        System.out.println("History of previous treatments:");
        tmp.setHistoryOfPreviousTreatment(sc.nextLine());

        System.out.println("Treated by physican or hospital?");
        tmp.setPhysicianOrHospital(sc.nextLine());

        tmp.setIdBasicComplaints(repo.insertBasicComplaints(repo.getSource(),
                tmp.getStatementOfComplaint(),
                tmp.getHistoryOfPreviousTreatment(),
                tmp.getPhysicianOrHospital()));

        return tmp;
    }

    private Lifestyle insertLifestyleDetails() throws Exception {
        Lifestyle tmp = new Lifestyle();

        while (true) {
            System.out.println(String.format("Is smoker: (Y/N) %s", tmp.isIsSmoker()));
            String dummy = sc.nextLine().toUpperCase();
            if (dummy.equals("Y")) {
                tmp.setIsSmoker(true);
                break;
            }
            if (dummy.equals("N")) {
                tmp.setIsSmoker(false);
                break;
            }
        }

        if (tmp.isIsSmoker()) {
            while (true) {
                System.out.println("Avarege number of cigarettes per day:");
                try {
                    tmp.setAverageNoOfCigarettes(Integer.parseInt(sc.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                }
            }
        }

        while (true) {
            System.out.println("Is alcoholic: (Y/N)");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("Y")) {
                tmp.setIsAlcoholic(true);
                break;
            }
            if (input.equals("N")) {
                tmp.setIsAlcoholic(false);
                break;
            }
        }

        if (tmp.isIsAlcoholic()) {
            while (true) {
                System.out.println("Avarege number of drinks per day:");
                try {
                    tmp.setAverageNoOfDrinks(Integer.parseInt(sc.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                }
            }
        }

        System.out.println("Stimulants used:");
        tmp.setUseStimulants(sc.nextLine());

        while (true) {
            System.out.println("Avarege consumption of coffee and tea per day:");
            try {
                tmp.setConsumptionOfCoffeeAndTea(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, try again.");
            }
        }

        while (true) {
            System.out.println("Avarege consumption of soft drinks per day:");
            try {
                tmp.setConsumptionOfSoftDrinks(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, try again.");
            }
        }

        while (true) {
            System.out.println("Has regular meals: (Y/N)");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("Y")) {
                tmp.setHaveRegularMeals(true);
                break;
            }
            if (input.equals("N")) {
                tmp.setHaveRegularMeals(false);
                break;
            }
        }

        while (true) {
            System.out.println("Eats homemade food: (Y/N)");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("Y")) {
                tmp.setEatsHomeFood(true);
                break;
            }
            if (input.equals("N")) {
                tmp.setEatsHomeFood(false);
                break;
            }
        }

        while (true) {
            System.out.println("Vegetarian: (Y/N)");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("Y")) {
                tmp.setIsVegetarian(true);
                break;
            }
            if (input.equals("N")) {
                tmp.setIsVegetarian(false);
                break;
            }
        }

        tmp.setIdLifestyle(repo.insertLifestyle(repo.getSource(),
                tmp.isIsSmoker(),
                tmp.getAverageNoOfCigarettes(),
                tmp.isIsAlcoholic(),
                tmp.getAverageNoOfDrinks(),
                tmp.getUseStimulants(),
                tmp.getConsumptionOfCoffeeAndTea(),
                tmp.getConsumptionOfSoftDrinks(),
                tmp.isHaveRegularMeals(),
                tmp.isEatsHomeFood(),
                tmp.isIsVegetarian()));

        return tmp;
    }

    private ProffesionDetails insertProffessionDetails() throws Exception {
        ProffesionDetails tmp = new ProffesionDetails();

        System.out.println("Occupation:");
        tmp.setOccupation(sc.nextLine());

        while (true) {
            System.out.println("Annual income:");
            try {
                tmp.setGrossAnnualIncome(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong data input, try again.");
            }
        }

        tmp.setIdProffessionDetails(repo.insertProffessionDetails(
                repo.getSource(),
                tmp.getOccupation(),
                tmp.getGrossAnnualIncome()));

        return tmp;
    }

    private PersonalDetails insertPersonalDetails() throws Exception {
        PersonalDetails tmp = new PersonalDetails();

        System.out.println("Marital status:");
        tmp.setMaritalStatus(sc.nextLine());

        System.out.println("Number of dependents:");
        tmp.setNumberOfDependents(sc.nextLine());

        System.out.println("Height:");
        tmp.setHeight(sc.nextLine());

        System.out.println("Weight:");
        tmp.setWeight(sc.nextLine());

        System.out.println("Blood type:");
        tmp.setBloodType(sc.nextLine());

        tmp.setIdPersonalDetails(repo.insertPersonalDetails(repo.getSource(),
                tmp.getMaritalStatus(),
                tmp.getNumberOfDependents(),
                tmp.getHeight(),
                tmp.getWeight(),
                tmp.getBloodType()));

        return tmp;
    }

    private ContactDetailsContact insertContactDetails() throws Exception {
        ContactDetailsContact tmp = new ContactDetailsContact();

        System.out.println("Telephone work:");
        tmp.setTelephoneWork(sc.nextLine());

        System.out.println("Telephone home:");
        tmp.setTelephoneHome(sc.nextLine());

        System.out.println("Mobile phone:");
        tmp.setTelephoneMobile(sc.nextLine());

        System.out.println("Pager:");
        tmp.setPager(sc.nextLine());

        System.out.println("Fax:");
        tmp.setFax(sc.nextLine());

        System.out.println("Email:");
        tmp.setEmail(sc.nextLine());

        tmp.setIdContactDetailsContact(repo.insertContactDetailsContact(
                repo.getSource(),
                tmp.getTelephoneWork(),
                tmp.getTelephoneHome(),
                tmp.getTelephoneMobile(),
                tmp.getPager(),
                tmp.getFax(),
                tmp.getEmail()));
        return tmp;
    }

    private ContactDetailsAddress insertAddressDetails() throws Exception {
        ContactDetailsAddress temp = new ContactDetailsAddress();

        System.out.println("City:");
        temp.setCity(sc.nextLine());

        System.out.println("Street:");
        temp.setStreet(sc.nextLine());

        System.out.println("Door number:");
        temp.setDoorNumber(sc.nextLine());

        System.out.println("Area:");
        temp.setArea(sc.nextLine());

        System.out.println("State:");
        temp.setState(sc.nextLine());

        System.out.println("Pincode:");
        temp.setPincode(sc.nextLine());

        temp.setIdContactDetailsAddress(repo.insertContactDetailsAddress(
                repo.getSource(),
                temp.getDoorNumber(),
                temp.getStreet(),
                temp.getArea(),
                temp.getCity(),
                temp.getState(),
                temp.getPincode()));

        return temp;
    }

    private void printPatientData() {
        try {
            PatientFull patient = searchForPatient();
            if (patient == null) {
                System.out.println("Terminated");
                return;
            }

            System.out.println("//// Selected Patient ////");
            System.out.println(String.format("ID: %d", patient.getIdPatientFull()));
            System.out.println(String.format("Name: %s", patient.getPatientShortData().getName()));
            System.out.println(String.format("Surname: %s", patient.getPatientShortData().getSurname()));
            System.out.println(String.format("Middlename: %s", patient.getPatientShortData().getMiddlename()));
            System.out.println(String.format("Date of birth: %s", patient.getDateOfBirth().toString()));
            System.out.println(String.format("Phone Home: %-20s Phone Work: %-20s Mobile: %-20s", patient.getContactDetails().getTelephoneHome(),
                    patient.getContactDetails().getTelephoneWork(), patient.getContactDetails().getTelephoneMobile()));

        } catch (Exception e) {
            System.out.println("Error printing patient data - printPatientData()");
        }
    }

    private PatientFull searchForPatient() {
        while (true) {
            try {

                List<PatientFull> allPatients = repo.getAllPatientsFull(repo.getSource());
                System.out.println("\n////  Search For Patient  ////");

                System.out.println("Surname:");
                System.out.println(">");
                String surname = sc.nextLine().trim().toLowerCase();

                List<PatientFull> searchResult = allPatients.stream()
                        .filter(x -> x.getPatientShortData()
                        .getSurname().toLowerCase()
                        .startsWith(surname))
                        .collect(Collectors.toList());

                if (searchResult.isEmpty()) {
                    System.out.printf("No surname starts with %s, press 0 to cancel", surname);
                    System.out.println(">");
                    if (sc.nextLine().equals("0")) {
                        return null;
                    }
                } else {
                    printPatients(searchResult);
                    try {
                        System.out.println("Select ID:");
                        System.out.print(">");
                        int id = Integer.parseInt(sc.nextLine());

                        Optional<PatientFull> patient = searchResult.stream().filter(x -> x.getIdPatientFull() == id).findFirst();
                        if (patient != null) {
                            patient.get().toString();
                            return patient.get();
                        } else {
                            System.out.printf("No patient with ID %d found, press any key to cancel...", id);
                            System.out.print(">");
                            sc.nextLine();
                            return null;
                        }
                    } catch (Exception e) {
                        System.out.println("ID is not valid");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error fetching patient data - searchForPatient()");
            }
        }
    }

    private void printPatients(List<PatientFull> patients) {
        System.out.println("Printing patients:");

        for (int i = 0; i < patients.size(); ++i) {
            System.out.println(String.format("ID: %-10d Name: %-20s Surname: %-25s Address: %s",
                    patients.get(i).getIdPatientFull(),
                    patients.get(i).getPatientShortData().getName(),
                    patients.get(i).getPatientShortData().getSurname(),
                    patients.get(i).getPermanentAddress().getCity() + " " + patients.get(i).getPermanentAddress().getStreet()));
        }
    }

    public void registerPatientShort() {
        System.out.println("////    Add new patient SHORT   ////");

        try {
            PatientShort shortData = insertShortPatientData(); //Promts the user for data entry

            //filler data
            ContactDetailsAddress addressPermanent = generateContactDetailsAddress();
            ContactDetailsAddress addressPresent = generateContactDetailsAddress();
            ContactDetailsContact contact = generateContactDetailsContact();
            PersonalDetails personalDetails = generatePersonalDetails();
            ProffesionDetails proffessionDetails = generateProffessionDetails();
            Lifestyle lifestyle = generateLifestyleDetails();
            BasicComplaints basicComplaints = generateBasicComplaints();
            ImportantMedicalComplaints importantComplaints = generateImportantMedicalComplaints();

            repo.insertPatientFull(
                    repo.getSource(),
                    shortData.getIdPatient(),
                    new Date(0),
                    addressPermanent.getIdContactDetailsAddress(),
                    addressPresent.getIdContactDetailsAddress(),
                    personalDetails.getIdPersonalDetails(),
                    proffessionDetails.getIdProffessionDetails(),
                    lifestyle.getIdLifestyle(),
                    basicComplaints.getIdBasicComplaints(),
                    importantComplaints.getIdImportantMedicalComplaints(),
                    contact.getIdContactDetailsContact());

        } catch (Exception e) {
            System.out.println("Failed to register patient - registerPatientShort()");
            System.out.println(e.getMessage());
        }
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

    private PatientShort insertShortPatientData() throws Exception {
        PatientShort temp = new PatientShort();

        System.out.println("Name:");
        System.out.print(">");
        temp.setName(sc.nextLine());

        System.out.println("Surname:");
        System.out.print(">");
        temp.setSurname(sc.nextLine());

        System.out.println("Middlename:");
        System.out.print(">");
        temp.setMiddlename(sc.nextLine());

        while (true) {
            System.out.println("Sex: (M/F)");
            System.out.print(">");
            temp.setSex(sc.nextLine().toUpperCase());
            if (temp.getSex().equals("F") || temp.getSex().equals("M")) {
                break;
            }
        }

        System.out.println("Statement of complaint:");
        System.out.print(">");
        temp.setStatementOfComplaint(sc.nextLine());

        System.out.println("Contact phone 1:");
        System.out.print(">");
        temp.setContact_1(sc.nextLine());

        System.out.println("Contact phone 2:");
        System.out.print(">");
        temp.setContact_2(sc.nextLine());

        while (true) {
            System.out.println("Is follow up patient: (Y/N)");
            System.out.print(">");
            String follow = sc.nextLine().toUpperCase();
            if (follow.equals("Y")) {
                temp.setIsFollowUp(true);
                break;
            }
            if (follow.equals("N")) {
                temp.setIsFollowUp(false);
                break;
            }
        }

        System.out.println("\nNext of kin contact details:");
        temp.setNextOfKin(insertNextOfKinShort());

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

        return temp;
    }

    private NextOfKin insertNextOfKinShort() throws Exception {
        NextOfKin temp = new NextOfKin();

        System.out.println("Name:");
        System.out.print(">");
        temp.setName(sc.nextLine());

        System.out.println("Surname:");
        System.out.print(">");
        temp.setSurname(sc.nextLine());

        System.out.println("Middlename:");
        System.out.print(">");
        temp.setMiddlename(sc.nextLine());

        System.out.println("Relationship status to patient:");
        System.out.print(">");
        temp.setRelationship(sc.nextLine());

        ContactDetailsContact contact = generateContactDetailsContact();
        ContactDetailsAddress address = generateContactDetailsAddress();

        temp.setAddressDetails(address);
        temp.setContactDetails(contact);

        temp.setIdNextOfKin(repo.insertNextOfKin(repo.getSource(),
                temp.getName(),
                temp.getSurname(),
                temp.getMiddlename(),
                temp.getRelationship(),
                temp.getContactDetails().getIdContactDetailsContact(),
                temp.getAddressDetails().getIdContactDetailsAddress()));

        return temp;
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

    private void printMenuDoctors() {
        System.out.println("/////////////////////////////////////////////");
        System.out.println("/ 1. Register new doctor");
        System.out.println("/ 2. Update existing doctor data");
        System.out.println("/ 3. Delete existing doctor");
        System.out.println("/ 4. Register new specialization");
        System.out.println("/ 5. Update specialization data");
        System.out.println("/ 6. Delete specialization");
        System.out.println("/ 0. Back");
        System.out.println("/////////////////////////////////////////////");
        System.out.println(">   ");
    }

    private void menuDoctors() {
        while (true) {
            printMenuDoctors();

            String menuChoice = sc.nextLine().toUpperCase().trim();
            switch (menuChoice) {
                case "1":
                    registerNewDoctor();
                    break;
                case "2":
                    updateDoctorData();
                    break;
                case "3":
                    deleteDoctor();
                    break;
                case "4":
                    registerNewSpecialization();
                    break;
                case "5":
                    updateSpecialization();
                    break;
                case "6":
                    deleteSpecialization();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            if (menuChoice.equals("0")) {
                break;
            }
        }

    }

    public void deleteSpecialization() {
        System.out.println("////    Delete specialization   ////");
        List<Specialization> specializations = getSpecializationsSortedByID();
        while (true) {
            printSpecializations(specializations);
            System.out.println("Type 0 to CANCEL");
            System.out.println("ID: ");
            System.out.print(">");

            String input = sc.nextLine();

            if (!input.equals("0")) {
                try {
                    int result = repo.deleteSpecialization(repo.getSource(),
                            getSpecializationFromList(input, specializations)
                                    .getIdSpecialization());
                    if (result == 0) {
                        System.out.println("ID is false");
                    } else {
                        System.out.println("Succesful deletion");
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Wrong input");
                } catch (Exception e) {
                    System.out.println("Failed to delete specialization");
                }
            } else {
                System.out.println("Canceled...");
                break;
            }

        }
    }

    public void updateSpecialization() {

        System.out.println("//// Updating existing specialization   //// ");
        System.out.println("Press 0 to CANCEL");
        List<Specialization> specializations = getSpecializationsSortedByID();

        while (true) {
            printSpecializations(specializations);
            System.out.println("\nID");
            System.out.print(">");
            String idInput = sc.nextLine();

            if (!idInput.equals("0")) {
                try {
                    int id = getSpecializationFromList(idInput, specializations).getIdSpecialization();

                    System.out.println("\nNew specialization name:");
                    System.out.print(">");
                    String specializationName = sc.nextLine();
                    repo.updateSpecialization(repo.getSource(), id, specializationName);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ID does not exist, try again.");
                } catch (Exception e) {
                }
            } else {
                System.out.println("Canceled...");
                break;
            }
        }
    }

    public void registerNewSpecialization() {
        System.out.println("//// Register new specialization    ////");
        System.out.println("Existing specializations:");
        List<Specialization> specializations = getSpecializationsSortedByID();
        printSpecializations(specializations);

        System.out.println("Type 0 to cancel or type new specialization name");
        System.out.println(String.format("%nSpecialization name:"));
        System.out.print(">");
        String specialization = sc.nextLine();

        try {
            if (!specialization.equals("0")) {
                repo.insertSpecialization(repo.getSource(), specialization);
                System.out.println("New specialization added successfully.\n");
            } else {
                System.out.println("Adding of new specialization cancelled.\n");
            }
        } catch (Exception e) {
            System.out.println("Error adding new specialization.\n");
        }
    }

    public void deleteDoctor() {
        try {
            List<Doctor> doctors = repo.getDoctors(repo.getSource());
            String input;

            while (true) {
                System.out.println("Press ENTER to continue or press 0 to cancel");
                System.out.print(">");
                input = sc.nextLine();

                if (!input.equals("0")) {
                    try {
                        printDoctors(doctors);
                        System.out.println("Type ID to delete: ");
                        System.out.print(">");
                        int idDoctor = Integer.parseInt(sc.nextLine());
                        repo.deleteDoctor(repo.getSource(), idDoctor);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input, try again.");
                    } catch (SQLServerException e) {
                        System.out.println("Cannot delete doctor.");
                    } catch (Exception e) {
                    }
                } else {
                    System.out.println("Doctor delete canceled.\n");
                }
            }
        } catch (Exception e) {
        }
    }

    private void printDoctors(List<Doctor> doctors) throws Exception {
        System.out.println("List of doctors: ");

        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).isIsWorking()) {
                System.out.println(String.format("ID: %-20d Name: %-20s Surname: %-25s Specialization: %-20s",
                        doctors.get(i).getIdDoctor(),
                        doctors.get(i).getName(),
                        doctors.get(i).getSurname(),
                        doctors.get(i).getSpecialization().getSpecializationName()));
            }
        }
    }

    private Doctor getDoctorByID() {
        Doctor doctor = null;
        while (true) {
            try {

                List<Doctor> doctors = repo.getDoctors(repo.getSource());
                printDoctors(doctors);
                System.out.println("Enter ID: ");
                System.out.print(">");
                int id = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < doctors.size(); i++) {
                    if (doctors.get(i).getIdDoctor() == id) {
                        doctor = doctors.get(i);
                        break;
                    }
                }
                if (doctor != null) {
                    break;
                } else {
                    System.out.println("Doctor not found. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Try again.");
            } catch (Exception e) {
                System.out.println("Error fetching doctor data - getDoctorByID()");
                System.out.println(e.getMessage());
            }
        }
        return doctor;
    }

    public void updateDoctorData() {

        System.out.println("////    Update doctor data    ////");
        System.out.println("Press 0 to cancel and ENTER to continue");
        System.out.print(">");
        try {
            if (!sc.nextLine().equals("0")) {
                Doctor doctor = getDoctorByID();
                boolean dataUpdated = false; //to check if update needs to be done

                System.out.println("\nType . to accept existing data\n");

                System.out.println(String.format("Name: %s", doctor.getName()));
                System.out.print(">");
                String name = sc.nextLine();
                if (!name.equals(".")) {
                    doctor.setName(name);
                    dataUpdated = true;
                }

                System.out.println(String.format("Surname: %s", doctor.getSurname()));
                System.out.print(">");
                String surname = sc.nextLine();
                if (!surname.equals(".")) {
                    doctor.setSurname(surname);
                    dataUpdated = true;
                }

                List<Specialization> specializations = getSpecializationsSortedByID();
                while (true) {
                    printSpecializations(specializations);
                    System.out.println("Choose specialization: ");
                    System.out.print(">");
                    String idSpecialization = sc.nextLine();

                    if (idSpecialization.equals(".")) {
                        break;
                    } else {
                        try {
                            Specialization tmp = getSpecializationFromList(idSpecialization, specializations);
                            doctor.setSpecialization(tmp);
                            doctor.getSpecialization().setIdSpecialization(tmp.getIdSpecialization());
                            doctor.getSpecialization().setSpecializationName(tmp.getSpecializationName());
                            //doctor.getSpecialization().setIdSpecialization(getSpecializationFromList(idSpecialization, specializations).getIdSpecialization());
                            dataUpdated = true;
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong input, try again.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("ID not found, try again.");
                        }
                    }
                }

                System.out.println("\nContact details:");
                updateContactDetails(
                        doctor.getContactDetails().getIdContactDetailsContact());
                updateAddressDetails(
                        doctor.getAddressDetails().getIdContactDetailsAddress());

                if (dataUpdated) {
                    repo.updateDoctor(repo.getSource(),
                            doctor.getIdDoctor(),
                            doctor.getName(),
                            doctor.getSurname(),
                            doctor.getSpecialization().getIdSpecialization());
                }

                System.out.println("New doctor data updated successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error updating doctor.\n");
        }
    }

    private List<Specialization> getSpecializationsSortedByID() {
        try {
            List<Specialization> specializations = repo.getSpecializations(repo.getSource());
            specializations.sort((x, y) -> x.getIdSpecialization() - y.getIdSpecialization());

            return specializations;
        } catch (Exception e) {
            return null;
        }
    }

    private void printSpecializations(List<Specialization> specializations) {
        System.out.println("Specializations:");

        for (int i = 0; i < specializations.size(); ++i) {
            System.out.println(String.format("%4d %s", (i + 1), specializations.get(i).getSpecializationName()));
        }
    }

    private Specialization getSpecializationFromList(String scInput, List<Specialization> specializations) {
        return specializations.get((Integer.parseInt(scInput) - 1));
    }

    public void registerNewDoctor() {
        System.out.println("////    Register new doctor    ////");
        System.out.println("Type 0 to cancel or . to continue");
        System.out.print(">");

        try {
            if (!sc.nextLine().equals("0")) {
                Doctor doctor = new Doctor();
                List<Specialization> specializations = getSpecializationsSortedByID();

                System.out.println("Name:");
                System.out.print(">");
                doctor.setName(sc.nextLine());

                System.out.println("Surname:");
                System.out.print(">");
                doctor.setSurname(sc.nextLine());

                while (true) {
                    printSpecializations(specializations);
                    System.out.println("Chose specialization:");
                    System.out.print(">");

                    try {
                        doctor.setSpecialization(getSpecializationFromList(sc.nextLine(), specializations));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input, try again.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("ID does not exist, try again.");
                    }
                }

                System.out.println("\nContact details:");
                doctor.setContactDetails(insertContactDetails());
                doctor.setAddressDetails(insertAddressDetails());

                repo.insertDoctor(repo.getSource(),
                        doctor.getName(),
                        doctor.getSurname(),
                        doctor.getContactDetails().getIdContactDetailsContact(),
                        doctor.getAddressDetails().getIdContactDetailsAddress(),
                        doctor.getSpecialization().getIdSpecialization(),
                        true);
                System.out.println("New doctor data successfully added.\n");

            } else {
                System.out.println("Adding of new doctor cancelled.\n");
            }
        } catch (Exception e) {
            System.out.println("Error adding new doctor.\n");
            System.out.printf("%s", e.getMessage());
        }
    }

    private void printMenuBillings() {
        System.out.println("/////////////////////////////////////////////");
        System.out.println("/ 1. Create new bill");
        System.out.println("/ 2. View bills by patient");
        System.out.println("/ 0. Back");
        System.out.println("/////////////////////////////////////////////");
        System.out.println(">   ");
    }

    private void menuBillings() {
        while (true) {
            printMenuBillings();

            String menuChoice = sc.nextLine().toUpperCase().trim();
            switch (menuChoice) {
                case "1":
                    createBill();
                    break;
                case "2":
                    viewBills();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            if (menuChoice.equals("0")) {
                break;
            }
        }
    }

    private void viewBills() {
        System.out.println("////    Viewing bills by patient    ////");
        System.out.println("Type 0 to CANCEL");

        if (!sc.nextLine().trim().equals("0")) {
            try {
                System.out.println("Select patient");
                PatientFull patient = searchForPatient();
                if (patient == null) {
                    System.out.println("Pateint not found");
                    return;
                }

                List<Bill> bills = repo.getAllBills(repo.getSource())
                        .stream()
                        .filter(x
                                -> x.getPatientFull().getIdPatientFull() == patient.getIdPatientFull())
                        .collect(Collectors.toList());
                System.out.println("Printing bills:");
                for (Bill tmpBill : bills) {
                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                    System.out.printf("%nID: %5d%n Date: %s%n",
                            tmpBill.getIdBill(),
                            date.format(tmpBill.getBillDate()));

                    List<AccountItem> accItems = repo.getAccountItems(repo.getSource(), tmpBill.getIdBill())
                            .stream()
                            .filter(x -> x.getBill().getIdBill() == tmpBill.getIdBill())
                            .collect(Collectors.toList());

                    accItems.forEach((item) -> {
                        System.out.printf("\tName: %s%n \tPrice: %s%n \tQuantity: %f%n",
                                item.getName(),
                                item.getQuantity(),
                                round(item.getPrice(), 2));
                    });
                }
            } catch (Exception e) {
                System.out.println("Failed to fetch bills - viewBills()");
            }

        } else {
            System.out.println("Canceled");
            return;
        }

    }

    private static double round(double value, int places) { //Found online
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void createBill() {

        System.out.println("//// Create new bill    ////");
        System.out.println("Press 0 to CANCEL");
        System.out.print(">");

        if (!sc.nextLine().equals("0")) {
            try {
                Bill bill = new Bill();

                System.out.println("Payment method:");
                System.out.print(">");
                bill.setPaymentMethod(sc.nextLine());

                System.out.println("Choose patient:");
                PatientFull patient = searchForPatient();
                if (patient == null) {
                    System.out.println("\nPatient not found. Canceled");
                    return;
                }
                bill.setPatientFull(patient);

                bill.setBillDate(new Date(new java.util.Date().getTime()));
                bill.setBillTime(new Time(Calendar.getInstance().getTimeInMillis()));
                

                bill.setIdBill(repo.insertBill(repo.getSource(),
                        bill.getPaymentMethod(),
                        bill.getPatientFull().getIdPatientFull(),
                        bill.getBillDate(),
                        bill.getBillTime()));

                System.out.println("Completed adding bill");
                System.out.println(bill.getPaymentMethod());
                
                List<AccountItem> accItems = new ArrayList<>(); // can add more than one item

                do {
                    System.out.println("\n////    Adding new account item     ////");

                    //TODO: Account item in seperate function
                    accItems.add(insertAccountItemForBill(bill));

                    System.out.println("Press '.' to add another account item");
                    System.out.print(">");
                } while (sc.nextLine().equals("."));

                repo.insertAccountItems(repo.getSource(), accItems);
            } catch (Exception e) {
                System.out.println("Error creating new bill - createBill()");
                System.out.println(e.getMessage());
            }
        }

    }

    private AccountItem insertAccountItemForBill(Bill bill) {
        AccountItem item = new AccountItem();

        item.setBill(bill);

        System.out.println("Item name: ");
        System.out.print(">");
        item.setName(sc.nextLine());

        while (true) {
            System.out.println("Item price: ");
            System.out.print(">");
            try {
                item.setPrice(Double.parseDouble(sc.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again.");
            }
        }

        while (true) {
            System.out.println("Quantity: ");
            System.out.print(">");
            try {
                item.setQuantity(Integer.parseInt(sc.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again.");
            }
        }

        return item;

    }

    private void printMenuAppointments() {
        System.out.println("/////////////////////////////////////////////");
        System.out.println("/ 1. Create new appointment");
        System.out.println("/ 2. Update appointment");
        System.out.println("/ 3. View appointments by date");
        System.out.println("/ 4. View appointments by doctor");
        System.out.println("/ 0. Back");
        System.out.println("/////////////////////////////////////////////");
        System.out.println(">");
    }

    private void menuAppointments() {
        while (true) {
            printMenuAppointments();

            String menuChoice = sc.nextLine().toUpperCase().trim();
            switch (menuChoice) {
                case "1":
                    createAppointment();
                    break;
                case "2":
                    updateAppointment();
                    break;
                case "3":
                    printAppointmentsByDate();
                    break;
                case "4":
                    printAppointmentsByDoctor();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            if (menuChoice.equals("0")) {
                break;
            }
        }
    }

    public void printAppointmentsByDoctor() {
        try {
            List<Appointment> apps = repo.getAllAppointments(repo.getSource());
            Doctor doctor = getDoctorByID();

            System.out.printf("%nAppointments for: %s%n",
                    doctor.getName() + " " + doctor.getSurname());
            List<Appointment> filtered
                    = apps.stream().filter(x -> x.getDoctor().getIdDoctor() == doctor.getIdDoctor())
                            .collect(Collectors.toList());
            filtered.forEach(x -> System.out.println(x.toString()));
        } catch (Exception e) {
            System.out.println("Error printing appointments by doctor");
        }

    }

    public void printAppointmentsByDate() {
        try {
            String scInput;
            List<Appointment> apps = repo.getAllAppointments(repo.getSource());

            System.out.println("Date of appointment: (dd-MM-yyyy)");
            scInput = sc.nextLine();
            System.out.print(">");
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                java.util.Date date = format.parse(scInput);

                System.out.println(String.format("Appointments for: %s%n", format.format(date)));
                List<Appointment> appointments
                        = apps.stream().filter(x -> x.getApointmentDate().equals(date)).collect(Collectors.toList());
                appointments.forEach(x -> System.out.println(x.toString()));

                System.out.println("\n");
                return;
            } catch (ParseException e) {
                System.out.println("Wrong date format.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error printing appointments by date");
        }
    }

    private Appointment searchForAppointment() throws Exception {
        List<Appointment> appointments;
        try {
            appointments = repo.getAllAppointments(repo.getSource());
            appointments.sort((x, y) -> x.getIdAppointment() - y.getIdAppointment());
            while (true) {
                appointments.forEach((item) -> {
                    System.out.printf("ID: %4d %nAppointment: %s %nDate: %s",
                            item.getIdAppointment(),
                            item.getAppointmentSummary(),
                            item.getApointmentDate());
                });
                System.out.println("Select ID: ");
                System.out.print(">");

                int id = Integer.parseInt(sc.nextLine());
                Optional<Appointment> app = appointments.stream()
                        .filter(x -> x.getIdAppointment() == id)
                        .findFirst();
                if (app != null) {
                    return app.get();
                } else {
                    System.out.println("Not found. Type . to continue or 0 to cancel");
                    System.out.print(">");
                    if (sc.nextLine().equals("0")) {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching appointments");
            return null;
        }
    }

    public void updateAppointment() {
        System.out.println("////    Update appointment    ////");
        System.out.println("Press 0 to CANCEL");
        boolean isUpdated = false;
        String input;

        if (!sc.nextLine().trim().equals("0")) {
            try {
                Appointment app = searchForAppointment();

                System.out.println("Updating selected appointment");
                System.out.println("Type . to accept exsiting data.");

                while (true) {
                    try {

                        System.out.printf("Date of appointment: %s", app.getApointmentDate());
                        System.out.println("(dd-MM-yyyy)");
                        System.out.print(">");
                        input = sc.nextLine();
                        if (!input.equals(".")) {
                            isUpdated = true;

                            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                            java.util.Date parsed = format.parse(input);

                            app.setApointmentDate(new Date(parsed.getTime()));
                            break;
                        } else {
                            System.out.println("Exsiting data accepted");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong fromat, try again");
                    }
                }

                while (true) {
                    try {

                        System.out.printf("Start of appointment: %s", app.getAppointmentStart());
                        System.out.println("HH:mm");
                        System.out.print(">");
                        input = sc.nextLine();

                        if (!input.equals(".")) {
                            isUpdated = true;

                            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                            java.util.Date parsed = format.parse(input);

                            app.setAppointmentStart(new Time(parsed.getTime()));
                            break;
                        } else {
                            System.out.println("Existing data accepted");
                        }
                    } catch (ParseException e) {
                        System.out.println("Wrong date format, try again");
                    } catch (Exception e) {
                        System.out.println("Failed to update data.");
                    }
                }

                while (true) {
                    try {

                        System.out.printf("End of appointment: %s", app.getAppointmentEnd());
                        System.out.println("HH:mm");
                        System.out.print(">");
                        input = sc.nextLine();

                        if (!input.equals(".")) {
                            isUpdated = true;

                            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                            java.util.Date parsed = format.parse(input);

                            app.setAppointmentEnd(new Time(parsed.getTime()));
                            break;
                        } else {
                            System.out.println("Existing data accepted");
                        }
                    } catch (ParseException e) {
                        System.out.println("Wrong date format, try again");
                    } catch (Exception e) {
                        System.out.println("Failed to update data.");
                    }
                }

                System.out.printf("Select patient: %d %s", app.getPatientFull().getIdPatientFull(), app.getPatientFull().getPatientShortData().getName());
                if (!sc.nextLine().equals(".")) {
                    app.setPatientFull(searchForPatient());
                    isUpdated = true;
                }

                System.out.printf("Select doctor: %d %s", app.getDoctor().getIdDoctor(), app.getDoctor().getName());
                if (!sc.nextLine().equals(".")) {
                    app.setDoctor(getDoctorByID());
                    isUpdated = true;
                }

                System.out.printf("Appointment sumamry: %s", app.getAppointmentSummary());
                if (!sc.nextLine().equals(".")) {
                    System.out.println("Enter new summary: ");
                    app.setAppointmentSummary(sc.nextLine());
                    isUpdated = true;
                }

                System.out.printf("Ordered tests: %s", app.getOrderedTests());
                if (!sc.nextLine().equals(".")) {
                    System.out.println("Enter new ordered tests:");
                    app.setOrderedTests(sc.nextLine());
                    isUpdated = true;
                }

                System.out.printf("Prescribed medicine: %s", app.getMedicine());
                if (!sc.nextLine().equals(".")) {
                    System.out.println("Enter new medicine:");
                    app.setMedicine(sc.nextLine());
                    isUpdated = true;
                }

                System.out.printf("Ordered treatement: %s", app.getTreatment());
                if (!sc.nextLine().equals(".")) {
                    System.out.println("Enter new treatment:");
                    app.setTreatment(sc.nextLine());
                    isUpdated = true;
                }

                if (isUpdated) {
                    repo.updateAppointment(repo.getSource(),
                            app.getIdAppointment(),
                            app.getApointmentDate(),
                            app.getAppointmentStart(),
                            app.getAppointmentEnd(),
                            app.getPatientFull().getIdPatientFull(),
                            app.getDoctor().getIdDoctor(),
                            app.getAppointmentSummary(),
                            app.getOrderedTests(),
                            app.getMedicine(),
                            app.getTreatment());
                }

            } catch (Exception e) {
                System.out.println("Error updating appointment");
            }
        } else {
            System.out.println("Updating canceled");
            return;
        }

    }

    public void createAppointment() {
        System.out.println("////    Create new appointment    ////");
        System.out.println("Type 0 to CANCEL");
        System.out.print(">");

        if (!sc.nextLine().equals("0")) {
            try {
                Appointment tmp = new Appointment();

                //  do {
                while (true) {
                    System.out.println("Date of appointment: (dd-MM-yyyy)");
                    System.out.print(">");
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        java.util.Date parsed = format.parse(sc.nextLine());
                        tmp.setApointmentDate(new Date(parsed.getTime()));
                        if (!tmp.getApointmentDate().before(new Date(new java.util.Date().getTime()))) {
                            break;
                        } else {
                            System.out.println("\nDate is not valid, try again.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Wrong date format, please try again.");
                    }
                }
                while (true) {
                    System.out.println("Start of appointment: (HH:mm)");
                    System.out.print(">");
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                        java.util.Date parsed = format.parse(sc.nextLine());
                        tmp.setAppointmentStart(new Time(parsed.getTime()));
                        break;
                    } catch (ParseException e) {
                        System.out.println("Wrong time format, please try again.");
                    }
                }
                while (true) {
                    System.out.println("End of appointment: (HH:mm)");
                    System.out.print(">");
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                        java.util.Date parsed = format.parse(sc.nextLine());
                        tmp.setAppointmentEnd(new Time(parsed.getTime()));
                        break;
                    } catch (ParseException e) {
                        System.out.println("Wrong time format, please try again.");
                    }
                }
                // } while (false);

                System.out.println("\nSelect patient:");
                PatientFull patient = searchForPatient();
                if (patient == null) {
                    System.out.println("Patient not found.");
                    return;
                }
                tmp.setPatientFull(patient);

                System.out.println("\nSelect doctor:");
                tmp.setDoctor(getDoctorByID());

                System.out.println("Appointment summary:");
                System.out.print(">");
                tmp.setAppointmentSummary(sc.nextLine());

                System.out.println("Ordered tests:");
                System.out.print(">");
                tmp.setOrderedTests(sc.nextLine());

                System.out.println("Prescribed medicine:");
                System.out.print(">");
                tmp.setMedicine(sc.nextLine());

                System.out.println("Ordered treatment:");
                System.out.print(">");
                tmp.setTreatment(sc.nextLine());

                repo.insertAppointment(repo.getSource(),
                        tmp.getApointmentDate(),
                        tmp.getAppointmentStart(),
                        tmp.getAppointmentEnd(),
                        tmp.getPatientFull().getIdPatientFull(),
                        tmp.getDoctor().getIdDoctor(),
                        tmp.getAppointmentSummary(),
                        tmp.getOrderedTests(),
                        tmp.getMedicine(),
                        tmp.getTreatment());
            } catch (Exception e) {
                System.out.println("Error while creating new appointment.");
            }
        }

    }

}
