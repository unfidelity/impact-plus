/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.newdawn.slick.Input;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.Control;
import org.newdawn.slick.command.ControllerButtonControl;
import org.newdawn.slick.command.ControllerDirectionControl;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.command.MouseButtonControl;
import org.newdawn.slick.util.InputAdapter;

public class InputProvider {
    private /* synthetic */ ArrayList listeners;
    private /* synthetic */ HashMap commandState;
    private /* synthetic */ Input input;
    private /* synthetic */ boolean active;
    private /* synthetic */ HashMap commands;

    public boolean isCommandControlDown(Command lllllllllllllllllIlIIIlIIIIIIIII) {
        InputProvider lllllllllllllllllIlIIIlIIIIIIIIl;
        return lllllllllllllllllIlIIIlIIIIIIIIl.getState(lllllllllllllllllIlIIIlIIIIIIIII).isDown();
    }

    public void clearCommand(Command lllllllllllllllllIlIIIlIIIIlIlll) {
        InputProvider lllllllllllllllllIlIIIlIIIIllIII;
        List lllllllllllllllllIlIIIlIIIIllIIl = lllllllllllllllllIlIIIlIIIIllIII.getControlsFor(lllllllllllllllllIlIIIlIIIIlIlll);
        for (int lllllllllllllllllIlIIIlIIIIlllII = 0; lllllllllllllllllIlIIIlIIIIlllII < lllllllllllllllllIlIIIlIIIIllIIl.size(); ++lllllllllllllllllIlIIIlIIIIlllII) {
            lllllllllllllllllIlIIIlIIIIllIII.unbindCommand((Control)lllllllllllllllllIlIIIlIIIIllIIl.get(lllllllllllllllllIlIIIlIIIIlllII));
        }
    }

    public InputProvider(Input lllllllllllllllllIlIIIlIIllllIlI) {
        InputProvider lllllllllllllllllIlIIIlIIlllllII;
        lllllllllllllllllIlIIIlIIlllllII.listeners = new ArrayList();
        lllllllllllllllllIlIIIlIIlllllII.commandState = new HashMap();
        lllllllllllllllllIlIIIlIIlllllII.active = true;
        lllllllllllllllllIlIIIlIIlllllII.input = lllllllllllllllllIlIIIlIIllllIlI;
        lllllllllllllllllIlIIIlIIllllIlI.addListener(lllllllllllllllllIlIIIlIIlllllII.new InputListenerImpl());
        lllllllllllllllllIlIIIlIIlllllII.commands = new HashMap();
    }

    public List getUniqueCommands() {
        InputProvider lllllllllllllllllIlIIIlIIllIlIII;
        ArrayList<Command> lllllllllllllllllIlIIIlIIllIlIlI = new ArrayList<Command>();
        for (Command lllllllllllllllllIlIIIlIIllIlllI : lllllllllllllllllIlIIIlIIllIlIII.commands.values()) {
            if (lllllllllllllllllIlIIIlIIllIlIlI.contains(lllllllllllllllllIlIIIlIIllIlllI)) continue;
            lllllllllllllllllIlIIIlIIllIlIlI.add(lllllllllllllllllIlIIIlIIllIlllI);
        }
        return lllllllllllllllllIlIIIlIIllIlIlI;
    }

    public void setActive(boolean lllllllllllllllllIlIIIlIIIlllIIl) {
        lllllllllllllllllIlIIIlIIIlllIlI.active = lllllllllllllllllIlIIIlIIIlllIIl;
    }

    public void unbindCommand(Control lllllllllllllllllIlIIIlIIIIlIIII) {
        InputProvider lllllllllllllllllIlIIIlIIIIlIIIl;
        Command lllllllllllllllllIlIIIlIIIIIllll = (Command)lllllllllllllllllIlIIIlIIIIlIIIl.commands.remove(lllllllllllllllllIlIIIlIIIIlIIII);
        if (lllllllllllllllllIlIIIlIIIIIllll != null && !lllllllllllllllllIlIIIlIIIIlIIIl.commands.keySet().contains(lllllllllllllllllIlIIIlIIIIIllll)) {
            lllllllllllllllllIlIIIlIIIIlIIIl.commandState.remove(lllllllllllllllllIlIIIlIIIIIllll);
        }
    }

