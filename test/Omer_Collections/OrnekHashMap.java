package Omer_Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OrnekHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> liste = new HashMap<Integer, String>();

        //Veri ekleme
        liste.put(10, "Balıkesir");
        liste.put(34, "İstanbul");
        liste.put(35, "İzmir");

        //Veriye erişim
        System.out.println(liste.get(10));

        //Veriyi silme dönüş olarak silinen kayıt alınıyor
        System.out.println(liste.remove(34));
        
        //null çıktı verir
        System.out.println(liste.get(34));
        

        //Anahtar listesi alınıyor
        Set<Integer> anahtarListesi = liste.keySet();
        
        //Anahtarlar listeleniyor
        for (Integer anahtar : anahtarListesi) {
            System.out.println(anahtar);
        }
        System.out.println("**********");
        //Değer listesi alınıyor
        Collection<String> degerler = liste.values();
        //Değerler listeleniyor
        for (String deger : degerler) {
            System.out.println(deger);
        }
        System.out.println("**********");

        //Kayıt anahtar ve değerle alınıyor
        Set<Map.Entry<Integer, String>> kayitlar = liste.entrySet();
        
        //Anahtar ve değerler listeleniyor
        for (Map.Entry<Integer, String> kayit : kayitlar) {
            System.out.println(kayit.getKey()
                    + " - " + kayit.getValue());
        }
    }
}
