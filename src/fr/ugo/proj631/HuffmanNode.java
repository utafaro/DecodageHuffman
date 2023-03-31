package fr.ugo.proj631;

public class HuffmanNode {
    private Character etiquette;
    private HuffmanNode leftChild;
    private HuffmanNode rightChild;
    private int frequence;

    public HuffmanNode(Character etiquette, int frequence,HuffmanNode leftChild, HuffmanNode rightChild) {
        this.etiquette = etiquette;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.frequence = frequence;
    }

    public HuffmanNode(Character etiquette, int frequence){
        this.etiquette = etiquette;
        this.frequence = frequence;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return "etiquette=" + etiquette +
                " | frequence=" + frequence;
    }

    public int getFrequence() {
        return frequence;
    }

    public Character getEtiquette() {
        return etiquette;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }
}
