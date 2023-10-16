/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import umg.edu.gt.DTO.DatosDTO;

/**
 *
 * @author Wilmer de Mata
 */
public class ConsultasDAO {

    ConexionDAO con = new ConexionDAO();
    
     //metodo para actualizar datos a bd
   public void actualizarDatos(int id, String nombre, String correo, String direccion, String telefono) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        StringBuilder consultaSQL = new StringBuilder("UPDATE clientes SET ");
        if (conexion != null) {
            try {
                // Verifica y agrega campos a la consulta SQL si se proporciona un valor no nulo o no vacío
                if (nombre != null && !nombre.isEmpty()) {
                    consultaSQL.append("nombre = ?, ");
                }
                if (correo != null && !correo.isEmpty()) {
                    consultaSQL.append("correo = ?, ");
                }
                if (direccion != null && !direccion.isEmpty()) {
                    consultaSQL.append("direccion = ?, ");
                }
                if (telefono != null && !telefono.isEmpty()) {
                    consultaSQL.append("telefono = ?, ");
                }

                // Elimina la coma final y agrega la condición WHERE
                consultaSQL.delete(consultaSQL.length() - 2, consultaSQL.length()).append(" WHERE id = ?");
                preparedStatement = conexion.prepareStatement(consultaSQL.toString());
                int parametroIndex = 1;

                // Establece los parámetros en la consulta SQL según los valores no nulos o no vacíos proporcionados
                if (nombre != null && !nombre.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, nombre);
                }
                if (correo != null && !correo.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, correo);
                }
                if (direccion != null && !direccion.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, direccion);
                }
                if (telefono != null && !telefono.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, telefono);
                }

                preparedStatement.setInt(parametroIndex, id);
                preparedStatement.executeUpdate();
                System.out.println("Datos actualizados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
       
    //metodo para consultar datos de la base de datos
    public List<DatosDTO> findAllCliente() {
        List<DatosDTO> Lista = new ArrayList<DatosDTO>();

        try {
            String query = "SELECT id, nombre, correo, direccion, telefono FROM clientes";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setId(r.getLong("id"));
                dato.setNombre(r.getString("nombre"));
                dato.setDireccion(r.getString("direccion"));
                dato.setCorreo(r.getString("correo"));
                dato.setTelefono(r.getString("telefono"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + Lista.size());
        //System.out.println("nombre lista );
        return Lista;

    }
    
    //mandar a llamar los productos
    public List<DatosDTO> findAllProducto() {
        List<DatosDTO> ListaProducto = new ArrayList<DatosDTO>();

        try {
            String query = "SELECT id, nombre, descripcion, precio, cantidad FROM productos";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setIdProducto(r.getLong("id"));
                dato.setNombreProducto(r.getString("nombre"));
                dato.setDescripcionProducto(r.getString("descripcion"));
                dato.setPrecio(r.getString("precio"));
                dato.setCantidad(r.getString("cantidad"));
                ListaProducto.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + ListaProducto.size());
        //System.out.println("nombre lista );
        return ListaProducto;
    }
    
        //mandar a llamar los ordenes
    public List<DatosDTO> findAllOrden() {
        List<DatosDTO> ListaOrden = new ArrayList<DatosDTO>();

        try {
            String query = "SELECT id, cliente_id, fecha, total FROM ordenes";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setIdOrden(r.getLong("id"));
                dato.setClienteId(r.getString("cliente_id"));
                dato.setFecha(r.getString("fecha"));
                dato.setTotal(r.getString("total"));
                ListaOrden.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + ListaOrden.size());
        //System.out.println("nombre lista );
        return ListaOrden;

    }
    
      //mandar a llamar los detalle Ordenes
    public List<DatosDTO> findAllDetalleOrden() {
        List<DatosDTO> ListaDetalleOrden = new ArrayList<DatosDTO>();

        try {
            String query = "SELECT id, orden_id, producto_id, cantidad, precio FROM detalles_ordenes";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setIdOrdenDetalle(r.getLong("id"));
                dato.setOrdenID(r.getString("orden_id"));
                dato.setProductoId(r.getString("producto_id"));
                dato.setCantidadDetalle(r.getString("cantidad"));
                dato.setPrecioDetalle(r.getString("precio"));
                ListaDetalleOrden.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + ListaDetalleOrden.size());
        //System.out.println("nombre lista );
        return ListaDetalleOrden;

    }

    //metodo para enviar clientes a la BD
    public void ingresarDatos(String nombre, String correo, String direccion, String telefono) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO clientes (nombre, correo, direccion, telefono) VALUES (?, ?, ?, ?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                //PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                //preparedStatement.setString(1, "");
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, correo);
                preparedStatement.setString(3, direccion);
                preparedStatement.setString(4, telefono);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
    
    public void actualizarProductoss(int id, String nombre, String descripcion, String precio, String cantidad) throws Exception {
    Connection conexion = con.conexionMysql();
    PreparedStatement preparedStatement = null;
    String consultaSQL = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, cantidad = ? WHERE id = ?";
    if (conexion != null) {
        try {
            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, descripcion);
            preparedStatement.setString(3, precio);
            preparedStatement.setString(4, cantidad);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            System.out.println("Datos actualizados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        System.out.println("No se pudo establecer la conexión.");
    }
}
  //metodo para actualizar datos a bd
   public void actualizarProductos(int id, String nombre, String descripcion, String precio, String cantidad) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        StringBuilder consultaSQL = new StringBuilder("UPDATE productos SET ");
        if (conexion != null) {
            try {
                // Verifica y agrega campos a la consulta SQL si se proporciona un valor no nulo o no vacío
                if (nombre != null && !nombre.isEmpty()) {
                    consultaSQL.append("nombre = ?, ");
                }
                if (descripcion != null && !descripcion.isEmpty()) {
                    consultaSQL.append("descripcion = ?, ");
                }
                if (precio != null && !precio.isEmpty()) {
                    consultaSQL.append("precio = ?, ");
                }
                if (cantidad != null && !cantidad.isEmpty()) {
                    consultaSQL.append("cantidad = ?, ");
                }

                // Elimina la coma final y agrega la condición WHERE
                consultaSQL.delete(consultaSQL.length() - 2, consultaSQL.length()).append(" WHERE id = ?");
                preparedStatement = conexion.prepareStatement(consultaSQL.toString());
                int parametroIndex = 1;

                // Establece los parámetros en la consulta SQL según los valores no nulos o no vacíos proporcionados
                if (nombre != null && !nombre.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, nombre);
                }
                if (descripcion != null && !descripcion.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, descripcion);
                }
                if (precio != null && !precio.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, precio);
                }
                if (cantidad != null && !cantidad.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, cantidad);
                }

                preparedStatement.setInt(parametroIndex, id);
                preparedStatement.executeUpdate();
                System.out.println("Datos actualizados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
    //metodo para enviar productos a la BD
    public void ingresarProductos(String nombreProducto, String descripcion, String precio, String cantidad) throws Exception {

        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO productos (nombre, descripcion, precio, cantidad) VALUES (?, ?, ?, ?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                //PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                //preparedStatement.setString(1, "");
                preparedStatement.setString(1, nombreProducto);
                preparedStatement.setString(2, descripcion);
                preparedStatement.setString(3, precio);
                preparedStatement.setString(4, cantidad);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }

    //metodo para enviar ordenes a la BD
    public void ingresarOrden(String ClienteId, String total) throws Exception {

        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO ordenes (cliente_id, total) VALUES (?, ?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                //PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                //preparedStatement.setString(1, "");
                preparedStatement.setString(1, ClienteId);
                preparedStatement.setString(2, total);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }

    //metodo para enviar detalle de ordenes a la BD
    public void ingresarDetalleOrden(String OrdenID, String ProductoId, String cantidad, String precio) throws Exception {

        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO detalles_ordenes (orden_id , 	producto_id, cantidad, precio) VALUES (?, ?, ?, ?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                //PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                //preparedStatement.setString(1, "");
                preparedStatement.setString(1, OrdenID);
                preparedStatement.setString(2, ProductoId);
                preparedStatement.setString(3, cantidad);
                preparedStatement.setString(4, precio);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
