package fr.ugo.proj631;

import java.io.File;

public class CompressionRate {
    private File file_bin;
    private File file_txt;

    public CompressionRate(File file_bin, File file_txt) {
        this.file_bin = file_bin;
        this.file_txt = file_txt;

    }

    public double getCompressionRate(){
        double file_bin_size = this.file_bin.length();
        double file_txt_size = this.file_txt.length();

        return 1-(file_bin_size/file_txt_size);
    }
}
