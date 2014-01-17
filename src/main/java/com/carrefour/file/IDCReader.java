package com.carrefour.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class IDCReader {

    private File hocidc;
    private LineNumberReader lr;

    public IDCReader(File hocidc) throws IOException {
        this.setHocidc(hocidc);
        lr = new LineNumberReader(new FileReader(hocidc));
    }

    public String readLine() throws IOException {

        String line = lr.readLine();
        if (line != null) {
            return line;
        } else {
            return null;
        }
    }

    public String readLine(int lineNumber) throws IOException {
        lr.setLineNumber(lineNumber);
        return lr.readLine();
    }

    public int currentLineNumber() {
        return lr.getLineNumber();
    }

    public long totalLineNumber() throws IOException {

        long lineNum = 0;
        lr = new LineNumberReader(new FileReader(hocidc));
        lr.readLine();

        String line = lr.readLine();

        System.out.println(line);

        while (line != null) {
            line = lr.readLine();
            lineNum++;
        }

        return lineNum;
    }

    public void setLineNumber(int lineNumber) {
        lr.setLineNumber(lineNumber);
    }

    public File getHocidc() {
        return hocidc;
    }

    public void setHocidc(File hocidc) {
        this.hocidc = hocidc;
    }

}
