public class Main {
    public static void main(String args[]) throws Exception {
        ContactsManager contactsManager = new ContactsManager();
        ContactsOrgenizer contactsOrgenizer = new ContactsOrgenizer();
        contactsOrgenizer.menu(contactsManager);
    }
}
