-- 코드를 입력하세요
SELECT p.ID, p.NAME, p.HOST_ID
FROM PLACES p
join (
    select HOST_ID
    from places 
    group by HOST_ID
    HAVING count(*) >= 2
) h 
on p.HOST_ID = h.HOST_ID
order by p.ID;