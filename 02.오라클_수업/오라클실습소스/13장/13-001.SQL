CREATE TABLE  TEST09 (LINE  VARCHAR2(3),
                      SPEC  VARCHAR2(10),
                      ITEM  VARCHAR2(8),
                      QTY   NUMBER,
                      CONSTRAINT TEST09_PK PRIMARY KEY (LINE,SPEC,ITEM)
                     );
INSERT INTO TEST09 VALUES('01','A001','P01',1);                                       
INSERT INTO TEST09 VALUES('01','A001','P03',1);                                       
INSERT INTO TEST09 VALUES('01','A001','P04',1);                                       
INSERT INTO TEST09 VALUES('01','A001','P07',1);                                       
INSERT INTO TEST09 VALUES('01','A001','P08',1);                                       
INSERT INTO TEST09 VALUES('01','A002','P02',4);                                       
INSERT INTO TEST09 VALUES('01','A002','P04',4);                                       
INSERT INTO TEST09 VALUES('01','A002','P05',4);                                       
INSERT INTO TEST09 VALUES('01','A002','P07',4);                                       
INSERT INTO TEST09 VALUES('01','A002','P08',4);                                       
INSERT INTO TEST09 VALUES('01','A003','P01',3);                                       
INSERT INTO TEST09 VALUES('01','A003','P03',3);                                       
INSERT INTO TEST09 VALUES('01','A003','P04',3);                                       
INSERT INTO TEST09 VALUES('01','A003','P06',3);                                       
INSERT INTO TEST09 VALUES('01','A003','P07',3);                                       
INSERT INTO TEST09 VALUES('01','A004','P02',2);                                       
INSERT INTO TEST09 VALUES('01','A004','P03',2);                                       
INSERT INTO TEST09 VALUES('01','A004','P05',2);                                       
INSERT INTO TEST09 VALUES('01','A004','P06',2);                                       
INSERT INTO TEST09 VALUES('01','A004','P07',2);                                       
INSERT INTO TEST09 VALUES('02','A001','P02',2);                                       
INSERT INTO TEST09 VALUES('02','A001','P05',2);                                       
INSERT INTO TEST09 VALUES('02','A001','P06',2);                                       
INSERT INTO TEST09 VALUES('02','A001','P09',2);                                       
INSERT INTO TEST09 VALUES('02','A001','P10',2);                                       
INSERT INTO TEST09 VALUES('02','A002','P01',1);                                       
INSERT INTO TEST09 VALUES('02','A002','P03',1);                                       
INSERT INTO TEST09 VALUES('02','A002','P06',1);                                       
INSERT INTO TEST09 VALUES('02','A002','P09',1);                                       
INSERT INTO TEST09 VALUES('02','A002','P10',1);                                       
INSERT INTO TEST09 VALUES('02','A003','P02',4);                                       
INSERT INTO TEST09 VALUES('02','A003','P05',4);                                       
INSERT INTO TEST09 VALUES('02','A003','P08',4);                                       
INSERT INTO TEST09 VALUES('02','A003','P09',4);                                       
INSERT INTO TEST09 VALUES('02','A003','P10',4);                                       
INSERT INTO TEST09 VALUES('02','A004','P01',3);                                       
INSERT INTO TEST09 VALUES('02','A004','P04',3);                                       
INSERT INTO TEST09 VALUES('02','A004','P08',3);                                       
INSERT INTO TEST09 VALUES('02','A004','P09',3);                                       
INSERT INTO TEST09 VALUES('02','A004','P10',3);                                       
INSERT INTO TEST09 VALUES('03','A001','P01',3);                                       
INSERT INTO TEST09 VALUES('03','A001','P03',3);                                       
INSERT INTO TEST09 VALUES('03','A001','P11',3);                                       
INSERT INTO TEST09 VALUES('03','A001','P13',3);                                       
INSERT INTO TEST09 VALUES('03','A001','P15',3);                                       
INSERT INTO TEST09 VALUES('03','A002','P01',2);                                       
INSERT INTO TEST09 VALUES('03','A002','P02',2);                                       
INSERT INTO TEST09 VALUES('03','A002','P13',2);                                       
INSERT INTO TEST09 VALUES('03','A002','P15',2);                                       
INSERT INTO TEST09 VALUES('03','A002','P16',2);                                       
INSERT INTO TEST09 VALUES('03','A003','P01',1);                                       
INSERT INTO TEST09 VALUES('03','A003','P08',1);                                       
INSERT INTO TEST09 VALUES('03','A003','P11',1);                                       
INSERT INTO TEST09 VALUES('03','A003','P12',1);                                       
INSERT INTO TEST09 VALUES('03','A003','P13',1);                                       
INSERT INTO TEST09 VALUES('03','A004','P01',4);                                       
INSERT INTO TEST09 VALUES('03','A004','P07',4);                                       
INSERT INTO TEST09 VALUES('03','A004','P09',4);                                       
INSERT INTO TEST09 VALUES('03','A004','P11',4);                                       
INSERT INTO TEST09 VALUES('03','A004','P12',4);
--
CREATE TABLE TEST10 (IDATE      VARCHAR2(8)  NOT NULL,
                     IN_SEQ     VARCHAR2(3)  NOT NULL,
                     LINE       VARCHAR2(3)  NOT NULL,
                     SPEC       VARCHAR2(10) NOT NULL,
                     CONSTRAINT TEST10_PK  
                                PRIMARY KEY (IDATE,IN_SEQ,LINE,SPEC)
                    );
