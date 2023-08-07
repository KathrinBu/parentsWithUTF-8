import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
        ArrayList<String> arrayList=new ArrayList<>();
        String name="text.txt";
        Scanner scanner=new Scanner(new File(name));
        while (scanner.hasNext()) {
         arrayList.add(scanner.next().replace("mother","parent").replace("father","parent"));
        }
        System.out.println(arrayList);
        } catch (IOException e) {
            System.out.println(":(((");
        }

        Path path= Paths.get("russian.txt");
        try {
            List<String> list = Files.readAllLines(path, Charset.forName("UTF-8"));
            System.out.println(list.toString().replaceAll("мама|папа","родитель")
                                              .replaceAll("маме|папе","родителю"));
        } catch (IOException e){
            System.out.println("error");
        }
    }
}
