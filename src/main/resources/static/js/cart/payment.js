/*csrf 토큰 정보*/
const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");

/*변수*/
// const size = $("#size").val();
// let productName = $("#productName").val();
// const buyerName = $("#buyerName").val();
// const amount = Number($("#amount").val());
// const buyerAddr = $("#buyerAddr").val();
// const buyerTel = $("#buyerTel").val();
// const email = $("#email").val();

// function check() {
//     // alert()
//     alert(size)
//     alert(productName)
//     alert(buyerName)
//     alert(amount)
//     alert(buyerAddr)
//     alert(buyerTel)
//     alert(email)
// }

/*토스 키*/
// var clientKey = 'test_ck_4Gv6LjeKD8ayzMd1KP08wYxAdXy1'
var clientKey = 'test_ck_4Gv6LjeKD8ayzMd1KP08wYxAdXy1'
var tossPayments = TossPayments(clientKey) // 클라이언트 키로 초기화하기

function kakaoPay() {

    if (size > 1) {
        productName += "외 " + size + "건"
    }

    $("#paymentMethod").val("KakaoPay");

    var IMP = window.IMP; // 생략가능
    IMP.init('imp27843145');
    // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    IMP.request_pay({
        pg: 'kakaopay', // version 1.1.0부터 지원.
        /*
            'kakao':카카오페이,
            html5_inicis':이니시스(웹표준결제)
                'nice':나이스페이
                'jtnet':제이티넷
                'uplus':LG유플러스
                'danal':다날
                'payco':페이코
                'syrup':시럽페이
                'paypal':페이팔
            */
        pay_method: 'card', // 생략가능
        /*
            'samsung':삼성페이,
            'card':신용카드,
            'trans':실시간계좌이체,
            'vbank':가상계좌,
            'phone':휴대폰소액결제
        */
        merchant_uid: 'merchant_' + new Date().getTime(), // 주문번호
        /*
            merchant_uid에 경우
            https://docs.iamport.kr/implementation/payment
            위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
            참고하세요.
            나중에 포스팅 해볼게요.
         */
        name: productName, //결제창에서 보여질 이름
        amount: amount, //가격
        buyer_email: email,
        buyer_name: buyerName,
        buyer_tel: buyerTel,
        buyer_addr: buyerAddr,
        buyer_postcode: '123-456'
        // , m_redirect_url: 'https://www.yourdomain.com/payments/complete'
        /*
            모바일 결제시,
            결제가 끝나고 랜딩되는 URL을 지정
            (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
            */
    }, function (rsp) { // callback 로직
        console.log(rsp);
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;
            // return location.href = "redirect:success";

            $("#paymentForm").submit();

            // window.location.href = "success"
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            // return location.href = "redirect:fail";
            window.location.href = "fail"
        }
        // alert(msg); // 결제 결과 알림
    });
}

function inicis() { // 추가 예정

    var IMP = window.IMP; // 생략가능
    IMP.init('imp27843145');
    // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    IMP.request_pay({
        // pg: 'INIBillTst', // version 1.1.0부터 지원.
        pg: 'html5_inicis', // version 1.1.0부터 지원.
        /*
            'kakao':카카오페이,
            html5_inicis':이니시스(웹표준결제)
                'nice':나이스페이
                'jtnet':제이티넷
                'uplus':LG유플러스
                'danal':다날
                'payco':페이코
                'syrup':시럽페이
                'paypal':페이팔
            */
        pay_method: 'card', // 생략가능
        /*
            'samsung':삼성페이,
            'card':신용카드,
            'trans':실시간계좌이체,
            'vbank':가상계좌,
            'phone':휴대폰소액결제
        */
        merchant_uid: 'merchant_' + new Date().getTime(),
        /*
            merchant_uid에 경우
            https://docs.iamport.kr/implementation/payment
            위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
            참고하세요.
            나중에 포스팅 해볼게요.
         */
        name: '주문명:결제테스트', //결제창에서 보여질 이름
        amount: 1000, //가격
        buyer_email: 'iamport@siot.do',
        buyer_name: '구매자이름',
        buyer_tel: '010-1234-5678',
        buyer_addr: '서울특별시 강남구 삼성동',
        buyer_postcode: '123-456'
        // , m_redirect_url: 'https://www.yourdomain.com/payments/complete'
        /*
            모바일 결제시,
            결제가 끝나고 랜딩되는 URL을 지정
            (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
            */
    }, function (rsp) { // callback 로직
        console.log(rsp);
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
    });
}

function toss() { // 추가 예정

    tossPayments.requestPayment('카드', { // 결제 수단
                                        // 결제 정보
        amount: 15000,
        orderId: 'wHCsCnS7R2sNldZ_8XWEO',
        orderName: '토스 티셔츠 외 2건',
        customerName: '박토스',
        successUrl: 'success',
        failUrl: 'fail',
        flowMode: 'DIRECT',
        easyPay: '토스페이'
    })
    .catch(function (error) {
        if (error.code === 'USER_CANCEL') {
            // 결제 고객이 결제창을 닫았을 때 에러 처리
            alert("결제가 취소되었습니다.")
        } else if (error.code === 'INVALID_CARD_COMPANY') {
            // 유효하지 않은 카드 코드에 대한 에러 처리
            alert("유효하지않은 카드 코드입니다.")
        }
    })
}

// function payment() {
//
//     let cvc = document.getElementById("cvc");
//
//     if (cvc != null) {
//         window.location.href="success";
//         return "success";
//     } else {
//         window.location.href="fail";
//         return "fail";
//     }
// }