<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
     

		let aryData = [];   // [[],[],[]....];
		
		fetch('chartData.do') // json 으로 가져옴. // fetch함수는 제일 늦게 시작.
		.then(result => result.json()) // 가져온 값을 파싱.
		.then(result => {
			aryData.push(['부서명', '인원']); // 배열의 값을 담을때는 push.
			result.forEach(item => { // 변수를 아이템으로 받아와서..
				aryData.push([item.dept_name, item.dept_count]); // 네임,카운트값을 배열로 선언해서 aryData에 담아줌.
			});
			console.log(aryData);
			 google.charts.load('current', {'packages':['corechart']}); // 차트를 먼저 그려줄수 있도록 이 안으로 넣어줌. 
		     google.charts.setOnLoadCallback(drawChart); 				// 차트를 먼저 그려줄수 있도록 이 안으로 넣어줌.
		})
		.catch (err => console.log(err));
		
      function drawChart() {
    	  	
        var data = google.visualization.arrayToDataTable(aryData); // aryData 테이블 먼저 실행이 되게 순서를 조정.

        var options = {
          title: '부서별 인원 현황.'        
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
