package EXERCISEExceptionsAndErrorHandling.validPerson;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
       this.setName(name);
       this.setEmail(email);
    }

    public void setName(String name) {
        char[] nameSymbols = name.toCharArray();
        for (char nameSymbol : nameSymbols) {
            if(!Character.isAlphabetic(nameSymbol)){
                try {
                    throw  new InvalidPersonNameException("Name must contain only letters");
                } catch (InvalidPersonNameException e) {
                    e.printStackTrace();
                }
            }
        }
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
