numbers = '''112 
105 
99 
111 
67 
84 
70 
123 
103 
48 
48 
100 
95 
107 
49 
116 
116 
121 
33 
95 
110 
49 
99 
51 
95 
107 
49 
116 
116 
121 
33 
95 
97 
57 
52 
101 
55 
125 
10 '''

numbers = [chr(int(i)) for i in numbers.split('\n')]
print(''.join(numbers))