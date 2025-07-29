-- 코드를 입력하세요
SELECT CART_ID
from CART_PRODUCTS
where NAME IN ('Milk', 'Yogurt')
group by cart_id
having count(DISTINCT name) > 1
order by cart_id;
