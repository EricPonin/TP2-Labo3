package ar.edu.utn.frbb.tup.Utilidades;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cuenta {

    private int titular;
    private static int nroCuentas = 0;
    private int nroCuenta;
    private double saldo;
    private String TipoCuenta;
    private  LocalDate fecha;
    private  ArrayList <Registro> registros;

    public Cuenta(){
        this.nroCuenta = ++nroCuentas;
    }

    public Cuenta(int titular, double saldo, String TipoCuenta , LocalDate fecha) {
        this.titular = titular;
        this.nroCuenta = ++nroCuentas;
        this.saldo = saldo;
        this.TipoCuenta = TipoCuenta;
        this.fecha = fecha;
        this.registros = new ArrayList<>();
    }
   
    public void VerRegistros(){
        System.out.println("Fecha      " + "   Monto    " + "    Movimiento   " + "   CuentaOrigen   " + "   CuentaDestino");
        for (Registro registro : registros) {
            System.out.println(registro.getFecha() + "       " + registro.getMonto() + "       " + registro.getMovimiento() + "        " + registro.getCuentaOrigen() + "            " + registro.getCuentaDestino());
        }
    }

    public void RegistroTransferencia(double monto, int cuentaOrigen, int cuentaDestino) {
        LocalDateTime fecha = LocalDateTime.now();
        String movimiento = "Transferencia";
        Registro nuevRegistro = new Registro(monto, fecha, movimiento, cuentaOrigen, cuentaDestino);
        this.registros.add(nuevRegistro);

    }
    public void Depositar(double monto) {
        String movimiento = "Deposito";
        this.saldo += monto;
        Registro nuevRegistro = new Registro(monto, this.fecha, movimiento, this.nroCuenta);
        this.registros.add(nuevRegistro);
    }

    public void Retirar(double monto) {
        String movimiento = "Retiro";
            this.saldo -= monto;
            Registro nuevRegistro = new Registro(monto, this.fecha, movimiento, this.nroCuenta);
            this.registros.add(nuevRegistro);
        }

    public void VerCuenta(){
        System.out.println("-------------------------------------------");
        System.out.println("CUENTA      SALDO      TIPO      FECHA");
        System.out.println(this.nroCuenta + "           " + this.saldo + "       " + this.TipoCuenta + "       " + this.fecha);
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTipoCuenta() {
        return TipoCuenta;
    }
    public void setTipo(String TipoCuenta){
        this.TipoCuenta = TipoCuenta;
    }
    public int getTitular() {
        return titular;
    }
    public void setTitular(int titular) {
        this.titular = titular;
    }
    public int getNroCuenta() {
        return nroCuenta;
    }
    public void setNroCuenta(int nroCliente) {
        this.nroCuenta = nroCliente;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNroCuentas() {
        return nroCuentas;
    }

}
