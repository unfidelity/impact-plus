/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import org.newdawn.slick.font.effects.ConfigurableEffect;

public class EffectUtil {
    private static /* synthetic */ BufferedImage scratchImage;

    public static BufferedImage getScratchImage() {
        Graphics2D llIIIIlIIIIIlIl = (Graphics2D)scratchImage.getGraphics();
        llIIIIlIIIIIlIl.setComposite(AlphaComposite.Clear);
        llIIIIlIIIIIlIl.fillRect(0, 0, 256, 256);
        llIIIIlIIIIIlIl.setComposite(AlphaComposite.SrcOver);
        llIIIIlIIIIIlIl.setColor(Color.white);
        return scratchImage;
    }

    public static ConfigurableEffect.Value intValue(String llIIIIIllllIlll, final int llIIIIIlllllIIl, final String llIIIIIllllIlIl) {
        return new DefaultValue(llIIIIIllllIlll, String.valueOf(llIIIIIlllllIIl)){

            @Override
            public Object getObject() {
                2 lllllllllllllllIllllIllllIIIlIIl;
                return Integer.valueOf(lllllllllllllllIllllIllllIIIlIIl.value);
            }
            {
                2 lllllllllllllllIllllIllllIlIIIll;
                super(lllllllllllllllIllllIllllIlIIIII, lllllllllllllllIllllIllllIlIIlII);
            }

            @Override
            public void showDialog() {
                2 lllllllllllllllIllllIllllIIlIIIl;
                JSpinner lllllllllllllllIllllIllllIIlIIll = new JSpinner(new SpinnerNumberModel(lllllllllllllllIllllIllllIIlIIIl.llIIIIIlllllIIl, Short.MIN_VALUE, Short.MAX_VALUE, 1));
                if (lllllllllllllllIllllIllllIIlIIIl.showValueDialog(lllllllllllllllIllllIllllIIlIIll, lllllllllllllllIllllIllllIIlIIIl.llIIIIIllllIlIl)) {
                    lllllllllllllllIllllIllllIIlIIIl.value = String.valueOf(lllllllllllllllIllllIllllIIlIIll.getValue());
                }
            }
        };
    }

    public static ConfigurableEffect.Value optionValue(String llIIIIIllIllIII, final String llIIIIIllIlIIll, final String[][] llIIIIIllIlIllI, final String llIIIIIllIlIlIl) {
        return new DefaultValue(llIIIIIllIllIII, llIIIIIllIlIIll.toString()){

            private String getValue(int llllllllllllllllIIIIllllIIIIIIIl) {
                5 llllllllllllllllIIIIllllIIIIIIlI;
                if (llllllllllllllllIIIIllllIIIIIIlI.llIIIIIllIlIllI[llllllllllllllllIIIIllllIIIIIIIl].length == 1) {
                    return llllllllllllllllIIIIllllIIIIIIlI.llIIIIIllIlIllI[llllllllllllllllIIIIllllIIIIIIIl][0];
                }
                return llllllllllllllllIIIIllllIIIIIIlI.llIIIIIllIlIllI[llllllllllllllllIIIIllllIIIIIIIl][1];
            }

            @Override
            public void showDialog() {
                5 llllllllllllllllIIIIllllIIIIlllI;
                int llllllllllllllllIIIIllllIIIIllIl = -1;
                DefaultComboBoxModel<String> llllllllllllllllIIIIllllIIIIllII = new DefaultComboBoxModel<String>();
                for (int llllllllllllllllIIIIllllIIIIllll = 0; llllllllllllllllIIIIllllIIIIllll < llllllllllllllllIIIIllllIIIIlllI.llIIIIIllIlIllI.length; ++llllllllllllllllIIIIllllIIIIllll) {
                    llllllllllllllllIIIIllllIIIIllII.addElement(llllllllllllllllIIIIllllIIIIlllI.llIIIIIllIlIllI[llllllllllllllllIIIIllllIIIIllll][0]);
                    if (!llllllllllllllllIIIIllllIIIIlllI.getValue(llllllllllllllllIIIIllllIIIIllll).equals(llllllllllllllllIIIIllllIIIIlllI.llIIIIIllIlIIll)) continue;
                    llllllllllllllllIIIIllllIIIIllIl = llllllllllllllllIIIIllllIIIIllll;
                }
                JComboBox llllllllllllllllIIIIllllIIIIlIll = new JComboBox(llllllllllllllllIIIIllllIIIIllII);
                llllllllllllllllIIIIllllIIIIlIll.setSelectedIndex(llllllllllllllllIIIIllllIIIIllIl);
                if (llllllllllllllllIIIIllllIIIIlllI.showValueDialog(llllllllllllllllIIIIllllIIIIlIll, llllllllllllllllIIIIllllIIIIlllI.llIIIIIllIlIlIl)) {
                    llllllllllllllllIIIIllllIIIIlllI.value = llllllllllllllllIIIIllllIIIIlllI.getValue(llllllllllllllllIIIIllllIIIIlIll.getSelectedIndex());
                }
            }

            @Override
            public String toString() {
                5 llllllllllllllllIIIIlllIllllllIl;
                for (int llllllllllllllllIIIIlllIlllllllI = 0; llllllllllllllllIIIIlllIlllllllI < llllllllllllllllIIIIlllIllllllIl.llIIIIIllIlIllI.length; ++llllllllllllllllIIIIlllIlllllllI) {
                    if (!llllllllllllllllIIIIlllIllllllIl.getValue(llllllllllllllllIIIIlllIlllllllI).equals(llllllllllllllllIIIIlllIllllllIl.value)) continue;
                    return llllllllllllllllIIIIlllIllllllIl.llIIIIIllIlIllI[llllllllllllllllIIIIlllIlllllllI][0].toString();
                }
                return "";
            }

            @Override
            public Object getObject() {
                5 llllllllllllllllIIIIlllIlllllIII;
                return llllllllllllllllIIIIlllIlllllIII.value;
            }
            {
                5 llllllllllllllllIIIIllllIIIlllII;
                super(llllllllllllllllIIIIllllIIIllIII, llllllllllllllllIIIIllllIIIllIlI);
            }
        };
    }

