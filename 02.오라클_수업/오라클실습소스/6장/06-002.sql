CREATE TABLE TEST11 (
    COLL   VARCHAR2(20),         
    DEPT   VARCHAR2(20),                  
    FRE    NUMBER,   
    SUP    NUMBER,   
    JUN    NUMBER,   
    SEN    NUMBER,
    CONSTRAINT TEST11_PK PRIMARY KEY (COLL,DEPT)
                    );  
INSERT INTO TEST11 VALUES('공과대학','항공우주공학과',120, 140, 140, 120);
INSERT INTO TEST11 VALUES('공과대학','기계공학과',    240, 260, 240, 240);
INSERT INTO TEST11 VALUES('공과대학','조선공학과',    118, 138, 136, 126);
INSERT INTO TEST11 VALUES('공과대학','산업공학과',    123, 141, 140, 120);
INSERT INTO TEST11 VALUES('공과대학','전자공학과',    126, 141, 140, 128);
INSERT INTO TEST11 VALUES('공과대학','재료공학과',    128, 132, 142, 126);
INSERT INTO TEST11 VALUES('공과대학','화학공학과',    122, 141, 141, 122);
INSERT INTO TEST11 VALUES('공과대학','전기공학과',    120, 140, 140, 120);
INSERT INTO TEST11 VALUES('공과대학','컴퓨터공학과',  124, 145, 142, 121);
INSERT INTO TEST11 VALUES('공과대학','섬유공학과',    126, 144, 140, 120);
INSERT INTO TEST11 VALUES('공과대학','자동화공학과',  122, 142, 144, 125);
INSERT INTO TEST11 VALUES('공과대학','고분자공학과',  121, 142, 143, 124);
COMMIT;
                
