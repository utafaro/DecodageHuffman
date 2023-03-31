package fr.ugo.proj631;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DicFreq{

    private File fichier; //fichier txt de fréquence
    private LinkedHashMap<Character, Integer> map_freq; // "Dictionnaire" qui va contenir nos fréquences

    public DicFreq(File fichier) {
        this.fichier = fichier;
        this.map_freq = new LinkedHashMap<Character, Integer>();

        //Lecture du fichier

        String ligne = "";
        int numeroLigne = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            while ((ligne = reader.readLine()) != null) {
                numeroLigne++;
                if (numeroLigne>1){
                    this.map_freq.put(ligne.charAt(0), Character.getNumericValue(ligne.charAt(2)));
                }

            }
        }
        catch (IOException e){
            System.out.println("Erreur lors de la lecture du fichier");
        }




    }

    public LinkedHashMap<Character, Integer> getMap_freq() {
        return map_freq;
    }

    public int getNbChar(){
        int res = 0;
        for(Map.Entry<Character, Integer> entry : this.map_freq.entrySet()){
            int value = entry.getValue();
            res += value;

        }
        return res;
    }
}
