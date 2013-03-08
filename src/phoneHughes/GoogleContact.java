
package phoneHughes;

/**
 * Google Contact Entity Class
 * For compatibility reasons I keep it simple.
 * 
 * No worrying for merging duplicates, Google once again did an amazing job.
 * 
 * @author ahughes
 */
public class GoogleContact {
    
    private String firstName;
    private String lastName;
        
    private String email1;  
    private String phone1;
    
    private String group;

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

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
