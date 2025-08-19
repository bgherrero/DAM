package ejerc1;

/**
 *
 * @author bgher
 */
public class Principal {

    
    public static void main(String[] args) {
        
        Fecha objFecha1 = new Fecha(enumMes.mayo);
        objFecha1.setDia(5);
        objFecha1.setAño(2000);
        
        System.out.println("Primera fecha, inicializada con el primer constructor");
        System.out.println("La fecha es: " + objFecha1.toString());
        System.out.println(objFecha1.isSummer()? "Es verano" : "No es verano");
        
        
        Fecha objFecha2 = new Fecha(15, enumMes.agosto, 2500);
        System.out.println("\nLa fecha 2 contiene el año " + objFecha2.getAño());
        System.out.println("La fecha es: " + objFecha2.toString());
        System.out.println(objFecha2.isSummer()? "Es verano" : "No es verano");
        
    }
}
