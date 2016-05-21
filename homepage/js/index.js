var release = false;

$( "#mousenose" ).click(function() {
	// alert("dd");
	if (release == false) {
		window.top.$('html, body').animate({scrollTop: 550}, 500);
	} else {
		window.top.$('html, body').animate({scrollTop: 55}, 500);
	}
	// $('#dropDownSpan', window.parent.document).css('visibility', 'visible');
	// $('html, body', window.parent.document).animate({scrollTop: 550}, 500);
	// $('#btn', window.parent.document).css("background-color", "yellow");
	// window.parent.$("#frame").css("background-color", "yellow");
});