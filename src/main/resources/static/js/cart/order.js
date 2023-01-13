// 인풋칸 값있으면 밑줄 흰색으로 바꿔주는 함수
// 포커스가 아니어야 하고, 디폴트 뉴로 바꿔도 작동하게, 키입력이 끝났을때 = 블러
// $.func(submit())
// $(function (){
//     $(".text-input").change(function (){
//
//         if ($(this).val()=='') {
//             // alert("값이 입력되지않았다? a")
//         }
//         else {
//             // alert("값이 입력됐다 b")
//             // $(this).css("border-bottom", "solid 2px white")
//         }
//     })
// })

function formSubmit() {

    $("#receiverNameForm").val($("#receiverName").val())
    $("#receiverTelForm").val($("#receiverTel").val())
    $("#addressForm").val($("#sample5_address").val())
    $("#deliveryRequiresForm").val($("#deliveryRequires").val())

    return location.href = "redirect:payment";
}
