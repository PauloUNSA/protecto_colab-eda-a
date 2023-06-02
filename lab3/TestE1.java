public class TestE1 {
    public static void main(String[] args) {
        int[] h1,h2,h3;
        h1 = new int[]{1,2,1,1};
        h2 = new int[]{1,1,2};
        h3 = new int[]{1,2,1};
        System.out.println(equalStacks(h1,h2,h3));
    }
    public static int equalStacks (int[] h1,int[] h2,int[] h3){
        int k = 0;
        while (!sonIguales(h1,h2,h3)) {
            int n1 = sumaArr(h1);
            int n2 = sumaArr(h2);
            int n3 = sumaArr(h3);
            int[] mayor = Math.max(n1, n2) == n1 ? h1 : h2;
            mayor = Math.max(mayor.length, n3) == n1 ? mayor : h3;
            int[] aux = new int[mayor.length - 1];
            for (int i = 0; i < mayor.length - 1; i++) {
                aux[i] = mayor[i];
            }
            h1 = h1 == mayor?aux:h1;
            h2 = h2 == mayor?aux:h2;
            h3 = h3 == mayor?aux:h3;
            k++;
        }
        return k;
    }
    public static boolean sonIguales(int[] h1,int[] h2,int[] h3){
        return sumaArr(h1)== sumaArr(h2)&&sumaArr(h1)== sumaArr(h3);
    }
    public static int sumaArr(int[] arr){
        int suma =0;
        for (int i :
                arr) {
            suma +=i;
        }
        return suma;
    }
}
