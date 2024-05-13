package ar.edu.utn.frbb.tup.Utilidades;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validaciones {
    
        public static double IngresoDouble(String cartel) {
            double ingreso = 0;
            boolean control = false;
            
            do {
                try {
                    System.out.print(cartel);
                    ingreso = Double.parseDouble(System.console().readLine());
                    control = true;
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println("Error, ingrese un número válido.");
                }
            } while (!control);
            
            return ingreso;
        }

        public static int IngresoEntero(String cartel) {
            int ingreso = 0;
            boolean control = false;
            
            do {
                try {
                    System.out.print(cartel);
                    ingreso = Integer.parseInt(System.console().readLine());
                    control = true;
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println("Error, ingrese un número válido.");
                }
            } while (!control);
            
            return ingreso;
        }
    

    public static String IngresoTipoCuenta(){
        Scanner sc = new Scanner(System.in);
        boolean control = false;
        String Ingreso = "";
        do{
            System.out.print("Ingrese Tipo de Cuenta(CC - CA): ");
            Ingreso = sc.nextLine();
            if(Ingreso.equals("CC") || Ingreso.equals("cc") || Ingreso.equals("Cc") || Ingreso.equals("cC")
            || Ingreso.equals("CA")|| Ingreso.equals("ca")|| Ingreso.equals("Ca")|| Ingreso.equals("cA")){
                control = true;
            }else{
                System.out.println("Error, ingrese una opcion valida(CC - CA)");
            }
        }while(!control);
        return Ingreso;
    }

   public static LocalDate IngresoFecha(String cartel) {
        Scanner sc = new Scanner(System.in);
        LocalDate fecha = null; 
        boolean control = false;
        do {
            System.out.print(cartel);
            String ingreso = sc.nextLine();
            try {
                fecha = LocalDate.parse(ingreso);
                control = true; 
            } catch (DateTimeParseException e) {
                System.out.println("Error, ingrese una fecha válida en formato yyyy-MM-dd");
            }
        } while (!control); 
     
        return fecha;
    }

    public static boolean IngresoOpcion(String cartel){
        Scanner sc = new Scanner(System.in);
        boolean control = false;
        boolean afirmativo = false;
        do{
            System.out.print(cartel);
            String Ingreso = sc.nextLine();
            if(Ingreso.equals("S") || Ingreso.equals("s")){
                afirmativo = true;
                control = true;
            }else if(Ingreso.equals("n") || Ingreso.equals("N")){
                control = true;
            }else{
                System.out.println("Error, ingrese una opcion valida(S - N)");
            }
        }while(!control);
        return afirmativo;
        }


    public static String IngresoNombres(String cartel){
        Scanner sc = new Scanner(System.in);
        boolean control = false;
        String Ingreso = "";
        do{
            System.out.print("Ingrese " + cartel + ": ");
            Ingreso = sc.nextLine();
            if(Ingreso.matches("[a-zA-Z]+")){
                control = true;
            }else{
                System.out.println("Error, ingrese un " + cartel + " valido");
            }
        }while(!control);
      
        return Ingreso;
    }

    public static String IngresoEmail(String cartel) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(cartel);
                String ingreso = sc.nextLine();
                if (ingreso.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                    return ingreso;
                } else {
                    System.out.println("Error: El formato del correo electrónico no es válido.");
                }
            }
        }
    }

    public static String IngresoDireccion() {
        Scanner sc = new Scanner(System.in);
        boolean control = false;
        String ingreso = "";
        
        do {
            System.out.print("Ingrese Dirección: ");
            ingreso = sc.nextLine();
            if (ingreso.matches("^[a-zA-Z0-9\\s]*$")) {
                control = true;
            } else {
                System.out.println("Error, ingrese una dirección válida (por ejemplo: Calle Falsa 123)");
            }
            
        } while (!control);
      
        return ingreso;
    }
        

}