    private CommandState getState(Command lllllllllllllllllIlIIIlIIIIIlIII) {
        InputProvider lllllllllllllllllIlIIIlIIIIIIlll;
        return (CommandState)lllllllllllllllllIlIIIlIIIIIIlll.commandState.get(lllllllllllllllllIlIIIlIIIIIlIII);
    }

    public List getControlsFor(Command lllllllllllllllllIlIIIlIIlIIIlIl) {
        InputProvider lllllllllllllllllIlIIIlIIlIIIllI;
        ArrayList<Control> lllllllllllllllllIlIIIlIIlIIlIII = new ArrayList<Control>();
        for (Map.Entry lllllllllllllllllIlIIIlIIlIlIIII : lllllllllllllllllIlIIIlIIlIIIllI.commands.entrySet()) {
            Control lllllllllllllllllIlIIIlIIlIIllll = (Control)lllllllllllllllllIlIIIlIIlIlIIII.getKey();
            Command lllllllllllllllllIlIIIlIIlIIlllI = (Command)lllllllllllllllllIlIIIlIIlIlIIII.getValue();
            if (lllllllllllllllllIlIIIlIIlIIlllI != lllllllllllllllllIlIIIlIIlIIIlIl) continue;
            lllllllllllllllllIlIIIlIIlIIlIII.add(lllllllllllllllllIlIIIlIIlIIllll);
        }
        return lllllllllllllllllIlIIIlIIlIIlIII;
    }

    public boolean isCommandControlPressed(Command lllllllllllllllllIlIIIIlllllllII) {
        InputProvider lllllllllllllllllIlIIIIllllllIll;
        return lllllllllllllllllIlIIIIllllllIll.getState(lllllllllllllllllIlIIIIlllllllII).isPressed();
    }

    public void bindCommand(Control lllllllllllllllllIlIIIlIIIlIIlIl, Command lllllllllllllllllIlIIIlIIIlIIlII) {
        InputProvider lllllllllllllllllIlIIIlIIIlIIllI;
        lllllllllllllllllIlIIIlIIIlIIllI.commands.put(lllllllllllllllllIlIIIlIIIlIIlIl, lllllllllllllllllIlIIIlIIIlIIlII);
        if (lllllllllllllllllIlIIIlIIIlIIllI.commandState.get(lllllllllllllllllIlIIIlIIIlIIlII) == null) {
            lllllllllllllllllIlIIIlIIIlIIllI.commandState.put(lllllllllllllllllIlIIIlIIIlIIlII, lllllllllllllllllIlIIIlIIIlIIllI.new CommandState());
        }
    }

    public void removeListener(InputProviderListener lllllllllllllllllIlIIIlIIIlIlIlI) {
        InputProvider lllllllllllllllllIlIIIlIIIlIllIl;
        lllllllllllllllllIlIIIlIIIlIllIl.listeners.remove(lllllllllllllllllIlIIIlIIIlIlIlI);
    }

    protected void fireReleased(Command lllllllllllllllllIlIIIIllllIlIIl) {
        InputProvider lllllllllllllllllIlIIIIllllIllII;
        lllllllllllllllllIlIIIIllllIllII.getState(lllllllllllllllllIlIIIIllllIlIIl).down = false;
        if (!lllllllllllllllllIlIIIIllllIllII.isActive()) {
            return;
        }
        for (int lllllllllllllllllIlIIIIllllIllIl = 0; lllllllllllllllllIlIIIIllllIllIl < lllllllllllllllllIlIIIIllllIllII.listeners.size(); ++lllllllllllllllllIlIIIIllllIllIl) {
            ((InputProviderListener)lllllllllllllllllIlIIIIllllIllII.listeners.get(lllllllllllllllllIlIIIIllllIllIl)).controlReleased(lllllllllllllllllIlIIIIllllIlIIl);
        }
    }

