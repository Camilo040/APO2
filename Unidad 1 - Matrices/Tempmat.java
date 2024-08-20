import java.util.Random;
public class Tempmat {
    public static void main(String[] args) {
        Random num_ram = new Random();
        int i;
        int[][] tabla;
        final int filas = 101, cols = 6;
        tabla = new int[filas][cols];

        System.out.println("Bogota     Cali       Medellin   Pasto      Barranquilla  Manizales");

        for(i=0; i<filas; i++)
        {
                tabla[i][0] = tabla[i][0] = (int) num_ram.nextDouble(30) + 10;
                tabla[i][1] = tabla[i][0] = (int) num_ram.nextDouble(30) + 10;
                tabla[i][2] = tabla[i][0] = (int) num_ram.nextDouble(30) + 10;
                tabla[i][3] = tabla[i][0] = (int) num_ram.nextDouble(30) + 10;
                tabla[i][4] = tabla[i][0] = (int) num_ram.nextDouble(30) + 10;
                tabla[i][5] = tabla[i][0] = (int) num_ram.nextDouble(30) + 10;

                System.out.println(tabla[i][0] +"         "+ tabla[i][1] +"         "+ tabla[i][2] +"         "+ tabla[i][3] +"         "+ tabla[i][4] +"            "+ tabla[i][5]);
        }

    }
}