/**
 *
 * @author bgher
 */
public class PROG02_Ejerc6 {
    // Creo la clase enumerada de razas de perros
    enum razaPerros{ Mastín, Terrier, Bulldog, Pekines, Caniche, Galgo}
    
    public static void main(String[] args) {
        // Declaro las dos varibles
       razaPerros var1 = razaPerros.Bulldog;
       razaPerros var2 = razaPerros.Caniche;
       // Comparo las dos variables
       System.out.printf("La raza de var1 es %s, y la raza var2 es %s \n", var1, var2);
       System.out.printf("var1.equals(var2) es %b\n", var1.equals(var2));
       // Muestro la posición de cada variable, tener en cuenta que empieza a contar por el 0
       System.out.printf("var1.ordinal()= " + var1.ordinal());
       System.out.printf("\nvar2.ordinal()= " + var2.ordinal());
       
     }
}
