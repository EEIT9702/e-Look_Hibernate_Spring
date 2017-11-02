<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><jsp:useBean id="SYSTEM" class="init.GlobalService" scope="application" />
<link rel="Short Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<title>結訓倒數 Timer</title>
<style>
body {
  display: flex;
  align-items: center;
  min-height: 100vh;
  text-align: center;
  font-family: helvetica;
  text-transform: uppercase;
  background-image: linear-gradient(
     165deg,  
     rgba(194, 233, 221, 0.5) 3%, 
     rgba(104, 119, 132, 0.5) 100%);
 } 

.countdown {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  width: 75%;
  max-width: 20rem;
  margin: 0 auto;
}

.countdown__item {
  display: flex;
  flex-direction: column;
  flex: 0 1 auto;
  min-width: 31%;
  margin-bottom: 1rem;

/* Instead of a modifier one could use a pseudo-class: */
/*    &:first-child { */
/*      width: 100%; */
/*    } */
  
/*    &:not(:first-child) { */
/*      flex: 1; */
/*    } */
}

.countdown__item--large {
  flex: auto;
  width: 100%;
  font-size: 2.75em;
}

.countdown__timer {
  padding: .25em;
  background-color: white;
  border: 1px solid black;
  border-radius: 3px;
  font-weight: bold;
  font-size: 2em;
}

.countdown__label {
  font-size: 1em;
  padding-top: .40em;
  
  .countdown__item--large & {
    &:before,
    &:after {
      content: '';
      display: block;
      height: 1px;
      background-image: linear-gradient(
        left,
        rgba(0, 0, 0, 0), 
        rgba(0, 0, 0, .4),
        rgba(0, 0, 0, 0));
    }

  }
}
</style>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function () {
	const countdown = new Date("November 17, 2017");

	function getRemainingTime(endtime) {
	  const milliseconds = Date.parse(endtime) - Date.parse(new Date());
	  const seconds = Math.floor( (milliseconds/1000) % 60 );
	  const minutes = Math.floor( (milliseconds/1000/60) % 60 );
	  const hours = Math.floor( (milliseconds/(1000*60*60)) % 24 );
	  const days = Math.floor( milliseconds/(1000*60*60*24) );

	  return {
	    'total': milliseconds,
	    'seconds': seconds,
	    'minutes': minutes,
	    'hours': hours,
	    'days': days,
	  };
	}
	  
	function initClock(id, endtime) {
	  const counter = document.getElementById(id);
	  const daysItem = counter.querySelector('.daysE');
	  const hoursItem = counter.querySelector('.hoursE');
	  const minutesItem = counter.querySelector('.minutsE');
	  const secondsItem = counter.querySelector('.secondsE');

	  function updateClock() {
	    const time = getRemainingTime(endtime);

	    daysItem.innerHTML = time.days;
	    hoursItem.innerHTML = ('0' + time.hours).slice(-2);
	    minutesItem.innerHTML = ('0' + time.minutes).slice(-2);
	    secondsItem.innerHTML = ('0' + time.seconds).slice(-2);

	    if (time.total <= 0) {
	      clearInterval(timeinterval);
	    }
	  }

	  updateClock();
	  const timeinterval = setInterval(updateClock, 1000);
	}

	initClock('js-countdown', countdown);
});

</script>
</head>
<body>

  <div class="countdown" id="js-countdown">
    <div style="margin:0 auto">
  	  <h1 style="text-align:center">結訓倒數</h1>
    </div>
    <div class="countdown__item countdown__item--large">
      <div class="countdown__timer daysE" aria-labelledby="day-countdown">
        
      </div>
      
      <div class="countdown__label" id="day-countdown">Days</div>
    </div>
    
    <div class="countdown__item">
      <div class="countdown__timer hoursE" aria-labelledby="hour-countdown">
        
      </div>
      
      <div class="countdown__label" id="hour-countdown">Hours</div>
    </div>
    
    <div class="countdown__item">
      <div class="countdown__timer minutsE" aria-labelledby="minute-countdown">
        
      </div>
      
      <div class="countdown__label" id="minute-countdown">Minutes</div>
    </div>
    
    <div class="countdown__item">
      <div class="countdown__timer secondsE" aria-labelledby="second-countdown">
        
      </div>
      
      <div class="countdown__label" id="second-countdown">Seconds</div>
    </div>
  </div>
</body>
</html>