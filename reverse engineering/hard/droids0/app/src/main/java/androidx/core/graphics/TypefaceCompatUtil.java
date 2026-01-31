package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    @Nullable
    public static File getTempFile(Context context) {
        String prefix = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(context.getCacheDir(), prefix + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[Catch: IOException -> 0x0032, TryCatch #1 {IOException -> 0x0032, blocks: (B:3:0x0001, B:5:0x0016, B:14:0x0025, B:19:0x0031, B:18:0x002e, B:17:0x002a), top: B:22:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer mmap(java.io.File r9) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L32
            r1.<init>(r9)     // Catch: java.io.IOException -> L32
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            long r6 = r2.size()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            r4 = 0
            java.nio.MappedByteBuffer r3 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            r1.close()     // Catch: java.io.IOException -> L32
            return r3
        L1a:
            r2 = move-exception
            r3 = r0
            goto L23
        L1d:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L1f
        L1f:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
        L23:
            if (r3 == 0) goto L2e
            r1.close()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L32
            goto L31
        L29:
            r4 = move-exception
            r3.addSuppressed(r4)     // Catch: java.io.IOException -> L32
            goto L31
        L2e:
            r1.close()     // Catch: java.io.IOException -> L32
        L31:
            throw r2     // Catch: java.io.IOException -> L32
        L32:
            r1 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatUtil.mmap(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[Catch: all -> 0x004e, Throwable -> 0x0051, TryCatch #4 {Throwable -> 0x0051, blocks: (B:8:0x0014, B:10:0x002d, B:26:0x004d, B:25:0x004a, B:24:0x0046), top: B:48:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[Catch: IOException -> 0x0068, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0068, blocks: (B:3:0x0005, B:6:0x0010, B:12:0x0032, B:35:0x005b, B:39:0x0064, B:38:0x0060, B:40:0x0067), top: B:45:0x0005, inners: #2 }] */
    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.ByteBuffer mmap(android.content.Context r11, android.os.CancellationSignal r12, android.net.Uri r13) throws java.lang.Throwable {
        /*
            android.content.ContentResolver r0 = r11.getContentResolver()
            r1 = 0
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r2 = r0.openFileDescriptor(r13, r2, r12)     // Catch: java.io.IOException -> L68
            if (r2 != 0) goto L14
        Le:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L68
        L13:
            return r1
        L14:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
            java.io.FileDescriptor r4 = r2.getFileDescriptor()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
            java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L39
            long r8 = r4.size()     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L39
            java.nio.channels.FileChannel$MapMode r5 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L39
            r6 = 0
            java.nio.MappedByteBuffer r5 = r4.map(r5, r6, r8)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L39
            r3.close()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.io.IOException -> L68
        L35:
            return r5
        L36:
            r4 = move-exception
            r5 = r1
            goto L3f
        L39:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L3b
        L3b:
            r5 = move-exception
            r10 = r5
            r5 = r4
            r4 = r10
        L3f:
            if (r5 == 0) goto L4a
            r3.close()     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L4e
            goto L4d
        L45:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
            goto L4d
        L4a:
            r3.close()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
        L4d:
            throw r4     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
        L4e:
            r3 = move-exception
            r4 = r1
            goto L57
        L51:
            r3 = move-exception
            throw r3     // Catch: java.lang.Throwable -> L53
        L53:
            r4 = move-exception
            r10 = r4
            r4 = r3
            r3 = r10
        L57:
            if (r2 == 0) goto L67
            if (r4 == 0) goto L64
            r2.close()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L68
            goto L67
        L5f:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch: java.io.IOException -> L68
            goto L67
        L64:
            r2.close()     // Catch: java.io.IOException -> L68
        L67:
            throw r3     // Catch: java.io.IOException -> L68
        L68:
            r2 = move-exception
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(Context context, Resources res, int id) {
        File tmpFile = getTempFile(context);
        ByteBuffer byteBufferMmap = null;
        if (tmpFile == null) {
            return null;
        }
        try {
            if (copyToFile(tmpFile, res, id)) {
                byteBufferMmap = mmap(tmpFile);
            }
            return byteBufferMmap;
        } finally {
            tmpFile.delete();
        }
    }

    public static boolean copyToFile(File file, InputStream is) throws IOException {
        FileOutputStream os = null;
        StrictMode.ThreadPolicy old = StrictMode.allowThreadDiskWrites();
        try {
            os = new FileOutputStream(file, false);
            byte[] buffer = new byte[1024];
            while (true) {
                int readLen = is.read(buffer);
                if (readLen == -1) {
                    return true;
                }
                os.write(buffer, 0, readLen);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
            return false;
        } finally {
            closeQuietly(os);
            StrictMode.setThreadPolicy(old);
        }
    }

    public static boolean copyToFile(File file, Resources res, int id) throws IOException {
        InputStream is = null;
        try {
            is = res.openRawResource(id);
            return copyToFile(file, is);
        } finally {
            closeQuietly(is);
        }
    }

    public static void closeQuietly(Closeable c) throws IOException {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }
}
