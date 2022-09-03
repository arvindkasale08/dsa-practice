def convert_num_to_word(num):
    THOUSANDS = ['', 'Thousand', 'Million', 'Billion']
    LESS_THAN_TWENTY = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven',
                        'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
    TENS = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

    def helper(num):
        h = num // 100
        t = ''
        if h:
            t = LESS_THAN_TWENTY[h] + ' Hundred '
        num %= 100
        if num < 20:
            t += LESS_THAN_TWENTY[num]
        else:
            tens = num // 10
            t += TENS[tens] + ' '
            num %= 10
            t += LESS_THAN_TWENTY[num] + ' '
        return t

    if num == 0:    return 'Zero'
    i, s = 0, ''
    while num:
        n = num % 1000
        if n:
            t = helper(n) + ' ' + THOUSANDS[i] + ' '
            s = t + s
        i += 1
        num //= 1000
    while '  ' in s:    s = s.replace('  ', ' ')
    return s.strip()

if __name__=='__main__':
    print(convert_num_to_word(123234))