<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/great-movies-collection-styles.css">
    <title>Great Movies Collection</title>
</head>
<body>
<h1>Great Movies Collection - Update Movie</h1>
<div class="app-container">
    <form name="updateForm" action="update-movie" method="post">
        <!-- Need to pass id, but do not want user to modify (so it is a hidden field) -->
        <label>
            <input type="number" hidden readonly name="id" value="${requestScope.movie.getId()}"/>
        </label>

        <label>
            Movie title:
            <input type="text" name="title" value="${requestScope.movie.getTitle()}"/>
        </label>

        <label>
            Movie revenue:
            <input type="text" name="revenue" value="${requestScope.movie.getRevenue()}"/>
        </label>

        <input type="submit" name="submit" value="Update"/>
    </form>
</div>
</body>
</html>