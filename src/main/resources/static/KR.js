var URL = "http://radar.lafox.net";
var detectedInvaders;

function getInvaders(){
    $.get(URL + "/api/getInvaders", function (data) {
        var n = 1;
        for(var name in data){
            $("#IN"+n).text(name);
            $("#I"+n).text(data[name]);
            n++;
        }
    });

}
function getMap() {
    $.get(URL + "/api/getMap", function (data) {
        $("#Nmap").text(data.id);
        $("#map").text(data.map);
    });
}
function searchForInvaters() {
    var formData = {
        "map":$("#map").text(),
        "id":$("#Nmap").text(),
        "invaters": [
            {
                "name": $("#IN1").text(),
                "map": $("#I1").text(),
                "acceptablePointsCount": $("#EV1").val()
            },
            {
                "name": $("#IN2").text(),
                "map": $("#I2").text(),
                "acceptablePointsCount": $("#EV2").val()
            },
            {
                "name": $("#IN3").text(),
                "map": $("#I3").text(),
                "acceptablePointsCount": $("#EV3").val()
            }
        ]
    };
    console.log(formData);
    $.postJSON("/api/searchForInvaters", formData,
       function (res) {
           console.log(res);
           detectedInvaders = res;
       }
    );

}

function cheak() {
    var invaders = [];
    $.each(detectedInvaders, function (index,value) {
        invaders.push({"name": value.name, "x": value.x, "y": value.y})
    });
    console.log(invaders);
    var formData = {
        "mapId": $("#Nmap").text(),
        "detectedInvaders": invaders
    };
    console.log(formData);

    $.postJSON(URL + "/api/checkMyResult", formData,
        function (result) { // onSuccess
            console.log(result);
            $("#res").text("Найдено "+result.percentOfSuccessDetection+"% захватчиков.");
});
}

$(document).ready(function () {
    $.postJSON = function (url, data, onSuccess, onError) {
        return jQuery.ajax({
            'type': 'POST',
            'url': url,
            'contentType': 'application/json',
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': onSuccess,
            'error': onError
        });
    };

});
