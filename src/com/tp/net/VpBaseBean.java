package com.tp.net;

import java.io.Serializable;

/**
 * Created by tanping on 16/7/27.
 *
 * 序列化 防止 混淆
 */
public class VpBaseBean implements Serializable {


    /**
     * args : {}
     * data : 
     * files : {"f1":"13334"}
     * form : {"age":"谭平sssssdf","name":"tanp post","sex":"1","中文key":"中文value"}
     * headers : {"Accept-Encoding":"gzip","Content-Length":"675","Content-Type":"multipart/form-data; boundary=45f64b62-76c6-4252-a8cf-a7617cd88c67","Host":"httpbin.org","User-Agent":"okhttp/3.1.2"}
     * json : null
     * origin : 121.34.147.3
     * url : https://httpbin.org/post
     */

    public String data;
    /**
     * f1 : 13334
     */

    public FilesBean files;
    /**
     * age : 谭平sssssdf
     * name : tanp post
     * sex : 1
     * 中文key : 中文value
     */

  // public FormBean form;
    /**
     * Accept-Encoding : gzip
     * Content-Length : 675
     * Content-Type : multipart/form-data; boundary=45f64b62-76c6-4252-a8cf-a7617cd88c67
     * Host : httpbin.org
     * User-Agent : okhttp/3.1.2
     */
    public FormBean form;


    public static class FilesBean {
        public String f1;

        public String getF1() {
            return f1;
        }

        public void setF1(String f1) {
            this.f1 = f1;
        }
    }

    public static class FormBean {
        public String age;
        public String name;
        public String sex;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
 
    }
}
