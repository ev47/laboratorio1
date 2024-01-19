package lab1p2_hectorflores;

import javax.swing.JOptionPane;


public class Ticket {
    String nombre;
    double precio;

    public Ticket(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void print() {
        JOptionPane.showMessageDialog(null, "Nombre del pasajero: " + this.nombre + "\nPrecio de su ticket: " + this.precio);
        System.out.println(this.nombre + "\n" + this.precio);
    }
    
}
