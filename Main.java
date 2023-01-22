import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sa = new Scanner(System.in);
		Boolean Exit=true;
		
		while(Exit) {
			System.out.println("PLS CHOOSE ONE OPTION:");
			System.out.println("1.Fetch Articals Api");
			System.out.println("2.Fetch Authors Api");
			System.out.println("3.Fetch Section Api");
			System.out.println("4.Create Section Api");
			System.out.println("5.Create Authors Api");
			System.out.println("6.Create Articals Api");

			String a = sa.next();
			int option = Integer.parseInt(a);
			switch (option) {
		case 1:
			try {
				URL url = new URL("https://api.nytimes.com/svc/topstories/v2/home.json?api-key=AySQQP5FhXqJIKwSubpFidjoGYsYrTEG");
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
				URL url = new URL("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Ml5uY114dD9aUJXw3sjhF9Hbv8fGxCJL");
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
				URL url = new URL("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Ml5uY114dD9aUJXw3sjhF9Hbv8fGxCJL");
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

			String sqlDB2 = "CREATE TABLE SectionsTable " + "(id INTEGER not NULL AUTO_INCREMENT," +"section_name VARCHAR(100),"+"subsection_name VARCHAR(100) not NULL, "
			
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

			String sqlDB1 = "CREATE TABLE AuthorsTable " + "(id INTEGER not NULL AUTO_INCREMENT," +"firstname VARCHAR(100),"+"middlename VARCHAR(100) not NULL, "
					+ " lastname   VARCHAR(100) , " + " _id   VARCHAR(100) , " 
					 + " PRIMARY KEY ( id ))";

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

			String sqlDB = "CREATE TABLE ArticalsTable " + "(id INTEGER not NULL AUTO_INCREMENT," +"title VARCHAR(100),"+
					 " Published_date   VARCHAR(100) , "+" item_type VARCHAR(100) ,"
					 +"Sections_id INTEGER ,"
						+ "FOREIGN KEY (Sections_id) REFERENCES SectionsTable(id) ON DELETE CASCADE ,"+
						"Authors_id INTEGER ,"
						+ "FOREIGN KEY (Authors_id) REFERENCES AuthorsTable(id) ON DELETE CASCADE ,"+
					 " PRIMARY KEY ( id ))";

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
	}

}Exit=false;
}
}