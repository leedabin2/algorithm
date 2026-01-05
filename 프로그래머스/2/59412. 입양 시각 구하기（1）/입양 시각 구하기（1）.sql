-- 코드를 입력하세요
SELECT hour(DATETIME) as HOUR, count(ANIMAL_ID) as COUNT
from ANIMAL_OUTS
where hour(DATETIME) between 9 AND 19
group by HOUR
order by HOUR;