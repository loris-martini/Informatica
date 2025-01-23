<?php
  include 'connessione.php';
  include 'funzioni.php';
?>

<!DOCTYPE html>
<html lang="it">
<head>
  <title>registrazione</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<style>
  h1,h2,h3{
    text-align: center;
  }
</style>

<?php
session_start();

if (!isset($_SESSION['user_mail'])) {
  header("Location: login.php"); // Reindirizza al login se non autenticato
  exit;
}

$mail = $_SESSION['user_mail'];
$sql = "SELECT * FROM taccount WHERE mail = ?";

try{
  $stmt = $db_conn->prepare($sql);

  if ($stmt) {
    $stmt->bind_param("i", $mail);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $user_data = $result->fetch_assoc(); // Recupera i dati come array associativo
    } else {
        echo "Nessun utente trovato.";
    }

    $stmt->close();
  } else {
      echo "Errore nella preparazione della query.";
  }
}catch (Exception $ex) {
  $message = $ex->getMessage();
  header("refresh:2");
}

//data di nascita
$data_nascita = isset($user_data['data_nascita']) && !empty($user_data['data_nascita']) ? htmlspecialchars($user_data['data_nascita']) : null;

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['data_nascita'])) {
  $new_data_nascita = htmlspecialchars($_POST['data_nascita']);

  $sql = "UPDATE taccount SET data_nascita = ? WHERE mail = ?";
  try {
      $stmt = $db_conn->prepare($sql);

      if ($stmt) {
          $stmt->bind_param("ss", $new_data_nascita, $mail);
          if ($stmt->execute()) {
              $data_nascita = $new_data_nascita; // Aggiorna la variabile
          } else {
              echo "Errore durante l'aggiornamento della data di nascita.";
          }
          $stmt->close();
      } else {
          echo "Errore nella preparazione della query.";
      }
  } catch (Exception $ex) {
      $message = $ex->getMessage();
      header("refresh:2");
  }
}

//elimina
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['delete']) && $_POST['delete'] == "delete") {
  $sql = "DELETE FROM taccount WHERE mail = ?";

  try{
    $stmt = $db_conn->prepare($sql);

    if ($stmt) {
      $stmt->bind_param("i", $mail);
      if ($stmt->execute()) {
        session_unset(); // Termina la sessione
        session_destroy(); // Distrugge la sessione
        header("Location: index.html"); // Reindirizza al login
        exit;
      } else {
        echo "Errore durante l'eliminazione dell'account.";
      }
      $stmt->close();
    } else {
      echo "Errore nella preparazione della query.";
    }
  }catch (Exception $ex) {
    $message = $ex->getMessage();
    header("refresh:2");
  }  
}
?>

<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Sito Votazioni</a>
      
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="index.php">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="registrazione.php">Registrazione</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="login.php">Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <br>
    <h1>Ciao <b><?=htmlspecialchars($user_data['nome'])?> <?=htmlspecialchars($user_data['cognome'])?></b></h1>
    <br>
    <h2>Informazioni Personali:</h2>
    <h3>Mail: <?=htmlspecialchars($user_data['mail'])?></h3>
    <h3>Data di Nascita: 
        <?php if ($data_nascita): ?>
            <?= $data_nascita ?>
        <?php else: ?>
            <form action="<?= $_SERVER["PHP_SELF"] ?>" method="POST" style="display:inline;">
                <input type="date" name="data_nascita" required>
                <button type="submit" class="btn btn-success">Inserisci</button>
            </form>
        <?php endif; ?>
    </h3>
    <br>
    <br>
    <center>
      <form action="<?= $_SERVER["PHP_SELF"]?>" method="POST">
        <input type="hidden" name="delete" value="delete">
        <button type="submit" class="btn btn-primary">ELIMINA DATI</button>
      </form>
    </center>
</body>
  

  <!-- Footer -->
  <footer class="bg-light text-center p-3 mt-5">
    <p><b>ITT BUONARROTI TRENTO</b></p>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
