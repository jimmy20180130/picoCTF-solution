# Wave a flag

## 題目描述 (Description)

Can you invoke help flags for a tool or binary? This program has extraordinarily helpful information...
[warm](https://challenge-files.picoctf.net/c_wily_courier/fc72a950cbaa130f81486c2df35deced17604b2c08c6a5aa99d18168036d3107/warm)

### 提示 (Hints)

1. Hint 1  
    This program will only work in the webshell or another Linux computer.
2. Hint 2  
    To get the file accessible in your shell, enter the following in the Terminal prompt: $ wget <URL here>, where the url can be found in the details section.
3. Hint 3  
    Run this program by entering the following in the Terminal prompt: $ ./warm, but you'll first have to make it executable with $ chmod +x warm
4. Hint 4  
    -h and --help are the most common arguments to give to programs to get more information from them!
5. Hint 5  
    Not every program implements help features like -h and --help.

## 解題思路 (Solution Walkthrough)

1. **第一步**：下載下來以後用 `grep` 即可取得 flag

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ strings warm | grep -o "picoCTF{.*}"                                                                 
    picoCTF{b1scu1ts_4nd_gr4vy_ac5832c}
    ```

## Flag

```text
picoCTF{b1scu1ts_4nd_gr4vy_ac5832c}
```
