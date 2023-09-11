package jdouglas9025.github.io.greatmoviescollection.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdouglas9025.github.io.greatmoviescollection.database.MovieDatabaseStatements;

import java.io.IOException;
import java.sql.ResultSet;

//Include '' (default page) as a mapping so that this servlet is called upon loading the home page
@WebServlet(name = "viewMovies", value = {"", "/view-movies"})
public class ViewMoviesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get an HTML table of the movies in DB
        ResultSet resultSet = MovieDatabaseStatements.getAllMovies();

        if (resultSet == null) {
            System.err.println("Issue with displaying all movies. Result set is null.");

            return;
        }

        String table = MovieDatabaseStatements.getHTMLTable(resultSet);

        //Pass execution control
        req.setAttribute("table", table);
        String url = "/great-movies-collection.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
