import java.util.ArrayList;
import java.util.Scanner;

enum Categoria { Superior, Inferior, Calzado, Accesorio; }

class BuilderPrenda {
    static ArrayList<String> tiposSuperiores = new ArrayList<>();
    static ArrayList<String> tiposInferiores = new ArrayList<>();
    static ArrayList<String> tiposCalzados = new ArrayList<>();
    static ArrayList<String> tiposAccesorios = new ArrayList<>();

    Prenda borrador;

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
        if (!continuar(prenda)) 
            return borrador;
        prenda.elegirMaterial();
        if (!continuar(prenda)) 
            return borrador;
        prenda.elegirColor();
        if (!continuar(prenda)) 
            return borrador;
        prenda.elegirColorSecundario();

        return prenda;
    }

    Prenda continuarBorrador() {
        Prenda prenda = borrador;
        
        // Identificaria que le falta al borrador para completarlo

        return prenda;
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

    boolean continuar(Prenda unaPrenda) {
        System.out.println("Desea continuar?");

        Scanner scan = new Scanner(System.in);

        if (scan.nextLine().startsWith("S")) 
            return true;
        else {
            this.borrador = unaPrenda;
            return false;
        }

    }
}

