-- 코드를 작성해주세요
select distinct id, email, first_name, last_name
    from developers d, skillcodes s
    where (d.skill_code & s.code) > 0 
        and s.category = 'Front End'
    order by d.id;