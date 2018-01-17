import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main (String args[]) throws Exception {
        ContactsManager contactsManager = new ContactsManager();
        contactsManager.add("efi", "052-2505011", "efio@radware.com");
        contactsManager.add("limor", "052-8357712", "limor@radware.com");
//        contactsManager.remove("eli");
//        System.out.println(contactsManager.getContacts());
        contactsManager.add("efi", "052-2505011", "efio@radware.com");
        contactsManager.update("eli", "054-2505011", "efio@radware.com");

//        System.out.println(contactsManager.query1("efi"));
//        System.out.println(contactsManager.query2("efi"));



//        contactsManager.save("created_file_for_efi");
//        System.out.println("---  Read data from file and print it   ----");
//        contactsManager.read("created_file_for_efi");


        contactsManager.writeToFile(contactsManager.getContacts(), "written_data_file");
        contactsManager.readFromFile("written_data_file");
    }
}
