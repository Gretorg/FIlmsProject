package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Actor_Film;
import model.Crew;
import model.Crew_film;
import model.Film;
import model.Role;



public class ProductDAO {
	private String jdbcURL = "jdbc:mysql://localhost/filmes?serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_FILMS_SQL = "INSERT INTO  film" + " (id,name,year,genre) VALUES "+ " (NULL,?, ?, ?);";
	private static final String SELECT_FILMS_BY_ID = "select * from film where id =?";
	private static final String SELECT_ALL_FILMS = "select * from film";
	private static final String DELETE_FILMS_SQL = "delete from film where id = ?;";
	private static final String UPDATE_FILMS_SQL = "update film set name = ?,year= ? ,genre= ? where id = ?;";
	
	private static final String SELECT_ACTOR_BY_ID = "select * from actor where actor_id =?";
	private static final String SELECT_ALL_ACTORS = "SELECT * FROM actor";
	private static final String INSERT_ACTOR = "INSERT INTO actor"+"(actor_id,actor_name,actor_surname) VALUES"+"(NULL,?,?)";
	private static final String DELETE_ACTOR = "delete from actor where actor_id=?;";
	private static final String UPDATE_ACTOR = "update actor set actor_name=?,actor_surname=? where actor_id=?;";
	
	private static final String SHOW_ACTORS_FROM="select actor.*,actor_film.* from actor,actor_film WHERE actor.actor_id = actor_film.actor_id;";
	
	private static final String SHOW_ACTORS_FROM_FILM="select actor.*,actor_film.*\n" + "from actor,actor_film\n" + 
													"WHERE actor.actor_id = actor_film.actor_id\n" + "and actor_film.id =?;";
	
	private static final String INSERT_ROLE="INSERT INTO actor_film (id,actor_id,role) VALUES(?,NULL,?)";
	
	private static final String INSERT_CREW_SQL = "INSERT INTO  crew" + "(film_id,film_director,film_doph,film_composer) VALUES "+ " (?,?, ?, ?);";
	private static final String SELECT_CREW_BY_ID ="select film.*,crew.*" +
													"from film inner join crew on  film_id = id"+
													" where film_id=?;";
	private static final String SELECT_ALL_CREW = "select film.*,crew.*" +
													"from film inner join crew on  film_id = id;";
	private static final String SELECT_CREW_BY_IDD = "select * from crew where film_id =?";
	private static final String DELETE_CREW_SQL = "delete from crew where film_id = ?;";
	private static final String UPDATE_CREW_SQL = "update crew set film_director = ?,film_doph= ? ,film_composer= ? where film_id = ?;";
	
