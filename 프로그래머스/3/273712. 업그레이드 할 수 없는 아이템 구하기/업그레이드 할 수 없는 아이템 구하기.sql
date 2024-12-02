-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info
where item_id not in (
    select parent_item_id
    from item_tree
    where not isnull(parent_item_id)
)
order by item_id desc;