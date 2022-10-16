<!DOCTYPE html>
<html>
    <head>
        <style>
            body{
                background-color: black;
                opacity: 0.8;
            }
            div.first{
                text-align: center;
                color: whitesmoke;
                border-radius: 15px; 
                width: auto; 
                height: auto;
                padding: 5px 30px 5px 30px; 
                font-size: 10px;
            }
            #targetButton {
                --div-width: 100px;
                position: absolute;
                background-color: coral;
                color: white;
                transition: .5s top, .5s right;
                top: 0;  
                right: calc(100% - var(--div-width));
                width: var(--div-width);
                transition: width 1s;
                opacity: 0;
            }
            #fadeButton {
                right: 45%;
                transition: width 1s;
                opacity: 1;
            }
            button.target {
                z-index: 1;
                position: absolute;
                height: 25px;
                width: 25px;
                background-color: rgb(255, 255, 255);
                border-radius: 50%;
                display: inline-block;
            }
            button.fade {
                z-index: 1;
                position: absolute;
                height: 25px;
                min-width: 25px;
                background-color: rgb(255, 255, 255);
                display: inline-block;
            }
            .dot{
                
            }
            .dotdot {
                position: relative;
                top: 5px;
                height: 15px;
                width: 15px;
                background-color: rgb(0, 0, 0);
                border-radius: 50%;
                display: inline-block;
            }
            .dotdotdot {
                position: relative;
                height: 5px;
                width: 5px;
                background-color: rgb(255, 255, 255);
                border-radius: 50%;
                display: inline-block;
            }
        </style>
        <title>Game</title>
    </head>
    <body>  
        <div id="fadeButton" style="text-align: center;">
            <h1 style="text-align: center;color: whitesmoke;">Hi there :)</h1>
            <button class="fade">Start game</button>
        </div>
        <div id="targetButton">
            <button class="target"><span class="dot"><span class="dotdot"><span class="dotdotdot"></span></span></span></button>
        </div>
        <script type="text/javascript">
            const targetButton = document.querySelector(".target");
            const fadeButton = document.querySelector(".fade");

            const height = document.documentElement.clientHeight;
            const width = document.documentElement.clientWidth;
            const targetButtonDiv = document.getElementById("targetButton");
            const fadeButtonDiv = document.getElementById("fadeButton");

            targetButton.addEventListener("click", () => {
                let randY = Math.floor((Math.random() * height) -100);
                let randX = Math.floor((Math.random() * width) -100);
                if (randY < 0) {
                    randY = randY+ 100;
                }
                if (randX < 0) {
                    randX = randX+ 100;
                }
                targetButtonDiv.style.top = randY + "px";
                targetButtonDiv.style.right = randX + "px";
            });

            fadeButton.addEventListener("click", () => {
                fadeButtonDiv.style.opacity = 0;
                targetButtonDiv.style.opacity = 1;
                targetButtonDiv.style.top = "50%";
                targetButtonDiv.style.right = "50%";
                fadeButtonDiv.style.top = 9999 + "px";
                fadeButtonDiv.style.right = 9999 + "px";
            });
        </script>    
    </body>
</html>