package Program;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import module.Input;

/**
 * Clinic class is a class use for manage appointment , doctor and patient class
 *
 * @author Thapakorn
 */
public class Clinic {

    private Input input;
    private ArrayList<Doctor> doctorList;
    private ArrayList<Patient> patientList;
    private ArrayList<Appointment> appointList;

    Clinic() {
        input = new Input();
        doctorList = new ArrayList<>();
        patientList = new ArrayList<>();
        appointList = new ArrayList<>();
        initialize();
        showMainMenu();
    }

    public void showMainMenu() {
        System.out.println(":::::>[Klinikum Dortmund ,Herzlich Willkommen]<:::::");
        System.out.println("==================================");//main menu ,choose by switch case
        System.out.println("(1)Doctor management");
        System.out.println("(2)Patient management");
        System.out.println("(3)Appointment management");
        System.out.println("(4)Search patient by name");
        System.out.println("(0)Exit the program");
        System.out.println("==================================");
        int choose = input.inputInt("Please choose from menu", "Error - invalid input");
        switch (choose) {
            case 1:
                showDoctorMenu();
                break;
            case 2:
                showPatientMenu();
                break;
            case 3:
                showAppointmentMenu();
                break;
            case 4:
                searchPatient();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Error selection - Please try again... ");
                input.PressEnterKey();
                showMainMenu();
        }
    }
/////////////////////////////////////Doctor part/////////////////////////////////////    

    void showDoctorMenu() {
        System.out.println("++++++++++Doctor menu++++++++++");
        System.out.println("(1)Add doctor");
        System.out.println("(2)Resign doctor");
        System.out.println("(3)Show doctor list");
        System.out.println("(4)Edit doctor information");
        System.out.println("(0)Back to main menu");
        System.out.println("+++++++++++++++++++++++++++++++");
        int choose = input.inputInt("Please choose from menu", "Error - invalid input");

        switch (choose) {
            case 1:
                addDoctor();
                break;
            case 2:
                removeDoctor();
                break;
            case 3:
                viewDoctor();
                break;
            case 4:
                editDoctor();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("Error selection - Please try again... ");
                input.PressEnterKey();
                showDoctorMenu();
        }
    }

