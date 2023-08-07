# 1. 날짜를 dates로 환산
def time_convert(t) :
    year, month, date = map(int, t.split('.'))
    return (year * 12 * 28) + (month * 28) + date

# 2. 결과
def solution(today, terms, privacies):
    term_dict = dict()
    today = time_convert(today)
    answer = []    
    
    for term in terms :
        code, period = term.split()
        term_dict[code] = int(period) * 28  # dates 계산
    
    for idx, privacy in enumerate(privacies) :
        start, code = privacy.split()
        end = time_convert(start) + term_dict[code]
        if end <= today :
            answer.append(idx+1)    
    
    return answer