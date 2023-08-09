import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    dp = [0] * 41
    dp[0] = 0
    dp[1] = 1

    for i in range(2,n+1):
        dp[i] = dp[i-1] + dp[i-2]

    if n == 0:
        print(1,0)
    elif n == 1:
        print(0,1)
    else:
        print(dp[n-1], dp[n])

