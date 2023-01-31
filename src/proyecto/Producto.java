
package proyecto;

public class Producto {
    private String Nombres;
    private int Id ;

    public Producto(String Nombres, int Id) {
        this.Nombres = Nombres;
        this.Id = Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    @Override
    public String toString(){
        
        return "el nombre del producto es:"+Nombres;
        
    }
}