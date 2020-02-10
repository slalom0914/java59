SELECT * FROM t_giftorder;


순서가 정해져 있도록 하고 수량을 참조하기 위해 수량1, 수량2를 정렬

SELECT name_vc, quantity_nu q1,quantity_nu q2 FROM t_giftorder

위 문장을 인라인 뷰 사용해서 밖에서 ROWNUM을 정한 후 2로 나누면 값이 0과 1로 나뉜다.

SELECT*
FROM(
     SELECT name_vc,quantity_nu q1
          , quantity_nu q2
          FROM t_giftorder
          ORDER BY name_vc
          )
          
mod(rownum,2)이 값을 decode로 분리하고 0과 1일때 q1을 뿌릴지 q2를 뿌릴지 결정하고
||','|| concat 처리

SELECT name_vc,MAX(DECODE(MOD(rownum,2),1,q1))
      ||','||
      MAX(DECODE(MOD(rownum,2),0,q2)) value
  FROM (     
       SELECT name_vc, quantity_nu q1
             , quantity_nu q2
             FROM t_giftorder
             ORDER BY name_vc
             )
     GROUP BY name_vc        


        