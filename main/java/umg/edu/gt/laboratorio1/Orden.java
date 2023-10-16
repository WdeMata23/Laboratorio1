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
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DAO.ConsultasDAO;
import umg.edu.gt.DTO.DatosDTO;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilmer de Mata
 */

@ManagedBean (name = "bkn_orden")
public class Orden implements Serializable{

       private String Cliente;
    private String total;
private List<DatosDTO> lista;

    ConsultasDAO consulta = new ConsultasDAO();
    
       public void EnviarOrden(){
        System.out.println("cliente: " + getCliente());
        System.out.println("total: " + getTotal());
    try {
      consulta.ingresarOrden(getCliente(), getTotal());
    } catch (Exception ex) {
        Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
       
    @PostConstruct
    public void init() {
        ConexionDAO con = new ConexionDAO();
        try {

            setLista(consulta.findAllOrden());
            System.out.println("la conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + getLista().size());
            System.out.println("La lista es: " + getLista().size());
        } catch (Exception ex) {
            System.out.println("Error de la conexion" + ex);
        }

    }
    
    
    
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getCliente() {
        return Cliente;
    }

    public String getTotal() {
        return total;
    }
        public void setTotal(String total) {
        this.total = total;
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
