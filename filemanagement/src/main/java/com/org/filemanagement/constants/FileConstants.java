package com.org.filemanagement.constants;

import java.util.Arrays;
import java.util.List;

public final class FileConstants {

	//valid file formats
	public static final List<String> fileTypes = Arrays.asList("txt", "pdf");

	public static final String TXT = "txt";
	public static final String PDF = "pdf";

	// Regular expressions
	public static final String REG_EXP_WORD_COUNT = "\\s+";
	public static final String REG_EXP_SPLIT_BY_WHITE_SPACE = "\\r?\\n";
	public static final String REG_EXP_FILE_EXTN_CHECK = "[.]";

}