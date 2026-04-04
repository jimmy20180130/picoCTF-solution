# Static ain't always noise

## 題目描述 (Description)

Can you look at the data in this binary? The bash script might help!
[static](https://challenge-files.picoctf.net/c_wily_courier/34dfb62cf2c94a618c7cdc292ff1c4062b104773695071e9a16ab25ad8cc935c/static), [ltdis.sh](https://challenge-files.picoctf.net/c_wily_courier/34dfb62cf2c94a618c7cdc292ff1c4062b104773695071e9a16ab25ad8cc935c/ltdis.sh)

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1. **第一步**：使用 `ltdis.sh` 提取出 static 的 strings 以後，用 grep 即可得到 flag

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ ./ltdis.sh static           
    Attempting disassembly of static ...
    Disassembly successful! Available at: static.ltdis.x86_64.txt
    Ripping strings from binary with file offsets...
    Any strings found in static have been written to static.ltdis.strings.txt with file offset
                                                                                                                                                                                                                
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ strings static.ltdis.strings.txt | grep -o "picoCTF{.*}"                                                                    
    picoCTF{d15a5m_t34s3r_20335e41}
    ```

## Flag

```text
picoCTF{d15a5m_t34s3r_20335e41}
```
