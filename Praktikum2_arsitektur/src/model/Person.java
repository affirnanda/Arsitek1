package src.model;

public class Person {
    private String firstname;
    private String lastname;
    private String idNumber;

    public Person(String firstname, String lastname, String idNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.idNumber = idNumber;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public String getidNumber() {
        return idNumber;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }

}
