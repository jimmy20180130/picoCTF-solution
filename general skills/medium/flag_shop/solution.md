# flag_shop

## 題目描述 (Description)

There's a flag shop selling stuff, can you buy a flag?
Source. Connect with nc fickle-tempest.picoctf.net 61506.

### 提示 (Hints)

1. Hint 1
   Two's compliment can do some weird things when numbers get really big!

## 解題思路 (Solution Walkthrough)

1.  **第一步**：先nc到上面的port，然後會有以下文字出現：
```text
Welcome to the flag exchange
We sell flags

1. Check Account Balance

2. Buy Flags

3. Exit

 Enter a menu selection
```
   底下可以輸入1、2、3
   輸入1後可以發現預設有1100元
   輸入3會直接退出
   輸入2後會出現以下選項：
```text
Currently for sale
1. Defintely not the flag Flag
2. 1337 Flag
```
   以下是輸入1的結果：
```text
These knockoff Flags cost 900 each, enter desired quantity
```
   以下是輸入2的結果；
```text
1337 flags cost 100000 dollars, and we only have 1 in stock
Enter 1 to buy one
```
2.  **第二步**：現在看起來只有2可以讓我們更改錢包，想辦法拿到十萬塊
   所以我先輸入2再輸入1，進入買旗子頁面，輸入9999999999999後，
   再檢查錢包餘額，發現它溢位了
```text
Balance: 889555796
```
   此時進入購買1337 flags的頁面，輸入1確認購買，就可以得到flag了。
```text
YOUR FLAG IS: picoCTF{m0n3y_bag5_39AF2bE1}
```

## Flag

```text
picoCTF{m0n3y_bag5_39AF2bE1}
```