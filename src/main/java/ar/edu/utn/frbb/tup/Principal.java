package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.Pantallas.PantallaPrincipal;
import ar.edu.utn.frbb.tup.Utilidades.Banco;

public class Principal {
  
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        //Genero algunos clientes para probar
        banco.CargarClientes("Juan", "Perez", "Malvinas 123", "juan@hotmail.com", 10222333);
        banco.CargarClientes("Pedro", "Ramirez", "Chiclana 55", "pedro@gmail.com", 20333444);
        banco.CargarClientes("Jose", "Lopez", "Brown 245", "jose@yahoo.com", 30444555);
        banco.CargarClientes("Jorge", "Villalba", "Beruti 1325", "jorge@gmail.com", 40555666);
        banco.CargarClientes("Maria", "Savicci", "Saavedra 12", "maria@hotmail.com", 50666777);


        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.MostrarPantalla(banco);
        
        


    }
}
