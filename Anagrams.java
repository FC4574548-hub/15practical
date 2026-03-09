import java.io.*;
import java.util.*;

public class Anagrams {

    public static String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) throws IOException {
        
        String inputFile = "joyce1922_ulysses.text";
        String outputFile = "Output";
        System.out.println("Data file: " + inputFile);


        BufferedReader reader = new BufferedReader((new FileReader(inputFile)));

        HashMap<String, Integer> D = new HashMap<>();
        String line;

        line = reader.readLine();
        while ((line != null)) {
            String[] words = line.split("\\s+");

            for (String w : words) {
                w = w.replaceAll("[0123456789(,.,.;:!\\?\\-()\\[\\]\"]", "");
                w = w.toLowerCase();

                if (w.length() == 0)
                    continue;

                if (D.containsKey(w))
                    D.put(w, D.get(w) + 1);
                else D.put(w, 1);
            }

        }

        reader.close();

        HashMap<String, ArrayList<String>> A = new HashMap<>();

        for (String w : D.keySet()) {

            String a = signature(w);

            if (!A.containsKey(a)) 
                A.put(a, new ArrayList<String>());
            
            A.get(a).add(w);
        }


        BufferedReader qreader = new BufferedReader((new FileReader(outputFile)));

        while ((line = qreader.readLine()) != null && !line.equals("")) {
            String word = line.trim();

            System.out.println("<" + word + ">");

            String tryanagram = signature((word));

            if (A.containsKey(tryanagram)) {
                System.out.println(word + " " + A.get(tryanagram));

            }
        }

        qreader.close();

        PrintWriter writer = new PrintWriter(new FileWriter("anagrams.txt"));

        for (String key : A.keySet()) {
            ArrayList<String> list = A.get(key);

            if (list.size() > 1) {
                String anagramList = String.join("", list);
                writer.println((anagramList));

                for (int i = 0; i < list.size() - 1; i++) {
                    String[] parts = anagramList.split("");
                    anagramList = "";

                    for (int j = 0; j < parts.length; j++)
                        anagramList += parts[j] + "";
                    anagramList += parts[0];

                    writer.println(anagramList);

                }
                writer.println();
            }
        }
                writer.close();
            
        
                ArrayList<String> lines = new ArrayList<>();
                BufferedReader r2 = new BufferedReader(new FileReader("anagrams.txt"));

                while ((line = r2.readLine()) != null)
                    lines.add(line);
                r2.close();

                Collections.sort(lines);

                PrintWriter sorted = new PrintWriter(new FileWriter("anagrams.sorted"));
                for (String I : lines)
                    sorted.println(I);
                sorted.close();


                BufferedReader r3 = new BufferedReader(new FileReader("anagrams.sorted"));
                PrintWriter tex = new PrintWriter(new FileWriter("theAnagrams.tex"));

                char letter = 'X';

                while ((line = r3.readLine()) != null) {
                    if (line.length() == 0)
                        continue;

                    char inital = line.charAt(0);

                    if (Character.toLowerCase(inital) != Character.toLowerCase(letter)) {

                        letter = inital;

                        tex.println("\\vspace{14pt}");
                        tex.println("\\noindent\\textbf{\\Large" + Character.toUpperCase(inital) + "}");
                        tex.println();
                    }
                    tex.print(line);

                }
                r3.close();
                tex.close();


            }
        }


    






