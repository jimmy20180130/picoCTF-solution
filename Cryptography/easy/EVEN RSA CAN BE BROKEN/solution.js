function modInv(a, m) {
    let [x0, x1, r0, r1] = [BigInt(1), BigInt(0), a, m];
    while (r1) {
        const q = r0 / r1;
        [r0, r1] = [r1, r0 - q * r1];
        [x0, x1] = [x1, x0 - q * x1];
    }
    return x0 < 0 ? x0 + m : x0;
}

function modPow(base, exp, mod) {
    let res = BigInt(1);
    base %= mod;
    while (exp > 0) {
        if (exp % 2n) res = (res * base) % mod;
        exp /= 2n;
        base = (base * base) % mod;
    }
    return res;
}

const n = BigInt('16636768217368339289891682920816090285440190983961425525967115667926643866528664250197607406204437919882794925457858827204142882676702533775506073752579414');
const e = 65537n;
const c = BigInt('10467280955887798588447777982830707902225986308851750542892411129830553759927485006670721545272711204770530827784171133909888990488475059115256464139582617');

// n is even -> p = 2
const p = 2n, q = n / p;
const phi = (p - 1n) * (q - 1n);
const d = modInv(e, phi);
const m = modPow(c, d, n);

// convert to utf-8
let hex = m.toString(16);
if (hex.length % 2) hex = '0' + hex;
console.log('flag:', Buffer.from(hex, 'hex').toString('utf-8'));
