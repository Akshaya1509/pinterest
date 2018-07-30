package pinterest;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlParser {
    public static List<String> getJavaScriptTags(String htmlcontent) {
            List<String> jslist = new ArrayList<String>();
            Document doc = Jsoup.parse(htmlcontent);
            Elements tags = doc.select("script");
            for (Element e: tags){
                    jslist.add(e.toString());
                    //System.out.println(e.toString()+"\n"); 
           }
            return jslist;
    }

}
