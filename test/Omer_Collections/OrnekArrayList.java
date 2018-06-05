package Omer_Collections;

import java.util.ArrayList;

public class OrnekArrayList {

    public static void main(String[] args) {

        ArrayList<String> ulkelerList = new ArrayList<String>();
        ulkelerList.add("Turkey");
        ulkelerList.add("Germany");
        ulkelerList.add("USA");
        ulkelerList.add("Italy");

        ArrayList<String> ulkelerList2 = new ArrayList<>();
        ulkelerList2.add("Russia");
        ulkelerList2.add("Ukraine");

        System.out.println("");
        System.out.println("2nci Ulke : " + ulkelerList.get(2));

        System.out.println("\n" + "***********");
        int a = 0;
        for (String ulke : ulkelerList) {
            a++;
            System.out.println(a + " " + ulke);
        }

        ulkelerList.add("New Country"); //Kayıt Ekleme
        ulkelerList.add("Last Country"); //Kayıt Ekleme
        ulkelerList.add("Last Country"); //Kayıt Ekleme
        ulkelerList.add("Last Country"); //Kayıt Ekleme

        ulkelerList.add(0, "First Country"); //İndeks numarasına kayıt ekleme, diğerlerini kaydırır

        System.out.println("***********");

        for (String ulke : ulkelerList) {
            System.out.println(ulke);
        }

        System.out.println("***********");

        System.out.println(ulkelerList.get(0) + " ve Last Country Silinecek"); //Sıra numaralı kaydı getirme
        ulkelerList.remove("Last Country"); //Kaydı silme
        ulkelerList.remove(0); //Sıra numarasına göre kaydı silme

        System.out.println("***********");

        ulkelerList.addAll(ulkelerList2); // Başka bir listeyi ekleme

        for (String eleman : ulkelerList2) {
            System.out.println(eleman);
        }

        System.out.println("Liste boş mu = " + ulkelerList.isEmpty()); // liste boş mu diye kontrol eder.
        System.out.println("Utopya indexi = " + ulkelerList.indexOf("Utopya"));
        System.out.println("USA indexi = " + ulkelerList.indexOf("USA"));

        System.out.println(ulkelerList);
        System.out.println(ulkelerList2);
    }
}
