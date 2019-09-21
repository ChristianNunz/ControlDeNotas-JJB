/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Jorge Villanueva
 */
public class ConectionDB {
    String url="jdbc:oracle:thin:@localhost:1521:XE";
    String user="director";
    String pass="jjb";
    
      
    
    public Statement conn(){
        try{  
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        System.out.println("Conectando con la base de datos...");
        Connection connection = DriverManager.getConnection(url,user,pass);
        Statement statement = connection.createStatement();
        return statement;
        }catch(Exception e){
        System.out.println("The exception raised is:" + e);
        return null;  
        } 
    }
    public LinkedList<String> query (String from){
            try{
            Statement st = conn();
            ResultSet resultSet = st.executeQuery("SELECT MAX(ID_DOCENTE) FROM DOCENTE");

            LinkedList<String> result = new LinkedList();
            while(resultSet.next()){
            for(int i=1;i<= resultSet.getMetaData().getColumnCount(); i++){
            result.add(resultSet.getString(i));
            }
            }
            return result;
            }catch (Exception e){
            return null;
            }
    }
    //obtiene el ultimo id
    public BigInteger GetLastId(String tabla, String Id){
        try {
            Statement st = conn();
            ResultSet resultSet = st.executeQuery("SELECT MAX("+Id+") FROM "+tabla);  
            resultSet.next();
            BigInteger id= new BigInteger(resultSet.getString(1));
            return id;
        } catch (Exception e) {
             return null;
        }
    }
    public BigDecimal GetIdToInsert(String tabla, String Id){
        try {
            Statement st = conn();
            ResultSet resultSet = st.executeQuery("SELECT MAX("+Id+") FROM "+tabla);  
            resultSet.next();
            int idd = Integer.parseInt(resultSet.getString(1));
            idd=idd+1;
            BigDecimal id= new BigDecimal(idd);
            return id;
        } catch (Exception e) {
             return  new BigDecimal("1");
        }
    }
    
}