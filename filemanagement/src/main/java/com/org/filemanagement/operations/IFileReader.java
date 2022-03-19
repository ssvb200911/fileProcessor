package com.org.filemanagement.operations;

import java.io.File;

import com.org.filemanagement.constants.FileConstants;
import com.org.filemanagement.model.FileData;

public interface IFileReader {

	public default int countNoWords(String fileLine) {
		if (fileLine != null) {
			return fileLine.split(FileConstants.REG_EXP_WORD_COUNT).length;
		}
		return 0;
	}

	public abstract FileData readFileContent(File file);

	public default int countSpecialChar(String s) {
		int specialCharCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isWhitespace(c)) {
				specialCharCount++;
			}
		}
		return specialCharCount;
	}
}