    public static String toString(Color llIIIIIllIIlIII) {
        String llIIIIIllIIlIIl;
        String llIIIIIllIIlIlI;
        if (llIIIIIllIIlIII == null) {
            throw new IllegalArgumentException("color cannot be null.");
        }
        String llIIIIIllIIlIll = Integer.toHexString(llIIIIIllIIlIII.getRed());
        if (llIIIIIllIIlIll.length() == 1) {
            llIIIIIllIIlIll = String.valueOf(new StringBuilder().append("0").append(llIIIIIllIIlIll));
        }
        if ((llIIIIIllIIlIlI = Integer.toHexString(llIIIIIllIIlIII.getGreen())).length() == 1) {
            llIIIIIllIIlIlI = String.valueOf(new StringBuilder().append("0").append(llIIIIIllIIlIlI));
        }
        if ((llIIIIIllIIlIIl = Integer.toHexString(llIIIIIllIIlIII.getBlue())).length() == 1) {
            llIIIIIllIIlIIl = String.valueOf(new StringBuilder().append("0").append(llIIIIIllIIlIIl));
        }
        return String.valueOf(new StringBuilder().append(llIIIIIllIIlIll).append(llIIIIIllIIlIlI).append(llIIIIIllIIlIIl));
    }

    public static Color fromString(String llIIIIIllIIIIll) {
        if (llIIIIIllIIIIll == null || llIIIIIllIIIIll.length() != 6) {
            return Color.white;
        }
        return new Color(Integer.parseInt(llIIIIIllIIIIll.substring(0, 2), 16), Integer.parseInt(llIIIIIllIIIIll.substring(2, 4), 16), Integer.parseInt(llIIIIIllIIIIll.substring(4, 6), 16));
    }

    public static ConfigurableEffect.Value floatValue(String llIIIIIlllIllll, final float llIIIIIlllIlIIl, final float llIIIIIlllIllIl, final float llIIIIIlllIIlll, final String llIIIIIlllIlIll) {
        return new DefaultValue(llIIIIIlllIllll, String.valueOf(llIIIIIlllIlIIl)){

            @Override
            public Object getObject() {
                3 llllllllllllllllIIllIIlllIIlIIlI;
                return Float.valueOf(llllllllllllllllIIllIIlllIIlIIlI.value);
            }

            @Override
            public void showDialog() {
                3 llllllllllllllllIIllIIlllIIllIII;
                JSpinner llllllllllllllllIIllIIlllIIlIlll = new JSpinner(new SpinnerNumberModel(llllllllllllllllIIllIIlllIIllIII.llIIIIIlllIlIIl, llllllllllllllllIIllIIlllIIllIII.llIIIIIlllIllIl, llllllllllllllllIIllIIlllIIllIII.llIIIIIlllIIlll, 0.1f));
                if (llllllllllllllllIIllIIlllIIllIII.showValueDialog(llllllllllllllllIIllIIlllIIlIlll, llllllllllllllllIIllIIlllIIllIII.llIIIIIlllIlIll)) {
                    llllllllllllllllIIllIIlllIIllIII.value = String.valueOf(((Double)llllllllllllllllIIllIIlllIIlIlll.getValue()).floatValue());
                }
            }
            {
                3 llllllllllllllllIIllIIlllIlIIlII;
                super(llllllllllllllllIIllIIlllIlIIIll, llllllllllllllllIIllIIlllIlIIIlI);
            }
        };
    }

