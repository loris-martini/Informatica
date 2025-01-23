<?php
  session_start();
?>
<!DOCTYPE html>
<html lang="it">
<head>
  <title>Votazioni Collegio</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Votazioni Collegio</a>
      
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

  <!-- Hero Section -->
  <?php if(isset($_SESSION['logged']) && $_SESSION['logged']){?>
    <div class="container-fluid p-5 bg-primary text-white text-center">
      <h1>SEI LOGGATO</h1>
    </div>
  <?php }else{?>
    <div class="container-fluid p-5 bg-primary text-white text-center">
      <h1>Benvenuto nel nostro sito!</h1>
      <p>Crea e partecipa a votazioni facilmente!!!</p>
      <a href="login.php" class="btn btn-light btn-lg">Accedi</a>
      <p>Oppure se ancora non lo hai fatto</p>
      <a href="registrazione.php" class="btn btn-light btn-lg">Registrati</a>
    </div>
    <?php };?>

  <!-- Footer -->
  <footer class="bg-light text-center p-3 mt-5">
    <p><b>ITT BUONARROTI TRENTO</b></p>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
