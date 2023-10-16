/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.laboratorio1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import umg.edu.gt.DAO.ConsultasDAO;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DTO.DatosDTO;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_producto")
public class Productos implements Serializable {

    private String nombreProducto;
    private String descripcion;
    private String precio;
    private String cantidad;
    private int idp;
    private List<DatosDTO> lista;
    ConsultasDAO consulta = new ConsultasDAO();

    public Productos() {

    }

    public void EnviarProductos() {
        try {
            consulta.ingresarProductos(getNombreProducto(), getDescripcion(), getPrecio(), getCantidad());
        } catch (Exception ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostConstruct
    public void init() {
        ConexionDAO con = new ConexionDAO();
        try {

            lista = consulta.findAllProducto();
            System.out.println("la conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + getLista().size());
            System.out.println("La lista es: " + getLista().size());
        } catch (Exception ex) {
            System.out.println("Error de la conexion" + ex);
        }
    }
    
       public void ActualizarProductos() {
        try {
          //  consulta.actualizarDatos(getId(), getNombre(), getCorreo(), getDireccion(), getTelefono());
       //lista = consulta.findAllCliente();
        } catch (Exception ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //nos permite ir a la ventana de clientes
    public void VentanaProductoAC() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/AProducto.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the lista
     */
    public List<DatosDTO> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<DatosDTO> lista) {
        this.lista = lista;
    }

    /**
     * @return the idp
     */
    public int getIdp() {
        return idp;
    }

    /**
     * @param idp the idp to set
     */
    public void setIdp(int idp) {
        this.idp = idp;
    }
}
