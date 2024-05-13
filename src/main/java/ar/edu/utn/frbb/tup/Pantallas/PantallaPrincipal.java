package ar.edu.utn.frbb.tup.Pantallas;
import ar.edu.utn.frbb.tup.Utilidades.Banco;
import ar.edu.utn.frbb.tup.Utilidades.Cliente;

import java.util.Scanner;
public class PantallaPrincipal {
        private int opcion;
        private Cliente cliente;
    
        public void MostrarPantalla(Banco banco) {
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("----------------------       BANCO         ----------------------------");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("----------------------1. CLIENTES          ----------------------------");
                System.out.println("----------------------2. CUENTAS           ----------------------------");
                System.out.println("----------------------3. MOVIMIENTOS       ----------------------------");
                System.out.println("----------------------0. SALIR DEL PROGRMA ----------------------------");
                System.out.println("-----------------------------------------------------------------------");
                System.out.print("------------------------Ingrese una opcion: ");
    
                opcion = sc.nextInt();
    
                switch (opcion) {
                    case 1:
                        PantallaClientes pantallaClientes = new PantallaClientes(banco);
                        pantallaClientes.MostrarPantalla();
                        break;
                    case 2:
                        PantallaCuentas pantallaCuentas = new PantallaCuentas(banco, cliente);
                        pantallaCuentas.MostrarPantalla();                        
                        break;
                    case 3:
                        PantallaOperaciones pantallaOperaciones = new PantallaOperaciones(banco, cliente);
                        pantallaOperaciones.MostrarPantalla();
                        break;
                    case 0:
                        System.out.println("Saliendo del Programa..");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
    
            }while (opcion!= 0);
            sc.close();
    
        }
    }

