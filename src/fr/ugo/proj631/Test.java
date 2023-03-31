package fr.ugo.proj631;

import java.util.ArrayList;

public class Test {

    public Test(){
        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        liste.add(5);
        liste.add(6);
        int index = 0;
        int value = 2;
        while (index<liste.size() && value > liste.get(index)){
            index++;
        }
        liste.add(index, value);

        System.out.println(liste);
    }
}
