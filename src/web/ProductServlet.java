package web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import model.Actor;
import model.Actor_Film;
import model.Crew;
import model.Crew_film;
import model.Film;
import model.Role;


@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	
	public void init() {
		productDAO = new ProductDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/user_list":
				response.sendRedirect("index.jsp");
				break;
			case "/show_actors":
				showActors(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/newActor":
				showNewActorForm(request, response);
				break;
			case "/newCrew":
				showNewCrewForm(request, response);
				break;
			case "/insert":
				insertProduct(request, response);
				break;
			case "/insertActor":
				insertActor(request, response);
				break;
			case "/insertCrew":
				insertCrew(request, response);
				break;
			case "/delete":
				deleteProduct(request, response);
				break;
			case "/deleteActor":
				deleteActor(request, response);
				break;
			case "/deleteCrew":
				deleteCrew(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/editActor":
				showActorEditForm(request, response);
				break;
			case "/editCrew":
				showCrewEditForm(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			case "/updateActor":
				updateActor(request, response);
				break;
			case "/updateCrew":
				updateCrew(request, response);
				break;
			case "/listActor":
				showActorsUserRRR(request, response);
				break;
			case "/listActorUser":
				listActorUser(request, response);
				break;
			case "/listFilmUser":
				listProductUser(request, response);
				break;
			case "/showActorsUser":
				showActorsUser(request, response);
				break;
			case "/showCrew-film":
				showCrew_Film(request, response);
				break;
			case "/showCrew-film-user":
				showCrew_Film_User(request, response);
				break;
			case "/showCrew-film-list":
				showCrew_Film_List(request, response);
				break;
			case "/showCrew-film-list-user":
				showCrew_Film_List_User(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void showActors(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Actor_Film> actor_film = productDAO.selectActorsByFilm(id);
		request.setAttribute("actor_film", actor_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-film.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showCrew_Film(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		List<Crew_film> crew_film = productDAO.selectCrewByFilm(film_id);
		request.setAttribute("crew_film", crew_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("crew-film.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showCrew_Film_User(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		List<Crew_film> crew_film = productDAO.selectCrewByFilm(film_id);
		request.setAttribute("crew_film", crew_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("crew-film-user.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showCrew_Film_List(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Crew_film> crew_film = productDAO.selectAllCrew();
		request.setAttribute("crew_film", crew_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("crew.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showCrew_Film_List_User(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Crew_film> crew_film = productDAO.selectAllCrew();
		request.setAttribute("crew_film", crew_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("crew-user.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showActorsUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Actor_Film> actor_film = productDAO.selectActorsByFilm(id);
		request.setAttribute("actor_film", actor_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-film-user.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showActorsUserRRR(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Actor_Film> actor_film = productDAO.selectActorsBy();
		request.setAttribute("actor_film", actor_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-list.jsp");
		dispatcher.forward(request, response);
		
	}
	

	
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Film> listProduct = productDAO.selectAllProducts();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listProductUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Film> listProduct = productDAO.selectAllProducts();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("film-list-user.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listActorUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Actor_Film> actor_film = productDAO.selectActorsBy();
		request.setAttribute("actor_film", actor_film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listActor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Actor> listActor = productDAO.selectAllActors();
		request.setAttribute("actorlist", listActor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-list.jsp");
		dispatcher.forward(request, response);
	}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewActorForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewCrewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("crew-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Film existingProduct = productDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		request.setAttribute("product", existingProduct);
		dispatcher.forward(request, response);

	}
	
	private void showActorEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int actor_id = Integer.parseInt(request.getParameter("id"));
		Actor existingActor = productDAO.selectActor(actor_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("actor-form.jsp");
		request.setAttribute("Actor", existingActor);
		dispatcher.forward(request, response);

	}
	
	private void showCrewEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		Crew existingCrew = productDAO.selectCrew(film_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("crew-form.jsp");
		request.setAttribute("Crew", existingCrew);
		dispatcher.forward(request, response);

	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year")); 
		String director = request.getParameter("director");
		
		Film newProduct = new Film(name, year,director);
		productDAO.insertProduct(newProduct);
		response.sendRedirect("list");
	}
	
	private void insertActor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); 
		String actor_name = request.getParameter("actor_name");
		String actor_surname = request.getParameter("actor_surname");
		Actor newActor = new Actor(actor_name, actor_surname);
		
		String role = request.getParameter("role");
		Role newRole = new Role(id,role);
		
		productDAO.insertActor(newActor, newRole);
		response.sendRedirect("actorlist");
	}
	
	private void insertCrew(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int film_id = Integer.parseInt(request.getParameter("id")); 
		String director = request.getParameter("director");
		String doph = request.getParameter("doph");
		String composer = request.getParameter("composer");
		Crew newCrew = new Crew(film_id, director,doph,composer);
		
		productDAO.insertCrew(newCrew);
		response.sendRedirect("showCrew-film-list");
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year")); 
		String director = request.getParameter("director");
		

		Film book = new Film(id, name, year,director);
		productDAO.updateProduct(book);
		response.sendRedirect("list");
	}
	
	private void updateActor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int actor_id = Integer.parseInt(request.getParameter("actor_id"));
		String actor_name = request.getParameter("actor_name");
		String actor_surname = request.getParameter("actor_surname");
		Actor act  = new Actor(actor_id, actor_name, actor_surname);
		productDAO.updateActor(act);
		response.sendRedirect("actorlist");
	}
	
	private void updateCrew(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		String director = request.getParameter("director");
		String doph = request.getParameter("doph");
		String composer = request.getParameter("composer");
		Crew crew  = new Crew(film_id,director,doph,composer);
		productDAO.updateCrew(crew);
		response.sendRedirect("showCrew-film-list");
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteProduct(id);
		response.sendRedirect("list");

	}
	
	private void deleteActor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int actor_id = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteActor(actor_id);
		response.sendRedirect("actor_list");

	}
	
	private void deleteCrew(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int film_id = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteCrew(film_id);
		response.sendRedirect("showCrew-film-list");

	}

}
