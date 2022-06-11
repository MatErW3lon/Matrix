package Matrix.io;
import Matrix.Matrix;

/**
 * This is an exception thrown when two matrices of different sizes are added to each other
 * The addition is element wise and if the sizes are different, an exception is raised
 */
public class IllegalAdditionException extends Exception{

    public IllegalAdditionException(Matrix m1, Matrix m2){
        super(buildExceptionMessage(m1, m2));
    }

    private static String buildExceptionMessage(Matrix m1, Matrix m2) {
        return "Attempt to add matrix of size " + m1.getSize() + " with matrix of size " + m2.getSize();
    }    
}
