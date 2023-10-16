/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.laboratorio1;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_Inicio")
@RequestScoped
public class InicioUI implements Serializable {

    //nos permite ir a la ventana de clientes
    public void VentanaCliente() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/ClientesUI.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      //nos permite ir a la ventana de clientes
    public void VentanaClienteActualizar() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/AClientes.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana de producto
    public void VentanaProducto() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/ProductosUI.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana de ordenes
    public void VentanaOrden() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/OrdenesUI.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana de detalle de Ordenes
    public void VentanaDetalleOrdenes() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/DetalleOrdenUI.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana principal
    public void VentanaPrincipal() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/InicioUI.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
