package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintDirectories(scanner.next(), 0);
    }

    public static void PrintDirectories(String path, int depth) {
        File f = new File(path);
        try {
            //все файлы в директории
            File[] files = f.listFiles();

            //формирование отступа
            StringBuilder indentBuilder = new StringBuilder();
            for (int i = 0; i < depth; i++)
                indentBuilder.append("  ");
            String indent = indentBuilder.toString();

            //вывод всех файлов в директории
            for (File file : files) {
                System.out.println(String.format("%s%s", indent, file.getName()));

                //рекурсивный вызов метода для вложенных директорий
                if (file.isDirectory()) {
                    PrintDirectories(file.getAbsolutePath(), depth + 1);
                }
            }
        } catch (Exception e) {
            System.out.println(path + " - unreachable directory");
        }
    }
}
