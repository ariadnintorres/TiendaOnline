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
		 
		// Nani: Declaración de los arrays y el contador real de productos
			String[] nombres = new String[10]; 
			double[] precios = new double[10];
			int[] stock = new int[10];
			int numProductos = 0;
			
			
			// Nani: Carga inicial de datos
			nombres[0] = "PlayStation 5 (PS5)"; precios[0] = 549.99; stock[0] = 3;
			nombres[1] = "Nintendo Switch OLED"; precios[1] = 349.00; stock[1] = 5;
			nombres[2] = "Cyberpunk 2077"; precios[2] = 49.99; stock[2] = 25;
			nombres[3] = "Control DualSense PS5"; precios[3] = 69.90; stock[3] = 12;
			nombres[4] = "Mario Kart 8 Deluxe"; precios[4] = 59.99; stock[4] = 30;
			nombres[5] = "Final Fantasy XVI"; precios[5] = 79.99; stock[5] = 18;
			nombres[6] = "Figura Coleccionable Valorant"; precios[6] = 45.50; stock[6] = 10;
			nombres[7] = "Headset Oficial PS5 Pulse 3D"; precios[7] = 99.00; stock[7] = 8;
			nombres[8] = "Super Mario Bros. Wonder"; precios[8] = 59.99; stock[8] = 22;
			nombres[9] = "Tarjeta de Regalo Pavos (50€)"; precios[9] = 50.00; stock[9] = 40;

			numProductos = 10;

		 
		 
		 
		 
		 
		 
		 

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
	    System.out.println( CYAN +"\n  Bienvenido a CLOUD GAME de Videojuegos 🎮" + RESET);

	       
	                
	     // Persona B: Métodos de compra y carrito

	        int carrito[] = new int[0];
	        int cantidadCarrito = 0;
	        int opcion;

	        do {
	            // ==== MENÚ ====
	        	mostrarMenu();
	            opcion = pedirEnteroSeguro(sc," ");

	            switch (opcion) {

	                case 1:
	                    System.out.println("\n--- VIDEOJUEGOS DISPONIBLES ---");
	                    for (int i = 0; i < nombres.length; i++) {
	                        System.out.println(i + ". " + nombres[i] + " - €" + precios[i]);
	                    }
	                    break;

	                case 2:
	                    System.out.println("\nIngresa el número del videojuego que quieres agregar:");
	                    int prod = sc.nextInt();

	                    if (prod >= 0 && prod < nombres.length) {
	                        carrito[cantidadCarrito] = prod;
	                        cantidadCarrito++;
	                        System.out.println(nombres[prod] + " añadido al carrito.");
	                    } else {
	                        System.out.println("Número inválido.");
	                    }
	                    break;

	                case 3:
	                	carrito(cantidadCarrito, carrito, nombres, precios);
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
        
        System.out.println(LIGHT_PINK + "═".repeat(45) + RESET);
        
        // --- . LISTA DE OPCIONES ---
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "           MENÚ TIENDA ONLINE" + " ".repeat(13) + LIGHT_PINK + "|" + RESET);
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "                               " + " ".repeat(11) + LIGHT_PINK + "|" + RESET);
        // Opción 1: Catálogo (Texto en Blanco)
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[1] Ver videojuegos disponibles" + " ".repeat(11) + LIGHT_PINK + "|" + RESET);
        
        // Opción 2: Carrito
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[2] Agregar videojuego al carrito " + " ".repeat(8) + LIGHT_PINK + "|" + RESET);
        
        // Opción 3: Finalizar Compra
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[3] Ver carrito" + " ".repeat(27) + LIGHT_PINK + "|" + RESET);
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[4] Calcular total a pagar" + " ".repeat(16) + LIGHT_PINK + "|" + RESET);
        
        // Separador (en Salmon)
        System.out.println(LIGHT_PINK + "|"+ "-".repeat(43) + "|" + RESET);
        
        // Opción 4: Salir
     
        
        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[5] Salir y Cerrar Tienda" + " ".repeat(17) + LIGHT_PINK + "|" + RESET);
        
        
        // --- 4. PIE DE PÁGINA Y SOLICITUD DE ENTRADA ---
        System.out.println(LIGHT_PINK + "═".repeat(45) + RESET);
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
	
	public static double leerDoublePositivo(Scanner sc, String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				double valor = sc.nextDouble();
				if (valor > 0) {
					return valor;
				}else {
					System.out.println("Error: El número debe ser positivo.");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Introduce un número decimal válido.");
				sc.nextLine();
			}
		}
	}
	
	public static int leerEnteroNoNegativo(Scanner sc, String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				int valor = sc.nextInt();
				
				if (valor >= 0) {
					return valor;
				}else {
					System.out.println("Error: El número no puede ser negativo.");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Introduce un número entero válido.");
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
	
	 
	// =========================================================
		// TAREA DE NANI (A2): ARRAYS DINÁMICOS
		// =========================================================
		public static String[] redimensionarArrayString(String[] arrayOriginal, int numElementosActuales, int nuevoTamaño) {
			String[] nuevoArray = new String[nuevoTamaño];
			// Copiamos solo los elementos reales que tienen datos
			for (int i = 0; i < numElementosActuales; i++) {
				nuevoArray[i] = arrayOriginal[i];
			}
			System.out.println(CYAN + "Array de Nombres redimensionado a tamaño: " + nuevoTamaño + RESET);
			return nuevoArray;
		}



		public static double[] redimensionarArrayDouble(double[] arrayOriginal, int numElementosActuales, int nuevoTamanio) {
			double[] nuevoArray = new double[nuevoTamanio];
			for (int i = 0; i < numElementosActuales; i++) {
				nuevoArray[i] = arrayOriginal[i];
			}
			System.out.println(CYAN + "Array de Precios redimensionado a tamaño: " + nuevoTamanio + RESET);
			return nuevoArray;

		}
		public static int[] redimensionarArrayInt(int[] arrayOriginal, int numElementosActuales, int nuevoTamanio) {
			int[] nuevoArray = new int[nuevoTamanio];
			for (int i = 0; i < numElementosActuales; i++) {
				nuevoArray[i] = arrayOriginal[i];
			}
			System.out.println(CYAN + "Array de Stock redimensionado a tamaño: " + nuevoTamanio + RESET);
			return nuevoArray;
		}
		
		// =========================================================
		// TAREA DE NANI (A3): ALTA DE PRODUCTO
		// =========================================================

	/*public static int altaProducto(Scanner sc , String[]nombres ,double[] precios,int[] stock,int numProductos) {
		if (numProductos== nombres.length) {
			System.out.println(RED + "❌ ERROR: Capacidad del almacén agotada. Es necesario redimensionar (Opción no implementada en este punto)." + RESET);
			// Devolvemos el mismo número de productos para no romper el contador.
	        return numProductos;
		}
		
		String nuevoNombre ="";
		int indiceExistente=-1;
		
		// Bucle para asegurar que el nombre es único
	    do {
	        System.out.print(YELLOW + "Introduzca el nombre del nuevo producto: " + RESET);
	        nuevoNombre = sc.nextLine().trim();

	        // Controlamos que no esté vacío antes de buscar
	        if (nuevoNombre.isEmpty()) {
	            System.out.println(RED + "❌ El nombre del producto no puede estar vacío." + RESET);
	            indiceExistente = 0; // Para forzar la repetición
	            continue;
	        }
	        
	        indiceExistente = buscarIndiceProducto(nuevoNombre, nombres, numProductos);
	        
	        if (indiceExistente != -1) {
	            System.out.println(RED + "⚠️ ERROR: El producto '" + nuevoNombre + "' ya está registrado. Debe introducir uno diferente." + RESET);
	        }
	    } while (indiceExistente != -1);
	    
	    double nuevoPrecio = leerDoublePositivo(scanner, "Introduzca el precio unitario (> 0): ");
	    int nuevaCantidad = leerEnteroNoNegativo(scanner, "Introduzca la cantidad disponible en stock (>= 0): ");
	    
	    // 4. Inserción (A3)
	    nombres[numProductos] = nuevoNombre;
	    precios[numProductos] = nuevoPrecio;
	    stock[numProductos] = nuevaCantidad; 
	    
	    System.out.println(GREEN + "✅ Producto '" + nuevoNombre + "' agregado con éxito en el índice " + numProductos + "." + RESET);
	    
	    return numProductos + 1; // Devolver el nuevo contador
	}

		
	}

	}*/

	
	
	
	
	
}
