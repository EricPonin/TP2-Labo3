package ar.edu.utn.frbb.tup.Pantallas;
import ar.edu.utn.frbb.tup.Utilidades.Banco;

import java.util.Scanner;

public class PantallaClientes {
        private int opcion;
        private Banco banco;

        public PantallaClientes(Banco banco) {
            this.banco = banco;
        }

        public void MostrarPantalla() {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("---------------------- GESTION DE CLIENTES ----------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("----------------------1. Agregar Cliente   ----------------------------");
            System.out.println("----------------------2. Listar Clientes   ----------------------------");
            System.out.println("----------------------3. Modificar Cliente ----------------------------");
            System.out.println("----------------------4. Eliminar Cliente  ----------------------------");
            System.out.println("----------------------0. Volver            ----------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("------------------------Ingrese una opcion: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    banco.agregarCliente();
                    break;
                case 2:
                    banco.ListarClientes();
                    break;
                case 3:
                    banco.ModificarCliente();
                    break;
                case 4:
                    banco.EliminarCliente();
                    break;
                case 0:
                    System.out.println("Volviendo al menú anterior.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
        
    }

}
