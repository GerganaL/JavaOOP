package LABInterfacesAndAbstraction.helloExtend;

public interface Person {
    String getName();
    default String sayHello() { return "Hello"; }

}
