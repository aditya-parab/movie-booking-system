<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <h2>Choose Theatre:</h2>
    <form method="POST" action="/makeBookingSelectTheatre">
        <select name="TheatreChosenName">
            <c:forEach items="${theatreList}" var="theatre">
                <option>${theatre.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Next">
    </form>