    void addDoctor() {//Add doctor process
        input.deleteToken();
        char YorN = input.inputChar("Add doctor , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Add Doctor------");
        } else {
            System.out.println("Go back to doctor menu...");
            input.PressEnterKey();
            showDoctorMenu();
        }
        Doctor doctor = new Doctor();
        doctor.setFirstName(input.inputName("Enter first name", "Error - First name cannot be blank, number or any white space."));
        doctor.setLastName(input.inputName("Enter last name", "Error - Last nname cannot be blank ,number or any white space."));
        doctor.setGender(input.inputChar("Choose gender\n[M]Male\n[F]Female", "Error - please input only M/F", new char[]{'M', 'F', 'm', 'f'}));
        System.out.println("--Enter date of birth--");
        doctor.setDateOfbirth(input.inputDate());
        doctor.setAge(2016 - doctor.getBirthYear());
        input.deleteToken();//use for delete enter token in scanner
        doctor.setCitizenID(input.inputID("Enter citizen ID (13digits)", "Error - Citizen ID cannot be blank,white space and must be only 13numbers and first digit cannot be 0"));
        doctor.setSpecialty(input.inputString("Enter doctor specialty", "Error - specialty cannot be blank"));
        System.out.println("----------------------------------------");
        doctor.printAllinfo();
        System.out.println("----------------------------------------");
        YorN = input.inputChar("Are you sure ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            doctorList.add(doctor);
            System.out.println("Successfully added!!!");
            input.PressEnterKey();
            showDoctorMenu();
        } else {
            System.out.println("Go back to doctor menu...");
            input.PressEnterKey();
            showDoctorMenu();
        }
    }

    void viewDoctor() {//Show doctor list and briefly information process
        input.deleteToken();
        char YorN = input.inputChar("Show doctor list , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Show Docter List------");
        } else {
            System.out.println("Go back to doctor menu...");
            input.PressEnterKey();
            showDoctorMenu();
        }
        showDoctorList(doctorList);
        int indexDoc = doctorList.size();
        int decide = input.inputInt("Select to show briefly information or enter '0' for back to doctor menu", "Error - invalid input");
        if (decide == 0) {
            System.out.println("Go back to doctor menu...");
            input.deleteToken();
            input.PressEnterKey();
            showDoctorMenu();
        } else if (decide <= indexDoc && decide > 0) {
            System.out.println("----------------------------------------");
            doctorList.get(decide - 1).printAllinfo();
            System.out.println("----------------------------------------");
            input.deleteToken();
            input.PressEnterKey();
            showDoctorMenu();
        } else {
            System.out.println("Error Selection  - Please try again...");
            input.PressEnterKey();
            viewDoctor();
        }
    }

    void removeDoctor() {//Resign doctor by list
        input.deleteToken();
        char YorN = input.inputChar("Resign doctor , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Resign the doctor------");
        } else {
            System.out.println("Go back to doctor menu...");
            input.PressEnterKey();
            showDoctorMenu();
        }
        showDoctorList(doctorList);
        int indexDoc = doctorList.size();
        int decide = input.inputInt("Select by number to make a resign or enter '0' for back to doctor menu", "Error - invalid input");
        if (decide == 0) {
            System.out.println("Go back to doctor menu...");
            input.deleteToken();
            showDoctorMenu();
        } else if (decide <= indexDoc && decide > 0) {
            System.out.println("----------------------------------------");
            doctorList.get(decide - 1).printAllinfo();
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Error Selection - Plese try again...");
            input.PressEnterKey();
            removeDoctor();
        }
        input.deleteToken();
        YorN = input.inputChar("Are you sure ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            doctorList.remove(decide - 1);
            System.out.println("This doctor has removed!!!");
            input.PressEnterKey();
            showDoctorMenu();
        } else {
            System.out.println("Go back to doctor menu...");
            input.PressEnterKey();
            showDoctorMenu();
        }
    }

    void editDoctor() {//edit doctor information process
        input.deleteToken();
        char YorN = input.inputChar("Edit doctor , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Edit the doctor------");
        } else {
            System.out.println("Go back to doctor menu...");
            input.PressEnterKey();
            showDoctorMenu();
        }
        showDoctorList(doctorList);
        int indexDoc = doctorList.size();
        int decide = input.inputInt("Select by number to edit or enter '0' for back to doctor menu", "Error - invalid input");
        if (decide == 0) {
            System.out.println("Go back to doctor menu...");
            input.deleteToken();
            showDoctorMenu();
        } else if (decide <= indexDoc && decide > 0) {
            System.out.println("----------------------------------------");
            doctorList.get(decide - 1).printAllinfo();
            System.out.println("----------------------------------------");
            input.PressEnterKey();
        } else {
            System.out.println("Error Selection - Please try again...");
            input.PressEnterKey();
            editDoctor();
        }
        input.deleteToken();
        System.out.println("(1)First name");
        System.out.println("(2)Last name");
        System.out.println("(3)Specialty");

        int choose = input.inputInt("Select to edit", "Error - invalid input");
        switch (choose) {
            case 1:
                input.deleteToken();
                doctorList.get(decide - 1).setFirstName(input.inputName("Enter first name", "Error - First name cannot be blank, number or any white space."));
                System.out.println("Successfully edit!!!");
                input.PressEnterKey();
                break;
            case 2:
                input.deleteToken();
                doctorList.get(decide - 1).setLastName(input.inputName("Enter last name", "Error - Last name cannot be blank, number or any white space."));
                System.out.println("Successfully edit!!!");
                input.PressEnterKey();
                break;
            case 3:
                input.deleteToken();
                doctorList.get(decide - 1).setSpecialty(input.inputString("Enter doctor specialty", "Error - specialty cannot be blank"));
                System.out.println("Successfully edit!!!");
                input.PressEnterKey();
                break;
            default:
                System.out.println("Error selection - please try again...");
                input.PressEnterKey();
                editDoctor();
        }
        showDoctorMenu();
    }

