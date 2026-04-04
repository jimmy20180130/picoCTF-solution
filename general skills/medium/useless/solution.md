# useless

## 題目描述 (Description)

There's an interesting script in the user's home directory

### 提示 (Hints)

(None)

## 解題思路 (Solution Walkthrough)

1. **第一步**：先使用 `ssh picoplayer@saturn.picoctf.net -p 54394` 連上伺服器

2. **第二步**：發現目錄裡有一個 `useless` 的檔案，應該是簡易版計算機

    ```sh
    #!/bin/bash
    # Basic mathematical operations via command-line arguments

    if [ $# != 3 ]
    then
        echo "Read the code first"
    else
            if [[ "$1" == "add" ]]
            then 
                sum=$(( $2 + $3 ))
                echo "The Sum is: $sum"  

            elif [[ "$1" == "sub" ]]
            then 
                sub=$(( $2 - $3 ))
                echo "The Substract is: $sub" 

            elif [[ "$1" == "div" ]]
            then 
                div=$(( $2 / $3 ))
                echo "The quotient is: $div" 

            elif [[ "$1" == "mul" ]]
            then
                mul=$(( $2 * $3 ))
                echo "The product is: $mul" 

            else
                echo "Read the manual"
            
            fi
    fi
    ```

3. **第三步**：看到底下有一行 `Read the manual`，於是使用 `man useless` 即可取得 flag

## Flag

```text
picoCTF{us3l3ss_ch4ll3ng3_3xpl0it3d_5136}
```
