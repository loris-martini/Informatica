<!DOCTYPE html>
<?php
    $nome = '';
    $nElementi = 0;
    $elenco = 'ul'; // Puoi scegliere 'ul' per lista non ordinata o 'ol' per lista ordinata.

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $nome = htmlspecialchars($_POST['nome']);
        $nElementi = intval($_POST['nElementi']); // Ottieni il numero di elementi dal form
    }
?>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="Width=device-width, initial-scale=1.0">
        <title>Elenco Puntato</title>
    </head>
    <body>
        <h1>
            <?php echo "Ciao " . $nome; ?>
        </h1>

        <form method="post">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>
            <br>
            <label for="nElementi">Numero di elementi:</label>
            <input type="number" id="nElementi" name="nElementi" min="1" required>
            <br>
            <input type="submit" value="Invia">
        </form>

        <?php if ($nElementi > 0): ?>
            <h2>Elenco di numeri casuali:</h2>
            <<?php echo $elenco; ?>>
                <?php for ($i = 0; $i < $nElementi; $i++): ?>
                    <li><?php echo rand(1, 100); ?></li>
                <?php endfor; ?>
            </<?php echo $elenco; ?>>
        <?php endif; ?>
    </body>
</html>
