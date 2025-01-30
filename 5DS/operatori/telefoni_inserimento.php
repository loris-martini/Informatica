<?php
    include 'connessione.php';
    include 'funzioni.php';
?>

<!DOCTYPE html>
<html lang="it">
<head>
    <title>Telefono Inserimento</title>
    <meta charset="UTF-8">
    <style>
        table {
            border-collapse: collapse;
        }
        td, th {
            border: 2px solid;
        }
        .error {
            border: 5px solid red;
            background-color: #ffe5e5;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<?php
    $prefisso = $telefono = $tipo = $contatti = $contattoSelezionato = $operatori = $operatoreSelezionato = '';
    
?>
<center>
<form name="formTelefono" method="POST" action="<?= $_SERVER['PHP_SELF'] ?>">
    <table>
        <tr>
            <td>Prefisso</td>
            <td>
                <input type="tel" name="telefono" pattern="[0-9]{10}" value="<?=htmlspecialchars($prefisso)?>">
            </td>
        </tr>
        <tr>
            <td>Telefono</td>
            <td>
                <input type="tel" name="telefono" pattern="[0-9]{10}" value="<?=htmlspecialchars($telefono)?>">
            </td>
        </tr>
        <tr>
            <td>Tipo</td>
            <td>
                <input type="text" name="txtCognome" value="<?=htmlspecialchars($tipo)?>">
            </td>
        </tr>
        <tr>
            <td>Operatore</td>
            <td>
                <select name="operatore">
                    <option value="">-- Seleziona un operatore --</option>
                    <?php
                    foreach ($operatori as $operatore) {
                        $selected = ($operatore == $operatoreSelezionato) ? 'selected' : '';
                        ?><option value="<?=$operatore?>" $selected><?=$operatore?></option>
                    <?php };?>
                </select>
            </td>
            
        </tr>
        <tr>
            <td>Contatto</td>
            <td>
            <select name="contatto">
                    <option value="">-- Seleziona un operatore --</option>
                    <?php
                    foreach ($contatti as $contatto) {
                        $selected = ($contatto == $contattoSelezionato) ? 'selected' : '';
                        ?><option value="<?=$contatto?>" $selected><?=$contatto?></option>
                    <?php };?>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="btnInserisci" value="Inserisci">
                <input type="submit" name="btnReset" value="Cancella">
            </td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
