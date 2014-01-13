package com.carrefour.operation;

import java.io.IOException;
import java.util.ArrayList;

import com.carrefour.entity.POSTransaction;
import com.carrefour.entity.Product;
import com.carrefour.file.IDCReader;

public class IDCOperation {

	public ArrayList<String> findCashNumbers(IDCReader idcReader) {

		String line;

		try {
			boolean contains = true;
			line = idcReader.readLine();
			String cashNo = line.split(":")[1];

			ArrayList<String> cashNoList = new ArrayList<String>();

			cashNoList.add(cashNo);
			System.out.println(cashNo);

			while (line != null) {

				contains = false;

				for (int i = 0; i < cashNoList.size(); i++) {
					if (cashNoList.get(i).equals(cashNo)) {
						line = idcReader.readLine();

						if (line == null)
							continue;

						cashNo = line.split(":")[1];

						if (cashNo.equals("801"))
							break;

						contains = true;
						break;
					}

				}

				if (cashNo.equals("801"))
					break;
				else if (contains) {
					continue;
				} else {

					cashNoList.add(cashNo);
					System.out.println(cashNo);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

			if (line == null)
				continue;

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
		String transactionType = lineArray[6];

		
		while (line != null) {

			
			lineArray = line.split(":");
			transactionType = lineArray[6];
			
			if (transactionType.equals("H")) {
//				System.out.println(lineArray[4]);
				headerLine = idcReader.currentLineNumber();
				transactionNo = lineArray[4];
				cashNumber = lineArray[1];
//				System.out.println(headerLine);
				System.out.println(line);
//				System.out.println(cashNumber +"   ||   "+transactionNo);
			}
			else if((lineArray[0].equals("FAT ") || lineArray[0].equals("FIS ")))
			{
				if(cashNumber.equals(lineArray[1]) && transactionNo.equals(lineArray[4]))
				{
					
					this.productTransactions(headerLine, fatLine, idcReader);

					fatLine = idcReader.currentLineNumber();
					System.out.println(line);
					
				}
			}
			
			
			line = idcReader.readLine();
		}
		

		return null;
	}
	
	private Product productTransactions(int headerLine, int fatLine, IDCReader idcReader) throws IOException{
		
		for(int i = headerLine; i<fatLine; i++)
			System.out.println(idcReader.readLine(i));
		return null;
	}
}
