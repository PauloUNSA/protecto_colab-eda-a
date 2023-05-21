public class Ejercicio2 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        for (int i :
                A) {
            System.out.println(i);
        }
        A=rotarIzquierdaArray(A);

        for (int i :
                A) {
            System.out.println(i);
        }
    }
    public static int[] rotarIzquierdaArray(int[] A){
        int[] aiz = new int[4];
        for (int i = 0; i < A.length; i++) {
            aiz[i]=A[A.length-(i+1)] ;
        }
    return aiz;
}
}