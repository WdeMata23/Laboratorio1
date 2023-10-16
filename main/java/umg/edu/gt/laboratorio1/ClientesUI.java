/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.laboratorio1;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DAO.ConsultasDAO;
import umg.edu.gt.DTO.DatosDTO;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_cliente")
public class ClientesUI implements Serializable {

    private String mensaje;
    private String dato1;
    private String dato2;
    private String dato3;
    private boolean band;
    private List<DatosDTO> lista;
    private int Id;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    ConsultasDAO consulta = new ConsultasDAO();

    public void mensaje1() {
        mensaje = "HOla Mundo desde un metodo---->";
    }

    //agregar clientes a la base de datos
    public void AgregarClientes() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Correo: " + getCorreo());

        try {
            consulta.ingresarDatos(getNombre(), getCorreo(), getDireccion(), getTelefono());

        } catch (Exception ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //Actualizar clientes a la base de datos
    public void ActualizarClientes() {
        try {
            consulta.actualizarDatos(getId(), getNombre(), getCorreo(), getDireccion(), getTelefono());
       lista = consulta.findAllCliente();
        } catch (Exception ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostConstruct
    public void init() {
        ConexionDAO con = new ConexionDAO();

        try {

            lista = consulta.findAllCliente();
            System.out.println("la conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + lista.size());
            System.out.println("El nombre es: " + lista.get(0).getNombre());
            System.out.println("El correo es " + lista.get(0).getCorreo());

        } catch (Exception ex) {
            System.out.println("Error de la conexion" + ex);
        }

        this.mensaje1();

        try {
            //this.consumeWS();

        } catch (Exception ex) {
            System.out.println("Error al consumir el WS");
        }
    }

    public void setSelectedItems() {

    }

    //ventana de actualizar Cliente
    public void VentanaCliente() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Laboratorio1/Pages/Inicio/AClientes.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consumeWS() throws IOException, InterruptedException {
        String url = "https://pokeapi.co/api/v2/ability/1/";
        HttpClient client = HttpClient.newHttpClient();
        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).
                GET().build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println(response.body());
        // Crear una solicitud POST con parámetros
        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        // Enviar la solicitud y obtener la respuesta
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println(response.body());
        /*JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(response.body()).getAsJsonArray();
        
        // Ahora puedes trabajar con el objeto JSON de tipo array
        for (int i = 0; i < jsonArray.size(); i++) {
            String nombre = jsonArray.get(i).getAsJsonObject().get("nombre").getAsString();
            int edad = jsonArray.get(i).getAsJsonObject().get("edad").getAsInt();

           
            System.out.println("Elemento " + i + ":");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
        }*/
    }

    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the dato1
     */
    public String getDato1() {
        return dato1;
    }

    /**
     * @param dato1 the dato1 to set
     */
    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    /**
     * @return the dato2
     */
    public String getDato2() {
        return dato2;
    }

    /**
     * @param dato2 the dato2 to set
     */
    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    /**
     * @return the dato3
     */
    public String getDato3() {
        return dato3;
    }

    /**
     * @param dato3 the dato3 to set
     */
    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }

    /**
     * @return the band
     */
    public boolean isBand() {
        return band;
    }

    /**
     * @param band the band to set
     */
    public void setBand(boolean band) {
        this.band = band;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }
}
