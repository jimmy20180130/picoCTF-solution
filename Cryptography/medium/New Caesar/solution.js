const LOWERCASE_OFFSET = 'a'.charCodeAt(0);
const ALPHABET = 'abcdefghijklmnop';
const enc = 'fegdeogdgecoeocgcgchcfcffccfca';

function unshift(c, k) {
    const t1 = c.charCodeAt(0) - LOWERCASE_OFFSET;
    const t2 = k.charCodeAt(0) - LOWERCASE_OFFSET;
    return ALPHABET[(t1 - t2 + ALPHABET.length) % ALPHABET.length];
}

function b16_decode(encoded) {
    let result = '';

    for (let i = 0; i < encoded.length; i += 2) {
        const high = ALPHABET.indexOf(encoded[i]);
        const low = ALPHABET.indexOf(encoded[i + 1]);
        
        const charCode = (high << 4) | low;
        result += String.fromCharCode(charCode);
    }
    return result;
}

function decrypt(encrypted, key) {
    let b16 = '';
    for (let i = 0; i < encrypted.length; i++) {
        b16 += unshift(encrypted[i], key[i % key.length]);
    }
    
    const plaintext = b16_decode(b16);
    return plaintext;
}

for (let i = 0; i < ALPHABET.length; i++) {
    const key = ALPHABET[i];
    const decrypted = decrypt(enc, key);
    
    console.log(`key[${key}]: ${decrypted}`);
}