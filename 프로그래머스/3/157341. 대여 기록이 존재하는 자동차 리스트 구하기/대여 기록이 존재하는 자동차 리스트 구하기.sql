-- 코드를 입력하세요

SELECT DISTINCT(C.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR AS C
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H ON C.CAR_ID = H.CAR_ID
WHERE CAR_TYPE = '세단' AND MONTH(START_DATE) = 10
ORDER BY CAR_ID DESC;

