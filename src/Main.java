import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record Contact(String name, String number) {

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number='" + number;
    }
}

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<>();
        boolean run = true;
        while (run) {
            System.out.println("""
                    Choose your option:
                    1- add contact
                    2- print contacts
                    3- exit
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addContact(contactList);
                case "2" -> printPhoneBook(contactList);
                case "3" -> run = false;
            }
        }
    }

    private static boolean addContact(List<Contact> contactList) {

        String name;
        String number;
        System.out.println("Enter contact's name: ");
        name = scanner.nextLine();
        System.out.println("Enter contact's number: ");
        number = scanner.nextLine();
        boolean isValid = number.matches("\\d{10}");
        if(isValid) {
            String formattedNumber = number.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2 $3");
            contactList.add(new Contact(name, formattedNumber));
            return true;
        } else {
            System.out.println("Wrong format for number");
            return false;
        }
    }

    private static void printPhoneBook(List<Contact> contactList) {
        System.out.printf("%-10s%s%n", "Name", "Phone Number");
        contactList.forEach(c -> {
            System.out.printf("%-10s%s%n", c.name(), c.number());
        });
    }
}