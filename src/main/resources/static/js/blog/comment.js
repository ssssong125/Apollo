$(document).ready(function () {
    getCommList();
})

function insertComm(){

    alert("작동하냐?")
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

// 해당 댓글 번호 가져오기
function selectComm(commNo) {

    $.ajax({
        url : "/blog/selectComm",
        data : {
            "commNo" : commNo,
        },
        type : "get",
        success : function(result) {
            alert("이건 되나?")
            let $td = $("<td colspan='3'>");
            let $textarea= "<textarea rows='3' cols='55' placeholder='내용을 작성하세요' name='commContent' id='commContent"+commNo+"' required='required'>"
                +result.rContents+"</textarea>"
            let apTd = "<td><button onclick='modifyComm("+commNo+")'>수정하기</button> "
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

function modifyComm(commNo){
    alert("여기로 넘오 오나?")
    let commContent = $('#commContent'+commNo).val();
    $.ajax({
        url : "/blog/modifyComm",
        data : {
            "commContent" : commContent,
            "commNo" : commNo
        },
        type : "post",
        success : function(result) {
            if (result === "success") {
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

//삭제
function delComment(commNo) {
    console.log()
    $.ajax({
        type: "POST",
        url: "/blog/commDelete",
        data: {commNo: commNo},
        success: function (response) {
            alert(response["msg"])
            window.location.reload()
        }
    }); // $.ajax
}


function getCommList() {
    alert("어디까지 되냐?")
    let commNo = $("#commNo").val();
    let blogNo = $("#blogNo").val();
    $.ajaxSetup({
        url: '/blog/commList',
        type: "get",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    });
    $.ajax({
        async: false,
        data:
            {
                "blogNo" : blogNo
            }
    })
        .done(function (result) { // 수행할 동작

            if (result === "success") {
                alert("등록성공" + commNo)
            }
            let $tableBody = $('#rtb tbody');
            $tableBody.html(''); //tbody를 초기화 시켜야 댓글 목록의 중첩을 막을수 있음 아니면 등록할떄마다 append로 이어짐
            $('#rCount').text("댓글 (" + result.length + ")")

            console.log(result);
            for (let i in result) {
                let $tr = $("<tr>");
                let $commWriter = $("<td width='100'>").text(
                    result[i].commWriter);
                let $commContent = $("<td>").text(
                    result[i].commContent);
                let $commDate = $("<td width='100'>").text(
                    result[i].commDate);
                let $btnArea = $("<td width='80'>")
                    .append(
                        "<button onclick='selectComm("+result[i].commNo+")'>수정</button>").append(
                        "<a href='javascript:void(0);' class='btn btn-sm btn-outline-secondary' onclick='delComment("+result[i].commNo+")'>삭제</a>");

                $tr.append($commWriter);
                $tr.append($commContent);
                $tr.append($commDate);
                $tr.append($btnArea);
                $tableBody.append($tr);
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