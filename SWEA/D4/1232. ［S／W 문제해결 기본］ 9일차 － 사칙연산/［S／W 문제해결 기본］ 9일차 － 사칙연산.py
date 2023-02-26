# 1
# 후위순회 함수
def post_odrer(v):
    if v:
        post_odrer(left[v])
        post_odrer(right[v])
        if tree[v] == '+':  # tree[v]가 연산자라면
            tree[v] = int(tree[left[v]]) + int(tree[right[v]])
        elif tree[v] == '-':
            tree[v] = int(tree[left[v]]) - int(tree[right[v]])
        elif tree[v] == '*':
            tree[v] = int(tree[left[v]]) * int(tree[right[v]])
        elif tree[v] == '/':
            tree[v] = int(tree[left[v]]) // int(tree[right[v]])
    return

# 2
T = 10
for tc in range(1, T + 1):
    # 2-1 초기설정
    V = int(input())
    tree = [0] * (V + 1)  # 숫자, 연산자 부분 넣기
    left = [0] * (V + 1)
    right = [0] * (V + 1)

    # 2-2
    # tree, left, right 채우기
    for _ in range(V):
        nums = list(map(str, input().split()))
        tree[int(nums[0])] = nums[1] # idx 1번자리 넣기/자식 인덱스로 부모 채우기

        if len(nums) == 4: # 연산자가 있는 부모 노드라면, 부모의 idx에 자식 노드 번호 저장
            left[int(nums[0])] = int(nums[2])
            right[int(nums[0])] = int(nums[3])

    post_odrer(1)
    print(f'#{tc} {tree[1]}')