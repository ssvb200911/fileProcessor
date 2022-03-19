package com.org.filemanagement.factory;

import com.org.filemanagement.constants.FileConstants;
import com.org.filemanagement.fileReaders.PdfFileReader;
import com.org.filemanagement.fileReaders.TextFileReader;
import com.org.filemanagement.operations.IFileReader;

public class FileFactory {

	public static IFileReader getFileReader(String fileType) {

		if (FileConstants.TXT.equalsIgnoreCase(fileType)) {
			return new TextFileReader();
		} else if (FileConstants.PDF.equalsIgnoreCase(fileType)) {
			return new PdfFileReader();
		} else {
			return new TextFileReader();
		}
	}
}
