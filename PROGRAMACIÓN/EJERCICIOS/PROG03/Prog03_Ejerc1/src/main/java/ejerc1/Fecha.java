package ejerc1;
/**
 *
 * @author bgher
 */
enum enumMes { enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre};

public class Fecha{
    
    // Determino los atributos de Fecha
    private int dia;
    private enumMes mes;
    private int año;
    
    // Declaro los métodos constructores
    public Fecha (enumMes mes){
        this.mes = mes;
        this.dia = 0;
        this.año = 0;        
    }    
    public Fecha (int dia, enumMes mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    // Implemento los métodos get y set
    public int getDia(){
        return dia;
    }
    public enumMes getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
    public void setMes(enumMes mes){
        this.mes = mes;
    }
    public void setAño(int año){
        this.año = año;
    }
    
    // Método que nos dice si es verano o no
    public boolean isSummer(){
        if ( this.mes == enumMes.junio && this.dia >= 21 
                || this.mes == enumMes.julio
                || this.mes == enumMes. agosto
                || this.mes == enumMes.septiembre & this.dia < 21){
            return true;
        }
        else{
            return false;
        }
    }
    
    // Método que nos devuelve la fecha en formato largo
    public String toString(){
        return dia + " de " + mes + " de " + año;
    }
}


