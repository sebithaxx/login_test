/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;


/**
 *
 * @author Sebithaxx
 
public class Conexion {
private String USERNAME = "root";
private String PASSWORD = "1234";
private String HOST = "localhost";
private String PORT = "3306";
private String DATABASE = "loginjap";
private String CLASSNAME = "com.mysql.jdbc.Driver;
orivate String URL = "jdbc:MYSQL:/"+host":"+port+"/"+DATABASE;
}*/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;


public class Conexion {
         protected Connection con;
         protected Statement stmt;
         private final String serverName= "localhost";
         private final String portNumber = "3306";
         private final String databaseName= "recepcion";
         private final String url = "jdbc:mysql://localhost:3306/" + databaseName;
         private final String userName = "root";
         private final String password = ""; // Tells the controller to use a server cursor, // allowing more than one active instruction // in a connection. private final String selectMethod = "cursor"; // private String selectMethod = "cursor";

         private String errString;
     // Constructor public Connect(){}

      public Conexion()
      {

      }
        private String getConnectionUrl()
     {
         return url;
     }


     public Connection Conectar(){
        con=null;
         try{
              Class.forName("org.gjt.mm.mysql.Driver");
              con = DriverManager.getConnection(getConnectionUrl(),userName,password);
              stmt=con.createStatement();
              System.out.println("Conectado");
         }catch(Exception e){
             errString= "Error Mientras se conectaba a la Base de Datos";
             System.out.println(errString);
             return null;
         }
          return con;
     }

     /* Mostrar las propiedades del controlador y los detalles de la base de datos */

       public void Desconectar()
     {
         try{
              stmt.close();
              con.close();
         }catch(SQLException e){
             errString= "Error Mientras se Cerraba la Conexion a la Base de Datos";
         }
     }
       public Statement getStmt()
       {
          return this.stmt;
       }


}