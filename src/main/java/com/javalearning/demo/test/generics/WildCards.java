package com.javalearning.demo.test.generics;

public class WildCards {
    static void rawArgs(Holder3 holder3, Object args){
        //原生类型可以随便set,但会警告
//        holder3.set(args); //warning
//        holder3.set(new WildCards()); //warning
//        T t = holder3.get();
        Object o = holder3.get();
    }
    static void unboundArgs(Holder3<?> holder3, Object args){
        //有？不能随便set,会报错
//        holder3.set(args); //error
//        holder3.set(new WildCards()); //error
//        T t = holder3.get();
        Object o = holder3.get();
    }
    static <T> T exact1(Holder3<T> holder3){
        return holder3.get();
    }
    static <T> T exact2(Holder3<T> holder3, T args){
        holder3.set(args);
        T t = holder3.get();
        return t;
    }
    static <T> T wildSubType(Holder3<? extends T> holder3, T args){
//        holder3.set(args);
        T t = holder3.get();
        return t;
    }
    static <T> void wildSuperType(Holder3<? super T> holder3, T args){
        holder3.set(args);
        Object object = holder3.get();
    }

    public static void main(String[] args) {
        Holder3 holderRaw = new Holder3<Long>(100L);
        Holder3<Long> holderQulified = new Holder3<Long>(100L);
        Holder3<?> holderUnbound = new Holder3<Long>(100L);
        Holder3<? extends Long> holderBound = new Holder3<Long>(100L);
        Long lng = 1L;

        rawArgs(holderRaw, lng);
        rawArgs(holderQulified, lng);
        rawArgs(holderUnbound, lng);
        rawArgs(holderBound, lng);

        unboundArgs(holderRaw, lng);
        unboundArgs(holderQulified, lng);
        unboundArgs(holderUnbound, lng);
        unboundArgs(holderBound, lng);

//        exact1(holderRaw); //warning
        Long aLong2 = exact1(holderQulified);
        Object o1 = exact1(holderUnbound);
        Long aLong3 = exact1(holderBound);

//        exact2(holderRaw, lng); //warning
        Long aLong4 = exact2(holderQulified, lng);
//        exact2(holderUnbound, lng); //error
//        exact2(holderBound, lng); //error

//        wildSubType(holderRaw, lng); //warning
        Long aLong = wildSubType(holderQulified, lng);
        Object o = wildSubType(holderUnbound, lng);
        Long aLong1 = wildSubType(holderBound, lng);

//        wildSuperType(holderRaw, lng); //warning
        wildSuperType(holderQulified, lng);
//        wildSuperType(holderUnbound, lng); //error
//        wildSuperType(holderBound, lng); //error
    }
}
