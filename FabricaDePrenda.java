import java.util.ArrayList;
import java.util.Scanner;

enum Categoria { SUPERIOR, INFERIOR, CALZADO, ACCESORIO; }

abstract class FabricaDePrenda {
    public Prenda cargarPrenda() {
        Prenda prenda = nuevaPrenda();
        prenda.indicarTipo();
        prenda.elegirMaterial();
        prenda.elegirColor();
        prenda.elegirColorSecundario();

        return prenda;
    }

    public static int seleccionarCategoria() {
        System.out.println("Seleccione categoria:");
        System.out.print("1. Prenda superior");
        System.out.print("2. Prenda inferior");
        System.out.print("3. Calzado");
        System.out.print("4. Accesorio");

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

    abstract Prenda nuevaPrenda();

}

class FabricaDePrendaSuperior extends FabricaDePrenda {
    Prenda nuevaPrenda() {
        return new PrendaSuperior();
    }
}

class FabricaDePrendaInferior extends FabricaDePrenda {
    Prenda nuevaPrenda() {
        return new PrendaInferior();
    }
}

class FabricaDeCalzado extends FabricaDePrenda {
    Prenda nuevaPrenda() {
        return new Calzado();
    }
}

class FabricaDeAccesorio extends FabricaDePrenda {
    Prenda nuevaPrenda() {
        return new Accesorio();
    }
}