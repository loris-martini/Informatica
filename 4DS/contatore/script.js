const c = document.querySelector(".count");
const count = document.querySelector(".contatore");
const tabella = document.querySelector(".tabella");
const backButton = document.querySelector(".back");
const testo = document.querySelector(".in")
const show = document.getElementById("show")
let score = 0;

function scelta(n){
    backButton.classList.remove("hidden");
    tabella.classList.add("hidden");

    switch(n){
        case 1:
            count.classList.remove("hidden");
            break;
        case 2:
            testo.classList.remove("hidden");
            
    }
    
}

function add(){
    score++;
    c.innerText = String(score);
}

function back(){
    tabella.classList.remove("hidden")
    count.classList.add("hidden")
    backButton.classList.add("hidden")
    testo.classList.add("hidden");
}

function scrivi(){
    const txt = document.getElementById("test").value
    show.innerHTML = txt;
}