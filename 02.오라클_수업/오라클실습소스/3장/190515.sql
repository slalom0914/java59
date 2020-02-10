20190515

SELECT rownum rno FROM emp

SELECT rownum, ename FROM emp
where deptno = 20
AND rno > 3

인라인 뷰를 사용하면 테이블에 없는 컬럼도 조건절에 사용할 수 있다.



SELECT 
        rno, ename
        FROM(select rownum rno, ename FROM emp where deptno = 20)   
    WHERE rno =  3
-- 알리아명을 컬럼명으로 쓰려면 인라인뷰를 사욯한다 --


rownum
SQL의 결과 집합에 대한 순번을 결정해 주는 역할


SELECT * FROM member;   

문제1
아이디 중복검사를 담당자가 원하고 있다.
중복검사 하는 select문을 작성해보시오

SELECT mem_name FROM member
WHERE mem_id =: user_id

--아이디가 존재하지 않으면 조회결과는 없다.
--로우가 없다.

    
SELECT count(mem_name) FROM member
WHERE mem_id =: user_id;

--그룹함수 사용하는 경우에는 조회결과가 없다 하더라도 리턴값이 있다.
--전체범위 처리 하므로 속도가 느리다. (중간에 중복값을 찾아도 총 갯수를 찾아야 하므로 전체범위를 처리함)

아이디가 존재하니?

SELECT 1 FROM dual
WHERE EXISTS (SELECT mem_name FROM member
                WHERE mem_id =:user_id
                AND rownum = 1
                )
-- rownum은 순서 매길떄와 스탑키로 사용한다


rowid 

SELECT rowid rid FROM emp

6자리: 데이터에 대한 오브젝트 번호
3자리: 상대적 파일번호
6자리: 블록번호
3자리:블록내의 행번호

SELECT ename, hiredate FROM emp
WHERE rowid = 'AAARE8AAEAAAACTAAA'

이 ROWID는 index와도 관련이 있는데 index테이블은 index key와 rowid로 이루어져 있기 때문이다.
이렇게 저장공간을 가지고 있는 rowid는 마치 물리적인 정보라고 생각할 수 있지만 실제로는 존재하지 않으며
index테이블 내에 있는 rowid는 해당데이터를 찾기 위한 하나의 논리적인 정보일 뿐이다.


문제1
temp와 tcom의 자료 중 emp_id, salary, comm을 
보여주는 sql 문을 작성하시오.
이때 salary와 comm이 모두 존재하는 사번은 두 줄로 나와야 함.

SELECT *  FROM temp, tcom
ORDER BY EMP_NAME

SELECT * FROM temp

SELECT * FROM tcom

SELECT a.emp_id, salary, comm FROM temp a, tcom b
WHERE salary is not null
UNION           
SELECT a.emp_id, salary, comm FROM temp a, tcom b
WHERE comm is not null
ORDER by emp_ID, comm asc   


컬럼의 갯수가 일치해야함.
타입도 서로 맞아야 함

SELECT '안녕' FROM dual
UNION ALL
SELECT 1 FROM dual

SELECT emp_id, salary, 0 comm FROM temp
UNION ALL
SELECT emp_id, 0 salary, comm FROM tcom

문제2 
우리회사에 근무하는 사원중에서 인센티브를 받지 않는 사원의 아이디와 일음을 출력하는 
sql문을 작성하시오.

SELECT emp_id, emp_name from temp 
MINUS
SELECT a.emp_id, emp_name  from tcom a, temp b
WHERE comm is not null

SELECT emp_id from temp
MINUS

SELECT emp_id from tcom


SELECT  workcd_vc, time_nu
 FROM t_worktime
 WHERE rownum <4
-- 인라인뷰로 사용하자


SELECT s1.workcd_vc ,count(s2.time_nu)
            FROM(SELECT  workcd_vc, time_nu
                    FROM t_worktime
                        WHERE rownum <4 ) s1,
                (SELECT  workcd_vc, time_nu
                     FROM t_worktime
                          WHERE rownum  <4) s2
                     WHERE s1.time_nu >= s2.time_nu
                        GROUP by s1.workcd_vc
                              ORDER BY count(s2.time_nu)
                              
랭크 함수
    
    SELECT  
            workcd_vc
            ,rank() over(order by time_nu asc) rnk
                FROM t_worktime                              