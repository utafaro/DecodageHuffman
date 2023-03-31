package fr.ugo.proj631;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;


public class Main {


    public static void main(String[] args) throws IOException {

        File file_txt = new File("src/fr/ugo/proj631/Fichier huffman/exemple_freq.txt");
        File file_bin = new File("src/fr/ugo/proj631/Fichier huffman/exemple_comp.bin");
        DicFreq dic_freq = new DicFreq(file_txt);
        HuffmanTree tree = new HuffmanTree(dic_freq);
        BinaryReader binaryNumber = new BinaryReader(file_bin);
        Decoder dic_code = new Decoder(tree);
        dic_code.generatesCode(tree.getRoot(), "");
        LinkedHashMap<String, Character> codeTable = dic_code.getMap_code();

        System.out.println(tree.getRoot());

        System.out.println(dic_freq.getMap_freq());
        System.out.println(dic_code.getMap_code());
        System.out.println(binaryNumber.getRes_binary());

        //Création d'un fichier txt
        String chaine_decodee = dic_code.decodeHuffman(binaryNumber.getRes_binary(), codeTable);
        try {
            FileWriter writer = new FileWriter("src/fr/ugo/proj631/Fichier huffman/exemple.txt");
            writer.write(chaine_decodee);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier.");
            e.printStackTrace();
        }
        File final_file = new File("src/fr/ugo/proj631/Fichier huffman/exemple.txt");
        CompressionRate taux_compression = new CompressionRate(file_bin, final_file);
        System.out.println("Taux de compression : "+taux_compression.getCompressionRate());

        }
}