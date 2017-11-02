/**
 * 
 */
	window.fbAsyncInit = function() {
		FB.init({
			appId : '1663714756974189',
			status : true,
			cookie : true,
			xfbml : true,
			version : 'v2.10'
		});

		FB.AppEvents.logPageView();
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/zh_TW/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
	function myFacebookLogin() {
		FB.login(function(response) {
			if (response.status === 'connected') {
				FB.api('/me', {
					fields : 'email,name,last_name,picture'
				}, function(response) {
					
//					console.log('Good to see you, ' + response.name + '.');
//					console.log('Good to see you, ' + response.email + '.');
//					console.log('Good to see you, ' + response.picture.data.url);
//					console.log("http://graph.facebook.com/"+response.id+"/picture?type=large");
				       var name=response.name;
				       var email=response.email;
				       var picture="http://graph.facebook.com/"+response.id+"/picture?type=large";
				       var url="login.login";
				       var xmlHttp=new XMLHttpRequest();
				       xmlHttp.open("POST",url,false);
				       xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				       xmlHttp.send("loginstatus=fb&mName="+name+"&email="+email+"&mPhoto="+picture);

				      document.location.href=location.href;
				});
			}  else if (response.status === 'not_authorized') {
			    // 己登入未授權
				alert("己登入未授權")
			  } else {
				alert("facebook 登入失敗，請從新登入")
			}
		}, {
			scope : 'public_profile,email'
		});
	}