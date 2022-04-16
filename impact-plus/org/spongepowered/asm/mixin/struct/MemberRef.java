/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.transformer.throwables.MixinTransformerError;
import org.spongepowered.asm.util.Bytecode;

public abstract class MemberRef {
    private static final /* synthetic */ int[] H_OPCODES;

    static {
        H_OPCODES = new int[]{0, 180, 178, 181, 179, 182, 184, 183, 183, 185};
    }

    static int tagFromOpcode(int llllllllllllllllIlllIIlllIllllll) {
        for (int llllllllllllllllIlllIIllllIIIlII = 1; llllllllllllllllIlllIIllllIIIlII < H_OPCODES.length; ++llllllllllllllllIlllIIllllIIIlII) {
            if (H_OPCODES[llllllllllllllllIlllIIllllIIIlII] != llllllllllllllllIlllIIlllIllllll) continue;
            return llllllllllllllllIlllIIllllIIIlII;
        }
        return 0;
    }

    public abstract int getOpcode();

    public abstract String getDesc();

    public abstract void setOwner(String var1);

    public abstract boolean isField();

    public abstract String getName();

    public int hashCode() {
        MemberRef llllllllllllllllIlllIIllllIIllIl;
        return llllllllllllllllIlllIIllllIIllIl.toString().hashCode();
    }

    public abstract void setName(String var1);

    static int opcodeFromTag(int llllllllllllllllIlllIIllllIIlIll) {
        return llllllllllllllllIlllIIllllIIlIll >= 0 && llllllllllllllllIlllIIllllIIlIll < H_OPCODES.length ? H_OPCODES[llllllllllllllllIlllIIllllIIlIll] : 0;
    }

    public MemberRef() {
        MemberRef llllllllllllllllIlllIIllllIlllll;
    }

    public String toString() {
        MemberRef llllllllllllllllIlllIIllllIllIlI;
        String llllllllllllllllIlllIIllllIllIll = Bytecode.getOpcodeName(llllllllllllllllIlllIIllllIllIlI.getOpcode());
        return String.format("%s for %s.%s%s%s", llllllllllllllllIlllIIllllIllIll, llllllllllllllllIlllIIllllIllIlI.getOwner(), llllllllllllllllIlllIIllllIllIlI.getName(), llllllllllllllllIlllIIllllIllIlI.isField() ? ":" : "", llllllllllllllllIlllIIllllIllIlI.getDesc());
    }

    public boolean equals(Object llllllllllllllllIlllIIllllIlIlII) {
        MemberRef llllllllllllllllIlllIIllllIlIIlI;
        if (!(llllllllllllllllIlllIIllllIlIlII instanceof MemberRef)) {
            return false;
        }
        MemberRef llllllllllllllllIlllIIllllIlIIll = (MemberRef)llllllllllllllllIlllIIllllIlIlII;
        return llllllllllllllllIlllIIllllIlIIlI.getOpcode() == llllllllllllllllIlllIIllllIlIIll.getOpcode() && llllllllllllllllIlllIIllllIlIIlI.getOwner().equals(llllllllllllllllIlllIIllllIlIIll.getOwner()) && llllllllllllllllIlllIIllllIlIIlI.getName().equals(llllllllllllllllIlllIIllllIlIIll.getName()) && llllllllllllllllIlllIIllllIlIIlI.getDesc().equals(llllllllllllllllIlllIIllllIlIIll.getDesc());
    }

    public abstract void setDesc(String var1);

    public abstract String getOwner();

    public abstract void setOpcode(int var1);

