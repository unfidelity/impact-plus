/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.ITokenProvider;
import org.spongepowered.asm.util.throwables.ConstraintViolationException;
import org.spongepowered.asm.util.throwables.InvalidConstraintException;

public final class ConstraintParser {
    private ConstraintParser() {
        ConstraintParser llllllllllllllllllIIIIlIllllIIII;
    }

    public static Constraint parse(AnnotationNode llllllllllllllllllIIIIlIllIllIII) {
        String llllllllllllllllllIIIIlIllIlIlll = Annotations.getValue(llllllllllllllllllIIIIlIllIllIII, "constraints", "");
        return ConstraintParser.parse(llllllllllllllllllIIIIlIllIlIlll);
    }

    public static Constraint parse(String llllllllllllllllllIIIIlIlllIIIlI) {
        if (llllllllllllllllllIIIIlIlllIIIlI == null || llllllllllllllllllIIIIlIlllIIIlI.length() == 0) {
            return Constraint.NONE;
        }
        String[] llllllllllllllllllIIIIlIlllIIlII = llllllllllllllllllIIIIlIlllIIIlI.replaceAll("\\s", "").toUpperCase().split(";");
        Constraint llllllllllllllllllIIIIlIlllIIIll = null;
        for (String llllllllllllllllllIIIIlIlllIIllI : llllllllllllllllllIIIIlIlllIIlII) {
            Constraint llllllllllllllllllIIIIlIlllIIlll = new Constraint(llllllllllllllllllIIIIlIlllIIllI);
            if (llllllllllllllllllIIIIlIlllIIIll == null) {
                llllllllllllllllllIIIIlIlllIIIll = llllllllllllllllllIIIIlIlllIIlll;
                continue;
            }
            llllllllllllllllllIIIIlIlllIIIll.append(llllllllllllllllllIIIIlIlllIIlll);
        }
        return llllllllllllllllllIIIIlIlllIIIll != null ? llllllllllllllllllIIIIlIlllIIIll : Constraint.NONE;
    }

    public static class Constraint {
        public static final /* synthetic */ Constraint NONE;
        private /* synthetic */ int max;
        private /* synthetic */ String token;
        private /* synthetic */ Constraint next;
        private /* synthetic */ int min;
        private final /* synthetic */ String expr;
        private static final /* synthetic */ Pattern pattern;
        private /* synthetic */ String[] constraint;

        Constraint(String lllllllllllllllllllIIIIlllIIIlll) {
            Constraint lllllllllllllllllllIIIIlllIIlIIl;
            lllllllllllllllllllIIIIlllIIlIIl.min = Integer.MIN_VALUE;
            lllllllllllllllllllIIIIlllIIlIIl.max = Integer.MAX_VALUE;
            lllllllllllllllllllIIIIlllIIlIIl.expr = lllllllllllllllllllIIIIlllIIIlll;
            Matcher lllllllllllllllllllIIIIlllIIIllI = pattern.matcher(lllllllllllllllllllIIIIlllIIIlll);
            if (!lllllllllllllllllllIIIIlllIIIllI.matches()) {
                throw new InvalidConstraintException(String.valueOf(new StringBuilder().append("Constraint syntax was invalid parsing: ").append(lllllllllllllllllllIIIIlllIIlIIl.expr)));
            }
            lllllllllllllllllllIIIIlllIIlIIl.token = lllllllllllllllllllIIIIlllIIIllI.group(1);
            lllllllllllllllllllIIIIlllIIlIIl.constraint = new String[]{lllllllllllllllllllIIIIlllIIIllI.group(2), lllllllllllllllllllIIIIlllIIIllI.group(3), lllllllllllllllllllIIIIlllIIIllI.group(4), lllllllllllllllllllIIIIlllIIIllI.group(5), lllllllllllllllllllIIIIlllIIIllI.group(6), lllllllllllllllllllIIIIlllIIIllI.group(7), lllllllllllllllllllIIIIlllIIIllI.group(8)};
            lllllllllllllllllllIIIIlllIIlIIl.parse();
        }

