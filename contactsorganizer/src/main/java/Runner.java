import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main (String args[]) throws Exception {
        // Add another
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("occupation","programmer");
        properties.put("age","32");



        ContactsManager contactsManager = new ContactsManager();
        contactsManager.add("efi", "052-2505011", "efio@radware.com",properties);
        contactsManager.add("limor", "052-8357712", "limor@radware.com", properties);
//        contactsManager.remove("eli");
        System.out.println(contactsManager.getContacts());
        contactsManager.add("efi", "052-2505011", "efio@radware.com",properties);
        contactsManager.update("eli", "054-2505011", "efio@radware.com",properties);

        System.out.println(contactsManager.query1("efi"));
        System.out.println(contactsManager.query2("efi"));
//        contactsManager.save((HashMap<String, Contact>) contactsManager.getContacts());
//        contactsManager.save("created_file_for_efi");
//        System.out.println("---  Read data from file and print it   ----");
//        contactsManager.read("created_file_for_efi");

    }
}
