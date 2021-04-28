import java.util.ArrayList;
import java.util.Scanner;

abstract class Prenda {
    String tipo;
    String material;
    String color;
    String colorSecundario;

    void elegirMaterial() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Indique material:");

            this.material = scan.nextLine();
            scan.close();
        }
        catch (IllegalArgumentException tipoErroneo) {
            System.out.println("Se introdujo un valor de material invalido.");
        }
    }

    void elegirColor() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Indique color:");

            this.color = scan.nextLine();
            scan.close();
        }
        catch (IllegalArgumentException tipoErroneo) {
            System.out.println("Se introdujo un valor de color invalido.");
        } 
    }

    void elegirColorSecundario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea agregar un color secundario?");

        boolean deseaColorSecundario = scan.nextBoolean();
        if (deseaColorSecundario) {
            try {
                System.out.println("Indique color secundario:");

                this.colorSecundario = scan.nextLine();
                scan.close();
            }
            catch (IllegalArgumentException tipoErroneo) {
                System.out.println("Se introdujo un valor de color invalido.");
            }
        }
    }

    void indicarTipo() {
        // Solicitaria que usuario seleccione de la lista tiposCompatibles (de las subclases) un tipo.
    }

}

class PrendaSuperior extends Prenda {
    ArrayList<String> tiposCompatibles = new ArrayList<>();
}

class PrendaInferior extends Prenda {
    ArrayList<String> tiposCompatibles = new ArrayList<>();
}

class Calzado extends Prenda {
    ArrayList<String> tiposCompatibles = new ArrayList<>();
}

class Accesorio extends Prenda {
    ArrayList<String> tiposCompatibles = new ArrayList<>();
}