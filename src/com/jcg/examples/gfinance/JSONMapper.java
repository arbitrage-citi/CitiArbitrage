package com.jcg.examples.gfinance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JSONMapper {
	public  Stocks[] call()
			throws FileNotFoundException, IOException, ParseException, URISyntaxException {
        sensexData s=new sensexData();
        nseData n=new nseData();
		// google_finance.gfinance.sensexData sd = new
		// google_finance.gfinance.sensexData();
		//s.call();
		System.out.println("sensexData.call()");

		// google_finance.gfinance.nseData nd = new
		// google_finance.gfinance.nseData();
		//n.call();
		System.out.println("nseData.call()");

		Stocks[] stock_obj = new Stocks[50];
		   for( int i=0; i<50; i++ )
		       stock_obj[i] = new Stocks();
		System.out.println("Stocks obj");
		int i = 1, j = 1;
		float[] diffper = new float[51];
		float[] diff = new float[51];
		String[] CName = new String[51];
		CName[1] = "ACC Cement";
		CName[2] = "AI Champdany";
		CName[3] = "Vaibhav Global";
		float[] l_fixN = new float[51];
		float[] l_fixB = new float[51];
		int[] check= new int[51];

		JSONParser parser = new JSONParser();
		JSONObject stockB, stockN;
		JSONArray jsonArrayN = (JSONArray) parser.parse(new FileReader("/home/asmita/workspace-sts-3.8.2.RELEASE/SpringMVCloginExample/outN.txt"));
		JSONArray jsonArrayB = (JSONArray) parser.parse(new FileReader("/home/asmita/workspace-sts-3.8.2.RELEASE/SpringMVCloginExample/outB.txt"));
		// System.out.println("1 opportunity exists! Sell at BSE. Buy at NSE");

		for (Object oN : jsonArrayN) {
			stockN = (JSONObject) oN;
			//System.out.println("2 opportunity exists! Sell at BSE. Buy at NSE");

			float l_fix1 = Float.parseFloat((String) stockN.get("l_fix"));
			System.out.println(l_fix1);
			//System.out.println(l_fix2);

			j = 1;
			for (Object oB : jsonArrayB) {
				stockB = (JSONObject) oB;
				float l_fix2 = Float.parseFloat((String) stockB.get("l_fix"));
				// System.out.println("3 opportunity exists! Sell at BSE. Buy at
				// NSE");

				if (i == j) {
					
					diff[i] = Math.abs(l_fix1 - l_fix2);
					diffper[i] = ((diff[i] / l_fix1) * 100);

					if (l_fix1 >= 20 && l_fix2 >= 20 && diffper[i] >= 2) {
						l_fixN[i] = l_fix1;
						l_fixB[i] = l_fix2;
						System.out.println(l_fix1);
						System.out.println(l_fix2);
						if (l_fix1 > l_fix2) {
							System.out.println("Nse greater");
							stock_obj[i].setDiff(diff[i]);
							stock_obj[i].setDiffper(diffper[i]);
							stock_obj[i].setL_fixB(l_fixB[i]);
							stock_obj[i].setL_fixN(l_fixN[i]);
							System.out.println("Arbitrage opportunity exists! Sell at NSE. Buy at BSE");
							System.out.println(stockN.get("t"));
							System.out.println("stocks object are set");
							//check[i]=1;
							
						} else if (l_fix1 < l_fix2) {
							//check[1]=2;
							System.out.println("2 object will be set");
							stock_obj[i].setCName("ACC Cement");
							System.out.println(stock_obj[i].getCName());
							stock_obj[i].setDiff(diff[i]);
							stock_obj[i].setDiffper(diffper[i]);
							stock_obj[i].setL_fixB(l_fixB[i]);
							stock_obj[i].setL_fixN(l_fixN[i]);
							
							System.out.println("2 object are set");
							System.out.println(stockN.get("t"));
							System.out.println("Arbitrage opportunity exists! Sell at BSE. Buy at NSE");

							
						}
					} else {
						l_fixN[i] = -99999;
						l_fixB[i] = -99999;

					}
				}
				j++;

			}
			i++;
		}
		return stock_obj;
		
		
		

		//
		// for (Object o : jsonArray) {
		// stockN = (JSONObject) o;
		//
		// int id = Integer.parseInt((String) stockN.get("id"));
		// System.out.println("ID::" + id);
		// String t = (String) stockN.get("t");
		// System.out.println("Name::" + t);
		//
		//
		// String e = (String) stockN.get("e");
		// System.out.println("Exchange::" + e);
		//
		// double l_fix=Double.parseDouble((String) stockN.get("l_fix"));
		// System.out.println("Value"+l_fix);
		//
		// }
		//
		// JSONArray jsonArrayB = (JSONArray) parser.parse(new FileReader(
		// "outB.txt"));
		//
		//
		// for (Object o : jsonArrayB) {
		// stockB = (JSONObject) o;
		//
		// int id = Integer.parseInt((String) stockB.get("id"));
		// System.out.println("ID::" + id);
		// String t = (String) stockB.get("t");
		// System.out.println("Name::" + t);
		//
		//
		// String e = (String) stockB.get("e");
		// System.out.println("Exchange::" + e);
		//
		// double l_fix=Double.parseDouble((String) stockB.get("l_fix"));
		// System.out.println("Value"+l_fix);
		//
		// }

	}

}
