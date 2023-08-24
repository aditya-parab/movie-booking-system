<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <h1>SELECT AUDITORIUM AND TIMING</h1>

    <form method="POST" action="/selectAuditoriumAndTimings">
        <select name="auditoriumChosenName">
            <c:forEach items="${auditoriumList}" var="auditorium">
                <option>${auditorium.name}</option>
            </c:forEach>
        </select>
        <br>

        <p>Enter the Start Time:</p>
        <input type="number" step="0.01" name="startTime">
        <p>Enter the End time:</p>
        <input type="number" step="0.01" name="endTime">

        <input type="submit" value="Next">
    </form>

    <button><a href="/">Home</a></button>