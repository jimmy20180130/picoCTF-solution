# Binary Search

## 題目描述 (Description)

Want to play a game? As you use more of the shell, you might be interested in how they work! Binary search is a classic algorithm used to quickly find an item in a sorted list. Can you find the flag? You'll have 1000 possibilities and only 10 guesses.
Cyber security often has a huge amount of data to look through - from logs, vulnerability reports, and forensics. Practicing the fundamentals manually might help you in the future when you have to write your own tools!
You can download the challenge files here:
- [challenge.zip](https://artifacts.picoctf.net/c_atlas/6/challenge.zip)

### 提示 (Hints)

1. Hint 1  
    Have you ever played hot or cold? Binary search is a bit like that.
2. Hint 2  
    You have a very limited number of guesses. Try larger jumps between numbers!
3. Hint 3  
    The program will randomly choose a new number each time you connect. You can always try again, but you should start your binary search over from the beginning - try around 500. Can you think of why?

## 解題思路 (Solution Walkthrough)

1. **第一步**：基本上就是 1~1000 猜一個數字，一開始先猜 500，如果說更大的話就猜 750，更小就猜 250，以此類推

## Flag

```text
picoCTF{g00d_gu355_de9570b0}
```
