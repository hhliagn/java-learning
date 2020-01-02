package com.javalearning.demo.test.extending_interface;

public class HorrorShow {
    static void a(Monster monster){
        monster.mence();
    }
    static void b(DangerousMonster dangerousMonster){
        dangerousMonster.destroy();
    }
    static void c(Lethal lethal){
        lethal.kill();
    }
    public static void main(String[] args) {
        DangerousMonster dangerousMonster = new DragonZilla();
        a(dangerousMonster);
        b(dangerousMonster);
        Vampire vampire = new VeryBadVampire();
        a(vampire);
        b(vampire);
        c(vampire);
    }
}
