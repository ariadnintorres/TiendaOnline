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
	public static final String BLACK_BG = "\u001B[40m";
	public static final String SKIN_BG = "\u001B[48;5;253m";
	public static final String HAIR_LIGHT_BG = "\u001B[48;5;45m";
	public static final String HAIR_DARK_BG = "\u001B[48;5;37m";
	public static final String PINK_BG = "\u001B[48;5;201m";
	public static final String GRAY_BG = "\u001B[48;5;240m";
	public static final double IVA_APLICADO = 0.21; // 21%
	
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // [MENSAJE DE BIENVENIDA Ariadna Sinay Torres Casique y Ariadni Noemy Torres Casique]
        
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
		System.out.println(GREEN + ">> Pulsa ENTER para iniciar ..." + RESET);
		
		sc.nextLine();
       
		
	
		        // Nani A1: Declaración de los arrays principales y el contador
		        final int CAPACIDAD_INICIAL = 15;
		        String[] nombres = new String[CAPACIDAD_INICIAL];
		        double[] precios = new double[CAPACIDAD_INICIAL];
		        int[] stock = new int[CAPACIDAD_INICIAL];
		        int numProductos = 0; 

		        // Nani A1 / Sina I1: Carga inicial de datos
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

		        // Arrays del Carrito (Se mantienen en el main para que persistan entre opciones 5-8)
		        final int CAPACIDAD_CARRITO = 50; 
		        int[] carritoIDs = new int[CAPACIDAD_CARRITO];       // Índices del producto en el almacén
		        int[] carritoCantidades = new int[CAPACIDAD_CARRITO]; // Cantidad deseada de ese producto
		        int numArticulosCarrito = 0; // Contador de tipos diferentes de artículos en el carrito

		        int opcion;

		        do {
		            mostrarMenu();
		            opcion = pedirEnteroSeguro(sc, "");
		            
		            // CRÍTICO: Consumir el salto de línea pendiente después de leer el número de opción.
		            // Esto es necesario porque pedirEnteroSeguro solo lee el número.
		            sc.nextLine(); 

		            switch (opcion) {

		                case 1: // ALTA DE PRODUCTO 
		                    if (numProductos == nombres.length) {
		                        System.out.println(YELLOW + " Capacidad agotada (" + nombres.length + "). Redimensionando arrays..." + RESET);
		                        int nuevoTamanio = nombres.length + 10;
		                        nombres = redimensionarArrayString(nombres, numProductos, nuevoTamanio);
		                        precios = redimensionarArrayDouble(precios, numProductos, nuevoTamanio);
		                        stock = redimensionarArrayInt(stock, numProductos, nuevoTamanio);
		                    }
		                    numProductos = altaProducto(sc, nombres, precios, stock, numProductos);
		                    break;

		                case 2: // CONSULTA DE PRODUCTOS 
		                    consultarProductos(nombres, precios, stock, numProductos);
		                    break;

		                case 3: // MODIFICACIÓN DE PRODUCTO 
		                    modificarProducto(sc, nombres, precios, stock, numProductos);
		                    break;

		                case 4: // BAJA DE PRODUCTO 
		                    numProductos = bajaProducto(sc, nombres, precios, stock, numProductos);
		                    break;

		                case 5: // VER ARTÍCULOS DISPONIBLES 
		                    consultarProductos(nombres, precios, stock, numProductos);
		                    break;

		                case 6: // AGREGAR PRODUCTO AL CARRITO (Sina B4)
		                    // PASAR PRECIOS A AGREGAR PRODUCTO AL CARRITO PARA EL LISTADO INTERNO
		                    int[] resultado = agregarProductoAlCarrito(sc, nombres, precios, stock, numProductos, carritoIDs, carritoCantidades, numArticulosCarrito);
		                    numArticulosCarrito = resultado[0];
		                    break;

		                case 7: // VER CARRITO ACTUAL (Sina B4)
		                    verCarrito(nombres, precios, carritoIDs, carritoCantidades, numArticulosCarrito);
		                    break;

		                case 8: // FINALIZAR COMPRA Y PAGAR (Sina B5)
		                    numArticulosCarrito = finalizarCompra(nombres, precios, stock, carritoIDs, carritoCantidades, numArticulosCarrito);
		                    break;

		                case 0:
		                    System.out.println(GREEN + "¡Gracias por usar CLOUD GAME! Cerrando aplicación." + RESET);
		                    break;

		                default:
		                    System.out.println(RED + " (￢_￢;) Opción inválida, intenta nuevamente." + RESET);
		            }

		        } while (opcion != 0);

		        sc.close();
		    } // Fin del main

		    // =========================================================
		    // FUNCIONES DE MENÚ Y FORMATO
		    // =========================================================

		    public static void mostrarMenu() {
		        System.out.println(LIGHT_PINK + "═".repeat(45) + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "      MENÚ PRINCIPAL DE TIENDA" + " ".repeat(12) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|"+ "-".repeat(43) + "|" + RESET);

		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "Gestión de Inventario (ADMIN):" + " ".repeat(12) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[1] Alta de Producto         " + " ".repeat(13) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[2] Consulta de Productos     " + " ".repeat(12) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[3] Modificación de Producto     " + " ".repeat(9) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[4] Baja de Producto     " + " ".repeat(17) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|"+ "-".repeat(43) + "|" + RESET);

		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "Transacción (CLIENTE):" + " ".repeat(20) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[5] Ver Artículos Disponibles     " + " ".repeat(8) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[6] Agregar Producto al Carrito     " + " ".repeat(6) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[7] Ver Carrito Actual" + " ".repeat(20) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[8] Finalizar Compra y Pagar     " + " ".repeat(9) + LIGHT_PINK + "|" + RESET);
		        
		        System.out.println(LIGHT_PINK + "|"+ "-".repeat(43) + "|" + RESET);
		        System.out.println(LIGHT_PINK + "|" + RESET + " " + WHITE + "[0] Salir y Cerrar Tienda" + " ".repeat(17) + LIGHT_PINK + "|" + RESET);
		        System.out.println(LIGHT_PINK + "═".repeat(45) + RESET);
		        System.out.print(GREEN + ">> Seleccione una opción (0-8): " + RESET);
		    }
		    
		    // =========================================================
		    // FUNCIONES DE APOYO (Sina B6) - CRÍTICAS PARA EL FLUJO
		    // =========================================================

		    public static int pedirEnteroSeguro(Scanner sc, String mensaje) {
		        while (true) {
		            try {
		                System.out.print(mensaje);
		                return sc.nextInt();
		            } catch (InputMismatchException e) {
		                System.out.println(RED + "(￢_￢;) Error: introduce un número entero válido." + RESET);
		                sc.nextLine(); // Limpiar el buffer si hay error
		            }
		        }
		    }
		    
		    public static double leerDoublePositivo(Scanner sc, String mensaje) {
		        double valor = 0;
		        while (valor <= 0) {
		            try {
		                System.out.print(YELLOW + mensaje + RESET);
		                valor = sc.nextDouble(); 
		                if (valor <= 0) {
		                    System.out.println(RED + "Error: El valor debe ser un número positivo (> 0)." + RESET);
		                }
		            } catch (InputMismatchException e) {
		                System.out.println(RED + "Error: Entrada inválida. Por favor, ingrese un número decimal." + RESET);
		                sc.nextLine();
		            }
		        }
		        return valor;
		    }
		    
		    // NOTA: leerEnteroNoNegativo NO se usa en el flujo de agregar carrito, 
		    // se usa una validación personalizada más estricta en la función 6.

		    // =========================================================
		    // FUNCIONES DE NANI (INVENTARIO Y DINÁMICA)
		    // =========================================================

		    // NANI A5: BÚSQUEDA DE PRODUCTOS
		    public static int buscarIndiceProducto(String nombreBuscado, String[] nombres, int numProductos) {
		        String nombreLimpio = nombreBuscado.trim();
		        for (int i = 0; i < numProductos; i++) {
		            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombreLimpio)) {
		                return i;
		            }
		        }
		        return -1;
		    }

		    // ... [MANTENER REDIMENSIONAMIENTOS IGUALES] ...
		    public static String[] redimensionarArrayString(String[] arrayOriginal, int numElementosActuales, int nuevoTamaño) {
		        String[] nuevoArray = new String[nuevoTamaño];
		        for (int i = 0; i < numElementosActuales; i++) {
		            nuevoArray[i] = arrayOriginal[i];
		        }
		        System.out.println(CYAN + "Array de Nombres redimensionado a tamaño: " + nuevoTamaño + RESET);
		        return nuevoArray;
		    }

		    public static double[] redimensionarArrayDouble(double[] arrayOriginal, int numElementosActuales, int nuevoTamanio) {
		        double[] nuevoArray = new double[nuevoTamanio];
		        for (int i = 0; i < numElementosActuales; i++) {
		            nuevoArray[i] = arrayOriginal[i];
		        }
		        System.out.println(CYAN + "Array de Precios redimensionado a tamaño: " + nuevoTamanio + RESET);
		        return nuevoArray;
		    }

		    public static int[] redimensionarArrayInt(int[] arrayOriginal, int numElementosActuales, int nuevoTamanio) {
		        int[] nuevoArray = new int[nuevoTamanio];
		        for (int i = 0; i < numElementosActuales; i++) {
		            nuevoArray[i] = arrayOriginal[i];
		        }
		        System.out.println(CYAN + "Array de Stock redimensionado a tamaño: " + nuevoTamanio + RESET);
		        return nuevoArray;
		    }


		    // NANI A3: ALTA DE PRODUCTO
		    public static int altaProducto(Scanner sc, String[] nombres, double[] precios, int[] stock, int numProductos) {

		        if (numProductos == nombres.length) {
		            System.out.println(RED + " ERROR: Capacidad del almacén agotada. Redimensione antes de intentar un Alta." + RESET);
		            return numProductos; 
		        }

		        String nuevoNombre = "";
		        int indiceExistente = -1;

		        do {
		            System.out.print(YELLOW + "Introduzca el nombre del nuevo producto: " + RESET);
		            nuevoNombre = sc.nextLine().trim(); 

		            if (nuevoNombre.isEmpty()) {
		                System.out.println(RED + " El nombre del producto no puede estar vacío." + RESET);
		                indiceExistente = 0;
		                continue;
		            }

		            indiceExistente = buscarIndiceProducto(nuevoNombre, nombres, numProductos);

		            if (indiceExistente != -1) {
		                System.out.println(RED + " ERROR: El producto '" + nuevoNombre + "' ya está registrado. Debe introducir uno diferente." + RESET);
		            }
		        } while (indiceExistente != -1);

		        double nuevoPrecio = leerDoublePositivo(sc, "Introduzca el precio unitario (> 0): ");
		        sc.nextLine(); // Consumir salto de línea después de leerDouble

		        int nuevaCantidad = -1;
		        while (nuevaCantidad < 0) {
		             nuevaCantidad = pedirEnteroSeguro(sc, YELLOW + "Introduzca la cantidad disponible en stock (>= 0): " + RESET);
		             if (nuevaCantidad < 0) {
		                 System.out.println(RED + " El stock no puede ser negativo." + RESET);
		             }
		        }
		        sc.nextLine(); // Consumir salto de línea después de leerEntero

		        // Inserción
		        nombres[numProductos] = nuevoNombre;
		        precios[numProductos] = nuevoPrecio;
		        stock[numProductos] = nuevaCantidad;

		        System.out.println(GREEN + "✅ Producto '" + nuevoNombre + "' agregado con éxito en el índice " + numProductos + "." + RESET);

		        return numProductos + 1; 
		    }
		    
		    // SINA B2: MODIFICACIÓN DE PRODUCTO (Opción 3)
		    public static void modificarProducto(Scanner sc, String[] nombres, double[] precios, int[] stock, int numProductos) {
		        if (numProductos == 0) {
		            System.out.println(YELLOW + " El almacén está vacío. No hay productos para modificar." + RESET);
		            return;
		        }

		        consultarProductos(nombres, precios, stock, numProductos);
		        System.out.print(YELLOW + "\nIntroduzca el nombre del producto a modificar: " + RESET);
		        String nombreModificar = sc.nextLine().trim();

		        int indiceModificar = buscarIndiceProducto(nombreModificar, nombres, numProductos);

		        if (indiceModificar == -1) {
		            System.out.println(RED + " ERROR: El producto '" + nombreModificar + "' no se encontró." + RESET);
		            return;
		        }

		        System.out.println(GREEN + "Producto encontrado: " + nombres[indiceModificar] + RESET);

		        // Opciones de modificación
		        System.out.println(CYAN + "\n¿Qué desea modificar?" + RESET);
		        System.out.println("[1] Nombre");
		        System.out.println("[2] Precio");
		        System.out.println("[3] Stock");
		        System.out.println("[4] Todo");
		        System.out.println("[0] Cancelar");
		        
		        int opcionMod = pedirEnteroSeguro(sc, ">> Opción de modificación: ");
		        sc.nextLine(); // Consumir salto de línea

		        boolean modificado = false;

		        switch (opcionMod) {
		            case 1: // Modificar Nombre
		                System.out.print(YELLOW + "Nuevo nombre (Actual: " + nombres[indiceModificar] + "): " + RESET);
		                String nuevoNombre = sc.nextLine().trim();
		                if (!nuevoNombre.isEmpty()) {
		                    if (!nuevoNombre.equalsIgnoreCase(nombres[indiceModificar]) && buscarIndiceProducto(nuevoNombre, nombres, numProductos) != -1) {
		                        System.out.println(RED + " ERROR: El nombre '" + nuevoNombre + "' ya existe. No se modificó el nombre." + RESET);
		                    } else {
		                        nombres[indiceModificar] = nuevoNombre;
		                        modificado = true;
		                    }
		                }
		                break;
		            case 2: // Modificar Precio
		                double nuevoPrecio = leerDoublePositivo(sc, "Nuevo precio (Actual: " + precios[indiceModificar] + "): ");
		                sc.nextLine();
		                precios[indiceModificar] = nuevoPrecio;
		                modificado = true;
		                break;
		            case 3: // Modificar Stock
		                int nuevoStock = -1;
		                while (nuevoStock < 0) {
		                     nuevoStock = pedirEnteroSeguro(sc, YELLOW + "Nuevo stock (Actual: " + stock[indiceModificar] + "): " + RESET);
		                     if (nuevoStock < 0) {
		                         System.out.println(RED + "El stock no puede ser negativo." + RESET);
		                     }
		                }
		                sc.nextLine();
		                stock[indiceModificar] = nuevoStock;
		                modificado = true;
		                break;
		            case 4: // Modificar Todo
		                System.out.print(YELLOW + "Nuevo nombre (Actual: " + nombres[indiceModificar] + "): " + RESET);
		                String nuevoNombreTodo = sc.nextLine().trim();
		                
		                if (!nuevoNombreTodo.isEmpty() && !nuevoNombreTodo.equalsIgnoreCase(nombres[indiceModificar])) {
		                    if (buscarIndiceProducto(nuevoNombreTodo, nombres, numProductos) != -1) {
		                        System.out.println(RED + " ERROR: El nombre '" + nuevoNombreTodo + "' ya existe. No se modificó el nombre." + RESET);
		                    } else {
		                        nombres[indiceModificar] = nuevoNombreTodo;
		                        modificado = true;
		                    }
		                } else if (!nuevoNombreTodo.isEmpty()) {
		                    nombres[indiceModificar] = nuevoNombreTodo;
		                }
		                
		                double nuevoPrecioTodo = leerDoublePositivo(sc, "Nuevo precio (Actual: " + precios[indiceModificar] + "): ");
		                sc.nextLine();
		                precios[indiceModificar] = nuevoPrecioTodo;

		                int nuevoStockTodo = -1;
		                while (nuevoStockTodo < 0) {
		                     nuevoStockTodo = pedirEnteroSeguro(sc, YELLOW + "Nuevo stock (Actual: " + stock[indiceModificar] + "): " + RESET);
		                     if (nuevoStockTodo < 0) {
		                         System.out.println(RED + " El stock no puede ser negativo." + RESET);
		                     }
		                }
		                sc.nextLine();
		                stock[indiceModificar] = nuevoStockTodo;
		                
		                modificado = true;
		                break;
		            case 0:
		                System.out.println(YELLOW + "Modificación cancelada." + RESET);
		                return;
		            default:
		                System.out.println(RED + "Opción inválida. No se realizó ninguna modificación." + RESET);
		                return;
		        }

		        if (modificado) {
		            System.out.println(GREEN + "✅ Producto modificado con éxito." + RESET);
		        } else {
		            System.out.println(YELLOW + "No se realizaron cambios." + RESET);
		        }
		    }

		    // NANI A4: BAJA DE PRODUCTO (opcion 4)
		    public static int bajaProducto(Scanner scanner, String[] nombres, double[] precios, int[] stock, int numProductos) {

		        if (numProductos == 0) {
		            System.out.println(YELLOW + " El almacén está vacío. No hay productos para dar de baja." + RESET);
		            return numProductos;
		        }

		        System.out.print(YELLOW + "Introduzca el nombre del producto a eliminar: " + RESET);
		        String nombreBaja = scanner.nextLine().trim();

		        int indiceEliminar = buscarIndiceProducto(nombreBaja, nombres, numProductos);

		        if (indiceEliminar == -1) {
		            System.out.println(RED + "ERROR: El producto '" + nombreBaja + "' no se encontró en el almacén." + RESET);
		            return numProductos;
		        }

		        String nombreProductoEliminado = nombres[indiceEliminar];

		        // Desplazamiento
		        for (int i = indiceEliminar; i < numProductos - 1; i++) {
		            nombres[i] = nombres[i + 1];
		            precios[i] = precios[i + 1];
		            stock[i] = stock[i + 1];
		        }

		        // Limpieza de la última posición
		        nombres[numProductos - 1] = null;
		        precios[numProductos - 1] = 0.0;
		        stock[numProductos - 1] = 0;

		        numProductos--;

		        System.out.println(GREEN + "✅ Producto '" + nombreProductoEliminado + "' eliminado con éxito. Nuevo stock: " + numProductos + RESET);

		        return numProductos;
		    }

		    // NANI A2: CONSULTA DE PRODUCTOS (Listado / Opción 2 y 5)
		    public static void consultarProductos(String[] nombres, double[] precios, int[] stock, int numProductos) {
		        if (numProductos == 0) {
		            System.out.println(YELLOW + " El almacén está actualmente vacío." + RESET);
		            return;
		        }

		        System.out.println(CYAN + "\n===== CATÁLOGO DE PRODUCTOS (" + numProductos + " artículos disponibles) =====" + RESET);
		        System.out.printf(BLUE + "%-5s %-40s %-12s %s\n" + RESET, "ID", "NOMBRE", "PRECIO (€)", "STOCK");
		        System.out.println("---------------------------------------------------------------------------------");

		        for (int i = 0; i < numProductos; i++) {
		            System.out.printf("%-5d %-40s %-12.2f %d\n",
		                i,
		                nombres[i],
		                precios[i],
		                stock[i]
		            );
		        }
		        System.out.println("---------------------------------------------------------------------------------");
		    }

		 // SINA B4: Agregar Producto al Carrito (Opción 6)
		    /**
		     * return Array de ints con {numArticulosCarrito actualizado, nuevo_o_existente_articulo}
		     */
		    public static int[] agregarProductoAlCarrito(Scanner sc, String[] nombres, double[] precios, int[] stock, int numProductos, int[] carritoIDs, int[] carritoCantidades, int numArticulosCarrito) {
		        
		        System.out.println(MAGENTA + "\n--- Agregar Producto al Carrito ---" + RESET);
		        // LLAMADA CORREGIDA: Pasar el array de precios real
		        consultarProductos(nombres, precios, stock, numProductos); 
		        
		        if (numProductos == 0) { 
		            System.out.println(YELLOW + "El catálogo está vacío. No se puede añadir nada al carrito." + RESET);
		            return new int[]{numArticulosCarrito, -1}; 
		        }

		        // --- LECTURA DE ID ---
		        int idProducto = pedirEnteroSeguro(sc, YELLOW + "Introduzca el ID del producto a agregar: " + RESET);

		        if (idProducto < 0 || idProducto >= numProductos) {
		            System.out.println(RED + " ID de producto inválido." + RESET);
		            return new int[]{numArticulosCarrito, -1};
		        }

		        if (stock[idProducto] <= 0) {
		            System.out.println(RED + " ERROR: El producto '" + nombres[idProducto] + "' está agotado (Stock: 0)." + RESET);
		            return new int[]{numArticulosCarrito, -1};
		        }

		        // --- LECTURA DE CANTIDAD (Validación en bucle) ---
		        int cantidadMax = stock[idProducto]; 
		        int cantidadDeseada = -1;
		        
		        while (cantidadDeseada < 1 || cantidadDeseada > cantidadMax) {
		            cantidadDeseada = pedirEnteroSeguro(sc, YELLOW + "Introduzca la cantidad deseada (1 - " + cantidadMax + "): " + RESET);
		            
		            if (cantidadDeseada < 1) {
		                System.out.println(RED + " Debe pedir al menos 1 unidad." + RESET);
		            } else if (cantidadDeseada > cantidadMax) {
		                System.out.println(RED + " ERROR: Solo quedan " + cantidadMax + " unidades en stock. Intente con una cantidad menor." + RESET);
		            }
		        }
		        
		        // 1. Buscar si el producto ya está en el carrito para sumar la cantidad
		        int indiceCarritoExistente = -1;
		        for (int i = 0; i < numArticulosCarrito; i++) {
		            if (carritoIDs[i] == idProducto) {
		                indiceCarritoExistente = i;
		                break;
		            }
		        }
		        
		        int cantidadActualEnCarrito = (indiceCarritoExistente != -1) ? carritoCantidades[indiceCarritoExistente] : 0;
		        int cantidadTotal = cantidadActualEnCarrito + cantidadDeseada;

		        // 2. Insertar/Actualizar
		        if (indiceCarritoExistente != -1) {
		            // Producto ya estaba: sumar cantidad
		            carritoCantidades[indiceCarritoExistente] = cantidadTotal;
		            System.out.println(GREEN + "✅ Cantidad de '" + nombres[idProducto] + "' actualizada a " + cantidadTotal + " unidades." + RESET);
		            return new int[]{numArticulosCarrito, indiceCarritoExistente};
		        } else {
		            // Producto nuevo: añadir al final 
		            if (numArticulosCarrito >= carritoIDs.length) {
		                System.out.println(RED + " El carrito no puede almacenar más tipos de artículos. Finalice la compra o elimine uno existente." + RESET);
		                return new int[]{numArticulosCarrito, -1};
		            }
		            carritoIDs[numArticulosCarrito] = idProducto;
		            carritoCantidades[numArticulosCarrito] = cantidadDeseada;
		            System.out.println(GREEN + "✅ Producto '" + nombres[idProducto] + "' añadido (" + cantidadDeseada + " unidades)." + RESET);
		            return new int[]{numArticulosCarrito + 1, numArticulosCarrito};
		        }
		    }
		    
		    // SINA B4: Ver Carrito Actual (Opción 7)
		    public static void verCarrito(String[] nombres, double[] precios, int[] carritoIDs, int[] carritoCantidades, int numArticulosCarrito) {
		        System.out.println(YELLOW + "\n--- TU CARRITO ACTUAL ---" + RESET);
		        if (numArticulosCarrito == 0) {
		            System.out.println("El carrito está vacío.");
		            return;
		        }

		        double totalSinIVA = 0;
		        
		        System.out.printf(BLUE + "%-5s %-40s %-10s %-15s %s\n" + RESET, "LINEA", "NOMBRE", "CANT.", "PRECIO UNIT. (€)", "SUBTOTAL (€)");
		        System.out.println("-----------------------------------------------------------------------------------");

		        for (int i = 0; i < numArticulosCarrito; i++) {
		            int index = carritoIDs[i];
		            int cantidad = carritoCantidades[i];
		            double subtotalLinea = precios[index] * cantidad;
		            
		            totalSinIVA += subtotalLinea;
		            
		            System.out.printf("%-5d %-40s %-10d %-15.2f %.2f\n",
		                i + 1, // Número de línea 
		                nombres[index],
		                cantidad,
		                precios[index],
		                subtotalLinea
		            );
		        }

		        double iva = totalSinIVA * IVA_APLICADO;
		        double totalConIVA = totalSinIVA * (1 + IVA_APLICADO);

		        // Formato corregido y estable
		        System.out.println("-----------------------------------------------------------------------------------");
		        System.out.println(CYAN + String.format("Total Subtotal (Sin IVA): %49s €%.2f", "", totalSinIVA) + RESET);
		        System.out.println(CYAN + String.format("IVA (%.0f%%): %65s €%.2f", IVA_APLICADO * 100, "", iva) + RESET);
		        System.out.println(GREEN + String.format("TOTAL A PAGAR (Con IVA): %50s €%.2f", "", totalConIVA) + RESET);
		    }
		    
		    // SINA B5: Finalizar Compra y Pagar (Opción 8)
		    public static int finalizarCompra(String[] nombres, double[] precios, int[] stock, int[] carritoIDs, int[] carritoCantidades, int numArticulosCarrito) {
		        System.out.println(MAGENTA + "\n--- FINALIZANDO COMPRA ---" + RESET);
		        
		        if (numArticulosCarrito == 0) {
		            System.out.println(YELLOW + "El carrito está vacío. No hay transacción que finalizar." + RESET);
		            return 0; 
		        }

		        // 1. Mostrar Desglose/Factura
		        verCarrito(nombres, precios, carritoIDs, carritoCantidades, numArticulosCarrito); 

		        // 2. ACTUALIZACIÓN DE STOCK
		        System.out.println(CYAN + "\nActualizando inventario..." + RESET);
		        for (int i = 0; i < numArticulosCarrito; i++) {
		            int indexProducto = carritoIDs[i];
		            int cantidadVendida = carritoCantidades[i];
		            
		            stock[indexProducto] -= cantidadVendida;
		            System.out.println(GREEN + "  - Descontadas " + cantidadVendida + " uds. de " + nombres[indexProducto] + ". Stock restante: " + stock[indexProducto] + RESET);
		        }
		        
		        // 3. RESETEAR CARRITO

		        System.out.println(GREEN + "\n===========================" + RESET);
		        System.out.println(GREEN + "✅ TRANSACCIÓN COMPLETADA." + RESET);
		        System.out.println(GREEN + "──────▄▀▄─────▄▀▄\r\n"
						+ "─────▄█░░▀▀▀▀▀░░█▄\r\n"
						+ "─▄▄──█░░░░░░░░░░░█──▄▄\r\n"
						+ "█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█\r\n"
						+ "");
		        System.out.println(GREEN + "¡Gracias por su compra!                           " + RESET);
		        System.out.println(GREEN + "===========================" + RESET);
		      
		        
		        return 0; // El nuevo número de artículos en el carrito es cero
		    }
		    }