-- 코드를 작성해주세요
select id, length
    from fish_info
    order by ifnull(length, 10) desc, id
    limit 10;