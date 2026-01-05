-- 코드를 입력하세요
SELECT f.category, f.price as max_price, f.product_name
from food_product f
join (
    select category, max(price) as max_price
    from food_product
    where category in ('과자', '국', '김치', '식용유')
    group by category
) p
on f.category = p.category
and f.price = p.max_price
order by f.price DESC;

