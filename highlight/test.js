window.onload = function() {
    var aCodes = document.getElementsByTagName('pre');
$("#di").load("test.txt");
        $("#div1").load("test.txt");
    alert("dddd");
    for (var i=0; i < aCodes.length; i++) {
        hljs.highlightBlock(aCodes[i]);
    }
    

    alert("asdf");
};