    protected void firePressed(Command lllllllllllllllllIlIIIIlllllIIlI) {
        InputProvider lllllllllllllllllIlIIIIlllllIIll;
        lllllllllllllllllIlIIIIlllllIIll.getState(lllllllllllllllllIlIIIIlllllIIlI).down = true;
        lllllllllllllllllIlIIIIlllllIIll.getState(lllllllllllllllllIlIIIIlllllIIlI).pressed = true;
        if (!lllllllllllllllllIlIIIIlllllIIll.isActive()) {
            return;
        }
        for (int lllllllllllllllllIlIIIIlllllIllI = 0; lllllllllllllllllIlIIIIlllllIllI < lllllllllllllllllIlIIIIlllllIIll.listeners.size(); ++lllllllllllllllllIlIIIIlllllIllI) {
            ((InputProviderListener)lllllllllllllllllIlIIIIlllllIIll.listeners.get(lllllllllllllllllIlIIIIlllllIllI)).controlPressed(lllllllllllllllllIlIIIIlllllIIlI);
        }
    }

    public boolean isActive() {
        InputProvider lllllllllllllllllIlIIIlIIIllIllI;
        return lllllllllllllllllIlIIIlIIIllIllI.active;
    }

    public void addListener(InputProviderListener lllllllllllllllllIlIIIlIIIllIIII) {
        InputProvider lllllllllllllllllIlIIIlIIIllIIll;
        lllllllllllllllllIlIIIlIIIllIIll.listeners.add(lllllllllllllllllIlIIIlIIIllIIII);
    }

