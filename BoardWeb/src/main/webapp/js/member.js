/**
 *	member.js 
 */
// 삭제함수 만들기.
// DB에서 삭제, 화면에서 remove(지우기).
function deleteRow(id) {
	console.log(id);
	let btn = this;
	// 서버컨트롤 실행.
	fetch("removeMember.do?mid=" + id) // 서버에서 삭제. 서버처리.
	.then(function(result) {
		return result.json();
	})
	.then((result) => {
		console.log(result);
		if(result.retCode == "OK" ) {
			document.querySelector('#tr_' + id ).remove(); // button의 상위요소의 상위요소를 지우겠다. (한건 지우기.)
		} else if (result.retCode == "NG") {
			alert('삭제오류 발생'); // 에러.
		} else {
			alert('알수 없는 코드입니다.'); // 둘다 아니면.
		}
	})
} // end of deleteRow.

fetch("testData.do")
	.then(function(result) {
		return result.json(); // stream 타입을-> object 타입으로.
	})
	.then(function(result) {
		const memberAry = result;
		memberAry.forEach(function(member) {
			const target = document.querySelector('#list');
			const html = `<tr id =tr_${member.memberId}>
							<td>${member.memberId}</td>
							<td>${member.passwd}</td>
							<td>${member.memberName}</td>
							<td>${member.responsibility}</td>
							<td><button onclick="deleteRow('${member.memberId}')" class="btn btn-danger">삭제</button></td> 
						  </tr>`; 
						  // 아이디, 비밀번호, 이름, 권한.
						  // ``(빽틱)은 줄바꿈 해도 관계없다.
			target.insertAdjacentHTML('beforeend', html);
		});
	})
	
// 추가이벤트.
document.querySelector('#addMember').addEventListener('click', addRow)

// 등록이벤트.
function addRow() {
	const id = document.querySelector("input[name=mid]").value;
	const pw = document.querySelector("input[name=mpw]").value;
	const name = document.querySelector("input[name=mname]").value;
	fetch("addMember.do?mid=" + id + "&mpw=" + pw + "&mname=" + name) 
		.then(function(result) {
			return result.json();
		})
		.then((result) => {
			if(result.retCode == "OK") {
				alert('추가성공');
				const target = document.querySelector('#list');
							const html = `<tr id =tr_${id}>
											<td>${id}</td>
											<td>${pw}</td>
											<td>${name}</td>
											<td>User</td>
											<td><button onclick="deleteRow('${id}')" class="btn btn-danger">삭제</button></td> 
										  </tr>`; 
										  // 아이디, 비밀번호, 이름, 권한.
										  // ``(빽틱)은 줄바꿈 해도 관계없다.
							target.insertAdjacentHTML('beforeend', html);
			} else if (result.retCode == "NG") {
				alert('추가실패');
			} else {
				alert('다시 확인하세요.');
			}
		})
	}
	
	




