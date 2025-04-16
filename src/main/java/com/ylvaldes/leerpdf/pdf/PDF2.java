package com.ylvaldes.leerpdf.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.fit.pdfdom.PDFDomTree;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PDF2 {
	private static final Logger log =  LogManager.getLogger(PDF2.class);

	/*
	 * Comvierte el documento PDF pasado por parametro a HTML
	 **/
	public static void hTML(String filename, String output) throws ParserConfigurationException, IOException {
		log.info("PDF2HTML()");
		PDDocument pdf = PDDocument.load(new File(filename));
		PDFDomTree parser = new PDFDomTree();
		Writer output1 = new PrintWriter(output, "utf-8");
		parser.writeText(pdf, output1);
		output1.close();
		if (pdf != null) {
			pdf.close();
		}
	}

	public static void imagen(String filename, String extension, String output) throws IOException {
		log.info("PDF2Imagen()");
		PDDocument document = PDDocument.load(new File(filename));
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		for (int page = 0; page < document.getNumberOfPages(); ++page) {
			BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
			ImageIOUtil.writeImage(bim, String.format(output + "/pdf-%d.%s", page + 1, extension), 300);
		}
		document.close();
	}

	public static void txt(String filename, String output) throws IOException {
		log.info("PDF2TXT()");
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

		PrintWriter pw = new PrintWriter(output);
		pw.print(parsedText);
		pw.close();
	}

	public static void doc(String filename, String output) throws IOException {
		log.info("PDF2DOC()");
		XWPFDocument doc = new XWPFDocument();

		String pdf = filename;
		PdfReader reader = new PdfReader(pdf);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);

		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			TextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			String text = strategy.getResultantText();
			XWPFParagraph p = doc.createParagraph();
			XWPFRun run = p.createRun();
			run.setText(text);
			run.addBreak(BreakType.PAGE);
		}
		FileOutputStream out = new FileOutputStream(output + "/pdf.docx");
		doc.write(out);
		out.close();
		reader.close();
		doc.close();
	}
}
