# 유효한 팰린드롬
# 주어진 문자열이 팰린드롬인지 확인, 대소문자 구분 x, 영문자와 숫자만을 대상
# 팰린드롬 : 앞뒤가 똑같은 단어나 문장, 뒤집어도 같은 말

import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        # 1
        # 함수 re 사용해서 문자열 안의 특수문자 제거
        # 소문자로 변환, 공백 제거
        new_str = re.sub(r"[^\uAC00-\uD7A30-9a-zA-Z\s]", "", s).lower().replace(" ", "")
    
        # 2
        # 변환된 문자열을 알파벳 하나씩 리스트에 넣기
        # 밑의 for문에서 틀릴 경우를 담을 리스트 선언
        list_str = list(new_str)
        list_false = []

        # 3
        # list_str에서 맨앞과 맨 뒤가 같다면 계속, 틀리다면 list_false에 f를 추가
        for i in range(len(list_str)):
            if list_str[i] == list_str[-(i+1)]:
                continue
            else:
                list_false.append('f')
    
        # 4
        # list_false가 비어있다면 true반환, 비어있지 않다면 false 반환
        if list_false == []:
            return 'true'
        else:
            return 'false'

str1 = Solution()
str2 = Solution()
print(str1.isPalindrome("A man, a plan, a canal: Panama"))
print(str2.isPalindrome("race a car"))

# 리트 코드에서는 run time error

# 처음에 함수로 푼 것
# def palindrome(str):
#     # 함수 re 사용해서 문자열 안의 특수문자 제거
#     # 소문자로 변환, 공백 제거
#     new_str = re.sub(r"[^\uAC00-\uD7A30-9a-zA-Z\s]", "", str).lower().replace(" ", "")
    
#     # 2
#     # 변환된 문자열을 알파벳 하나씩 리스트에 넣기
#     # 밑의 for문에서 틀릴 경우를 담을 리스트 선언
#     list_str = list(new_str)
#     list_false = []

#     # 3
#     # list_str에서 맨앞과 맨 뒤가 같다면 계속, 틀리다면 list_false에 f를 추가
#     for i in range(len(list_str)):
#         if list_str[i] == list_str[-(i+1)]:
#             continue
#         else:
#             list_false.append('f')
    
#     # 4
#     # list_false가 비어있다면 true반환, 비어있지 않다면 false 반환
#     if list_false == []:
#         return 'true'
#     else:
#         return 'false'



