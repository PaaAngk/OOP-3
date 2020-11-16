package ISTb192.Pervykh;

import java.io.*;

public class FileHandler {

    public static void addFile(String[] str, String name){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name+".txt"))){
            str[3] = str[3].replace("[", "");
            str[3] = str[3].replace("]", "");
            bw.write(str[0]);
            bw.newLine();
            bw.write(str[1]);
            bw.newLine();
            bw.write(str[2]);
            bw.newLine();
            bw.write(str[3]);
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public static String[] fromFile(String name){
        String[] str = new String[4];
        int i = 0;
        try {
            FileReader fr = new FileReader(name+".txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                str[i] = line;
                i++;
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
        return str;
    }

    public static void addByte(int[] arr, int size, String name){
        try(FileOutputStream out = new FileOutputStream(name+".byte")){
            out.write(Integer.toString(size).getBytes());
            if(size > 0){
                for (int i = 0; i < size; i++){
                    out.write(Integer.toString(arr[i]).getBytes());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public static void fromByte(String name) {
        try(FileInputStream fin = new FileInputStream(name+".byte"))
        {
            int k=-1;
            while((k=fin.read())!=-1){
                System.out.println("Исходный массив:");
                byte[] buff = new byte[fin.available()];
                fin.read(buff);
                System.out.write(buff);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }
}
