# vault-door-training

## 題目描述 (Description)

Your mission is to enter Dr. Evil's laboratory and retrieve the blueprints for his Doomsday Project. The laboratory is protected by a series of locked vault doors. Each door is controlled by a computer and requires a password to open. Unfortunately, our undercover agents have not been able to obtain the secret passwords for the vault doors, but one of our junior agents obtained the source code for each vault's computer! You will need to read the source code for each level to figure out what the password is for that vault door. As a warmup, we have created a replica vault in our training facility.
The source code for the training vault is here: [VaultDoorTraining.java](https://challenge-files.picoctf.net/c_fickle_tempest/f2743327a75583885f4aa22e3c9856618fd0e95dbfa56f1bf889bd322a45f1a2/VaultDoorTraining.java)

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看到程式碼發現這段，基本上就是 userInput.substring(8, userInput.length()-1)，基本上就是看使用者的 input 去掉 `picoCTF{` 和 `}` 後是否等於 `w4rm1ng_Up_w1tH_jAv4_000iPnsaWOY`
   ```Java
   String input = userInput.substring("picoCTF{".length(),userInput.length()-1);
   ```

2.  **第二步**：照上面的邏輯直接把 `picoCTF{}` 加上 `w4rm1ng_Up_w1tH_jAv4_000iPnsaWOY`，最後再加上 `}` 即為 flag

## Flag

```text
picoCTF{w4rm1ng_Up_w1tH_jAv4_000iPnsaWOY}
```