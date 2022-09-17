
package Dev_J_140.repo;
import Dev_J_140.models.Domains;
import Dev_J_140.models.Person;
import Dev_J_140.models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class Repository implements RepositoryInterface{
    
    @Override
    public List<User> getUsers(String userName){

        List<User> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users WHERE name = '" + userName + "'")){
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                User user = new User(id, name, password);
                list.add(user);
            }
        }catch(SQLException e){
            alertMessage();
        }
        
        return list;
    }

    @Override
    public List<Person> getPersons() {

        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person")){
            while(rs.next()){
                int id = rs.getInt(1);
                String jobTitle = rs.getString(2);
                String firstNameLastName = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(id, jobTitle, firstNameLastName, phone, email); 
                list.add(person);
            }
        }catch(SQLException e){
            alertMessage();
        }
        
        return list;
    }

    @Override
    public List<Domains> getDomainsByPerson(Person person) {
        
        List<Domains> list = new ArrayList<>();
        if(person!=null){
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM domains WHERE personid = " + person.getId())){
            while(rs.next()){
                int id = rs.getInt(1);
                String webName = rs.getString(2);
                String domainName = rs.getString(3);
                String ip = rs.getString(4);
                Timestamp dataReg = rs.getTimestamp(5);
                String countryReg = rs.getString(6);
                Domains domains = new Domains(id, webName, domainName, ip, dataReg, countryReg, person); 
                list.add(domains);
            }
        }   catch (SQLException ex) {
                   alertMessage();
            }
        }
        return list;
    }
    
    private Connection getConnection() throws SQLException{
        String url = ApplicationProperties.get().getProperty("db.url");
        String dbUser = ApplicationProperties.get().getProperty("db.user");
        String dbPassword = ApplicationProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
    private void alertMessage(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("The database server is not responding, or an error occurred when querying the database."
                + "\nFurther operation of the application is impossible. The application will be closed.");
        alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> System.exit(0)); 
    }
}
