package Matrix.io;
import Matrix.Matrix;

public class IllegalMultiplcationException extends Exception{
    public IllegalMultiplcationException(Matrix m1, Matrix m2){
        super(buildExceptionMessage(m1, m2));
    }

    private static String buildExceptionMessage(Matrix m1, Matrix m2) {
        return "Attempt to multiply matrix of size " + m1.getSize() + " with matrix of size " + m2.getSize();
    } 
}
