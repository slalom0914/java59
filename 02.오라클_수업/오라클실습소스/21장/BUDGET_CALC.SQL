     CREATE OR REPLACE PROCEDURE BUDGET_CALC AS
        V_AMT  NUMBER       := 0;
     BEGIN
        DELETE FROM  TEST24
        WHERE  BUDGET IN (SELECT DISTINCT BUDGET
                          FROM   TEST25 );
--            
        FOR I IN(SELECT SER,
                        BUDGET, 
                        SEQ,
                        SIGNAL,
                        FBUDGET,
                        TBUDGET
                 FROM   TEST25
                 ORDER BY 
                        SER,
                        BUDGET, 
                        SEQ     )
        LOOP
        /*DATA중 FROM항목과 TO항목 사이의 값을 부문/제품별로 SUM한다. */
        FOR J IN(SELECT ITEM,SUM(AMT_AM) AMT_AM
                 FROM   TEST24
                 WHERE  BUDGET BETWEEN I.FBUDGET AND I.TBUDGET
                 GROUP BY 
                        ITEM)
        LOOP
           /* 계산식을 적용하고자하는 항목을
              읽어온 제품별로 값을 먼저 가져다 놓는다*/
           DECLARE
           BEGIN
             SELECT  AMT_AM
             INTO    V_AMT
             FROM    TEST24
             WHERE   ITEM   = J.ITEM 
             AND     BUDGET = I.BUDGET;
           EXCEPTION
                WHEN NO_DATA_FOUND THEN
                /* 해당항목의 제품에 값이 없으면 계산식의 연산자를  기준으로
                   연산식의 앞에오는 값은  영이다 */
                V_AMT := 0;
           END;
           /* 계산식의 부호에 따라 연산을 수행한다 */
           IF    I.SIGNAL = '+'  THEN
                 V_AMT := V_AMT+J.AMT_AM;
           ELSIF I.SIGNAL = '-'  THEN
                 V_AMT := V_AMT-J.AMT_AM;
           ELSIF I.SIGNAL = '*'  THEN
                 V_AMT := V_AMT*J.AMT_AM;
           ELSIF I.SIGNAL = '/'  THEN
                 V_AMT := V_AMT/J.AMT_AM;
           END IF;
           /* 수행한 연산값을 해당 KEY를 기준으로 UPDATE 하고 
              해당값이 없으면 INSERT 한다 */
           UPDATE TEST24
           SET    AMT_AM  = V_AMT
           WHERE  ITEM    = J.ITEM
           AND    BUDGET  = I.BUDGET;
           IF SQL%NOTFOUND  THEN
              INSERT INTO TEST24(ITEM,BUDGET,AMT_AM)
              VALUES (J.ITEM,I.BUDGET,V_AMT);
           END IF; /*END IF SQL%NOTFOUND THEN */
        END LOOP;  /*END LOOP FOR J IN()*/
      END LOOP;        /*END LOOP FOR I IN()*/
    END;