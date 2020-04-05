<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            crossorigin="anonymous"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="></script>
    <title>Upload</title>
    <script>
        function sendFile() {
            let formData = new FormData();
            let files = ($('#file'))[0]['files'];
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    alert(response);
                    let fileUrl = 'http://localhost:8080/files/' + response;
                    $('#photo').append('<img src = "' + fileUrl + '"/>');
                })
                .fail(function () {
                    alert('Error. Try again')
                });
        }
    </script>
</head>
<body>
<div>
    <input type="file" id="file" name="file" placeholder="Имя файла..."/>
    <button onclick="sendFile()">
        load file
    </button>
    <input type="hidden" id="file_hidden">
    <div class="filename"></div>
</div>
</body>
</html>