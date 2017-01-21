package Program;

/**
 * Class object doctor use for  get doctor's information
 *
 * @author Thapakorn
 */
public class Doctor extends Person {

    private String specialty;
    private final String[] times = new String[]{"9:00-11:00", "11:00-13:00", "13:00-15:00", "15:00-17:00"};

    Doctor() {
    }

    public Doctor(String specialty) {
        this.specialty = specialty;
    }

    public Doctor(String specialty, String fistName, String lastName, int birthDay, int birthMonth, int birthYear, int age, String citizenID, String gender) {
        super(fistName, lastName, birthDay, birthMonth, birthYear, age, citizenID, gender);
        this.specialty = specialty;
    }

    public String[] getTimes() {
        return times;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        String firstLetter = specialty.substring(0, 1);//for set the first lettter as Capital letter
                firstLetter = firstLetter.toUpperCase();
                specialty = specialty.substring(1);
                specialty = firstLetter + specialty;
                this.specialty = specialty;
    }

    @Override
    void printAllinfo() {
        System.out.println("Doctor : " + firstName + "  " + lastName + "\n"
                + "Sex : " + gender + "\n"
                + "Citizen ID : " + citizenID + "\n"
                + "Date of birth(dd/mm/yyyy): " + birthDay +"/"+birthMonth+"/"+birthYear+ "\n"
                + "Age : " + age + " years old" + "\n"
                + "Specialty : " + specialty);
    }
}
