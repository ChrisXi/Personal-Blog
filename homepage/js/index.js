// var release = false;

$( "#mousenose" ).click(function() {
	// alert("dd");
	window.top.$('html, body').animate({scrollTop: 550}, 500);
	// if (release == false) {
	// 	alert("dd");
	// 	window.top.$('html, body').animate({scrollTop: 550}, 500);
	// 	release = true;
	// } else {
	// 	alert("dd2");
	// 	window.top.$('html, body').animate({scrollTop: 55}, 500);
	// 	release = false;
	// }
});
/*
$(document).ready(function () {

  var trigger = $('#mousenose');
  var release = false;
  trigger.click(function () {
    toggle();      
  });

  function toggle() {
  	window.top.$('html, body').animate({scrollTop: 550}, 500);
 //    if (release == false) {	
	// 	window.top.$('html, body').animate({scrollTop: 550}, 500);
	// 	release = true;
	// } else {
	// 	window.top.$('html, body').animate({scrollTop: 55}, 500);
	// 	release = false;
	// }
  }
});*/