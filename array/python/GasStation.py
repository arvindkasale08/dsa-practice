def canCompleteCircuit(gas, cost):
    if sum(gas) < sum(cost):    return -1
    n = len(gas)
    start = tank = 0
    for i in range(n):
        tank += gas[i]
        if tank < cost[i]:
            start = i + 1
            tank = 0
        else:   tank -= cost[i]
    return start

if __name__=='__main__':
    test_cases = [[[1,2,3,4,5], [3,4,5,1,2]],
                  [[2,3,4], [3,4,3]]]
    for gas, cost in test_cases:
        print(canCompleteCircuit(gas, cost))