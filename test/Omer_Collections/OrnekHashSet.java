package Omer_Collections;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author BSR
 */
public class OrnekHashSet {
    public static void main(String[] args) {
        ArrayList<String> liste1 = new ArrayList<String>();
            liste1.add("Ankara");
            liste1.add("Ankara");
            liste1.add("Ankara");
            System.out.println("liste1.size() : " + liste1.size());
    
        HashSet<String> liste2 = new HashSet<String>();
            liste2.add("Ankara");
            liste2.add("Ankara");
            liste2.add("Ankara");
            System.out.println("liste2.size() : " + liste2.size());
    
// Sonuç itibari ile Set türevi sınıflarda aynı kayıt varsa
// tekrar ekleme yapılmayacak ve add metodu false dönecektir. 
// Bu durumda istediğimiz kadar Ankara kaydını eklesekte listemizde sadece bir tane olacaktır.   
    

    




    }

}
