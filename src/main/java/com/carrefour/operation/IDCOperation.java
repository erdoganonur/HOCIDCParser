package com.carrefour.operation;

import java.io.IOException;
import java.util.ArrayList;

import com.carrefour.entity.POSTransaction;
import com.carrefour.entity.Product;
import com.carrefour.file.IDCReader;
import com.carrefour.util.FormatDouble;
<<<<<<< HEAD
=======
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a

public class IDCOperation {

    public ArrayList<String> findCashNumbers(IDCReader idcReader) {
<<<<<<< HEAD
            
=======
        try {
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a
            String line;

            boolean contains = true;
            line = idcReader.readLine();
            String cashNo = line.split(":")[1];

            ArrayList<String> cashNoList = new ArrayList<String>();

            cashNoList.add(cashNo);
//            System.out.println(cashNo);

            while (line != null) {

                contains = false;

                for (int i = 0; i < cashNoList.size(); i++) {
                    if (cashNoList.get(i).equals(cashNo)) {
                        line = idcReader.readLine();

                        if (line == null) {
                            continue;
                        }

                        cashNo = line.split(":")[1];

                        if (cashNo.equals("801")) {
                            break;
                        }

                        contains = true;
                        break;
                    }

                }

                if (cashNo.equals("801")) {
                    break;
                } else if (contains) {
                    continue;
                } else {

                    cashNoList.add(cashNo);
                    System.out.println(cashNo);
                }

            }

<<<<<<< HEAD
        
=======
        } catch (IOException ex) {
            Logger.getLogger(IDCOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a

        return null;
    }

    public String findStoreId(IDCReader idcReader) throws Exception {

        String line = idcReader.readLine();
        String storeId = line.split(":")[0];
        String previousStoreId = storeId;

        while (line != null) {

            // System.out.println(storeId);
            if (storeId.equals("FIS ") || storeId.equals("FAT ")) {

                line = idcReader.readLine();
                storeId = line.split(":")[0];
                continue;

            } else if (!storeId.equals(previousStoreId)) {

                throw new Exception(
                        "Dosya da farklı mağaza numaraları mevcut!!");

            }

            // System.out.println(line);
            previousStoreId = storeId;
            line = idcReader.readLine();

            if (line == null) {
                continue;
            }

            storeId = line.split(":")[0];
        }

        return storeId;
    }

    public POSTransaction posTransactions(IDCReader idcReader)
            throws IOException {
        String line = idcReader.readLine();
        String[] lineArray;
        int headerLine = 0;
        int fatLine = 0;
        String transactionNo = null;
        String cashNumber = null;

        lineArray = line.split(":");
        char transactionType = lineArray[6].charAt(0);
        
        while (line != null) {
            
<<<<<<< HEAD
            lineArray = line.split(":");
            transactionType = lineArray[6].charAt(0);

            if (transactionType ==  'H') {
                headerLine = idcReader.currentLineNumber();
                transactionNo = lineArray[4];
                cashNumber = lineArray[1];
                System.out.println("\n"+line);

=======
            System.out.println("Line Number ["+idcReader.currentLineNumber()+"]"+line);
            lineArray = line.split(":");
            transactionType = lineArray[6].charAt(0);
//            System.out.println(""+transactionType);

            if (transactionType ==  'H') {
//				System.out.println(lineArray[4]);
                headerLine = idcReader.currentLineNumber();
                transactionNo = lineArray[4];
                cashNumber = lineArray[1];
//				System.out.println(headerLine);
//                System.out.println(line);
//				System.out.println(cashNumber +"   ||   "+transactionNo);
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a
            } else if ((lineArray[0].equals("FAT ") || lineArray[0].equals("FIS "))) {
                if (cashNumber.equals(lineArray[1]) && transactionNo.equals(lineArray[4])) {

                    this.productTransactions(headerLine, fatLine, idcReader);

                    fatLine = idcReader.currentLineNumber();

                    this.productTransactions(headerLine, fatLine, idcReader);
<<<<<<< HEAD

                    idcReader.setLineNumber(fatLine);
                    
                    System.out.println(line);
=======
                    //System.out.println(line);

                    idcReader.setLineNumber(fatLine);
                    line = idcReader.readLine();
                    //System.out.println(line);
                    continue;
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a
                }
            }

            line = idcReader.readLine();
        }

        return null;
    }

    private Product productTransactions(int headerLine, int fatLine, IDCReader idcReader) throws IOException {
        String[] transactionLine;
        Product product;

        for (int i = headerLine; i < fatLine; i++) {
            transactionLine = idcReader.readLine(i).split(":");

            if (transactionLine[6].charAt(0) == 'S') {
                System.out.println("###########################");
                System.out.println("VAT     :%" + ((int) transactionLine[6].charAt(1) - 64));
                System.out.println("Barcode :" + transactionLine[8].substring(0, 16).trim());
                System.out.println("Unit    :" + transactionLine[8].substring(17, 25));
                System.out.println("UnitType:" + transactionLine[8].charAt(23));
                if (transactionLine[8].charAt(23) == '1') {
                    System.out.println("Unit    :" + Integer.parseInt(transactionLine[8].substring(17, 21)));
                }
                System.out.println("Price   :" + transactionLine[8].substring(26));
                System.out.println("Price   :" + FormatDouble.formatFromString(transactionLine[8].substring(26)));
<<<<<<< HEAD
            }
            else if(transactionLine[6].charAt(0) == 'C')
            {
                System.out.println("Barcode :" + transactionLine[8].trim());
                System.out.println("Discount Price   :" + transactionLine[9].substring(8));
                System.out.println("Discount Price   :" + FormatDouble.formatFromString(transactionLine[9].substring(8)));
=======
>>>>>>> e982a3c7f270f2c6c5235bd475efd2567e251a7a
            }
        }
        return null;
    }
}