/////////////////////////////////////////End doctor part/////////////////////////////////////////
///////////////////////////////////////Patient part///////////////////////////////////////////// 
    void showPatientMenu() {
        System.out.println("++++++++++Patient menu++++++++++");
        System.out.println("(1)Register patient");
        System.out.println("(2)Remove patient");
        System.out.println("(3)Show patient list");
        System.out.println("(4)Edit patient information");
        System.out.println("(0)Back to main menu");
        System.out.println("++++++++++++++++++++++++++++++++");
        int choose = input.inputInt("Please choose from menu", "Error - invalid input");

        switch (choose) {
            case 1:
                addPatient();
                break;
            case 2:
                removePatient();
                break;
            case 3:
                viewPatient();
                break;
            case 4:
                editPatient();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("Error selection - Please try again... ");
                input.PressEnterKey();
                showPatientMenu();
        }
    }

    void addPatient() {//Register Patient process
        input.deleteToken();
        char YorN = input.inputChar("Register Patient , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Register Patient------");
        } else {
            System.out.println("Go back to patient menu...");
            input.PressEnterKey();
            showPatientMenu();
        }
        Patient patient = new Patient();
        patient.setFirstName(input.inputName("Enter first name", "Error - First name cannot be blank, number or any white space."));
        patient.setLastName(input.inputName("Enter last name", "Error - Last nname cannot be blank ,number or any white space."));
        patient.setGender(input.inputChar("Choose gender\n[M]Male\n[F]Female", "Error - please input only M/F", new char[]{'M', 'F', 'm', 'f'}));
        System.out.println("--Enter date of birth--");
        patient.setDateOfbirth(input.inputDate());
        patient.setAge(2016 - patient.getBirthYear());
        input.deleteToken();
        patient.setCitizenID(input.inputID("Enter citizen ID (13digits)", "Error - Citizen ID cannot be blank,white space and must have only 13numbers and first digit cannot be 0"));
        patient.setTel(input.inputTel("Enter telephone number(Example:0xxxxxxxxx)", "Error - Telephone number cannot be blank and must enter like form"));
        patient.setDateAndtime(getCurrentlyTime());
        System.out.println("----------------------------------------");
        patient.printAllinfo();
        System.out.println("----------------------------------------");
        YorN = input.inputChar("Are you sure ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            patientList.add(patient);
            System.out.println("Successfully register!!!");
            input.PressEnterKey();
            showPatientMenu();
        } else {
            System.out.println("Go back to patient menu...");
            input.PressEnterKey();
            showPatientMenu();
        }
    }

    void viewPatient() {//Show patient list and briefly information process
        input.deleteToken();
        char YorN = input.inputChar("Show patient list , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Show Patient List------");
        } else {
            System.out.println("Go back to patient menu...");
            input.PressEnterKey();
            showPatientMenu();
        }
        showPatientList(patientList);
        int indexPatient = patientList.size();
        int decide = input.inputInt("Select to show briefly information or enter '0' for back to patient menu", "Error - invalid input");
        if (decide == 0) {
            System.out.println("Go back to patient menu...");
            input.deleteToken();
            input.PressEnterKey();
            showPatientMenu();
        } else if (decide <= indexPatient && decide > 0) {
            System.out.println("----------------------------------------");
            patientList.get(decide - 1).printAllinfo();
            System.out.println("----------------------------------------");
            input.deleteToken();
            input.PressEnterKey();
            showPatientMenu();
        } else {
            System.out.println("Error Selection - Please try again...");
            input.PressEnterKey();
            viewPatient();
        }
    }

    void removePatient() {//Remove pateint by list
        input.deleteToken();
        char YorN = input.inputChar("Remove patient , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Resign the doctor------");
        } else {
            System.out.println("Go back to patient menu...");
            input.PressEnterKey();
            showPatientMenu();
        }
        showPatientList(patientList);
        int indexPatient = patientList.size();
        int decide = input.inputInt("Select by number to remove or enter '0' for back to patient menu", "Error - invalid input");
        if (decide == 0) {
            System.out.println("Go back to patient menu...");
            input.deleteToken();
            showPatientMenu();
        } else if (decide <= indexPatient && decide > 0) {
            System.out.println("----------------------------------------");
            patientList.get(decide - 1).printAllinfo();
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Error Selection - Plese try again...");
            input.PressEnterKey();
            removePatient();
        }
        input.deleteToken();
        YorN = input.inputChar("Are you sure ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            patientList.remove(decide - 1);
            System.out.println("This pateint has removed!!!");
            input.PressEnterKey();
            showPatientMenu();
        } else {
            System.out.println("Go back to patient menu...");
            input.PressEnterKey();
            showPatientMenu();
        }
    }

    void editPatient() {//edit pateint information process
        input.deleteToken();
        char YorN = input.inputChar("Edit patient , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Edit the patient------");
        } else {

            System.out.println("Go back to patient menu...");
            input.PressEnterKey();
            showPatientMenu();
        }
        showPatientList(patientList);
        int indexPatient = patientList.size();
        int decide = input.inputInt("Select by number to edit or enter '0' for back to patient menu", "Error - invalid input");
        if (decide == 0) {
            input.PressEnterKey();
            showPatientMenu();
        } else if (decide <= indexPatient && decide > 0) {
            System.out.println("----------------------------------------");
            patientList.get(decide - 1).printAllinfo();
            System.out.println("----------------------------------------");
            input.PressEnterKey();
        } else {
            System.out.println("Error Selection - Please try again...");
            input.PressEnterKey();
            editPatient();
        }
        input.deleteToken();
        System.out.println("(1)First name");
        System.out.println("(2)Last name");
        System.out.println("(3)Telephone number");

        int choose = input.inputInt("Select to edit", "Error - invalid input");
        switch (choose) {
            case 1:
                input.deleteToken();
                patientList.get(decide - 1).setFirstName(input.inputName("Enter first name", "Error - First name cannot be blank, number or any white space."));
                System.out.println("Successfully edit!!!");
                input.PressEnterKey();
                break;
            case 2:
                input.deleteToken();
                patientList.get(decide - 1).setLastName(input.inputName("Enter last name", "Error - Last name cannot be blank, number or any white space."));
                System.out.println("Successfully edit!!!");
                input.PressEnterKey();
                break;
            case 3:
                input.deleteToken();
                patientList.get(decide - 1).setTel(input.inputTel("Enter telephone number(Example:0xxxxxxxxx)", "Error - Telephone number cannot be blank and must enter like form"));
                System.out.println("Successfully edit!!!");
                input.PressEnterKey();
                break;
            default:
                System.out.println("Error selection - please try again...");
                input.PressEnterKey();
                ;
                editPatient();
        }
        showPatientMenu();
    }

