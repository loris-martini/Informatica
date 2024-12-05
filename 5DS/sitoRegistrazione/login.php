<!DOCTYPE html>
<html lang="it">
<head>
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<?php
session_start(); // Avvia la sessione
$loginErr = "";

// Controlla se i dati del form sono inviati
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $email = $_POST['mail'];
  $password = $_POST['pwd'];

  // Verifica le credenziali dalla sessione
  if (isset($_SESSION['user']) && $_SESSION['user']['email'] === $email && $_SESSION['user']['password'] === $password) {
    header("Location: homepage.php"); // Reindirizza alla homepage
    exit();
  } else {
    $loginErr = "Email o password non valide.";
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
            <a class="nav-link active" aria-current="page" href="index.html">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="registrazione.html">Registrazione</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="login.html">Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Login Content 
  <div class="container my-5">
    <h1 class="text-center">Login</h1>
    <form class="row g-3">
      <div class="col-md-6">
        <label for="inputName" class="form-label">E-mail</label>
        <input type="text" class="form-control" id="inputName" required>
      </div>
      <div class="col-md-6">
        <label for="inputEmail" class="form-label">Password</label>
        <input type="email" class="form-control" id="inputEmail" required>
      </div>
    </form>
          
  <div class="text-center">
    <br>
    <a href="index.html" class="btn btn-light btn-lg">Accedi</a>
  </div>
  </div>
  -->

  <div class="container my-5">
    <h1 class="text-center">Login</h1>

    <form action="<?= htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST">
      <div class="mb-3">
        <label for="inputEmail" class="form-label">E-mail</label>
        <input type="email" class="form-control" id="inputEmail" name="mail" required>
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input type="password" class="form-control" id="inputPassword" name="pwd" required>
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