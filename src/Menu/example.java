package Menu;
import java.util.ArrayList;
import java.util.List;

interface MenuComponent {
    void draw();
	void add(MenuComponent newItem);
}

class MenuItem implements MenuComponent {
    private String name;
    public MenuItem(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("Dibujando ítem del menú: " + name);
    }

	@Override
	public void add(MenuComponent newItem) {
	}
}

class Menu implements MenuComponent {
    private String name;
    private List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        menuComponents.add(component);
    }

    public void draw() {
        System.out.println("Dibujando menú: " + name);
        for (MenuComponent component : menuComponents) {
            component.draw();
        }
    }
}

public class example {
    public static void main(String[] args) {
        MenuComponent mainMenu = new Menu("Menú Principal");

        MenuComponent fileMenu = new Menu("Archivo");
        MenuComponent editMenu = new Menu("Editar");

        MenuComponent newItem = new MenuItem("Nuevo");
        MenuComponent openItem = new MenuItem("Abrir");
        MenuComponent cutItem = new MenuItem("Cortar");
        MenuComponent copyItem = new MenuItem("Copiar");
        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        editMenu.add(cutItem);
        editMenu.add(copyItem);

        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);

        mainMenu.draw();
    }
}
