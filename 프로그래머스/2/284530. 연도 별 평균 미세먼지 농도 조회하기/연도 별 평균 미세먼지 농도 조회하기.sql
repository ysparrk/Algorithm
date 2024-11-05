-- 코드를 작성해주세요
select year(ym) as year, round(avg(pm_val1), 2) as pm10, round(avg(pm_val2), 2) as 'PM2.5'
from air_pollution
group by year, location1, location2
having location2 = '수원'
order by 1;