    public static final class Method
    extends MemberRef {
        public final /* synthetic */ MethodInsnNode insn;
        private static final /* synthetic */ int OPCODES;

        @Override
        public boolean isField() {
            return false;
        }

        @Override
        public String getName() {
            Method llllllllllllllllIllIIlIIllllIIll;
            return llllllllllllllllIllIIlIIllllIIll.insn.name;
        }

        @Override
        public String getDesc() {
            Method llllllllllllllllIllIIlIIlllIlIlI;
            return llllllllllllllllIllIIlIIlllIlIlI.insn.desc;
        }

        @Override
        public String getOwner() {
            Method llllllllllllllllIllIIlIIllllllIl;
            return llllllllllllllllIllIIlIIllllllIl.insn.owner;
        }

        @Override
        public int getOpcode() {
            Method llllllllllllllllIllIIlIlIIIIIllI;
            return llllllllllllllllIllIIlIlIIIIIllI.insn.getOpcode();
        }

        @Override
        public void setName(String llllllllllllllllIllIIlIIlllIllIl) {
            llllllllllllllllIllIIlIIllllIIII.insn.name = llllllllllllllllIllIIlIIlllIllIl;
        }

        static {
            OPCODES = 191;
        }

        @Override
        public void setOwner(String llllllllllllllllIllIIlIIlllllIII) {
            llllllllllllllllIllIIlIIlllllIIl.insn.owner = llllllllllllllllIllIIlIIlllllIII;
        }

        @Override
        public void setDesc(String llllllllllllllllIllIIlIIlllIIlII) {
            llllllllllllllllIllIIlIIlllIIlIl.insn.desc = llllllllllllllllIllIIlIIlllIIlII;
        }

        public Method(MethodInsnNode llllllllllllllllIllIIlIlIIIIlIll) {
            Method llllllllllllllllIllIIlIlIIIIlIlI;
            llllllllllllllllIllIIlIlIIIIlIlI.insn = llllllllllllllllIllIIlIlIIIIlIll;
        }

        @Override
        public void setOpcode(int llllllllllllllllIllIIlIlIIIIIIIl) {
            Method llllllllllllllllIllIIlIlIIIIIIII;
            if ((llllllllllllllllIllIIlIlIIIIIIIl & 0xBF) == 0) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid opcode for method instruction: 0x").append(Integer.toHexString(llllllllllllllllIllIIlIlIIIIIIIl))));
            }
            llllllllllllllllIllIIlIlIIIIIIII.insn.setOpcode(llllllllllllllllIllIIlIlIIIIIIIl);
        }
    }

    public static final class Handle
    extends MemberRef {
        private /* synthetic */ org.spongepowered.asm.lib.Handle handle;

        @Override
        public int getOpcode() {
            Handle lllllllllllllllllllllIlIlIllIlII;
            int lllllllllllllllllllllIlIlIllIlIl = MemberRef.opcodeFromTag(lllllllllllllllllllllIlIlIllIlII.handle.getTag());
            if (lllllllllllllllllllllIlIlIllIlIl == 0) {
                throw new MixinTransformerError(String.valueOf(new StringBuilder().append("Invalid tag ").append(lllllllllllllllllllllIlIlIllIlII.handle.getTag()).append(" for method handle ").append(lllllllllllllllllllllIlIlIllIlII.handle).append(".")));
            }
            return lllllllllllllllllllllIlIlIllIlIl;
        }

        @Override
        public void setOpcode(int lllllllllllllllllllllIlIlIlIIIII) {
            Handle lllllllllllllllllllllIlIlIlIIlIl;
            int lllllllllllllllllllllIlIlIlIIIll = MemberRef.tagFromOpcode(lllllllllllllllllllllIlIlIlIIIII);
            if (lllllllllllllllllllllIlIlIlIIIll == 0) {
                throw new MixinTransformerError(String.valueOf(new StringBuilder().append("Invalid opcode ").append(Bytecode.getOpcodeName(lllllllllllllllllllllIlIlIlIIIII)).append(" for method handle ").append(lllllllllllllllllllllIlIlIlIIlIl.handle).append(".")));
            }
            boolean lllllllllllllllllllllIlIlIlIIIlI = lllllllllllllllllllllIlIlIlIIIll == 9;
            lllllllllllllllllllllIlIlIlIIlIl.handle = new org.spongepowered.asm.lib.Handle(lllllllllllllllllllllIlIlIlIIIll, lllllllllllllllllllllIlIlIlIIlIl.handle.getOwner(), lllllllllllllllllllllIlIlIlIIlIl.handle.getName(), lllllllllllllllllllllIlIlIlIIlIl.handle.getDesc(), lllllllllllllllllllllIlIlIlIIIlI);
        }

        @Override
        public void setName(String lllllllllllllllllllllIlIIlllIlll) {
            Handle lllllllllllllllllllllIlIIlllIlIl;
            boolean lllllllllllllllllllllIlIIlllIllI = lllllllllllllllllllllIlIIlllIlIl.handle.getTag() == 9;
            lllllllllllllllllllllIlIIlllIlIl.handle = new org.spongepowered.asm.lib.Handle(lllllllllllllllllllllIlIIlllIlIl.handle.getTag(), lllllllllllllllllllllIlIIlllIlIl.handle.getOwner(), lllllllllllllllllllllIlIIlllIlll, lllllllllllllllllllllIlIIlllIlIl.handle.getDesc(), lllllllllllllllllllllIlIIlllIllI);
        }

        @Override
        public String getName() {
            Handle lllllllllllllllllllllIlIlIIIIlII;
            return lllllllllllllllllllllIlIlIIIIlII.handle.getName();
        }

        @Override
        public void setDesc(String lllllllllllllllllllllIlIIllIlIII) {
            Handle lllllllllllllllllllllIlIIllIIllI;
            boolean lllllllllllllllllllllIlIIllIIlll = lllllllllllllllllllllIlIIllIIllI.handle.getTag() == 9;
            lllllllllllllllllllllIlIIllIIllI.handle = new org.spongepowered.asm.lib.Handle(lllllllllllllllllllllIlIIllIIllI.handle.getTag(), lllllllllllllllllllllIlIIllIIllI.handle.getOwner(), lllllllllllllllllllllIlIIllIIllI.handle.getName(), lllllllllllllllllllllIlIIllIlIII, lllllllllllllllllllllIlIIllIIlll);
        }

        @Override
        public boolean isField() {
            Handle lllllllllllllllllllllIlIllIIlIll;
            switch (lllllllllllllllllllllIlIllIIlIll.handle.getTag()) {
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: {
                    return false;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    return true;
                }
            }
            throw new MixinTransformerError(String.valueOf(new StringBuilder().append("Invalid tag ").append(lllllllllllllllllllllIlIllIIlIll.handle.getTag()).append(" for method handle ").append(lllllllllllllllllllllIlIllIIlIll.handle).append(".")));
        }

        @Override
        public String getOwner() {
            Handle lllllllllllllllllllllIlIlIIllIll;
            return lllllllllllllllllllllIlIlIIllIll.handle.getOwner();
        }

        public org.spongepowered.asm.lib.Handle getMethodHandle() {
            Handle lllllllllllllllllllllIlIllIlIIll;
            return lllllllllllllllllllllIlIllIlIIll.handle;
        }

        public Handle(org.spongepowered.asm.lib.Handle lllllllllllllllllllllIlIllIlIlIl) {
            Handle lllllllllllllllllllllIlIllIllIII;
            lllllllllllllllllllllIlIllIllIII.handle = lllllllllllllllllllllIlIllIlIlIl;
        }

        @Override
        public String getDesc() {
            Handle lllllllllllllllllllllIlIIlllIIII;
            return lllllllllllllllllllllIlIIlllIIII.handle.getDesc();
        }

        @Override
        public void setOwner(String lllllllllllllllllllllIlIlIIlIIII) {
            Handle lllllllllllllllllllllIlIlIIlIIlI;
            boolean lllllllllllllllllllllIlIlIIlIIll = lllllllllllllllllllllIlIlIIlIIlI.handle.getTag() == 9;
            lllllllllllllllllllllIlIlIIlIIlI.handle = new org.spongepowered.asm.lib.Handle(lllllllllllllllllllllIlIlIIlIIlI.handle.getTag(), lllllllllllllllllllllIlIlIIlIIII, lllllllllllllllllllllIlIlIIlIIlI.handle.getName(), lllllllllllllllllllllIlIlIIlIIlI.handle.getDesc(), lllllllllllllllllllllIlIlIIlIIll);
        }
    }

    public static final class Field
    extends MemberRef {
        public final /* synthetic */ FieldInsnNode insn;
        private static final /* synthetic */ int OPCODES;

        static {
            OPCODES = 183;
        }

        @Override
        public String getName() {
            Field llllllllllllllllIIlllIIIIlIlllIl;
            return llllllllllllllllIIlllIIIIlIlllIl.insn.name;
        }

        @Override
        public void setDesc(String llllllllllllllllIIlllIIIIlIIlllI) {
            llllllllllllllllIIlllIIIIlIIllll.insn.desc = llllllllllllllllIIlllIIIIlIIlllI;
        }

        @Override
        public void setName(String llllllllllllllllIIlllIIIIlIlIlll) {
            llllllllllllllllIIlllIIIIlIllIII.insn.name = llllllllllllllllIIlllIIIIlIlIlll;
        }

        public Field(FieldInsnNode llllllllllllllllIIlllIIIIlllIIll) {
            Field llllllllllllllllIIlllIIIIlllIllI;
            llllllllllllllllIIlllIIIIlllIllI.insn = llllllllllllllllIIlllIIIIlllIIll;
        }

        @Override
        public boolean isField() {
            return true;
        }

        @Override
        public void setOpcode(int llllllllllllllllIIlllIIIIllIlIll) {
            Field llllllllllllllllIIlllIIIIllIllII;
            if ((llllllllllllllllIIlllIIIIllIlIll & 0xB7) == 0) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid opcode for field instruction: 0x").append(Integer.toHexString(llllllllllllllllIIlllIIIIllIlIll))));
            }
            llllllllllllllllIIlllIIIIllIllII.insn.setOpcode(llllllllllllllllIIlllIIIIllIlIll);
        }

        @Override
        public String getDesc() {
            Field llllllllllllllllIIlllIIIIlIlIlIl;
            return llllllllllllllllIIlllIIIIlIlIlIl.insn.desc;
        }

        @Override
        public String getOwner() {
            Field llllllllllllllllIIlllIIIIllIIllI;
            return llllllllllllllllIIlllIIIIllIIllI.insn.owner;
        }

        @Override
        public void setOwner(String llllllllllllllllIIlllIIIIllIIIII) {
            llllllllllllllllIIlllIIIIllIIIIl.insn.owner = llllllllllllllllIIlllIIIIllIIIII;
        }

        @Override
        public int getOpcode() {
            Field llllllllllllllllIIlllIIIIllIllll;
            return llllllllllllllllIIlllIIIIllIllll.insn.getOpcode();
        }
    }
}

