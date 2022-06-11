package Matrix.io;

public class IllegalBoundsException extends Exception{
    public IllegalBoundsException(int width, int height){
        super("the size " + width + " x " + height + " is not a valid matrix size");
    }
}
