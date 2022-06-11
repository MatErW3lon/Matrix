package Matrix;
import Matrix.io.*;
import java.util.Random;
/**
 * Matrix
 */
public class Matrix{

    private double[][] matrix;
    private static Random rn;
    static{
        rn = new Random();
    }

    public Matrix(int rows, int columns) throws IllegalBoundsException{
        //check for bounds 
        if(columns <= 0 || rows <= 0){
            throw new IllegalBoundsException(columns, rows);
        }

        //initialize the matrix
        matrix = new double[rows][columns];
    }

    public void randomInit(){
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = Matrix.rn.nextInt();
            }
        }
    }

    public void setElement(int row, int column, double value){
        matrix[row][column] = value;
    }

    public double getElement(int row, int column){
        return matrix[row][column];
    }

    public Matrix add(Matrix matrixToAdd) throws IllegalAdditionException{
        try{
            Matrix answer = new Matrix(matrix.length, matrix[0].length);
            if(!this.getSize().equals(matrixToAdd.getSize())){
                throw new IllegalAdditionException(this, matrixToAdd);
            }
            for(int row = 0; row < matrix.length; row++){
                for(int column = 0; column < matrix[0].length; column++){
                    answer.matrix[row][column] = this.matrix[row][column] + matrixToAdd.matrix[row][column]; 
                }
            }
            return answer;
        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }

    public Matrix subtract(Matrix matrixToSub) throws IllegalSubtractionException{
        try{
            Matrix answer = new Matrix(matrix.length, matrix[0].length);
            if(!this.getSize().equals(matrixToSub.getSize())){
                throw new IllegalSubtractionException(this, matrixToSub);
            }
            for(int row = 0; row < matrix.length; row++){
                for(int column = 0; column < matrix[0].length; column++){
                    answer.matrix[row][column] = this.matrix[row][column] - matrixToSub.matrix[row][column];
                }
            }
            return answer;
        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }

    public Matrix multiply(Matrix matrixToMultiply) throws IllegalMultiplcationException{
        try{
            Matrix answer = new Matrix(matrix.length, matrixToMultiply.matrix[0].length);
            if(matrix[0].length != matrixToMultiply.matrix.length){
                throw new IllegalMultiplcationException(this, matrixToMultiply);
            }
            int thisRowPtr = 0, thisColPtr = 0, otherRowPtr = 0, otherColPtr = 0;
            
            //current ptrs of the answer matrix
            int ansRowPtr = 0, ansColPtr = 0;
            while(thisRowPtr < matrix.length){
                while(otherColPtr < matrixToMultiply.matrix[0].length){
                    int sum = 0;
                    thisColPtr = 0;
                    otherRowPtr = 0;
                    while(thisColPtr < matrix[0].length){
                        sum += matrix[thisRowPtr][thisColPtr] * matrixToMultiply.matrix[otherRowPtr][otherColPtr];
                        thisColPtr++; otherRowPtr++;
                    }
                    answer.matrix[ansRowPtr][ansColPtr] = sum;
                    otherColPtr++; ansColPtr++;
                }
                otherColPtr = 0; ansColPtr = 0;
                thisRowPtr++; ansRowPtr++;
            }
            return answer;

        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }

    public Matrix scalarMultiplyNew(double scalar){
        try{
            Matrix answer = new Matrix(matrix.length, matrix[0].length);
            for(int i=0; i < matrix.length; i++){
                for(int j=0; j < matrix[0].length; j++){
                    answer.matrix[i][j] = matrix[i][j] * scalar;
                }
            }
            return answer;
        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }

    public void scalarMultiplyInPlace(double scalar){
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] * scalar;
            }
        }
    }

    public Matrix transpose(){
        try{
            Matrix answer = new Matrix(matrix[0].length, matrix.length);
            int thisRowPtr = 0, thisColPtr = 0, ansRowPtr = 0, ansColPtr = 0;
            while(thisRowPtr < matrix.length){
                thisColPtr = 0; ansRowPtr = 0;
                while(thisColPtr < matrix[0].length){
                    answer.matrix[ansRowPtr][ansColPtr] = matrix[thisRowPtr][thisColPtr];
                    thisColPtr++; ansRowPtr++;
                }
                thisRowPtr++; ansColPtr++;
            }
            return answer;
        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }
    
        public Matrix flattenRowMajor(){
        try{
            Matrix answer = new Matrix(1, matrix.length * matrix[0].length);
            final int ansRowPtr = 0;
            int ansColPtr = 0;
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    answer.matrix[ansRowPtr][ansColPtr] = matrix[i][j];
                    ansColPtr++;
                }
            }
            return answer;
        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }

    public Matrix flattenColumnMajor(){
        try{
            Matrix answer = new Matrix(matrix.length * matrix[0].length, 1);
            final int ansColPtr = 0;
            int ansRowPtr = 0;
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    answer.matrix[ansRowPtr][ansColPtr] = matrix[i][j];
                    ansRowPtr++;
                }
            }
            return answer;
        }catch(IllegalBoundsException illegalBoundsException){
            illegalBoundsException.printStackTrace();
            return null;
        }
    }

    public String getSize(){
        String buildSizeString = matrix.length + " x " + matrix[0].length;
        return buildSizeString;
    }

    public int getRows(){
        return matrix.length;
    }

    public int getColumns(){
        return matrix[0].length;
    }

    @Override
    public String toString(){
        String representationBuilder = "";
        for(int i = 0 ; i < matrix.length; i++){
            representationBuilder += "|\t";
            for(int j = 0; j < matrix[0].length; j++){
                representationBuilder += "" + matrix[i][j] + "\t";
            }
            representationBuilder += "|\n";
        }
        return representationBuilder;
    }
}
