CREATE USER SEMI IDENTIFIED BY SEMI;
GRANT CONNECT, RESOURCE TO SEMI;
GRANT CREATE VIEW TO SEMI;
GRANT CREATE SEQUENCE TO SEMI;
GRANT CREATE TRIGGER TO SEMI; 

DROP TABLE BLOG_BOARD;
DROP TABLE BLOG_COMMENT;
DROP TABLE BLOG_IMAGE;
DROP TABLE CART;
DROP TABLE "CATEGORY";
DROP TABLE CONTACT;
DROP TABLE "ORDER";
DROP TABLE PATMENT;
DROP TABLE PAYMENT;
DROP TABLE PRODUCT;
DROP TABLE PRODUCT_IMAGE;
DROP TABLE QUESTION;
DROP TABLE QUESTION_REPLY;
DROP TABLE "USER";

-- 상품 테이블
DROP TABLE TBL_PRODUCT;

CREATE TABLE "TBL_PRODUCT" (
	"PRODUCT_NO"	NUMBER		NOT NULL,
	"PRODUCT_NAME"	NUMBER		NOT NULL,
	"PRODUCT_PRICE"	NUMBER		NOT NULL,
	"PRODUCT_DESC"	LONG		NOT NULL,
	"PRODUCT_QTY"	NUMBER		NOT NULL,
	"CATEGORY_CODE"	VARCHAR(30)		NOT NULL
);

DROP TABLE TBL_CATEGORY;

CREATE TABLE "TBL_CATEGORY" (
	"CATEGORY_CODE"	VARCHAR(30)		NOT NULL,
	"CATEGORY_NAME"	VARCHAR(50)		NOT NULL
);

DROP TABLE "TBL_CART";

CREATE TABLE "TBL_CATEGORY" (
	"CART_NO"	NUMBER		NOT NULL,
	"PRODUCT_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL,
	"PRODUCT_COUNT"	NUMBER		NOT NULL
);

DROP TABLE "TBL_USER";

CREATE TABLE "TBL_USER" (
	"USER_ID"	VARCHAR(50)		NOT NULL,
	"USER_PWD"	VARCHAR(50)		NOT NULL,
	"USER_NAME"	VARCHAR(20)		NOT NULL,
	"USER_TEL"	VARCHAR(20)		NOT NULL,
	"ADDRESS"	VARCHAR(50)		NOT NULL,
	"USER_EMAIL"	VARCHAR(50)		NOT NULL,
	"USER_ROLE"	CHAR(1)		,
	"USER_ACTIVE"	CHAR(1)		,
	"USER_ENTDATE"	DATE		NOT NULL,
	"USER_POINT"	NUMBER		NOT NULL
);

DROP TABLE "TBL_PAYMENT";

CREATE TABLE "TBL_PAYMENT" (
	"PAYMENT_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL,
	"PAYMENT_METHOD"	VARCHAR(20)		NOT NULL,
	"PAYMENT_AMOUNT"	NUMBER		NOT NULL
);

DROP TABLE "TBL_BLOG_BOARD";

CREATE TABLE "TBL_BLOG_BOARD" (
	"BLOG_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL,
	"BLOG_TITLE"	VARCHAR2(200)		NOT NULL,
	"BLOG_CONTENT"	LONG		NOT NULL,
	"BLOG_POSTDATE"	DATE		NOT NULL,
	"BLOG_VIEWCOUNT"	NUMBER		NULL
);

DROP TABLE "TBL_BLOG_IMAGE";

CREATE TABLE "TBL_BLOG_IMAGE" (
	"BLOG_IMG_NO"	NUMBER		NOT NULL,
	"ORIGIN_FILE"	VARCHAR(300)		NOT NULL,
	"STORED_FILE"	VARCHAR(300)		NOT NULL,
	"BLOG_THUMB"	VARCHAR(300)		NOT NULL,
	"BLOG_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL
);

DROP TABLE "TBL_PRODUCT_IMAGE";

CREATE TABLE "TBL_PRODUCT_IMAGE" (
	"FILE_NO"	NUMBER		NOT NULL,
	"ORIGIN_NAME"	VARCHAR(300)		NOT NULL,
	"STORED_NAME"	VARCHAR(300)		NOT NULL,
	"THUMBNAIL"	CHAR(1)		NOT NULL,
	"PRODUCT_NO"	NUMBER		NOT NULL
);

DROP TABLE "TBL_QUESTION";

