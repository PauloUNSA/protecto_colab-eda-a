public class Arrays {
    public static void main(String[] args) {
        //ejer1
        String[] cars = {"Volvo", "BMW", "Ford"};
        //ejer2
        System.out.println(cars[1]);
        //ejer3        
        cars[0]= "Opel";
        System.out.println(cars[0]);
        //ejer4
        System.out.println(cars.length);
        //ejer5
        for(String i : cars) {
        System.out.println(i);
        }
        //ejer6
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
    }
}
