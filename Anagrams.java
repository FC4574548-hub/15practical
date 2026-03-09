import java.io.*;
import java.util.*;

public class Anagrams {

  public static String signature(String word){
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  
}
