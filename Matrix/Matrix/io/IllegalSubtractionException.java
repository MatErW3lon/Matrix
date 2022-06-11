package Matrix.io;
import Matrix.Matrix;

public class IllegalSubtractionException extends Exception{
    public IllegalSubtractionException(Matrix m1, Matrix m2){
        super(buildExceptionMessage(m1, m2));
    }

    private static String buildExceptionMessage(Matrix m1, Matrix m2) {
        return "Attempt to subtract matrix of size " + m1.getSize() + " with matrix of size " + m2.getSize();
    }    
}
