<?php
    include 'connessione.php';
    include 'funzioni.php';
?>

<!DOCTYPE html>
<html lang="it">
<head>
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<?php
session_start();
$loginErr = "";

// Controlla se i dati del form sono inviati
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $email = test_input($_POST['mail']);
  $password = test_input($_POST['pwd']);

  // Query sicura usando Prepared Statement
  $sql = "SELECT * FROM taccount WHERE mail = ? AND pass = ?";

  try{
    $stmt = $db_conn->prepare($sql);
    
    if ($stmt) {
      // Associa i parametri
      $stmt->bind_param("ss", $email, $password);

      // Esegui la query
      $stmt->execute();
      $result = $stmt->get_result();

      if ($result->num_rows > 0) {
        $_SESSION['user_mail'] = $result->fetch_assoc()['mail'];

        header("Location: homepage.php");
        exit; // Assicurati di fermare l'esecuzione dopo il redirect
      } else {
        $loginErr = "Email o password non valide.";
      }

      // Chiudi lo statement
      $stmt->close();
    } else {
      $loginErr = "Errore nel preparare la query.";
    }
  }catch (Exception $ex) {
    $message = $ex->getMessage();
    header("refresh:2");
  }
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
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
            <a class="nav-link active" aria-current="page" href="index.html">Home</a>
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

  <div class="container my-5">
    <h1 class="text-center">Login</h1>

    <form action="<?= htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST">
      <div class="mb-3">
        <label for="inputEmail" class="form-label">E-mail</label>
        <input type="email" class="form-control" name="mail" required>
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input type="password" class="form-control" name="pwd" required>
      </div>
      <span class="text-danger"><?= $loginErr; ?></span>
      <button type="submit" class="btn btn-primary">Login</button>
    </form>

  </div>

    <!-- Footer -->
  <footer class="bg-light text-center p-3 mt-5">
    <p><b>ITT BUONARROTI TRENTO</b></p>
  </footer>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>