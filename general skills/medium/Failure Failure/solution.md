# Failure Failure

## 題目描述 (Description)

Welcome to **Failure Failure** — a high-available system.
This challenge simulates a real-world failover scenario where one server is prioritized over the other.
A load balancer stands between you and the truth — and it won't hand over the flag until you force its hand.

### 提示 (Hints)

1. Hint 1
   How does a load balancer decide which server should get the traffic?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：看他後端的程式碼可以發現每分鐘請求超過 300 次時會觸發 ratelimit，反回 503

2.  **第二步**：`haproxy.cfg` 裡面的規則是每秒向後端發送 GET / 請求，連續失敗兩次 (回應不是 200) 的話就會把流量導到 backup

3.  **第三步**：於是使用 `vegeta` 發送請求，成功取得 flag
   ```
   ./vegeta attack -targets=123.txt -rate=50 -duration=90s | ./vegeta report 
   ```

## Flag

```text
picoCTF{f41l0v3r_f0r_7h3_w1n_73050a63}
```