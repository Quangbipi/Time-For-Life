package com.quangminh.myapplication.model

class User (var userName : String, var password : String, var id : String){
    fun validate(userNameCheck: String, passwordCkeck: String) : Boolean{
        if(userName.equals(userNameCheck) && password.equals(passwordCkeck)){
            return true
        }
        return false

    }
}