INSERT INTO TEST10 VALUES ('19990203','01','01','A001');        
INSERT INTO TEST10 VALUES ('19990203','01','03','A001');        
INSERT INTO TEST10 VALUES ('19990203','02','01','A002');        
INSERT INTO TEST10 VALUES ('19990203','01','02','A002');        
INSERT INTO TEST10 VALUES ('19990203','02','02','A003');        
INSERT INTO TEST10 VALUES ('19990203','02','03','A003');        
INSERT INTO TEST10 VALUES ('19990203','03','01','A001');        
INSERT INTO TEST10 VALUES ('19990203','03','03','A001');        
INSERT INTO TEST10 VALUES ('19990203','04','01','A002');        
INSERT INTO TEST10 VALUES ('19990203','03','02','A002');        
INSERT INTO TEST10 VALUES ('19990203','04','02','A003');        
INSERT INTO TEST10 VALUES ('19990203','04','03','A003');        
INSERT INTO TEST10 VALUES ('19990203','05','01','A001');        
INSERT INTO TEST10 VALUES ('19990203','05','03','A001');        
INSERT INTO TEST10 VALUES ('19990203','06','01','A002');        
INSERT INTO TEST10 VALUES ('19990203','05','02','A002');        
INSERT INTO TEST10 VALUES ('19990203','06','02','A003');        
INSERT INTO TEST10 VALUES ('19990203','06','03','A003');        
INSERT INTO TEST10 VALUES ('19990203','07','01','A001');        
INSERT INTO TEST10 VALUES ('19990203','07','03','A001');        
INSERT INTO TEST10 VALUES ('19990203','08','01','A002');        
INSERT INTO TEST10 VALUES ('19990203','07','02','A002');        
INSERT INTO TEST10 VALUES ('19990203','08','02','A003');        
INSERT INTO TEST10 VALUES ('19990203','08','03','A003');        
INSERT INTO TEST10 VALUES ('19990203','09','01','A001');        
INSERT INTO TEST10 VALUES ('19990203','09','03','A001');        
INSERT INTO TEST10 VALUES ('19990203','10','01','A002');        
INSERT INTO TEST10 VALUES ('19990203','09','02','A002');        
INSERT INTO TEST10 VALUES ('19990203','10','02','A003');        
INSERT INTO TEST10 VALUES ('19990203','10','03','A003');   
COMMIT;
