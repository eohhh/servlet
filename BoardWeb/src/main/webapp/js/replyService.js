/**
 * replyService.js
 */
const svc = {
	name: "Hong", 			// 기능이 안담겨있기 때문에 이건 속성.
	//showName: function() {  // 기능이 담겨있으면 매소드.
	//return this.name;
	//},
	// 목록메소드.
	replyList: function(bno, successCallback, errorCallback) {
	console.log(bno);
		fetch('replyList.do?bno=' + bno)
			.then(result => result.json()) // 화살표 함수.
			.then(successCallback) 	// 정상작동시 실행할 함수.
			.catch(errorCallback) 	// 에러시 실행할 함수
	},
	// 등록메소드.
	addReply(param = { bno, reply, replyer }, successCallback, errorCallback) {
		fetch('addReply.do?bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer)
			.then(result => result.json())
			.then(successCallback) 	// 정상작동시 실행할 함수.
			.catch(errorCallback)	// 에러시 실행할 함수.
	},
	// 삭제메소드.
	removeReply(rno = 1, successCallback, errorCallback) {
		fetch('removeReply.do?rno=' + rno)
		fetch('replyList.do?bno=' + bno)
			.then(result => result.json()) // 화살표 함수.
			.then(successCallback) 	// 정상작동시 실행할 함수.
			.catch(errorCallback) 	// 에러시 실행할 함수
	}
}
