package calcu.data;

import calcu.calcu.Menu;
import calcu.calcu.peopleSegment;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.*;
import java.util.ArrayList;

public class Account extends Menu {
    private String username, password;
    private ArrayList<Employee> employees = new ArrayList<>();
    private boolean isLoadingData;
    public void setisLoadingData(boolean bool){
        this.isLoadingData = bool;
    }
    public boolean getisLoadingData(){
        return this.isLoadingData;
    }

    public static void newAccount(String inputUser, String inputPass){
        try{
            addAccDatabase(inputUser,inputPass);
            PrintWriter pw = new PrintWriter(new File("assets/Accounts/"+inputUser+".csv"));
            StringBuilder sb = new StringBuilder();

            pw.write(sb.toString());
            pw.close();
        }catch (Exception e){
            System.out.println("Error1");
        }
    }
    public static void addAccDatabase(String inputUser, String inputPass) throws IOException {
        BufferedWriter buffWriter = null;
        String newData = inputUser+","+inputPass+"\n";
        try{
            buffWriter = new BufferedWriter(new FileWriter(new File("assets/acc_list.csv"),true));
            buffWriter.write(newData);
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        }catch(IOException e){
            System.out.println("I/O Error");
        }finally {
            if(buffWriter != null){
                buffWriter.close();
            }
        }
    }
    public static int checkAccDatabase(String inputUser, String inputPass) throws IOException {
        String file = "assets/acc_list.csv";
        BufferedReader reader = null;
        String line = "";
        String[][] list = new String[2][100];
        int i;
        int j = 0;
        int columns = 0;
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                i = 0;
                for (String index : row){
                    list[i][j] = index;
                    i++;
                }
                columns++;
                j++;
            }
        }catch (Exception e){e.printStackTrace();}finally {
            reader.close();
        }

        for (int a=0; a<columns; a++){
            if ((list[0][a].compareTo(inputUser) == 0))
            {
                if (list[1][a].compareTo(inputPass) == 0)
                {
                    //login successful
                    System.out.println("User Found on row: "+a);
                    return 1;
                }else {
                    //wrong password
                    return 2;
                }
            }
        }
        return 3;
    }
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /** GETTER AND SETTERS */
    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }
    public Employee getEmployee(String name){
        for (Employee i : employees){
            if (i.getName() == null)
                return null;
            else if (i.getName().equals(name))
                return i;
        }
        return null;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void delEmployee(Employee employee){
        employees.remove(employee);
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String user){
        this.username = user;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }

    /** SAVING AND LOADING ACCOUNTS */
    public void saveAccount() throws IOException {
        /* TBA
        * gagamitin to pag pinindot ung quit
        * dapat nakasave lahat ng info sa txt file
        * siguro check muna if [accountname].txt exists
        * if false, then gawa ng txt file
        * tapos write info nalang ganun
         */
        System.out.println("save account initialized");
        File x = new File("assets/Accounts/"+username+".csv");
        if (x.exists()){
            try{
                PrintWriter pw = new PrintWriter(x);
                StringBuilder sb = new StringBuilder();
                pw.write(sb.toString());
                pw.close();
            }catch (Exception e){
                System.out.println("Error1");
            }

            System.out.println("Account found: "+ username +" "+ password);
            BufferedWriter buffWriter = null;
            for (Employee employee : employees){
                String out = employee.getName()+","+
                        employee.getNote()+","+
                        employee.getHourlyRate()+","+
                        employee.getHours()+","+
                        employee.getMonthlySalary()+","+
                        employee.getMultiplier()+","+
                        employee.getOvertimeHours()+","+
                        employee.getTotalSalary()+","+
                        employee.getIncomeTax()+","+
                        employee.getTotalTax()+","+
                        employee.getInsurance()+","+
                        employee.getInsuranceType()+","+
                        employee.getPhil()+","+
                        employee.getPgb()+","+
                        employee.getNetSalary();
                try{
                    buffWriter = new BufferedWriter(new FileWriter(x, true));
                    buffWriter.write(out+"\n");
                }catch(FileNotFoundException e){
                    System.out.println("File not found!");
                }catch(IOException e){
                    System.out.println("I/O Error");
                }finally {
                    if(buffWriter != null){
                        buffWriter.close();
                    }
                }
            }
        }
    }

    /*
    name =
    note =
    insuranceType =
    hourly =
    hours =
    monthly =
    multiplier =
    ohours =
    totalSalary =
    incomeTax =
    totalTax =
    insurance =
    phil =
    pgb =
    netSalary =
    */
    public void loadData() throws IOException {
        employees.clear();
        isLoadingData = true;
        String file = "assets/Accounts/"+username+".csv";
        BufferedReader reader = null;
        String line = "";
        String[][] empData = new String[100][15];
        int empCount = 0;
        int i=0;
        int j;
        try
        {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                j=0;
                String[] row = line.split(",");
                for (String index : row)
                {
                    empData[i][j] = index;
                    j++;
                }
                empCount++;
                i++;
            }
        }catch (Exception e){}finally {reader.close();}
        for (int a=0; a<empCount; a++){
            Employee x = new Employee(empData[a][0]);
            x.setNote(empData[a][1]);
            x.setHourlyRate(Double.parseDouble(empData[a][2]));
            x.setHours(Double.parseDouble(empData[a][3]));
            x.setMonthlySalary(Double.parseDouble(empData[a][4]));
            x.setMultiplier(Double.parseDouble(empData[a][5]));
            x.setOvertimeHours(Double.parseDouble(empData[a][6]));
            x.setTotalSalary(Double.parseDouble(empData[a][7]));
            x.setIncomeTax(Double.parseDouble(empData[a][8]));
            x.setTotalTax(Double.parseDouble(empData[a][9]));
            x.setInsurance(Double.parseDouble(empData[a][10]));
            x.setInsuranceType(empData[a][11]);
            x.setPhil(Double.parseDouble(empData[a][12]));
            x.setPgb(Double.parseDouble(empData[a][13]));
            x.setNetSalary(Double.parseDouble(empData[a][14]));
            employees.add(x);
        }
    }
    public boolean loadAccount() throws IOException {
        /* TBA
        gagamitin to ng register at login pages

        if (file exists){
            if (username.equals(usernameSaFile) && password.equals(passwordSaFile)){
                code para maread lahat ng laman tapos ilagay sa tamang lalagyan :D
                parang loadstats lang yan ng pokemon ig
                return true;
            }else{
                return false; // para pag false dapat idisplay ng page "mali password / wala pong ganyang account"
            }
        }else{
            return false;
        }

         */

        switch (checkAccDatabase(username,password))
        {
            case 1: //login
                System.out.println("LOGIN SUCCESSFUL");
                loadData();
                return true;
            case 2: //wrong password
                System.out.println("WRONG PASSWORD");
                return false;
            case 3: //new account
                System.out.println("NEW ACCOUNT MADe");
                newAccount(username,password);
                loadData();
                return true;
            default:
                System.out.println("DEPOLT");
                return false;
        }
    }

    @Override
    public void initialize() throws IOException {

    }
}
