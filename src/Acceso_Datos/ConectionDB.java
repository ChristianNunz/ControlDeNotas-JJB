/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;



import Logica_Negocios.EditarNota;
import Logica_Negocios.Materia;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *noooo
 * @author Jorge Villanueva
 */
public class ConectionDB {
    private static String url="jdbc:oracle:thin:@localhost:1521:XE";
    private static String user="directora";
    private static String pass="jjb";
   
    public Connection conn;

    public ConectionDB() {
        try {
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              conn=DriverManager.getConnection(url,user,pass);
              conn.setAutoCommit(false);
              if (conn != null) {
                  System.out.println("Conexion exitosa");
              }else{
                  System.out.println("Conexion erronea");
              }
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "conexion erronea"+e.getMessage());
          }
    }
    
      public Connection getconnection(){
          
          return conn;
      }
      
    public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("error al desconectar"+e.getMessage());
        }
    }
//    public Statement conn(){
//        try{  
//            
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            System.out.println("Conectando con la base de datos...");
//            Connection connection = DriverManager.getConnection(url,user,pass);
//           
//            Statement statement = connection.createStatement();
//            
//            return statement;
//        }catch(Exception e){
//            System.out.println("The exception raised is:" + e);
//        return null;  
//        } 
//    }
//    
//    public  void main(String[] args) {
//        ConectionDB cdb = new ConectionDB();
//        
//        PreparedStatement pst=null;
//        String sql="";
//        try {
//            pst=cdb.getconnection().prepareStatement(sql);
//            pst.setInt(1, 2);
//            pst.execute();
//            pst.close();
//        } catch (SQLException e) {
//        }
//    }
    
    //OBTENEMOS EL ULTIMO ID DE LA TABLA 
    public BigInteger GetLastId(String tabla, String Id){
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT MAX("+Id+") FROM "+tabla);  
            resultSet.next();
            BigInteger id= new BigInteger(resultSet.getString(1));
            st.close();
            return id;
        } catch (Exception e) {
             return null;
        }
    }
    public BigDecimal GetIdToInsert(String tabla, String Id){
        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT MAX("+Id+") FROM "+tabla);  
            resultSet.next();
            int idd = Integer.parseInt(resultSet.getString(1));
            idd=idd+1;
            BigDecimal id= new BigDecimal(idd);
            st.close();
            return id;
        } catch (Exception e) {
            return  new BigDecimal("1"); 
        }
    }
   
}
