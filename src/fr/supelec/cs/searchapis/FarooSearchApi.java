package fr.supelec.cs.searchapis;

import java.util.List;

import de.tudarmstadt.ke.jfreewebsearch.farooObjects.FarooResult;
import de.tudarmstadt.ke.jfreewebsearch.farooObjects.FarooResultSet;
import de.tudarmstadt.ke.jfreewebsearch.query.FarooQueryPoint;

public class FarooSearchApi {
	
	public static void main(String[] args) {
		String key = "2@3tw8OdoC81Zx-1Dt1tzE3B1vI_";
		FarooQueryPoint fq = new FarooQueryPoint(key);
		FarooResultSet results = fq.query("Mohammad Ghufran");
		
		System.out.println("# of results: " + results.getNrOfResults());
		
		List<FarooResult> resultList = results.getResults();
		
		for(int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i).getIurl() + "\n" + resultList.get(i).getTitle() + "\n" + resultList.get(i).getTextSnippet() + "\n\n");	
		}
		
	}
}
