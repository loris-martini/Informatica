<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>
    <h1>Form</h1>
    <form action="martini-php.php" method="post">
        <!-- Input Testuale -->
        <label for="text">Testo:</label>
        <input type="text" id="text" name="text"><br><br>

        <!-- Password -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>

        <!-- Email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br><br>

        <!-- Numero -->
        <label for="number">Numero:</label>
        <input type="number" id="number" name="number"><br><br>

        <!-- Data -->
        <label for="date">Data:</label>
        <input type="date" id="date" name="date"><br><br>

        <!-- Colore -->
        <label for="color">Colore:</label>
        <input type="color" id="color" name="color"><br><br>

        <!-- Radio Button -->
        <p>Genere:</p>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Maschio</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Femmina</label><br>
        <input type="radio" id="other" name="gender" value="other">
        <label for="other">Altro</label><br><br>

        <!-- Checkbox -->
        <p>Interessi:</p>
        <input type="checkbox" id="sport" name="interests[]" value="sport">
        <label for="sport">Sport</label><br>
        <input type="checkbox" id="music" name="interests[]" value="music">
        <label for="music">Musica</label><br>
        <input type="checkbox" id="reading" name="interests[]" value="reading">
        <label for="reading">Lettura</label><br><br>

        <!-- Select -->
        <label for="country">Paese:</label>
        <select id="country" name="country">
            <option value="italy">Italia</option>
            <option value="usa">USA</option>
            <option value="uk">Regno Unito</option>
        </select><br><br>

        <!-- Textarea -->
        <label for="message">Messaggio:</label>
        <textarea id="message" name="message"></textarea><br><br>

        <!-- File -->
        <label for="file">File:</label>
        <input type="file" id="file" name="file"><br><br>

        <!-- Range -->
        <label for="range">Range (0-100):</label>
        <input type="range" id="range" name="range" min="0" max="100"><br><br>

        <!-- Invio -->
        <input type="submit" value="Invia">
    </form>
</body>
</html>
