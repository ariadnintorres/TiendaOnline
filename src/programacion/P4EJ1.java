package programacion;
import java.util.Scanner;
public class P4EJ1 {
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

	public static void main(String[] args) {
		/*selecion de productos y la cantidad de los mismos en el carrito
		 * debe tener minimo 10 productos
		 * precio por unidad
		 * cantidad de stock
		 * al relaizar law compra recibe un la informacion total de los productos y el precio total
		 * el precio total mas 21% de iva 
		 *  
		 *  
		 *  un menu con:
		 *  -alta de producto
		 *  -consulta de productos
		 *  -modificar el precio y cantidad de un producto
		 *  -baja de un producto
		 *  -compra
		 *  -salir
		 *  
		 *  */
		 Scanner sc = new Scanner(System.in);

	        System.out.println(BLUE + "#############################################" + RESET);
	        System.out.println(BLUE + "#                                           #" + RESET);
	        System.out.println(BLUE + "#  " + YELLOW + "╔═╗┬ ┬┌─┐┌─┐┬  ┌─┐┬  ┬" + BLUE + "                   #" + RESET);
	        System.out.println(BLUE + "#  " + YELLOW + "╚═╗└┬┘├┤ ├┤ │  ├─┤└┐┌┘" + BLUE + " THE LEGEND OF ARIA #" + RESET);
	        System.out.println(BLUE + "#  " + YELLOW + "╚═╝ ┴ └─┘└  ┴─┘┴ ┴ └┘ " + BLUE + "                   #" + RESET);
	        System.out.println(BLUE + "#                                           #" + RESET);
	        System.out.println(BLUE + "#    " + CYAN + "Tienda Online Oficial de Videojuegos" + BLUE + "    #" + RESET);
	        System.out.println(BLUE + "#                                           #" + RESET);
	        System.out.println(BLUE + "#############################################" + RESET);
	        System.out.println();
	        System.out.println(GREEN + ">> Pulsa ENTER para iniciar..." + RESET);

	        sc.nextLine();

	        System.out.println("\nBienvenido a la Tienda Online de Videojuegos 🎮");
	        System.out.println("");

	        // ==== PRODUCTOS ====
	        String productos[] = {
	                "The Legend of Zelda: Breath of the Wild",
	                "Elden Ring",
	                "Minecraft",
	                "GTA V",
	                "Hogwarts Legacy",
	                "The Witcher 3",
	                "Super Mario Odyssey"
	        };

	        double precios[] = {
	                59.99, 49.99, 19.99, 29.99, 39.99, 24.99, 44.99
	        };

	        int carrito[] = new int[50];
	        int cantidadCarrito = 0;
	        int opcion;

	        do {
	            // ==== MENÚ ====
	            System.out.println("\n--- MENÚ TIENDA ONLINE ---");
	            System.out.println("1. Ver videojuegos disponibles");
	            System.out.println("2. Agregar videojuego al carrito");
	            System.out.println("3. Ver carrito");
	            System.out.println("4. Calcular total a pagar");
	            System.out.println("5. Salir");
	            System.out.print("Elige una opción: ");
	            opcion = sc.nextInt();

	            switch (opcion) {

	                case 1:
	                    System.out.println("\n--- VIDEOJUEGOS DISPONIBLES ---");
	                    for (int i = 0; i < productos.length; i++) {
	                        System.out.println(i + ". " + productos[i] + " - €" + precios[i]);
	                    }
	                    break;

	                case 2:
	                    System.out.println("\nIngresa el número del videojuego que quieres agregar:");
	                    int prod = sc.nextInt();

	                    if (prod >= 0 && prod < productos.length) {
	                        carrito[cantidadCarrito] = prod;
	                        cantidadCarrito++;
	                        System.out.println(productos[prod] + " añadido al carrito.");
	                    } else {
	                        System.out.println("Número inválido.");
	                    }
	                    break;

	                case 3:
	                    System.out.println("\n--- TU CARRITO ---");
	                    if (cantidadCarrito == 0) {
	                        System.out.println("El carrito está vacío.");
	                    } else {
	                        for (int i = 0; i < cantidadCarrito; i++) {
	                            int index = carrito[i];
	                            System.out.println("- " + productos[index] + " (€" + precios[index] + ")");
	                        }
	                    }
	                    break;

	                case 4:
	                    double total = 0;
	                    for (int i = 0; i < cantidadCarrito; i++) {
	                        total += precios[carrito[i]];
	                    }
	                    System.out.println("\n💰 Total a pagar: €" + total);
	                    break;

	                case 5:
	                    System.out.println("Gracias por visitar la Tienda Online. ¡Hasta pronto!");
	                    break;

	                default:
	                    System.out.println("Opción inválida, intenta nuevamente.");
	            }

	        } while (opcion != 5);

	        sc.close();
	    }
}
