SELECT * FROM t_letitbe

Â¦¼ö´Ï?

SELECT MOD(5,2), MOD(1501,2), MOD(200,2), MOD(4,2)
  FROM dual
  
SELECT empno,MOD(empno,2) FROM emp  

SELECT empno,MOD(empno,2) FROM emp  
WHERE MOD(empno,2)=0

SELECT empno,MOD(empno,2) FROM emp  
WHERE MOD(empno,2)=1