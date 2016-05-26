
var param1 = "";
var param2 = "";
$(document).ready(function () {
 // $("#di").load("test.txt");
 	var url = window.location.search.substring(1); //get rid of "?" in querystring
    var qArray = url.split('&'); //get key-value pairs
    for (var i = 0; i < qArray.length; i++) 
    {
        var pArr = qArray[i].split('='); //split key and value
        if (pArr[0] == "name") 
        	param1 = pArr[1];
        if (pArr[0] == "href")
        	param2 = pArr[1];
    }

    // alert(param2);

 	var dir = "code/"+param1+".java";
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
$('#highlight').click(function() {
	if(display == false) {
		$('#highlight').text('Cancel');
		var aCodes = document.getElementsByTagName('pre');
	
	    for (var i=0; i < aCodes.length; i++) {
	        hljs.highlightBlock(aCodes[i]);
	    }
		display = true;
	} else {
		$('#highlight').text('Highlight');
		var dir = "code/"+param1+".java";
	 	$.ajax({url: dir, success: function(result){
			var res = result.replace(/</g, "&lt;");
			res = res.replace(/>/g, "&gt;");
			$("#code").html(res);
			// alert(res);
	    }});
		display = false;
	}
});

$('#practice').click(function() {
	var win = window.open(param2, '_blank');
});


