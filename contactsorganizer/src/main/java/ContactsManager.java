import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsManager {

    private Map<String, Contact> contacts = new HashMap<String, Contact>();

    public void add(String name, String mobile, String email, Map<String, String> properties) {
        Contact newContact = new Contact(name, mobile, email, properties);
        if (contacts.containsKey(name) == true) {
            System.out.format("The contact: %s is already exist - it won\'t bet added", name).println();
        } else contacts.put(name, newContact);
    }

    public void update(String name, String mobile, String email, Map<String, String> properties) {
        Contact newContact = new Contact(name, mobile, email, properties);
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

    public void save(String filename) {
        //write to file : filename
        try {
            File fileOne = new File(filename);
            FileOutputStream fos = new FileOutputStream(fileOne);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(contacts);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public void read(String filename){
        //read from file
        try{
            File toRead=new File(filename);
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);

            HashMap<String,Contact> mapInFile=(HashMap<String,Contact>)ois.readObject();

            ois.close();
            fis.close();
            //print All data in MAP
            for(Map.Entry<String,Contact> m :mapInFile.entrySet()){
                System.out.println(m.getKey()+" : "+m.getValue());
            }
        }catch(Exception e){}
    }


    public Map<String, Contact> getContacts() {
        return contacts;
    }


}