        public void check(ITokenProvider lllllllllllllllllllIIIIlIllIIIIl) throws ConstraintViolationException {
            Constraint lllllllllllllllllllIIIIlIllIIIlI;
            if (lllllllllllllllllllIIIIlIllIIIlI != NONE) {
                Integer lllllllllllllllllllIIIIlIllIIllI = lllllllllllllllllllIIIIlIllIIIIl.getToken(lllllllllllllllllllIIIIlIllIIIlI.token);
                if (lllllllllllllllllllIIIIlIllIIllI == null) {
                    throw new ConstraintViolationException(String.valueOf(new StringBuilder().append("The token '").append(lllllllllllllllllllIIIIlIllIIIlI.token).append("' could not be resolved in ").append(lllllllllllllllllllIIIIlIllIIIIl)), lllllllllllllllllllIIIIlIllIIIlI);
                }
                if (lllllllllllllllllllIIIIlIllIIllI < lllllllllllllllllllIIIIlIllIIIlI.min) {
                    throw new ConstraintViolationException(String.valueOf(new StringBuilder().append("Token '").append(lllllllllllllllllllIIIIlIllIIIlI.token).append("' has a value (").append(lllllllllllllllllllIIIIlIllIIllI).append(") which is less than the minimum value ").append(lllllllllllllllllllIIIIlIllIIIlI.min).append(" in ").append(lllllllllllllllllllIIIIlIllIIIIl)), lllllllllllllllllllIIIIlIllIIIlI, (int)lllllllllllllllllllIIIIlIllIIllI);
                }
                if (lllllllllllllllllllIIIIlIllIIllI > lllllllllllllllllllIIIIlIllIIIlI.max) {
                    throw new ConstraintViolationException(String.valueOf(new StringBuilder().append("Token '").append(lllllllllllllllllllIIIIlIllIIIlI.token).append("' has a value (").append(lllllllllllllllllllIIIIlIllIIllI).append(") which is greater than the maximum value ").append(lllllllllllllllllllIIIIlIllIIIlI.max).append(" in ").append(lllllllllllllllllllIIIIlIllIIIIl)), lllllllllllllllllllIIIIlIllIIIlI, (int)lllllllllllllllllllIIIIlIllIIllI);
                }
            }
            if (lllllllllllllllllllIIIIlIllIIIlI.next != null) {
                lllllllllllllllllllIIIIlIllIIIlI.next.check(lllllllllllllllllllIIIIlIllIIIIl);
            }
        }

        public int getMin() {
            Constraint lllllllllllllllllllIIIIlIllllIIl;
            return lllllllllllllllllllIIIIlIllllIIl.min;
        }

        void append(Constraint lllllllllllllllllllIIIIlIllllllI) {
            Constraint lllllllllllllllllllIIIIlIlllllll;
            if (lllllllllllllllllllIIIIlIlllllll.next != null) {
                lllllllllllllllllllIIIIlIlllllll.next.append(lllllllllllllllllllIIIIlIllllllI);
                return;
            }
            lllllllllllllllllllIIIIlIlllllll.next = lllllllllllllllllllIIIIlIllllllI;
        }

        public int getMax() {
            Constraint lllllllllllllllllllIIIIlIlllIlIl;
            return lllllllllllllllllllIIIIlIlllIlIl.max;
        }

        public String toString() {
            Constraint lllllllllllllllllllIIIIlIlIIIIll;
            return String.format("Constraint(%s [%d-%d])", lllllllllllllllllllIIIIlIlIIIIll.token, lllllllllllllllllllIIIIlIlIIIIll.min, lllllllllllllllllllIIIIlIlIIIIll.max);
        }

        private Constraint() {
            Constraint lllllllllllllllllllIIIIllIllIlll;
            lllllllllllllllllllIIIIllIllIlll.min = Integer.MIN_VALUE;
            lllllllllllllllllllIIIIllIllIlll.max = Integer.MAX_VALUE;
            lllllllllllllllllllIIIIllIllIlll.expr = null;
            lllllllllllllllllllIIIIllIllIlll.token = "*";
            lllllllllllllllllllIIIIllIllIlll.constraint = new String[0];
        }

        private String elem(int lllllllllllllllllllIIIIllIIIllII) {
            Constraint lllllllllllllllllllIIIIllIIIllIl;
            return lllllllllllllllllllIIIIllIIIllIl.constraint[lllllllllllllllllllIIIIllIIIllII];
        }

        public String getRangeHumanReadable() {
            Constraint lllllllllllllllllllIIIIlIlIIlIlI;
            if (lllllllllllllllllllIIIIlIlIIlIlI.min == Integer.MIN_VALUE && lllllllllllllllllllIIIIlIlIIlIlI.max == Integer.MAX_VALUE) {
                return "ANY VALUE";
            }
            if (lllllllllllllllllllIIIIlIlIIlIlI.min == Integer.MIN_VALUE) {
                return String.format("less than or equal to %d", lllllllllllllllllllIIIIlIlIIlIlI.max);
            }
            if (lllllllllllllllllllIIIIlIlIIlIlI.max == Integer.MAX_VALUE) {
                return String.format("greater than or equal to %d", lllllllllllllllllllIIIIlIlIIlIlI.min);
            }
            if (lllllllllllllllllllIIIIlIlIIlIlI.min == lllllllllllllllllllIIIIlIlIIlIlI.max) {
                return String.format("%d", lllllllllllllllllllIIIIlIlIIlIlI.min);
            }
            return String.format("between %d and %d", lllllllllllllllllllIIIIlIlIIlIlI.min, lllllllllllllllllllIIIIlIlIIlIlI.max);
        }

