public class ContactCard {
    private String name;
    private String number;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContactCard(String pname, String num){
        name = pname;
        number = num;
    }
    public String toString(ContactCard card){
        return String.format("%s, %s", name, number);
    }


}
