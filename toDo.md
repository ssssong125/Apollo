### 완료
결제시 포인트 삭감 트리거 포인트 적립
결제시 상품재고 빼기
결제시 카트테이블에서 주문완료 테이블로 이동
오더테이블은 따로 넣어줘야함
결제목록 y로 불러와서 넘기기
### 진행중 
상품이미지 AJAX 사용해야할듯 
체크된 카트리스트만 넘겨서 카트에서 삭제 쿼리문 필요 구매상태 Y로 전환 
세션에서 아이디 뽑기
상품추가시 로그인 필요 + 장바구니 담기 클릭시 모달(장바구니로 or 닫기) + 이미 있는 상품이면 갯수만 + 
배송조회 주문한 상품 목록 - 트롤리에서 넘겨줄 값 : 구매할 상품 cartNo
정규식 카드 유효성 검증, 폰번호 
오더페이지 직접 접근(겟맵핑 불가) 포스트 방식으로 넘어올때 데이터 없으면 카트로 넘기기, 

결제시 상품재고 체크 간단하게만 해도 되긴할듯 - 사용자가 한명이라 + 장바구니들어갈때 재고 항상 확인하게하자
배송상태 소요 날짜로 카운팅 상태 변경하는 트리거
페이지 벗어날때 에러 뒤로가기 버튼 및 페이지 이탈시 입력정보 날아갑니다 알림
장바구니 제이쿼리 사용해서 구매수량 이상하게 입력하면 이전 값 다시 넣어주기
입력칸 에러(빨간 글씨)
배송지 저장 - 배송지 테이블 필요 또는 기존 주문 정보에서 불러오기(이게 낫네) 모달창띄워서 목록보여주고 고ㅓ르게하기 + 기본 3가지
userDTO 암호같은 개인정보는 빼자
라디오 버튼 수정
브라우저 작게 했을때 사이즈 조정
완료되지않은 주문 있으면 불러와서 다시 주문 과정 시작

### 월요일 
- 상품 사진 받아오기 - 장바구니 페이지 

### 테스트 목록 
장바구니 추가시 장바구니에 추가 및 이동할지 안할지
장바구니 품목 갯수가 뱃지로 표시
카트 버튼 눌렀을떄 카트페이지로 이동
장바구니 상품 정보 제대로 표시
갯수 조절 작동 소수점, 음수, 문자, 특수문자 최대치 재고수량
삭제 했을때 제대로 삭제 및 화면 전환 
