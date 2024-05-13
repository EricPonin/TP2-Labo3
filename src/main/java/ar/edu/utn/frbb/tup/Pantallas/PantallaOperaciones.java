package ar.edu.utn.frbb.tup.Pantallas;
import ar.edu.utn.frbb.tup.Utilidades.Banco;
import ar.edu.utn.frbb.tup.Utilidades.Cliente;

import java.util.Scanner;

public class PantallaOperaciones {
    private int opcion;
    private Banco banco;
    private Cliente cliente;

    public PantallaOperaciones(Banco banco, Cliente cliente) {
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
            System.out.println("----------------------  OPERACIONES  ----------------------------------");
            System.out.println("CLIENTE: " + cliente.getNombre() +" "+cliente.getApellido());
            System.out.println("----------------------1. Depositar ------------------------------------");
            System.out.println("----------------------2. Retirar --------------------------------------");
            System.out.println("----------------------3. Transferir -----------------------------------");
            System.out.println("----------------------4. Ver Movimientos ------------------------------");
            System.out.println("----------------------0. Volver ---------------------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("------------------------Ingrese una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cliente.DepositarEnCuenta();
                    break;
                case 2:
                    cliente.RetirarDeCuenta();
                    break;
                case 3:
                    cliente.TransferirDeCuenta(banco,cliente);
                    break;
                case 4:
                    cliente.verMovimientos();
                    break;
                case 0:
                    System.out.println("Volviendo al menu anterior");
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