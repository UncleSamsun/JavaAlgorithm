import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        StringBuffer sbStr = new StringBuffer(str);

        sbStr.reverse();

        if(sbStr.toString().equals(str)) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}
