/* ----------------------------------
FASE DI PREPARAZIONE DEL NOSTRO GIOCO
-------------------------------------*/

//recuperare dalla pagina tutti gli elementi di interesse
const scoreCounter = document.querySelector('.score-counter');
const grid = document.querySelector('.grid');
const endGameScreen = document.querySelector('.end-game-screen');
const endGameText = document.querySelector('.end-game-text');
const playAgainButtun = document.querySelector('.play-again');

//Preparo delle informazioni utili alla logica di giocos
const totalCells = 9;
let gridCells = [];
let turno = 0;




/*-----------------------
GRIGLIA E LOGICA DI GIOCO
-------------------------*/
let isCellEven = false; 
let isRowEven = false; 
for(let i=0; i<=8; i++){
    //Creo un elemento e gli do la classe cell
    gridCells[i] = document.createElement('div'); 
    gridCells[i].classList.add('cell');
    //cell.innerText = i; 

    //se sono alla fine della riga
    if(i % 3 === 0) isRowEven = !isRowEven; 

    // # Gestiamo il click della cella
    gridCells[i].addEventListener('click', function(){
        // Controllo che la cella non sia gia stata cliccata
        if(gridCells[i].classList.contains('cell-O') || gridCells[i].classList.contains('cell-X')) return; 

        //Questo codice viene eseguito quando avviene l'evento
        if(turno %2 === 0){
            gridCells[i].classList.add('cell-O')
        }else{
            gridCells[i].classList.add('cell-X')
        }
        turno++;

        if(turno>=5){
            if(turno===9){
                endGameScreen.classList.add('pareggio') 
                endGameText.innerHTML = 'PAREGGIO';
                endGameScreen.classList.remove('hidden');
            }else{
                if(checkWinnerO()===true){
                    endGame(false);
                }else if(checkWinnerX()===true){
                    endGame(true);
                }
            }
        }
    }); 

    //Lo inserisco nella griglia
    grid.appendChild(gridCells[i]);
}


/*------
FUNZIONI
--------*/


//funzione per controllare se ce un vincitore
function checkWinnerX() {
    const lines = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // righe
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // colonne
        [0, 4, 8], [2, 4, 6] // diagonali
    ];

    for (let line of lines) {
        if (line.every(cellIndex => gridCells[cellIndex].classList.contains('cell-X'))) {
            return true; // Il giocatore ha vinto
        }
    }
    return false; // Nessun vincitore trovato
}
function checkWinnerO() {
    const lines = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // righe
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // colonne
        [0, 4, 8], [2, 4, 6] // diagonali
    ];

    for (let line of lines) {
        if (line.every(cellIndex => gridCells[cellIndex].classList.contains('cell-O'))) {
            return true; // Il giocatore ha vinto
        }
    }
    return false; // Nessun vincitore trovato
}




//funzione per decretare la fine del gioco
function endGame(isVictory){
    if(isVictory===true){
        endGameScreen.classList.add('win');
        endGameText.innerHTML = 'IL GIOCATORE 2 HA VINTO';
    }else{
        endGameScreen.classList.add('win');
        endGameText.innerHTML = 'IL GIOCATORE 1 HA VINTO';
    }
    endGameScreen.classList.remove('hidden');
}


/*----
EVENTI
------*/
playAgainButtun.addEventListener('click', function(){
    location.reload();
})
