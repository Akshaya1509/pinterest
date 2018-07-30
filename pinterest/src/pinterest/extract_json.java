package pinterest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.io.*;


	public class extract_json {


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String responsedata="";
		try{
	    System.out.println("test");
	    String urlstring = "https://www.pinterest.com/OnlineShoes/";
	    responsedata=SyncCrawl.getMethod(urlstring,true);
		  try{    
	           FileWriter fw=new FileWriter("/home/akshaya/eclipse/shoes_boards.html");      
	           fw.write(responsedata);    
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    

		
		}catch(Exception e){ System.out.println(e);}
		
		List<String> all_scripts = new ArrayList<String>(); 
		all_scripts = HtmlParser.getJavaScriptTags(responsedata);
		for (int i=0;i < all_scripts.size();i++)
		{
			if (all_scripts.get(i).contains("jsInit1"))
			{
				//System.out.println("Value of element "+i + ":"+all_scripts.get(i));
				String temp =all_scripts.get(i);
				temp=temp.replace("<script type=\"application/json\" id=\"jsInit1\">", "");
				temp=temp.replace("</script>","");	
				board_parser.parseJson(temp);
				
				
			}
			
		  
		}
		
	}

}
