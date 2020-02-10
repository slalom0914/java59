SELECT emp_id, emp_name, lev
  FROM temp
ORDER by step asc, emp_id desc

select문의 처리과정에 대해서 설명할 수 있다.

1)파싱한다(문법체크)
2)DBMS가 실행계획을 세운다.
3)실행계획을 옵티마이저에게 넘긴다.
4)OPEN~CURSOR~FETCH
커서가 가리키는 위치에 한 개 로우를 메모리에 올림-> 이것을  fetch라고 함.

SELECT ename FROM emp

SELECT empno, ename FROM emp
WHERE ename LIKE '_M%';

