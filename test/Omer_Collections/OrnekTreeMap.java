package Omer_Collections;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class OrnekTreeMap {
    public static void main(String[] args) {
    
        //HashMap listesi
    HashMap<Integer, String> liste1 = new HashMap<Integer, String>();
        liste1.put(34, "İstanbul");
        liste1.put(10, "Balıkesir");
        liste1.put(35, "İzmir");
        liste1.put(16, "Bursa");
        System.out.println("HashMap listesi");
        for (Entry<Integer, String> kayit : liste1.entrySet()) {
        System.out.println(kayit.getKey() +
        " - " + kayit.getValue());
        }
        System.out.println("************");
        //TreeMap listesi
        TreeMap<Integer, String> liste2 = new TreeMap<Integer, String>();
        liste2.put(34, "İstanbul");
        liste2.put(10, "Balıkesir");
        liste2.put(35, "İzmir");
        liste2.put(16, "Bursa");
        System.out.println("TreeMap listesi");
        for (Entry<Integer, String> kayit : liste2.entrySet()) {
        System.out.println(kayit.getKey() +
        " - " + kayit.getValue());
        }
}
    
}
