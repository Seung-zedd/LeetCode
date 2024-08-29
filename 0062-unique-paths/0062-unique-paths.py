class Solution(object):
    def uniquePaths(self, m, n):
        # Bottom-up approach(tabulation)
        table = {0: 1, 1: 1}

        def fact(x):  # 0! or 1! = 1
            for i in range(2, x + 1):  # x가 arr에 없으면 fact를 호출
                table[i] = table[i - 1] * i
            return table[x]
        # 함수를 먼저 정의해야 함수를 호출할 수 있음
        return fact(m + n - 2) / (fact(m - 1) * fact(n - 1))