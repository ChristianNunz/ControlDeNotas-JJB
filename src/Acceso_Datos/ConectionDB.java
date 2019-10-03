/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;


import Logica_Negocios.EditarNota;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
            // CON ESTE METODO OBTENEMOS EL DOCENTE CON MAXIMO ID QUE EN ESTE CASO SERIA EL ULTIMO
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
    //OBTENEMOS EL ULTIMO ID DE LA TABLA 
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
     public List<EditarNota> GetListaNotas(String periodo, String grado, String materia,String Seccion, String docenteid){
        try {
            List<EditarNota> editarNotas = new ArrayList<EditarNota>();
            Statement st = conn();
            ResultSet resultSet = st.executeQuery("SELECT p.id_periodo,a.alumno_nombre,a.alumno_apelidos,p.nota1,p.nota2,p.nota3 FROM alumno A"
                    + " INNER JOIN NOTA N ON a.id_alumno = n.id_alumno "
                    + "INNER JOIN periodo P ON n.id_nota = p.id_nota "
                    + "INNER JOIN materia_grado MG ON n.id_materia_grado=mg.id_materia_grado "
                    + "INNER JOIN SECCION S ON mg.id_seccion = s.id_seccion "
                    + "INNER JOIN turno T ON mg.id_turno = t.id_turno "
                    + "INNER JOIN materia M ON mg.id_materia = m.id_materia "
                    + "INNER JOIN docente D ON mg.id_docente=d.id_docente "
                    + "INNER JOIN grado G ON mg.id_grado = g.id_grado "
                    + "WHERE p.periodo="+periodo+" AND g.grado='"+grado+"' AND m.materia_nombre='"+materia+"' AND s.nombre_seccion='"+Seccion+"' AND d.id_docente='"+docenteid+"'");
            while(resultSet.next()){
                
                
                 EditarNota editarNota = new EditarNota(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4)), Double.parseDouble(resultSet.getString(5)), Double.parseDouble(resultSet.getString(6)));
                 editarNotas.add(editarNota);                
           }
            return editarNotas;
        } catch (Exception e) {
             return null;
        }
    }
     public List<EditarNota> GetListaAlumnos( String grado, String materia,String Seccion, String docenteid){
        try {
            List<EditarNota> editarNotas = new ArrayList<EditarNota>();
            Statement st = conn();
            ResultSet resultSet = st.executeQuery("SELECT p.id_periodo,a.alumno_nombre,a.alumno_apelidos,p.nota1,p.nota2,p.nota3 FROM alumno A"
                    + " INNER JOIN NOTA N ON a.id_alumno = n.id_alumno "
                    + "INNER JOIN periodo P ON n.id_nota = p.id_nota "
                    + "INNER JOIN materia_grado MG ON n.id_materia_grado=mg.id_materia_grado "
                    + "INNER JOIN SECCION S ON mg.id_seccion = s.id_seccion "
                    + "INNER JOIN turno T ON mg.id_turno = t.id_turno "
                    + "INNER JOIN materia M ON mg.id_materia = m.id_materia "
                    + "INNER JOIN docente D ON mg.id_docente=d.id_docente "
                    + "INNER JOIN grado G ON mg.id_grado = g.id_grado "
                    + "WHERE  g.grado='"+grado+"' AND m.materia_nombre='"+materia+"' AND s.nombre_seccion='"+Seccion+"' AND d.id_docente='"+docenteid+"'");
            while(resultSet.next()){
                
                
                 EditarNota editarNota = new EditarNota(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4)), Double.parseDouble(resultSet.getString(5)), Double.parseDouble(resultSet.getString(6)));
                 editarNotas.add(editarNota);                
           }
            return editarNotas;
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
    public int GetIdValidar(BigDecimal idm, BigDecimal ids, BigDecimal idg,BigDecimal idt, BigDecimal idd){
        try {
            Statement st = conn();
             ResultSet resultSet = st.executeQuery("SELECT  ID_MATERIA_GRADO FROM MATERIA_GRADO WHERE ID_MATERIA = '"+(idm)+"' AND ID_GRADO =  '"+(ids)+"' AND ID_SECCION = '"+(idg)+"'  AND ID_TURNO = '"+(idt)+"'");
             resultSet.next();
              int iddd = Integer.parseInt(resultSet.getString(1));
              return iddd;
        } catch (Exception e) {
             return 0;
        }
    }
    public BigDecimal GetIdDocnete(String NombreD){
        try {
            Statement st = conn();
             ResultSet resultSet = st.executeQuery("SELECT  ID_DOCENTE FROM DOCENTE WHERE DOCENTE_NOMBRE = '"+(NombreD)+"'");
             resultSet.next();
              int iddd = Integer.parseInt(resultSet.getString(1));
              BigDecimal id = new BigDecimal(iddd);
              return id;
        } catch (Exception e) {
             return null;
        }
    }
    
}
