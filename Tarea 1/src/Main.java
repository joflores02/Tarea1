import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Articulo chocolate = new Articulo(700,"Chocolate", "Relleno", 1000);
        Articulo galleta = new Articulo(200,"Galleta", "Sabor vainilla", 250);
        Articulo helado = new Articulo(120,"Helado", "Sabor Limón", 500);
        Articulo pan = new Articulo(1000, "Pan", "amasado", 1800);
        Articulo jugo = new Articulo(500, "Jugo", "piña", 800);
        Cliente clienteUno = new Cliente("Pepito", "20.579.357-5", new Direccion("Calle 3"));
        Cliente clienteDos = new Cliente("Juan", "22.863.767-5", new Direccion("Calle 9"));
        DetalleCompra dc = new DetalleCompra(chocolate, 3);
        OrdenCompra ordenUno = new OrdenCompra(clienteUno);
        DocTributario docTributario = new DocTributario("54767", clienteUno);

    }
}

class OrdenCompra{
    private Cliente cliente;
    private DocTributario documento;
    private ArrayList <DetalleCompra> detalle;
    private Pago pago;
    private Date fecha;
    private String estado;
    public OrdenCompra(Cliente a){
        this.cliente = a;
        fecha = new Date();
        detalle = new ArrayList<DetalleCompra>();
    }

    public void añadirArticulos(Articulo articulo, int cantidad){
        detalle.add(new DetalleCompra(articulo, cantidad));
    }

    public void TotalPagos(Pago pago){

    }

}

class DetalleCompra{

    private int cantidad;
    private Articulo articulo;
    private float precio;

    public DetalleCompra(Articulo b, int c){
        this.cantidad = c;
        this.articulo = b;
        precio = articulo.getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad() {
    }

    public float calcPrecio(){
        return calcPrecioSinIVA() + calcPrecioIVA();
    }

    public float calcPrecioSinIVA() {
        return (float) (precio / 1.19) * cantidad;
    }
    public float calcPrecioIVA() {
        return (float) ((calcPrecioSinIVA() * 0.19)) ;
    }
}

class Articulo{
    private float peso, precio;
    private String nombre, descripcion;

    public Articulo(float peso, String nombre, String descripcion, float precio){
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return "Nombre: " + nombre + " Precio: " + precio + " Descripcion: " + descripcion + " Peso: " + peso;
    }
}

class Cliente{
    private String nombre, rut;
    public Direccion direccion;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut = rut;
    }

    public Cliente(String nombre, String rut, Direccion direccion){
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Rut: " + rut + " Direccion: " + direccion;
    }
}

class Direccion{
    private String direccion;
    public Direccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString(){
        return direccion;
    }
}

abstract class Pago{
    private float monto;
    private Date fecha;
    private OrdenCompra orden;

    public Pago(float monto, Date fecha, OrdenCompra orden){
        this.monto = monto;
        this.fecha = fecha;
        this.orden = orden;
    }

    public float getMonto(){
        return monto;
    }
    public void setMonto(float monto){
        this.monto = monto;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public OrdenCompra getOrden(){
        return orden;
    }
    public void setOrden(OrdenCompra orden){
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Monto" + monto + " Fecha: " + fecha;
    }
}

class Efectivo extends Pago{
    public Efectivo(float monto, Date fecha, OrdenCompra orden) {
        super(monto, fecha, orden);
    }
}

class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(float monto, Date fecha, OrdenCompra orden, String numCuenta, String Banco){
        super(monto, fecha, orden);
        this.numCuenta = numCuenta;
        this.banco = Banco;
    }
    public String getBanco(){
        return banco;
    }
    public void setBanco(String Banco){
        this.banco = Banco;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta){
        this.numCuenta = numCuenta;
    }
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(float monto, Date fecha, OrdenCompra orden, String tipo, String numTransaccion) {
        super(monto, fecha, orden);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }

}

class DocTributario{
    private String numero;
    private String rut;
    private Cliente cliente;

    public DocTributario(String numero,Cliente cliente){
        this.cliente = cliente;
        this.rut = cliente.getRut();
    }
}

class Boleta extends DocTributario{
    public Boleta(String numero, Cliente cliente) {
        super(numero, cliente);
    }
}
class Factura extends DocTributario{

    public Factura(String numero, Cliente cliente) {
        super(numero, cliente);
    }
}
