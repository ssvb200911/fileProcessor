package com.org.filemanagement.fileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.org.filemanagement.model.FileData;
import com.org.filemanagement.operations.IFileReader;

public class TextFileReader implements IFileReader {

	@Override
	public FileData readFileContent(File file) {

		FileData fileData = new FileData();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			while (line != null) {
				fileData.getFileContent().append(line);
				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return fileData;
	}

}
