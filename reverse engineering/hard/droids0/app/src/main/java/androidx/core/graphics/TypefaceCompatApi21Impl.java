package androidx.core.graphics;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi21Impl";

    TypefaceCompatApi21Impl() {
    }

    private File getFile(ParcelFileDescriptor fd) throws ErrnoException {
        try {
            String path = Os.readlink("/proc/self/fd/" + fd.getFd());
            if (!OsConstants.S_ISREG(Os.stat(path).st_mode)) {
                return null;
            }
            return new File(path);
        } catch (ErrnoException e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x005b A[Catch: all -> 0x005f, Throwable -> 0x0062, TryCatch #5 {Throwable -> 0x0062, blocks: (B:75:0x001a, B:77:0x0020, B:80:0x0027, B:84:0x0031, B:86:0x003e, B:102:0x005e, B:101:0x005b, B:100:0x0057), top: B:124:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[Catch: IOException -> 0x0079, SYNTHETIC, TRY_LEAVE, TryCatch #0 {IOException -> 0x0079, blocks: (B:74:0x000f, B:82:0x002d, B:88:0x0043, B:111:0x006c, B:115:0x0075, B:114:0x0071, B:116:0x0078), top: B:119:0x000f, inners: #3 }] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r11, android.os.CancellationSignal r12, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] r13, int r14) throws java.lang.Throwable {
        /*
            r10 = this;
            int r0 = r13.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L6
            return r1
        L6:
            androidx.core.provider.FontsContractCompat$FontInfo r0 = r10.findBestInfo(r13, r14)
            android.content.ContentResolver r2 = r11.getContentResolver()
            android.net.Uri r3 = r0.getUri()     // Catch: java.io.IOException -> L79
            java.lang.String r4 = "r"
            android.os.ParcelFileDescriptor r3 = r2.openFileDescriptor(r3, r4, r12)     // Catch: java.io.IOException -> L79
            java.io.File r4 = r10.getFile(r3)     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            if (r4 == 0) goto L31
            boolean r5 = r4.canRead()     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            if (r5 != 0) goto L27
            goto L31
        L27:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r4)     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            if (r3 == 0) goto L30
            r3.close()     // Catch: java.io.IOException -> L79
        L30:
            return r5
        L31:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            java.io.FileDescriptor r6 = r3.getFileDescriptor()     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            android.graphics.Typeface r6 = super.createFromInputStream(r11, r5)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L4a
            r5.close()     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.io.IOException -> L79
        L46:
            return r6
        L47:
            r6 = move-exception
            r7 = r1
            goto L50
        L4a:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L4c
        L4c:
            r7 = move-exception
            r9 = r7
            r7 = r6
            r6 = r9
        L50:
            if (r7 == 0) goto L5b
            r5.close()     // Catch: java.lang.Throwable -> L56 java.lang.Throwable -> L5f
            goto L5e
        L56:
            r8 = move-exception
            r7.addSuppressed(r8)     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
            goto L5e
        L5b:
            r5.close()     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
        L5e:
            throw r6     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L62
        L5f:
            r4 = move-exception
            r5 = r1
            goto L68
        L62:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L64
        L64:
            r5 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
        L68:
            if (r3 == 0) goto L78
            if (r5 == 0) goto L75
            r3.close()     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L79
            goto L78
        L70:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch: java.io.IOException -> L79
            goto L78
        L75:
            r3.close()     // Catch: java.io.IOException -> L79
        L78:
            throw r4     // Catch: java.io.IOException -> L79
        L79:
            r3 = move-exception
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
