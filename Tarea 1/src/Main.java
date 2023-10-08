import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Articulo chocolate = new Articulo(700,"Chocolate", "Relleno", 1000);
        Articulo galleta = new Articulo(200,"Galleta", "Sabor vainilla", 250);
        Articulo helado = new Articulo(120,"Helado", "Sabor Limón", 500);
        Articulo pan = new Articulo(1000, "Pan", "amasado", 1800);
        Articulo jugo = new Articulo(500, "Jugo", "piña", 800);

    }
}

class Articulo{
    private float peso, precio;
    private String nombre, descripcion;
    public Articulo(float peso, String nombre, String Descripcion, float precio){
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = Descripcion;
        this.precio = precio;

    }
}