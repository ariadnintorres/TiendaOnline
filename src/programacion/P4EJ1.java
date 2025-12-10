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
		System.out.println("Bienvenido a la Tienda Online ");
	    System.out.println("");
		String productos[];
		
	
		int n = 1;
		do {
			mostrarMenu();
			 
		      
		      //agregar producto
		    
		   			
			    System.out.println(BLUE + "#############################################" + RESET);
                System.out.println(BLUE + "#                                           #" + RESET);
                System.out.println(BLUE + "#  " + YELLOW + "╔═╗┬ ┬┌─┐┌─┐┬  ┌─┐┬  ┬" + BLUE + "                   #" + RESET);
                System.out.println(BLUE + "#  " + YELLOW + "╚═╗└┬┘├┤ ├┤ │  ├─┤└┐┌┘" + BLUE + "THE LEGEND OF ARIA #" + RESET);
                System.out.println(BLUE + "#  " + YELLOW + "╚═╝ ┴ └─┘└  ┴─┘┴ ┴ └┘ " + BLUE + "                   #" + RESET);
                System.out.println(BLUE + "#                                           #" + RESET);
                System.out.println(BLUE + "#    " + CYAN + "Un juego épico de aventuras y magia" + BLUE + "    #" + RESET);
                System.out.println(BLUE + "#                                           #" + RESET);
                System.out.println(BLUE + "#############################################" + RESET);
                System.out.println();
                System.out.println(GREEN + ">> Pulsa ENTER para iniciar..." + RESET);
			
                
                
                
			n=0;
			
		} while (n!=0);
}

public static void mostrarMenu() {
   System.out.println("menu de productos");
}


public static void agregarProducto(Scanner sc) {
    
  
}
		
		
		

	}

