import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Anagrams {

    public static String signature(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Usage: ./anagrans inputfile. \n" +
                    " You gave: \n" +
                    " %s" + args[1]);
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];
        System.out.println("Data file: " + inputFile);

        
        BufferedReader reader = new BufferedReader((new FileReader(inputFile)));

        HashMap<String, Integer> D = new HashMap<>();
        String line;

        line = reader.readLine();
        while ((line != null )) {
            String[] words = line.split("\\s+");

            for (String w : words){
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
        
        for (String w : D.keySet()){
            
            String a = signature(w);
            
            if (!A.containsKey(a)) {
                A.put(a, new ArrayList<String>());
            }
            A.get(a).add(w);
        }


        BufferedReader qreader = new BufferedReader((new FileReader(outputFile)));
        
        while ((line = qreader.readLine()) != null && !line.equals("")){
            String word = line.trim();
            
            System.out.println("<" + word + ">");
            
            String tryanagram = signature((word));
            
            if(A.containsKey(tryanagram)){
                System.out.println(word + " " + A.get(tryanagram));

            }        }
        
        qreader.close();
        
        
        
    }



}



