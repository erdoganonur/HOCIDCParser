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
            lineNum++;
        }

        return lineNum;
    }

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
        this.hocidc = hocidc;
    }

}