    public EffectUtil() {
        EffectUtil llIIIIlIIIIIlll;
    }

    public static ConfigurableEffect.Value colorValue(String llIIIIIllllllll, Color llIIIIIlllllllI) {
        return new DefaultValue(llIIIIIllllllll, EffectUtil.toString(llIIIIIlllllllI)){
            {
                1 lllllllllllllllIllllllIllIllIlII;
            }

            @Override
            public Object getObject() {
                1 lllllllllllllllIllllllIllIIlllII;
                return EffectUtil.fromString(lllllllllllllllIllllllIllIIlllII.value);
            }

            @Override
            public void showDialog() {
                1 lllllllllllllllIllllllIllIlIIllI;
                Color lllllllllllllllIllllllIllIlIIlII = JColorChooser.showDialog(null, "Choose a color", EffectUtil.fromString(lllllllllllllllIllllllIllIlIIllI.value));
                if (lllllllllllllllIllllllIllIlIIlII != null) {
                    lllllllllllllllIllllllIllIlIIllI.value = EffectUtil.toString(lllllllllllllllIllllllIllIlIIlII);
                }
            }
        };
    }

    static {
        scratchImage = new BufferedImage(256, 256, 2);
    }

    public static ConfigurableEffect.Value booleanValue(String llIIIIIlllIIIlI, final boolean llIIIIIllIllllI, final String llIIIIIllIlllIl) {
        return new DefaultValue(llIIIIIlllIIIlI, String.valueOf(llIIIIIllIllllI)){

            @Override
            public void showDialog() {
                4 lllllIIlIIlIllI;
                JCheckBox lllllIIlIIlIlIl = new JCheckBox();
                lllllIIlIIlIlIl.setSelected(lllllIIlIIlIllI.llIIIIIllIllllI);
                if (lllllIIlIIlIllI.showValueDialog(lllllIIlIIlIlIl, lllllIIlIIlIllI.llIIIIIllIlllIl)) {
                    lllllIIlIIlIllI.value = String.valueOf(lllllIIlIIlIlIl.isSelected());
                }
            }
            {
                4 lllllIIlIlIIIII;
                super(lllllIIlIIlllII, lllllIIlIIllIll);
            }

            @Override
            public Object getObject() {
                4 lllllIIlIIlIIIl;
                return Boolean.valueOf(lllllIIlIIlIIIl.value);
            }
        };
    }

    private static abstract class DefaultValue
    implements ConfigurableEffect.Value {
        /* synthetic */ String value;
        /* synthetic */ String name;

        @Override
        public void setString(String llIIlllIIlllIII) {
            llIIlllIIllIlll.value = llIIlllIIlllIII;
        }

        @Override
        public String getName() {
            DefaultValue llIIlllIIllIIIl;
            return llIIlllIIllIIIl.name;
        }

        public String toString() {
            DefaultValue llIIlllIIlIlllI;
            if (llIIlllIIlIlllI.value == null) {
                return "";
            }
            return llIIlllIIlIlllI.value.toString();
        }

        @Override
        public String getString() {
            DefaultValue llIIlllIIllIlII;
            return llIIlllIIllIlII.value;
        }

        public DefaultValue(String llIIlllIIllllIl, String llIIlllIIllllII) {
            DefaultValue llIIlllIlIIIIIl;
            llIIlllIlIIIIIl.value = llIIlllIIllllII;
            llIIlllIlIIIIIl.name = llIIlllIIllllIl;
        }

        public boolean showValueDialog(final JComponent llIIlllIIlIIIll, String llIIlllIIlIIIlI) {
            DefaultValue llIIlllIIlIlIII;
            ValueDialog llIIlllIIlIIlIl = new ValueDialog(llIIlllIIlIIIll, llIIlllIIlIlIII.name, llIIlllIIlIIIlI);
            llIIlllIIlIIlIl.setTitle(llIIlllIIlIlIII.name);
            llIIlllIIlIIlIl.setLocationRelativeTo(null);
            EventQueue.invokeLater(new Runnable(){
                {
                    1 lIIIlIIlIIIlI;
                }

                @Override
                public void run() {
                    1 lIIIlIIIllIll;
                    JComponent lIIIlIIIlllII = lIIIlIIIllIll.llIIlllIIlIIIll;
                    if (lIIIlIIIlllII instanceof JSpinner) {
                        lIIIlIIIlllII = ((JSpinner.DefaultEditor)((JSpinner)lIIIlIIIllIll.llIIlllIIlIIIll).getEditor()).getTextField();
                    }
                    lIIIlIIIlllII.requestFocusInWindow();
                }
            });
            llIIlllIIlIIlIl.setVisible(true);
            return llIIlllIIlIIlIl.okPressed;
        }
    }

