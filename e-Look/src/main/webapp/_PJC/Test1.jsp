<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<title>TinyMCE - Setup5</title>
		<LINK REL="SHORTCUT ICON" HREF="http://www.mydomain.com/myicon.ico">
	</head>
	<body>
		<form id="get-data-form" method="post">


			<textarea class="tinymce" id="texteditor"></textarea>						

			<input name="image" type="file" id="upload" class="hidden" onchange="">
		</form>


<!-- 		<div id="data-container">49491916156-->
<!-- 		</div> -->




		<script src="<%=request.getContextPath()%>/_PJC/js/jquery.js"></script>		
		<script src="<%=request.getContextPath()%>/_PJC/tinymce/js/tinymce/jquery.tinymce.min.js"></script>
		<script src="<%=request.getContextPath()%>/_PJC/tinymce/js/tinymce/tinymce.js"></script>		
		<script>
		$(document).ready(function() {
			  tinymce.init({
			    selector: "#texteditor",
			    language_url:'<%=request.getContextPath()%>/_PJC/tinymce/js/tinymce/langs/zh_TW.js',
			    theme: "modern",
			    paste_data_images: true,
			    plugins: [
			      "advlist autolink lists link image charmap print preview hr anchor pagebreak",
			      "searchreplace wordcount visualblocks visualchars code fullscreen",
			      "insertdatetime media nonbreaking save table contextmenu directionality",
			      "emoticons template paste textcolor colorpicker textpattern"
			    ],
			    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
			    toolbar2: "print preview media | forecolor backcolor emoticons",
			    image_advtab: true,
			    file_picker_callback: function(callback, value, meta) {
			      if (meta.filetype == 'image') {
			        $('#upload').trigger('click');
			        $('#upload').on('change', function() {
			          var file = this.files[0];
			          var reader = new FileReader();
			          reader.onload = function(e) {
			            callback(e.target.result, {
			              alt: ''
			            });
			          };
			          reader.readAsDataURL(file);
			        });
			      }
			    },
			    templates: [{
			      title: 'Test template 1',
			      content: 'Test 1'
			    }, {
			      title: 'Test template 2',
			      content: 'Test 2'
			    }],
			  setup: function(ed) {
				    ed.on('keyup', function(e) {
				        console.log(ed.getContent());
				        $("#courseContent").val(ed.getContent());
				    });
				}
			  });
		
		
		});
		</script>
		
	</body>
</html>