CREATE TABLE tbl_foods(
    fd_code	VARCHAR2(7)		PRIMARY KEY,
    fd_name	nVARCHAR2(125)	NOT NULL	,
    fd_year	NUMBER	NOT NULL	,
    fd_ccode	VARCHAR2(6)	NOT NULL	,
    fd_fcode	VARCHAR2(4)	NOT NULL	,
    fd_serv	NUMBER	NOT NULL	,
    fd_total	NUMBER		,
    fd_energy	NUMBER	NOT NULL	,
    fd_protein	NUMBER		,
    fd_fat	NUMBER		,
    fd_carbo	NUMBER	,	
    fd_sugar	NUMBER		
);

DROP TABLE tbl_foods;

CREATE TABLE tbl_company(
    cp_code	VARCHAR2(6)		PRIMARY KEY,
    cp_name	nVARCHAR2(100)	NOT NULL	
);

CREATE TABLE tbl_items(
    it_code	VARCHAR2(4)		PRIMARY KEY,
    it_name	nVARCHAR2(100)	NOT NULL	
);

-- 세개의 table간의 참조무결성 설정
-- 누가 부모이고, 누가 자손인지 파악
-- 자손 : tbl_foods, 부모 : tbl_compnay, tbl_items
-- FK 설정은 자손 table에 설정하기

ALTER TABLE tbl_foods 
ADD CONSTRAINT fk_ccode
FOREIGN KEY (fd_ccode)
REFERENCES tbl_company(cp_code);

ALTER TABLE tbl_foods 
ADD CONSTRAINT fk_fcode
FOREIGN KEY (fd_fcode)
REFERENCES tbl_items(it_code);

SELECT COUNT (*) FROM tbl_foods;

CREATE VIEW view_식품정보
AS
(
SELECT F.fd_code AS 식품코드, F.fd_name AS 식품명,
        F.fd_year AS 출시연도, C.cp_code AS 제조사코드,
        C.cp_name AS 제조사명, I.it_code AS 분류코드, 
        I.it_name AS 분류명, F.fd_serv AS "1회제공량",
        F.fd_total AS 총내용량, F.fd_energy AS "에너지(kcal)",
        F.fd_protein AS "단백질(g)" ,  F.fd_fat AS "지방(g)" ,
        F.fd_carbo AS "탄수화물(g)", F.fd_sugar AS "총 당류(g)"               
FROM tbl_foods F
    LEFT JOIN tbl_company C
        ON F.fd_ccode = C.cp_code
    LEFT JOIN tbl_items I
        ON F.fd_fcode = I.it_code
);

SELECT * FROM view_식품정보;

DROP TABLE tbl_myfoods;

CREATE TABLE tbl_myfoods(
    mf_seq NUMBER PRIMARY KEY,
    mf_date VARCHAR2(20) NOT NULL,
    mf_fcode VARCHAR2(7) NOT NULL,
    mf_size NUMBER NOT NULL    
        );

DELETE tbl_myfoods
WHERE mf_seq = 7;

CREATE SEQUENCE mf_seq 
INCREMENT BY 1
START WITH 1;

DROP SEQUENCE mf_seq;
        
INSERT INTO tbl_myfoods(mf_seq ,mf_date, mf_fcode,mf_size)
VALUES (mf_seq.NEXTVAL,'2021-05-10', 'PD00018', 2);
        
DROP VIEW view_섭취정보;        

CREATE VIEW view_섭취정보
AS
(
SELECT mf_seq AS SEQ ,mf_date AS 날짜, V.식품명 AS 식품명,
        mf_size AS 섭취량, V."에너지(kcal)" * MF.mf_size AS 에너지,
        V."1회제공량" * MF.mf_size AS "총 내용량",
        V."단백질(g)" * MF.mf_size AS 단백질,
        V."지방(g)" * MF.mf_size AS 지방,
        V."탄수화물(g)" * MF.mf_size AS 탄수화물,
        V."총 당류(g)" * MF.mf_size AS "총 당류"
FROM tbl_myfoods MF
    LEFT JOIN view_식품정보 V
        ON mf_fcode = V.식품코드
);

SELECT * FROM view_섭취정보;