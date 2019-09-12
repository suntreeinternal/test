package CurrentPatienInfo;

public class Patient {
    private String firstname;
    private String lastName;
    private String dob;
    private String Id;

    public Patient (String firstName, String lastName, String dob, String Id){
        this.firstname = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.Id = Id;
    }

    public String getFullName(){
        return (this.lastName + ", " + this.firstname);
    }

    public String getDob(){
        return this.dob;
    }
    public String getId(){
        return this.Id;
    }
}
