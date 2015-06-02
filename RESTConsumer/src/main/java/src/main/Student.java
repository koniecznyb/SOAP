package src.main;

/**
 * Created by redi on 28.04.15.
 */
public class Student {

    private String firstName;
    private String lastName;
    private String indexNo;

    public Student() {
    }

    public Student(String firstName, String lastName, String indexNo) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNo = indexNo;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }
}
