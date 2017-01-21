package Program;

/**
 * Class Appointment use for make an appointment by receive doctor and patient
 * together
 *
 * @author Thapakorn
 */
public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private String purpose;
    private int appointDay;
    private int appointMonth;
    private int appointYear;
    private String appointTime;
    private String record;
    private String confirmTime;

    Appointment() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setAppointDate(int[] date) {
        int year = date[2];
        int month = date[1];
        int day = date[0];

        this.appointDay = day;
        this.appointMonth = month;
        this.appointYear = year;
    }

    public int getAppointDay() {
        return this.appointDay;
    }

    public int getAppointMonth() {
        return this.appointMonth;
    }

    public int getAppointYear() {
        return this.appointYear;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getRecord() {
        return record;
    }

    void setRecord(String firstName, String lastName, int appointDay, int appointMonth, int appointYear, String appointTime) {
        this.record = (firstName + "\t" + lastName + "\t" + appointDay + "/" + appointMonth + "/" + appointYear + "\t" + appointTime);
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    void printAppointInfo() {//Print briefly appointment information
        System.out.println("Patient : " + patient.getFirstName() + " " + patient.getLastName() + "\n"
                + "Appointment for : " + getPurpose() + "\n"
                + "Appointment doctor : " + doctor.getFirstName() + " " + doctor.getLastName() + "\n"
                + "Appointment time : " + appointDay + "/" + appointMonth + "/" + appointYear + "  " + getAppointTime() + "\n"
                + "Confirmed time : " + this.confirmTime);
    }
}
