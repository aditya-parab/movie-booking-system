<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <h2>Select Booking seat </h2>
    <form method="POST" action="/selectBookingSeats">
        <select name="seatChosen">

            <c:forEach items="${availableSeats}" var="availableSeat">
                <option>${availableSeat.id}</option>
            </c:forEach>

        </select>
        <br>
        <input type="submit" value="Next">
    </form>

    <button><a href="/">Home</a></button>