/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuchitoTeExtraño;
public class DaoUser2 extends Dao{
    public String userName;
    public String email;
 
    
    public DaoUser2(String email){
        Dao d = new Dao();
        try {
            d.conectar();
            
            setUserName(d.getNameByEmail(email));
            
            d.desconectar();
        } catch (Exception e) {}
    }
    
    public String getUserName() {
        return userName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}