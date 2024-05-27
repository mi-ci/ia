console.log("test");

const title1 = document.getElementById("title");
console.log(title1);

const title2 = document.querySelector("#title");
console.log(title2);

const container1 = document.getElementsByClassName("container");
console.log(container1);

const container2 = document.querySelector(".container");
console.log(container2);

const container3 = document.querySelectorAll(".container");
console.log(container3);

const newDiv = document.createElement("div");
const newP = document.createElement("p");
const newH2 = document.createElement("h2");
newDiv.append(newP);
newDiv.append(newH2);
console.log(newDiv);

const newButton = document.createElement("button");
newButton.textContent = "삽입";
container2.append(newButton);
const newButton2 = document.createElement("button");
newButton2.textContent = "저장";
container3[1].append(newButton2);

const bodyEl = document.querySelector("body");
const h1El = document.querySelectorAll("#title");
bodyEl.removeChild(h1El[1]);
