# 0. input
k = int(input())

# 2. method
# 공백 여러개 하나로
def trim(s):
    return ' '.join(s.split())

# 특수 문자 전후 공백 없앰
def trin_icon(s):
    special_chars = ['(', ')', ',', '.', ':']
    for char in special_chars:
        s = s.replace(f' {char}', char).replace(f'{char} ', char)
    return s

# 3.
for i in range(1, k + 1):
    s1 = input().strip().lower()
    s2 = input().strip().lower()

    # 괄호 -> 소괄호
    s1 = s1.replace('[', '(').replace('{', '(').replace(']', ')').replace('}', ')')
    s2 = s2.replace('[', '(').replace('{', '(').replace(']', ')').replace('}', ')')

    # 세미콜론 -> 쉼표
    s1 = s1.replace(';', ',')
    s2 = s2.replace(';', ',')

    # 연속된 공백 처리 후 -> 특수문자 전후 공백 제거
    s1 = trin_icon(trim(s1))
    s2 = trin_icon(trim(s2))


    if s1 == s2:
        print(f'Data Set {i}: equal')
    else:
        print(f'Data Set {i}: not equal')
        
    print()