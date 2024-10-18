-- 코드를 입력하세요
-- 2021년 가입 / 상품 구매 회원수 / 가입한 전체 회원 수 비율 년, 월별로 출력
select 
    date_format(os.sales_date, '%Y') as year,
    date_format(os.sales_date, '%m') as month,
    count(distinct ui.user_id) as purchased_users,
    round(count(distinct ui.user_id) / (select count(*) from user_info where joined like '2021%'), 1) as purchased_ratio
    from user_info ui
    join online_sale os
        on ui.user_id = os.user_id
    where ui.joined like '2021%'
    group by year, month
    order by year, month;