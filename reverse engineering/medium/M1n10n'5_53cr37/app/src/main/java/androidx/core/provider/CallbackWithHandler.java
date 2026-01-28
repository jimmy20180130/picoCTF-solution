package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

/* loaded from: classes.dex */
class CallbackWithHandler {
    private final FontsContractCompat.FontRequestCallback mCallback;
    private final Handler mCallbackHandler;

    CallbackWithHandler(FontsContractCompat.FontRequestCallback callback, Handler callbackHandler) {
        this.mCallback = callback;
        this.mCallbackHandler = callbackHandler;
    }

    CallbackWithHandler(FontsContractCompat.FontRequestCallback callback) {
        this.mCallback = callback;
        this.mCallbackHandler = CalleeHandler.create();
    }

    /* renamed from: androidx.core.provider.CallbackWithHandler$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ Typeface val$typeface;

        AnonymousClass1(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            fontRequestCallback = fontRequestCallback;
            typeface = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            fontRequestCallback.onTypefaceRetrieved(typeface);
        }
    }

    private void onTypefaceRetrieved(Typeface typeface) {
        FontsContractCompat.FontRequestCallback callback = this.mCallback;
        this.mCallbackHandler.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.1
            final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
            final /* synthetic */ Typeface val$typeface;

            AnonymousClass1(FontsContractCompat.FontRequestCallback callback2, Typeface typeface2) {
                fontRequestCallback = callback2;
                typeface = typeface2;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(typeface);
            }
        });
    }

    /* renamed from: androidx.core.provider.CallbackWithHandler$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ int val$reason;

        AnonymousClass2(FontsContractCompat.FontRequestCallback fontRequestCallback, int i) {
            fontRequestCallback = fontRequestCallback;
            i = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            fontRequestCallback.onTypefaceRequestFailed(i);
        }
    }

    private void onTypefaceRequestFailed(int reason) {
        FontsContractCompat.FontRequestCallback callback = this.mCallback;
        this.mCallbackHandler.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.2
            final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
            final /* synthetic */ int val$reason;

            AnonymousClass2(FontsContractCompat.FontRequestCallback callback2, int reason2) {
                fontRequestCallback = callback2;
                i = reason2;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(i);
            }
        });
    }

    void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}
