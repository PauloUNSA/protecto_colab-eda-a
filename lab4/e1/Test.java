import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        ListaDoble<Integer> listaDoble = generarPeorCaso(10);
        System.out.println(listaDoble);
        insertionSort(listaDoble);
        System.out.println(listaDoble);
        /*int tamano;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño máximo del último arreglo: ");
        tamano = teclado.nextInt();

        ArrayList<int[]> casos = new ArrayList<int[]>();
        String archivoInsercion = "insercion.txt";
        PrintWriter oS = new PrintWriter(archivoInsercion);

        for (int n = 1; n <= tamano; n++) {
            casos.add(generarPeorCaso(n));
        }
        Iterator<int[]> puntero = casos.iterator();
        while (puntero.hasNext()) {
            oS.println(String.valueOf(insertionSort(puntero.next())));
        }
        oS.close();
        // plot "/Users/richarteq/eclipse-workspace/Algoritmica/insercion.txt" with lines
        /*JavaPlot p = new JavaPlot();
        p.addPlot("\"/Algoritmica/insercion.txt\" with lines");
        p.plot();*/
    }

    public static long insertionSort(ListaDoble<Integer> lista) {
        Node<Integer> keyNode;
        Node<Integer> currentNode;
        long nano_startTime = System.nanoTime();
        if (!lista.isEmpty()) {
            keyNode = lista.getInicio().getNextNode();
            while (keyNode != null) {
                Integer key = keyNode.getData();
                currentNode = keyNode.getPreviousNode();
                while (currentNode != null && currentNode.getData() > key) {
                    currentNode.getNextNode().setData(currentNode.getData());
                    currentNode = currentNode.getPreviousNode();
                }
                if (currentNode == null) {
                    lista.getInicio().setData(key);
                } else {
                    currentNode.getNextNode().setData(key);
                }

                keyNode = keyNode.getNextNode();
            }
        }
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
    public static ListaDoble<Integer> generarPeorCaso(int tamanio) {
        ListaDoble<Integer> listaDoble = new ListaDoble<>();
        for (int i = 0; i < tamanio; i++) {
            listaDoble.addFinal(tamanio - i);
        }
        return listaDoble;
    }
}
