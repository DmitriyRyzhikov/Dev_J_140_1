
package Dev_J_140.repo;

import Dev_J_140.models.Domains;
import Dev_J_140.models.Person;
import Dev_J_140.models.User;
import java.util.List;


public interface RepositoryInterface {
    
    List<User> getUsers(String userName);
    List<Person> getPersons();
    List<Domains> getDomainsByPerson(Person person);
    
}
