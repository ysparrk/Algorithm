-- 코드를 작성해주세요
select count(*) as fish_count
    from fish_info
    where ifnull(length, 0) < 10;