///////////////////////////////////End patient part/////////////////////////////////////////////
//////////////////////////////////Appointment part/////////////////////////////////////////////  
    void showAppointmentMenu() {
        System.out.println("++++++++++Appointment menu++++++++++");
        System.out.println("(1)Add appointment");
        System.out.println("(2)Cancel or remove appointment");
        System.out.println("(3)Show appointment record");
        System.out.println("(4)Postpone appointment");
        System.out.println("(0)Back to main menu");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        int choose = input.inputInt("Please choose from menu", "Error - invalid input");

        switch (choose) {
            case 1:
                addAppointment();
                break;
            case 2:
                removeAppointment();
                break;
            case 3:
                viewAppointment();
                break;
            case 4:
                editAppointment();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("Error selection - Please try again... ");
                input.PressEnterKey();
                showDoctorMenu();
        }
    }

    void addAppointment() {//Make an appointment
        input.deleteToken();
        char YorN = input.inputChar("Make appointment , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Make An Appointment------");
        } else {
            System.out.println("Go back to appoinment menu...");
            input.PressEnterKey();
            showAppointmentMenu();
        }
        YorN = input.inputChar("Did patient register ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("##Start appointment##");//Start appointment here
            Appointment appoint = new Appointment();
            Doctor selectedDoctor = new Doctor();
            Patient selectedPatient = new Patient();
            showPatientList(patientList);
            int indexPatient = patientList.size();
            int decide = input.inputInt("Select patient or press'0' to go back", "Error - invalid input");//Select patient part
            if (decide == 0) {
                System.out.println("Go back to appointment menu...");
                input.deleteToken();
                input.PressEnterKey();
                showAppointmentMenu();
            } else if (decide <= indexPatient && decide > 0) {
                selectedPatient = patientList.get(decide - 1);
                appoint.setPatient(selectedPatient);
            } else {
                System.out.println("Error Selection - Please try again...");
                input.PressEnterKey();
                addAppointment();
            }
            showDoctorList(doctorList);
            int indexDoc = doctorList.size();
            decide = input.inputInt("Select doctor or press '0' to go back", "Error - invalid input");//Select doctor part
            if (decide == 0) {
                System.out.println("Go back to appointment menu...");
                input.deleteToken();
                input.PressEnterKey();
                showAppointmentMenu();
            } else if (decide <= indexDoc && decide > 0) {
                selectedDoctor = doctorList.get(decide - 1);
                appoint.setDoctor(selectedDoctor);
            } else {
                System.out.println("Error Selection - Please try again...");
                input.PressEnterKey();
                addAppointment();
            }
            System.out.println("--Enter appointment date--");
            appoint.setAppointDate(input.inputDate());
            if (checkRealtime(appoint) == false) {
                System.out.println("Can make an appointment after currently date only !!!");
                input.PressEnterKey();
                addAppointment();
            }
            decide = input.inputInt("Select doctor's time\n[1]9:00-11:00\n[2]11:00-13:00\n[3]13:00-15:00\n[4]15:00-17:00", "Error - invalid input");
            if (decide <= selectedDoctor.getTimes().length && decide > 0) {
                appoint.setAppointTime(selectedDoctor.getTimes()[decide - 1]);
            } else {
                System.out.println("Error Selection - Please try again...");
                input.PressEnterKey();
                addAppointment();
            }
            if (isAvailable(appointList, appoint) == false) {
                System.out.println("!!!!!!This doctor is not available on this time!!!!!!");
                input.PressEnterKey();
                addAppointment();
            } else {
                input.deleteToken();
                appoint.setPurpose(input.inputString("Enter purpose of this appointment", "Error - must has the propose"));
                appoint.setConfirmTime(getCurrentlyTime());
                System.out.println("----------------------------------------");
                appoint.printAppointInfo();
                System.out.println("----------------------------------------");
                YorN = input.inputChar("Are you sure ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
                if (YorN == 'Y' || YorN == 'y') {
                    appointList.add(appoint);
                    appoint.setRecord(selectedPatient.getFirstName(), selectedPatient.getLastName(), appoint.getAppointDay(), appoint.getAppointMonth(), appoint.getAppointYear(), appoint.getAppointTime());
                    System.out.println("Appointment Confirm!!!");
                    input.PressEnterKey();
                    showAppointmentMenu();
                } else {
                    System.out.println("Go back to appointment menu....");
                    input.PressEnterKey();
                    showAppointmentMenu();
                }
            }
        } else {
            System.out.println("Please register first...");
            input.PressEnterKey();
            showAppointmentMenu();
        }

    }

    void viewAppointment() {//Show appointment record
        input.deleteToken();
        char YorN = input.inputChar("Show appointment record , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Show Appointment Record------");
        } else {
            System.out.println("Go back to appointment menu...");
            input.PressEnterKey();
            showAppointmentMenu();
        }
        showAppointList(appointList);
        int indexAppoint = appointList.size();
        int decide = input.inputInt("Select to show briefly information or enter '0' for back to appointment menu", "Error - invalid input");
        if (decide == 0) {
            input.deleteToken();
            System.out.println("Go back to appointment menu...");
            input.PressEnterKey();
            showAppointmentMenu();;
        } else if (decide <= indexAppoint && decide > 0) {
            System.out.println("----------------------------------------");
            appointList.get(decide - 1).printAppointInfo();
            System.out.println("----------------------------------------");
            input.deleteToken();
            input.PressEnterKey();
            showAppointmentMenu();
        } else {
            System.out.println("Error Selection - Please try again");
            input.PressEnterKey();
            viewAppointment();
        }
    }

    void removeAppointment() {//Remove appointment from list
        input.deleteToken();
        char YorN = input.inputChar("Remove appointment , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Cancel or Remove Appointment------");
        } else {
            System.out.println("Go back to appointment menu...");
            input.PressEnterKey();
            showAppointmentMenu();
        }
        showAppointList(appointList);
        int indexAppoint = appointList.size();
        int decide = input.inputInt("Select by number to remove or enter '0' for back to appointment menu", "Error - invalid input");

        if (decide == 0) {
            input.deleteToken();
            System.out.println("Go back to appointment menu...");
            input.PressEnterKey();
            showAppointmentMenu();;
        } else if (decide <= indexAppoint && decide > 0) {
            System.out.println("----------------------------------------");
            appointList.get(decide - 1).printAppointInfo();
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Error Selection - please try again...");
            input.PressEnterKey();
            removeAppointment();
        }
        input.deleteToken();
        YorN = input.inputChar("Are you sure ? [Y]/[N]", "Error - Please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            appointList.remove(decide - 1);
            System.out.println("This appointment has removed!!!");
            input.PressEnterKey();
            showAppointmentMenu();
        } else {
            input.deleteToken();
            System.out.println("Go back to appointment menu....");
            input.PressEnterKey();
            showAppointmentMenu();
        }
    }

    void editAppointment() {//Postpone an appointment
        input.deleteToken();
        char YorN = input.inputChar("Postpone appointment , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Postpone the Appointment------");
        } else {
            System.out.println("Go back to appointment menu...");
            input.PressEnterKey();
            showAppointmentMenu();
        }
        showAppointList(appointList);
        int indexAppoint = appointList.size();
        int decide = input.inputInt("Select by number to edit or enter '0' for back to apointment menu", "Error - invalid input");

        if (decide == 0) {
            input.deleteToken();
            System.out.println("Go back to appointment menu...");
            input.PressEnterKey();
            showAppointmentMenu();;
        } else if (decide <= indexAppoint && decide > 0) {
            System.out.println("----------------------------------------");
            appointList.get(decide - 1).printAppointInfo();
            System.out.println("----------------------------------------");
            input.PressEnterKey();
        } else {
            System.out.println("Error Selection - please try again...");
            input.PressEnterKey();
            editAppointment();
        }
        input.deleteToken();
        int index = appointList.indexOf(appointList.get(decide - 1));
        Appointment postpone = new Appointment();
        postpone.setDoctor(appointList.get(index).getDoctor());
        postpone.setPatient(appointList.get(index).getPatient());
        postpone.setPurpose(appointList.get(index).getPurpose());
        System.out.println("--Enter new date--");
        postpone.setAppointDate(input.inputDate());
        if (checkRealtime(postpone) == false) {
            System.out.println("Can make an appointment after currently date only !!!");
            input.PressEnterKey();
            editAppointment();
        }
        decide = input.inputInt("Select doctor's time\n[1]9:00-11:00\n[2]11:00-13:00\n[3]13:00-15:00\n[4]15:00-17:00", "Error - invalid input");
        if (decide <= postpone.getDoctor().getTimes().length && decide > 0) {
            postpone.setAppointTime(postpone.getDoctor().getTimes()[decide - 1]);
        } else {
            input.deleteToken();
            System.out.println("Error Selection - Please try again...");
            input.PressEnterKey();
            editAppointment();
        }

        if (isAvailable(appointList, postpone) == false) {
            System.out.println("!!!!!!This doctor is not available on this time!!!!!!");
            input.PressEnterKey();
            editAppointment();
        } else {
            appointList.get(index).getPatient().setDateAndtime(getCurrentlyTime());
            appointList.get(index).setRecord(postpone.getPatient().getFirstName(), postpone.getPatient().getLastName(), postpone.getAppointDay(), postpone.getAppointMonth(), postpone.getAppointYear(), postpone.getAppointTime());
            input.deleteToken();
            System.out.println("Successfully edit!!!");
            input.PressEnterKey();
            showAppointmentMenu();
        }
    }

    //////////////////////////////////////// end appoitnment part/////////////////////////////////////////////
    //////////////////////////////Clinic funtions///////////////////////////////////////////
    void searchPatient() {//Search patient by name
        input.deleteToken();
        char YorN = input.inputChar("Search patient , Are you sure ? [Y]/[N]", "Error - please input only Y/N", new char[]{'Y', 'N', 'y', 'n'});
        if (YorN == 'Y' || YorN == 'y') {
            System.out.println("------Search patient by name------");
        } else {
            System.out.println("Go back to main menu...");
            input.PressEnterKey();
            showMainMenu();
        }
        String search = input.inputName("Enter patient's first name", "Error - please input the name");
        int check;
        for (Patient list : patientList) {
            check = search.compareToIgnoreCase(list.getFirstName());
            if (check == 0) {
                search = input.inputName("Enter patient's last name", "Error - please enter the name");
                check = search.compareToIgnoreCase(list.getLastName());
                if (check == 0) {
                    System.out.println("----------------------------------------");
                    list.printAllinfo();
                    System.out.println("----------------------------------------");
                    input.PressEnterKey();
                    showMainMenu();
                }
            }

        }
        System.out.println("This patient never register here....");
        input.PressEnterKey();
        showMainMenu();
    }

    static void showDoctorList(ArrayList<Doctor> doctorList) {//show doctor name by list
        for (Doctor list : doctorList) {
            System.out.println("[" + (doctorList.indexOf(list) + 1) + "]" + list.getFirstName() + " " + list.getLastName());
        }
    }

    static void showPatientList(ArrayList<Patient> patientList) {//show patient name by list
        for (Patient list : patientList) {
            System.out.println("[" + (patientList.indexOf(list) + 1) + "]" + list.getFirstName() + " " + list.getLastName());
        }
    }

    static void showAppointList(ArrayList<Appointment> appointList) {//show appointment short information
        for (Appointment list : appointList) {
            System.out.println("[" + (appointList.indexOf(list) + 1) + "]" + list.getRecord());
        }
    }

    static boolean isAvailable(ArrayList<Appointment> appointList, Appointment appoint) {
        for (Appointment list : appointList) {
            if (list.getDoctor() == appoint.getDoctor() && list.getAppointDay() == appoint.getAppointDay() && list.getAppointMonth() == appoint.getAppointMonth() && list.getAppointYear() == appoint.getAppointYear() && list.getAppointTime().equalsIgnoreCase(appoint.getAppointTime())) {
                return false;
            }
        }
        return true;
    }

    static boolean checkRealtime(Appointment appoint) {//Check currently time
        Date realTime = new Date();
        Date appointTime = new Date(appoint.getAppointYear() - 1900, appoint.getAppointMonth() - 1, appoint.getAppointDay());
        if (realTime.before(appointTime)) {
            return true;
        }
        return false;
    }

    static String getCurrentlyTime() { //get currently time
        String currentTime;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");//to set date and time automatically
        Date date = new Date();
        currentTime = dateFormat.format(date);
        return currentTime;
    }
