/**
 * 
 */
//alert("test");
let divobj1 = document.querySelector(".mybox")
let divobj2= document.querySelector("#mydiv")

let divobj3 = document.getElementsByClassName("mybox");
let divobj4 = document.getElementById("mydiv");

console.log(divobj1);
console.log(divobj2);
console.log("===============================");
console.log(divobj3);
console.log(divobj4);

//dom 객체에 이벤트 연결하기
//divobj1.addEventListner(이벤트명, 이벤트가 발생할 때 실행할 함수)
//마우스 클릭이벤트가 발생하면 익명의 함수가 실행
divobj1.addEventListener("click",function(){
	//alert("이벤트가 발생됨");
	divobj1.style.backgroundColor = "red";
	divobj1.style.color = "blue";
	//엘리먼트에 클래스를 여러 단계로 정의하기 위해 사용
	divobj1.classList.add("active");
	console.log("==================")
	//엘리 먼트의 클래스 속성에 active가 포함되어 있는지 확인하기 이해 필요
	console.log(divobj1.classList.contains("active"));
	divobj1.classList.remove("active");
	console.log(divobj1.classList.contains("active"));
	console.log(divobj1.textContent); //getter
	console.log(divobj2.textContent);
	console.log(divobj3.textContent);
	console.log(divobj4.textContent);
	divobj1.textContent = "Hello dom"; //setter
	console.log("==================")
	
});