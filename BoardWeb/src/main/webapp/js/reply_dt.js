/**
 * reply_dt.js
 */

new DataTable('#example', {
	ajax: 'datatable.do?bno=' + bno,
	lengthMenu: [
		[5, 10, 25, 50, -1],
		[5, 10, 25, 50, 'All']
	]
});

// 화면에서 row추가.
let counter = 'hello';
function addNewRow() {
	// 원본글(bno), replyer(logid), reply(#reply)
	let reply =document.querySelector('#reply').value;
	let param = {bno, reply, replyer: logid}
	// ajax 호출.
	svc.addReply(param, 
		function(result) {
		let rvo = result.retVal;
    table.row
        .add([
            rvo.replyNo,
            rvo.reply,
            rvo.replyer,
            rvo.replyDate
        ])
        .draw(false);
		
		},
		function(err) {
			console.log(err);
		}
	)
	
		
}

document.querySelector('#addReply').addEventListener('click', addNewRow);


const table = new DataTable('#example');
// tr선택,선택해제.
let delNo = 0;
table.on('click', 'tbody tr', (e) => {
	console.log(e.currentTarget.classList);
	let classList = e.currentTarget.classList; // ['selecte']

	if (classList.contains('selected')) {
		classList.remove('selected');
	}
	else {
		table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
		classList.add('selected');
		delNo = e.currentTarget.children[0].innerText; // 댓글번호.
	}
});

document.querySelector('#button').addEventListener('click', function() {
	svc.removeReply(bno, function(result) {
		console.log(result.retCode)
		if (result.retCode == 'OK') {

			// 화면삭제(remove)
			table.row('.selected').remove().draw(false);
		} else {
			alert('처리중 오류')
		}
	}),
		function(err) {
			console.log(err);
		}

});