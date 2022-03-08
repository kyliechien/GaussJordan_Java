import java.util.Arrays;
import java.util.Scanner;

public class GaussJordan {

    private int numberOfRow = 0;
    private int numberOfColumn = 0;
    final private int lastEqual = 1;
    private float[][] matrix; // divide might be decimal
    private int pointerOfRow;
    private int pointerOfColumn;


    GaussJordan(){}


    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }


    public void setNumberOfColumn(int numberOfColumn) {
        this.numberOfColumn = numberOfColumn;
    }


    public void setMatrix() {
        Scanner sc = new Scanner(System.in);
        matrix = new float[numberOfRow][numberOfColumn + lastEqual];
        for(int row = 0; row < numberOfRow; row++){
            String oneEquation = sc.nextLine();
            String[] depart = oneEquation.split(" ");
            for(int column = 0; column < numberOfColumn + lastEqual; column++){
                matrix[row][column] = Float.parseFloat(depart[column]);
            }
        }
    }

    public void swapTheEquation(int row1, int row2){
        float[] temp = new float[numberOfColumn + lastEqual];
        System.arraycopy(matrix[row1], 0, temp, 0, numberOfColumn  + lastEqual);

        if (numberOfColumn >= 0) System.arraycopy(matrix[row2], 0, matrix[row1], 0, numberOfColumn  + lastEqual);

        if (numberOfColumn >= 0) System.arraycopy(temp, 0, matrix[row2], 0, numberOfColumn  + lastEqual);
    }

    public void divideToOne(){
        float dividend = matrix[pointerOfRow][pointerOfColumn];
        for(int column = pointerOfColumn; column < numberOfColumn + lastEqual; column++){
            matrix[pointerOfRow][column] /= dividend;
        }
    }

    public void minusTheRow(){
        float dividend = matrix[pointerOfRow][pointerOfColumn];
        float times;
        for(int row = 0; row < numberOfRow; row++){
            if(row == pointerOfRow){
                continue;
            }
            times = matrix[row][pointerOfColumn] / dividend;
            for(int column = pointerOfColumn; column < numberOfColumn + lastEqual; column++) {
                matrix[row][column] -= matrix[pointerOfRow][column] * times;
            }
        }
    }

    public void moveCursor(){
            pointerOfRow++;
            pointerOfColumn++;

            while((pointerOfRow < numberOfRow && pointerOfColumn < numberOfColumn) && matrix[pointerOfRow][pointerOfColumn] == 0) {
                pointerOfColumn++;
            }

    }

    public int findNotZero() {
        int row = pointerOfRow + 1;
        while(row < numberOfRow && matrix[row][pointerOfColumn] == 0){
            row++;
        }
        return row;
    }

    public void startGaussJordan(){
        pointerOfRow = 0;
        pointerOfColumn = 0;
        while(pointerOfRow < numberOfRow && pointerOfColumn < numberOfColumn) {
            if (matrix[pointerOfRow][pointerOfColumn] == 0) {
                swapTheEquation(pointerOfRow, findNotZero());
                out();
            }
            divideToOne();
            minusTheRow();
            moveCursor();
           out();
        }

    }

    public void out(){
        String output = "";
        for(int row = 0; row < numberOfRow; row++){
            for(int column = 0; column < numberOfColumn + lastEqual; column++){
                output = output + matrix[row][column] + " ";
                if((column+1) % (numberOfColumn + lastEqual) == 0){
                    output = output + "\n";
                }
            }
        }
        System.out.println(output+"--------");
    }
}
