package fr.ugo.proj631;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryReader {

    private String res_binary="";
    private File binaryFile;

    public BinaryReader(File binaryFile){

        this.binaryFile = binaryFile;

        try(FileInputStream fis = new FileInputStream(binaryFile)){

            int data;
            while((data=fis.read()) != -1){
                if (data!=0){
                    this.res_binary += String.format("%8s", Integer.toBinaryString(data)).replaceAll(" ", "0");
                }


            }


        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public String getRes_binary() {
        return res_binary;
    }
}
