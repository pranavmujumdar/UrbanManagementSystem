/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Role.CitizenRole;
import Business.UserAccount.UserAccount;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author vedan
 */
public class DataStore {
    
    public static HashMap<UserAccount,Network> citizens = new HashMap<UserAccount,Network>();
    public static HashSet<String> usernames = new HashSet<String>();

    public static void setUsernames(HashSet<String> usernames) {
        DataStore.usernames = usernames;
    }

    public static HashSet<String> getUsernames() {
        return usernames;
    }
    
    static int citizenId = 1;
    public void setCitizens(HashMap<UserAccount,Network> citizens) {
        this.citizens = citizens;
    }

    public HashMap<UserAccount,Network> getCitizens() {
        return citizens;
    }
    
    public static void addCitizen(UserAccount userAccount, Network network)
    {
        citizens.put(userAccount, network);
        usernames.add(userAccount.getUsername());
    }
    
    
    
    
}
