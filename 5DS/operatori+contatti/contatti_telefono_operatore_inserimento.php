<?php
    session_start(); 

    include 'connessione.php';
    include 'funzioni.php';
?>

<!DOCTYPE html>
<html lang="it">
<head>
    <title>Contatti inserimento</title>
    <meta charset="UTF-8">
    <!-- CSS di Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- JavaScript di Bootstrap (necessario per componenti interattivi) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
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
<body>
<?php


    $dangerNome = $dangerCognome = $dangerFiscale = $dangerMatricola = $dangerData = $dangerOra = '';
    $nome = $cognome = $codice_fiscale = $matricola = $data_nascita = $ora_nascita = '';
    
    $numero = $tipo  = $operatore = '';
    $dangerNumero = $dangerTipo = $dangerOperatore = '';
    
    $message = '';

    try{   
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
        $message = @mysqli_error($db_conn);
    } 

    if (isset($_POST['btnInserisci'])) {
        $nome           = isset($_POST['nome']) ? filtro_testo($_POST['nome']) : '';
        $cognome        = isset($_POST['cognome']) ? filtro_testo($_POST['cognome']) : '';
        $codice_fiscale = isset($_POST['codice_fiscale']) ? filtro_testo($_POST['codice_fiscale']) : '';
        $matricola      = isset($_POST['matricola']) ? filtro_testo($_POST['matricola']) : '';
        $data_nascita   = isset($_POST['data_nascita']) ? filtro_testo($_POST['data_nascita']) : '';
        $ora_nascita    = isset($_POST['ora_nascita']) ? filtro_testo($_POST['ora_nascita']) : '';
        $numero         = isset($_POST['numero']) ? filtro_testo($_POST['numero']) : '';
        $tipo           = isset($_POST['tipo']) ? filtro_testo($_POST['tipo']) : '';
        $operatore      = isset($_POST['operatore']) ? filtro_testo($_POST['operatore']) : '';

        $valid = true;

        $_SESSION['user'] = [
            "nome"              => $nome,
            "cognome"           => $cognome,
            "codice_fiscale"    => $codice_fiscale,
            "matricola"         => $matricola,
            "data_nascita"      => $data_nascita,
            "ora_nascita"       => $ora_nascita,
            "numero"            => $numero,
            "operatore"         => $operatore,
            "tipo"              => $tipo
        ];
        
        if (empty($nome)) {
            $dangerNome = 'error';
            $valid = false;
        }
        if (empty($cognome)) {
            $dangerCognome = 'error';
            $valid = false;
        }
        if (empty($codice_fiscale)) {
            $dangerFiscale = 'error';
            $valid = false;
        }
        if (empty($matricola)) {
            $dangerMatricola = 'error';
            $valid = false;
        }
        if (empty($data_nascita)) {
            $dangerData = 'error';
            $valid = false;
        }
        if (empty($ora_nascita)) {
            $dangerOra = 'error';
            $valid = false;
        }
        if (empty($numero)) {
            $dangerNumero = 'error';
            $valid = false;
        }
        if (empty($tipo)) {
            $dangerTipo = 'error';
            $valid = false;
        }
        if (empty($operatore)) {
            $dangerOperatore = 'error';
            $valid = false;
        }


        if(!$valid){
            $message= "Tutti i campi sono obbligatori";
        }else{

            $nome           = @mysqli_real_escape_string($db_conn, ucwords(strtolower(filtro_testo($_POST['nome']))));
            $cognome        = @mysqli_real_escape_string($db_conn, ucwords(strtolower(filtro_testo($_POST['cognome']))));
            $codice_fiscale = @mysqli_real_escape_string($db_conn, strtoupper(filtro_testo($_POST['codice_fiscale'])));
            $matricola      = @mysqli_real_escape_string($db_conn, strtoupper(filtro_testo($_POST['matricola'])));
            $data_nascita   = @mysqli_real_escape_string($db_conn, filtro_testo($_POST['data_nascita']));
            $ora_nascita    = @mysqli_real_escape_string($db_conn, filtro_testo($_POST['ora_nascita']));
            $numero         = @mysqli_real_escape_string($db_conn, filtro_testo($_POST['numero']));
            $tipo           = @mysqli_real_escape_string($db_conn, strtoupper(filtro_testo($_POST['tipo'])));
            $operatore      = @mysqli_real_escape_string($db_conn, strtoupper(filtro_testo($_POST['operatore'])));

            
            try {
                mysqli_begin_transaction($db_conn);

                $query1 = "INSERT INTO tcontatti (nome, cognome, codice_fiscale, matricola, data_nascita, ora_nascita) 
                        VALUES('$nome', '$cognome', '$codice_fiscale', '$matricola', '$data_nascita', '$ora_nascita')";
                $insert1 = mysqli_query($db_conn, $query1);

                if (!$insert1) {
                    throw new Exception("Errore nell'inserimento in tcontatti: " . mysqli_error($db_conn));
                }

                $id_user = mysqli_insert_id($db_conn);

                $query2 = "INSERT INTO ttelefoni (numero, tipo, fk_contatti, fk_operatore) 
                        VALUES('$numero', '$tipo', '$id_user', '$operatore')";
                $insert2 = mysqli_query($db_conn, $query2);

                if (!$insert2) {
                    throw new Exception("Errore nell'inserimento in ttelefoni: " . mysqli_error($db_conn));
                }

                mysqli_commit($db_conn);

                $message = "Contatto inserito con successo!";
                $dangerNome = $dangerCognome = $dangerFiscale = $dangerMatricola = $dangerData = $dangerOra = '';
                $nome = $cognome = $codice_fiscale = $matricola = $data_nascita = $ora_nascita = '';

                $numero = $tipo  = $operatore = '';
                $dangerNumero = $dangerTipo = $dangerOperatore = '';

                session_unset();

                header("refresh:1; contatti_telefono_operatore_inserimento.php");                               
            } catch (Exception $ex) {                        
                $message = @mysqli_error($db_conn);
                $error_code = @mysqli_errno($db_conn);

                switch ($error_code) {
                    case 1062:
                        if (strpos($message, 'matricola') !== false) {
                            $message = "Errore: La matricola è già registrata!";
                            $dangerMatricola = 'error';
                        } elseif (strpos($message, 'codice_fiscale') !== false) {
                            $message = "Errore: Il codice fiscale è già presente!";
                            $dangerFiscale = 'error';
                        }
                        break;
            
                    case 1452:
                        if (strpos($message, 'fk_operatore') !== false) {
                            $message = "Errore: L'operatore selezionato non esiste!";
                            $dangerOperatore = 'error';
                        }
                        break;
            
                    case 1644:
                        if (strpos($message, '001') !== false) {
                            $dangerCognome = 'error';
                            $dangerNome = 'error';
                        } elseif (strpos($message, '002') !== false) {
                            $dangerCognome = 'error';
                        } elseif (strpos($message, '003') !== false) {
                            $dangerNome = 'error';
                        } elseif (strpos($message, '004') !== false) {
                            $dangerData = 'error';
                        } elseif (strpos($message, '005') !== false) {
                            $dangerFiscale = 'error';
                        } elseif (strpos($message, '006') !== false) {
                            $dangerMatricola = 'error';
                        } elseif (strpos($message, '007') !== false) {
                            $dangerNumero = 'error';
                        }
                        break;
            
                    case 1645:
                        $dangerTipo = 'error';
                        break;
            
                    default:
                        $message = "Errore sconosciuto: " . $message;
                        break;
                }
            }

            if (isset($_POST['btnReset'])) {
                $dangerNome = $dangerCognome = $dangerFiscale = $dangerMatricola = $dangerData = $dangerOra = '';
                $nome = $cognome = $codice_fiscale = $matricola = $data_nascita = $ora_nascita = '';

                $numero = $tipo  = $operatore = '';
                $dangerNumero = $dangerTipo = $dangerOperatore = '';

                $message = '';
            
            }

        }  
        echo $message;
    
}
?>
<center>
<form name="frmContattiInserimento" method="POST" action="<?= $_SERVER['PHP_SELF'] ?>">
    <table>
        <tr>
            <td>Nome</td>
            <td class="<?= $dangerNome ?>">
                <input type="text" name="nome" value="<?=isset($_SESSION['user']['nome']) ? $_SESSION['user']['nome'] : ''?>">
            </td>
        </tr>
        <tr>
            <td>Cognome</td>
            <td class="<?= $dangerCognome ?>">
                <input type="text" name="cognome" value="<?=isset($_SESSION['user']['cognome']) ? $_SESSION['user']['cognome'] : ''?>">
            </td>
        </tr>
        <tr>
            <td>Codice Fiscale</td> <!--MRTLRS06B26L378Y-->
            <td class="<?= $dangerFiscale ?>"> <!--BSCNDR06H22Z103T-->
                <input type="text" name="codice_fiscale" value="<?=isset($_SESSION['user']['codice_fiscale']) ? $_SESSION['user']['codice_fiscale'] : ''?>">
            </td>
        </tr>
        <tr>
            <td>Codice Matricola</td>
            <td class="<?= $dangerMatricola ?>">
                <input type="text" name="matricola" value="<?=isset($_SESSION['user']['matricola']) ? $_SESSION['user']['matricola'] : ''?>">
            </td>
        </tr>
        <tr>
            <td>Data di nascita</td>
            <td class="<?= $dangerData ?>">
                <input type="date" name="data_nascita" value="<?=isset($_SESSION['user']['data_nascita']) ? $_SESSION['user']['data_nascita'] : ''?>">
            </td>
        </tr>
        <tr>
            <td>Ora di nascita</td>
            <td class="<?= $dangerOra ?>">
                <input type="time" name="ora_nascita" value="<?=isset($_SESSION['user']['ora_nascita']) ? $_SESSION['user']['ora_nascita'] : ''?>">
            </td>
        </tr>
        <tr>
            <td>Numero</td>
            <td class="<?=$dangerNumero?>">
                <input type="tel" name="numero" value="<?=isset($_SESSION['user']['numero']) ? $_SESSION['user']['numero'] : ''?>">
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
                        $selected = ($id_operatore == $_SESSION['user']['operatore']) ? 'selected' : '';
                        echo "<option value=\"$id_operatore\" $selected>$nome_operatore</option>";
                    }
                    ?>
                </select>
            </td>
        </tr>

        <tr>
            <td>Tipo</td>
            <td class="<?=$dangerTipo?>">
                <input type="radio" name="tipo" value="P" <?= ($_SESSION['user']['tipo'] ?? '') == "P" ? 'checked' : '' ?>> Personale<br>
                <input type="radio" name="tipo" value="C" <?= ($_SESSION['user']['tipo'] ?? '') == "C" ? 'checked' : '' ?>> Casa<br>
                <input type="radio" name="tipo" value="L" <?= ($_SESSION['user']['tipo'] ?? '') == "L" ? 'checked' : '' ?>> Lavoro
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
<br>
</center>
</body>
</html>