def sudoku_solver(board):
    def solved(board):
        for i in range(n):
            if '.' in board[i]:    return False
        return True
    
    def is_safe(board, i, j, val):
        if row[i][val] or col[j][val] or cell[cell_number(i, j)][val]:    return False
        return True
    
    def solve_sudoku(board):
        if solved(board):    return True
        for i in range(n):
            for j in range(n):
                if board[i][j] == '.':
                    res = True
                    for k in range(1, 10):
                        if is_safe(board, i, j, k):
                            res = False
                            board[i][j] = str(k)
                            row[i][k] = 1
                            col[j][k] = 1
                            cell[cell_number(i, j)][k] = 1
                            if solve_sudoku(board):    return True
                            board[i][j] = '.'
                            row[i][k] = 0
                            col[j][k] = 0
                            cell[cell_number(i, j)][k] = 0
                    if res or board[i][j] == '.':    return False
    n = 9
    cell_number = lambda row, col: ((row // 3) * 3) + (col // 3)
    row = [[0 for _ in range(10)] for _ in range(10)]
    col = [[0 for _ in range(10)] for _ in range(10)]
    cell = [[0 for _ in range(10)] for _ in range(10)]
    for i in range(n):
        for j in range(n):
            if board[i][j] != '.':
                val = int(board[i][j])
                row[i][val] = 1
                col[j][val] = 1
                cell[cell_number(i, j)][val] = 1
    solve_sudoku(board)
    return board

if __name__=='__main__':
    board = [["5","3",".",".","7",".",".",".","."],
             ["6",".",".","1","9","5",".",".","."],
             [".","9","8",".",".",".",".","6","."],
             ["8",".",".",".","6",".",".",".","3"],
             ["4",".",".","8",".","3",".",".","1"],
             ["7",".",".",".","2",".",".",".","6"],
             [".","6",".",".",".",".","2","8","."],
             [".",".",".","4","1","9",".",".","5"],
             [".",".",".",".","8",".",".","7","9"]]
    board = sudoku_solver(board)
    for b in board:
        print(b)