CREATE TABLE "TBL_QUESTION" (
	"QNA_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL,
	"QNA_CHECK"	CHAR(1)		NULL,
	"QNA_TITLE"	VARCHAR(100)		NOT NULL,
	"QNA_CONTENT"	VARCHAR(300)		NOT NULL,
	"QNA_POSTDATE"	DATE		NOT NULL
);

DROP TABLE "TBL_ORDER";

CREATE TABLE "TBL_ORDER" (
	"ORDER_NO"	NUMBER		NOT NULL,
	"PAYMENT_NO"	NUMBER		NOT NULL,
	"ORDER_DATE"	DATE		NOT NULL,
	"RECEIVER_NAME"	VARCHAR(20)		NOT NULL,
	"RECEIVER_TEL"	VARCHAR(20)		NOT NULL,
	"ADDRESS_ZIPCODE"	VARCHAR(10)		NOT NULL,
	"ADDRESS"	VARCHAR(100)		NOT NULL,
	"ADDRESS_DETAIL"	VARCHAR(100)		NOT NULL,
	"SHIP_STATUS"	VARCHAR(20)		NOT NULL
);

DROP TABLE "TBL_CONTACT";

CREATE TABLE "TBL_CONTACT" (
	"NAME"	VARCHAR(10)		NOT NULL,
	"EMAIL"	VARCHAR(50)		NOT NULL,
	"SUBJECT"	VARCHAR(50)		NOT NULL,
	"CONTENT"	VARCHAR(500)		NOT NULL
);

DROP TABLE "TBL_BLOG_COMMENT";

CREATE TABLE "TBL_BLOG_COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR(200)		NOT NULL,
	"COMMENT_POSTDATE"	DATE		NOT NULL,
	"BLOG_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL
);

DROP TABLE "TBL_QUESTION_REPLY";

CREATE TABLE "TBL_QUESTION_REPLY" (
	"REPLY_NO"	NUMBER		NOT NULL,
	"QNA_NO"	NUMBER		NOT NULL,
	"USER_ID"	VARCHAR(50)		NOT NULL,
	"REPLY_TITLE"	VARCHAR(100)		NOT NULL,
	"REPLY_CONTENT"	VARCHAR(300)		NOT NULL
);

-- 제약 조건
ALTER TABLE TBL_PRODUCT ADD CONSTRAINT PK_PRODUCT_NO PRIMARY KEY (PRODUCT_NO);
ALTER TABLE TBL_PRODUCT ADD CONSTRAINT FK_CATEGORY_CODE FOREIGN KEY (CATEGORY_CODE) REFERENCES "TBL_CATEGORY"(CATEGORY_CODE);

ALTER TABLE "TBL_CATEGORY" ADD CONSTRAINT PK_CATEGORY_CODE PRIMARY KEY (CATEGORY_CODE);

ALTER TABLE "TBL_CART" ADD CONSTRAINT PK_CART_NO PRIMARY KEY (CART_NO);
ALTER TABLE "TBL_CART" ADD CONSTRAINT FK_PRODUCT_NO FOREIGN KEY (PRODUCT_NO) REFERENCES "TBL_PRODUCT"(PRODUCT_NO);
ALTER TABLE "TBL_CART" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);

ALTER TABLE "TBL_PAYMENT" ADD CONSTRAINT PK_PAYMENT_NO PRIMARY KEY (PAYMENT_NO);
ALTER TABLE "TBL_PAYMENT" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);

ALTER TABLE "TBL_USER" ADD CONSTRAINT PK_USER_ID PRIMARY KEY (USER_ID);
ALTER TABLE "TBL_USER" ADD CONSTRAINT CK_USER_ROLE CHECK(USER_ROLE IN('Y', 'N'));
ALTER TABLE "TBL_USER" ADD CONSTRAINT CK_USER_ACTIVE CHECK(USER_ACTIVE IN('Y', 'N'));

ALTER TABLE "TBL_BLOG_BOARD" ADD CONSTRAINT PK_BLOG_NO PRIMARY KEY (BLOG_NO);
ALTER TABLE "TBL_BLOG_BOARD" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);

ALTER TABLE "TBL_BLOG_IMAGE" ADD CONSTRAINT PK_BLOG_IMG_NO PRIMARY KEY (BLOG_IMG_NO);
ALTER TABLE "TBL_BLOG_IMAGE" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);
ALTER TABLE "TBL_BLOG_IMAGE" ADD CONSTRAINT FK_BLOG_NO FOREIGN KEY (BLOG_NO) REFERENCES "TBL_BLOG_BOARD"(BLOG_NO);

