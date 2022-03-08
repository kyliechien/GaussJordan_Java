import java.util.Arrays;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args){
        GaussJordan gaussJordan = new GaussJordan();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("please input the number of variables");
            gaussJordan.setNumberOfColumn(sc.nextInt());
            System.out.println("please input the number of equations");
            gaussJordan.setNumberOfRow(sc.nextInt());
            System.out.println("input augmented matrix, split with space");
            gaussJordan.setMatrix();
            gaussJordan.out();
            gaussJordan.startGaussJordan();
            System.out.println("next turn? Y/N");

        }while(sc.next().equalsIgnoreCase("Y"));

    }
}
