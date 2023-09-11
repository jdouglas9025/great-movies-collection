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

@WebServlet(name = "addMovie", value = "/add-movie")
public class AddMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        int revenue = Integer.parseInt(req.getParameter("revenue"));

        //Init movie object
        Movie movie = new Movie(title, revenue);

        //Add movie to the database
        MovieDatabaseStatements.addMovie(movie);

        //Pass execution control to the ViewMovies servlet
        String url = "/view-movies";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
