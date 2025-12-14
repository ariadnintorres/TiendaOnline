package programacion;
import java.util.InputMismatchException;
import java.util.Scanner;
public class P4EJ1 {
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String LIGHT_PINK = "\u001B[38;5;207m";
    public static final String FUCHSIA = "\u001B[95m";
    public static final String SALMON = "\u001B[38;5;209m";
    public static final String WHITE = "\u001B[37m";
    
	// CONSTANTES DE COLOR ANSI (BACKGROUND)
	public static final String BLACK_BG = "\u001B[40m";
	public static final String SKIN_BG = "\u001B[48;5;253m";
	public static final String HAIR_LIGHT_BG = "\u001B[48;5;45m";
	public static final String HAIR_DARK_BG = "\u001B[48;5;37m";
	public static final String PINK_BG = "\u001B[48;5;201m";
	public static final String GRAY_BG = "\u001B[48;5;240m";
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

		System.out.println(BLUE + "##########################################" + RESET);
		System.out.println(BLUE + "#                                        #" + RESET);
		System.out.println(BLUE + "#  " + LIGHT_PINK + "  ████  ██     ████  ██  ██ ████   " + BLUE + "   #" + RESET);
		System.out.println(BLUE + "#  " + LIGHT_PINK + " ██  ██ ██    ██  ██ ██  ██ ██ ██  " + BLUE + "   #" + RESET);
		System.out.println(BLUE + "#  " + LIGHT_PINK + " ██     ██    ██  ██ ██  ██ ██  ██ " + BLUE + "   #" + RESET);
		System.out.println(BLUE + "#  " + LIGHT_PINK + " ██  ██ ██    ██  ██ ██  ██ ██ ██  " + BLUE + "   #" + RESET);
		System.out.println(BLUE + "#  " + LIGHT_PINK + "  ████  █████  ████   ████  ████   " + BLUE + "   #" + RESET);
		System.out.println(BLUE + "#                                        #" + RESET);
		System.out.println(BLUE + "#  " + CYAN + "Tienda Online Oficial de CLOUD GAME" + BLUE + "   #" + RESET);
		System.out.println(BLUE + "#  "+ FUCHSIA + "           sina y nani    "+  BLUE   +"            #" + RESET);
		System.out.println(BLUE + "##########################################" + RESET);
		System.out.println();
		System.out.println(GREEN + ">> Pulsa ENTER para iniciar █ ..." + RESET);
		
	        sc.nextLine();


	        // ==== PRODUCTOS ====
	        String productos[] = {
	                "The Legend of Zelda: Breath of the Wild",
	                "Elden Ring",
	                "Minecraft",
	                "GTA V",
	                "Hogwarts Legacy",
	                "The Witcher 3",
	                "Super Mario Odyssey "
	        };

	        double precios[] = {
	                59.99, 49.99, 19.99, 29.99, 39.99, 24.99, 44.99
	        };
	     // Persona B: Métodos de compra y carrito

	        int carrito[] = new int[0];
	        int cantidadCarrito = 0;
	        int opcion;

	        do {
	            // ==== MENÚ ====
	        	mostrarMenu();
	            opcion = pedirEnteroSeguro(sc,"Elige una opción del menú: ");

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
	                	carrito(cantidadCarrito, carrito, productos, precios);
	                    break;

	                case 4:
	                	totalAPagar(cantidadCarrito, carrito, precios);
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
	
	public static void mostrarMenu() {
	    // ==== MENÚ ====
        System.out.println("\n--- MENÚ TIENDA ONLINE ---");
        System.out.println("1. Ver videojuegos disponibles");
        System.out.println("2. Agregar videojuego al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Calcular total a pagar");
        System.out.println("5. Salir");

        System.out.println( CYAN +"\nBienvenido a la Tienda Online CLOUD GAME de Videojuegos 🎮" + RESET);
        System.out.println("");
        System.out.println(SALMON + "-".repeat(45) + RESET);
        
        // --- 3. LISTA DE OPCIONES ---
        
        // Opción 1: Catálogo (Texto en Blanco)
        System.out.println(SALMON + "|" + RESET + " " + WHITE + "[1] Explorar Catálogo de Juegos" + " ".repeat(14) + SALMON + "|" + RESET);
        
        // Opción 2: Carrito
        System.out.println(SALMON + "|" + RESET + " " + WHITE + "[2] Ver Carrito de Compras" + " ".repeat(18) + SALMON + "|" + RESET);
        
        // Opción 3: Finalizar Compra
        System.out.println(SALMON + "|" + RESET + " " + WHITE + "[3] Pagar y Finalizar Pedido" + " ".repeat(17) + SALMON + "|" + RESET);
        
        // Separador (en Salmon)
        System.out.println(SALMON + "|"+ "-".repeat(43) + "|" + RESET);
        
        // Opción 4: Salir
        System.out.println(SALMON + "|" + RESET + " " + WHITE + "[4] Salir y Cerrar Tienda" + " ".repeat(20) + SALMON + "|" + RESET);
        
        // --- 4. PIE DE PÁGINA Y SOLICITUD DE ENTRADA ---
        System.out.println(SALMON + "═".repeat(45) + RESET);
        System.out.println(GREEN + ">> Seleccione una opción (1-4): " + RESET);
        
	}
	
	public static int pedirEnteroSeguro(Scanner sc, String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: introduce un número entero válido.");
				sc.nextLine();
			}
		}
	}
	
	//carrito si esta vacio y los productos y precios 
	public static void carrito(int cantidadCarrito, int [] carrito, String [] productos, double [] precios ) {
		 System.out.println("\n--- TU CARRITO ---");
         if (cantidadCarrito == 0) {
             System.out.println("El carrito está vacío.");
         } else {
             for (int i = 0; i < cantidadCarrito; i++) {
                 int index = carrito[i];
                 System.out.println("- " + productos[index] + " (€" + precios[index] + ")");
                 }
             double total = totalAPagar(cantidadCarrito, carrito, precios);
             System.out.println("----------------------------");
             System.out.println("Total sin IVA: €" + total);
             System.out.println("Total con IVA (21%): €" + (total * 1.21));
         }
	}
	
	public static double totalAPagar(int cantidadCarrito, int []  carrito, double [] precios) {
		double total = 0;
        for (int i = 0; i < cantidadCarrito; i++) {
            total += precios[carrito[i]];
        }
        System.out.println("\n Total a pagar: €" + total);
     // Asumiendo que SALMON y WHITE están definidos
        System.out.println(SALMON + "█████████████████████████" + RESET);
        System.out.println(SALMON + "█" + WHITE + " Producto #1 - La espada  " + SALMON + "█" + RESET);
        System.out.println(SALMON + "█" + WHITE + " ".repeat(23) + SALMON + "█" + RESET);
        System.out.println(SALMON + "█" + WHITE + "  Precio: [GREEN] 9.99€ [WHITE]      " + SALMON + "█" + RESET);
        System.out.println(SALMON + "█████████████████████████" + RESET);
        return total;
	}
	
	 
	
	
	
	
	
	
}
