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
$nameErr = $surNameErr = $emailErr = $passwordErr = "";
$isFormValid = true;

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name is required";
    $isFormValid = false;
  }

  if (empty($_POST["surname"])) {
    $surNameErr = "Surname is required";
    $isFormValid = false;
  }

  if (empty($_POST["mail"])) {
    $emailErr = "Email is required";
    $isFormValid = false;
  }

  if (empty($_POST["pwd"])) {
    $passwordErr = "Password is required";
    $isFormValid = false;
  }

  if ($isFormValid) {
    $_SESSION['user'] = [
      'name' => $_POST['name'],
      'surname' => $_POST['surname'],
      'email' => $_POST['mail'],
      'password' => $_POST['pwd']
    ];
    header("Location: login.php");
    exit();
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
  
  <!-- registrazione Content -->
  <div class="container my-5">
    <h1 class="text-center">Registrazione</h1>

    <form class="row g-3" action="<?= htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
      <div class="col-md-6">
        <label for="inputName" class="form-label">Nome</label>
        <span class="error">* <?= $nameErr;?></span>
        <input type="text" class="form-control" id="text" name="name">
      </div>
      <div class="col-md-6">
        <label for="inputName" class="form-label">Cognome</label>
        <span class="error">* <?= $surNameErr;?></span>
        <input type="text" class="form-control" id="text" name="surname">
      </div>
      <div class="col-md-6">
        <label for="inputName" class="form-label">E-mail</label>
        <span class="error">* <?= $emailErr;?></span>
        <input type="email" class="form-control" id="inputEmail" name="mail">
      </div>
      <div class="col-md-6">
        <label for="inputEmail" class="form-label">Password</label>
        <span class="error">* <?= $passwordErr;?></span>
        <input type="text" class="form-control" id="text" name="pwd">
      </div>
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
