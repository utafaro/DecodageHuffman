package fr.ugo.proj631;

import java.util.*;

public class HuffmanTree {
    private DicFreq dic_freq;
    private ArrayList<HuffmanNode> list_nodes;
    private HuffmanNode root;

    public HuffmanTree(DicFreq dic_freq) {
        this.dic_freq = dic_freq;
        this.list_nodes = new ArrayList<HuffmanNode>();

        LinkedHashMap<Character,Integer> map_freq = this.dic_freq.getMap_freq();
        for(Character key : map_freq.keySet()){
            HuffmanNode node = new HuffmanNode(key, map_freq.get(key));
            list_nodes.add(node);
        }

        while(list_nodes.size() > 1){
            HuffmanNode node1 = list_nodes.remove(0);
            HuffmanNode node2 = list_nodes.remove(0);
            HuffmanNode new_tree = new HuffmanNode(null, node1.getFrequence()+ node2.getFrequence(), node1, node2);

            int index = 0; //On définit une variable index initialisée à 0 qui va représenter l'index où la doit être insérée dans la liste

            // On parcourt la liste avec une boucle while tant que l'index est inférieur à la taille de la liste  ET que la valeur à insére
            while (index<list_nodes.size() && new_tree.getFrequence() > list_nodes.get(index).getFrequence()){
                index++;
            }
            list_nodes.add(index, new_tree);
        }
        this.root = list_nodes.get(0);
    }

    public HuffmanNode getRoot() {
        return root;
    }

    public DicFreq getDic_freq() {
        return dic_freq;
    }
}
