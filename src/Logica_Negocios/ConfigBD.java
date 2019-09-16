/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Jorge Villanueva
 */
public class ConfigBD {
    private String clase;
    private String cadena;
    private String usuario;
    private String clave;
        
    public Statement ConfiguracionBD()
    {
        try{  
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando con la base de datos...");
            Connection connection = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE","DIRECTOR","jjb");
            Statement statement = connection.createStatement();
            return statement;
        }catch(Exception e){
            System.out.println("The exception raised is:" + e);
            return null;  
        } 
    }
      public LinkedList<String> query (String from){
            try{
                Statement st = ConfiguracionBD();
                ResultSet resultSet = st.executeQuery(from);

                LinkedList<String> result = new LinkedList();
                while(resultSet.next()){
                    for(int i=1;i< resultSet.getMetaData().getColumnCount(); i++){
                        result.add(resultSet.getString(i));
                    }
                }
                return result;
            }catch (Exception e){
                return null;
            }
    }
    public void fijartodo()
    {
        clase="Provider=OraOLEDB.Oracle;";
        cadena="Data Source=MyOracleDB;";
        usuario="User Id=myUsername;";
        clave=  "Password=myPassword;";       
    }
}
