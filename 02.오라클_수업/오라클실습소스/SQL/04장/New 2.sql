SELECT * FROM t_letitbe

문제1
영어가사만 나오게 하기

SELECT MOD(5,2), MOD(500,2), MOD(35,2) FROM dual

SELECT MOD(seq_vc,2) as "NO"
      ,words_vc
 FROM t_letitbe
WHERE MOD(seq_vc,2)=1

문제2
한글가사만 출력해 보세요.

SELECT MOD(seq_vc,2) as "NO"
      ,words_vc
 FROM t_letitbe
WHERE MOD(seq_vc,2)=0

문제3
1번 답과 2번 답을 가지고 합집합을 사용하여 영어가사와 한글가사가 교대로 
출력되도록 해보세요.

SELECT MOD(seq_vc,2) as "NO"
      ,words_vc
 FROM t_letitbe
WHERE MOD(seq_vc,2)=1
UNION ALL
SELECT MOD(seq_vc,2) as "NO"
      ,words_vc
 FROM t_letitbe
WHERE MOD(seq_vc,2)=0

형전환 함수가 있다.
문자를 숫자로 바꾸어 주는 함수가 있다.

edit t_letitbe

SELECT TO_NUMBER(seq_vc,99) FROM t_letitbe

SELECT ename FROM emp WHERE empno='7566'

오라클도 자동형전환이 일어난다.

강제형전환 함수가 있다.

TO_CHAR()
TO_NUMBER()

SELECT seq_vc, words_vc FROM t_letitbe
ORDER BY TO_NUMBER(seq_vc) asc
