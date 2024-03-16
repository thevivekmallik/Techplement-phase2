package com.techplement.filecompression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class FileCompressionUtility {
	    public static void main(String[] args) {
	        // Check if the correct number of arguments is provided
	        if (args.length != 2) {
	            System.out.println("Usage: java FileCompressionUtility <inputFile> <outputFile>");
	            return;
	        }

	        String inputFile = args[0];
	        String outputFile = args[1];

	        // Compress the input file
	        compressFile(inputFile, outputFile);

	        // Decompress the output file (optional)
	        // decompressFile(outputFile, "decompressed_" + inputFile);
	    }

	    public static void compressFile(String inputFile, String outputFile) {
	        try (FileInputStream fis = new FileInputStream(inputFile);
	             FileOutputStream fos = new FileOutputStream(outputFile);
	             DeflaterOutputStream dos = new DeflaterOutputStream(fos)) {

	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                dos.write(buffer, 0, bytesRead);
	            }

	            System.out.println("File compressed successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void decompressFile(String inputFile, String outputFile) {
	        try (FileInputStream fis = new FileInputStream(inputFile);
	             FileOutputStream fos = new FileOutputStream(outputFile);
	             InflaterInputStream iis = new InflaterInputStream(fis)) {

	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = iis.read(buffer)) != -1) {
	                fos.write(buffer, 0, bytesRead);
	            }

	            System.out.println("File decompressed successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
