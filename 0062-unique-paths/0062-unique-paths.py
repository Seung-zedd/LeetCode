class Solution(object):
    def uniquePaths(self, m, n):
        arr = {}
        def fact(x):  # 0! or 1! = 1
            if x <= 1:
                return 1
            if x not in arr:  # x가 arr에 없으면 fact를 호출
                arr[x] = fact(x - 1) * x
            return arr[x]
        # 함수를 먼저 정의해야 함수를 호출할 수 있음
        return fact(m + n - 2) / (fact(m - 1) * fact(n - 1))