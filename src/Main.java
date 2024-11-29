import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine() + "11";
        String[] strArr = str.split("");
        int count = 0;

        for (int i = 0; i < strArr.length-2; i++) {
            if(strArr[i].equals("c") && strArr[i+1].equals("=")){
                count++;
                i++;
            } else if (strArr[i].equals("c") && strArr[i+1].equals("-")) {
                count++;
                i++;
            } else if (strArr[i].equals("d") && strArr[i+1].equals("-")) {
                count++;
                i++;
            } else if (strArr[i].equals("l") && strArr[i+1].equals("j")) {
                count++;
                i++;
            } else if (strArr[i].equals("n") && strArr[i+1].equals("j")) {
                count++;
                i++;
            } else if (strArr[i].equals("s") && strArr[i+1].equals("=")) {
                count++;
                i++;
            } else if (strArr[i].equals("z") && strArr[i+1].equals("=")) {
                count++;
                i++;
            } else if (strArr[i].equals("d") && strArr[i+1].equals("z") && strArr[i+2].equals("=")) {
                count++;
                i += 2;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
