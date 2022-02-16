/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nguyen Van Long
 */
public class User {

    int userid;
    String username;
    String useraccount;
    String userpassword;
    String useremail;
    String userphone;
    String useraddress;
    int userrole;

    public User(int userid, String username, String useraccount, String userpassword, String useremail, String userphone, String useraddress, int userrole) {
        this.userid = userid;
        this.username = username;
        this.useraccount = useraccount;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.userphone = userphone;       
        this.useraddress = useraddress;
        this.userrole = userrole;
    }
    
    public User() {
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public int getUserrole() {
        return userrole;
    }

    public void setUserrole(int userrole) {
        this.userrole = userrole;
    }
    
    
    
}
