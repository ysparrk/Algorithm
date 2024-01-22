# 1. input
T = int(input())

# 2.
for _ in range(T):

    str = input()
    N = len(str)
    del_flag, pal_flag = False, True

    # 1) 팰린드롬 확인
    left, right = 0, N - 1
    while left < right:
        if str[left] == str[right]:
            left += 1
            right -= 1
        elif del_flag == False:
            del_flag = True
            if str[left+1:right+1] == str[left+1:right+1][::-1]:
                break
            elif str[left:right] == str[left:right][::-1]:
                break
            else:
                pal_flag = False
                break
        else:
            pal_flag = False
            break


    # 3. result
    if pal_flag == True and del_flag == False:
        print("0")
    elif pal_flag == True and del_flag == True:
        print("1")
    else:
        print("2")