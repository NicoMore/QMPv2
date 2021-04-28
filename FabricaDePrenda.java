import java.util.ArrayList;
import java.util.Scanner;

enum Categoria { Superior, Inferior, Calzado, Accesorio; }

class FabricaDePrenda {
    static ArrayList<String> tiposSuperiores = new ArrayList<>();
    static ArrayList<String> tiposInferiores = new ArrayList<>();
    static ArrayList<String> tiposCalzados = new ArrayList<>();
    static ArrayList<String> tiposAccesorios = new ArrayList<>();

    ArrayList<String> getTiposSuperiores() {
        return tiposSuperiores;
    }

    ArrayList<String> getTiposInferiores() {
        return tiposInferiores;
    }

    ArrayList<String> getTiposCalzados() {
        return tiposCalzados;
    }

    ArrayList<String> getTiposAccesorios() {
        return tiposAccesorios;
    }

    public Prenda cargarPrenda() {
        Prenda prenda = indicarTipo();
        prenda.elegirMaterial();
        prenda.elegirColor();
        prenda.elegirColorSecundario();

        return prenda;
    }

    public static int seleccionarCategoria() {
        System.out.println("Seleccione categoria:");
        System.out.println("1. Prenda superior");
        System.out.println("2. Prenda inferior");
        System.out.println("3. Calzado");
        System.out.println("4. Accesorio");

        try { 
            Scanner scan = new Scanner(System.in);

            int eleccion = scan.nextInt();
            scan.close();
            return eleccion;
        }
        catch (IllegalArgumentException tipoErroneo) {
            System.out.println("Se introdujo un valor invalido.");
            return 0;
        }      
    }

    
    Prenda indicarTipo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Indique el tipo de prenda que desea crear:");
        String tipoElegido = scan.nextLine();
        scan.close();

        return identificarTipo(tipoElegido);
    }

    Prenda identificarTipo(String unTipo) { // Se podria hacer una funcion getter mas sencilla
        try {
            if (this.getTiposSuperiores().contains(unTipo))
                return new PrendaSuperior(unTipo);
            else if (this.getTiposInferiores().contains(unTipo))
                return new PrendaInferior(unTipo);
            else if (this.getTiposCalzados().contains(unTipo))
                return new Calzado(unTipo);
            else if (this.getTiposAccesorios().contains(unTipo))
                return new Accesorio(unTipo);
        }   
        catch (Exception noSeEncontroTipo) {
            System.out.print("No se indico un tipo correcto");
            // Hacer Prenda fallada
        }
    }
}

