/**
 *
 * @author bgher
 */
public class PROG02_Ejerc1 {

    public static void main(String[] args) {
         // Al ser una constante el nombre se poner en mayúsculas y usamos final delante del tipo
         final int NUM = 5000; 
         // Utilizo boolean poder tomar solo el valor true o false
         boolean carnet = true;
         //Al ser solo 12 el máximo, usamos byte
         byte numMes = 10; 
         // Es una cadena de caracteres, se utiliza String
         String nombre = "Ana Garcia";
         // Declaro un enumerado con dos valores posible M, V
         enum sexo { M, V };
         sexo ana = sexo.M;
         // Utilizo long al ser un número muy grande
         long milisegundos = 1671408000;
         // Utilizo double por poder contener decimales, y por si tiene mucho saldo
         double saldo = 5879.25;
         // Es un número entero grande
         long distTierraJupiter = 965600000;
         
         // Imprimo todos los valores
         System.out.printf("Valor máximo no modificable: %d\n", NUM);
         System.out.printf("¿Tiene usted carnet de conducir? %s\n", carnet);
         System.out.printf("Estamos en el mes número: %d\n", numMes);
         System.out.printf("Mi nombre es: %s\n", nombre);
         System.out.printf("Mi sexo es: %s\n", ana);
         System.out.printf("Han transcurrido %d milisegundes desde 01/01/1970 \n", milisegundos);
         System.out.printf("Mi saldo en el banco es: " +saldo+" €\n");
         System.out.printf("La distancia de la Tierra a Júpiter es: " + distTierraJupiter + " kilometros \n");
    }
}
