package com.kmv.util;

import com.kmv.WordCounterMain;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author khosro.makari@gmail.com
 */
public final class FileUtil {

    private static final Logger LOGGER = Logger.getLogger(WordCounterMain.class.getName());

    private FileUtil() {
        throw new IllegalArgumentException();
    }

    public static FileContentDetail getFileContentDetails(String path) {
        int lines = 0, words = 0, characters = 0;
        int sizeOfRead = 4 * 1024;
        URL url = WordCounterMain.class.getClassLoader().getResource(path);
        if (url == null) {
            throw new RuntimeException("filePath is wrong!");
        }
        String filePath = url.getFile();
        try (Reader reader = new FileReader(filePath); BufferedReader bufferedReader = new BufferedReader(reader, sizeOfRead);) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines++;
                if (line.trim().equals("")) {
                    line = bufferedReader.readLine();
                    continue;
                }
                String[] wordsArray = line.trim().split("[ ,\\.]+");
                words += wordsArray.length;
                characters += Stream.of(wordsArray).mapToInt(w -> w.length()).sum();
                line = bufferedReader.readLine();
            }
            return new FileContentDetail(lines, words, characters);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new UncheckedIOException(ex);
        }

    }
}
