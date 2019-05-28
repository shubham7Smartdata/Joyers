package com.sdi.joyers.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class UserModel {
    /**
     * msg : Register Successfully.
     * data : {"role":"norole","status":"PENDING","userStatus":"Active","token":"X3cu3eth2ZSQ8tgEcAum","_isActive":true,"_isDeleted":false,"_id":"5ced10defefc19588af47fd4","email":"test10@gmail.com","password":"$2a$10$SscoSfUdv08iayPc9ml6.eOCJlEervK5jCxSzYJiDBVmQuuguVbRC","_createdDate":"2019-05-28T10:43:42.788Z","_updatedDate":"2019-05-28T10:43:42.788Z","__v":0}
     */

    private String msg;

    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Entity(tableName = "user_model")
    public static class DataBean {
        /**
         * role : norole
         * status : PENDING
         * userStatus : Active
         * token : X3cu3eth2ZSQ8tgEcAum
         * _isActive : true
         * _isDeleted : false
         * _id : 5ced10defefc19588af47fd4
         * email : test10@gmail.com
         * password : $2a$10$SscoSfUdv08iayPc9ml6.eOCJlEervK5jCxSzYJiDBVmQuuguVbRC
         * _createdDate : 2019-05-28T10:43:42.788Z
         * _updatedDate : 2019-05-28T10:43:42.788Z
         * __v : 0
         */

        private String role;
        private String status;
        private String userStatus;
        private String token;
        private boolean _isActive;
        private boolean _isDeleted;

        @NonNull
        @PrimaryKey
        private String _id;

        private String email;
        private String password;
        private String _createdDate;
        private String _updatedDate;
        private int __v;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public boolean is_isActive() {
            return _isActive;
        }

        public void set_isActive(boolean _isActive) {
            this._isActive = _isActive;
        }

        public boolean is_isDeleted() {
            return _isDeleted;
        }

        public void set_isDeleted(boolean _isDeleted) {
            this._isDeleted = _isDeleted;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String get_createdDate() {
            return _createdDate;
        }

        public void set_createdDate(String _createdDate) {
            this._createdDate = _createdDate;
        }

        public String get_updatedDate() {
            return _updatedDate;
        }

        public void set_updatedDate(String _updatedDate) {
            this._updatedDate = _updatedDate;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }
    }
}
