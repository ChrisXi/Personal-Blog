var display = false;
window.onload = function() {
    var aCodes = document.getElementsByTagName('pre');
	
    for (var i=0; i < aCodes.length; i++) {
        hljs.highlightBlock(aCodes[i]);
    }
};

$(document).ready(function () {
 // $("#di").load("test.txt");
 // $("#div1").load("test.txt");
 	$.ajax({url: "code/349.java", success: function(result){
		var res = result.replace(/</g, "&lt;");
		res = res.replace(/>/g, "&gt;");
		$("#code").html(res);
		// alert(res);
    }});
});



$('#btn').click(function() {
	if(display == false) {
		$('#btn').text('Cancel');
		var aCodes = document.getElementsByTagName('pre');
	
	    for (var i=0; i < aCodes.length; i++) {
	        hljs.highlightBlock(aCodes[i]);
	    }
		display = true;
	} else {
		$('#btn').text('Highlight');
		$.ajax({url: "code/349.java", success: function(result){
			var res = result.replace(/</g, "&lt;");
			res = res.replace(/>/g, "&gt;");
			$("#code").html(res);
			// alert(res);
	    }});
		display = false;
	}
});
