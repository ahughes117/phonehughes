/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneHughes;

import java.io.Serializable;

/**
 *
 * @author Alex Hughes
 */

public class Credentials implements Serializable{
    
    private String URL;
    private String username;
    private String password;
    
    public Credentials(String aURL, String aUsername, String aPassword){
        URL = aURL; //+ "?characterEncoding=utf8"; //handshake hard coded.
        username = aUsername;
        password = aPassword;
    }
    
    public String getURL(){
        return URL;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setURL(String aURL){
        URL = aURL;
    }
    
    public void setUsername(String aUsername){
        username = aUsername;
    }
    
    public void setPassword(String aPassword){
        password = aPassword;
    }
    
    public void clear(){
        URL = null;
        username = null;
        password = null;
    }
    
}
