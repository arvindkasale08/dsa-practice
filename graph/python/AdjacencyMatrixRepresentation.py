def add_edge(matrix, src, dest):
    matrix[src][dest] = 1
    matrix[dest][src] = 1

if __name__=='__main__':
    n = 5
    matrix = [[0 for _ in range(5)] for _ in range(5)]
    add_edge(matrix, 0, 1)
    add_edge(matrix, 0, 4)
    add_edge(matrix, 1, 2)
    add_edge(matrix, 1, 3)
    add_edge(matrix, 1, 4)
    add_edge(matrix, 2, 3)
    add_edge(matrix, 3, 4)
    for m in matrix:
        print(m)