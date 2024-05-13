package ar.edu.utn.frbb.tup.Utilidades;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;


    public Banco(){
        this.clientes = new ArrayList<>();
    }
  
    public void CargarClientes(String nombre, String apellido, String direccion, String email, int dni) {
        Cliente nuevoCliente = new Cliente(nombre, apellido, direccion, email, dni);
        this.clientes.add(nuevoCliente);

    }

    public void Transferencia(int dniOrigen, double monto, int NroCta){
        for(Cliente clienteOrigen : clientes){
            if(clienteOrigen.getDni() == dniOrigen){
                for(Cuenta cuentaOrigen : clienteOrigen.getCuentas()){
                    if(cuentaOrigen.getNroCuenta() == NroCta){
                        if(cuentaOrigen.getSaldo() >= monto){

                        int dniDestino = Validaciones.IngresoEntero("Ingrese DNI del cliente a transferir: ");
                        for(Cliente clienteDestino : clientes){
                            if(clienteDestino.getDni() == dniDestino){
                                for(Cuenta cuentaDestino : clienteDestino.getCuentas()){
                                    cuentaDestino.VerCuenta();
                                    int SelectCta = Validaciones.IngresoEntero("Ingrese Nro de cuenta del destinatario: ");
                                    if(cuentaDestino.getNroCuenta() == SelectCta ){
                                            cuentaOrigen.Retirar(monto);
                                            cuentaOrigen.RegistroTransferencia(monto, cuentaOrigen.getNroCuenta(), cuentaDestino.getNroCuenta());
                                            cuentaDestino.Depositar(monto);
                                            cuentaDestino.RegistroTransferencia(monto, cuentaDestino.getNroCuenta(), cuentaOrigen.getNroCuenta());
                                            System.out.println("Transferencia de $" + monto + " realizada con exito");
                                    }
                                }
                            }
                        }
                        }else{
                        System.out.println("No hay suficiente saldo en la cuenta");
                        }
                    }
                }
            }
                
        }
    }

    public boolean agregarCliente() {
        int dni = Validaciones.IngresoEntero("Ingrese DNI del nuevo cliente: ");
        // Verificar si el cliente ya existe
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                System.out.println("El cliente ya existe");
                return false;
            }
        }
        // Si el cliente no existe, ingresar los datos y agregarlo a la lista de clientes
        Cliente nuevoCliente = new Cliente();
        clientes.add(nuevoCliente.IngresarNuevoCliente(nuevoCliente,dni));
        System.out.println("Cliente agregado");
        return true;
    }
    
    
    public void ListarClientes(){
        for (Cliente cliente : clientes) {
            cliente.MostrarCliente();
        }
    }
    
    public Cliente BuscarCliente(Cliente clienteBuscado) { 
        int DniBuscado = Validaciones.IngresoEntero("Ingrese DNI del cliente: ");
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == DniBuscado) {
                cliente.MostrarCliente();
                return cliente;
            }
        }
        System.out.println("El cliente no existe");
        return null; // Devuelve null si el cliente no es encontrado
    }
    

    public boolean ModificarCliente(){
        int  DniBuscado = Validaciones.IngresoEntero("Ingrese DNI del cliente a modificar: ");
            for (Cliente cliente : clientes) {
                if (cliente.getDni()== DniBuscado) {
                    //Logica para cargar los nuevos datos del cliente   
                    cliente.ModificarCliente(DniBuscado);                   
                    System.out.println("Cliente modificado exitosamente.");
                    return true;
                }
            }
            System.out.println("El cliente no existe");
            return false;
        }

    public void EliminarCliente(){
        int  DniBuscado = Validaciones.IngresoEntero("Ingrese DNI del cliente a eliminar: ");
            for (Cliente cliente : clientes) {
                if (cliente.getDni()== DniBuscado) {
                    cliente.MostrarCliente();
                    if(Validaciones.IngresoOpcion("Elimina? (S/N)")){
                        clientes.remove(cliente);
                        System.out.println("Cliente eliminado exitosamente.");
                        return;
                    }
                    else{
                        System.out.println("Cliente no eliminado.");
                        return;
                    }
                }
            }
    }


  

}
