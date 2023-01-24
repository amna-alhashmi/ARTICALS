import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Main {

	public static void main(String[] args) {

		Scanner sa = new Scanner(System.in);
		Boolean Exit = true;

		while (Exit) {
			System.out.println("PLS CHOOSE ONE OPTION:");
			System.out.println("1.Fetch Articals Api");
			System.out.println("2.Fetch Authors Api");
			System.out.println("3.Fetch Section Api");
			System.out.println("4.Create Section Api");
			System.out.println("5.Create Authors Api");
			System.out.println("6.Create Articals Api");
			System.out.println("7.Insert Section Api");
			System.out.println("8.Insert Authors Api");
			System.out.println("9.Insert Articals Api");

			String a = sa.next();
			int option = Integer.parseInt(a);
			switch (option) {
			case 1:
				try {
					URL url = new URL(
							"https://api.nytimes.com/svc/topstories/v2/home.json?api-key=AySQQP5FhXqJIKwSubpFidjoGYsYrTEG");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				try {
					URL url = new URL(
							"https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Ml5uY114dD9aUJXw3sjhF9Hbv8fGxCJL");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				break;
			case 3:
				try {
					URL url = new URL(
							"https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Ml5uY114dD9aUJXw3sjhF9Hbv8fGxCJL");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				break;

			case 4:

				String url2 = "jdbc:mysql://localhost:3306/Api_database";
				String user2 = "root";
				String pass2 = "root";

				String sqlDB2 = "CREATE TABLE SectionsTable " + "(id INTEGER not NULL AUTO_INCREMENT,"
						+ "section_name VARCHAR(100)," + "subsection_name VARCHAR(100) not NULL, "

						+ " PRIMARY KEY ( id ))";

				Connection conn2 = null;
				try {
					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn2 = DriverManager.getConnection(url2, user2, pass2);
					Statement st = conn2.createStatement();
					int m = st.executeUpdate(sqlDB2);
					if (m >= 1) {
						System.out.println("Created table in given database...");

					} else {
						System.out.println(" table already Created in given database...");
					}
					conn2.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}
				break;
			case 5:
				String url1 = "jdbc:mysql://localhost:3306/Api_database";
				String user1 = "root";
				String pass1 = "root";

				String sqlDB1 = "CREATE TABLE AuthorsTable " + "(id INTEGER not NULL AUTO_INCREMENT,"
						+ "firstname VARCHAR(100)," + "middlename VARCHAR(100) not NULL, "
						+ " lastname   VARCHAR(100) , " + " _id   VARCHAR(100) , " + " PRIMARY KEY ( id ))";

				Connection conn1 = null;
				try {
					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn1 = DriverManager.getConnection(url1, user1, pass1);
					Statement st = conn1.createStatement();
					int m = st.executeUpdate(sqlDB1);
					if (m >= 1) {
						System.out.println("Created table in given database...");

					} else {
						System.out.println(" table already Created in given database...");
					}
					conn1.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}

				break;
			case 6:

				String url = "jdbc:mysql://localhost:3306/Api_database";
				String user = "root";
				String pass = "root";

				String sqlDB = "CREATE TABLE ArticalsTable " + "(id INTEGER not NULL AUTO_INCREMENT,"
						+ "title VARCHAR(100)," + " Published_date   VARCHAR(100) , " + " item_type VARCHAR(100) ,"
						+ "Sections_id INTEGER ,"
						+ "FOREIGN KEY (Sections_id) REFERENCES SectionsTable(id) ON DELETE CASCADE ,"
						+ "Authors_id INTEGER ,"
						+ "FOREIGN KEY (Authors_id) REFERENCES AuthorsTable(id) ON DELETE CASCADE ,"
						+ " PRIMARY KEY ( id ))";

				Connection conn = null;
				try {
					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn = DriverManager.getConnection(url, user, pass);
					Statement st = conn.createStatement();
					int m = st.executeUpdate(sqlDB);
					if (m >= 1) {
						System.out.println("Created table in given database...");

					} else {
						System.out.println(" table already Created in given database...");
					}
					conn.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}
				break;
				
			case 7:
				try {
					String url4 = "jdbc:mysql://localhost:3306/api_database";
					String user4 = "root";
					String pass4 = "root";
					
					HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Ml5uY114dD9aUJXw3sjhF9Hbv8fGxCJL")).build();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					String uglyJsonString = response.body();
					
//						System.out.println(uglyJsonString);
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					JsonParser jp = new JsonParser();
					JsonElement je = jp.parse(uglyJsonString);
					String prettyJsonString = gson.toJson(je);
					//System.out.println(prettyJsonString);
					Sections api=gson.fromJson(prettyJsonString,Sections.class);
					Connection conn4 = null;

					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn4 = DriverManager.getConnection(url4, user4, pass4);
					
					for(int i=0;i<api.getResponse().getDocs().length; i++) {
						
						String sqlInserting= "insert into SectionsTable(section_name,subsection_name)"+"values('"+api.getResponse().getDocs()[i].getSection_name()+"','"+api.getResponse().getDocs()[i].getSubsection_name()+"'"+")";
						
						
						System.out.println("SQL:"+sqlInserting);
						
						java.sql.Statement st1 = conn4.createStatement();
						int m = st1.executeUpdate(sqlInserting);
						if (m > 0) { 
							System.out.println("Created table in given database..."+sqlInserting);

						}else { 
							System.out.println(" table already Created in given database...");
						}
						
					}
					conn4.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}	
			
				
				break;
						
			case 8:
				
				try {
					String url4 = "jdbc:mysql://localhost:3306/api_database";
					String user4 = "root";
					String pass4 = "root";
					
					HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Ml5uY114dD9aUJXw3sjhF9Hbv8fGxCJL")).build();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					String uglyJsonString = response.body();
					
					//System.out.println(uglyJsonString);
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					JsonParser jp = new JsonParser();
					JsonElement je = jp.parse(uglyJsonString);
					String prettyJsonString = gson.toJson(je);
					//System.out.println(prettyJsonString);
					Sections api=gson.fromJson(prettyJsonString,Sections.class);
					Connection conn4 = null;

					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn4 = DriverManager.getConnection(url4, user4, pass4);
					
					for(int i=0;i< api.getResponse().getDocs().length; i++) {
						
						String sqlInserting= "insert into AuthorsTable(firstname,middlename,lastname,_id)"+
						"values('"+api.getResponse().getDocs()[i].getByline().getPerson()[0].getFirstname()+"','"+api.getResponse().getDocs()[i].getByline().getPerson()[0].getMiddlename()+"','"+api.getResponse().getDocs()[i].getByline().getPerson()[0].getLastname()+"','"+api.getResponse().getDocs()[i].get_id()+"'"+")";
						
						
						//System.out.println("SQL:"+sqlInserting);
						
						java.sql.Statement st1 = conn4.createStatement();
						int m = st1.executeUpdate(sqlInserting);
						if (m > 0) { 
							System.out.println("iserted into table is success..."+sqlInserting);

						}else { 
							System.out.println(" iserted into table is faild...");
						}
						
					}
					conn4.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}	
		
				break;
			case 9:
				try {
					String url5 = "jdbc:mysql://localhost:3306/HotelDBMS";
					String user5 = "root";
					String pass5 = "root";
					
					Scanner sa5=new Scanner(System.in);
					System.out.println("How many Rooms you wants:");
					int ROOM2=sa5.nextInt();
					
					String created_date = "2023-01-01";
					String updated_date = "2022-12-6";
					boolean is_Active = true;

					Random rn = new Random();
					Integer numberToAdd = rn.nextInt(100);

					for (int i = 1; i <=ROOM2; i++) {
//						Scanner sa = new Scanner(System.in);
//						System.out.println("enter room type you want?");
//						String number3 = sa.next();
//						System.out.println("enter hotel name you want?");
//						String number4 = sa.next();
						// Integer id=1;
//						String sql1 ="insert into Rooms (Rooms, id) select Rooms, id from room_type where id ="+number3+","+"select Rooms, id from hotel_name where id ="+number4+")";
//						String hotel_id = "SELECT id FROM Hotels WHERE hotel_name="+number4;
						String sql1 = "INSERT INTO Rooms VALUES (" + i + ","+3+",'" +280+"','"+created_date+"','"+updated_date+"',"+is_Active+")";
						//String sql = "INSERT INTO Rooms VALUES (" + i + numberToAdd  + "SELECT id FROM room_type WHERE room_type_name="+number3
								//+ "SELECT id FROM hotels WHERE hotel_name="+number4 + ",'" + created_date + "','" + updated_date + "'," + is_Active + ")";

						Connection conn5 = null;

						Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						DriverManager.registerDriver(driver);
						conn = DriverManager.getConnection(url5, user5, pass5);
						Statement st = conn.createStatement();
						int m = st.executeUpdate(sql1);
						if (m >= 1) {
							System.out.println("Created table in given database...");

						} else {
							System.out.println(" table already Created in given database...");
						}
						conn5.close();
					}
				} catch (Exception ex) {
					System.err.println(ex);
				}
				
				
				
				
				break;
			}

		}
		Exit = false;
	}
}