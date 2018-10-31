package com.suyan.user.resp;

import java.util.List;

public class UserPermissionsODTO {

    private boolean isAdmin;

    private List<String> urlList;

    public boolean getIsAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }
}
