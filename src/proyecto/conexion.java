
package proyecto;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

public class conexion {

    private ObjectContainer oc;

    private void open() {
        this.oc = Db4o.openFile("database.yap");
    }

    public boolean Insertar(Producto objeto) {
        try {
            this.open();
            oc.set(objeto);
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("dboo.Controlador.InsertarProducto():" + e);
            return false;
        }

    }

    public Producto[] Consultar(Producto objeto) {
        try {
            Producto[] producto = null;
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            int i = 0;
            if (resultados.hasNext()) {
                producto = new Producto[resultados.size()];
                while (resultados.hasNext()) {
                    producto[i] = (Producto) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return producto;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("dboo.Controlador.InsertarProducto():" + e);
            return null;
        }
    }

    public boolean Eliminar(Producto objeto) {
        try {
            this.open();
            ObjectSet resultados = this.oc.get(objeto);
            if (resultados.size() > 0) {
                Producto producto = (Producto) resultados.next();
                this.oc.delete(producto);
                this.oc.close();
                return true;
            } else {
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("dboo.Controlador.InsertarProducto():" + e);
            return false;
        }
    }
}