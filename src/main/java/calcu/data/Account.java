package calcu.data;

import java.util.ArrayList;

public class Account {
    private String username, password;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Template> templates = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** GETTER AND SETTERS */
    public Employee getEmployee(String name){
        for (Employee i : employees){
            if (i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public Template getTemplate(String name){
        for (Template i : templates){
            if (i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    public void addTemplate(Template template){
        templates.add(template);
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
        this.password = password;
    }

    /** SAVING AND LOADING ACCOUNTS */
    public void saveAccount(){
        /* TBA
        * gagamitin to pag pinindot ung quit
        * dapat nakasave lahat ng info sa txt file
        * siguro check muna if [accountname].txt exists
        * if false, then gawa ng txt file
        * tapos write info nalang ganun
         */
    }

    public static boolean loadAccount(){
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
        return true;
    }
}
