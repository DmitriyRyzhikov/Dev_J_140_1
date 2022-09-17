
package Dev_J_140.tableDataModels;


public class PersonTable {
    private Integer id;
    private String jobTitle;
    private String firstNameLastName;
    private String phone;
    private String email;
    Integer numberOfDomains;

    public PersonTable(Integer id, String jobTitle, String firstNameLastName, String phone, String email, Integer numberOfDomains) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
        this.numberOfDomains = numberOfDomains;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNumberOfDomains() {
        return numberOfDomains;
    }

    public void setNumberOfDomains(Integer numberOfDomains) {
        this.numberOfDomains = numberOfDomains;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + firstNameLastName + 
               "\nJobtitle: " + jobTitle + "\nPhone: " + 
               phone + "\nEmail: " + email + "\nNumber of domains: " + 
               numberOfDomains;
    }    
}

