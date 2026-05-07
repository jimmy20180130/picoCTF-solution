def solve(n):
    count_of_ones = bin(n & 0xFFFFFFFF).count('1')
    return count_of_ones * 3

input_val = 4101707659
print(f"Result: {solve(input_val)}")