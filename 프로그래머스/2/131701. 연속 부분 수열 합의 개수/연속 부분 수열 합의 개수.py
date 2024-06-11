def solution(elements):
    
    nums = set()
    
    N = len(elements)
    elements = elements + elements
    
    for i in range(N):
        for j in range(N):
            nums.add(sum(elements[i:i+j]))
                  
    return len(nums)