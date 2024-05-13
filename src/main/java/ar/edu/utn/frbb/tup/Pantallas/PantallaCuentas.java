package ar.edu.utn.frbb.tup.Pantallas;
import ar.edu.utn.frbb.tup.Utilidades.Banco;
import ar.edu.utn.frbb.tup.Utilidades.Cliente;

import java.util.Scanner;

public class PantallaCuentas {
    private int opcion;
    private Banco banco;
    private Cliente cliente;

    public PantallaCuentas(Banco banco, Cliente cliente) {
        this.banco = banco;
        this.cliente = cliente;
    }

    public void MostrarPantalla() {
        Scanner sc = new Scanner(System.in);
        boolean control = false;
        Cliente clienteBuscado = banco.BuscarCliente(cliente);
        if(clienteBuscado!= null){
                cliente = clienteBuscado;
                control = true;
        }
        if(control){
            do {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("----------------------     GESTION DE CUENTAS       -------------------");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("----------------------1. Agregar Cuenta al CLiente  ------------------");
                    System.out.println("----------------------2. Listar Cuentas del CLiente -------------------");
                    System.out.println("----------------------3. Buscar una Cuenta          -------------------");
                    System.out.println("----------------------4. Modificar una Cuenta       -------------------");
                    System.out.println("----------------------5. Eliminar una Cuenta        -------------------");
                    System.out.println("----------------------0. Volver                     -------------------");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.print("------------------------Ingrese una opcion: ");
            
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        cliente.agregarCuenta(cliente.getDni());                    
                        break;
                    case 2:
                        cliente.listarCuentas();
                        break;
                    case 3:
                        cliente.buscarCuenta();
                        break;
                    case 4:
                        cliente.modificarCuenta();
                        break;
                    case 5:
                        cliente.eliminarCuenta();
                        break;
                    case 0:
                        System.out.println("Volviendo al menu principal..");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            }while (opcion!= 0);
        }else{
            System.out.println("Cliente no encontrado");
        }

    }
}