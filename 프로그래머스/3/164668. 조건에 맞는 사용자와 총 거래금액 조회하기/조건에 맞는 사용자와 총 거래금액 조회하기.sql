-- 코드를 입력하세요

SELECT 
  U.USER_ID, 
  U.NICKNAME, 
  SUM(B.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER U
JOIN USED_GOODS_BOARD B 
  ON U.USER_ID = B.WRITER_ID
WHERE B.STATUS = 'DONE'
GROUP BY U.USER_ID, U.NICKNAME
HAVING SUM(B.PRICE) >= 700000
ORDER BY TOTAL_SALES ASC;
