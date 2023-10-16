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
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DTO.DatosDTO;

/**
 *
 * @author Wilmer de Mata
 */

@ManagedBean(name = "bkn_DetalleORden")
public class DetalleOrden implements Serializable {

    private String OrdenID;
    private String ProductoID;
    private String cantidad;
    private String precio;
    private List<DatosDTO> lista;
    ConsultasDAO consulta = new ConsultasDAO();

    public void EnviarDetalleORden() {
        System.out.println("ordenID: " + getOrdenID());
        System.out.println("ProductoID: " + getProductoID());

        try {
            consulta.ingresarDetalleOrden(getOrdenID(), getProductoID(), getCantidad(), getPrecio());
        } catch (Exception ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PostConstruct
    public void init() {
        ConexionDAO con = new ConexionDAO();

        try {
            setLista(consulta.findAllDetalleOrden());
            System.out.println("la conexion es: " + con.conexionMysql());
        } catch (Exception ex) {
            System.out.println("Error de la conexion" + ex);
        }

    }

    public String getOrdenID() {
        return OrdenID;
    }

    public void setOrdenID(String OrdenID) {
        this.OrdenID = OrdenID;
    }

    public String getProductoID() {
        return ProductoID;
    }

    public void setProductoID(String ProductoID) {
        this.ProductoID = ProductoID;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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
}
