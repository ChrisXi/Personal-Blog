window.onload = function() {
    // var aCodes = document.getElementsByTagName('pre');
	
    // for (var i=0; i < aCodes.length; i++) {
    //     hljs.highlightBlock(aCodes[i]);
    // }
    // alert("asdf");
};

$(document).ready(function () {
	alert("bbb");
	$("#di").load("test.txt");
    $("#div1").load("test.txt");

    $("button").click(function(){
        var aCodes = document.getElementsByTagName('pre');
	
	    for (var i=0; i < aCodes.length; i++) {
	        hljs.highlightBlock(aCodes[i]);
	    }
	    alert("asdf");
    });
});