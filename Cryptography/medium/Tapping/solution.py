MORSE_CODE = {
    'A': '.-',    'B': '-...',  'C': '-.-.',
    'D': '-..',   'E': '.',     'F': '..-.',
    'G': '--.',   'H': '....',  'I': '..',
    'J': '.---',  'K': '-.-',   'L': '.-..',
    'M': '--',    'N': '-.',    'O': '---',
    'P': '.--.',  'Q': '--.-',  'R': '.-.',
    'S': '...',   'T': '-',     'U': '..-',   
    'V': '...-',  'W': '.--',   'X': '-..-',  
    'Y': '-.--',  'Z': '--..',  '0': '-----', 
    '1': '.----', '2': '..---', '3': '...--', 
    '4': '....-', '5': '.....', '6': '-....', 
    '7': '--...', '8': '---..', '9': '----.',
    '{': '{',     '}':'}'
}

def morse_to_text(morse):
    reverse = {v: k for k, v in MORSE_CODE.items()}
    result = []

    for token in morse.split():
        if token == '/':
            result.append(' ')
        else:
            result.append(reverse.get(token, token))

    return ''.join(result)

str = input()
print(morse_to_text(str))