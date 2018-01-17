import java.io.*;
import java.util.*;
import java.util.Scanner;

class ContactsManager {

    boolean add(String name, String mobile, String email) {
        Contact newContact = new Contact(name, mobile, email);
        if (contacts.containsKey(name)) {
            return false;
        } else {
            contacts.put(name, newContact);
            return true;
        }
    }

    boolean update(String name, String mobile, String email) {
        Contact newContact = new Contact(name, mobile, email);
        if (contacts.containsKey(name)) {
            contacts.put(name, newContact);
            return true;
        } else {
            return false;
        }
    }

    boolean remove(String name) throws Exception {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            return true;
        }
        else {
            return false;
        }
    }

    Contact query(String name) {
        return contacts.get(name);
    }


    Collection<Contact> getContacts() {
        return  contacts.values();
    }


    void save(Collection<Contact> contactsCollection, String fn) {
        try {
            File writenFile = new File(fn);
            FileOutputStream fos = new FileOutputStream(writenFile);
            PrintWriter pw = new PrintWriter(fos);
            for (Contact contactMember : contactsCollection) {
                pw.println(contactMember);
            }
            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    void read(String fn) {
        try{
            File toRead=new File(fn);
            FileInputStream fis=new FileInputStream(toRead);
            Scanner sc=new Scanner(fis);
            ArrayList<String> contactValues = new ArrayList<String>(3);
            //read data from file line by line:
            String currentLine;
            while(sc.hasNextLine()){
                currentLine=sc.nextLine();
                String[] seprated_by_comma = currentLine.split(",");
                for ( String element : seprated_by_comma ) {
                    String[] key_and_value = element.split("=");
                       contactValues.add(key_and_value[1]);
                }
                this.add(contactValues.get(0), contactValues.get(1), contactValues.get(2));
                contactValues.clear();
         }
            fis.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Map<String, Contact> contacts = new HashMap<String, Contact>();


}






