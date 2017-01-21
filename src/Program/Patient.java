package Program;

/**
 * Class object patient use for get information of patient
 *
 * @author Thapakorn
 */
public class Patient extends Person {

    Patient() {
    }

    public Patient(String tel, String dateAndtime) {
        this.tel = tel;
        this.dateAndtime = dateAndtime;
        
    }

    public Patient(String tel, String dateAndtime, String fistName, String lastName, int birthDay, int birthMonth, int birthYear, int age, String citizenID, String gender) {
        super(fistName, lastName, birthDay, birthMonth, birthYear, age, citizenID, gender);
        this.tel = tel;
        this.dateAndtime = dateAndtime;
    }

    private String tel;
    private String dateAndtime;  
    
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    void printAllinfo() {
        System.out.println("Patient : " + firstName + "  " + lastName + "\n"
                + "Sex : " + gender + "\n"
                + "Citizen ID : " + citizenID + "\n"
                + "Date of birth(dd/mm/yyyy): " + birthDay + "/" + birthMonth + "/" + birthYear + "\n"
                + "Age : " + age + " years old" + "\n"
                + "Tel : " + tel + "\n"
                + "Registerd date : " + dateAndtime);
    }

    public void setDateAndtime(String dateAndtime) {
        this.dateAndtime = dateAndtime;
    }

    public String getDateAndTime() {
        return this.dateAndtime;
    }
}