    private static class ValueDialog
    extends JDialog {
        public /* synthetic */ boolean okPressed;

        public ValueDialog(JComponent llIlIlIlllIIIIl, String llIlIlIlllIIlll, String llIlIlIllIlllll) {
            ValueDialog llIlIlIlllIlIIl;
            llIlIlIlllIlIIl.okPressed = false;
            llIlIlIlllIlIIl.setDefaultCloseOperation(2);
            llIlIlIlllIlIIl.setLayout(new GridBagLayout());
            llIlIlIlllIlIIl.setModal(true);
            if (llIlIlIlllIIIIl instanceof JSpinner) {
                ((JSpinner.DefaultEditor)((JSpinner)llIlIlIlllIIIIl).getEditor()).getTextField().setColumns(4);
            }
            JPanel llIlIlIlllIIlIl = new JPanel();
            llIlIlIlllIIlIl.setLayout(new GridBagLayout());
            llIlIlIlllIlIIl.getContentPane().add((Component)llIlIlIlllIIlIl, new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
            llIlIlIlllIIlIl.setBackground(Color.white);
            llIlIlIlllIIlIl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            JTextArea llIlIlIlllIllII = new JTextArea(llIlIlIllIlllll);
            llIlIlIlllIIlIl.add((Component)llIlIlIlllIllII, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
            llIlIlIlllIllII.setWrapStyleWord(true);
            llIlIlIlllIllII.setLineWrap(true);
            llIlIlIlllIllII.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            llIlIlIlllIllII.setEditable(false);
            JPanel llIlIlIlllIIlII = new JPanel();
            llIlIlIlllIlIIl.getContentPane().add((Component)llIlIlIlllIIlII, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, 10, 0, new Insets(5, 5, 0, 5), 0, 0));
            llIlIlIlllIIlII.add(new JLabel(String.valueOf(new StringBuilder().append(llIlIlIlllIIlll).append(":"))));
            llIlIlIlllIIlII.add(llIlIlIlllIIIIl);
            JPanel llIlIlIlllIIIll = new JPanel();
            llIlIlIlllIlIIl.getContentPane().add((Component)llIlIlIlllIIIll, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, 13, 0, new Insets(0, 0, 0, 0), 0, 0));
            JButton llIlIlIlllIlIll = new JButton("OK");
            llIlIlIlllIIIll.add(llIlIlIlllIlIll);
            llIlIlIlllIlIll.addActionListener(new ActionListener(){
                {
                    1 lllllllllllllllllIIllIlIllIlIIII;
                }

                @Override
                public void actionPerformed(ActionEvent lllllllllllllllllIIllIlIllIIllII) {
                    1 lllllllllllllllllIIllIlIllIIllIl;
                    lllllllllllllllllIIllIlIllIIllIl.ValueDialog.this.okPressed = true;
                    lllllllllllllllllIIllIlIllIIllIl.ValueDialog.this.setVisible(false);
                }
            });
            JButton llIlIlIlllIlIlI = new JButton("Cancel");
            llIlIlIlllIIIll.add(llIlIlIlllIlIlI);
            llIlIlIlllIlIlI.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent lllllllllllllllllllIIlIIllllIlll) {
                    2 lllllllllllllllllllIIlIIlllllIII;
                    lllllllllllllllllllIIlIIlllllIII.ValueDialog.this.setVisible(false);
                }
                {
                    2 lllllllllllllllllllIIlIIllllllII;
                }
            });
            llIlIlIlllIlIIl.setSize(new Dimension(320, 175));
        }
    }
}

