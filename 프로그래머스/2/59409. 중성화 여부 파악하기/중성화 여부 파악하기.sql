-- 코드를 입력하세요
select animal_id,
    name,
    if(sex_upon_intake regexp 'Neutered|Spayed', 'O', 'X') as '중성화'
from animal_ins
order by animal_id asc;
