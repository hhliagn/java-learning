package com.javalearning.demo.test.interface2.other_case;

public class Filter {
    //filter 和 Apply 具有相同的接口元素，应该可以复用，但是因为filter没有继承Processor(不知道要这么做)，所以不能复用。
    //主要的原因是Apply.process()和Processor 耦合太紧，超出所需的程度，所以复用被禁止了。解决的办法就是把Processor做成接口。
    public String name(){
        return this.getClass().getSimpleName();
    }
    public Waveform process(Waveform input){
        return input;
    }
}
