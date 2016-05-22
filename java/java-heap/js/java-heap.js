$('#e1').hover(function() {
	$('#sen1').css('display','block');
}, function() {
	$('#sen1').css('display','none');
});

$('#e2').hover(function() {
	$('#sen2').css('display','block');
}, function() {
	$('#sen2').css('display','none');
});

$('#e3').hover(function() {
	$('#sen3').css('display','block');
}, function() {
	$('#sen3').css('display','none');
});

$('#e4').hover(function() {
	$('#sen4').css('display','block');
}, function() {
	$('#sen4').css('display','none');
});

$('#e5').hover(function() {
	$('#sen5').css('display','block');
}, function() {
	$('#sen5').css('display','none');
});

var display = false;
$('#btn').click(function() {
	if(display == false) {
		$('#sen1').css('display','block');
		$('#sen2').css('display','block');
		$('#sen3').css('display','block');
		$('#sen4').css('display','block');
		$('#sen5').css('display','block');
		$('#btn').text('Hide');
		display = true;
	} else {
		$('#sen1').css('display','none');
		$('#sen2').css('display','none');
		$('#sen3').css('display','none');
		$('#sen4').css('display','none');
		$('#sen5').css('display','none');
		$('#btn').text('Show');
		display = false;
	}
});



