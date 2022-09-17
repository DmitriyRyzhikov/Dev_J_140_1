
package Dev_J_140.tableDataModels;

import Dev_J_140.models.Person;
import Dev_J_140.models.Person;
import java.sql.Timestamp;


public class DomainsTable {
    
    private Integer id;
    private String webName;
    private String domainName;
    private String ip;
    private Timestamp dataReg;
    private String countryReg;
    private Person person;
    private String personName;
    private Integer idPerson;

    public DomainsTable(Integer id, String webName, String domainName, String ip, Timestamp dataReg, String countryReg, Person person) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dataReg = dataReg;
        this.countryReg = countryReg;
        this.person = person;
        personName = person.getFirstNameLastName();
        idPerson = person.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getDataReg() {
        return dataReg;
    }

    public void setDataReg(Timestamp dataReg) {
        this.dataReg = dataReg;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public void setCountryReg(String countryReg) {
        this.countryReg = countryReg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
    
}
