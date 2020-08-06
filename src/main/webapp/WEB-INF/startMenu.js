$(document).ready(function() {

    $("#newgame").click(newGame);
    $("#joingame").click(joinGame);
    $("#rules").click(rules);

});

    function newGame(){

        // perform an ajax http get request
        $.ajax({
        url: 'www.google.com',
        async: true,
        success: test,
        error: errorCallback});
    }

    function test(){
        $("banner tr").re
    }

    function joinGame(){
        // perform an ajax http get request
        $.ajax({
        url: 'www.abola.pt',
        async: true,
        success: editcustomer,
        error: errorCallback});
    }

    function rules(){
        // perform an ajax http get request
        $.ajax({
        url: 'www.ojogo.pt',
        async: true,
        success: editcustomer,
        error: errorCallback});
    }
