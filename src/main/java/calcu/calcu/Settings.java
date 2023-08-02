package calcu.calcu;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Settings extends Menu{

    @FXML
    private TextField oldPass;
    @FXML
    private TextField newPass;
    public void changePass() throws IOException {
        if (oldPass.getText().equals(account.getPassword())) {
            showError("Password changed!");

            String tempFile = "assets/temp.txt";
            File oldFile = new File("assets/acc_list.csv");
            File newFile = new File(tempFile);
            String dbUSER = ""; String dbPASS = "";
            try
            {
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                Scanner x = new Scanner(new File("assets/acc_list.csv"));
                x.useDelimiter("[,\n]");

                while (x.hasNext()){
                    dbUSER = x.next();
                    dbPASS = x.next();
                    if (dbPASS.equals(account.getPassword())){
                        pw.println(account.getUsername()+","+newPass.getText());
                        System.out.println("Change Successful!");
                    }else{
                        pw.println(dbUSER+","+dbPASS);
                    }
                }
                x.close();
                pw.flush();
                pw.close();
                oldFile.delete();
                File dump = new File("assets/acc_list.csv");
                newFile.renameTo(dump);
            }catch(Exception e){System.out.println("Error2");}

            Scanner file;
            PrintWriter writer;
            try {
                file = new Scanner(new File("assets/acc_list.csv"));
                writer = new PrintWriter("assets/testing.csv");
                while (file.hasNext()) {
                    String line = file.nextLine();
                    if (!line.isEmpty()) {
                        writer.write(line);
                        writer.write("\n");
                    }
                }
                file.close();
                writer.close();
            } catch (Exception e) {System.out.println("Error3");}
            File file1 = new File("assets/acc_list.csv");
            File file2 = new File("assets/testing.csv");
            file1.delete();
            file2.renameTo(file1);
            account.setPassword(newPass.getText());
        }else if (newPass.getText().isBlank() || newPass.getText().indexOf(' ') != -1){
            showError("Password should be valid and without spaces.");
        }else{
            showError("Incorrect Password.");
        }
    }
    @Override
    public void initialize() throws IOException {

    }
}
