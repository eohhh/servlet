/**
 * js/test.js
 * JSON 포맷 (문자열 - 객체)
 */
console.log('경로정상.');

let json = `{"name": "홍길동", "age": 20}`; // json 포맷 예시. (문자열) json 문자열.
let obj = JSON.parse(json);
document.querySelector('input[name="name"]').value = obj.name;
document.querySelector('input[name="age"]').value = obj.age;

// 서버(servlet)로부터 - jsp페이지.
// Asychronous(비동기 방식) Javascript And Xml 
console.log('1'); // 실행순서 1. ==> fetch함수를 가장 마지막에 실행. 이유: 만약 웹에서 아이디 비밀번호를 호출할때 시간이 오래걸리므로 요청만 해놓고 다른거부터 호출하기 위해..?
fetch('testData.do') // url('testData.do')을 호출하면 보여주는 내용이 then 매소드의 실행하는 함수의 내용을 호출. 여기서 나오는 결과값:result..
	.then(function(result) {
		console.log(result); // body: stream
		return result.json(); // stream(json문자열) -> object로 반환..  // return 해주는 문자열이 다시 then 매소드의 결과값으로 반환..
	})
	.then(function(result) {
		console.log(result); // 이 값(json 문자열)을 가지고
		document.querySelector('input[name="name"]').value = result.name;
		document.querySelector('input[name="age"]').value = result.age;
		console.log('2'); // 실행순서 3. fetch함수를 가장 마지막에 실행.
	})

	console.log('3'); // 실행순서 2.
	
