package Dev_J_140.repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties extends Properties{
    
    private static ApplicationProperties ap;
    
    private ApplicationProperties(){}
    
    public static ApplicationProperties get(){
        if(ap==null) {
           ap = new ApplicationProperties();
           File file = new File("application.properties");
           try {
               if(file.exists()) file.createNewFile();
                       ap.load(new FileInputStream(file)); 
                   } catch (IOException ex) {
                       Logger.getLogger(ApplicationProperties.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
        return ap;
    }
    
}