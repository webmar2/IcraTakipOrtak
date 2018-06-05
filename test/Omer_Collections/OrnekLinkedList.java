package Omer_Collections;

import java.util.LinkedList;

public class OrnekLinkedList {

    public static void main(String[] args) {
        LinkedList<String> liste = new LinkedList<>();

        liste.add("Kırıkkale");
        liste.add("Istanbul");
        liste.add("Izmir");
        liste.add("Bursa");

        for (String eleman : liste) {
            System.out.println(eleman);
        }

        System.out.println("******* " + liste.size());

        liste.addFirst("Balıkesir"); //En başa atama
        liste.addLast("Adana"); //En sona atama
        liste.offerFirst("Eskişehir"); //En başa atama
        liste.offerLast("Gaziantep"); //En sona atama

        for (String eleman : liste) {
            System.out.println(eleman);
        }

        System.out.println("******* " + liste.size());
        
        System.out.println(liste.peekLast()); //Son kaydı getirir
        System.out.println(liste.getLast()); //Son kaydı getirir
        System.out.println(liste.removeLast()); //Son kaydı siler
        System.out.println(liste.pollLast()); //Son kaydı siler
    }
}
