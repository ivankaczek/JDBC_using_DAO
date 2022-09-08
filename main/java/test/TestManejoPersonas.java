package test;

import datos.PersonaDAO;
import dominio.*;
import java.util.*;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO persDAO = new PersonaDAO();
        List<Persona> personas = persDAO.seleccionar();
        
        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
        
        // Insertando un nuevo objeto en la base de datos
        Persona persParaInsertar = new Persona("Albertillo", "Mermandez", "amermandez@presimail.com", "549222222");
        //persDAO.insertar(persParaInsertar);
        
        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
        
    }



    
}
