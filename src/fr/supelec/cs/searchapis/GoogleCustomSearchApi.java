package fr.supelec.cs.searchapis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleCustomSearchApi {
	//Api Key: https://developers.google.com/custom-search/json-api/v1/introduction
	//customSearchEngineKey: https://www.google.com/cse/setup/basic?cx=001235157744831495461%3Akiks7nxbwru
	final static String apiKey = "AIzaSyAUU0nnt1C1PfW1CAi0fWhs58btBIGnSmQ";
	final static String customSearchEngineKey = "001235157744831495461:kiks7nxbwru";
	
	final static  String searchURL = "https://www.googleapis.com/customsearch/v1?";
	
	private static String makeSearchString(String qSearch, int start, boolean prettyPrint)
	{
	    String toSearch = searchURL + "key=" + apiKey + "&cx=" + customSearchEngineKey+"&q=";
	     
	    //replace spaces in the search query with +
	    String keys[]=qSearch.split("[ ]+");
	    for(String key:keys)
	    {   
	        toSearch += key +"+"; //append the keywords to the url
	   }        
	     
	        //specify response format as json
	        toSearch+="&alt=json";
	    
	        //specify starting result number
	        if (start > 0)
	        	toSearch+="&start="+start;
	     
	        toSearch += prettyPrint ? "&prettyPrint=true" : "&prettyPrint=false";
	        
	        //specify the number of results you need from the starting position
	        //toSearch+="&num="+numOfResults;
	     
	    return toSearch;
	}
	
	private static String read(String pUrl)
	{
	    //pUrl is the URL we created in previous step
	    try
	   {
	        URL url=new URL(pUrl);
	        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
	        BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        StringBuffer buffer=new StringBuffer();
	        while((line=br.readLine())!=null){
	            buffer.append(line);
	        }
	        return buffer.toString();
	    }catch(Exception e){
	        e.printStackTrace();
	   }
	    return null;
	}
	
	public static void main(String[] args) {
		String searchString = GoogleCustomSearchApi.makeSearchString("mohammad ghufran", 0, true);
		System.out.println(searchString);
		String results = GoogleCustomSearchApi.read(searchString);
		System.out.println(results);
	}

}
