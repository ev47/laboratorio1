/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_hectorflores;

import javax.swing.JOptionPane;

/**
 *
 * @author edgva
 */
public class PalindromaAir {
    Ticket[] asientos = new Ticket[30];
    boolean verificar = false;
    double price=0;
    double totalIncome;
    
    Ticket a = new Ticket("", 0);
    
    public int firstAvailable() {
        return firstAvailableHelper(0);
    }

    private int firstAvailableHelper(int index) {
        if (index >= asientos.length) {
            return -1;
        }
        if (asientos[index] == null) {
            return index;
        }
        return firstAvailableHelper(index + 1);
    }
    public int searchPassenger(String name){
        return searchPassengerhelp(name,0);
    }
    private int searchPassengerhelp(String name, int index) {
        if (index == asientos.length) {
            return -1;
        }
        if (asientos[index] != null && asientos[index].getNombre().equals(name)) {
            return index;
        }
        return searchPassengerhelp(name, index + 1);
    }

  public boolean isPalindromo(String name) {
        return isPalindromoHelper(0, name.length() - 1, name);
    }

   private boolean isPalindromoHelper(int index, int endIndex, String name) {
        if (index >= endIndex) {
            return true;
        }
        if (name.charAt(index) != name.charAt(endIndex)) {
            return false;
        }
        return isPalindromoHelper(index + 1, endIndex - 1, name);
    }

    private void printPassengers(int index) {
        if (index == asientos.length) {
            return;
        }
        if (asientos[index] != null) {
            a.setNombre(asientos[index].getNombre());
            a.setPrecio(asientos[index].getPrecio());
            a.print();
        }
        printPassengers(index + 1);
    }
    
    public void printPassengers(){
        printPassengers(0);
    }
    
    public double income(){
        return incomeHelp(0);
    }
    
   private double incomeHelp(int index) {
        if (index == asientos.length) {
            return 0;
        }
        if (asientos[index] != null) {
            return asientos[index].getPrecio() + incomeHelp(index + 1);
        }
        return incomeHelp(index + 1);
    }
     public void reset() {
        resetHelper(0);
    }

    private void resetHelper(int index) {
        if (index >= asientos.length) {
            return;
        }
        asientos[index] = null;
        resetHelper(index + 1);
    }
    public void sellTicket(String name) {        
        int seat = firstAvailable();
        if (seat != -1) {
            price = 800;
            if (isPalindromo(name)) {
                price *= 0.8;
                verificar = true;
            }
            
            a.setNombre(name);
            a.setPrecio(price);
            
            asientos[seat] = new Ticket(name, price);
            JOptionPane.showMessageDialog(null, "Se vendió el boleto a " + name + " por un total de " + price);
            System.out.println("Se vendió el boleto a " + name + " por un total de " + price);
        } else {
            JOptionPane.showMessageDialog(null, "No hay asientos disponibles");
            System.out.println("No hay asientos disponibles");
            verificar = false;
        }
    }

    public boolean cancelTicket(String name) {
        int seat = searchPassenger(name);
        if (seat != -1) {
            asientos[seat] = null;
            return true;
        }
        return false;
    }

    public void dispatch() {
        totalIncome = income();
        JOptionPane.showMessageDialog(null, "Se ha despachado el avion. Total de ingresos generados: " + totalIncome);
        System.out.println("Total de ingresos generados: " + totalIncome);
        reset();
    }
}
