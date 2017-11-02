/**
 * 
 */
var auth2; // The Sign-In object.
var googleUser; // The current user.
var appStart = function() {
	  gapi.load('auth2', initSigninV2);
	};
	
	var initSigninV2 = function() {
	  auth2 = gapi.auth2.init({
	      client_id:'490965683057-mrrjeqqgg3inltis80brpe9ep9jei34f.apps.googleusercontent.com',
	      scope: 'profile'
	  });
	  //auth2.isSignedIn.listen(signinChanged);//狀態改變時
	  // Listen for changes to current user.
	  //auth2.currentUser.listen(userChanged);
	  attachSignin(document.getElementById('google'));
	}
	  function attachSignin(element) {
		  //  console.log(element.id);
		    auth2.attachClickHandler(element);
		  
		  }

 //	var signinChanged = function (val) {
// 		  console.log('Signin state changed to ', val);
 		//myGoogleLogin();
//		};
//		var userChanged = function (user) {
		  //console.log(auth2.isSignedIn.get());
			
//		}
		function myGoogleLogin() {
			auth2.currentUser.listen(function (user){
				googleUser=user;
				 //auth2.isSignedIn.get()
						var profile = googleUser.getBasicProfile();
//				  	  	console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
//				  	  	console.log('Name: ' + profile.getName());
//				  	  	console.log('Image URL: ' + profile.getImageUrl());
//				  	  	console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
					       var name=profile.getName();
					       var email=profile.getEmail();
					       var picture=profile.getImageUrl();
					       var url="login.login";
					       var xmlHttp=new XMLHttpRequest();
					       xmlHttp.open("POST",url,false);
					       xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					       xmlHttp.send("loginstatus=google&mName="+name+"&email="+email+"&mPhoto="+picture);
					      document.location.href=location.href;
				  	  	
			})
		}
		function signOut() {
		    var auth2 = gapi.auth2.getAuthInstance();
		    auth2.signOut().then(function () {
		      console.log('User signed out.');
		    });
		  }