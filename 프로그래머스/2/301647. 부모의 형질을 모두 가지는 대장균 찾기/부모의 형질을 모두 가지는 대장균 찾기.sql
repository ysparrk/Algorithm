-- 코드를 작성해주세요
select ed1.id, ed1.genotype, ed2.genotype as parent_genotype
    from ecoli_data ed1
    inner join ecoli_data ed2
        on ed1.parent_id = ed2.id
    where ed1.genotype & ed2.genotype = ed2.genotype
    order by ed1.id asc;