	public ProductDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	////////////////////CREW//////////////////////////////////////
	public void insertCrew(Crew crew) throws SQLException {
		System.out.println(INSERT_FILMS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CREW_SQL)) {
			preparedStatement.setInt(1, crew.getFilmId());
			preparedStatement.setString(2, crew.getDirector());
			preparedStatement.setString(3, crew.getDoph());
			preparedStatement.setString(4, crew.getComposer());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Crew selectCrew(int film_id) {
		Crew crew = null;
	
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CREW_BY_IDD);) {
			preparedStatement.setInt(1, film_id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String director = rs.getString("film_director");
				String doph = rs.getString("film_doph");
				String composer = rs.getString("film_composer");
				
				crew = new Crew( film_id, director, doph,composer);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return crew;
	}
	
	public List<Crew_film> selectCrewByFilm(int id){
		
		List<Crew_film> crew_film = new ArrayList<>();
		
		try (Connection connection = getConnection();

				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CREW_BY_ID);) {
				System.out.println(preparedStatement);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					String film_name = rs.getString("name");
					String film_director = rs.getString("film_director");
					String film_doph = rs.getString("film_doph");
					String film_composer = rs.getString("film_composer");
					crew_film.add(new Crew_film(film_name, film_director, film_doph,film_composer));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
		return crew_film;
	}
	
	public List<Crew_film> selectAllCrew() {

		List<Crew_film> crew = new ArrayList<>();
		
		try (Connection connection = getConnection();

		
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CREW);) {
			System.out.println(preparedStatement);
		
			ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
				int film_id = rs.getInt("film_id");
				String film_director = rs.getString("film_director");
				String film_doph = rs.getString("film_doph");
				String film_composer = rs.getString("film_composer");
				String film_name = rs.getString("film.name");
				crew.add(new Crew_film(film_id, film_director, film_doph,film_composer,film_name));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return crew;
	}
	
	public boolean deleteCrew(int film_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CREW_SQL);) {
			statement.setInt(1, film_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	public boolean updateCrew(Crew crew) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CREW_SQL);) {
			statement.setString(1, crew.getDirector());
			statement.setString(2, crew.getDoph());
			statement.setString(3, crew.getComposer());
			statement.setInt(4, crew.getFilmId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}


	//////////FILMS AND ACTORS///////////////////////////////
	public void insertProduct(Film film) throws SQLException {
		System.out.println(INSERT_FILMS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FILMS_SQL)) {
			preparedStatement.setString(1, film.getName());
			preparedStatement.setInt(2, film.getYear());
			preparedStatement.setString(3, film.getDirector());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public void insertActor(Actor actor,Role role) throws SQLException {
		
		System.out.println(INSERT_ACTOR);
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACTOR)) {
			preparedStatement.setString(1, actor.getActorName());
			preparedStatement.setString(2, actor.getActorSurname());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println(INSERT_ROLE);
		try (Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROLE)) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, role.getId());
			preparedStatement.setString(2, role.getRole());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
	}

	public Film selectProduct(int id) {
		Film film = null;
	
		try (Connection connection = getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FILMS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String director = rs.getString("genre");
				film = new Film(id, name, year,director);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return film;
	}
	
	public Actor selectActor(int actor_id) {
		Actor actor = null;
	
		try (Connection connection = getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACTOR_BY_ID);) {
			preparedStatement.setInt(1, actor_id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String actor_name = rs.getString("actor_name");
				String actor_surname = rs.getString("actor_surname");
				
				actor = new Actor( actor_id,actor_name, actor_surname);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return actor;
	}
	
	public List<Actor_Film> selectActorsBy(){
		
		List<Actor_Film> actor_film = new ArrayList<>();
		
		try (Connection connection = getConnection();

				
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ACTORS_FROM);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					int actor_id = rs.getInt("actor_id");
					String actor_name = rs.getString("actor_name");
					String actor_surname = rs.getString("actor_surname");
					String role = rs.getString("role");
					actor_film.add(new Actor_Film(actor_id, actor_name, actor_surname,role));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
		return actor_film;
	}

	public List<Actor_Film> selectActorsByFilm(int id){
		
		List<Actor_Film> actor_film = new ArrayList<>();
		
		try (Connection connection = getConnection();

				
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ACTORS_FROM_FILM);) {
				System.out.println(preparedStatement);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
					int actor_id = rs.getInt("actor_id");
					String actor_name = rs.getString("actor_name");
					String actor_surname = rs.getString("actor_surname");
					String role = rs.getString("role");
					actor_film.add(new Actor_Film(actor_id, actor_name, actor_surname,role));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
		return actor_film;
	}
	
	public List<Actor> selectAllActors(){
		
		List<Actor> actor = new ArrayList<>();
		
		try (Connection connection = getConnection();

				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACTORS);) {
				System.out.println(preparedStatement);
			
				ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
					int actor_id = rs.getInt("actor_id");
					String actor_name = rs.getString("actor_name");
					String actor_surname = rs.getString("actor_surname");
					actor.add(new Actor(actor_id, actor_name, actor_surname));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
		return actor;
		
		
	}
	public List<Film> selectAllProducts() {

		List<Film> films = new ArrayList<>();
		
		try (Connection connection = getConnection();

		
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FILMS);) {
			System.out.println(preparedStatement);
		
			ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String director = rs.getString("genre");
				films.add(new Film(id, name, year,director));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return films;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_FILMS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean deleteActor(int actor_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ACTOR);) {
			statement.setInt(1, actor_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateProduct(Film film) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_FILMS_SQL);) {
			statement.setString(1, film.getName());
			statement.setInt(2, film.getYear());
			statement.setString(3, film.getDirector());
			statement.setInt(4, film.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateActor(Actor actor) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ACTOR);) {
			statement.setString(1, actor.getActorName());
			statement.setString(2, actor.getActorSurname());
			statement.setInt(3, actor.getActorId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
