/**
 * array.js
 * forEach, filter, map, reduce 메소드.
 */
let ary =[
	{id: 100, name: "홍길동", score: 345},
	{id: 101, name: "김말숙", score: 456},
	{id: 102, name: "최선기", score: 232}
]

// reduce 누적된값 (acc)
let result = ary.reduce((acc, item, idx, array) => {
	console.log(acc);
	return acc + item.score ; // acc: accumulator
}, 0);
console.log('최종결과: ', result);

result = ary.reduce((acc, item) => {
	return acc > item.score ? acc : item.score;
}, 1000);
console.log('최종Min: ', result);

// filter: 300점 이상.
result = ary.reduce((acc, item) => {
	if(item.score > 300) {
		acc.push(item); // [{}]
	}
	return acc;
}, []);
console.log('최종결과: ', result);

result = ary.reduce((acc, item) => {
	let li = document.createElement('li') 	// createElement: 요소를 만들어주는 메소드.
	li.innerHTML = 'id: ' + item.id + ', name: ' + item.name;
	acc.appendChild(li);
	return acc; 	// <ul></ul> 반환.
}, document.getElementById('list'));

/*
ary.forEach((item, idx, array) => { // 화살표 함수.(function)
	console.log(item, idx, array);
})

let filAry = ary.filter(item => { // filter (필터링.)
	if (item.score > 400 ) {
		return true;
	}
		return false;
})
console.log(filAry);

// map(ping)
let mapAry = ary.map(item => {
	// A그룹: 400, B그룹: 300, C그룹:그외
	if(item.score > 400) {
		item.group = 'A';
	} else if (item.score > 300) {
		item.group = 'B';
	} else {
		item.group = 'C';
	}
	return item;
});
console.log(mapAry);

*/