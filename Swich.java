public class Swich {
    public static void main(String[] args) {
        //ejer 1
        int day = 2;
        switch (day) {
            case 1:
                System.out.println("Saturday");
                break;
            case 2:
                System.out.println("Sunday");
                break;
            }
        //ejer 2
        day = 4;
        switch (day) {
        case 1:
            System.out.println("Saturday");
            break;
        case 2:
            System.out.println("Sunday");
        break;
        default:
            System.out.println("Weekend");
        }
    }
}
