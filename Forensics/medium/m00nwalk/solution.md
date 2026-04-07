# m00nwalk

## 題目描述 (Description)

Decode this [message](https://challenge-files.picoctf.net/c_fickle_tempest/67884a117da864fd93ca3cfc5d8b4d1aae71c84d7f3d2a89c1b5d0b3a19e0a71/message.wav) from the moon.

### 提示 (Hints)

1. Hint 1  
    How did pictures from the moon landing get sent back to Earth?
2. Hint 2  
    What is the CMU mascot?, that might help select a RX option

## 解題思路 (Solution Walkthrough)

1. **第一步**：我一開始以為是摩斯密碼，後來看提示以後發現是 SSTV 訊號，於是使用[這個網站](https://sstv-decoder.mathieurenaud.fr)並得到了圖片，flag 就在圖片上

## Flag

```text
picoCTF{beep_boop_im_in_space}
```
