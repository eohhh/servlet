/**
 * api.js
 */
let centerAll = [];

// 이벤트(select태그에 change) 등록.
document.getElementById('centerList').addEventListener('change', function(e) {
	console.log(e.target);
	let sidoName = e.target.value; // "서울특별시", "인천광역시" ....

	let filterSido = [];
	filterSido = centerAll.filter(item => { // filter (필터링.)
		if (item.sido == sidoName) {
			return true;
		}
		return false;
	})
	console.log(filterSido);
	makeCenterList(filterSido);
});  //change이벤트.

function makeCenterList(centerAry = []) {
	let fields = ['id', 'centerName', 'phoneNumber', 'sido'];
	// 기존목록 삭제.
	document.getElementById('list').innerHTML = '';

	// 센터정보.
	centerAry.forEach(center => {
		
		// tr>td*4
		let tr = document.createElement('tr');
		tr.setAttribute('class', 'pe-auto');
		tr.addEventListener('click', function() {
			console.log(center.lat, center.lng);
			window.open('map.do?lat=' + center.lat + '&lng=' + center.lng + '&cname=' + center.centerName);
		})
		for (let i = 0; i < fields.length; i++) {
			let td = document.createElement('td');
			td.innerHTML = center[fields[i]];
			tr.appendChild(td);
		}
		document.getElementById('list').appendChild(tr);
	})
}
// Ajax. (fetch..then..)
fetch('https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=TdaRJnF4xQrK0uxTRK3DURPhBaJ%2BkOnQcjearcwF2RsS%2Bw8QA3WqRxYo53ROPS6lR2CJ7a%2FT1npDXti9b1%2FIBw%3D%3D')
	.then(result => result.json())
	.then(result => {
		console.log(result.data);
		centerAll = result.data;
		makeSidoList() // fetch,then 안에 넣어야 순서대로 실행 (밖에 있으면 먼저실행됨.)
	})
	.catch(err => console.log(err));

// 시도정보 중복제거 후 화면 출력.
function makeSidoList() {
	let sidoList = []; // ['서울특별시', '인천광역시','대전광역시','광주광역시'...]
	for (let i = 0; i < centerAll.length; i++) {
		if (sidoList.indexOf(centerAll[i].sido) == -1) {
			sidoList.push(centerAll[i].sido);
		}
	}
	console.log(sidoList);
	sidoList.forEach(sido => {
		let opt = document.createElement('option'); // option태그 만들기.
		opt.innerHTML = sido; // <option>서울특별시</option>
		document.getElementById('centerList').appendChild(opt); // centerList의 하위요소에 opt붙이기.
	})

};
