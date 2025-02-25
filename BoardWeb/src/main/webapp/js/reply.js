/**
 * reply.js
 */

// 댓글정보를 가지고 오면 목록에 그려지는 함수.
function makeReply(reply = {}) {
	let html = `<li data-id="${reply.replyNo}">
					<span class="col-sm-2">${reply.replyNo}</span>
					<span class="col-sm-5">${reply.reply}</span>
					<span class="col-sm-2">${reply.replyer}</span>
					<span class="col-sm-2"><button onclick="deleteRow('${reply.replyNo}')">삭제</button></span>	  
			    </li>`;
	return html
}
// 글삭제
function deleteRow(rno) {
	if(!confirm("삭제하시겠습니까?")) {
		alert('취소합니다.');
		return;
	}
	svc.removeReply(rno //
		, function(result) {
			if (result.retCode == 'OK') {
				document.querySelector('li[data-id="' + rno + '"]').remove();
			}
		}
		, function(err) { console.log(err); })
	
}
// 목록.
svc.replyList(bno, function(result) {		// 원본 글번호;
	let resultAry = result;
	resultAry.forEach(reply => {
		let target = document.querySelector('.reply>.content>ul')

		target.insertAdjacentHTML('beforeend', makeReply(reply))
	});

}, function(err) { // 실패시 함수실행.
	console.log(err);

});

// 댓글등록 이벤트 id = "#addReply""
document.querySelector('#addReply').addEventListener('click', function() {
	// 원본글번호: bno, 작성자: logId, 댓글 :??
	// id="reply"
	const reply = document.querySelector('#reply').value;
	const replyer = logid;
	
	if(!reply || !replyer) {
		alert('필수입력값을 확인하셍.');
		return;
	}
	const parm = { bno, reply, replyer }

	svc.addReply(parm // 첫번째 파라메타.
		, function(result) { // 두번째 파라메타.
			if(result.retCode == 'OK') {
			const html = makeReply(result.retVal);	
			let target = document.querySelector('.reply>.content>ul');
			target.insertAdjacentHTML('beforeend', html);
			} else {
				alert('처리 예외 발생.');
			}
		} 
		, function(err) {console.log(err) });

});
