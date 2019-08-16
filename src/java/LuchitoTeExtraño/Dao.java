/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuchitoTeExtraño;

import java.sql.*;
 
public class Dao {
    public Connection conexion;
    public final static String userDb = "root";
    public final static String passDb = "123456";
    
    
    //Connect to the Database
    public void conectar() throws SQLException,ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
         conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb1",userDb, passDb);
    }
    //Disconnect to the Database
    public void desconectar() throws SQLException, ClassNotFoundException{
        conexion.close();
    }
    
    //Method to check if an email and password belong to a registered account
    public boolean isAcountExists(String email, String password) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE email='"+email+"' AND password='"+password+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }
    
    //Method to check if the email received is already registered
    public boolean isEmailRegistered(String email) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE email='"+email+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
 
        return rs.next();
    }
    
    //Method to register an account
    public void registerUser(String email, String password, String name) throws SQLException{
        String sql = "INSERT INTO `usuarios`(`email`,`password`,`name`) VALUES ('"+email+"','"+password+"','"+name+"')";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }

    String getNameByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}