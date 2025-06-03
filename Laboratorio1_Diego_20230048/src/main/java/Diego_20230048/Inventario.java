package Diego_20230048;

public class Inventario {
    private String[][] productos;
    private int capacidad;
    private int cantidadProductos;

    public Inventario() {
        this.capacidad = 10;
        this.productos = new String[capacidad][3]; // ID, Nombre, Stock
        this.cantidadProductos = 0;
        inicializarProductosEjemplo();
    }

    private void inicializarProductosEjemplo() {
        agregarProducto("P001", "Laptop", "15");
        agregarProducto("P002", "Mouse", "5");
        agregarProducto("P003", "Teclado", "8");
        agregarProducto("P004", "Monitor", "12");
        agregarProducto("P005", "USB 32GB", "3");
    }

    public boolean agregarProducto(String id, String nombre, String stock) {
        if (cantidadProductos >= capacidad) {
            return false;
        }
        productos[cantidadProductos][0] = id;
        productos[cantidadProductos][1] = nombre;
        productos[cantidadProductos][2] = stock;
        cantidadProductos++;
        return true;
    }

    public boolean actualizarStock(String id, String nuevaCantidad) {
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i][0].equals(id)) {
                productos[i][2] = nuevaCantidad;
                return true;
            }
        }
        return false;
    }

    public String[][] obtenerProductosConStockBajo() {
        String[][] resultado = new String[capacidad][3];
        int contador = 0;

        for (int i = 0; i < cantidadProductos; i++) {
            try {
                int stock = Integer.parseInt(productos[i][2]);
                if (stock < 10) {
                    resultado[contador][0] = productos[i][0];
                    resultado[contador][1] = productos[i][1];
                    resultado[contador][2] = productos[i][2];
                    contador++;
                }
            } catch (NumberFormatException e) {
                // Ignorar productos con stock inválido
            }
        }

        return resultado;
    }

    public String[][] obtenerTodosLosProductos() {
        return productos;
    }
}
