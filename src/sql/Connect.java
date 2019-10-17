package sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Actor;

public class Connect {

	private static String url = "jdbc:sqlite:C:/Users/Ira/Desktop/MOE/3course/Java EE/theaterDb.db";

	public static ArrayList<Actor> select() {
		Connection conn = null;
		ArrayList<Actor> actors = new ArrayList<Actor>();

		try {
			try {
				Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String lastname = resultSet.getString(3);
				String gender = resultSet.getString(4);
				Actor actor = new Actor(id, name, lastname, gender);
				actors.add(actor);
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
		return actors;
	}
	
	 public static Actor selectOne(int id) {
		Connection conn = null;
		Actor actor = null;
		try {
			try {
				Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM actor WHERE id_actor = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){

                    int id_a = resultSet.getInt(1);
                    String firstname = resultSet.getString(2);
                    String lastname = resultSet.getString(3);
                    String gender = resultSet.getString(4);
                    actor = new Actor(id_a, firstname, lastname, gender);
                }

				

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return actor;
	}

	public static int insert(Actor actor) {
		Connection conn = null;
		try {
			try {
				Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "INSERT INTO Actor (firstname, lastname, gender) Values (?, ?, ?)";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setString(1, actor.getFirstname());
				preparedStatement.setString(2, actor.getLastname());
				preparedStatement.setString(3, actor.getGender());

				return preparedStatement.executeUpdate();

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}
	public static int update(Actor actor) {
		Connection conn = null;
		try {
			try {
				Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "UPDATE actor SET firstname = ?, lastname = ?, gender = ? WHERE id_actor = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setString(1, actor.getFirstname());
				preparedStatement.setString(2, actor.getLastname());
				preparedStatement.setString(3, actor.getGender());
				preparedStatement.setInt(4, actor.getId());

				return preparedStatement.executeUpdate();

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}
	
	public static int delete(int id) {
		Connection conn = null;
		try {
			try {
				Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

			conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "DELETE FROM actor WHERE id_actor = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);
			

				return preparedStatement.executeUpdate();

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

}