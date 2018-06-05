package Omer_Collections;

import java.util.TreeSet;

/**
 * @author BSR
 */
public class OrnekTreeSet {
    
    public static void main(String[] args) {
        TreeSet<String> liste = new TreeSet<String>();
            liste.add("Ankara");
            liste.add("Istanbul");
            liste.add("Izmir");
            liste.add("Adana");
            for (String str : liste) {
            System.out.println(str);
}
}
    
    
    
}
