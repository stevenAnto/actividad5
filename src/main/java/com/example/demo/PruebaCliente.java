package com.example.demo;
import com.example.demo.servidor.CalculatorService;

import java.rmi.Naming;
import java.util.Scanner;


public class PruebaCliente {
    // Crear una instancia de CalculatorServiceClient
    public static void main(String[] args) {
// Configurar la aplicación Spring
        try {
            // Llamar a los métodos add y subtract para probar
            CalculatorService cliente  = (CalculatorService) Naming.lookup("rmi://localhost/CalculatorService");
            Scanner entrada = new Scanner(System.in);
            while(true){
                System.out.println("ingrese el primer valor");
                int a = entrada.nextInt();
                System.out.println("Ingrese el segundo valor");
                int b = entrada.nextInt();
                int resultAdd = cliente.add(a, b);
                int resultSubtract = cliente.subtract(a, b);
                System.out.println("Result of add operation: " + resultAdd);
                System.out.println("Result of subtract operation: " + resultSubtract);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
