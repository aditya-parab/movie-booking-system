<!DOCTYPE html>
<html>

<head>
    <title>Add Theatre</title>
</head>

<body>
    <h1>Add Theatre</h1>
    <form action="/addTheatre" method="post">
        <label for="name">Name of Theatre:</label>
        <input type="text" name="name" required><br><br>

        <label for="noOfAuditoriums">No of Auditoriums in this Theatre:</label>
        <input type="number" name="noOfAuditoriums" pattern="[1-9][0-9]*" required><br><br>


        <input type="submit" value="Next">
        <button><a href="/">Home</a></button>
    </form>
</body>

</html>