        private void parse() {
            Constraint lllllllllllllllllllIIIIllIIllIII;
            if (!lllllllllllllllllllIIIIllIIllIII.has(1)) {
                return;
            }
            lllllllllllllllllllIIIIllIIllIII.min = lllllllllllllllllllIIIIllIIllIII.val(1);
            lllllllllllllllllllIIIIllIIllIII.max = lllllllllllllllllllIIIIllIIllIII.min++;
            boolean lllllllllllllllllllIIIIllIIllIIl = lllllllllllllllllllIIIIllIIllIII.has(0);
            if (lllllllllllllllllllIIIIllIIllIII.has(4)) {
                if (lllllllllllllllllllIIIIllIIllIIl) {
                    throw new InvalidConstraintException(String.valueOf(new StringBuilder().append("Unexpected modifier '").append(lllllllllllllllllllIIIIllIIllIII.elem(0)).append("' in ").append(lllllllllllllllllllIIIIllIIllIII.expr).append(" parsing range")));
                }
                lllllllllllllllllllIIIIllIIllIII.max = lllllllllllllllllllIIIIllIIllIII.val(4);
                if (lllllllllllllllllllIIIIllIIllIII.max < lllllllllllllllllllIIIIllIIllIII.min) {
                    throw new InvalidConstraintException(String.valueOf(new StringBuilder().append("Invalid range specified '").append(lllllllllllllllllllIIIIllIIllIII.max).append("' is less than ").append(lllllllllllllllllllIIIIllIIllIII.min).append(" in ").append(lllllllllllllllllllIIIIllIIllIII.expr)));
                }
                return;
            }
            if (lllllllllllllllllllIIIIllIIllIII.has(6)) {
                if (lllllllllllllllllllIIIIllIIllIIl) {
                    throw new InvalidConstraintException(String.valueOf(new StringBuilder().append("Unexpected modifier '").append(lllllllllllllllllllIIIIllIIllIII.elem(0)).append("' in ").append(lllllllllllllllllllIIIIllIIllIII.expr).append(" parsing range")));
                }
                lllllllllllllllllllIIIIllIIllIII.max = lllllllllllllllllllIIIIllIIllIII.min + lllllllllllllllllllIIIIllIIllIII.val(6);
                return;
            }
            if (lllllllllllllllllllIIIIllIIllIIl) {
                if (lllllllllllllllllllIIIIllIIllIII.has(3)) {
                    throw new InvalidConstraintException(String.valueOf(new StringBuilder().append("Unexpected trailing modifier '").append(lllllllllllllllllllIIIIllIIllIII.elem(3)).append("' in ").append(lllllllllllllllllllIIIIllIIllIII.expr)));
                }
                String lllllllllllllllllllIIIIllIIlllII = lllllllllllllllllllIIIIllIIllIII.elem(0);
                if (">".equals(lllllllllllllllllllIIIIllIIlllII)) {
                    lllllllllllllllllllIIIIllIIllIII.max = Integer.MAX_VALUE;
                } else if (">=".equals(lllllllllllllllllllIIIIllIIlllII)) {
                    lllllllllllllllllllIIIIllIIllIII.max = Integer.MAX_VALUE;
                } else if ("<".equals(lllllllllllllllllllIIIIllIIlllII)) {
                    lllllllllllllllllllIIIIllIIllIII.max = --lllllllllllllllllllIIIIllIIllIII.min;
                    lllllllllllllllllllIIIIllIIllIII.min = Integer.MIN_VALUE;
                } else if ("<=".equals(lllllllllllllllllllIIIIllIIlllII)) {
                    lllllllllllllllllllIIIIllIIllIII.max = lllllllllllllllllllIIIIllIIllIII.min;
                    lllllllllllllllllllIIIIllIIllIII.min = Integer.MIN_VALUE;
                }
            } else if (lllllllllllllllllllIIIIllIIllIII.has(2)) {
                String lllllllllllllllllllIIIIllIIllIll = lllllllllllllllllllIIIIllIIllIII.elem(2);
                if ("<".equals(lllllllllllllllllllIIIIllIIllIll)) {
                    lllllllllllllllllllIIIIllIIllIII.max = lllllllllllllllllllIIIIllIIllIII.min;
                    lllllllllllllllllllIIIIllIIllIII.min = Integer.MIN_VALUE;
                } else {
                    lllllllllllllllllllIIIIllIIllIII.max = Integer.MAX_VALUE;
                }
            }
        }

        static {
            NONE = new Constraint();
            pattern = Pattern.compile("^([A-Z0-9\\-_\\.]+)\\((?:(<|<=|>|>=|=)?([0-9]+)(<|(-)([0-9]+)?|>|(\\+)([0-9]+)?)?)?\\)$");
        }

        private boolean has(int lllllllllllllllllllIIIIllIIlIIlI) {
            Constraint lllllllllllllllllllIIIIllIIlIIIl;
            return lllllllllllllllllllIIIIllIIlIIIl.constraint[lllllllllllllllllllIIIIllIIlIIlI] != null;
        }

        private int val(int lllllllllllllllllllIIIIllIIIIlII) {
            Constraint lllllllllllllllllllIIIIllIIIIlll;
            return lllllllllllllllllllIIIIllIIIIlll.constraint[lllllllllllllllllllIIIIllIIIIlII] != null ? Integer.parseInt(lllllllllllllllllllIIIIllIIIIlll.constraint[lllllllllllllllllllIIIIllIIIIlII]) : 0;
        }

        public String getToken() {
            Constraint lllllllllllllllllllIIIIlIllllIll;
            return lllllllllllllllllllIIIIlIllllIll.token;
        }
    }
}

