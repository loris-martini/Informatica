<?php
include 'connessione.php';
include 'funzioni.php';
session_start();

$numero = $tipo = $contatto = $operatore = '';
$dangerNumero = $dangerTipo = $dangerContatto = $dangerOperatore = '';
$message = '';
$valid = true;


try{    
    $query = "SELECT id_contatti, nome, cognome FROM tcontatti";
    $result = mysqli_query($db_conn, $query);

    if(@mysqli_num_rows($result) != 0){
        while($row = @mysqli_fetch_array($result, MYSQLI_ASSOC)) {
            $contatti[] = [
                "id"    => $row['id_contatti'],
                "nome"  => $row['nome'] . " " . $row['cognome']
            ];
        }
    }

    $query = "SELECT id_operatori, nome FROM toperatori";
    $result = mysqli_query($db_conn, $query);

    if(@mysqli_num_rows($result) != 0){
        while($row = @mysqli_fetch_array($result, MYSQLI_ASSOC)) {
            $operatori[] = [
                "id"    => $row['id_operatori'],
                "nome"  => $row['nome']
            ];
        }
    }

} catch (Exception $ex) {       
    //gestione errori
} 

if (isset($_POST['btnInserisci'])) {
    $numero                 = isset($_POST['numero']) ? filtro_testo($_POST['numero']) : '';
    $tipo                   = isset($_POST['tipo']) ? filtro_testo($_POST['tipo']) : '';
    $contatto               = isset($_POST['contatto']) ? filtro_testo($_POST['contatto']) : '';
    $operatore              = isset($_POST['operatore']) ? filtro_testo($_POST['operatore']) : '';

    $_SESSION['insert'] = [
        "contatto"  => $contatto,
        "numero"    => $numero,
        "operatore" => $operatore,
        "tipo"      => $tipo
    ];

    if (empty($numero)) {
        $dangerNumero = 'error';
        $valid = false;
    }
    if (empty($tipo)) {
        $dangerTipo = 'error';
        $valid = false;
    }
    if (empty($contatto)) {
        $dangerContatto = 'error';
        $valid = false;
    }
    if (empty($operatore)) {
        $dangerOperatore = 'error';
        $valid = false;
    }

    if(!$valid){
        $message= "Tutti i campi sono obbligatori";
    }else{
        try{
            $query = "INSERT INTO ttelefoni (numero, tipo, fk_contatti, fk_operatore) VALUES ('$numero', '$tipo', '$contatto', '$operatore')";
            $result = mysqli_query($db_conn, $query);
            if ($result){
                $message = "Contatto inserito con successo!";
                $dangerNome = $dangerCognome = $dangerFiscale = $dangerMatricola = $dangerData = $dangerOra = '';
                $nome = $cognome = $codice_fiscale = $matricola = $data_nascita = $ora_nascita = '';
                header("refresh:1; telefoni_inserimento.php");
            }     

        }catch (Exception $ex) {       
            //gestione errori
        } 
    }    
    echo $message;   
}

if (isset($_POST['btnReset'])) {
    session_unset();
    header("Location: " . $_SERVER['PHP_SELF']);
    exit();
}
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
            border: 2px solid red;
            background-color: #ffe5e5;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<center>
<form name="formTelefono" method="POST" action="<?= $_SERVER['PHP_SELF'] ?>">
    <table>
        <tr>
            <td>Contatto</td>
            <td class="<?=$dangerContatto?>">
                <select name="contatto">
                    <option value=""> Seleziona un contatto </option>
                    <?php
                    foreach ($contatti as $contatto) {
                        $id_contatto = $contatto['id'];
                        $nome_contatto = $contatto['nome'];
                        $selected = ($contatto['id'] == $_SESSION['insert']['contatto']) ? 'selected' : '';
                        echo "<option value=\"$id_contatto\" $selected>$nome_contatto</option>";
                    }
                    ?>
                </select>
            </td>
        </tr>
        <tr>
            <td>Numero</td>
            <td class="<?=$dangerNumero?>">
                <input type="tel" name="numero" pattern="[0-9]{10}" value="<?= isset($_SESSION['insert']['numero']) ? $_SESSION['insert']['numero'] : '' ?>">
            </td>
        </tr>
        <tr>
            <td>Operatore</td>
            <td class="<?=$dangerOperatore?>">
                <select name="operatore">
                    <option value=""> Seleziona un operatore </option>
                    <?php
                    foreach ($operatori as $operatore) {
                        $id_operatore = $operatore['id'];
                        $nome_operatore = $operatore['nome'];
                        $selected = ($operatore == $_SESSION['insert']['operatore']) ? 'selected' : '';
                        echo "<option value=\"$id_operatore\" $selected>$nome_operatore</option>";
                    }
                    ?>
                </select>
            </td>
        </tr>
        <tr>
            <td>Tipo</td>
            <td class="<?=$dangerTipo?>">
                <input type="radio" name="tipo" value="P" <?= ($_SESSION['insert']['tipo'] ?? '') == "P" ? 'checked' : '' ?>> Personale<br>
                <input type="radio" name="tipo" value="C" <?= ($_SESSION['insert']['tipo'] ?? '') == "C" ? 'checked' : '' ?>> Casa<br>
                <input type="radio" name="tipo" value="L" <?= ($_SESSION['insert']['tipo'] ?? '') == "L" ? 'checked' : '' ?>> Lavoro
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
