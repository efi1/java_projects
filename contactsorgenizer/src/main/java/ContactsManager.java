import java.io.*;
import java.util.*;
import java.util.Scanner;


public class ContactsManager {

    public ContactsManager() {
        read(fn);
    }


    public void getSortedContacts() {
        Map<String, Contact> sortedContacts = new TreeMap<String, Contact>(contacts);
        for (Map.Entry<String, Contact> entry : sortedContacts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    public void getContacts() {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public boolean add(String name, String mobile, String email) {
        Contact newContact = new Contact(name, mobile, email);
        if (contacts.containsKey(name)) {
            return false;
        } else {
            contacts.put(name, newContact);
            save(fn);
            return true;
        }
    }

    public boolean update(String name, String mobile, String email) {
        Contact newContact = new Contact(name, mobile, email);
        if (contacts.containsKey(name)) {
            contacts.put(name, newContact);
            save(fn);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(String name) throws Exception {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            save(fn);
            return true;
        } else {
            return false;
        }
    }

    public Contact query(String name) {
        return contacts.get(name);
    }

    public void save() {
        save(fn);
    }

    public void save(String fn) {
        try {
            File writenFile = new File(fn);
            FileOutputStream fos = new FileOutputStream(writenFile);
            PrintWriter pw = new PrintWriter(fos);
            for (Contact contactMember : contacts.values()) {
                pw.println(contactMember);
            }
            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public void read(String fn) {
        try {
            File toRead = new File(fn);
            FileInputStream fis = new FileInputStream(toRead);
            Scanner sc = new Scanner(fis);
            List<String> contactValues = new ArrayList<String>(3);
            //read data from file line by line:
            String currentLine;
            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                if (!currentLine.trim().isEmpty()) {
                    String[] seprated_by_comma = currentLine.split(",");
                    for (String element : seprated_by_comma) {
                        String[] key_and_value = element.split("=");
                        contactValues.add(key_and_value[1]);
                    }
                    this.add(contactValues.get(0), contactValues.get(1), contactValues.get(2));
                    contactValues.clear();
                }
            }
            fis.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    private Map<String, Contact> contacts = new HashMap<String, Contact>();
    private String fn = "contents_data.txt";

}







