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

@WebServlet(name = "filterMoviesByRevenue", value = "/filter-movies-by-revenue")
public class FilterMoviesByRevenueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Query the DB
        int revenue = Integer.parseInt(req.getParameter("revenue"));
        ResultSet resultSet = MovieDatabaseStatements.filterMoviesByRevenue(revenue);

        if (resultSet == null) {
            System.err.println("Issue with filtering movies by revenue. Result set is null.");
            return;
        }

        //Convert result set into table
        String table = MovieDatabaseStatements.getHTMLTable(resultSet);

        //Pass execution control
        req.setAttribute("table", table);
        String url = "/great-movies-collection-filter-by-revenue.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }


}
