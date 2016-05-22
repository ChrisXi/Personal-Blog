var release;
$(document).ready(function () {

  var trigger = $('#mousenose');
  release = false;
  trigger.click(function () {
    toggle();      
  });

  function toggle() {
    if (release == false) {	
		window.top.$('html, body').animate({scrollTop: 550}, 500);
		release = true;
	} else {
		window.top.$('html, body').animate({scrollTop: 55}, 500);
		release = false;
	}
  }
});

$('#mousenose').hover(function() {

	if (release == false) {	
		$('#sen1').css('display','block');
	} else {
		$('#sen2').css('display','block');
	}

}, function() {
	$('#sen1').css('display','none');
	$('#sen2').css('display','none');
});

