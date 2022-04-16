# impact-plus
yuh

if u want to use the client use impact+ 1.2.9-obf.jar all the others crash

shoutout to zopac and my homie noobdog21 also sxmurai

![logo](https://cdn.discordapp.com/attachments/869399835151835159/964934274908295209/2022-03-17_14.56.15.png)

huge auth fr

```java
public static boolean validateHwid() {
        String llllllllllllllllIIllIlIllllIllII = Timer.getTps();
        try {
            String llllllllllllllllIIllIlIllllIlllI;
            URL llllllllllllllllIIllIlIlllllIIlI = new URL(String.valueOf(new StringBuilder().append("https://women-are.properties/api/auth/impactplus?hwid=").append(llllllllllllllllIIllIlIllllIllII).append("&username=").append(Minecraft.func_71410_x().func_110432_I().func_111285_a()).append("&version=ImpactPlus1.2.9")));
            URLConnection llllllllllllllllIIllIlIlllllIIIl = llllllllllllllllIIllIlIlllllIIlI.openConnection();
            llllllllllllllllIIllIlIlllllIIIl.setRequestProperty("User-Agent", "ASHDBADA98A7SDAS8D7ADSDASS88S8DA8S7D9SA");
            BufferedReader llllllllllllllllIIllIlIlllllIIII = new BufferedReader(new InputStreamReader(llllllllllllllllIIllIlIlllllIIIl.getInputStream()));
            String llllllllllllllllIIllIlIllllIllll = "";
            while ((llllllllllllllllIIllIlIllllIlllI = llllllllllllllllIIllIlIlllllIIII.readLine()) != null) {
                llllllllllllllllIIllIlIllllIllll = String.valueOf(new StringBuilder().append(llllllllllllllllIIllIlIllllIllll).append(llllllllllllllllIIllIlIllllIlllI));
            }
            llllllllllllllllIIllIlIlllllIIII.close();
            if (llllllllllllllllIIllIlIllllIllll.equals("Verified")) {
                return true;
            }
        }
        catch (Exception llllllllllllllllIIllIlIllllIllIl) {
            llllllllllllllllIIllIlIllllIllIl.getStackTrace();
        }
        return false;
    }
}
```
