<!DOCTYPE html>
<html>
<body>

<p id="demo"></p>

<script>
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        myFunction(this);
    }
};
xhttp.open("GET", "biblioteka.xml", true);
xhttp.send();

function myFunction(xml) {
    var x, i, xLen, newComment, xmlDoc, txt;
    xmlDoc = xml.responseXML;
    txt = "";
    x = xmlDoc.getElementsByTagName("ksiazka");
    xLen = x.length
    for (i = 0; i < xLen; i++) { 
        newComment = xmlDoc.createComment("Dostepna");
        x[i].appendChild(newComment);
    }
    for (i = 0; i < xLen; i++) { 
        txt += x[i].getElementsByTagName("tytul")[0].childNodes[0].nodeValue + 
        " - " + x[i].lastChild.nodeValue + "<br>";
    }
    document.getElementById("demo").innerHTML = txt; 
}
</script>

</body>
</html>
