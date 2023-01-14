$(document).ready(function () {
    getCommList();
})

function insertComm(){
    alert ('작동하긴 하냐?')
    let commContent = $("#commContent").val(),
         blogNo = $("#blogNo").val();
    $.ajaxSetup({
        url: '/blog/commInsert',
        type: "get",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    });
    $.ajax({
        data:
            {
                commContent : commContent,
                blogNo : blogNo
            }
    })
        .done(function (result) { // 수행할 동작
            alert("작동하냐?")
            if (result === "success") {
                alert("등록성공")
            }
            $('#commContent').val('') //댓글 등록시 댓글 등록창 초기화
            getCommList(); //등록후 댓글 목록 불러오기 함수 실행
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

function getCommList() {
    alert("체크")
    let  blogNo = $("#blogNo").val();
    $.ajaxSetup({
        url: '/blog/commList',
        type: "get",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    });
    $.ajax({
        data:
            {
                blogNo : blogNo
            }
    })

        .done(function (result) { // 수행할 동작
            alert("여기까진 되냐?")
            if (result === "success") {
                alert("등록성공")
            }
            let $tableBody = $('#rtb tbody');
            $tableBody.html(''); //tbody를 초기화 시켜야 댓글 목록의 중첩을 막을수 있음 아니면 등록할떄마다 append로 이어짐
            $('#rCount').text("댓글 (" + result.length + ")")

            if (true) {
                console.log(result);
                for (let i in result) {
                    let $tr = $("<tr>");
                    let $commWriter = $("<td width='100'>").text(
                        result[i].commWriter);
                    let $commContent = $("<td>").text(
                        result[i].commContent);
                    let $commDate = $("<td width='100'>").text(
                        result[i].commDate);
                    let $btnArea = $("<td width='80'>").append(
                        "<a href='modifyreply(${board.boardNo})'>수정</a>").append(
                        "<a href='#'>삭제</a>");

                    $tr.append($commWriter);
                    $tr.append($commContent);
                    $tr.append($commDate);
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