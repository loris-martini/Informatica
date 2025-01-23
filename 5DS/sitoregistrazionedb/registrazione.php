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
  .error {color: #FF0000;}
</style>

<?php
session_start();
$_SESSION['logged'] = false;
$name = $surname = $email = $pwd = $emailErr = $passwordErr = $registrazioneError = "";
$isFormValid = true;

// Controlla se i dati del form sono inviati
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $name = test_input($_POST['name']);
  $surname = test_input($_POST['surname']);
  $email = test_input($_POST['mail']);
  $pwd = test_input($_POST['pwd']);


  if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    $emailErr = "Invalid email format";
    $isFormValid = false;
  }

  if (!preg_match('/^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/', $pwd)){
    $passwordErr = "Password is invalid!";
    $isFormValid = false;
  }

  if ($isFormValid) {
 
    $nome = @mysqli_real_escape_string($db_conn, ucwords(strtolower(filtro_testo($_POST['name']))));
    $surname = @mysqli_real_escape_string($db_conn, ucwords(strtolower(filtro_testo($_POST['surname']))));
    $mail = @mysqli_real_escape_string($db_conn, strtolower(filtro_testo($_POST['mail'])));
    $password = @mysqli_real_escape_string($db_conn, filtro_testo($_POST['pwd']));

    $hashedPassword = password_hash($password, PASSWORD_DEFAULT);

    $query_insert = "INSERT INTO taccount (nome, cognome, mail, pass) VALUES('$nome', '$surname', '$mail', '$hashedPassword')";

    try {
      $insert = @mysqli_query($db_conn, $query_insert);

      $message = "Registrato con Successo!";
 
      header("Location: login.php");
      exit();
    } catch (Exception $ex) {
      $message = $ex->getMessage();

      if (@mysqli_errno($db_conn) == 4025) // errore generato dai check
        $message = "nome e/o cognome errati!";
      
      if (@mysqli_errno($db_conn) == 1062) // errore generato dai campi unique
        $message = "contatto già esistente!";

      if (@mysqli_errno($db_conn) == 1644) // errore generato dai trigger
        $message = @mysqli_error($db_conn); 

      $registrazioneError = $message;
      header("refresh:2");
    }
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
  
  <!-- registrazione Content 
   id="text"
   id="text"
   id="inputEmail"
   id="text"
   -->
  <div class="container my-5">
    <h1 class="text-center">Registrazione</h1>

    <form class="row g-3" action="<?= htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
      <div class="col-md-6">
        <label for="inputName" class="form-label">Nome</label>
        <input type="text" class="form-control" name="name" value="<?=$name?>" placeholder="Nome" required>
      </div>
      <div class="col-md-6">
        <label for="inputName" class="form-label">Cognome</label>
        <input type="text" class="form-control" name="surname" value="<?=$surname?>" placeholder="Cognome" required>
      </div>
      <div class="col-md-6">
        <label for="inputName" class="form-label">E-mail</label>
        <span class="error">* <?= $emailErr;?></span>
        <input type="email" class="form-control" name="mail" value="<?=$email?>" placeholder="Email" required>
      </div>
      <div class="col-md-6">
        <label for="inputEmail" class="form-label">Password</label>
        <span class="error">* <?= $passwordErr;?></span>
        <input type="password" class="form-control" name="pwd" placeholder="Password" required>
      </div>
      <span class="text-danger"><?= $registrazioneError; ?></span>
      <input class="btn btn-light btn-lg" type="submit" name="submit" value="Registrati">
    </form>
  </div>

  <!-- Footer -->
  <footer class="bg-light text-center p-3 mt-5">
    <p><b>ITT BUONARROTI TRENTO</b></p>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
