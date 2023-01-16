$(document).ready(function () {
    getReplyList();
})

function insertReply(){

    let replyContent = $("#replyContent").val(),
        boardNo = $("#boardNo").val();
    $.ajaxSetup({
        url: '/question/detail/replyInsert',
        type: "get",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    });
    $.ajax({
        data:
            {
                replyContent : replyContent,
                boardNo : boardNo
            }
    })
        .done(function (result) { // 수행할 동작

            if (result === "success") {
                alert("등록성공")
            }
            $('#replyContent').val('') //댓글 등록시 댓글 등록창 초기화
            getReplyList(); //등록후 댓글 목록 불러오기 함수 실행
            //DOM 조작 함수호츨 등 가능
        })
        .fail(function(result) { // 실패시
            if(result ==="error"){
                alert("등록 실패")
            }
        })
        .always(function() { // 항상 동작

        })
}

// function modifyComm(boardNo) {
//     $.ajax({
//         url : "/blog/moidfyComm",
//         data : {
//             "replyNo" : replyNo,
//         },
//         type : "get",
//         success : function(result) {
//
//             let $td = $("<td colspan='3'>");
//             let $textarea= "<textarea rows='3' cols='55' placeholder='내용을 작성하세요' name='commContent' id='commContent"+replyNo+"' required='required'>"
//                 +result.rContents+"</textarea>"
//             let apTd = "<td><button onclick='modifyDo("+replyNo+")'>수정하기</button> "
//             $td.html($textarea)
//
//             console.log(result.rContents);
//             $('#'+replyNo).html(''); //현재 댓글 출력창의 tr부분을 비운다
//             $('#'+replyNo).append($td).append(apTd); //비워진 tr에 td와 apTd를 넣어 수정창으로 바꾼다
//         },
//         error : function() {
//             alert("등록 실패")
//
//         }
//     })
// }
//
// function modifyDo(replyNo){
//     let commContent = $('#commContent'+replyNo).val();
//     $.ajax({
//         url : "/blog/doModify.do",
//         data : {
//             "replyContent" : replyContent,
//             "replyNo" : replyNo
//         },
//         type : "post",
//         success : function(result) {
//             if (result == "success") {
//                 alert("등록성공")
//             }
//
//             getReplyList(); //등록후 댓글 목록 불러오기 함수 실행
//             //DOM 조작 함수호츨 등 가능
//         },
//         error : function() {
//             alert("등록 실패")
//
//         }
//     })
// }

//삭제
function delReply(replyNo) {
    console.log()

    $.ajax({
        url: "/question/detail/replyDelete/"+replyNo,
        type: "post",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    })
        .done(function (result) { // 수행할 동작

            getReplyList(); //등록후 댓글 목록 불러오기 함수 실행
            // alert("여기 테스트")
            // window.location.href= "/blog/commDelete/"+commNo;
            //DOM 조작 함수호츨 등 가능
        })
        .fail(function(result) { // 실패시
            if(result ==="error"){
                alert("등록 실패")
            }
        })
        .always(function() { // 항상 동작

        })
}




function getReplyList() {
    let replyNo = $("#replyNo").val();
    let boardNo = $("#boardNo").val();
    let replyDate = $("#replyDate").val();
    $.ajaxSetup({
        url: '/question/detail/replyList',
        type: "get",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    });
    $.ajax({
        async: false,
        data:
            {
                "boardNo" : boardNo
            }
    })
        .done(function (result) { // 수행할 동작
            if (result === "success") {
                alert("등록성공" + replyNo)
            }
            let $tableBody = $('#rtb tbody');
            $tableBody.html(''); //tbody를 초기화 시켜야 댓글 목록의 중첩을 막을수 있음 아니면 등록할때마다 append로 이어짐
            $('#rCount').text("댓글 (" + result.length + ")")

            if (true) {
                console.log(result);
                for (let i in result) {
                    let $tr = $("<tr>");
                    let $replyWriter = $("<td width='100'>").text(
                        result[i].replyWriter);
                    let $replyContent = $("<td>").text(
                        result[i].replyContent);
                    let $replyDate = $("<td width='100'>").text(
                        result[i].replyDate);
                    let $btnArea = $("<td width='80'>")
                        // .append("<a href=javascript:void(0);' onclick='modifyReply()'>수정</a>")
                        .append("<a href='javascript:void(0);' class='btn btn-sm btn-outline-secondary' onclick='delReply("+result[i].replyNo+")'>삭제</a>");

                    $tr.append($replyWriter);
                    $tr.append($replyContent);
                    $tr.append($replyDate);
                    $tr.append($btnArea);
                    $tableBody.append($tr);
                }
            }
        })
        .fail(function(request, error) { // 실패시
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            alert("등록 실패")
        })
        .always(function() { // 항상 동작
            // alert("항상");
        })
}