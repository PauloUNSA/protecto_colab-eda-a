package ejercicio_3_colas;
import myExceptions.ExceptionIsEmpty;

public class pruebas {


    public static void main(String[] args) throws ExceptionIsEmpty {
        queueLink lista=new queueLink();
        System.out.println("la cola esta vacia\n"+lista.inEmpty());
        lista.enqueue(12);
        lista.enqueue(123);
        lista.enqueue(153);
        lista.enqueue(3);
        lista.enqueue(13);
        lista.enqueue(22);
        lista.enqueue(45);
        System.out.println("mostrar cola\n" +lista);
        System.out.println("la cola esta vacia\n"+lista.inEmpty());
        System.out.println("mostrar primer elemento de la cola\n"+lista.front());
        lista.denqueue();
        System.out.println("se elimino un elemento de la cola");
        System.out.println(lista);
        System.out.println("mostrar ultimo elemento de la cola\n"+lista.back());
    }
}
