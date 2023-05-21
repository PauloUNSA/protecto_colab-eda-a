public class IfElse {
    public static void main(String[] args) {
        //ejer 1
        int x = 50;
        int y = 10;
        if
        (x 
        >
        y) {
        System.out.println("Hello World");
        }
        //ejer2
        x = 50;
        y = 50;
        if
        (x ==y) {
        System.out.println("Hello World");
        }
        //ejer3
        x = 50;
        y = 50;
        if(x ==y) {
        System.out.println("Yes");
        } else{
        System.out.println("No");
        }  
        //ejer 4
        x = 50;
        y = 50;
        if
        (x ==y) {
        System.out.println("1");
        } else if
        (x > y) {
        System.out.println("2");
        } else{
        System.out.println("3");
        }  
        //ejer 5
        int time = 20;
        String result = (time < 18)?"Good day." :"Good evening.";
        System.out.println(result); 
    }
}
