package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    public void resize(int maxSize) throws Throwable {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = maxSize;
        }
        trimToSize(maxSize);
    }

    @Nullable
    public final V get(@NonNull K k) throws Throwable {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                V v2 = this.map.get(k);
                if (v2 != null) {
                    this.hitCount++;
                    return v2;
                }
                this.missCount++;
                V vCreate = create(k);
                if (vCreate == null) {
                    return null;
                }
                synchronized (this) {
                    this.createCount++;
                    v = (V) this.map.put(k, vCreate);
                    if (v != null) {
                        this.map.put(k, v);
                    } else {
                        this.size += safeSizeOf(k, vCreate);
                    }
                }
                if (v != null) {
                    entryRemoved(false, k, vCreate, v);
                    return v;
                }
                trimToSize(this.maxSize);
                return vCreate;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Nullable
    public final V put(@NonNull K key, @NonNull V value) throws Throwable {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.putCount++;
                this.size += safeSizeOf(key, value);
                V previous = this.map.put(key, value);
                if (previous != null) {
                    this.size -= safeSizeOf(key, previous);
                }
                if (previous != null) {
                    entryRemoved(false, key, previous, value);
                }
                trimToSize(this.maxSize);
                return previous;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:29:0x0078
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void trimToSize(int r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L3:
            monitor-enter(r6)
            int r3 = r6.size     // Catch: java.lang.Throwable -> L75
            if (r3 < 0) goto L56
            java.util.LinkedHashMap<K, V> r3 = r6.map     // Catch: java.lang.Throwable -> L75
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L14
            int r3 = r6.size     // Catch: java.lang.Throwable -> L75
            if (r3 != 0) goto L56
        L14:
            int r3 = r6.size     // Catch: java.lang.Throwable -> L75
            if (r3 <= r7) goto L54
            java.util.LinkedHashMap<K, V> r3 = r6.map     // Catch: java.lang.Throwable -> L75
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L21
            goto L54
        L21:
            java.util.LinkedHashMap<K, V> r3 = r6.map     // Catch: java.lang.Throwable -> L75
            java.util.Set r3 = r3.entrySet()     // Catch: java.lang.Throwable -> L75
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L75
            java.lang.Object r3 = r3.next()     // Catch: java.lang.Throwable -> L75
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L75
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L75
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L52
            java.util.LinkedHashMap<K, V> r4 = r6.map     // Catch: java.lang.Throwable -> L78
            r4.remove(r1)     // Catch: java.lang.Throwable -> L78
            int r4 = r6.size     // Catch: java.lang.Throwable -> L78
            int r5 = r6.safeSizeOf(r1, r2)     // Catch: java.lang.Throwable -> L78
            int r4 = r4 - r5
            r6.size = r4     // Catch: java.lang.Throwable -> L78
            int r4 = r6.evictionCount     // Catch: java.lang.Throwable -> L78
            r5 = 1
            int r4 = r4 + r5
            r6.evictionCount = r4     // Catch: java.lang.Throwable -> L78
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            r6.entryRemoved(r5, r1, r2, r0)
            goto L3
        L52:
            r0 = move-exception
            goto L76
        L54:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L75
            return
        L56:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L75
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r3.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> L75
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L75
            r3.append(r4)     // Catch: java.lang.Throwable -> L75
            java.lang.String r4 = ".sizeOf() is reporting inconsistent results!"
            r3.append(r4)     // Catch: java.lang.Throwable -> L75
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L75
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L75
            throw r0     // Catch: java.lang.Throwable -> L75
        L75:
            r0 = move-exception
        L76:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            throw r0
        L78:
            r0 = move-exception
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }

    @Nullable
    public final V remove(@NonNull K key) throws Throwable {
        Throwable th;
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                try {
                    V previous = this.map.remove(key);
                    if (previous != null) {
                        this.size -= safeSizeOf(key, previous);
                    }
                    if (previous != null) {
                        entryRemoved(false, key, previous, null);
                    }
                    return previous;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    protected void entryRemoved(boolean evicted, @NonNull K key, @NonNull V oldValue, @Nullable V newValue) {
    }

    @Nullable
    protected V create(@NonNull K key) {
        return null;
    }

    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return result;
    }

    protected int sizeOf(@NonNull K key, @NonNull V value) {
        return 1;
    }

    public final void evictAll() throws Throwable {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int hitPercent;
        int accesses = this.hitCount + this.missCount;
        hitPercent = accesses != 0 ? (this.hitCount * 100) / accesses : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(hitPercent));
    }
}
