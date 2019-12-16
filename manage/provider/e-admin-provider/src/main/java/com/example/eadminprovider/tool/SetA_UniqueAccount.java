package com.example.eadminprovider.tool;

import com.example.emodeldao.admin.Admin;

public class SetA_UniqueAccount {

    public boolean uniquenessAdmin(Admin admin){
        boolean flag = false;

        if(admin.getAdminName().equals("skylong")){
            flag = true;
        }

        return flag;
    }
}
