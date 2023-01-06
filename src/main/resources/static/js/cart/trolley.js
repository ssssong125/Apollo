// trolley
function updateQty(cartNo, count) {

    // let params = {
    //     cartNo : cartNo,
    //     count : count
    // }

    $.ajaxSetup({
        // url: 'cart/trolley',
        url: 'trolley',
        // global: false,
        type: "POST"
    });

    $.ajax({
        // url : 'cart/trolley',   // 요청할 서버url
        // url : "trolley",   // 요청할 서버url
        // method : 'POST',
        // method : "GET",
        data:
            {
                cartNo : cartNo,
                count : count
            },
        // dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
        // type : 'POST',           // 타입 (get, post, put 등등)
        // async : true,            // 비동기화 여부 (default : true)
        // headers : {              // Http header
        //     "Content-Type" : "application/json",
        //     "X-HTTP-Method-Override" : "POST"
        // },
        // data : JSON.stringify({  // 보낼 데이터 (Object , String, Array)
        //     "no" : no,
        //     "name" : name,
        //     "nick" : nick
        // }),
        // data: params,
    })
        .done(function (result) {
            alert("성공")
            // 수행할 동작
        })
        .fail(function(jqXHR) {
            alert("실패")
        })
        // .always(function() {
        //     alert("항상");
        // })
}
