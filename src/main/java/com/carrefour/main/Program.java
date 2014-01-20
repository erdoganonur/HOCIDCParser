package com.carrefour.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.carrefour.file.IDCReader;
import com.carrefour.operation.IDCOperation;

public class Program {

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

//        File hocidc = new File("C:\\Users\\erdoganon\\Desktop\\HOCIDC.001");
//        File hocidc = new File("C:\\Users\\erdoganon\\Desktop\\S_IDC\\S_IDC001.DAT");
//        File hocidc = new File("\\\\10.181.81.1\\ccc\\server\\data\\S_IDC001.DAT");
        File hocidc = new File("/Users/onurerdogan/Desktop/S_IDC/S_IDC001.DAT");

        try
        {
//			IDCReader idcReader = new IDCReader(hocidc);
//
//			String line = idcReader.readLine();
//
//			while (line != null) {
//				System.out.println(line);
//				line = idcReader.readLine();
//			}
//
//			System.out
//					.println("\n\nTotal Line :" + idcReader.totalLineNumber());

            IDCOperation idcOperation = new IDCOperation();

            long start = System.currentTimeMillis();
            String storeId = idcOperation.findStoreId(new IDCReader(hocidc));
            System.out.println("MAĞAZA KODU :" + storeId);
            idcOperation.findCashNumbers(new IDCReader(hocidc));
            long stop = System.currentTimeMillis();

            long total = stop - start;

            idcOperation.posTransactions(new IDCReader(hocidc));
            System.out.println("TOTAL TIME :" + total + " ms");

        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
