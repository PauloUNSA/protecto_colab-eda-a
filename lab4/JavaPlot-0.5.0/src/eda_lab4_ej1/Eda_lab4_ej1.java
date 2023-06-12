package eda_lab4_ej1;

import com.panayotis.gnuplot.JavaPlot;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Eda_lab4_ej1 {


    public static void main(String[] args) throws FileNotFoundException {
        
        int tamano;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño máximo de la ultima lista: ");
        tamano = teclado.nextInt();
        ArrayList<NodeLink<Integer>> casos = new ArrayList<>();
        String archivoInsercion = "insercion.txt";
        PrintWriter oS = new PrintWriter(archivoInsercion);
        for (int n = 1; n <= tamano; n++)
            casos.add(generarPeorCaso(n));
        Iterator<NodeLink<Integer>> puntero = casos.iterator();
        while (puntero.hasNext())
            oS.println(insertionSort(puntero.next()));
        oS.close();
        JavaPlot p = new JavaPlot();
        p.addPlot("\"insercion.txt\" with lines");
        p.plot();
    }
    
    public static NodeLink<Integer> generarPeorCaso(int tamaño) {
        NodeLink<Integer> lista = new NodeLink<>();
        for (int i = 0; i < tamaño; i++)
            lista.InserLast(tamaño - i);
        return lista;
    }
    
    
    public static long insertionSort(NodeLink<Integer> list) {
        int key;
        int i;
        long nano_startTime = System.nanoTime(); 
        for(int j=1; j<list.getCount(); j=j+1) {
        key = list.get(j).getData();
        i = j-1;
        while(i>-1 && list.get(i).getData()>key) {
            list.get(i+1).setData(list.get(i).getData());
        i = i-1;
        }
        list.get(i+1).setData(key);
}
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
    
}
