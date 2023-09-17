package ru.geekbrains.lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BackUp {
    public static String folderName = "./backup";

    public static void main(String[] args) throws IOException {
        File target = new File(".");
        File destination = new File(folderName);
        createBackUp(target, destination);
    }

    /**
     * Подготавливает новую директорию для BackUp-а, запускает обход
     * @param target
     * @param destination
     * @throws IOException
     */
    public static void createBackUp(File target, File destination) throws IOException {
        String rootPath = destination.getAbsolutePath();
        Files.createDirectories(Paths.get(rootPath));
        checkSource(target, rootPath);
    }

    /**
     * Новые директории в папке BackUp-а и копирование файлов
     * @param file
     * @param rootPath
     * @throws IOException
     */
    private static void backUp(File file, String rootPath) throws IOException {
        rootPath += "/" + file.getName();
        Path path= Paths.get(rootPath);
        if (file.isDirectory()){  // если это папка
            Files.createDirectories(path);
            checkSource(file, rootPath);
        }
        else {
            if (path.toFile().exists()) // если такой файл существует
                path.toFile().deleteOnExit(); // удаляем

            copy(file, rootPath);  // создаем копию
        }
    }

    /**
     * Проверка на директорию
     * @param file
     * @param rootPath
     * @throws IOException
     */
    private static void checkSource(File file, String rootPath) throws IOException {
        File[] files = file.listFiles();
        if (files == null)
            return;

        for (File fileInclude : files) {
            if (!fileInclude.toString().equals(folderName)) // исключить папку backup от копирования
                backUp(fileInclude, rootPath);
        }
    }




    /**
     * Копирование файлов
     * @param file
     * @param path
     * @throws IOException
     */
    public static void copy(File file, String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int c;
            while ((c = fileInputStream.read()) != -1)
                fileOutputStream.write(c);
        }
        catch (Exception e){
            try {
                fileInputStream.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                fileOutputStream.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
