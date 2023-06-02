public class TestE1 {
    public static void main(String[] args) {
        int[] h1,h2,h3;
        h1 = new int[]{1,2,1,1};
        h2 = new int[]{1,1,2};
        h3 = new int[]{1,2,1};

    }
    public static int equalStacks (int[] h1,int[] h2,int[] h3){
        int n1 = h1.length;
        int n2 = h2.length;
        int n3 = h3.length;
        int[] mayor = Math.max(n1,n2) ==n1?h1:h2;
        mayor = Math.max(mayor.length,n3) ==n1?mayor:h3;

        return 0;
    }
}
