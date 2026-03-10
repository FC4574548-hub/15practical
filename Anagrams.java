import java.io.*;
import java.util.*;

public class Anagrams {

    public static String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));

        String inputFile = "joyce1922_ulysses.text";

        System.out.println("Data file: " + inputFile);


        BufferedReader reader = new BufferedReader((new FileReader(inputFile)));

        HashMap<String, ArrayList<String>> D = new HashMap<>();
        String line;

        line = reader.readLine();
        while ((line != null)) {
            String[] words = line.split("\\s+");

            for (String w : words) {
                w = w.replaceAll("[0123456789(,.,.;:!\\?\\-()\\[\\]\"]", "");
                w = w.toLowerCase();

                if (w.length() == 0)
                    continue;
                String key = signature(w);

                if (!D.containsKey(key)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(w);
                    D.put(key, list);
                }
                else {
                    D.get(key).add(w);
                }
            }
            line = reader.readLine();


        }

        reader.close();

        for (String key : D.keySet()) {

            ArrayList<String> list = D.get(key);

            if (list.size() >= 2){
                System.out.println(key + "" + list);
        }
    }





                PrintWriter tex = new PrintWriter(new FileWriter("theAnagrams.tex"));

                char letter = ' ';

        for (String key : D.keySet()) {

                    ArrayList<String> list = D.get(key);

                    if (list.size() >= 2){
                        String first = list.get(0);
                        char inital = first.charAt(0);

                    if (Character.toLowerCase(inital) != Character.toLowerCase(letter)) {

                        letter = inital;

                        tex.println("\\vspace{14pt}");
                        tex.println("\\noindent\\textbf{\\Large" + Character.toUpperCase(inital) + "}");
                        tex.println();
                    }
                    for (String w : list){
                        tex.print(w + "");
                    }
                    tex.print(line);

                }}

                tex.close();


            }
        }


    






