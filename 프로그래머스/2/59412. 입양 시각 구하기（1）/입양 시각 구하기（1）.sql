-- 코드를 입력하세요
select hour(datetime) hour, count(datetime) count
    from animal_outs
    group by hour(datetime)
    having hour >= 9 and hour <= 19
    order by hour;