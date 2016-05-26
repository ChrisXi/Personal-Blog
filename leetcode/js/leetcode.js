
var param = "";
$(document).ready(function () {
 // $("#di").load("test.txt");
 	var url = window.location.search.substring(1); //get rid of "?" in querystring
    var qArray = url.split('&'); //get key-value pairs
    for (var i = 0; i < qArray.length; i++) 
    {
        var pArr = qArray[i].split('='); //split key and value
        if (pArr[0] == "name") 
        	param = pArr[1];
    }

 	var dir = "code/"+param+".java";
 	$.ajax({url: dir, success: function(result){
		var res = result.replace(/</g, "&lt;");
		res = res.replace(/>/g, "&gt;");
		$("#code").html(res);
		// alert(res);
    }});

});

window.onload = function() {
    var aCodes = document.getElementsByTagName('pre');
	
    for (var i=0; i < aCodes.length; i++) {
        hljs.highlightBlock(aCodes[i]);
    }
};

var display = false;
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
		var dir = "code/"+param+".java";
	 	$.ajax({url: dir, success: function(result){
			var res = result.replace(/</g, "&lt;");
			res = res.replace(/>/g, "&gt;");
			$("#code").html(res);
			// alert(res);
	    }});
		display = false;
	}
});


