# KSECRETS

## 題目描述 (Description)

We have a kubernetes cluster setup and flag is in the secrets. You think you can get it?

### 提示 (Hints)

1. Hint 1  
    Where are secrets usually stored in Kubernetes
2. Hint 2  
    How are Kubernetes secrets stored internally? Can you decode them?
3. Hint 3  
    Please ignore TLS

## 解題思路 (Solution Walkthrough)

1. **第一步**：根據題目敘述，可以下載下來一個 K8s 的設定檔，裡面包含了可以連線到遠端 Kubernetes 叢集所需的憑證，先把 server 改成題目中的 server

2. **第二步**：使用 `kubectl --kubeconfig=kubeconfig.yaml --insecure-skip-tls-verify=true get namespaces` 來取得 namespaces，這裡要 ignore tls

    ```text
    NAME              STATUS   AGE
    default           Active   2m37s
    kube-node-lease   Active   2m37s
    kube-public       Active   2m37s
    kube-system       Active   2m37s
    picoctf           Active   2m24s
    ```

3. **第三步**：使用 `kubectl --kubeconfig=kubeconfig.yaml --insecure-skip-tls-verify=true get secrets -n picoctf` 來列出 secrets

    ```text
    NAME         TYPE     DATA   AGE
    ctf-secret   Opaque   1      4m7s
    ```

4. **第四步**：使用 `kubectl --kubeconfig=kubeconfig.yaml --insecure-skip-tls-verify=true get secret ctf-secret -n picoctf -o yaml` 來取得 ctf-secret，把 flag 拿去 base64 decode 即為 flag

    ```yaml
    apiVersion: v1
    data:
        flag: cGljb0NURntrczNjcjM3NV80MW43X3M0ZjNfYzg0ODAxNjV9Cg==
    kind: Secret
    metadata:
        annotations:
            kubectl.kubernetes.io/last-applied-configuration: |
                {"apiVersion":"v1","data":{"flag":"cGljb0NURntrczNjcjM3NV80MW43X3M0ZjNfYzg0ODAxNjV9Cg=="},"kind":"Secret","metadata":{"annotations":{},"name":"ctf-secret","namespace":"picoctf"},"type":"Opaque"}
        creationTimestamp: "2026-04-04T13:41:31Z"
        name: ctf-secret
        namespace: picoctf
        resourceVersion: "386"
        uid: a5a5496b-c894-4940-9018-28c524a4a815
    type: Opaque
    ```

## Flag

```text
picoCTF{ks3cr375_41n7_s4f3_c8480165}
```

## 參考資料

1. https://zenn.dev/tetsurou/articles/7d795a69886b6b#ksecrets---100pt