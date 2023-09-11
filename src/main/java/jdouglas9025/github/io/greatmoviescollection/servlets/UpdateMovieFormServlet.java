package jdouglas9025.github.io.greatmoviescollection.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdouglas9025.github.io.greatmoviescollection.database.MovieDatabaseStatements;
import jdouglas9025.github.io.greatmoviescollection.model.Movie;

import java.io.IOException;

@WebServlet(name = "updateMovieForm", value = "/update-movie-form")
public class UpdateMovieFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get data for dynamic form that shows current values
        int id = Integer.parseInt(req.getParameter("id"));

        //Get movie's current data from DB
        Movie movie = MovieDatabaseStatements.getMovie(id);

        if (movie == null) {
            System.err.println("Issue with getting the movie's existing data.");
        }

        //Set movie and pass control
        req.setAttribute("movie", movie);
        String url = "/great-movies-collection-update.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
