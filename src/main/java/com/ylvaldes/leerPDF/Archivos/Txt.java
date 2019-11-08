package com.ylvaldes.leerPDF.Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Txt {
	String filename;
	String output;

	public Txt(String filename, String output) {
		this.filename = filename;
		this.output = output;
	}

	public String crearTxt() throws FileNotFoundException, IOException {
		File f = new File(filename);
		String parsedText;
		PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
		parser.parse();

		COSDocument cosDoc = parser.getDocument();

		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument pdDoc = new PDDocument(cosDoc);

		parsedText = pdfStripper.getText(pdDoc);

		if (cosDoc != null)
			cosDoc.close();
		if (pdDoc != null)
			pdDoc.close();

		PrintWriter pw = new PrintWriter(output, "utf-8");
		pw.print(parsedText);
		pw.close();
		return parsedText;
	}
}
