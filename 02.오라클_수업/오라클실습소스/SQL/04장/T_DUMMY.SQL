/*
 System Name    :  TEST                                        
 Entity Name    :   DUMMY 테이블 만들기                               
 Table  Name    : T_DUMMY
 작성자         :  노정환 					
 작성일         :  2003.06.16
 내용            :  조인
 비고	     :  
*/
CREATE TABLE T_DUMMY
(
DM NUMBER(3) PRIMARY KEY
)
/
DECLARE
  DUMMY_NU NUMBER;
BEGIN
  DUMMY_NU :=0;
  LOOP
 DUMMY_NU := DUMMY_NU + 1;
  EXIT WHEN DUMMY_NU > 100;
  INSERT INTO T_DUMMY VALUES
  (DUMMY_NU);
  END LOOP;
 COMMIT;
END;
/
