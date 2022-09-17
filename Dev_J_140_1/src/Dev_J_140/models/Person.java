
package Dev_J_140.models;

public class Person {
    
    private final Integer id;
    private String jobTitle;
    private String firstNameLastName;
    private String phone;
    private String email;

    public Person(Integer id, String jobTitle, String firstNameLastName, String phone, String email) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getFirstNameLastName() {
        return firstNameLastName;
    }
    public void setFirstNameLastName(String firstNameLastName) {
        this.firstNameLastName = firstNameLastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("id=").append(id);
        sb.append(", jobTitle=").append(jobTitle);
        sb.append(", firstNameLastName=").append(firstNameLastName);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }    
}
