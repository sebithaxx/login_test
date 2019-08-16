/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cepita;

/**
 *
 * @author Sebithaxx
 */
class respuesta {

    static void setAttribute(String error, String motivo_del_error) {
        // Vi esto en vox, no sé Java por lo que la sintaxis puede estar mal,
        // pero acá te dejo la posible solución a tu problema.
        // Podes quitar la variable "error" de esta función. Vi que la llamas en
        // "SrvCalidad.java", y siempre que lo haces pasas la variable error con
        // el valor "error" y es medio al pedo.
        // Podés quitar esa variable de esta función y dejar el print de la
        // siguiente manera:
        // System.out.print("error: %s", motivo_del_error);
        System.out.print("%s: %s", error, motivo_del_error);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
