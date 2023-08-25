<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <form method="POST" action="/selectBookingTime">
        <select name="selectedStartTime">
            <c:forEach items="${startTimes}" var="startTime">
                <option>${startTime}</option>
            </c:forEach>
        </select>
        <br>


        <input type="submit" value="Next">
    </form>