    private class InputListenerImpl
    extends InputAdapter {
        @Override
        public void controllerDownPressed(int llllllllllllllllIIllIllIIlIlIlII) {
            InputListenerImpl llllllllllllllllIIllIllIIlIllIII;
            Command llllllllllllllllIIllIllIIlIlIllI = (Command)llllllllllllllllIIllIllIIlIllIII.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIIlIlIlII, ControllerDirectionControl.DOWN));
            if (llllllllllllllllIIllIllIIlIlIllI != null) {
                llllllllllllllllIIllIllIIlIllIII.InputProvider.this.firePressed(llllllllllllllllIIllIllIIlIlIllI);
            }
        }

        @Override
        public void controllerRightPressed(int llllllllllllllllIIllIllIIllllIII) {
            InputListenerImpl llllllllllllllllIIllIllIIlllllII;
            Command llllllllllllllllIIllIllIIllllIlI = (Command)llllllllllllllllIIllIllIIlllllII.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIIllllIII, ControllerDirectionControl.RIGHT));
            if (llllllllllllllllIIllIllIIllllIlI != null) {
                llllllllllllllllIIllIllIIlllllII.InputProvider.this.firePressed(llllllllllllllllIIllIllIIllllIlI);
            }
        }

        @Override
        public void controllerUpReleased(int llllllllllllllllIIllIllIIllIIIII) {
            InputListenerImpl llllllllllllllllIIllIllIIlIllllI;
            Command llllllllllllllllIIllIllIIlIlllll = (Command)llllllllllllllllIIllIllIIlIllllI.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIIllIIIII, ControllerDirectionControl.UP));
            if (llllllllllllllllIIllIllIIlIlllll != null) {
                llllllllllllllllIIllIllIIlIllllI.InputProvider.this.fireReleased(llllllllllllllllIIllIllIIlIlllll);
            }
        }

        @Override
        public void controllerLeftReleased(int llllllllllllllllIIllIllIlIIIIIIl) {
            InputListenerImpl llllllllllllllllIIllIllIlIIIIIlI;
            Command llllllllllllllllIIllIllIlIIIIIll = (Command)llllllllllllllllIIllIllIlIIIIIlI.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIlIIIIIIl, ControllerDirectionControl.LEFT));
            if (llllllllllllllllIIllIllIlIIIIIll != null) {
                llllllllllllllllIIllIllIlIIIIIlI.InputProvider.this.fireReleased(llllllllllllllllIIllIllIlIIIIIll);
            }
        }

        @Override
        public void controllerDownReleased(int llllllllllllllllIIllIllIIlIIlIll) {
            InputListenerImpl llllllllllllllllIIllIllIIlIIllll;
            Command llllllllllllllllIIllIllIIlIIllIl = (Command)llllllllllllllllIIllIllIIlIIllll.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIIlIIlIll, ControllerDirectionControl.DOWN));
            if (llllllllllllllllIIllIllIIlIIllIl != null) {
                llllllllllllllllIIllIllIIlIIllll.InputProvider.this.fireReleased(llllllllllllllllIIllIllIIlIIllIl);
            }
        }

        @Override
        public void controllerRightReleased(int llllllllllllllllIIllIllIIlllIIlI) {
            InputListenerImpl llllllllllllllllIIllIllIIlllIIll;
            Command llllllllllllllllIIllIllIIlllIIIl = (Command)llllllllllllllllIIllIllIIlllIIll.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIIlllIIlI, ControllerDirectionControl.RIGHT));
            if (llllllllllllllllIIllIllIIlllIIIl != null) {
                llllllllllllllllIIllIllIIlllIIll.InputProvider.this.fireReleased(llllllllllllllllIIllIllIIlllIIIl);
            }
        }

        @Override
        public void controllerUpPressed(int llllllllllllllllIIllIllIIllIlIIl) {
            InputListenerImpl llllllllllllllllIIllIllIIllIIlll;
            Command llllllllllllllllIIllIllIIllIlIII = (Command)llllllllllllllllIIllIllIIllIIlll.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIIllIlIIl, ControllerDirectionControl.UP));
            if (llllllllllllllllIIllIllIIllIlIII != null) {
                llllllllllllllllIIllIllIIllIIlll.InputProvider.this.firePressed(llllllllllllllllIIllIllIIllIlIII);
            }
        }

        @Override
        public void controllerButtonReleased(int llllllllllllllllIIllIllIIIlllIII, int llllllllllllllllIIllIllIIIllIlll) {
            InputListenerImpl llllllllllllllllIIllIllIIIlllIIl;
            Command llllllllllllllllIIllIllIIIllIllI = (Command)llllllllllllllllIIllIllIIIlllIIl.InputProvider.this.commands.get(new ControllerButtonControl(llllllllllllllllIIllIllIIIlllIII, llllllllllllllllIIllIllIIIllIlll));
            if (llllllllllllllllIIllIllIIIllIllI != null) {
                llllllllllllllllIIllIllIIIlllIIl.InputProvider.this.fireReleased(llllllllllllllllIIllIllIIIllIllI);
            }
        }

        @Override
        public boolean isAcceptingInput() {
            return true;
        }

        @Override
        public void keyReleased(int llllllllllllllllIIllIllIlIlIlIIl, char llllllllllllllllIIllIllIlIlIllII) {
            InputListenerImpl llllllllllllllllIIllIllIlIlIlIlI;
            Command llllllllllllllllIIllIllIlIlIlIll = (Command)llllllllllllllllIIllIllIlIlIlIlI.InputProvider.this.commands.get(new KeyControl(llllllllllllllllIIllIllIlIlIlIIl));
            if (llllllllllllllllIIllIllIlIlIlIll != null) {
                llllllllllllllllIIllIllIlIlIlIlI.InputProvider.this.fireReleased(llllllllllllllllIIllIllIlIlIlIll);
            }
        }

        @Override
        public void mouseReleased(int llllllllllllllllIIllIllIlIIllIII, int llllllllllllllllIIllIllIlIIlIlll, int llllllllllllllllIIllIllIlIIlIllI) {
            InputListenerImpl llllllllllllllllIIllIllIlIIlIlII;
            Command llllllllllllllllIIllIllIlIIlIlIl = (Command)llllllllllllllllIIllIllIlIIlIlII.InputProvider.this.commands.get(new MouseButtonControl(llllllllllllllllIIllIllIlIIllIII));
            if (llllllllllllllllIIllIllIlIIlIlIl != null) {
                llllllllllllllllIIllIllIlIIlIlII.InputProvider.this.fireReleased(llllllllllllllllIIllIllIlIIlIlIl);
            }
        }

        @Override
        public void keyPressed(int llllllllllllllllIIllIllIlIllIIll, char llllllllllllllllIIllIllIlIllIllI) {
            InputListenerImpl llllllllllllllllIIllIllIlIllIlII;
            Command llllllllllllllllIIllIllIlIllIlIl = (Command)llllllllllllllllIIllIllIlIllIlII.InputProvider.this.commands.get(new KeyControl(llllllllllllllllIIllIllIlIllIIll));
            if (llllllllllllllllIIllIllIlIllIlIl != null) {
                llllllllllllllllIIllIllIlIllIlII.InputProvider.this.firePressed(llllllllllllllllIIllIllIlIllIlIl);
            }
        }

        @Override
        public void controllerLeftPressed(int llllllllllllllllIIllIllIlIIIlIlI) {
            InputListenerImpl llllllllllllllllIIllIllIlIIIlIll;
            Command llllllllllllllllIIllIllIlIIIllII = (Command)llllllllllllllllIIllIllIlIIIlIll.InputProvider.this.commands.get(new ControllerDirectionControl(llllllllllllllllIIllIllIlIIIlIlI, ControllerDirectionControl.LEFT));
            if (llllllllllllllllIIllIllIlIIIllII != null) {
                llllllllllllllllIIllIllIlIIIlIll.InputProvider.this.firePressed(llllllllllllllllIIllIllIlIIIllII);
            }
        }

        @Override
        public void controllerButtonPressed(int llllllllllllllllIIllIllIIlIIIlII, int llllllllllllllllIIllIllIIlIIIIll) {
            InputListenerImpl llllllllllllllllIIllIllIIlIIIlIl;
            Command llllllllllllllllIIllIllIIlIIIIlI = (Command)llllllllllllllllIIllIllIIlIIIlIl.InputProvider.this.commands.get(new ControllerButtonControl(llllllllllllllllIIllIllIIlIIIlII, llllllllllllllllIIllIllIIlIIIIll));
            if (llllllllllllllllIIllIllIIlIIIIlI != null) {
                llllllllllllllllIIllIllIIlIIIlIl.InputProvider.this.firePressed(llllllllllllllllIIllIllIIlIIIIlI);
            }
        }

        private InputListenerImpl() {
            InputListenerImpl llllllllllllllllIIllIllIlIlllllI;
        }

        @Override
        public void mousePressed(int llllllllllllllllIIllIllIlIIllllI, int llllllllllllllllIIllIllIlIlIIIlI, int llllllllllllllllIIllIllIlIlIIIIl) {
            InputListenerImpl llllllllllllllllIIllIllIlIlIIlII;
            Command llllllllllllllllIIllIllIlIlIIIII = (Command)llllllllllllllllIIllIllIlIlIIlII.InputProvider.this.commands.get(new MouseButtonControl(llllllllllllllllIIllIllIlIIllllI));
            if (llllllllllllllllIIllIllIlIlIIIII != null) {
                llllllllllllllllIIllIllIlIlIIlII.InputProvider.this.firePressed(llllllllllllllllIIllIllIlIlIIIII);
            }
        }
    }

    private class CommandState {
        private /* synthetic */ boolean down;
        private /* synthetic */ boolean pressed;

        private CommandState() {
            CommandState lllIIlIllIIIlI;
        }

        public boolean isPressed() {
            CommandState lllIIlIlIlllIl;
            if (lllIIlIlIlllIl.pressed) {
                lllIIlIlIlllIl.pressed = false;
                return true;
            }
            return false;
        }

        public boolean isDown() {
            CommandState lllIIlIlIllIlI;
            return lllIIlIlIllIlI.down;
        }
    }
}

