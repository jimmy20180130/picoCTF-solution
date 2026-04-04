# Ph4nt0m 1ntrud3r

## 題目描述 (Description)

A digital ghost has breached my defenses, and my sensitive data has been stolen! 😱💻 Your mission is to uncover how this phantom intruder infiltrated my system and retrieve the hidden flag.
To solve this challenge, you'll need to analyze the provided PCAP file and track down the attack method. The attacker has cleverly concealed his moves in well timely manner. Dive into the network traffic, apply the right filters and show off your forensic prowess and unmask the digital intruder!
Find the PCAP file here [Network Traffic PCAP file](https://challenge-files.picoctf.net/c_verbal_sleep/b6fbb3a5560749f838cdc6db4950985767c4691db3a7b34a220e5654ee39e700/myNetworkTraffic.pcap) and try to get the flag.

### 提示 (Hints)

1. Hint 1  
    Filter your packets to narrow down your search.
2. Hint 2  
    Attacks were done in timely manner.
3. Hint 3  
    Time is essential

## 解題思路 (Solution Walkthrough)

1. **第一步**：先用 wireshark 打開，可以看到 payload 都是 b64 encode 的

2. **第二步**：使用 `tshark -r myNetworkTraffic.pcap -Y "tcp.payload contains \"=\"" -T fields -e tcp.payload` 取得所有的資料，並把他轉成 b64 encoding

    ```text
    626e52666447673064413d3d
    577336396863383d
    4f492f70654b773d
    633636466c2b513d
    794c414d3851513d
    2b2f2f796d616b3d
    66513d3d
    596d68664e484a664d773d3d
    617a63634731733d
    41456957746f673d
    32376f37317a303d
    4e6d5930595459324e673d3d
    587a4d3063336c6664413d3d
    3169562b376b553d
    7565562f7738673d
    756b4c7235556f3d
    657a46305833633063773d3d
    596254394331513d
    4d3256596964413d
    63476c6a62304e5552673d3d
    5061644f7643343d
    4e5a4c422f5a773d
    ```

3. **第三步**：把可以轉成 ASCII 字元的資料保留下來，並嘗試拼湊，即可得到 flag

    ```text
    bnRfdGg0dA==         | nt_th4t
    fQ==                 | }
    YmhfNHJfMw==         | bh_4r_3
    NmY0YTY2Ng==         | 6f4a666
    XzM0c3lfdA==         | _34sy_t
    ezF0X3c0cw==         | {1t_w4s
    cGljb0NURg==         | picoCTF
    ```

## Flag

```text
picoCTF{1t_w4snt_th4t_34sy_tbh_4r_36f4a666}
```
