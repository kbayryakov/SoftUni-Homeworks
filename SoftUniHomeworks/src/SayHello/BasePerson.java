package SayHello;

public class BasePerson implements Person {

    protected BasePerson(String name) {
        this.name = name;
    }

    private String name;

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String sayHello() {
        return null;
    }

}
