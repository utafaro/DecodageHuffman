package fr.ugo.proj631;

import java.util.LinkedHashMap;

public class Decoder {
    private HuffmanTree tree;
    private LinkedHashMap<String, Character> map_code;

    public Decoder(HuffmanTree tree) {
        this.tree = tree;
        this.map_code = new LinkedHashMap<String, Character>();
    }

    public void generatesCode(HuffmanNode tree, String code){

        if (tree.getEtiquette() != null) {
            this.map_code.put(code, tree.getEtiquette());
        } else {
            generatesCode(tree.getLeftChild(), code + "0");
            generatesCode(tree.getRightChild(), code + "1");
        }

    }

    public String decodeHuffman(String codeBinaire, LinkedHashMap<String, Character> codeTable){
        String res = "";
        String bitSequency = "";
        for(int i = 0; i<codeBinaire.length(); i++){
            bitSequency += codeBinaire.charAt(i);
            if (codeTable.containsKey(bitSequency)){


                res += this.map_code.get(bitSequency);
                bitSequency = "";
            }
        }
        return res.substring(0, tree.getDic_freq().getNbChar());
    }

    public LinkedHashMap<String, Character> getMap_code() {
        return map_code;
    }

}
