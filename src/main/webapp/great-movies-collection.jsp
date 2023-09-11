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
<h1>Great Movies Collection</h1>
<div class="app-container">

    <!-- Output table -->
    ${requestScope.table}

    <a href="great-movies-collection-add.html">Add a Movie</a>
</div>
</body>
</html>