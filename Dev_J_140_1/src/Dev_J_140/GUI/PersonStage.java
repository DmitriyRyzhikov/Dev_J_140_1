
package Dev_J_140.GUI;

import Dev_J_140.tableDataModels.PersonTable;
import Dev_J_140.models.Domains;
import Dev_J_140.repo.Repository;
import Dev_J_140.models.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PersonStage{
    
    private Stage stage;
    Map<Integer, List<Domains>> domainsOfPersonMap = new HashMap<>();

    public Map<Integer, List<Domains>> getDomainsOfPersonMap() {
        return domainsOfPersonMap;
    }

    public void show(){
        stage = new Stage();
        StackPane root = new StackPane();
        List<PersonTable> personTableList = new ArrayList<>();
        
        List<Person> personList = new Repository().getPersons();
        for(Person person : personList){
            List<Domains> domainsListOfPerson = new Repository().getDomainsByPerson(person);
            int idPerson = person.getId();
            domainsOfPersonMap.put(idPerson, domainsListOfPerson);
            int numberOfDomains = domainsListOfPerson.size();
            personTableList.add(new PersonTable(person.getId(), 
                    person.getJobTitle(), 
                    person.getFirstNameLastName(), 
                    person.getPhone(), 
                    person.getEmail(), 
                    numberOfDomains));
        }
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList(personTableList);
        TableView<PersonTable> table = new TableView<PersonTable>(observableList);
        
        TableColumn<PersonTable, Integer> idColumn = new TableColumn<>("Идентификатор");
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        idColumn.setStyle("-fx-alignment: CENTER; -fx-width: 200");
        idColumn.setMinWidth(130); 
        table.getColumns().add(idColumn);
        
        TableColumn<PersonTable, String> jobTitle = new TableColumn<>("Должность");
        jobTitle.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobTitle"));
        table.getColumns().add(jobTitle);
        
        TableColumn<PersonTable, String> firstNameLastName = new TableColumn<>("Фамилия и имя");
        firstNameLastName.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("firstNameLastName"));
        table.getColumns().add(firstNameLastName);
        
        TableColumn<PersonTable, String> phone = new TableColumn<>("Телефон");
        phone.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        phone.setStyle("-fx-alignment: CENTER;"); 
        table.getColumns().add(phone);
        
        TableColumn<PersonTable, String> email = new TableColumn<>("e-mail");
        email.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        table.getColumns().add(email);
        
        TableColumn<PersonTable, Integer> numberOfDomains = new TableColumn<>("кол-во доменов");
        numberOfDomains.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("numberOfDomains"));
        numberOfDomains.setStyle("-fx-alignment: CENTER;");
        numberOfDomains.setMinWidth(145);
        
        table.getColumns().add(numberOfDomains);
        table.setStyle("-fx-font-size: 15;"); 
         
        table.setRowFactory( tv -> {
        TableRow<PersonTable> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!row.isEmpty())) {
            PersonTable personTableSelected = row.getItem();
            Integer idPerson = personTableSelected.getId();
            new DomainsStage(stage, personTableSelected, domainsOfPersonMap.get(idPerson)).show(); 
        }
        });
           return row ;
        });
        
        root.getChildren().add(table);
        Scene scene = new Scene(root, 1000, 600);
        
        stage.setTitle("Persons");
        stage.setScene(scene);
        stage.show();
    }   
}

