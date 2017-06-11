package org.global.fairy.bigdata.mapreduce;

import org.junit.Test;



public class TestDataTotalMapReduce {
	@Test
	public void testStringSplit(){
		String lineValue = "18561597073     2       3       4       5       6       7       8       9       10      11      12";
		
		String[] strs = lineValue.split("    ");
		for(String str : strs){
			System.out.print(str+"#");
		}
	}

}
