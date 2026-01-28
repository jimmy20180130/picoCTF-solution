# Log Hunt

## 題目描述 (Description)

Our server seems to be leaking pieces of a secret flag in its logs. The parts are scattered and sometimes repeated. Can you reconstruct the original flag?
Download the [logs](https://challenge-files.picoctf.net/c_amiable_citadel/49cec6157142f24a599f4164d5b63322c2494f801390d6f22eb91b3aa592bc66/server.log) and figure out the full flag from the fragments.

### 提示 (Hints)

1. Hint 1
   You can use grep to filter only matching lines from the log.
2. Hint 2
   Some lines are duplicates; ignore extra occurrences.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載 server.log 以後，我發現有開頭有一串 `INFO FLAGPART: picoCTF{us3_`

2.  **第二步**：之後用尋找功能搜尋 `FLAGPART` 並找到以下結果
   ```
   [1990-08-09 10:00:10] INFO FLAGPART: picoCTF{us3_
   [1990-08-09 10:02:55] INFO FLAGPART: y0urlinux_
   [1990-08-09 10:05:54] INFO FLAGPART: sk1lls_
   [1990-08-09 10:05:55] INFO FLAGPART: sk1lls_
   [1990-08-09 10:10:54] INFO FLAGPART: cedfa5fb}
   [1990-08-09 10:10:58] INFO FLAGPART: cedfa5fb}
   [1990-08-09 10:11:06] INFO FLAGPART: cedfa5fb}
   ...
   ```

3.  **第三步**：提取 Flag。
    *   將上述字串組合完後會發現 flag 為 `picoCTF{us3_y0urlinux_sk1lls_cedfa5fb}`。

## Flag

```text
picoCTF{us3_y0urlinux_sk1lls_cedfa5fb}
```