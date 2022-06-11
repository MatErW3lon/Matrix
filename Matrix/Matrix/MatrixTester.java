package Matrix;
import Matrix.io.IllegalBoundsException;
import Matrix.io.IllegalMultiplcationException;
import java.util.Scanner;
/**
 * MatrixTester
 * Access Specifier: Package Access
 * For testing the classes Matrix and io only
 */
class MatrixTester {

    public static void main(String[] args){
        try{
            //testMultiply();
            testTranspose();        
        }catch(Exception e){
            e.printStackTrace();
        }
    }   

    public static void testTranspose() throws IllegalBoundsException{
        Scanner in = new Scanner(System.in);
        Matrix myMatrix1 = new Matrix(3, 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                myMatrix1.setElement(i, j, in.nextInt());
                in.nextLine();
            }
        }
        System.out.println(myMatrix1);

        System.out.println("AFTER TRANSPOSE");
        System.out.println(myMatrix1.transpose());
        in.close();
    }
    
    public static void testMultiply() throws IllegalBoundsException, IllegalMultiplcationException{
        Scanner in = new Scanner(System.in);
        
        Matrix myMatrix1 = new Matrix(3, 2);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                myMatrix1.setElement(i, j, in.nextInt());
                in.nextLine();
            }
        }
        System.out.println(myMatrix1);


        Matrix myMatrix2 = new Matrix(2, 2);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                myMatrix2.setElement(i, j, in.nextInt());
                in.nextLine();
            }
        }
        System.out.println(myMatrix2);

        System.out.println(myMatrix1.multiply(myMatrix2));

        in.close();
    }
}