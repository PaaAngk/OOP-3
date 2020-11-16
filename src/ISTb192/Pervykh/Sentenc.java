package ISTb192.Pervykh;
import java.util.*;

public class Sentenc {
    private String string;

    public Sentenc() {
        this.string = "I can, program in java. And write 12345678";
    }
    public Sentenc(String string) {
        this.string = string;
    }
    public Sentenc(Sentenc str){
        this.string = str.string;
    }

    // Преобразование букв в большие
    public String upper(){
        this.string = string.toUpperCase();
        return string;
    }

    // Размер строки
    public int Size(){
        int Size;
        Size = this.string.length();
        return Size;
    }

    // Вывод обьекта класса Sentenc
    public void Print(){
        System.out.println(this.string);
    }

    // Методы задачи 2
    // Определния кода ASCII символа строки
    public int[] chAt(){
        int[] arr = new int[255];
        for (int i = 0; i < string.length(); i++) {
            arr[this.string.charAt(i)]++;
        }
        return arr;
    }

    // Вывод элементов массива в интервале
    public void inp2Symb(int a, int b){
        int[] arr = new int[255];
        Sentenc str = new Sentenc(this.string);
        str.upper();
        arr = str.chAt();
        for (int i = a; i < b; i++) {
            if (arr[i] != 0) {
                System.out.println((char) i + " встречается " + arr[i] + " раз(а)");
            }
        }
    }

    // Вывод 1 элемента массива
    public void inp1Symb(int a, String nm){
        int[] arr = new int[255];
        Sentenc str = new Sentenc(this.string);
        str.upper();
        arr = str.chAt();
        System.out.println(nm+" встречается " + arr[a] + " раз(а)");
    }

    // Задача 3
    //Определение знака больше или меньше в веденной строке
    public int moreThan(){
        int moreThan;
        String[] s1 = string.split(" ");
        if (s1[0].equals(">")){moreThan = 1;}
        else {moreThan = 2;}
        return moreThan;
    }

    //Определения числа в введенной строке
    public int numStr(){
        int n;
        String[] s1 = string.split(" ");
        n = Integer.parseInt(s1[1]);
        return n;
    }

}
