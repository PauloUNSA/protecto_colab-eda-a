public class pruebas {


    public static void main(String[] args) {
        queueLink lista=new queueLink();
        System.out.println(lista.inEmpty());
        lista.enqueue(12);
        lista.enqueue(123);
        lista.enqueue(153);
        lista.enqueue(3);
        lista.enqueue(13);
        lista.enqueue(22);
        lista.enqueue(45);
        System.out.println(lista);
        System.out.println(lista.inEmpty());
        System.out.println(lista.front());
        lista.denqueue();
        lista.enqueue(15515);
        System.out.println(lista);
        System.out.println(lista.back());
        System.out.println(lista.front());
        System.out.println(lista.inEmpty());
        lista.denqueue();
        lista.enqueue(111);
        System.out.println(lista.inEmpty());
        System.out.println(lista.front());
        System.out.println(lista.back());

    }

}
