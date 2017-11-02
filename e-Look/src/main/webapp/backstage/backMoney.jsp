<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <script src="js/jquery.js" type="text/javascript"></script>
 <script type="text/javascript" src="js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="css/jquery-ui.min.css">
<!--   <link rel="stylesheet" href="css/table.css"> -->
<script src="code/highcharts.js"></script>
<script src="code/modules/exporting.js"></script>
<script src="code/themes/dark-unica.js"></script>

<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>eLook後台管理系統</title>
<style type="text/css">
.container{font-family:inherit;
}
b{font-size: 20px;}
</style>

</head>
<body>
	<jsp:include page="backheader.jsp"></jsp:include>
				
<section id="wrapper">
						<header>
							<div class="inner">
								<h2>類別圖表</h2>		
							</div>
						</header>
						</section> 
						
<div id="container" style="width: 80%; height: 700px; margin: 0 auto"></div>
<script>
var ooo = new Array(12);
$.post('<%=request.getContextPath()%>/TestClassMoney',{},function(data){
	//datas=JSON.parse(data);
	$.each(data,function(i,v){
		ooo[i]=parseInt(v);
	})
	Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'e-LOOK收益報表'
    },
    xAxis: {
        categories: [
            '生活',
            '藝術',
            '運動',
            '影音',
            '手作',
            '其他',
            '設計',
            '科技',
            '商業',
            '語言',
            '烹飪',
            '程式'
            
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: '元'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:25px">{point.key}</span><table>',
        pointFormat: '<tr><td style="font-size:15px; color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0 ;font-size:20px"><b>{point.y:.1f}元</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: '課程類別',
        data:ooo
    }]
});
	
},"json")



	</script>

 
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>