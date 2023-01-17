$(document).ready(function () {
    getCommList();
})

function insertComm(){

    // alert("작동테스트?")
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

//
// function modifyComm(commNo,commContent){
//     alert("왜 안돼!!!")
//   let commentMod = "";
//   commentMod += '<div id="commNo' + commNo+'">';
//   commentMod += '<strong>';
//   commentMod += '댓글 내용 : &nbsp;&nbsp;&nbsp';
//   commentMod += '<textarea class="form-control" id=commContent">';
//   commentMod += commContent;
//   commentMod += '</textarea>';
//   commentMod += '<br/>';
//   commentMod += '<button class="btn btn-sm btn-outline-secondary"';
//   commentMod += 'onclick=updateBtn(' + commNo + ')"> 댓글작성 </button>';
//   commentMod += '<button type="button" class="btn btn-sm btn-outline-secondary" onClick="getCommList()">';
//   commentMod += '취소';
//   commentMod += '</button>';
//   commentMod += '</div>';
//   commentMod += '<br/>';
//
//   $('#commNo' + commNo).replaceWith(commentMod);
//   $('#commNo' + commNo + '#commContent').focus();
// }
//
// function updateBtn(commNo, commWriter){
//     alert("아 좀!")
//     let updateUrl = "/blog/commModify";
//     let commContent = $("#commContent").val();
//
//     $.ajax({
//         url: updateUrl + commNo + '/' + commContent,
//         type: "post",
//         dataType : "json",
//         contentType: "application/json; charset=utf-8",
//     })
//         .done(function (result) { // 수행할 동작
//
//             getCommList(); //등록후 댓글 목록 불러오기 함수 실행
//
//             //DOM 조작 함수호츨 등 가능
//         })
//         .fail(function(result) { // 실패시
//             if(result ==="error"){
//                 alert("등록 실패")
//             }
//         })
//         .always(function() { // 항상 동작
//
//         })
//
// }



//삭제
function delComment(commNo) {
    console.log()

    $.ajax({
        url: "/blog/commDelete/"+commNo,
        type: "post",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
    })
        .done(function (result) { // 수행할 동작

            getCommList(); //등록후 댓글 목록 불러오기 함수 실행
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


function getCommList() {

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
            $tableBody.html(''); //tbody를 초기화 시켜야 댓글 목록의 중첩을 막을수 있음 아니면 등록할때마다 append로 이어짐
            $('#rCount').text("댓글 (" + result.length + ")")

            console.log(result);
            for (let i in result) {
                let $tr = $("<tr>");
                let $commWriter = $("<td width='80'>").text(
                    result[i].commWriter);
                let $commContent = $("<td>").text(
                    result[i].commContent);
                let $commDate = $("<td width='200'>").text(
                    result[i].commDate);
                let $btnArea = $("<td width='120'>")
                    // .append("<a href='javascript:void(0);' class='btn btn-sm btn-outline-secondary' onclick='modifyComm("+ result[i].commNo +", " + result[i].commContent +")'>수정</a>")
                    .append("<a href='javascript:void(0);' class='btn btn-sm btn-outline-secondary' onclick='delComment("+result[i].commNo+")'>삭제</a>");



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