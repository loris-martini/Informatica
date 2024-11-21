<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dati Ricevuti</title>
    <style>
        table {
            /*width: 100%;*/
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Dati inviati dal form</h1>
    <table>
        <tr>
            <th>Campo</th>
            <th>Valore</th>
        </tr>
        <tr>
            <td>Testo</td>
            <td><?= htmlspecialchars($_POST['text'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><?= htmlspecialchars($_POST['password'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><?= htmlspecialchars($_POST['email'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Numero</td>
            <td><?= htmlspecialchars($_POST['number'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Data</td>
            <td><?= htmlspecialchars($_POST['date'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Colore</td>
            <td><div style='width: 50px; height: 20px; background-color:<?= htmlspecialchars($_POST['color'] ?? '') ?>;'></div></td>
        </tr>
        <tr>
            <td>Genere</td>
            <td><?= htmlspecialchars($_POST['gender'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Interessi</td>
            <td><?= isset($_POST['interests']) ? htmlspecialchars(implode(', ', $_POST['interests'])) : '' ?></td>
        </tr>
        <tr>
            <td>Paese</td>
            <td><?= htmlspecialchars($_POST['country'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Messaggio</td>
            <td><?= htmlspecialchars($_POST['message'] ?? '') ?></td>
        </tr>
        <tr>
            <td>Range</td>
            <td><?= htmlspecialchars($_POST['range'] ?? '') ?></td>
        </tr>
    </table>
</body>
</html>
