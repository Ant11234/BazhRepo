---
toc: True
comments: True
layout: post
title: Final Project - Individual
description: Final Trimester 1 Individual Blog
type: devops
courses: {'csa': {'week': 11}}
---

## Individual Code
- Below I have addded sections of code that I am proud of in my final project that shows contribution and a good understanding of java and other topics in this timerster.


```Java
const playerImages = [
            'https://github.com/Ant11234/student/assets/40652645/15b4e3de-f9c4-4c70-adc9-d696cffd6ad7',
            'https://github.com/Ant11234/student/assets/40652645/97854bf1-907b-4a51-9de1-7064b7f296da',
            'https://github.com/Ant11234/student/assets/40652645/2122f367-aea5-4a97-bb5d-ace685929f77'
        ];
        let currentPlayerImageIndex = 0;
        function changePlayerImage() {
            // Update the player image source with the next image in the array
            playerImage.src = playerImages[currentPlayerImageIndex];
            // Increment the index or reset it to 0 if it exceeds the array length
            currentPlayerImageIndex = (currentPlayerImageIndex + 1) % playerImages.length;
        }
        // Call the changePlayerImage function every second (1000 milliseconds)
        setInterval(changePlayerImage, 10000);
```

# Improvements
- Fixes to extreme rapid movement and a better way to change animation of player
    - Rapid Shooting: https://ant11234.github.io/student/game
- Changed animation in order to make the ship stop disappearing
# Things Learned
- Learnt about the problem with creating a new listener every event
- Timeout functions
- Animation using multiple individual images and switching between them


