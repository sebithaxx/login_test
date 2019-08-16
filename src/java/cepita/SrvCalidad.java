package cepita;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import AccesoDatos.AccesoCalidad;
import LuchitoTeExtraño.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.annotation.WebServlet;

 @WebServlet(urlPatterns = {"/SrvCalidad"})
public class SrvCalidad extends HttpServlet {
  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        

    } 

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String jaque=request.getParameter("user");  
            String mate=request.getParameter("pass");  
            String correo=request.getParameter("email"); 
            String molina;
             Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher m = p.matcher(correo);
        Validador v = new Validador();
        Dao d = new Dao();
        /* Start with validations
        
          * We can do a lot of validations, for example:
          * Non-empty fields, valid email address, username and password
          * no spaces and / or special characters.
          *
        
        empty fields*/
         if(jaque.isEmpty() || correo.isEmpty() || mate.isEmpty()){
            respuesta.setAttribute("error", "Hay campos vacios");
            } else {
            //There are no empty fields, I see the email address is valid
            if(m.find()){
                respuesta.setAttribute("error", "La direccion de email no es correcta");
                } else {
                //The email address if correct, I verify that the password is also correct
                if(v.isUsernameOrPasswordValid(mate)){
                    
                   
                    try {
                        if(d.isEmailRegistered(jaque)){
                            respuesta.setAttribute("error", "Esta direccion de correo ya fue registrada");
                            
                            
                            
                        } else {
                            
                            //Legacy at this point means that everything is correct, therefore I enter the DB
                            d.registerUser(correo, mate, jaque);
                            respuesta.setAttribute("error", null);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(SrvCalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                    try {
                        d.desconectar();
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(SrvCalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                             
                     //   } catch (Exception e) { out.println("Ocurrio la sig exception: " +e); }
                        
                        
                        
                 
                    
                    } else {
                    respuesta.setAttribute("error", "Contraseña no es válida");
                   
                }
            molina = " <link rel=\"stylesheet\" type=\"text/css\" href=\"http://romsdrive.ml/files/cpita.css\">";
            out.println("<!DOCTYPE html>");
         try {
            ResultSet res;
            AccesoCalidad calidad = new AccesoCalidad();
            int calcodigo = 0;
            String calnombre = "";
            out.println("<html>");
            out.println("<head>");
            out.println(molina);
            out.println("<title>Hola " +jaque+"</title>");
            out.println(" <link href=Estilo.css rel=stylesheet type=text/css>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Su Clave es: " +mate+"<br> y su correo es: "+correo+"</h1>");
            //out.println("<table align=center width=289 border=1 class=datos_form>");
            //out.println("<tr class=titulo_tabla><td colspan=2>LISTADO DE CALIDADES </td></tr> ");
            //out.println("<tr><td>Codigo</td><td>Calidad</td></tr>");
            res = calidad.Listado();
            if ((request.getParameter("CALCODIGO")=="")&&(request.getParameter("CALNOMBRE")!=""))
                res=calidad.BuscarPorNombre(request.getParameter("CALNOMBRE"));
            if ((request.getParameter("CALCODIGO")!="")&&(request.getParameter("CALNOMBRE")==""))
                res=calidad.BuscarExistente(Integer.parseInt(request.getParameter("CALCODIGO")));
            if ((request.getParameter("CALCODIGO")=="")&&(request.getParameter("CALNOMBRE")==""))
                  res = calidad.Listado();

            while (res.next()) {
                calcodigo = res.getInt("CALCODIGO");
                calnombre = res.getString("CALNOMBRE");
               // out.println("<tr><td>" + calcodigo + "</td><td>" + calnombre + "</td></tr>");
            }
          //  out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(SrvCalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
 }
 }

  
