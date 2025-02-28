/**
 * full.js 
 */


document.addEventListener('DOMContentLoaded', function() {
	
	let eventAll =[];
	fetch('fullData.do')
	.then(result => result.json())
	.then(result => {
		eventAll =result; // 결과를 eventAll에 저장.
		fullCalendarFunc();
	})
	.catch(err => console.log(err));
// fullCalendar호출.
function fullCalendarFunc(){
	
  var calendarEl = document.getElementById('calendar');
  var calendar = new FullCalendar.Calendar(calendarEl, {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    initialDate: '2025-08-10',
    navLinks: true, // can click day/week names to navigate views
    selectable: true,
    selectMirror: true,
    select: function(arg) {
      var title = prompt('Event Title:');
	  console.log(title, arg.startStr, arg.endStr);
      if (title) {
        calendar.addEvent({
          title: title,
          start: arg.start,
          end: arg.end,
          allDay: arg.allDay
        })
      }
      calendar.unselect(); // 화면출력.
    },
	
    eventClick: function(arg) {
      if (confirm('Are you sure you want to delete this event?')) {
        arg.event.remove()
      }
    },
    editable: true,
    dayMaxEvents: true, // allow "more" link when too many events
    events: eventAll
	
  });
  calendar.render();
}
});
