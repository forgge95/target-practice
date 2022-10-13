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
            #myDIV {
                --div-width: 100px;
                position: absolute;
                background-color: coral;
                color: white;
                transition: .5s top, .5s right;
                top: 0;  
                right: calc(100% - var(--div-width));
                width: var(--div-width);
            }
            button {
                z-index: 1;
                position: absolute;
                background: transparent;
            }            
            .dot {
                height: 25px;
                width: 25px;
                background-color: rgb(255, 255, 255);
                border-radius: 50%;
                display: inline-block;
                cursor: pointer;
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
        <h1 style="text-align: center;">Hi there :)</h1>
        <br/>
        <div id="myDIV">
            <button><span class="dot"><span class="dotdot"><span class="dotdotdot"></span></span></span></button>
        </div>
        <script type="text/javascript">
            const btn = document.querySelector("button");
            const height = document.documentElement.clientHeight;
            const width = document.documentElement.clientWidth;
            const box = document.getElementById("myDIV");
            box.style.top = "50%";
            box.style.right = "50%";
            btn.addEventListener("click", () => {
                let randY = Math.floor((Math.random() * height) -10);
                let randX = Math.floor((Math.random() * width) -10);
                box.style.top = randY + "px";
                box.style.right = randX + "px";
            });
        </script>    
    </body>
</html>