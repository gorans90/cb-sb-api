/**
 * Created by stephan on 20.03.16.
 */

$(function () {
    var TOKEN_KEY = "jwtToken"
    var $notLoggedIn = $("#notLoggedIn");
    var $loggedIn = $("#loggedIn").hide();
    var $loggedInBody = $("#loggedInBody");
    var $login = $("#login");
    var $userInfo = $("#userInfo").hide();


    function getJwtToken() {
        return localStorage.getItem(TOKEN_KEY);
    }

    function setJwtToken(token) {
        localStorage.setItem(TOKEN_KEY, token);
    }

    function removeJwtToken() {
        localStorage.removeItem(TOKEN_KEY);
    }

    function doLogin(loginData) {
        $.ajax({
                   url: "/auth",
                   type: "POST",
                   data: JSON.stringify(loginData),
                   contentType: "application/json; charset=utf-8",
                   dataType: "json",
                   success: function (data, textStatus, jqXHR) {
                       setJwtToken(data.token);
                       $login.hide();
                       $notLoggedIn.hide();
                       showTokenInformation();
                       $userInfo.show();
                   },
                   error: function (jqXHR, textStatus, errorThrown) {
                       if (jqXHR.status === 401) {
                           alert(jqXHR.responseJSON.exception);
                       } else {
                           alert("An unexpected error occured");
                       }
                   }
               });
    }

    function doLogout() {
        removeJwtToken();
        $login.show();
        $loggedIn.hide();
        $loggedInBody.empty();
        $notLoggedIn.show();
    }

    function createAuthorizationTokenHeader() {
        var token = getJwtToken();
        if (token) {
            return {"Authorization": token};
        } else {
            return {};
        }
    }

    function showTokenInformation() {
        var jwtToken = getJwtToken();
        var decodedToken = jwt_decode(jwtToken);
        console.log(decodedToken);

        $loggedInBody.append($("<h4>").text("Token"));
        $loggedInBody.append($("<div>").text(jwtToken).css("word-break", "break-all"));
        $loggedInBody.append($("<h4>").text("Token claims"));

        var $table = $("<table>")
            .addClass("table table-striped");
        appendKeyValue($table, "sub", decodedToken.sub);
        appendKeyValue($table, "audience", decodedToken.audience);
        appendKeyValue($table, "created", new Date(decodedToken.created).toString());
        appendKeyValue($table, "exp", decodedToken.exp);

        $loggedInBody.append($table);

        $loggedIn.show();
    }

    function appendKeyValue($table, key, value) {
        var $row = $("<tr>")
            .append($("<td>").text(key))
            .append($("<td>").text(value));
        $table.append($row);
    }

    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            username: $form.find('input[name="username"]').val(),
            password: $form.find('input[name="password"]').val()
        };

        console.log("test json stringify");
        console.log(JSON.stringify(formData));
        doLogin(formData);
    });

    $("#logoutButton").click(doLogout);

    $loggedIn.click(function () {
        $loggedIn
            .toggleClass("text-hidden")
            .toggleClass("text-shown");
    });

    // INITIAL CALLS =============================================================
    if (getJwtToken()) {
        $login.hide();
        $notLoggedIn.hide();
        showTokenInformation();
    }
});