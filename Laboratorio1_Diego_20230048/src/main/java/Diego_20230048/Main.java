package Diego_20230048;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Menu menu;
        menu = new Menu(inventario);
        menu.mostrarMenuPrincipal();
    }
}