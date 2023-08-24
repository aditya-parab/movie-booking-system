<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <h2>Choose Movie:</h2>
    <form method="POST" action="/makeBookingSelectMovie">
        <select name="movieChosenTitle">
            <c:forEach items="${movieList}" var="movie">
                <option>${movie.title}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Next">
    </form>