def canCompleteCircuit(gas, cost):
    if sum(gas) < sum(cost):    return -1
    n = len(gas)
    start = curr_gas = 0
    for i in range(n):
        curr_gas += gas[i]
        if curr_gas < cost[i]:
            start = i + 1
            curr_gas = 0
        else:   curr_gas -= cost[i]
    return start

if __name__=='__main__':
    test_cases = [[[1,2,3,4,5], [3,4,5,1,2]],
                  [[2,3,4], [3,4,3]]]
    for gas, cost in test_cases:
        print(canCompleteCircuit(gas, cost))