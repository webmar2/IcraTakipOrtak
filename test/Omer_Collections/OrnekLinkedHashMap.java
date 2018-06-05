package Omer_Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class OrnekLinkedHashMap {

    public static void main(String[] args) {
//HashMap listesi
        HashMap<Integer, String> liste1 = new HashMap<Integer, String>();
        liste1.put(34, "İstanbul");
        liste1.put(10, "Balıkesir");
        liste1.put(35, "İzmir");
        liste1.put(16, "Bursa");
        liste1.put(17, "Bursa");
        System.out.println("HashMap listesi");
        for (Entry<Integer, String> kayit : liste1.entrySet()) {
            System.out.println(kayit.getKey()
                    + " - " + kayit.getValue());
        }
        
//        for (int i = 0; i < liste1.entrySet().size() ; i++) {
//            System.out.println(liste1.get(i));
//        }
        
        System.out.println("************");
        
//LinkedHashMap listesi
        LinkedHashMap<Integer, String> liste2
                = new LinkedHashMap<Integer, String>();
        liste2.put(34, "İstanbul");
        liste2.put(10, "Balıkesir");
        liste2.put(35, "İzmir");
        liste2.put(16, "Bursa");
        System.out.println("LinkedHashMap listesi");
        for (Entry<Integer, String> kayit : liste2.entrySet()) {
            System.out.println(kayit.getKey()
                    + " - " + kayit.getValue());
        }
    }

}
