<!DOCTYPE html>
<html>
    <head>
        <style>
            body{
                background-color: black;
                opacity: 0.8;
            }
            #targetButton {
                --div-width: 100px;
                position: absolute;
                background-color: coral;
                color: white;
                transition: .5s top, .5s right;
                top: 50%;  
                right: 50%;
                right: calc(100% - var(--div-width));
                width: var(--div-width);
                visibility: hidden;
                opacity: 0;
                transition: opacity 2s linear;
            }
            #fadeButton {
                margin: 0;
                position: absolute;
                top: 30%;
                right: 50%;
                -ms-transform: translateY(-30%), translateX(-50%);
                transform: translateY(-30%), translateX(-50%);
                visibility: visible;
                opacity: 1;
                transition: visibility 0s 2s, opacity 2s linear;
            }
            button.target {
                z-index: 1;
                position: absolute;
                height: 50px;
                width: 50px;
                background-color: rgb(255, 255, 255);
                border-radius: 50%;
                display: inline-block;
            }
            button.fade {
                z-index: 1;
                position: absolute;
                background-color: rgb(255, 255, 255);
                width: auto;
                color: whitesmoke;
                background-color: black;
                outline-color: black;
            }
            .dotdot {
                position: relative;
                height: 25px;
                width: 25px;
                background-color: rgb(0, 0, 0);
                border-radius: 50%;
                display: inline-block;
            }
            .dotdotdot {
                position: relative;
                height: 12.5px;
                width: 12.5px;
                top: 6px;
                left: 1px;
                background-color: rgb(255, 255, 255);
                border-radius: 50%;
                display: inline-block;
            }
        </style>
        <title>Game</title>
    </head>
    <body>  
        <div id="fadeButton" style="text-align: center;">
                <button class="fade">Hi there :)</button>
        </div>
        <div id="targetButton" style="text-align: center;">
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
                fadeButtonDiv.style.visibility = "hidden";
                targetButtonDiv.style.top = "30%";
                targetButtonDiv.style.right = "45%";
                targetButtonDiv.style.opacity = 1;
                targetButtonDiv.style.visibility = "visible";
            });
        </script>    
    </body>
</html>