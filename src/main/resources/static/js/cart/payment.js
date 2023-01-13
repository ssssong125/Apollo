/*csrf 토큰 정보*/
const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");

//     $("#check_module").click(function () {
//     var IMP = window.IMP; // 생략가능
//     IMP.init('10c46c520d881aad65ac022e95256d3e');
//     // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
//     // ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
//     IMP.request_pay({
//     pg: 'kakao',
//     pay_method: 'card',
//     merchant_uid: 'merchant_' + new Date().getTime(),
//     /*
//      *  merchant_uid에 경우
//      *  https://docs.iamport.kr/implementation/payment
//      *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
//      */
//     name: '주문명 : 아메리카노',
//     // 결제창에서 보여질 이름
//     // name: '주문명 : ${auction.a_title}',
//     // 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
//     amount: 2000,
//     // amount: ${bid.b_bid},
//     // 가격
//     buyer_name: '이름',
//     // 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
//     // 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
//     buyer_postcode: '123-456',
// }, function (rsp) {
//     console.log(rsp);
//     if (rsp.success) {
//     var msg = '결제가 완료되었습니다.';
//     msg += '결제 금액 : ' + rsp.paid_amount;
//     // success.submit();
//     // 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
//     // 자세한 설명은 구글링으로 보시는게 좋습니다.
// } else {
//     var msg = '결제에 실패하였습니다.';
//     msg += '에러내용 : ' + rsp.error_msg;
// }
//     alert(msg);
// });
// });

// $("#check_module").onclick(function () {
//     alert()
//     var IMP = window.IMP; // 생략가능
//     IMP.init('10c46c520d881aad65ac022e95256d3e 넣어주세요');
//     // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
//     // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
//     IMP.request_pay({
//         pg: 'kakao', // version 1.1.0부터 지원.
//         /*
//             'kakao':카카오페이,
//             html5_inicis':이니시스(웹표준결제)
//                 'nice':나이스페이
//                 'jtnet':제이티넷
//                 'uplus':LG유플러스
//                 'danal':다날
//                 'payco':페이코
//                 'syrup':시럽페이
//                 'paypal':페이팔
//             */
//         pay_method: 'card',
//         /*
//             'samsung':삼성페이,
//             'card':신용카드,
//             'trans':실시간계좌이체,
//             'vbank':가상계좌,
//             'phone':휴대폰소액결제
//         */
//         merchant_uid: 'merchant_' + new Date().getTime(),
//         /*
//             merchant_uid에 경우
//             https://docs.iamport.kr/implementation/payment
//             위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
//             참고하세요.
//             나중에 포스팅 해볼게요.
//          */
//         name: '주문명:결제테스트', //결제창에서 보여질 이름
//         amount: 1000, //가격
//         buyer_email: 'iamport@siot.do',
//         buyer_name: '구매자이름',
//         buyer_tel: '010-1234-5678',
//         buyer_addr: '서울특별시 강남구 삼성동',
//         buyer_postcode: '123-456',
//         m_redirect_url: 'https://www.yourdomain.com/payments/complete'
//         /*
//             모바일 결제시,
//             결제가 끝나고 랜딩되는 URL을 지정
//             (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
//             */
//     }, function (rsp) {
//         console.log(rsp);
//         if (rsp.success) {
//             var msg = '결제가 완료되었습니다.';
//             msg += '고유ID : ' + rsp.imp_uid;
//             msg += '상점 거래ID : ' + rsp.merchant_uid;
//             msg += '결제 금액 : ' + rsp.paid_amount;
//             msg += '카드 승인번호 : ' + rsp.apply_num;
//         } else {
//             var msg = '결제에 실패하였습니다.';
//             msg += '에러내용 : ' + rsp.error_msg;
//         }
//         alert(msg);
//     });
// });

function kakaoPay() {

    $("#paymentMethod").val("KakaoPay")

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
        merchant_uid: 'merchant_' + new Date().getTime(),
        /*
            merchant_uid에 경우
            https://docs.iamport.kr/implementation/payment
            위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
            참고하세요.
            나중에 포스팅 해볼게요.
         */
        name: 'Apollo', //결제창에서 보여질 이름
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
            // return location.href = "redirect:success";
            window.location = "success"
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            // return location.href = "redirect:fail";
            window.location = "fail"
        }
        alert(msg);
    });
}

function inicis() { // 추가 예정

    var IMP = window.IMP; // 생략가능
    IMP.init('imp27843145');
    // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    IMP.request_pay({
        pg: 'INIBillTst', // version 1.1.0부터 지원.
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

    var IMP = window.IMP; // 생략가능
    IMP.init('imp27843145');
    // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    IMP.request_pay({
        pg: 'tosstest', // version 1.1.0부터 지원.
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