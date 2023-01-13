function listReply2(){
    $.ajax({
        type: "get",
        //contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
        url: "${path}/reply/listJson.do?bno=${dto.bno}",
        success: function(result){
            console.log(result);
            var output = "<table>";
            for(var i in result){
                output += "<tr>";
                output += "<td>"+result[i].userName;
                output += "("+changeDate(result[i].regdate)+")<br>";
                output += result[i].replytext+"</td>";
                output += "<tr>";
            }
            output += "</table>";
            $("#listReply").html(output);
        }
    });
}