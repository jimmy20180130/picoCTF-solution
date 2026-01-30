function rot26Decrypt(message) {
    let result = '';
    for (let i = 0; i < message.length; i++) {
        let char = message[i];
        if (char >= 'a' && char <= 'z') {
            let shiftedCharCode = ((char.charCodeAt(0) - 97 - 13 + 26) % 26) + 97;
            result += String.fromCharCode(shiftedCharCode);
        } else if (char >= 'A' && char <= 'Z') {
            let shiftedCharCode = ((char.charCodeAt(0) - 65 - 13 + 26) % 26) + 65;
            result += String.fromCharCode(shiftedCharCode);
        } else {
            result += char;
        }
    }

    return result;
}

console.log(rot26Decrypt('cvpbPGS{arkg_gvzr_V\'yy_gel_2_ebhaqf_bs_ebg13_45559noq}'))