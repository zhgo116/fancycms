package com.fancy.freemarker.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.fancy.common.util.FreemarkerUtil;
import com.fancy.freemarker.model.Classes;
import com.fancy.freemarker.model.User;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;


public class FreemarkerGene {
	/**
     * 使用模板生成HTML代码
     */
    public static void createHtmlFromModel() {
        FileWriter out = null;
        try {
            // 通过FreeMarker的Confuguration读取相应的模板文件
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            // 设置模板路径
            configuration.setClassForTemplateLoading(FreemarkerGene.class, "/");//第二个参数/指classpath路径
           // configuration.setDirectoryForTemplateLoading(new File(FreemarkerGene.class.getResource("").getPath()));
            // 设置默认字体
            configuration.setDefaultEncoding("utf-8");

            // 获取模板
            Template template = configuration.getTemplate("user.ftl");
            //设置模型
            User user = new User("tom", "hahahah", 28, "上海市");
            
            //设置输出文件
            File file = new File("e:/html/result.html");
            if(!file.exists()) {
                file.createNewFile();
            }
            //设置输出流
            out = new FileWriter(file);
            //模板输出静态文件
            template.process(user, out);
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 把模板读入到String中，然后根据String构造FreeMarker模板
     */
    public static void createHtmlFromString() {
        BufferedInputStream in = null;
        FileWriter out = null;
        try {
            //模板文件
            File file = new File(FreemarkerGene.class.getResource("").getPath()+"/class.html");
            //构造输入流
            in = new BufferedInputStream(new FileInputStream(file));
            int len;
            byte[] bytes = new byte[1024];
            //模板内容
            StringBuilder content = new StringBuilder();
            while((len = in.read(bytes)) != -1) {
                content.append(new String(bytes, 0, len, "utf-8"));
            }
            
            //构造Configuration
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            //构造StringTemplateLoader
            StringTemplateLoader loader = new StringTemplateLoader();
            //添加String模板
            loader.putTemplate("test", content.toString());
            //把StringTemplateLoader添加到Configuration中
            configuration.setTemplateLoader(loader);
            
            //构造Model
            Classes classes = new Classes();
            classes.setClassId("23");
            classes.setClassName("实验一班");
            List<User> users = new ArrayList<User>();
            User user = new User("tom", "kkkkk", 29, "北京");
            users.add(user);
            User user2 = new User("Jim", "hhhh", 22, "上海");
            users.add(user2);
            User user3 = new User("Jerry", "aaaa", 25, "南京");
            users.add(user3);
            classes.setUsers(users);
            //获取模板
            Template template = configuration.getTemplate("test");
            //构造输出路
            out = new FileWriter("e:/html/result.html");
            //生成HTML
            template.process(classes, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if(null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
		System.out.println(FreemarkerUtil.class.getResource("/").getPath());
		FreemarkerGene.createHtmlFromModel();
	}
}
