package com.linage.transform;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author edwin permana
 * This class connect to Impala and Transform
 */
public class ClouderaImpala {
	

	
	
	public static void main(String[] args) {
		
		try {
			ConsolidateInventory tt =  new ConsolidateInventory("hj_mapping.properties","hj_transform.properties");
			String cmd= "impala-shell -q "+"\"USE STAGING;" +tt.buildSQL()+"\"";  
			System.out.println("Executing: \n" );
		
	
			PrintWriter out = new PrintWriter("hj_transform.sh");
			out.println(cmd);
			out.close();
			
			ConsolidateInventory ta =  new ConsolidateInventory("in_mapping.properties","in_transform.properties");
			String cmds= "impala-shell -q "+"\"USE STAGING;" +ta.buildSQL()+"\"";  
			System.out.println("Executing: \n" );
		
	
			PrintWriter outs = new PrintWriter("in_transform.sh");
			outs.println(cmds);
			outs.close();
			
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	
	}
}
