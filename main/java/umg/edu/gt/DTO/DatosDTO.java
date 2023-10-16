/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

/**
 *
 * @author Wilmer de Mata
 */
public class DatosDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String direccion;   
    private String telefono;
    private Long idProducto;
    private String nombreProducto;
    private String DescripcionProducto;
    private String Precio;   
    private String Cantidad;
    private Long idOrden;
    private String ClienteId;
    private String fecha;
    private String total;   
    private Long idOrdenDetalle;
    private String OrdenID;
    private String ProductoId;
    private String cantidadDetalle;  
    private String precioDetalle;  
    
    /**
     * @return the cantidadDetalle
     */
    public String getCantidadDetalle() {
        return cantidadDetalle;
    }

    /**
     * @param cantidadDetalle the cantidadDetalle to set
     */
    public void setCantidadDetalle(String cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    /**
     * @return the precioDetalle
     */
    public String getPrecioDetalle() {
        return precioDetalle;
    }

    /**
     * @param precioDetalle the precioDetalle to set
     */
    public void setPrecioDetalle(String precioDetalle) {
        this.precioDetalle = precioDetalle;
    }

    
    /**
     * @return the idOrdenDetalle
     */
    public Long getIdOrdenDetalle() {
        return idOrdenDetalle;
    }

    /**
     * @param idOrdenDetalle the idOrdenDetalle to set
     */
    public void setIdOrdenDetalle(Long idOrdenDetalle) {
        this.idOrdenDetalle = idOrdenDetalle;
    }

    /**
     * @return the OrdenID
     */
    public String getOrdenID() {
        return OrdenID;
    }

    /**
     * @param OrdenID the OrdenID to set
     */
    public void setOrdenID(String OrdenID) {
        this.OrdenID = OrdenID;
    }

    /**
     * @return the ProductoId
     */
    public String getProductoId() {
        return ProductoId;
    }

    /**
     * @param ProductoId the ProductoId to set
     */
    public void setProductoId(String ProductoId) {
        this.ProductoId = ProductoId;
    }

    /**
     * @return the idOrden
     */
    public Long getIdOrden() {
        return idOrden;
    }

    /**
     * @param idOrden the idOrden to set
     */
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    /**
     * @return the ClienteId
     */
    public String getClienteId() {
        return ClienteId;
    }

    /**
     * @param ClienteId the ClienteId to set
     */
    public void setClienteId(String ClienteId) {
        this.ClienteId = ClienteId;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }
    /**
     * @return the idProducto
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
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
     * @return the DescripcionProducto
     */
    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    /**
     * @param DescripcionProducto the DescripcionProducto to set
     */
    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    /**
     * @return the Precio
     */
    public String getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the Cantidad
     */
    public String getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }
        

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
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
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
