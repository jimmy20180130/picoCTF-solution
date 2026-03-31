# ClusterRSA

## 題目描述 (Description)

A message has been encrypted using RSA, but this time something feels... more crowded than usual. Can you decrypt it?
Download the [message](https://challenge-files.picoctf.net/c_plain_mesa/9f1083eba391ec3052a8a0e8c92b61ab7775589f730a7a4d0b5fdb1bf1c0323c/message.txt).

### 提示 (Hints)

1. Hint 1
   RSA usually means two primes... but what if someone got greedy?
2. Hint 2
   Prime factors decomposition

## 解題思路 (Solution Walkthrough)

1.  **第一步**：照慣例先去 factordb 查詢題目中 [n 的值因數分解](https://factordb.com/index.php?query=8749002899132047699790752490331099938058737706735201354674975134719667510377522805717156720453193651)

2.  **第二步**：發現它是由四個質數相乘得到的數
   ```
   9671406556917033397931773<25> · 9671406556917033398314601<25> · 9671406556917033398439721<25> · 9671406556917033398454847<25>
   ```

3.  **第三步**：因為這題是 Multi-Prime RSA，參考[這個網站](https://maojui.me/Crypto/Multi-prime-RSA/)上的資料後，得知取得 ϕ(N) 的方法是 (p−1)×(q−1)×(r−1)×(s−1)
   
## Flag

```text
picoCTF{mul71_rsa_787c01b3}
```