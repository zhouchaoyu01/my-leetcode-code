/**
 * @author ChanceZhou
 * @code this file2022-01-25-18:35
 */
//class Something {
//    public static void main(String[] something_to_do) {
//        System.out.println("Do something ...");
//    } }

/*
interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
        System.out.println(x);
    }
    public static void main(String[] args) {
        new C().pX();
    } }*/
/*
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable,
        Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name; }
    public Ball(String name) {
        this.name = name; }
    public void play() {
        ball = new Ball("Football");
        System.out.println(ball.getName());
    } }*/