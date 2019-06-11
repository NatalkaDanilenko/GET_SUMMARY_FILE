/*
 Напишите программу, которая примет на вход
 два текстовых файла, а вернет один.
 Содержимым этого файла должны быть слова,
 которые одновременно есть и в первом и во втором файле.
 */

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("/Users/nataliadanilenko/Documents/GIT/GET_SUMMARY_FILE/file1.txt");
        File file2 = new File("/Users/nataliadanilenko/Documents/GIT/GET_SUMMARY_FILE/file2.txt");
        File out = new File("sum.txt");
        try (PrintWriter a = new PrintWriter(out)) {
            a.println(sumFile(file1, file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(File file) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(file));
        String str = "";
        String out = "";
        for (; (str = f.readLine()) != null; ) {
            out = out + str;
        }
        return out;
    }

    public static String sumFile(File file1, File file2) throws IOException {
        String[] str1 = readFile(file1).replaceAll(",", "").split(" ");
        String[] str2 = readFile(file2).replaceAll(",", "").split(" ");
        String str = "";
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i].equals(str2[j])) {
                    str = str + " " + str1[i];
                }
            }
        }
        return str;
    }
}
