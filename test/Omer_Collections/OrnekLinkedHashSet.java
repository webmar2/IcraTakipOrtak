package Omer_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author BSR
 */
public class OrnekLinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> liste1 = new HashSet<String>();
            liste1.add("Ankara");
            liste1.add("Istanbul");
            liste1.add("Izmir");
            liste1.add("Adana");
        for (String str : liste1) {
        System.out.println(str); 
        // Çıktının çıktısı eklediğimiz sıraya göre değil.
        }
        
        System.out.println("*************");
        
        LinkedHashSet<String> liste2 = new LinkedHashSet<String>();
            liste2.add("Ankara");
            liste2.add("Istanbul");
            liste2.add("Izmir");
            liste2.add("Adana");
        
        for (String str : liste2) {
            System.out.println(str);
            
            //LinkedHashSet ile eklenen sıraya göre olmuştur sıralama.
        }
    } 
}
