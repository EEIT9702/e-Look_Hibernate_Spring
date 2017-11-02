<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/alan/sweet/sweetalert2.min.css">
<script src="<%=request.getContextPath()%>/alan/sweet/sweetalert2.min.js"></script>
<script src="<%=request.getContextPath()%>/alan/lib/jquery-2.1.1.min.js"></script> 
<title>Insert title here</title>

<script>
//http://www.htmleaf.com/jQuery/Lightbox-Dialog/201606123589.html
//選取檢舉留言
function warning() {
	swal({
		  title: '檢舉留言',
		  input: 'select',
		  inputOptions: {
		    '含有仇恨言論': '含有仇恨言論',
		    '不雅內容': '不雅內容',
		    '垃圾訊息': '垃圾訊息'
		  },
		  inputPlaceholder: '請選擇檢舉事項',
		  confirmButtonText: '確認',
		  cancelButtonText: '取消',
		  showCancelButton: true,
		  inputValidator: function(value) {
		    return new Promise(function(resolve) {
		    	resolve();
// 		      if (value === '垃圾訊息') {
// 		        resolve();
// 		      } else {
// 		        reject('You need to select Ukraine :)');
// 		      }
		    });
		  }
		}).then(function(result) {
		  if (result) {
				
			    swal({
			      confirmButtonText: '確認',
			      type: 'success',
	 		      //html: '檢舉成功 : ' + result
			      html: '檢舉成功，管理員會盡快審核 '
			    });

		 	}
		});
}

// $('#select1').on('click',function(){
// 	swal({
// 		  title: 'Select Ukraine',
// 		  input: 'select',
// 		  inputOptions: {
// 		    'SRB': 'Serbia',
// 		    'UKR': 'Ukraine',
// 		    'HRV': 'Croatia'
// 		  },
// 		  inputPlaceholder: 'Select country',
// 		  showCancelButton: true,
// 		  inputValidator: function(value) {
// 		    return new Promise(function(resolve, reject) {
// 		      if (value === 'UKR') {
// 		        resolve();
// 		      } else {
// 		        reject('You need to select Ukraine :)');
// 		      }
// 		    });
// 		  }
// 		}).then(function(result) {
// 		  if (result) {
// 		    swal({
// 		      type: 'success',
// 		      html: 'You selected: ' + result
// 		    });
// 		  }
// 		});
// });

	
//	確認取消選擇
// swal1({
//   title: 'Are you sure?',
//   text: "You won't be able to revert this!",
//   type: 'warning',
//   showCancelButton: true,
//   confirmButtonColor: '#3085d6',
//   cancelButtonColor: '#d33',
//   confirmButtonText: 'Yes, delete it!'
// }).then(function(isConfirm) {
//   if (isConfirm) {
//     swal1(
//       'Deleted!',
//       'Your file has been deleted.',
//       'success'
//     );
//   }
// })
</script>
</head>
<body>
<input style="margin-top:100px;margin-left:100px;" id="select1" type="submit" value="選擇" onclick="warning()"/>
<input style="margin-top:100px;margin-left:100px;" id="sure" type="submit" value="確認選擇" onclick=""/>

</body>
</html>