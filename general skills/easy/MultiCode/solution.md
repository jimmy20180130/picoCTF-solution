# MultiCode

## 題目描述 (Description)

We intercepted a suspiciously encoded message, but it’s clearly hiding a flag. No encryption, just multiple layers of obfuscation. Can you peel back the layers and reveal the truth?
Download the [message](https://challenge-files.picoctf.net/c_plain_mesa/453281f153c7ca52eaab563255119c4849a163af823ae09402dc0b448746b58c/message.txt).

### 提示 (Hints)

1. Hint 1  
    The flag has been wrapped in several layers of common encodings such as ROT13, URL encoding, Hex, and Base64. Can you figure out the order to peel them back?
2. Hint 2  
    A tool like CyberChef can be interesting.

## 解題思路 (Solution Walkthrough)

1. **第一步**：先 base64 decode，會得到 `637670625047532537426172666772715f72617030717661745f3070323139327137253744`

2. **第二步**：轉換為 hex string 以後為 `cvpbPGS%7Barfgrq_rap0qvat_0p2192q7%7D`

3. **第三步**：url decode 以後再放入 rot13，即可得到 flag

## Flag

```text
picoCTF{nested_enc0ding_0c2192d7}
```
