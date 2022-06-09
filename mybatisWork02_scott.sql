SELECT USER
FROM DUAL;
--==>>SCOTT

------------------------------------------------------------
--기존 테이블 제거
DROP TABLE TBL_MEMBERLIST;
--Table TBL_MEMBERLIST이(가) 삭제되었습니다.

-- 실습 테이블 생성(TBL_MEMBERLIST)
CREATE TABLE MEMBERLIST
(MID         NUMBER
,NAME       VARCHAR2(30)
,TELEPHONE  VARCHAR2(50)
,CONSTRAINT MEMBERLIST_ID_PK PRIMARY KEY(MID)
);
--Table MEMBERLIST이(가) 생성되었습니다.

-- 기존 시퀀스 제거
DROP SEQUENCE MEMBERLISTSEQ;
--Sequence MEMBERLISTSEQ이(가) 삭제되었습니다.


-- 시퀀스 생성
CREATE SEQUENCE MEMBERLISTSEQ
NOCACHE;
--Sequence MEMBERLISTSEQ이(가) 생성되었습니다.


--------------------------------------------------------------
-- 데이터 입력
INSERT INTO MEMBERLIST(MID, NAME, TELEPHONE)
VALUES(MEMBERLISTSEQ.NEXTVAL,'김태형','010-1111-1111');
-->1 행 이(가) 삽입되었습니다.

--확인
SELECT MID, NAME, TELEPHONE
FROM TBL_MEMBERLIST;
--1	김태형	010-1111-1111

--커밋
COMMIT;
--커밋 완료.

-- 인원수 확인
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERLIST;
--1

-- 데이터 추가 입력
INSERT INTO MEMBERLIST(MID, NAME, TELEPHONE)
VALUES(MEMBERLISTSEQ.NEXTVAL,'우수정','010-2222-2222');
--1 행 이(가) 삽입되었습니다.

--확인
SELECT MID, NAME, TELEPHONE
FROM MEMBERLIST;
/*
1	김태형	010-1111-1111
2	우수정	010-2222-2222
*/


--커밋
COMMIT;

ALTER TABLE MEMBERLIST RENAME TO TBL_MEMBERLIST;
--Table MEMBERLIST이(가) 변경되었습니다.

--커밋
COMMIT;

SELECT *
FROM TBL_MEMBERLIST;




