package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class mFontFamily;
    protected final Constructor mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method abortCreation;
        Class fontFamily;
        Constructor fontFamilyCtor;
        Method addFontFromAssetManager;
        Method addFontFromAssetManager2;
        Method addFontFromBuffer;
        Method freeze;
        try {
            fontFamily = obtainFontFamily();
            fontFamilyCtor = obtainFontFamilyCtor(fontFamily);
            addFontFromAssetManager = obtainAddFontFromAssetManagerMethod(fontFamily);
            addFontFromAssetManager2 = obtainAddFontFromBufferMethod(fontFamily);
            addFontFromBuffer = obtainFreezeMethod(fontFamily);
            freeze = obtainAbortCreationMethod(fontFamily);
            abortCreation = obtainCreateFromFamiliesWithDefaultMethod(fontFamily);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            abortCreation = null;
            fontFamily = null;
            fontFamilyCtor = null;
            addFontFromAssetManager = null;
            addFontFromAssetManager2 = null;
            addFontFromBuffer = null;
            freeze = null;
        }
        this.mFontFamily = fontFamily;
        this.mFontFamilyCtor = fontFamilyCtor;
        this.mAddFontFromAssetManager = addFontFromAssetManager;
        this.mAddFontFromBuffer = addFontFromAssetManager2;
        this.mFreeze = addFontFromBuffer;
        this.mAbortCreation = freeze;
        this.mCreateFromFamiliesWithDefault = abortCreation;
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.mAddFontFromAssetManager != null;
    }

    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromAssetManager(Context context, Object family, String fileName, int ttcIndex, int weight, int style, @Nullable FontVariationAxis[] axes) {
        try {
            Boolean result = (Boolean) this.mAddFontFromAssetManager.invoke(family, context.getAssets(), fileName, 0, false, Integer.valueOf(ttcIndex), Integer.valueOf(weight), Integer.valueOf(style), axes);
            return result.booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromBuffer(Object family, ByteBuffer buffer, int ttcIndex, int weight, int style) {
        try {
            Boolean result = (Boolean) this.mAddFontFromBuffer.invoke(family, buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Integer.valueOf(style));
            return result.booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface createFromFamiliesWithDefault(Object family) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object familyArray = Array.newInstance((Class<?>) this.mFontFamily, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, familyArray, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean freeze(Object family) {
        try {
            Boolean result = (Boolean) this.mFreeze.invoke(family, new Object[0]);
            return result.booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void abortCreation(Object family) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.mAbortCreation.invoke(family, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object objNewFamily = newFamily();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!addFontFromAssetManager(context, objNewFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                abortCreation(objNewFamily);
                return null;
            }
        }
        if (freeze(objNewFamily)) {
            return createFromFamiliesWithDefault(objNewFamily);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[Catch: IOException -> 0x0071, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0071, blocks: (B:8:0x001d, B:11:0x002e, B:15:0x0051, B:26:0x0063, B:31:0x006d, B:30:0x0069, B:32:0x0070), top: B:54:0x001d, inners: #3 }] */
    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r20, @androidx.annotation.Nullable android.os.CancellationSignal r21, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] r22, int r23) throws java.lang.Throwable {
        /*
            r19 = this;
            r7 = r19
            r8 = r21
            r9 = r22
            r10 = r23
            int r0 = r9.length
            r1 = 1
            r11 = 0
            if (r0 >= r1) goto Le
            return r11
        Le:
            boolean r0 = r19.isFontFamilyPrivateAPIAvailable()
            if (r0 != 0) goto L73
            androidx.core.provider.FontsContractCompat$FontInfo r1 = r7.findBestInfo(r9, r10)
            android.content.ContentResolver r2 = r20.getContentResolver()
            android.net.Uri r0 = r1.getUri()     // Catch: java.io.IOException -> L71
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r0 = r2.openFileDescriptor(r0, r3, r8)     // Catch: java.io.IOException -> L71
            r3 = r0
            if (r3 != 0) goto L32
        L2c:
            if (r3 == 0) goto L31
            r3.close()     // Catch: java.io.IOException -> L71
        L31:
            return r11
        L32:
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            java.io.FileDescriptor r4 = r3.getFileDescriptor()     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            int r4 = r1.getWeight()     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            android.graphics.Typeface$Builder r0 = r0.setWeight(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            boolean r4 = r1.isItalic()     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            android.graphics.Typeface$Builder r0 = r0.setItalic(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            android.graphics.Typeface r0 = r0.build()     // Catch: java.lang.Throwable -> L55 java.lang.Throwable -> L59
            if (r3 == 0) goto L54
            r3.close()     // Catch: java.io.IOException -> L71
        L54:
            return r0
        L55:
            r0 = move-exception
            r4 = r0
            r5 = r11
            goto L5f
        L59:
            r0 = move-exception
            r4 = r0
            throw r4     // Catch: java.lang.Throwable -> L5c
        L5c:
            r0 = move-exception
            r5 = r4
            r4 = r0
        L5f:
            if (r3 == 0) goto L70
            if (r5 == 0) goto L6d
            r3.close()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L71
            goto L70
        L67:
            r0 = move-exception
            r6 = r0
            r5.addSuppressed(r6)     // Catch: java.io.IOException -> L71
            goto L70
        L6d:
            r3.close()     // Catch: java.io.IOException -> L71
        L70:
            throw r4     // Catch: java.io.IOException -> L71
        L71:
            r0 = move-exception
            return r11
        L73:
            r12 = r20
            java.util.Map r0 = androidx.core.provider.FontsContractCompat.prepareFontData(r12, r9, r8)
            java.lang.Object r13 = r19.newFamily()
            r1 = 0
            int r14 = r9.length
            r2 = 0
            r16 = r1
            r15 = 0
        L83:
            if (r15 >= r14) goto Lb8
            r17 = r9[r15]
            android.net.Uri r1 = r17.getUri()
            java.lang.Object r1 = r0.get(r1)
            r18 = r1
            java.nio.ByteBuffer r18 = (java.nio.ByteBuffer) r18
            if (r18 != 0) goto L96
            goto Lb5
        L96:
            int r4 = r17.getTtcIndex()
            int r5 = r17.getWeight()
            boolean r6 = r17.isItalic()
            r1 = r19
            r2 = r13
            r3 = r18
            boolean r1 = r1.addFontFromBuffer(r2, r3, r4, r5, r6)
            if (r1 != 0) goto Lb2
            r7.abortCreation(r13)
            return r11
        Lb2:
            r2 = 1
            r16 = r2
        Lb5:
            int r15 = r15 + 1
            goto L83
        Lb8:
            if (r16 != 0) goto Lbe
            r7.abortCreation(r13)
            return r11
        Lbe:
            boolean r1 = r7.freeze(r13)
            if (r1 != 0) goto Lc5
            return r11
        Lc5:
            android.graphics.Typeface r1 = r7.createFromFamiliesWithDefault(r13)
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r1, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int id, String path, int style) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, id, path, style);
        }
        Object fontFamily = newFamily();
        if (!addFontFromAssetManager(context, fontFamily, path, 0, -1, -1, null)) {
            abortCreation(fontFamily);
            return null;
        }
        if (freeze(fontFamily)) {
            return createFromFamiliesWithDefault(fontFamily);
        }
        return null;
    }

    protected Class obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor obtainFontFamilyCtor(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getConstructor(new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method obtainAddFontFromBufferMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(ADD_FONT_FROM_BUFFER_METHOD, ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method obtainFreezeMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(FREEZE_METHOD, new Class[0]);
    }

    protected Method obtainAbortCreationMethod(Class fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class fontFamily) throws NoSuchMethodException, SecurityException, NegativeArraySizeException {
        Object familyArray = Array.newInstance((Class<?>) fontFamily, 1);
        Method m = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, familyArray.getClass(), Integer.TYPE, Integer.TYPE);
        m.setAccessible(true);
        return m;
    }
}
