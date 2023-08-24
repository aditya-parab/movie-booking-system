<!DOCTYPE html>
<html>

<head>
    <title>Add Movie</title>
</head>

<body>
    <h1>Add Movie</h1>
    <form action="/addMovie" method="post">
        <label for="title">Title:</label>
        <input type="text" name="title" required><br><br>

        <label for="genre">Genre:</label>
        <input type="text" id="genre" name="genre" required><br><br>


        <input type="submit" value="Add Movie">
        <button><a href="/">Home</a></button>
    </form>
</body>

</html>