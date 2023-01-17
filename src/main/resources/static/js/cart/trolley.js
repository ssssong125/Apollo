/*csrf 토큰 정보*/
const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");
// const userId = $("#userId").val();

/*페이지 로드될때 합계 출력*/
$(document).ready(function () {

    sum(size);

    checkMax();

    $(".checkStatus").change(function (){

        // alert($(this).attr("id"))
        // alert($(this).val())
        let cartNo = $(this).val();
        let check = 'A';

        // alert(cartNo);

        if($(this).is(":checked")){
            // alert("체크됨")
            // alert($(this).val())
            // alert($(this).attr("id"))
            check = 'Y';
            // updateCheckStatus(cartNo, check);
        } else {
            // alert("체크해제")
            check = 'N';
        }

        updateCheckStatus(cartNo, check);

        sum(size);
    })
})
/*품목 체크 확인*/
function checkForm() {

    if($("#checkedSize").val() > 0){

        window.location.href='order'
        return true;
    } else {

        alert("선택된 상품이 없습니다.")
        return false;
    }
}
/*체크 여부 수정*/
function updateCheckStatus(cartNo, check) {

    /*ajax 설정*/
    $.ajaxSetup({
        url: 'trolley-check', // 요청할 서버url
        type: "POST" // 타입 (get, post, put 등등)
        // global: false, // 동시에 실행 x, 비동기화 여부 (default : true)
    });

    $.ajax({
        data: // 보낼 데이터 (Object , String, Array)
            {
                cartNo : cartNo,
                check : check
            }
        // , beforeSend : function(xhr) {
        //     xhr.setRequestHeader(header, token)
        // }

        // , dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
        // contentType: 'application/json'
        // headers : {              // Http header
        //     "Content-Type" : "application/json",
        //     "X-HTTP-Method-Override" : "POST"
        // },
    })
    .done(function (result) { // 수행할 동작
        // alert("성공")
        // return location.href = "trolley"
    })
    .fail(function(jqXHR) { // 실패시
        // alert("실패")
        // return location.href = "trolley"
    })
    .always(function() { // 항상 동작
        // alert("항상");
        let cSize = 0;

        for (let i = 1; i <= size; i++) {
            if($("#checkBox"+i).is(':checked')) {
                cSize += 1;
            }
        }

        $("#checkedSize").val(cSize)
    })

}
/*해당 상품 장바구니에서 삭제*/
function deleteProductInCart(cartNo) {

    // alert("작동")
    const count = 0;

    /*ajax 설정*/
    $.ajaxSetup({
        // url: 'trolley', // 요청할 서버url
        url: 'trolley-count', // 요청할 서버url
        type: "POST" // 타입 (get, post, put 등등)
        // global: false, // 동시에 실행 x, 비동기화 여부 (default : true)
    });

    $.ajax({
        data: // 보낼 데이터 (Object , String, Array)
            {
                cartNo : cartNo,
                count : count
            }
        // , beforeSend : function(xhr) {
        //     xhr.setRequestHeader(header, token)
        // }

        // ,
        // dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
        // contentType: 'application/json'
        // headers : {              // Http header
        //     "Content-Type" : "application/json",
        //     "X-HTTP-Method-Override" : "POST"
        // },
    })
    .done(function (result) { // 수행할 동작
        // alert("성공")
        return location.href = "trolley"
    })
    .fail(function(jqXHR) { // 실패시
        // alert("실패")
        return location.href = "trolley"
    })
    .always(function() { // 항상 동작
        // alert("항상");
    })
}
/*상품 구매수량 조절*/
function updateQty(cartNo, code, max) {

    const count = $('#productQty'+code).val();

    if (count%1 != 0 || count < 1) {
        alert("다시 입력해주세요.")
        $(this).focus()
        return false;
    } else if(count > max) {
        alert("재고부족으로 인해 최대 "+max+"개 까지만 주문 가능합니다.")
        return false;
    }

    sum(size);

    $.ajaxSetup({
        // url: 'trolley', // 요청할 서버url
        url: 'trolley-count', // 요청할 서버url
        type: "POST" // 타입 (get, post, put 등등)
        // global: false, // 동시에 실행 x, 비동기화 여부 (default : true)
    });

    $.ajax({
        data: // 보낼 데이터 (Object , String, Array)
            {
                cartNo : cartNo,
                count : count
            }
        // , beforeSend : function(xhr) {
        //     xhr.setRequestHeader(header, token)
        // }

        // dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
        // headers : {              // Http header
        //     "Content-Type" : "application/json",
        //     "X-HTTP-Method-Override" : "POST"
        // },
    })
        .done(function (result) { // 수행할 동작
            // return location.href = "trolley"
        })
        .fail(function(jqXHR) { // 실패시
            // alert("실패!")
        })
    // .always(function() { // 항상 동작
    //     alert("작동");
    // })
}
/*합계 계산 및 출력*/
function sum(size) {

    let orderTotal = 0;

    for (let i = 1; i <= size; i++) {

        let check = 0;

        if($("#checkBox"+i).is(':checked')) {
            check = 1;
        }

        orderTotal += $("#hiddenPrice" + i).val() * $("#productQty" + i).val() * check
    }

    $("#orderTotal").text(orderTotal+"$")

    let subTotal = orderTotal - $("#point").val()

    if (subTotal < 0) {
        subTotal = 0
    }

    $("#userPoint").text(point+"$")
    $("#subTotal").text(subTotal+"$")

    $("#totalPrice").val(subTotal)
}
function checkMax() {

    for (let i = 1; i <= size; i++) {

        if ($("#productQty"+i).val() > $("#productMaxCount"+i).val()) {

            $("#productQty"+i).val($("#productMaxCount"+i).val())
            updateQty($("#getCartNo"+i).val(), i, $("#productMaxCount"+i).val())
        }
    }
}
// - $.get()  : GET 메소드 요청하고, 서버로부터 데이터 로딩
// - $.post() : POST 메소드 요청하고, 서버로부터 데이터 로딩
// - $.getJSON() : GET 메소드 요청하고, 서버로부터 JSON 형식의 데이터를 로딩
// - $.getScript() : GET 메소드 요청하고, 서버로부터 자바스크립트 파일을 로딩 후 실행
// - $.load() : 서버로부터 데이터를 선택 요소의 컨텐츠로 대체 로딩
