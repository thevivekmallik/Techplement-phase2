package com.techplement.filecompression;
import java.io.*;
import java.util.zip.GZIPOutputStream; // with this we only able to compress single file
import java.util.zip.ZipEntry; // zipEntry allow to compress multiple files
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // string array to compress the files
        // please update the path according to where you place that directory
        String[] inputPath = {
                "E:\\Techplement\\Week-2\\Techplement-phase2\\src\\com\\techplement\\filecompression\\input.txt",
                "E:\\Techplement\\Week-2\\Techplement-phase2\\src\\com\\techplement\\filecompression\\images.jpeg",
                "E:\\Techplement\\Week-2\\Techplement-phase2\\src\\com\\techplement\\filecompression\\factorial.png"
        }; // This three files we have to compress

        try {
            compressFile(inputPath, "compressed.zip");
            System.out.println("File Compressed....");
        } catch (Exception e) {
            System.out.println("Exception " + e.getLocalizedMessage());
        }
    }

    public static void compressFile(String[] sourcefiles, String compressfile) throws IOException {
        
        FileOutputStream fileOutputStream = new FileOutputStream(compressfile);
        
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        
        // To compress multiple files in Java, you can iterate through each file and
        // compress it individually.
        for (String sourcefileiterator : sourcefiles) {
            
            File file = new File(sourcefileiterator);
            FileInputStream fileInputStream = new FileInputStream(file);
            
            // java.util.zip package: This package provides classes for reading and writing
            // the standard ZIP and GZIP file formats.
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int contents;
            while ((contents = fileInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, contents);
            }
            fileInputStream.close();
        }
        zipOutputStream.close();
        fileOutputStream.close();
    }
}
