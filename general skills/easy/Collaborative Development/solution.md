# Collaborative Development

## 題目描述 (Description)

My team has been working very hard on new features for our flag printing program! I wonder how they'll work together?
You can download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_titan/178/challenge.zip)

### 提示 (Hints)

1. Hint 1  
    `git branch -a` will let you see available branches
2. Hint 2  
    How can file 'diffs' be brought to the main branch? Don't forget to `git config`!
3. Hint 3  
    Merge conflicts can be tricky! Try a text editor like nano, emacs, or vim.

## 解題思路 (Solution Walkthrough)

1. **第一步**：先使用 `git branch -a`，看到有 `feature/part-1~3` 這幾個 branch

2. **第二步**：切換 branch 到 `feature/part-1`，使用 `git log`，即可發現 commit 歷史，接著使用 `git show` 即可看到 flag 的第一部分，重複以上步驟即可取得完整的 flag

## Flag

```text
picoCTF{t3@mw0rk_m@k3s_th3_dr3@m_w0rk_6c06cec1}
```
