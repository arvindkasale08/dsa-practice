def is_safe(board, i, j, n):
    I, J = i, j
    i, j = i - 1, j - 1
    while i > -1 and j > -1:
        if board[i][j] == 'Q':    return False
        i -= 1
        j -= 1
    i, j = I - 1, J
    while i > -1:
        if board[i][j] == 'Q':    return False
        i -= 1
    i, j = I - 1, J + 1
    while i > -1 and j < n:
        if board[i][j] == 'Q':    return False
        i -= 1
        j += 1
    return True

def n_queen(board, i, n):
    if i == n:    return True
    for j in range(n):
        if is_safe(board, i, j, n):
            board[i][j] = 'Q'
            if n_queen(board, i + 1, n):    return True
            board[i][j] = '.'
    return False

if __name__=='__main__':
    n = 8
    board = [['.' for _ in range(n)] for _ in range(n)]
    n_queen(board, 0, n)
    for b in board:
        print(b)