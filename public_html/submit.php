<!DOCTYPE html>
<html>
<head>
<title>submit - the heart locker</title>
<link rel="icon" type="image/jpg" href="/favicon.jpg" sizes="16x16">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Garamond, serif;
  margin: 0;
  text-align: center;
}

a:link {
  color: black;
  background-color: transparent;
  text-decoration: none;
}

a:visited {
  color: black;
  background-color: transparent;
  text-decoration: none;
}

.header {
  padding: 30px;
  text-align: center;
  background: #FFFFFF;
  color: black;
}

textarea {
  width: 300px;
  height: 300px;
  resize: none;
  margin-bottom: 10px;
}


</style>
</head>
<body>

    <h1>say anything</h1>
    <p>(leave a date and your name/location if you want)</p>

    <form method="post">
        <textarea name="submission"></textarea><br>
        <input type="submit" value="leave a note">
    </form>
    
    <?php
    if( isset($_POST['submission']) )
    {
        $txt= $_POST['submission'] . PHP_EOL; 
        file_put_contents('archive.txt', $txt, FILE_APPEND);
        file_put_contents('archive.txt', "\n", FILE_APPEND);
        file_put_contents('archive.txt', "\n", FILE_APPEND);
    }
    ?>
    
    <br>
    <a href="leave a note.html">back</a>

</body>
</html>
