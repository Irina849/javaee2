package sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Actor;
import model.Event;

public class ConnEvent {

	private static String url = "jdbc:sqlite:C:/Users/Ira/Desktop/MOE/3course/Java EE/theaterDb.db";

	public static ArrayList<Event> select() {
		Connection conn = null;
		ArrayList<Event> events = new ArrayList<Event>();

		try {
			try {
				Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM event");
			while (resultSet.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				
				int id = resultSet.getInt(1);
				String title_event = resultSet.getString(2);
				Date performance_date = resultSet.getDate(3);
			
				String comment_about_event = resultSet.getString(4);
				Event event = new Event(id, title_event, performance_date, comment_about_event);
				events.add(event);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return events;
	}
	
	

}