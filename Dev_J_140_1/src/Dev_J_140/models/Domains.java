
package Dev_J_140.models;

import java.sql.Timestamp;

public class Domains {
    
    private final Integer id;
    private String webName;
    private String domainName;
    private String ip;
    private Timestamp dataReg;
    private String countryReg;
    private final Person person;

    public Domains(Integer id, String webName, String domainName, 
           String ip, Timestamp dataReg, String countryReg, Person person) 
       {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dataReg = dataReg;
        this.countryReg = countryReg;
        this.person = person;
       }
    public Integer getId() {
        return id;
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Domains{");
        sb.append("id=").append(id);
        sb.append(", webName=").append(webName);
        sb.append(", domainName=").append(domainName);
        sb.append(", ip=").append(ip);
        sb.append(", dataReg=").append(dataReg);
        sb.append(", countryReg=").append(countryReg);
        sb.append(", personId=").append(person.toString());
        sb.append('}');
        return sb.toString();
    }   
}
