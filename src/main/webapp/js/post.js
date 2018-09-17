function getData() {
    var xhr = new XMLHttpRequest();

    var body = 'surname=' + encodeURIComponent(surname) +
        '&firstName=' + encodeURIComponent(firstName) +
        '&lastName=' + encodeURIComponent(lastName) +
        '&birthday=' + encodeURIComponent(birthday) +
        '&post=' + encodeURIComponent(post);

    xhr.open("POST", '/submit', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(body);
}

