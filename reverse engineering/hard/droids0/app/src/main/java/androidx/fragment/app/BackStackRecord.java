package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    ArrayList<Runnable> mCommitRunnables;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    final FragmentManagerImpl mManager;

    @Nullable
    String mName;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;
    int mTransitionStyle;
    ArrayList<Op> mOps = new ArrayList<>();
    boolean mAllowAddToBackStack = true;
    int mIndex = -1;
    boolean mReorderingAllowed = false;

    static final class Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        int popEnterAnim;
        int popExitAnim;

        Op() {
        }

        Op(int cmd, Fragment fragment) {
            this.cmd = cmd;
            this.fragment = fragment;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dump(prefix, writer, true);
    }

    public void dump(String prefix, PrintWriter writer, boolean full) {
        String cmdStr;
        if (full) {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(this.mName);
            writer.print(" mIndex=");
            writer.print(this.mIndex);
            writer.print(" mCommitted=");
            writer.println(this.mCommitted);
            if (this.mTransition != 0) {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(this.mTransition));
                writer.print(" mTransitionStyle=#");
                writer.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(this.mEnterAnim));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(this.mPopEnterAnim));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            writer.print(prefix);
            writer.println("Operations:");
            String str = prefix + "    ";
            int numOps = this.mOps.size();
            for (int opNum = 0; opNum < numOps; opNum++) {
                Op op = this.mOps.get(opNum);
                switch (op.cmd) {
                    case 0:
                        cmdStr = "NULL";
                        break;
                    case 1:
                        cmdStr = "ADD";
                        break;
                    case 2:
                        cmdStr = "REPLACE";
                        break;
                    case 3:
                        cmdStr = "REMOVE";
                        break;
                    case 4:
                        cmdStr = "HIDE";
                        break;
                    case 5:
                        cmdStr = "SHOW";
                        break;
                    case 6:
                        cmdStr = "DETACH";
                        break;
                    case 7:
                        cmdStr = "ATTACH";
                        break;
                    case 8:
                        cmdStr = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        cmdStr = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        cmdStr = "cmd=" + op.cmd;
                        break;
                }
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(opNum);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.fragment);
                if (full) {
                    if (op.enterAnim != 0 || op.exitAnim != 0) {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.enterAnim));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.exitAnim));
                    }
                    if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.popEnterAnim));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.popExitAnim));
                    }
                }
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl manager) {
        this.mManager = manager;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }

    void addOp(Op op) {
        this.mOps.add(op);
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction add(Fragment fragment, @Nullable String tag) {
        doAddOp(0, fragment, tag, 1);
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        doAddOp(containerViewId, fragment, null, 1);
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction add(int containerViewId, Fragment fragment, @Nullable String tag) {
        doAddOp(containerViewId, fragment, tag, 1);
        return this;
    }

    private void doAddOp(int containerViewId, Fragment fragment, @Nullable String tag, int opcmd) {
        Class fragmentClass = fragment.getClass();
        int modifiers = fragmentClass.getModifiers();
        if (fragmentClass.isAnonymousClass() || !Modifier.isPublic(modifiers) || (fragmentClass.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + fragmentClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.mFragmentManager = this.mManager;
        if (tag != null) {
            if (fragment.mTag != null && !tag.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + tag);
            }
            fragment.mTag = tag;
        }
        if (containerViewId != 0) {
            if (containerViewId == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + tag + " to container view with no id");
            }
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != containerViewId) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + containerViewId);
            }
            fragment.mFragmentId = containerViewId;
            fragment.mContainerId = containerViewId;
        }
        addOp(new Op(opcmd, fragment));
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        return replace(containerViewId, fragment, null);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction replace(int containerViewId, Fragment fragment, @Nullable String tag) {
        if (containerViewId == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(containerViewId, fragment, tag, 2);
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        addOp(new Op(3, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        addOp(new Op(4, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        addOp(new Op(5, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        addOp(new Op(6, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction attach(Fragment fragment) {
        addOp(new Op(7, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        addOp(new Op(8, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        return setCustomAnimations(enter, exit, 0, 0);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int enter, int exit, int popEnter, int popExit) {
        this.mEnterAnim = enter;
        this.mExitAnim = exit;
        this.mPopEnterAnim = popEnter;
        this.mPopExitAnim = popExit;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setTransition(int transition) {
        this.mTransition = transition;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction addSharedElement(View sharedElement, String name) {
        if (FragmentTransition.supportsTransition()) {
            String transitionName = ViewCompat.getTransitionName(sharedElement);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList<>();
                this.mSharedElementTargetNames = new ArrayList<>();
            } else {
                if (this.mSharedElementTargetNames.contains(name)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + name + "' has already been added to the transaction.");
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + " has already been added to the transaction.");
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(name);
        }
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setTransitionStyle(int styleRes) {
        this.mTransitionStyle = styleRes;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction addToBackStack(@Nullable String name) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = name;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(int res) {
        this.mBreadCrumbTitleRes = res;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence text) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = text;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        this.mBreadCrumbShortTitleRes = res;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence text) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = text;
        return this;
    }

    void bumpBackStackNesting(int amt) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Bump nesting in " + this + " by " + amt);
        }
        int numOps = this.mOps.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            Op op = this.mOps.get(opNum);
            if (op.fragment != null) {
                op.fragment.mBackStackNesting += amt;
                if (FragmentManagerImpl.DEBUG) {
                    Log.v(TAG, "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction runOnCommit(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable cannot be null");
        }
        disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    public void runOnCommitRunnables() {
        ArrayList<Runnable> arrayList = this.mCommitRunnables;
        if (arrayList != null) {
            int N = arrayList.size();
            for (int i = 0; i < N; i++) {
                this.mCommitRunnables.get(i).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setReorderingAllowed(boolean reorderingAllowed) {
        this.mReorderingAllowed = reorderingAllowed;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setAllowOptimization(boolean allowOptimization) {
        return setReorderingAllowed(allowOptimization);
    }

    int commitInternal(boolean allowStateLoss) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Commit: " + this);
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
            pw.close();
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, allowStateLoss);
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> records, ArrayList<Boolean> isRecordPop) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Run: " + this);
        }
        records.add(this);
        isRecordPop.add(false);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
            return true;
        }
        return true;
    }

    boolean interactsWith(int containerId) {
        int numOps = this.mOps.size();
        int opNum = 0;
        while (true) {
            if (opNum >= numOps) {
                return false;
            }
            Op op = this.mOps.get(opNum);
            int fragContainer = op.fragment != null ? op.fragment.mContainerId : 0;
            if (fragContainer == 0 || fragContainer != containerId) {
                opNum++;
            } else {
                return true;
            }
        }
    }

    boolean interactsWith(ArrayList<BackStackRecord> records, int startIndex, int endIndex) {
        if (endIndex == startIndex) {
            return false;
        }
        int numOps = this.mOps.size();
        int lastContainer = -1;
        for (int opNum = 0; opNum < numOps; opNum++) {
            Op op = this.mOps.get(opNum);
            int container = op.fragment != null ? op.fragment.mContainerId : 0;
            if (container != 0 && container != lastContainer) {
                lastContainer = container;
                for (int i = startIndex; i < endIndex; i++) {
                    BackStackRecord record = records.get(i);
                    int numThoseOps = record.mOps.size();
                    for (int thoseOpIndex = 0; thoseOpIndex < numThoseOps; thoseOpIndex++) {
                        Op thatOp = record.mOps.get(thoseOpIndex);
                        int thatContainer = thatOp.fragment != null ? thatOp.fragment.mContainerId : 0;
                        if (thatContainer == container) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    void executeOps() {
        int numOps = this.mOps.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            Op op = this.mOps.get(opNum);
            Fragment f = op.fragment;
            if (f != null) {
                f.setNextTransition(this.mTransition, this.mTransitionStyle);
            }
            switch (op.cmd) {
                case 1:
                    f.setNextAnim(op.enterAnim);
                    this.mManager.addFragment(f, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                case 3:
                    f.setNextAnim(op.exitAnim);
                    this.mManager.removeFragment(f);
                    break;
                case 4:
                    f.setNextAnim(op.exitAnim);
                    this.mManager.hideFragment(f);
                    break;
                case 5:
                    f.setNextAnim(op.enterAnim);
                    this.mManager.showFragment(f);
                    break;
                case 6:
                    f.setNextAnim(op.exitAnim);
                    this.mManager.detachFragment(f);
                    break;
                case 7:
                    f.setNextAnim(op.enterAnim);
                    this.mManager.attachFragment(f);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(f);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
            }
            if (!this.mReorderingAllowed && op.cmd != 1 && f != null) {
                this.mManager.moveFragmentToExpectedState(f);
            }
        }
        if (!this.mReorderingAllowed) {
            FragmentManagerImpl fragmentManagerImpl = this.mManager;
            fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
        }
    }

    void executePopOps(boolean moveToState) {
        for (int opNum = this.mOps.size() - 1; opNum >= 0; opNum--) {
            Op op = this.mOps.get(opNum);
            Fragment f = op.fragment;
            if (f != null) {
                f.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            }
            switch (op.cmd) {
                case 1:
                    f.setNextAnim(op.popExitAnim);
                    this.mManager.removeFragment(f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                case 3:
                    f.setNextAnim(op.popEnterAnim);
                    this.mManager.addFragment(f, false);
                    break;
                case 4:
                    f.setNextAnim(op.popEnterAnim);
                    this.mManager.showFragment(f);
                    break;
                case 5:
                    f.setNextAnim(op.popExitAnim);
                    this.mManager.hideFragment(f);
                    break;
                case 6:
                    f.setNextAnim(op.popEnterAnim);
                    this.mManager.attachFragment(f);
                    break;
                case 7:
                    f.setNextAnim(op.popExitAnim);
                    this.mManager.detachFragment(f);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(f);
                    break;
            }
            if (!this.mReorderingAllowed && op.cmd != 3 && f != null) {
                this.mManager.moveFragmentToExpectedState(f);
            }
        }
        if (!this.mReorderingAllowed && moveToState) {
            FragmentManagerImpl fragmentManagerImpl = this.mManager;
            fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment expandOps(java.util.ArrayList<androidx.fragment.app.Fragment> r13, androidx.fragment.app.Fragment r14) {
        /*
            r12 = this;
            r0 = 0
        L1:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r1 = r12.mOps
            int r1 = r1.size()
            if (r0 >= r1) goto Lb6
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r1 = r12.mOps
            java.lang.Object r1 = r1.get(r0)
            androidx.fragment.app.BackStackRecord$Op r1 = (androidx.fragment.app.BackStackRecord.Op) r1
            int r2 = r1.cmd
            r3 = 1
            if (r2 == r3) goto Lad
            r4 = 2
            r5 = 3
            r6 = 9
            if (r2 == r4) goto L53
            if (r2 == r5) goto L3a
            r4 = 6
            if (r2 == r4) goto L3a
            r4 = 7
            if (r2 == r4) goto Lad
            r4 = 8
            if (r2 == r4) goto L2a
            goto Lb3
        L2a:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r2 = r12.mOps
            androidx.fragment.app.BackStackRecord$Op r4 = new androidx.fragment.app.BackStackRecord$Op
            r4.<init>(r6, r14)
            r2.add(r0, r4)
            int r0 = r0 + 1
            androidx.fragment.app.Fragment r14 = r1.fragment
            goto Lb3
        L3a:
            androidx.fragment.app.Fragment r2 = r1.fragment
            r13.remove(r2)
            androidx.fragment.app.Fragment r2 = r1.fragment
            if (r2 != r14) goto Lb3
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r2 = r12.mOps
            androidx.fragment.app.BackStackRecord$Op r4 = new androidx.fragment.app.BackStackRecord$Op
            androidx.fragment.app.Fragment r5 = r1.fragment
            r4.<init>(r6, r5)
            r2.add(r0, r4)
            int r0 = r0 + 1
            r14 = 0
            goto Lb3
        L53:
            androidx.fragment.app.Fragment r2 = r1.fragment
            int r4 = r2.mContainerId
            r7 = 0
            int r8 = r13.size()
            int r8 = r8 - r3
        L5d:
            if (r8 < 0) goto L9d
            java.lang.Object r9 = r13.get(r8)
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            int r10 = r9.mContainerId
            if (r10 != r4) goto L9a
            if (r9 != r2) goto L6d
            r7 = 1
            goto L9a
        L6d:
            if (r9 != r14) goto L7c
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r10 = r12.mOps
            androidx.fragment.app.BackStackRecord$Op r11 = new androidx.fragment.app.BackStackRecord$Op
            r11.<init>(r6, r9)
            r10.add(r0, r11)
            int r0 = r0 + 1
            r14 = 0
        L7c:
            androidx.fragment.app.BackStackRecord$Op r10 = new androidx.fragment.app.BackStackRecord$Op
            r10.<init>(r5, r9)
            int r11 = r1.enterAnim
            r10.enterAnim = r11
            int r11 = r1.popEnterAnim
            r10.popEnterAnim = r11
            int r11 = r1.exitAnim
            r10.exitAnim = r11
            int r11 = r1.popExitAnim
            r10.popExitAnim = r11
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r11 = r12.mOps
            r11.add(r0, r10)
            r13.remove(r9)
            int r0 = r0 + r3
        L9a:
            int r8 = r8 + (-1)
            goto L5d
        L9d:
            if (r7 == 0) goto La7
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r5 = r12.mOps
            r5.remove(r0)
            int r0 = r0 + (-1)
            goto Lac
        La7:
            r1.cmd = r3
            r13.add(r2)
        Lac:
            goto Lb3
        Lad:
            androidx.fragment.app.Fragment r2 = r1.fragment
            r13.add(r2)
        Lb3:
            int r0 = r0 + r3
            goto L1
        Lb6:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.expandOps(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment trackAddedFragmentsInPop(java.util.ArrayList<androidx.fragment.app.Fragment> r5, androidx.fragment.app.Fragment r6) {
        /*
            r4 = this;
            r0 = 0
        L1:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r1 = r4.mOps
            int r1 = r1.size()
            if (r0 >= r1) goto L31
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r1 = r4.mOps
            java.lang.Object r1 = r1.get(r0)
            androidx.fragment.app.BackStackRecord$Op r1 = (androidx.fragment.app.BackStackRecord.Op) r1
            int r2 = r1.cmd
            r3 = 1
            if (r2 == r3) goto L28
            r3 = 3
            if (r2 == r3) goto L22
            switch(r2) {
                case 6: goto L22;
                case 7: goto L28;
                case 8: goto L20;
                case 9: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L2e
        L1d:
            androidx.fragment.app.Fragment r6 = r1.fragment
            goto L2e
        L20:
            r6 = 0
            goto L2e
        L22:
            androidx.fragment.app.Fragment r2 = r1.fragment
            r5.add(r2)
            goto L2e
        L28:
            androidx.fragment.app.Fragment r2 = r1.fragment
            r5.remove(r2)
        L2e:
            int r0 = r0 + 1
            goto L1
        L31:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.trackAddedFragmentsInPop(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    boolean isPostponed() {
        for (int opNum = 0; opNum < this.mOps.size(); opNum++) {
            Op op = this.mOps.get(opNum);
            if (isFragmentPostponed(op)) {
                return true;
            }
        }
        return false;
    }

    void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener listener) {
        for (int opNum = 0; opNum < this.mOps.size(); opNum++) {
            Op op = this.mOps.get(opNum);
            if (isFragmentPostponed(op)) {
                op.fragment.setOnStartEnterTransitionListener(listener);
            }
        }
    }

    private static boolean isFragmentPostponed(Op op) {
        Fragment fragment = op.fragment;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }
}
