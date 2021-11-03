package Accenture.Cursojava.Postwork.David;


public class ListaTareaMain {

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        Lector lector = new Lector();
        ListasTareas l1 = new ListasTareas();
        byte Opcion;


        do {
            menu.muestraOpciones();
            Opcion = lector.leeOpcion();
            System.out.printf("%n%nSeleccionaste la Opccion: %d%n", Opcion);

            switch (Opcion) {
                case 1:
                    l1.crearNuevaLista();
                    break;
                case 2:
                    l1.verListaTareas();
                    break;
                case 3:
                    l1.verTareasDeLista();
                    break;
                case 4:
                    l1.actualizarListaDeTareas();
                    break;
                case 5:
                    l1.eliminarListaDeTareas();
                    break;
                case 6:
                    l1.guardarTareas();
                    System.out.println("Saliendo de la aplicación");
                    break;
                default:
                    System.out.println("Opción desconocida.");
            }
        }while (Opcion != 6);


    }
}
