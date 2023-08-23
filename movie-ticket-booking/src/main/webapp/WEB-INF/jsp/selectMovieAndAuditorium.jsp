<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>selectMovieAndAuditorium</title>
        <style>
            .success {
                color: green;
            }

            .error {
                color: red;
            }
        </style>
    </head>

    <body>



        <h3>Choose the Movie and the Theatre where you wish to screen it</h3>

        <p>
            Movie:
        <form method="POST" action="/chooseexam">
            <select name="movieChosen">
                <c:forEach items="${movieList}" var="movie">
                    <option>${movie.title}</option>
                </c:forEach>
            </select>
            <br>
            Theatre:
            <select name="theatreChosen">
                <c:forEach items="${theatreList}" var="theatre">
                    <option>${theatre.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Submit">
        </form>

        </p>





    </body>

    </html>