package ejercicio_3_colas;
import myExceptions.ExceptionIsEmpty;

public interface cola <E>{
    public void enqueue (E x);
    public E dequeue() throws ExceptionIsEmpty;
    public E front() throws ExceptionIsEmpty;
    public E back() throws ExceptionIsEmpty;
    public boolean inEmpty();
}
