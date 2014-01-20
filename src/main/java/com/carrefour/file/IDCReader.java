package com.carrefour.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;

public class IDCReader {

    private File hocidc;
    private LineNumberReader lr;
<<<<<<< HEAD
    private BufferedReader br;
    private Reader rd;
    private ArrayList<String> idcList;
    private int lineNumber = 0;

    public IDCReader(File hocidc) throws IOException
    {
        this.hocidc = hocidc;
        br = new BufferedReader(new FileReader(hocidc));
        idcList = new ArrayList<String>();

        String line = br.readLine();
        idcList.add(line);

        while (line != null)
        {
            line = br.readLine();
            idcList.add(line);
        }

    }

    public String readLine()
    {

        if (lineNumber >= idcList.size())
        {
            return null;
        }
        
        else 
        {
            String line = idcList.get(lineNumber);
            lineNumber++;

            return line;
        }
            

    }

    public String readLine(int lineNumber) 
    {
        if (lineNumber >= idcList.size())
        {
            return null;
        }
        
        else 
        {
            String line = idcList.get(lineNumber);
            lineNumber++;

            return line;
        }
    }

    public int currentLineNumber()
    {
        return lineNumber;
    }

    public long totalLineNumber() throws IOException
    {

        long lineNum = 0;
        br = new LineNumberReader(new FileReader(hocidc));
        br.readLine();

        String line = br.readLine();

        while (line != null)
        {
            line = br.readLine();
=======

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
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a
            lineNum++;
        }

        return lineNum;
    }

<<<<<<< HEAD
    public void setLineNumber(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public File getHocidc()
    {
        return hocidc;
    }

    public void setHocidc(File hocidc)
    {
=======
    public void setLineNumber(int lineNumber) {
        lr.setLineNumber(lineNumber);
    }

    public File getHocidc() {
        return hocidc;
    }

    public void setHocidc(File hocidc) {
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a
        this.hocidc = hocidc;
    }

}
