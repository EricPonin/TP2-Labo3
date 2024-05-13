package ar.edu.utn.frbb.tup.Utilidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private int dni;
    private ArrayList <Cuenta> cuentas;


    public Cliente(){
        this.cuentas = new ArrayList<>();
    }
    public Cliente(String nombre, String apellido, String direccion, String email, int dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.dni = dni;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getDni(){
        return dni;
    }
    public void setDni(int dni){
        this.dni = dni;
    }
    public ArrayList<Cuenta> getCuentas(){
        return cuentas;
    }


    public void ModificarCliente(int dni){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingreso Nombre: ");
        String nombre = sc.nextLine();
        this.setNombre(nombre);
        System.out.print("Ingreso Apellido: ");
        String apellido = sc.nextLine();
        this.setApellido(apellido);
        System.out.print("Ingreso Direccion: ");
        String direccion = sc.nextLine();
        this.setDireccion(direccion);
        System.out.print("Ingreso Email: ");
        String email = sc.nextLine();
        this.setEmail(email);
        //completar con pregunta si modifica el dni
        this.setDni(dni);

    }

    public Cliente IngresarNuevoCliente(Cliente NuevoCliente,int dni){
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingreso Nombre: ");
        String nombre = sc.nextLine();
        NuevoCliente.setNombre(nombre);
        System.out.print("Ingreso Apellido: ");
        String apellido = sc.nextLine();
        NuevoCliente.setApellido(apellido);
        System.out.print("Ingreso Direccion: ");
        String direccion = sc.nextLine();
        NuevoCliente.setDireccion(direccion);
        System.out.print("Ingreso Email: ");
        String email = sc.nextLine();
        NuevoCliente.setEmail(email);
        NuevoCliente.setDni(dni);

      return NuevoCliente;
    }

    public void DepositarEnCuenta(){
        boolean encontrado = false;
        VerCuentasCliente();
        int nroCuenta = Validaciones.IngresoEntero("Numero de cuenta a depositar: ");
        for(Cuenta cuenta: cuentas){
            if(cuenta.getNroCuenta() == nroCuenta){
                encontrado = true;
                double monto = Validaciones.IngresoDouble("Ingrese monto a depositar: ");
                cuenta.Depositar(monto);
                System.out.println("Deposito de $ " + monto + "  realizado con exito");
            } 
            if(!encontrado){
                System.out.println("Cuenta no encontrada");
            }
        }
    }

    public void RetirarDeCuenta(){
        boolean encontrado = false;
        VerCuentasCliente();
        int nroCuenta = Validaciones.IngresoEntero("Numero de cuenta a retirar: ");
        for(Cuenta cuenta: cuentas){
            if(cuenta.getNroCuenta() == nroCuenta){
                encontrado = true;
                double monto = Validaciones.IngresoDouble("Ingrese monto a retirar: ");
                if(cuenta.getSaldo() >= monto){
                    cuenta.Retirar(monto);
                    System.out.println("Retiro de $ " + monto + "  realizado con exito");
                }else{
                    System.out.println("Saldo insuficiente");
                }
            }
            if(!encontrado){
                System.out.println("Cuenta no encontrada");
            }
            
        }
    }

    public void MostrarCliente(){
        System.out.println("Cliente Encontrado: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("CLIENTE              DNI               DIRECCION            EMAIL");
        System.out.println(this.nombre + " " + this.apellido + "      " + this.dni + "          " + this.direccion + "          " + this.email);
    }

    public void TransferirDeCuenta(Banco banco, Cliente cliente){
        VerCuentasCliente();
        int nroCuenta = Validaciones.IngresoEntero("Numero de cuenta a depositar: ");
        double monto = Validaciones.IngresoDouble("Ingrese monto a transferir: ");
        banco.Transferencia(cliente.getDni(),monto,nroCuenta);
    }
   

    public void VerCuentasCliente(){  
        for(Cuenta cuenta: cuentas){
            cuenta.VerCuenta();
        }
    }

    public void verMovimientos(){
        int NroCuenta = Validaciones.IngresoEntero("Ingrese el numero de la cuenta para ver sus movimientos: ");
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNroCuenta() == NroCuenta) {
                cuenta.VerRegistros();
            }else{
                System.out.println("Cuenta no encontrada");
            }
        }
    }

    public void agregarCuenta(int dni) {
        System.out.println("Ingrese los datos de la cuenta del cliente: " + nombre + " " + apellido);
        double Saldo = Validaciones.IngresoDouble("Ingrese el saldo de la cuenta: ");
        String Tipo = Validaciones.IngresoTipoCuenta();
        LocalDate Fecha = Validaciones.IngresoFecha("Ingrese la fecha de apertura de la cuenta: ");
        Cuenta nuevaCuenta = new Cuenta(dni, Saldo, Tipo, Fecha);
        cuentas.add(nuevaCuenta);
    }
    

    public void listarCuentas(){
        System.out.println("-------------------------------------------");
        System.out.println("CLIENTE: " + nombre + " " + apellido);
        for (Cuenta cuenta : cuentas) {
            cuenta.VerCuenta();
        }
    }
    
    public void buscarCuenta(){
        int CtaBuscadoInt = Validaciones.IngresoEntero("Ingrese el numero de la cuenta a buscar: ");
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getNroCuenta() == CtaBuscadoInt){
                System.out.println("Cuenta encontrada");
                cuenta.VerCuenta();
            }else{
                System.out.println("Cuenta no encontrada");
            }
        }
    }


    public void modificarCuenta() {
        int CtaBuscadoInt = Validaciones.IngresoEntero("Ingrese el numero de la cuenta a modificar: ");
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getNroCuenta() == CtaBuscadoInt){
                System.out.print("Saldo actual:  " + cuenta.getSaldo());
                double saldo = Validaciones.IngresoDouble("Ingrese nuevo saldo: ");
                cuenta.setSaldo(saldo);
                String tipoCta = Validaciones.IngresoTipoCuenta();
                cuenta.setTipo(tipoCta);
                LocalDate fecha = Validaciones.IngresoFecha("Ingrese nueva fecha de apertura (aaaa/mm/dd): ");
                cuenta.setFecha(fecha);
                return;
            }
            else{
                System.out.println("La cuenta no existe");
                return;
            }
        }
    }

    public void eliminarCuenta() {
        int CtaBuscadoInt = Validaciones.IngresoEntero("Ingrese el numero de la cuenta a eliminar: ");
        for (Cuenta cuenta : cuentas) {
            if(cuenta.getNroCuenta() == CtaBuscadoInt){
                cuenta.VerCuenta();
                if(Validaciones.IngresoOpcion("Confirmaque desea eliminar la cuenta? (s/n)")){  
                    cuentas.remove(cuenta);
                    System.out.println("Cuenta eliminada");
                }else{
                    System.out.println("Operacion Cancelada");
                }
            }
        }
    } 

}
