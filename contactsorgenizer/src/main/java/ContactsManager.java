import java.io.*;
import java.util.*;

public class ContactsManager {

    private Map<String, Contact> contacts = new HashMap<String, Contact>();

    public void add(String name, String mobile, String email) {
        Contact newContact = new Contact(name, mobile, email);
        if (contacts.containsKey(name) == true) {
            System.out.format("The contact: %s is already exist - it won\'t bet added", name).println();
        } else contacts.put(name, newContact);
    }

    public void update(String name, String mobile, String email) {
        Contact newContact = new Contact(name, mobile, email);
        if (contacts.containsKey(name) == true) {
            contacts.put(name, newContact);
        } else System.out.format("Cotact with key: %s doesn\'t exist and can\'t be updated\n", name);
    }

    public void remove(String name) throws Exception {
        if (contacts.containsKey(name) == true) {
            contacts.remove(name);
        }
        else {
            throw new Exception(String.format("Can\'t remove contact name: %s, since it doesn\'t exist", name));
        }
    }

    public Contact query1(String name) {
        if (contacts.containsKey(name) == true) {
            return contacts.get(name);
        } else return null;
    }

    public List<String> query2(String name) {
        if (contacts.containsKey(name) == true) {
            return contacts.get(name).getValues();
        } else return null;
    }



    public HashMap<String, Contact> getContacts() {
        return (HashMap<String, Contact>) contacts;
    }


    public void writeToFile(HashMap<String,Contact> map, String fn) {
        try {
            File writenFile = new File(fn + ".txt");
            FileOutputStream fos = new FileOutputStream(writenFile);
            PrintWriter pw = new PrintWriter(fos);

            for (Map.Entry<String, Contact> m : map.entrySet()) {
                pw.println(m.getKey() + ":" + m.getValue());
            }

            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public void readFromFile(String fn) {
        try{
            File toRead=new File(fn+".txt");
            FileInputStream fis=new FileInputStream(toRead);
            Scanner sc=new Scanner(fis);
            HashMap<String, String> mapInFile=new HashMap<String, String>();
            ArrayList<String> contactValues = new ArrayList<String>(3);
            //read data from file line by line:
            String currentLine;
            while(sc.hasNextLine()){
                currentLine=sc.nextLine();
                String[] separated_by_colon = currentLine.split(":");
                String[] seprated_by_comma = separated_by_colon[1].split(",");
                for ( String element : seprated_by_comma ) {
                    String[] key_and_value = element.split("=");
                       contactValues.add(key_and_value[1]);
                }
                ContactsManager contactsManager = new ContactsManager();
                contactsManager.add(contactValues.get(0), contactValues.get(1), contactValues.get(2));
                System.out.println(contactsManager.getContacts());

         }
            fis.close();

        }catch(Exception e){}
    }


}







