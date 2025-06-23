import Exercises.Exercises;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Exercises/Files txt/Produtos.txt");

        try{
            System.out.println(Arrays.toString(Exercises.product(file, 20)));
        } catch (IOException | ArrayIndexOutOfBoundsException ioe) {
            System.out.println("An error occurred: " + ioe);
        }
    }
} 