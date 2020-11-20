import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class DataSource {
    //    String fs = File.separator;
//    String dir = System.getProperty("user.dir") + fs + "Data";
//    String Sourcefile = dir + fs + "account.txt";
    String path= "Data/account.txt";
    public List<Account> readAccounts(){
        try {
            createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Account> accounts = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader buffer = null;
        try {
            fileReader = new FileReader(path);
            buffer = new BufferedReader(fileReader);
            String line = buffer.readLine();
            while ((line ) != null) {
                String[] data = line.split(",");
                String firstname = data[0].trim();
                String lastname = data[1].trim();
                String username =data[2].trim();
                String password = data[3].trim();
                String address = data[4].trim();
                String tel = data[4].trim();
                Account a = new Account(firstname, lastname,username, password,address,tel);
                accounts.add(a);
                line = buffer.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    public void createFile() throws IOException {
        File directory = new File("Data");
        if(!directory.exists()){
            directory.mkdirs();
        }
        File file = new File(path);
        file.createNewFile();
    }



    public void writeAccount(String firstname,String lastname,String username,String password,String address,String tel) throws IOException {
        createFile();
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.append(firstname + "," + lastname + ","+username+"," + password+"," +address+"," +tel);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.err.println("Error IO");
        }
    }

}