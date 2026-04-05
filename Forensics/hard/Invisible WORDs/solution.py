def process_binary_file(input_path, output_path):
    with open(input_path, 'rb') as f_in:
        data = f_in.read()
    
    restored = bytearray()
    
    # 每 4 bytes 一個循環
    for i in range(0, len(data), 4):
        chunk = data[i:i+4]
        # 保留前 2 bytes (索引 0, 1)，移除後 2 bytes (索引 2, 3)
        if len(chunk) >= 2:
            restored.extend(chunk[0:2])
            
    with open(output_path, 'wb') as f_out:
        f_out.write(restored)
    print(f"處理完成！結果已存至 {output_path}")

process_binary_file('output.bmp', 'output.zip')