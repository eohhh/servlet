/**
 *	member.js 
 */
// 삭제함수 만들기.
function deleteRow(id) {
	console.log(id);
	let btn = this;
	fetch("removeMember.do?mid=" + id)
	.then(function(result) {
		return result.json();
	})
	.then((result) => {
		console.log(result);
		if(result.retCode == "OK") {
			btn.parentElement.parentElement.remove(); // button의 상위요소의 상위요소를 지우겠다.
		} else if (result.retCode == "NG") {
			alert('삭제오류 발생');
		} else {
			alert('알수 없는 코드입니다.');
		}
	})
} // end of delete

fetch("testData.do")
	.then(function(result) {
		return result.json(); // stream 타입을-> object 타입으로.
	})
	.then(function(result) {
		const memberAry = result;
		memberAry.forEach(function(member) {
			const target = document.querySelector('#list');
			const html = `<tr>		
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