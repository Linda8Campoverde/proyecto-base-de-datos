
package proyecto;

import javax.swing.table.DefaultTableModel;

public class controlador extends conexion  {
     public boolean InsertarProducto(String Nombres, int Id){
        Producto producto = new Producto (Nombres, Id);
        return this.Insertar(producto);
    }
   
    public DefaultTableModel producto(){
        String titulos[] = {"Id", "NOMBRES"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Producto producto = null;
        Producto[] p = this.Consultar(producto);
        if(p!= null){
            for (Producto per : p){
                Object[] cli = new Object[2];
                cli[0] = per.getId();
                cli[1] = per.getNombres();
                dtm.addRow(cli);        
            }
        }
        return dtm;        
    }
    public boolean EliminarProducto(int Id ){
        if(Id>0){
            Producto producto = new Producto(null,Id);
            return this.Eliminar(producto);
        }else{
            return false;
        }
    }
    
}
