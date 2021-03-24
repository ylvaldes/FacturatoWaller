package com.ylvaldes.leerpdf.pdf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PDFFrom {
	private static final Logger log =  LogManager.getLogger(PDFFrom.class);

	private static void hTML(String filename) throws ParserConfigurationException, IOException, DocumentException {
		log.info("PDFFromHTML()");
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/output/html.pdf"));
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
		document.close();
	}

	private static void image(String filename, String extension)
			throws IOException, BadElementException, DocumentException {
		log.info("PDFFromImage()");
		Document document = new Document();
		String input = filename + "." + extension;
		String output = "src/output/" + extension + ".pdf";
		FileOutputStream fos = new FileOutputStream(output);
		PdfWriter writer = PdfWriter.getInstance(document, fos);
		writer.open();
		document.open();
		document.add(Image.getInstance((new URL(input))));
		document.close();
		writer.close();
	}

	private static void txt(String filename) throws IOException, DocumentException {
		log.info("PDFFromTXT()");
		Document pdfDoc = new Document(PageSize.A4);
		PdfWriter.getInstance(pdfDoc, new FileOutputStream("src/output/txt.pdf"))
				.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
		pdfDoc.open();

		Font myfont = new Font();
		myfont.setStyle(Font.NORMAL);
		myfont.setSize(11);
		pdfDoc.add(new Paragraph("\n"));

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			Paragraph para = new Paragraph(strLine + "\n", myfont);
			para.setAlignment(Element.ALIGN_JUSTIFIED);
			pdfDoc.add(para);
		}

		pdfDoc.close();
		br.close();
	}
}