ALTER TABLE "TBL_PRODUCT_IMAGE" ADD CONSTRAINT PK_FILE_NO PRIMARY KEY (FILE_NO);
ALTER TABLE "TBL_PRODUCT_IMAGE" ADD CONSTRAINT FK_PRODUCT_NO FOREIGN KEY (PRODUCT_NO) REFERENCES "TBL_PRODUCT"(PRODUCT_NO);

ALTER TABLE "TBL_QUESTION" ADD CONSTRAINT PK_QNA_NO PRIMARY KEY (QNA_NO);
ALTER TABLE "TBL_QUESTION" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);

ALTER TABLE "TBL_ORDER" ADD CONSTRAINT PK_ORDER_NO PRIMARY KEY (ORDER_NO);
ALTER TABLE "TBL_ORDER" ADD CONSTRAINT FK_PAYMENT_NO FOREIGN KEY (PAYMENT_NO) REFERENCES "TBL_PAYMENT"(PAYMENT_NO);

ALTER TABLE "TBL_CONTACT" ADD CONSTRAINT PK_NAME PRIMARY KEY ("NAME");

ALTER TABLE "TBL_BLOG_COMMENT" ADD CONSTRAINT PK_COMMENT_NO PRIMARY KEY (COMMENT_NO);
ALTER TABLE "TBL_BLOG_COMMENT" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);
ALTER TABLE "TBL_BLOG_COMMENT" ADD CONSTRAINT FK_BLOG_NO FOREIGN KEY (BLOG_NO) REFERENCES "TBL_BLOG_BOARD"(BLOG_NO);

ALTER TABLE "TBL_QUESTION_REPLY" ADD CONSTRAINT PK_REPLY_NO PRIMARY KEY (REPLY_NO);
ALTER TABLE "TBL_QUESTION_REPLY" ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES "TBL_USER"(USER_ID);
ALTER TABLE "TBL_QUESTION_REPLY" ADD CONSTRAINT FK_QNA_NO FOREIGN KEY (QNA_NO) REFERENCES "TBL_QUESTION"(QNA_NO);

INSERT INTO TBL_USER
VALUES('admin', 'admin', '관리자', '010-3456-9890', '서울시 가산동', 'admin@gmail.com', 'Y', 'Y', SYSDATE, 0);

INSERT INTO TBL_USER
VALUES('user01', 'pass01', '홍길동', '010-3456-9891', '서울시 금산구', 'hong@gmail.com', 'Y', 'Y', SYSDATE, 1000);

INSERT INTO TBL_USER
VALUES('user02', 'pass02', '유재석', '010-3456-9881', '서울시 구로구', 'yu@gmail.com', 'Y', 'Y', SYSDATE, 1000);

-- 시퀀스

-- 뷰 테이블

-- 별칭
-- 예시
-- COMMENT ON COLUMN STUDENT_DEL.STUDENT_NO IS '학생번호';

-- CREATE SEQUENCE SEQ_STUDENT_NO
--     START WITH 20220001
--     INCREMENT BY 1
--     MAXVALUE 20229999
--     NOCYCLE
-- NOCACHE;

-- 뷰 테이블
-- CREATE OR REPLACE VIEW VIEW_GRADE_CHECK
-- AS
-- SELECT
--     D.LECTURE_NAME LECTURE_NAME,
--     B.PROF_NAME PROF_NAME,
--     A.STUDENT_NO STUDENT_NO,
--     C.STUDENT_NAME STUDENT_NAME,
--     A.ATT_SCORE ATT_SCORE,
--     A.ASS_SCORE ASS_SCORE,
--     A.MID_SCORE MID_SCORE,
--     A.FIN_SCORE FIN_SCORE,
--     A.GRADE GRADE
-- FROM GRADE A
--          JOIN PROFESSOR B
--               ON A.PROF_NO = B.PROF_NO
--          JOIN STUDENT C
--               ON A.STUDENT_NO = C.STUDENT_NO
--          JOIN LECTURE D
--               ON A.LECTURE_NO = D.LECTURE_NO;

-- 트리거
-- CREATE OR REPLACE TRIGGER TRG_ENROLL
--     AFTER INSERT ON ENROLLMENT
--     FOR EACH ROW
-- BEGIN
-- UPDATE LECTURE
-- SET CURR_NO = CURR_NO + 1
-- WHERE LECTURE_NO = :NEW.LECTURE_NO;
-- END;
-- /