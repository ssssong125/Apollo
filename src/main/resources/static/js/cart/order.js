// 인풋칸 값있으면 흰색 밑줄
$(function (){
    $(".text-input").on('input', function (){
    // $(".text-input").blur(function (){
        // if ($(".text-input").val()=='') {
        //     alert("값이 입력되지않았다? a")
        //     // $(`#${inputId}`).attr("border", "solid 1px red")
        //     // $(".text-input").attr("border", "solid 1px red")
        // }
        // else {
        //     alert("값이 입력됐다 b")
        //     // $(`#${inputId}`).attr("border", "solid 1px red")
        //     // $(".text-input").attr("border", "solid 1px red")
        // }
        if ($.isEmptyObject($(".text-input"))) {
            alert("값이 비었다 c")
            // $(".text-input").css("border", "solid 1px red")
            // alert($("#name").val())
        }
        else {
            alert("값이 있다 d")
            // $(".text-input").attr("border", "solid 1px red")
            document.getElementById("comment").innerHTML += "text.val"+$("name").text().val();
            document.getElementById("comment").innerHTML += "val"+$("name").val();
            document.getElementById("comment").innerHTML += "text"+$("name").text();
            // $("#comment").text($("#name").val())
            // $("#comment").text($("#name").text())
            // $("#comment").text($("#name").textContent)
            // $("#comment").text($("#name").val())
            // $("#comment").text($("#name").val())

            // alert("이름"+$("#name").val())
            // alert("이름"+$("#name").text())
            // alert("이름"+$("#name").textContent)
            // alert(document.getElementById("receiverName").text())
            // alert(document.getElementById("receiverName").val())
        }
    })
})