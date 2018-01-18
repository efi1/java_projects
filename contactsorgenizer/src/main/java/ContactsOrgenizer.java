import java.util.InputMismatchException;
import java.util.Scanner;

class ContactsOrgenizer {


    void menu(ContactsManager contactsManager) throws Exception {
        String fn = "contents_data.txt";
        contactsManager.read(fn);
        Boolean respBool;
        int choice;
        int menu = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println(" 1. Add a new contact ");
            System.out.println(" 2. Remove an exist contact ");
            System.out.println(" 3. Update an exist contact ");
            System.out.println(" 4. Display contact by name ");
            System.out.println(" 5. Display all contacts");
            System.out.println(" 6. Save contacts to disk");
            System.out.println(" 7. Read contacts from disk");
            System.out.println(" 8. Exit ");
            try {
                menu = input.nextInt();
            } catch (InputMismatchException ex) {
                input.nextLine();
            }
            choice = 1;
            switch (menu) {
                case 1:
                    while (choice != 2) {
                        System.out.println("Enter new contact to be added: ");
                        userContactInputs(input);
                        respBool = contactsManager.add(name, mobile, email);
                        if (!respBool) {
                            System.out.format("The contact %s already exists - it won\'t be added", name).println();
                        }
                        choice = verifyUserInput(input, choice);
                    }
                    break;
                case 2:
                    while (choice != 2) {
                        System.out.println("Enter the contact's name, to be removed: ");
                        name = input.next();
                        respBool = contactsManager.remove(name);
                        if (!respBool) {
                            System.out.format("a contact with the name %s doesn't exist", name).println();
                        }
                        choice = verifyUserInput(input, choice);
                    }
                    break;
                case 3:
                    while (choice != 2) {
                        System.out.println("Enter the contact's name, to be updated: ");
                        userContactInputs(input);
                        respBool = contactsManager.update(name, mobile, email);
                        if (!respBool) {
                            System.out.format("a contact with the name %s doesn't exist", name).println();
                        }
                        choice = verifyUserInput(input, choice);
                    }
                    break;
                case 4:
                    while (choice != 2) {
                        System.out.println("Enter the contact's name, to be queried: ");
                        name = input.next();
                        if (contactsManager.query(name) == null) {
                            System.out.format("no contact under the name: %s", name).println();
                        } else {
                            System.out.println(contactsManager.query(name));
                        }
                        choice = verifyUserInput(input, choice);
                    }
                    break;
                case 5:
                    System.out.println(contactsManager.getContacts());
                    break;
                case 6:
                    contactsManager.save();
                    break;
                case 7:
                    contactsManager.read(fn);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("** valid inputs are (1 - 8) **\n");
                    break;
            }

        } while (menu != 8);

        contactsManager.save();

    }

    private void userContactInputs(Scanner input) {
        System.out.println("Enter contacts' name: ");
        name = input.next();
        System.out.println("Enter contacts' mobile: ");
        mobile = input.next();
        System.out.println("Enter contacts' email: ");
        email = input.next();
    }

    private int verifyUserInput(Scanner input, int choice) {
        do {
            System.out.println("Enter another? 1: Yes, 2: No");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\n** Error: Invalid input **\n");
                input.nextLine();
                choice = 2;
                return choice;
            }
        }
        while (choice != 1 && choice != 2);
        {
        }
        return choice;
    }

    private String name;
    private String mobile;
    private String email;

}
