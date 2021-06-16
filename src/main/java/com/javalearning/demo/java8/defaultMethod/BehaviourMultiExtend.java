package com.javalearning.demo.java8.defaultMethod;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class BehaviourMultiExtend {

    public static void main(String[] args) {

        Monster m = new Monster();

        m.rotateBy(180);
        m.moveVertically(10);


    }
}

/**
 * sun 只能旋转、移动，不能缩放
 */
class Sun implements Moveable, Rotatable {

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }
}

/**
 * 怪物可以旋转、移动、缩放
 */
class Monster implements Rotatable, Moveable, Resizable{

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }
}

/**
 * 提供旋转功能的接口
 */
interface Rotatable {
    void setRotationAngle(int angleInDegrees);
    int getRotationAngle();
    default void rotateBy(int angleInDegrees){
        setRotationAngle((getRotationAngle () + angleInDegrees) % 360);
    }
}

/**
 * 提供移动功能的接口
 */
interface Moveable {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    default void moveHorizontally(int distance){
        setX(getX() + distance);
    }
    default void moveVertically(int distance){
        setY(getY() + distance);
    }
}

/**
 * 提供缩放功能的接口
 */
interface Resizable {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
    default void setRelativeSize(int wFactor, int hFactor){
        setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
    }
}

