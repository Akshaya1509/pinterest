package pinterest;

import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;

import org.json.JSONArray;

public class board_parser {

	public static void parseJson(String temp) throws Exception
	{
		int no_of_boards,i,board_pin_count = 0;
		String board = "0",board_url,board_id,board_name,owner_username,owner_user_id,user_username,user_id,user_full_name=null,user_img_url,user_href;	
		board_url=board_id=board_name=owner_username=owner_user_id=user_username=user_id=user_full_name=user_img_url=user_href = null;
		JSONObject obj = new JSONObject(temp);
		no_of_boards = (int)(obj.getJSONObject("initialPageInfo").getJSONObject("meta").getInt("pinterestapp:boards"));
		for (i=0; i < no_of_boards; i++)
		{
			board_pin_count = (int) obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getInt("pin_count");
			board_url = user_href = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getString("url");
			board_id = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getString("id");
			board_name = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getString("name");
			owner_username = user_username = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getJSONObject("owner").getString("username");
			owner_user_id = user_id = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getJSONObject("owner").getString("id");
			user_full_name = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getJSONObject("owner").getString("full_name");
			user_img_url = obj.getJSONArray("resourceDataCache").getJSONObject(0).getJSONObject("data").getJSONArray("boards").getJSONObject(i).getJSONObject("owner").getString("image_medium_url");
			System.out.println("board "+i+ ":\n-----------\n"+"pins_count:"+ board_pin_count+"\nboard url:"+board_url+"\nboard id:"+board_id+"\nboard name:"+board_name+"\nowner username:"+owner_username+"\nowner user id:"+owner_user_id+"\nuser username:"+user_username+"\nuser id:"+user_id+"\nuser_full_name:"+user_full_name+"\nuser_img_url"+user_img_url+"\nuser_href:"+user_href+"\n------------\n");
		}
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/catalog_manager","root","root");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select id from catalog_source where name like '%"+owner_username+"%' or name like '%"+user_full_name+"%'");   
			while(rs.next())
			System.out.println("entity_id :"+rs.getInt(1));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
