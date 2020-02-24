function updateNumber() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "greeting/ajax-number");
    xhr.send();
    xhr.onload = function() {
    if (xhr.status == 200) {
            document.getElementById("ajaxNumber").outerHTML = xhr.responseText;
        }
    }
}
