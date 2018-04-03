package com.kmv;

import com.kmv.util.FileContentDetail;
import com.kmv.util.FileUtil;

/**
 * Read a file from classpath and count the lines, words and
 * characters and print the results A "word" is everything that is separated by
 * a white-space, e.g. " one, two 123 four " is 4 words. Punctuation characters
 * like "." and "," are treated as white space. Whitespace and newlines are no
 * characters.
 * <p>
 * Write the code as if it were production code!
 * <p>
 * Java version: JDK 8
 */
public class WordCounterMain {

    private static final String fileToCount = "example.txt";

    public static void main(String[] args) {
        FileContentDetail fileContentDetail = FileUtil.getFileContentDetails(fileToCount);
        System.out.println("lines: " + fileContentDetail.getLines());
        System.out.println("words: " + fileContentDetail.getWords());
        System.out.println("characters: " + fileContentDetail.getCharacters());

    }

}
