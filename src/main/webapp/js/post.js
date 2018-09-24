function getData(str) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            document.location.href = "http://localhost:8080" + getUrl() + "/ecm/persons";
        }
    };

    xhr.open("POST", getUrl() + str, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    var obj = {};
    obj.id = encodeURIComponent(document.getElementById("id").value);
    obj.surname = encodeURIComponent(document.getElementById("surname").value);
    obj.firstName = encodeURIComponent(document.getElementById("firstName").value);
    obj.lastName = encodeURIComponent(document.getElementById("lastName").value);
    obj.birthday = encodeURIComponent(document.getElementById("birthday").value);
    obj.post = encodeURIComponent(document.getElementById("post").value);
    obj.photo = encodeURIComponent(document.getElementById("photo").value);

    var body = JSON.stringify(obj);
    xhr.send(body);

}

function getUrl() {
    return "/" + window.location.pathname.split("/")[1];
}

function back() {
    return  window.location.origin + "/" + window.location.pathname.split("/")[1] + "/ecm/persons";

}