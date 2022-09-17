
package Dev_J_140.GUI;

import Dev_J_140.tableDataModels.DomainsTable;
import Dev_J_140.tableDataModels.PersonTable;
import Dev_J_140.models.Domains;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class DomainsStage {
    
    private Stage stage;
    private final Stage ownerStage;
    private final List<Domains> domainsList;
    private final PersonTable personTableSelected;

    public DomainsStage(Stage ownerStage, PersonTable personTableSelected, List<Domains> domainsList) {
        this.ownerStage = ownerStage;
        this.domainsList = domainsList;
        this.personTableSelected = personTableSelected;
    }
     
    public void show(){
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(ownerStage);
        VBox root = new VBox();
        List<DomainsTable> domainsTableList = new ArrayList<>();
        for(Domains dom : domainsList){
            domainsTableList.add(new DomainsTable(dom.getId(), dom.getWebName(), 
                    dom.getDomainName(), dom.getIp(), dom.getDataReg(), dom.getCountryReg(), dom.getPerson()));
        }
        ObservableList<DomainsTable> observableList = FXCollections.observableArrayList(domainsTableList);
        TableView<DomainsTable> table = new TableView<>(observableList);
        
        TableColumn<DomainsTable, Integer> idColumn = new TableColumn<>("Идентификатор");
        idColumn.setCellValueFactory(new PropertyValueFactory<DomainsTable, Integer>("id"));
        idColumn.setStyle("-fx-alignment: CENTER;");
        idColumn.setMinWidth(130); 
        table.getColumns().add(idColumn);
        
        TableColumn<DomainsTable, String> webName = new TableColumn<>("Имя домена");
        webName.setCellValueFactory(new PropertyValueFactory<DomainsTable, String>("webName"));
        webName.setMinWidth(160); 
        table.getColumns().add(webName);
        
        TableColumn<DomainsTable, String> domainName = new TableColumn<>("Домен");
        domainName.setCellValueFactory(new PropertyValueFactory<DomainsTable, String>("domainName"));
        domainName.setStyle("-fx-alignment: CENTER;"); 
        table.getColumns().add(domainName);
        
        TableColumn<DomainsTable, String> ip = new TableColumn<>("IP");
        ip.setCellValueFactory(new PropertyValueFactory<DomainsTable, String>("ip"));
        ip.setStyle("-fx-alignment: CENTER;"); 
        table.getColumns().add(ip);
                
        TableColumn<DomainsTable, Timestamp> dataReg = new TableColumn<>("Дата регистрации");
        dataReg.setCellValueFactory(new PropertyValueFactory<DomainsTable, Timestamp>("dataReg"));
        table.getColumns().add(dataReg);
        
        TableColumn<DomainsTable, String> countryReg = new TableColumn<>("Страна регистрации");
        countryReg.setCellValueFactory(new PropertyValueFactory<DomainsTable, String>("countryReg"));
        countryReg.setMinWidth(200);
        table.getColumns().add(countryReg);
        
        table.setStyle("-fx-font-size: 15;-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background;");
        Label label = new Label(" Information about the domain owner:");
        label.setStyle("-fx-font-size: 18; -fx-font-weight: bold;"); 
        TextArea textArea = new TextArea();  
        textArea.setEditable(false);
        textArea.setMaxHeight(200.); 
        textArea.setText(personTableSelected.toString());
        textArea.setStyle("-fx-font-size: 15; -fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background;"); 
    
        root.setStyle("-fx-background-color: white;");  
        root.getChildren().addAll(label, textArea, table); 
        Scene scene = new Scene(root, 850, 500);
        
        stage.setTitle("Domains");
        stage.setScene(scene);
        stage.show();
    }
    
    
}

