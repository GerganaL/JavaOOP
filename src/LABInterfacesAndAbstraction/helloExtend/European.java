package LABInterfacesAndAbstraction.helloExtend;

public class European extends BasePerson{
    private String name;

    public European(String name){
        super(name);
    }


    public String getName() {
        return this.name;
    }

}
