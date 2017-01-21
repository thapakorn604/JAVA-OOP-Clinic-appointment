package Program;

/**
 * Abstract class Person use for get person basic method and extends to doctor
 * and patient
 *
 * @author Thapakorn
 */
public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected int birthDay;
    protected int birthMonth;
    protected int birthYear;
    protected int age;
    protected String citizenID;
    protected String gender;

    Person() {
    }

    public Person(String fistName, String lastName, int birthDay, int birthMonth, int birthYear, int age, String citizenID, String gender) {

        this.firstName = fistName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.age = age;
        this.citizenID = citizenID;
        this.gender = gender;
    }

    void setFirstName(String firstname) {
        String firstLetter = firstname.substring(0, 1);//for set the first lettter as Capital letter
        firstLetter = firstLetter.toUpperCase();
        firstname = firstname.substring(1);
        firstname = firstLetter + firstname;
        this.firstName = firstname;
    }

    String getFirstName() {
        return this.firstName;
    }

    void setLastName(String lastname) {
        String firstLetter = lastname.substring(0, 1);//for set the first lettter as Capital letter
        firstLetter = firstLetter.toUpperCase();
        lastname = lastname.substring(1);
        lastname = firstLetter + lastname;
        this.lastName = lastname;
    }

    String getLastName() {
        return this.lastName;
    }

    void setGender(char gender) {
        if (gender == 'm'||gender == 'M'){
            this.gender = "Male";
        }else{
            this.gender = "Female";
        }
    }

    String getGender() {
        return this.gender;
    }

    void setCitizenID(String id) {
        this.citizenID = id;
    }

    String getCitizenID() {
        return this.citizenID;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    void setDateOfbirth(int[] date) {
        int year = date[2];
        int month = date[1];
        int day = date[0];
        
        this.birthDay = day;
        this.birthMonth = month;
        this.birthYear = year;
    }

    abstract void printAllinfo();
}
