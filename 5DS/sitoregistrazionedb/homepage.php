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
//json_encode($_SESSION['user'])
  session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST" && $_POST['delete'] == "delete") {
    session_destroy();
    header("Location: index.html"); // Reindirizza alla homepage
    exit();
}
?>

<body>
  <br>
    <h1>Ciao <b><?= $_SESSION['user']['name']?> <?=$_SESSION['user']['surname']?></b></h1>
    <br>
    <h2>Informazioni Personali:</h2>
    <h3><?= $_SESSION['user']['email']?>
    <br>
    <br>
    <form action="<?= $_SERVER["PHP_SELF"]?>" method="POST">
      <input type="hidden" name="delete" value="delete">
      <button type="submit" class="btn btn-primary">ELIMINA DATI</button>
    </form>
</body>
  

  <!-- Footer -->
  <footer class="bg-light text-center p-3 mt-5">
    <p><b>ITT BUONARROTI TRENTO</b></p>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
