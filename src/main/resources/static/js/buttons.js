const targetButton = document.querySelector(".target");
const fadeButton = document.querySelector(".fade");

const height = document.documentElement.clientHeight-100;
const width = document.documentElement.clientWidth-100;

const targetButtonDiv = document.getElementById("targetButton");
const fadeButtonDiv = document.getElementById("fadeButton");

const hitsCounter = document.getElementById("hitsHeader");
const scoreCounter = document.getElementById("scoreHeader");
const timeCounter = document.getElementById("timerHeader");

var score = 0;
var counter = 0;
var seconds=60;
var timer;
var streak = 0;

window.addEventListener('load', startGame());

function startTimer() {
    if(seconds < 60) { 
        timeCounter.innerHTML = seconds;
    }
    if (seconds >0 ) { 
        seconds--;
    } else {
        clearInterval(timer);
        sendHS(2);
        clearGame();
    }
}

function sendHS(id){
    var tempId = id;
    var tempScore = score;
    $.ajax({
        type : "GET",
        url : "/game/processHighscore/"+id+"&"+score,
        data : {
            id:tempId,
            score:tempScore
        },
        timeout : 1000,
        success : function(id) {
            console.log("success");
        },
        error : function(e) {
            console.log("error: " + e);   

        },
        done : function(e) {
            console.log("done");
        }
    });
}

function scoreCalculator(){
    score += 10+streak;
    streak++;
    counter++;
    scoreCounter.innerHTML = 'Score: ' + score;
    hitsCounter.textContent = 'Hits: ' + counter;
}

function clearGame(){
    targetButton.removeEventListener("click", targetButtonEvList());
    fadeButtonDiv.style.opacity = 1;
    fadeButtonDiv.style.visibility = "visible";
    targetButtonDiv.style.opacity = 0;
    targetButtonDiv.style.visibility = "hidden";
    hitsCounter.style.opacity = 0;
    hitsCounter.style.visibility = "hidden";
    timeCounter.style.opacity = 0;
    timeCounter.style.visibility = "hidden";
    scoreCounter.style.opacity = 0;
    scoreCounter.style.visibility = "hidden";
    score = 0;
    counter = 0;
    seconds=60;
    timer;
    streak = 0;
}
function startGame(){
    targetButton.addEventListener("click", () => targetButtonEvList());
    fadeButton.addEventListener("click", () => fadeButtonEvList());
    document.getElementById("streakAnuller").addEventListener("click",() => {
        streak = 0;
    });
}

function targetButtonEvList(){
    let randY = Math.floor((Math.random() * height));
    let randX = Math.floor((Math.random() * width));
    
    targetButtonDiv.style.top = randY + "px";
    targetButtonDiv.style.right = randX + "px";
    scoreCalculator();
}

function fadeButtonEvList(){
    fadeButtonDiv.style.opacity = 0;
    fadeButtonDiv.style.visibility = "hidden";
    targetButtonDiv.style.opacity = 1;
    targetButtonDiv.style.visibility = "visible";
    hitsCounter.style.opacity = 1;
    hitsCounter.style.visibility = "visible";
    timeCounter.style.opacity = 1;
    timeCounter.style.visibility = "visible";
    scoreCounter.style.opacity = 1;
    scoreCounter.style.visibility = "visible";
    if(!timer) {
        timer = window.setInterval(function() { 
            startTimer();
        }, 1000); 
    }
}
