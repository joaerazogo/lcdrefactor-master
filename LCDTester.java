import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

    // Establece los segmentos de cada numero
    List<String> listaComando = new ArrayList<>();
    
    //Declaración de variables
    
    String comando;
    int espacioDig;
    String opcion;
    String opcionsi = "s";
    String opcionno = "n";
    String NumeroADibujar;
    System.out.println("This is a line in java");

    int a;
      
      try {

          try (Scanner lector = new Scanner(System.in)) {
            while(true){
            	
                System.out.println("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero
                if (ImpresorLCD.isNumeric(comando)) 
                {
	                    espacioDig = Integer.parseInt(comando);
	                    
	                    // se valida que el espaciado este entre 0 y 5
	                    if(espacioDig <0 || espacioDig >5)
	                    {
		                       System.out.println("El espacio entre digitos debe estar entre 0 y 5");
		                       System.out.println();
		                       continue;
	                    }
                    
                    
                } 
                else 
                {
	                	System.out.println("Error: Cadena " + comando + " no es un entero");
	                    continue;
                }
                
                do
                {
	                    System.out.print("Entrada: ");
	                    Scanner entradaNumero = new Scanner(System.in);
	                    NumeroADibujar = entradaNumero.next();
	                    
	                    // se valida que la cadena ingresada no sea igual a 0,0
	                    //En caso de ingresar un caracter diferente a la coma como un ., ^, ~, etc habrá una excepción y terminará el programa
	                    if(!NumeroADibujar.equalsIgnoreCase(CADENA_FINAL))
	                    {
	                    	String[] parametros;
                    		parametros = NumeroADibujar.split(",");                    	
                    		int ParteEntera=Integer.parseInt(parametros[0]);
                    		int ParteDecimal=Integer.parseInt(parametros[1]);
                    		
                    		// se valida que el caracter ingresado contenga la , y que sea un número
	                    	if (NumeroADibujar.contains(",") && !ImpresorLCD.isNumeric(NumeroADibujar)) {
	                    		
		                    		
	                    		
		                    		System.out.println(parametros[0] + " " + parametros[1]);
		                    		
		                    		//Valida la cantidad de parametros
	                    		    if(parametros.length>2)
		                    		      {
	                    		    			System.out.println("Cadena " + comando + " contiene mas caracter ,");
	                    		    			continue;
		                    		      }
	                    		        
	                    		    //Valida la cantidad de parametros
   	                    		    if(parametros.length<2)
		                    		       {
   	                    		    			System.out.println("Cadena " + comando + " no contiene los parametros requeridos");
   	                    		    			continue;
		                    		       }
   	                    		    //Valida que la parte entera esté entre 1 y 10 
	                    		    if(ParteEntera<1 || ParteEntera>10)
		                    		       {
	                    		    			System.out.println("El parametro size ["+ ParteEntera + "] debe estar entre 1 y 10");
	                    		    			continue;
		                    			   }
	                    			
	                    	ImpresorLCD impresorLCD = new ImpresorLCD(); 
	                    		  
	                    	//Llamado a la función imprimirNumero que dibujará la parte decimal con su tamaño (parte entera) en la consola
	                    	impresorLCD.imprimirNumero(ParteEntera, parametros[1], espacioDig); 
	                    	}
	                    	else{
                    		
		                    		System.out.println("Cadena " + comando + " no es un número que contiene el caracter , y no se podrá dibujar ");
		                    		continue;
	                    	}
	                    }
	                    else{
	                    	System.out.println("Has finalizado, ¿deseas continuar?, presiona s si quieres continuar y n si no deseas continuar");
	                    	
	                    	do{
	                    			Scanner eleccion = new Scanner(System.in);
	                    			opcion = eleccion.next();
	                    			
	                    			//Valida que no desea continuar el programa
			                    	if(opcion.equals(opcionno)){
			                    		System.out.println("Has decidido no continuar");
			                    		System.exit(0);
			                    	}
			                    	//Valida que si desea continuar el programa
			                    	else if(opcion.equals(opcionsi)){
			                    		System.out.println("Has decidido continuar");
			                    		break;
			                    	}
			                    	//En caso de ingresar mal la opción, repote el mensaje 
			                    	else{
			                    		System.out.println("Has ingresado mal la opción, por favor vuelve a intentar");
			                    	}
	                    	}while(!opcion.equals(opcionno) || !opcion.equals(opcionsi));
	                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
           }
        }
      } 
      //Excepción que captura cuando se ingresa por pantalla un símbolo 
      catch (Exception ex) 
      {
            System.out.println("Error: "+ex.getMessage() + " has digitado mal, por ende finaliza el programa");
      }
   }
}
