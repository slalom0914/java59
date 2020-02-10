CREATE TABLE TEST12(
 PRESS     VARCHAR2(20) NOT NULL,
 BOOK_TYPE VARCHAR2(10) NOT NULL,
 BOOK_NAME VARCHAR2(20) NOT NULL,
 PRICE     NUMBER,
 CONSTRAINT TEST12_PK PRIMARY KEY (PRESS,BOOK_TYPE,BOOK_NAME)
);
INSERT INTO TEST12 VALUES ('서울 출판사','소설','전원일기',              9000);
INSERT INTO TEST12 VALUES ('서울 출판사','소설','인간시대',              8000);
INSERT INTO TEST12 VALUES ('서울 출판사','소설','태백산',               10000);
INSERT INTO TEST12 VALUES ('서울 출판사','소설','손자병법',              7000);
INSERT INTO TEST12 VALUES ('서울 출판사','시','접시꽃당신',              6000);
INSERT INTO TEST12 VALUES ('서울 출판사','시','진다래꽃',                7000);
INSERT INTO TEST12 VALUES ('서울 출판사','시','윤동주시집',              7000);
INSERT INTO TEST12 VALUES ('서울 출판사','시','겨울비',                  7000);
INSERT INTO TEST12 VALUES ('서울 출판사','수필','낙엽을태우며',          7000);
INSERT INTO TEST12 VALUES ('서울 출판사','수필','가을이오면',            7000);
INSERT INTO TEST12 VALUES ('서울 출판사','수필','어떻게사나',            7000);
INSERT INTO TEST12 VALUES ('서울 출판사','수필','비오면나는님을그린다',  7000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','고교국어',               9000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','중학수학',               8000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','고교수학',              10000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','고교물리',               7000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','지구과학',               6000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','물리',                   7000);
INSERT INTO TEST12 VALUES ('한국출판','교과서','고전',                   7000);
INSERT INTO TEST12 VALUES ('한국출판','참고서','영어참고',               7000);
INSERT INTO TEST12 VALUES ('한국출판','참고서','수학참고',               7000);
INSERT INTO TEST12 VALUES ('한국출판','참고서','국어참고',               7000);
INSERT INTO TEST12 VALUES ('한국출판','참고서','물리참고',               7000);
INSERT INTO TEST12 VALUES ('한국출판','참고서','전과',                   7000);   
CREATE TABLE SUB_SUM (
 NO1         NUMBER NOT NULL,
 UNCASH_DATE VARCHAR2(08) NOT NULL,
 SO_GUBUN    VARCHAR2(01),
 BILL_AMT    NUMBER,
 CUST_NAME   VARCHAR2(10),
 CONSTRAINT SUB_SUM_PK PRIMARY KEY (NO1)
);
INSERT INTO SUB_SUM VALUES (1,'19990601','1',100,'TEST1');
INSERT INTO SUB_SUM VALUES (2,'19990601','2',200,'TEST2');     
INSERT INTO SUB_SUM VALUES (3,'19990601','1',300,'TEST3');     
INSERT INTO SUB_SUM VALUES (4,'19990601','2',400,'TEST4');     
INSERT INTO SUB_SUM VALUES (5,'19990602','1',500,'TEST5');     
INSERT INTO SUB_SUM VALUES (6,'19990602','1',600,'TEST6');     
INSERT INTO SUB_SUM VALUES (7,'19990602','1',700,'TEST7');     
INSERT INTO SUB_SUM VALUES (8,'19990603','2',800,'TEST8');     
INSERT INTO SUB_SUM VALUES (9,'19990603','2',900,'TEST9');
COMMIT;

