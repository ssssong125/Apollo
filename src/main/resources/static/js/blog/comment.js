alert("작동?")
$(function(){
    selectReplyList();

    $("#addReply").click(function(){
        let bno = "${question.boardNo}";

        if($("#replyContent").val().trim().length != 0){

            $.ajax({
                url:"rinsertBoard",
                type:"post",
                data:{replyContent:$("#replyContent").val(),
                    refBoardNo:bno,
                    replyWriter:"${loginUser.userId}"},
                success:function(result){
                    if(result > 0){
                        $("#replyContent").val("");
                        selectReplyList();

                    }else{
                        alert("댓글등록실패");
                    }
                },error:function(){
                    console.log("댓글 작성 ajax 통신 실패");
                }
            });

        }else{
            alert("댓글등록하셈");
        }

    });
});

function selectReplyList(){
    alert("되는건가?")
    let bno = "${question.boardNo}";
    $.ajax({
        url:"rlistBoard",
        data:{bno:bno},
        type:"get",
        done:function(list){
            $("#rcount").text(list.length);

            let value="";
            $.each(list, function(i, obj){

                value += "<th>" + obj.replyWriter + "</th>" +
                    "<td>" + obj.replyContent + "</td>" +
                    "<td>" + obj.createDate + "</td>" +
                    "</tr>";
            });
            $("#replyArea tbody").html(value);
        },fail:function(){
            console.log("댓글 리스트조회용 ajax 통신 실패");
        }
    });
}