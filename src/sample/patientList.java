package sample;


import java.util.SplittableRandom;

public class patientList {
    private String firstName;
    private String lastName;
    private String patientDob;
    private String id;

    public patientList(String first, String last, String dob, String id){
        this.firstName = first;
        this.lastName = last;
        this.patientDob = dob;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPatientDob() {
        return patientDob;
    }

    public String getId(){
        return id;
    }
}
