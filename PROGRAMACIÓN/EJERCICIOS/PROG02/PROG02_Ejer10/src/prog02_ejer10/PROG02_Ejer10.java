/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog02_ejer10;

/**
 *
 * @author bgher
 */
public class PROG02_Ejer10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        int j = (int)(i*x);
        System.out.println( "Producto de int por float: j = i * x = " + j);
        double dx = 2.0;
        double dz = dx * y;              
        System.out.println( "Producto de float por double: dz = dx * y = " + dz);
        
        System.out.println("------- Operaciones con byte -------");
        byte bx = 5;
        byte by = 2;
        byte bz = (byte)(bx - by);        
        System.out.printf( "byte: %d - %d = %d \n", bx, by, bz);
        bx = -128;
        by = 1;
        bz = (byte)(bx - by); //byte
        System.out.printf( "byte: %d - %d = %d \n", bx, by, bz);
        int bm = bx - by; //int
        System.out.printf( "(int)( %d - %d) = %d \n", bx, by, bm);
        
        System.out.println("------- Operaciones con short -------");
        short sx = 5;
        short sy = 2;
        short sz = (short)(sx - sy);
        System.out.printf( "short: %d - %d = %d \n", sx, sy, sz);
        sx = 32767;
        sy = 1;
        sz = (short)(sx + sy);
        System.out.printf( "short: %d + %d = %d \n", sx, sy, sz);
        
        System.out.println("------- Operaciones con char -------");
        char cx = '\u000F'; // 15
        char cy = '\u0001'; // 1
        int z = cx - cy;
        System.out.printf( "char: - = %d \n", z);
        z = cx - 1;
        System.out.printf( "char(0x000F) - 1 = %d \n", z);
        
        cx = '\uFFFF'; //65535
        z = cx;
        System.out.printf(("(int)( ) = %d \n"), z);
        sx = (short)cx;
        System.out.printf(("(short)( ) = %d \n"), sx);
        sx = -32768;
        cx = (char)sx;
        z = cx;
        System.out.printf(("-32768 short-char-int = %d \n"), z);
        sx = -1;
        cx = (char)sx;
        z = cx;
        System.out.printf(("-1 short-char-int = %d \n"), z);      
        
    }
    
}
