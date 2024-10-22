/*---------------------
FASE DI PREPARAZIONE
---------------------*/

//recuperare dalla pagina tutt fli elementi di interessi

const scoreCounter = document.querySelector(".score-counter");
const grid = document.querySelector(".grid");
const endGameScreen = document.querySelector(".end-game-screen");
const endGameText = document.querySelector(".end-game-text");
const playAgainButton = document.querySelector(".play-again");
const lvlButton = document.querySelector(".scelta");
const gameBoard = document.querySelector(".game-board");
const scoreBoard = document.querySelector(".score");

//Preparo dalle informazione gioco
const totalCells = 100;
let totalBombs = null;
let totalWin = null;
let score = 0;

/*---------------------
FUNZIONI
---------------------*/

function gioca(lvl) {
    if (lvl === 1) {
        totalBombs = 5;
        totalWin = 10;
    } else if (lvl === 2) {
        totalBombs = 10;
        totalWin = 5;
    } else {
        totalBombs = 20;
        totalWin = 1;
    }

    lvlButton.classList.add("hidden");
    scoreBoard.classList.remove("hidden");
    gameBoard.classList.remove("hidden");

    const maxScore = totalCells - totalBombs;
    const bombList = [];
    const winList = [];

    //genera tot bombe casuali

    while (bombList.length < totalBombs) {
        const number = Math.floor(Math.random() * totalCells) + 1;
        if (number !== bombList.includes(number)) {
            bombList.push(number);
        }
    }

    console.log(bombList);

    //genero il tesoro

    while (winList.length < totalWin) {
        const number = Math.floor(Math.random() * totalCells) + 1;
        if (number !== winList.includes(number)) {
            winList.push(number);
        }
    }

    console.log(winList);

    /*---------------------
    GRIGLIA DI GIOCO
    ---------------------*/

    let isCellEven = false;
    let isRowEven = false;

    for (let i = 1; i <= 100; i++) {
        const cell = document.createElement("div");
        cell.classList.add("cell");
        //cell.innerText = i;

        isCellEven = i % 2 === 0;

        if (isCellEven && isRowEven) cell.classList.add("cell-dark");
        else if (!isRowEven && !isCellEven) cell.classList.add("cell-dark");

        //lo inserisco nella griglia
        if (i % 10 === 0) isRowEven = !isRowEven;

        cell.addEventListener("click", function () {
            if (cell.classList.contains("cell-clicked")) return;

            if (bombList.includes(i)) {
                cell.classList.add("cell-bomb");
                endGame(false);
            }
            if (winList.includes(i)) {
                cell.classList.add("cell-win");
                endGame(true);
            }
            cell.classList.add("cell-clicked");
            updateScore();
        });

        grid.appendChild(cell);
    }


    function updateScore() {
        score++;
        scoreCounter.innerText = String(score).padStart(5, 0);
        if (score === maxScore) endGame(true);
    }

    function endGame(isVictory) {
        if (isVictory) {
            endGameScreen.classList.add("win");
            endGameText.innerHTML = "YOU<br>WIN"
        }
        revealAllBombs();
        endGameScreen.classList.remove("hidden");
    }

    function revealAllBombs() {
        const cells = document.querySelectorAll(".cell");
        for (let i = 1; i <= cells.length; i++) {
            if (bombList.includes(i)) {
                const cellToReveal = cells[i - 1];
                cellToReveal.classList.add("cell-bomb");
            } if (winList.includes(i)) {
                const cellToReveal = cells[i - 1];
                cellToReveal.classList.add("cell-win");
            }
        }
    }
}

/*---------------------
EVENTI
---------------------*/

playAgainButton.addEventListener("click", function () {
    location.reload();
});