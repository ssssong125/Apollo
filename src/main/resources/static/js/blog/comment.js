$(document).ready(function () {
    getCommList();
})

function insertComm(){

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

function modifyComm(blogNo) {
    $.ajax({
        url : "/blog/moidfyComm",
        data : {
            "commNo" : commNo,
        },
        type : "get",
        success : function(result) {

            let $td = $("<td colspan='3'>");
            let $textarea= "<textarea rows='3' cols='55' placeholder='내용을 작성하세요' name='commContent' id='commContent"+commNo+"' required='required'>"
                +result.rContents+"</textarea>"
            let apTd = "<td><button onclick='modifyDo("+commNo+")'>수정하기</button> "
            $td.html($textarea)

            console.log(result.rContents);
            $('#'+commNo).html(''); //현재 댓글 출력창의 tr부분을 비운다
            $('#'+commNo).append($td).append(apTd); //비워진 tr에 td와 apTd를 넣어 수정창으로 바꾼다
        },
        error : function() {
            alert("등록 실패")

        }
    })


}


function modifyDo(commNo){
    let commContent = $('#commContent'+commNo).val();
    $.ajax({
        url : "/blog/doModify.do",
        data : {
            "commContent" : commContent,
            "commNo" : commNo
        },
        type : "post",
        success : function(result) {
            if (result == "success") {
                alert("등록성공")
            }

            getReplyList(); //등록후 댓글 목록 불러오기 함수 실행
            //DOM 조작 함수호츨 등 가능
        },
        error : function() {
            alert("등록 실패")

        }
    })
}


function getCommList() {

    let blogNo = $("#blogNo").val();
    let commDate = $("#commDate").val();
    $.ajaxSetup({
        url: '/blog/commList',
        type: "get",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    });
    $.ajax({
        data:
            {
                blogNo : blogNo,
                commDate : commDate
            }
    })

        .done(function (result) { // 수행할 동작
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
                    let $commDate = $("<td width='200'>").text(
                        result[i].commDate);
                    let $btnArea = $("<td width='80'>").append(
                        "<a href='modifyComm(blogNo)'>수정</a>").append(
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