/**
 *
 * @author bgher
 */
public class PROG02_Ejerc8 {

    public static void main(String[] args) {
        
        int alum_prog = 32;
        int alum_ed = 45;
        int alum_bd = 89;
        int total_alum = alum_prog + alum_ed + alum_bd;
        
        System.out.println(" Los alumnos matriculados en programación son el " + (float)((alum_prog*100)/total_alum) + "% del total.");
        System.out.println(" Los alumnos matriculados en entorno de desarrollo son el " + (float)((alum_ed*100)/total_alum) + "% del total.");
        System.out.println(" Los alumnos matriculados en base de datos son el " + (float)((alum_bd*100)/total_alum) + "% del total.");
        
    }
}
