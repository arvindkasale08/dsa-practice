from collections import defaultdict

def topological_sort(v, graph, mark, visited, res):
    for i in graph[v]:
        mark[i] -= 1
        if mark[i] == 0 and not visited[i]:
            res.append(i)
            visited[i] = 1
            topological_sort(i, graph, mark, visited, res)

def check_vertex(graph, mark, num_courses, res):
    visited = defaultdict(list)
    for i in range(num_courses + 1):
        if not mark[i]:
            if not visited[i]:
                if graph[i]:
                    res.append(i)
                    visited[i] = 1
                    topological_sort(i, graph, mark, visited, res)
    flag = False
    for m in mark:
        if mark[m] == 1:
            flag = True
    if flag:
        res = []
    return res

def course_schedule(num_courses, prerequisites):
    res = []
    if not prerequisites:
        for i in range(num_courses - 1, -1, -1):
            res.append(i)
        return res
    graph = defaultdict(list)
    mark = defaultdict(int)
    for course in prerequisites:
        graph[course[0]].append(course[1])
        mark[course[1]] += 1
        if not graph[course[1]]:
            graph[course[1]] = []
    res = check_vertex(graph, mark, num_courses, res)
    if len(res) > 0 and len(res) < num_courses:
        for i in range(num_courses):
            if i not in res:
                res.append(i)
    res.reverse()
    return res

if __name__=='__main__':
    print(course_schedule(1, []))