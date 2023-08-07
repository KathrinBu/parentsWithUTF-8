import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        task1();
        task2();

    }
        static void task1(){
        try {
        ArrayList<String> arrayList=new ArrayList<>();
        String name="text.txt";
        Scanner scanner=new Scanner(new File(name));
        while (scanner.hasNext()) {
         arrayList.add(scanner.next().replace("mother","parent").replace("father","parent"));
        } System.out.println(arrayList);
       int count=0;
            for (int i = 0; i < arrayList.size(); i++) {
                String [] arr=arrayList.toString().split(" ");
                boolean a1=arr[i].equals("(");
                boolean a2=arr[i].equals(")");
                boolean b1=arr[i].equals("[");
                boolean b2=arr[i].equals("]");
                boolean c1=arr[i].equals("{");
                boolean c2=arr[i].equals("}");
                boolean d1=arr[i].equals("<");
                boolean d2=arr[i].equals(">");
                if ((a1 && a2) || (b1 && b2) || (c1 && c2) || (d1 && d2)) {
                    count=0;
                    System.out.println("scobki sovpadayt");
                } else {
                    count=-1;
                    System.out.println("scobki NE sovpadayt");
                }
            }
            } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(":(");
        } return;
        }

//        Path path= Paths.get("russian.txt");
//        try {
//            List<String> list = Files.readAllLines(path, Charset.forName("UTF-8"));
//            System.out.println(list.toString().replaceAll("мама|папа","родитель")
//                                              .replaceAll("маме|папе","родителю"));
//        } catch (IOException e){
//            System.out.println("error");
//        }

    static void task2(){
        System.out.println("Vvedite imj faila:");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        try {
            List<String> list=Files.readAllLines(new File(name).toPath());
            String str=list.toString();
            int countRoundOpen=count(str,"(");
            int countRoundClose=count(str,")");
            int squareOpen=(int) str.chars().filter(x->x=='[').count();
            int squareClose=(int) str.chars().filter(x->x==']').count();
//            for (int i = 0; i < str.length(); i++) {
//                char c=str.charAt(i);
//
//            }
            System.out.println(countRoundClose+" - "+countRoundOpen+" -- "+squareOpen+" = "+squareClose);
        } catch (IOException e) {
            System.out.println(":(");
        }
    }
    static int count(String source, String toFind) {
        String s=source.replace(toFind,"");
        int delta=source.length()-s.length();
        int result=delta/toFind.length();
        return result;
    }
}
