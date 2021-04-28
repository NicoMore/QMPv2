public class QueMePongo {
    public static void main(String[] args) {
        while(true) {           
            switch (FabricaDePrenda.seleccionarCategoria() - 1) {
                case -1:
                    System.out.println("Hubo un error al elegir categoria, intente nuevamente.");
                    break;
                case Categoria.SUPERIOR:
                    Prenda nuevaPrendaSuperior = new FabricaDePrendaSuperior().cargarPrenda();
                    break;
                case Categoria.INFERIOR:
                    Prenda nuevaPrendaInferior = new FabricaDePrendaInferior().cargarPrenda();
                    break;
                case Categoria.CALZADO:
                    Prenda nuevoCalzado = new FabricaDeCalzado().cargarPrenda();
                    break;
                case Categoria.ACCESORIO:
                    Prenda nuevoAccesorio = new FabricaDeAccesorio().cargarPrenda();
                    break;
            }


            //Condicion de corte
        }

        //Posible generacion de atuendos
    }


}