```Java
createButton.addEventListener("click", () => {
    username = input.value;
    const postData = {
        leaderboard: username,
        score: score,
    };
    fetch(`http://localhost:8027/api/leaderboard/post/${username}/${score}`, {
            method: 'POST',
            mode: 'cors',
            cache: 'default',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer my-token'
            },
            body: JSON.stringify(postData)
    })
    .then(response => response.json())
    .then(data => {
        //
    })
    .catch(error => {
        console.error("Error: " + error);
    });
});
generateButton.addEventListener("click", () => {
    fetch("http://localhost:8027/api/leaderboard/")
    .then(response => response.json())
    .then(data => {
        leaderboardTable.innerHTML = ""; // Clear previous data
        data.forEach(item => {
            const row = leaderboardTable.insertRow(-1);
            const cell1 = row.insertCell(0);
            const cell2 = row.insertCell(1);
            cell1.innerHTML = item.leaderboard;
            cell2.innerHTML = item.score;
            console.log(item.score);
        });
    })
    .catch(error => {
        console.error("Error:", error);
    });
});
```

# Improvements
- Worked to make an API for the first time
# Things Learned
- How API's work, their function, and how to get them to work in code
- How to get information from an API to the frontend
    - Taking the information from the API and putting it on the leaderboard


```Java
const miniBoss = {
    x: 0,
    y: 0,
    width: 100,
    height: 100,
    speed: 15,
};
// Function to spawn the mini-boss
// Function to spawn the mini-boss
function spawnMiniBoss() {
    let minDistance = 300; // Minimum distance between player and mini-boss
    let validSpawn = false;
    while (!validSpawn) {
        miniBoss.x = Math.random() * (canvas.width - miniBoss.width);
        miniBoss.y = Math.random() * (canvas.height - miniBoss.height);
        // Calculate the distance between player and mini-boss
        let distance = Math.sqrt(Math.pow(player.x - miniBoss.x, 2) + Math.pow(player.y - miniBoss.y, 2));
        if (distance >= minDistance) {
            validSpawn = true;
        }
    }
}
// Draw the mini-boss
function drawMiniBoss() {
    ctx.save();
    ctx.translate(miniBoss.x + miniBoss.width / 2, miniBoss.y + miniBoss.height / 2);
    ctx.rotate(Math.PI); // Rotate by 180 degrees (π radians)
    ctx.drawImage(minibossImage, -miniBoss.width / 2, -miniBoss.height / 2, miniBoss.width, miniBoss.height);
    ctx.restore();
}
// Update the mini-boss
function updateMiniBoss() {
    miniBoss.x += (Math.random() - 0.5) * miniBoss.speed;
    miniBoss.y += (Math.random() - 0.5) * miniBoss.speed;
    miniBoss.x = Math.max(0, Math.min(canvas.width - miniBoss.width, miniBoss.x));
    miniBoss.y = Math.max(0, Math.min(canvas.height - miniBoss.height, miniBoss.y));
}
setInterval(() => {
    miniBoss.speed += 1; // Increase miniboss speed by 1 (you can adjust the increment as needed)
}, 5000);
// Check for collisions with the mini-boss
function checkMiniBossCollision() {
    if (
        player.x < miniBoss.x + miniBoss.width &&
        player.x + player.width > miniBoss.x &&
        player.y < miniBoss.y + miniBoss.height &&
        player.y + player.height > miniBoss.y
    ) {
        isGameOver = true;
    }
    for (let i = 0; i < bullets.length; i++) {
        if (
            bullets[i].x < miniBoss.x + miniBoss.width &&
            bullets[i].x + bullets[i].width > miniBoss.x &&
            bullets[i].y < miniBoss.y + miniBoss.height &&
            bullets[i].y + bullets[i].height > miniBoss.y
        ) {
            spawnMiniBoss(); // Respawn the mini-boss
            bullets.splice(i, 1);
            score += 20; // Increment the score when mini-boss is hit
        }
    }
}
```

# Improvements
- Random movement
- Created a good model that blends in with background
- Making sure boss doesn't spawn on player instantly ending the game
- Gradually increasing mini-boss speed
# Things Learned
- Use of tools like canva to create models for projects
- Position of things in a canvas, and how to make sure that they don't overlap with something else

# Github Commits
- Profile: https://github.com/Ant11234
- Issues: https://github.com/Ant11234/student/issues
- Repository: https://github.com/Cosmic-Carnage

## Individual Blog

# College Board Quiz Notes
- Journal of Searches During Quiz
    - What is a constructor in Java
    - How to declare and use methods in Java
    - Java inheritance and polymorphism explanation
    - String manipulation methods in Java
    - Exception handling in Java.
    - Object-oriented programming principles
    - Java access modifiers (public, private, protected, default)
    - Sorting and searching algorithms in Java
    - Understanding the "this" keyword in Java
    - Java collections (e.g., HashMap, HashSet) usage
- Corrected Questions
    - Question 12:
        - Incorrect because it would only be true if k was incremented by 1 and the for loop only went to input.length()-1
    - Question 22:
        - Should be B because the code can't call an audiobooks pages per minute
    - Question 24:
        - 5 is at [1][1] not [2][0]
    - Quesiton 38:
        - Will return false when y is below 10000, x has no effect
# Trimester 1 Reflection
- Period 1 CSA has been one of my most memorable classes I've had during my time at Del Norte. Throughout this trimester, I feel as if I've made some close friends in my teamates, and have grown a lot and learned a lot especially in respect to computer science. While coming into this class I was expecting my previous knowledge in python to help considerably, and I believed that my previous experiences working on collaborative projects like in my AI research paper would make this class easy. I was mistaken. Even though this knowledge definently made a considerable impact. I was initially overwelmed with work trying to learn a new language and complete tons of dev ops stuff. However, after getting into the groove of it, I wouldn't have it any other way. The challenge this class has provided me has propelled my computer science knowledge, and I feel much more well versed and comftorable despite majority of this being new. I feel as if in this short time I have learned and progressed further than I ever thought I would. I am pleasently suprised by the drastic effect this class has had on my ability in computer science, and its ability to reignit my love for computer science. In future trimesters I hope to recieve a similar challenge in order to come out a more proficient coder and keep kindiling my passion for computer science.
