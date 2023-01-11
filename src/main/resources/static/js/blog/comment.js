function updateComment() {
const  commWriter = $("#commWriter").val(),
       content = $("#commentContent").val(),
       blogNo =  $("#blogNo").val()
    // $.ajaxSetup({
    //     url: "/view", // 요청할 서버url
    //     type: "POST" // 타입 (get, post, put 등등)
    //     // global: false, // 동시에 실행 x, 비동기화 여부 (default : true)
    // });

    $.ajax({
        url: "/question/view",
        type: "POST",
        data:
            {   commWriter: commWriter,
                content: content,
                blogNo: blogNo
            }
        // beforeSend : function(xhr) {
        //     xhr.setRequestHeader(header, token)
        // }
    })
        // .done(function (fragment) {
        //     $('#commentTable').replaceWith(fragment);
        // });
}