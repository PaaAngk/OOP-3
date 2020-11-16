package ISTb192.Pervykh;

public class Digit {
    private int[] digit;

    public Digit(int n) {
        this.digit = new int[n];
    }

    public Digit(int[] inp) {
        this.digit = new int[Size(inp)];
        // копируем элементы, поэлементно
        for (int i = 0; i < Size(inp); ++i)
        {
            this.digit[i] = inp[i];
        }
    }

    public Digit(Digit dig) {
        this.digit = dig.digit;
    }

    // решение программы 1
    public int[] p1(int m, int k){
        int[] nat = naturalRyadx2(m);
        int[] masEven = new int[sumEvOd(nat, 1)];
        int[] masOdd = new int[sumEvOd(nat, 2)];

        masEven = sortEvOd(nat, 1);
        masOdd = sortEvOd(nat, 2);

        if (k == 1){return masEven;}
        else {return masOdd;}
    }

    //сортировка массива на четный массив и нечетный массив (evOrOd 1 и 2 соотвественно)
    public int[] sortEvOd(int[] source, int evOrOd){
        int[] masEven = new int[sumEvOd(source, 1)];
        int[] masOdd = new int[sumEvOd(source, 2)];
        int index1 = 0, index2 = 0;

        for (int i = 0; i < Size(source); i++) {
            if (source[i] % 2 == 0) {
                masEven[index1++] = source[i];
            } else {
                masOdd[index2++] = source[i];
            }
        }

        if (evOrOd == 1){return masEven;}
        else {return masOdd;}
    }

    //Количесвто четных и нечетных элементов массива
    public int sumEvOd(int[] source, int evOrOd){
        int evens = 0, odd = 0;
        for (int i = 0; i < Size(source); i++) {
            if (source[i] % 2 == 0){evens++;}
            else {odd++;}
        }
        if (evOrOd == 1){return evens;}
        else {return odd;}
    }

    // Создание натурального ряда
    public int[] naturalRyadx2(int m){
        int[] source = new int[m];
        int in = 1;
        for (int i = 0; i < m; i++) {
            source[i] = in * in;
            in++;
        }
        return source;
    }

    // Вывод массива
    public void Print(int[] source){
        for (int i = 0; i < Size(source); i++){
            System.out.print(source[i] + ", ");
        }
    }

    public void Print1(){
        for (int i = 0; i < Size(this.digit); i++){
            System.out.print(this.digit[i] + ", ");
        }
    }

    // Размер массива
    public int Size(int[] source){
        return source.length;
    }

    // Ввод массива
    public void inpMass(int msize){
        Digit digi = new Digit(msize);
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < msize; i++) {
            System.out.println("Элемент " + (i+1) + " массива: ");
            this.digit[i] = Input.inputVer();
        }
    }

    // Вывод чисел соотвествующих условия
    public void printMass(int moreThan, int n, int msize){
        for (int i = 0; i < msize; i++) {
            if ((moreThan == 1) && this.digit[i] > n)
                System.out.print(this.digit[i]+ " ");
            else if ((moreThan == 2) && this.digit[i] < n)
                System.out.print(this.digit[i] + " ");
        }
    }

}
