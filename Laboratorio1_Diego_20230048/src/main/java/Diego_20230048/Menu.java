package Diego_20230048;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Inventario inventario;

    public Menu(Inventario inventario) {
        this.scanner = new Scanner(System.in);
        this.inventario = inventario;
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1. Actualizar stock de producto");
            System.out.println("2. Listar productos con stock bajo (<10)");
            System.out.println("3. Listar todos los productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    actualizarStock();
                    break;
                case "2":
                    listarStockBajo();
                    break;
                case "3":
                    listarTodosLosProductos();
                    break;
                case "4":
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void actualizarStock() {
        System.out.println("\n--- ACTUALIZAR STOCK ---");
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese la nueva cantidad en stock: ");
        String cantidad = scanner.nextLine();

        if (inventario.actualizarStock(id, cantidad)) {
            System.out.println("Stock actualizado correctamente.");
        } else {
            System.out.println("Producto no registrado.");
        }
    }

    private void listarStockBajo() {
        System.out.println("\n--- PRODUCTOS CON STOCK BAJO (<10) ---");
        String[][] productosBajoStock = inventario.obtenerProductosConStockBajo();

        boolean hayProductos = false;
        for (String[] producto : productosBajoStock) {
            if (producto != null && producto[0] != null) {
                System.out.printf("ID: %s - %s - Stock: %s%n", producto[0], producto[1], producto[2]);
                hayProductos = true;
            }
        }

        if (!hayProductos) {
            System.out.println("No hay productos con stock bajo.");
        }
    }

    private void listarTodosLosProductos() {
        System.out.println("\n--- TODOS LOS PRODUCTOS ---");
        String[][] todosProductos = inventario.obtenerTodosLosProductos();

        for (String[] producto : todosProductos) {
            if (producto != null && producto[0] != null) {
                System.out.printf("ID: %s - %s - Stock: %s%n", producto[0], producto[1], producto[2]);
            }
        }
    }
}
