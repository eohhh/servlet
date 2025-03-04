/**
 * full.js
 */

document.addEventListener('DOMContentLoaded', function() {
	// event에 사용할 데이터.
	let eventAll = [];

	// Ajax 호출.
	fetch('fullData.do')
		.then(result => result.json())
		.then(result => {
			console.log(result);
			eventAll = result; // 결과를 eventAll에 저장.
			fullCalendarFunc();
		})
		.catch(err => console.log(err));

	// fullCalendar 호출.
	function fullCalendarFunc() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
				left: 'prev,next today',
				center: 'title',
				right: 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate: new Date(),
			navLinks: true, // can click day/week names to navigate views
			selectable: true,
			selectMirror: true,
			select: function(arg) {
				var title = prompt('Event Title:');
				console.log(title, arg.startStr, arg.endStr);
				fetch('addData.do?title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr)
					.then(result => result.json())
					.then(result => {
						if (result.retCode == "OK") {
							// 화면출력.
							if (title) {
								calendar.addEvent({
									title: title,
									start: arg.start,
									end: arg.end,
									allDay: arg.allDay
								})
							}
							calendar.unselect(); // 화면출력.
						} else {
							alert('처리오류!');
						}
					})
					.catch(err => console.log(err));
		
			},
			eventClick: function(arg) {
				console.log(arg);
				console.log(arg.event.startStr);
				// Ajax 호출. -> 컨트롤 -> 삭제 -> 화면삭제.
				if (confirm('이벤트를 삭제하시겠습니까?')) {
					fetch('removeData.do?title='+ arg.event.title + '&start=' + arg.event.startStr + '&end=' + arg.event.endStr)		
					
					.then(result => result.json()) // json(자바스크립트) 객체로 변환.
					.then(result => {
						
						if(result.retCode == 'OK') {
							
					arg.event.remove()								
						} else {
							alert('삭제중 예외.')
						}
					})	
					.catch(err => console.log(err))		
				}
			},
			editable: true,
			dayMaxEvents: true, // allow "more" link when too many events
			events: eventAll
		});
		calendar.render();
	}


});

