s = 'jU5t_a_sna_3lpm1cg04e_u_4_m6rb42'
password = [''] * len(s)

i = 0

while i < 8:
    password[i] = s[i]
    i += 1

while i < 16:
    password[23 - i] = s[i]
    i += 1

while i < 32:
    password[46 - i] = s[i]
    i += 2

i = 31
while i >= 17:
    password[i] = s[i]
    i -= 2

print(''.join(password))