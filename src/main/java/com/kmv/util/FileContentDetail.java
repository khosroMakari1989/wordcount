package com.kmv.util;

/**
 *
 * @author khosro.makari@gmail.com
 */
public class FileContentDetail {

    private int lines;
    private int words;
    private int characters;

    public FileContentDetail(int lines, int words, int characters) {
        this.lines = lines;
        this.words = words;
        this.characters = characters;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

}
