package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ImageViewCompat {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof TintableImageSourceView) {
            return ((TintableImageSourceView) imageView).getSupportImageTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageTintList(@NonNull ImageView imageView, @Nullable ColorStateList tintList) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(tintList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable imageViewDrawable = imageView.getDrawable();
                boolean hasTint = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (imageViewDrawable != null && hasTint) {
                    if (imageViewDrawable.isStateful()) {
                        imageViewDrawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(imageViewDrawable);
                    return;
                }
                return;
            }
            return;
        }
        if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView) imageView).setSupportImageTintList(tintList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof TintableImageSourceView) {
            return ((TintableImageSourceView) imageView).getSupportImageTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageTintMode(@NonNull ImageView imageView, @Nullable PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable imageViewDrawable = imageView.getDrawable();
                boolean hasTint = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (imageViewDrawable != null && hasTint) {
                    if (imageViewDrawable.isStateful()) {
                        imageViewDrawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(imageViewDrawable);
                    return;
                }
                return;
            }
            return;
        }
        if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView) imageView).setSupportImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }
}
