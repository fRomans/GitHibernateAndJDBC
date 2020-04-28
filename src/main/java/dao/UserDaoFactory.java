package dao;

import util.PropertyReader;

public class UserDaoFactory {

public void getRealization(String fileName){
    if (PropertyReader.getPropertyValue(fileName).equals("hibernate")){
        return;
    }
}
}