////////////////////////////////////end Clicnic function//////////////////////////////////////////

    void initialize() {
        //initialize Doctor
        Doctor doctor1 = new Doctor("Orthopedic", "Thapakorn", "Tuwaemuesa", 13, 4, 1994, 22, "1431100046130", "Male");
        doctorList.add(doctor1);
        Doctor doctor2 = new Doctor("Surgery", "Hathaichannok", "Dumrongsiri", 13, 4, 1997, 19, "5821150450000", "Female");
        doctorList.add(doctor2);
        Doctor doctor3 = new Doctor("Internal Medicine", "Nuntachat", "Pattanasart", 27, 1, 1997, 19, "5821150310000", "Female");
        doctorList.add(doctor3);
        //initialize Patient0,
        Patient patient1 = new Patient("0856828074", "01/04/2016 15:15:05", "Thanawat", "Lukuan", 7, 9, 1996, 20, "5821150010000", "Male");
        patientList.add(patient1);
        Patient patient2 = new Patient("0635606532", "05/04/2016 12:07:58", "Sear", "Choulong", 11, 12, 1996, 20, "5821155030000", "Male");
        patientList.add(patient2);
        Patient patient3 = new Patient("0842145642", "31/03/2016 08:35:29", "Krissada", "Pulsawasdi", 25, 10, 1995, 21, "5821150030000", "Male");
        patientList.add(patient3);

    }
}
