package com.org.filemanagement.fileReaders;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.org.filemanagement.constants.FileConstants;
import com.org.filemanagement.model.FileData;
import com.org.filemanagement.operations.IFileReader;

public class PdfFileReader implements IFileReader {

	@Override
	public FileData readFileContent(File fileName) {

		FileData fileData = new FileData();
		PDDocument document = null;
		try {
			document = PDDocument.load(fileName);
			document.getClass();
			if (!document.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper tStripper = new PDFTextStripper();
				String pdfFileInText = tStripper.getText(document);
				// split by whitespace
				String lines[] = pdfFileInText.split(FileConstants.REG_EXP_SPLIT_BY_WHITE_SPACE);
				for (String line : lines) {
					fileData.getFileContent().append(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return fileData;
	}
}
