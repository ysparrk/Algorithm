-- 코드를 입력하세요
select i.animal_id, i.animal_type, i.name
    from animal_ins i
    join animal_outs o
        on i.animal_id = o.animal_id
    where sex_upon_intake like 'Intact%' and 
        (sex_upon_outcome = 'Neutered Male' or sex_upon_outcome = 'Spayed Female');