package com.gen.jpa.main;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gen.jpa.utils.AnalysisDB;
import com.gen.jpa.utils.GenerateConfig;
import com.gen.jpa.utils.TableMeta;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 生成代码入口
 * @author	zhanglikun
 * @date	2013-7-17
 * @desc	XXX
 */
public class GenerateMain {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

        //初使化参数
        ClassLoader classLoader = GenerateMain.class.getClassLoader();
        String configName = classLoader.getResource("config.properties").getPath();
        GenerateConfig.init(configName);


        List<TableMeta> tableList ;
        Writer out = null ;
        String targetDir = GenerateConfig.config.getTargetDir();

        tableList = AnalysisDB.readDB() ;
        AnalysisDB.readTables(tableList) ;
        // 输出到文件
        File dir = new File(targetDir) ;
        if(!dir.isDirectory()) {
            dir.mkdirs() ;
        }

        Configuration cfg = new Configuration() ;
        File model = new File(classLoader.getResource("model.ftl").getPath());
        cfg.setDirectoryForTemplateLoading(new File(model.getParent())) ;
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        Template tpl = cfg.getTemplate("model.ftl") ;
        if(tableList != null) {
            for(TableMeta tm : tableList) {
                if(StringUtils.isBlank(tm.getClassName()))continue ;
                out = new FileWriter(new File(dir.getPath() + File.separator + tm.getClassName() + ".java")) ;
                tpl.process(tm, out) ;
                System.out.println("===文件 " + tm.getClassName() + ".java" + " 生成成功===");
            }
        }
        if (out != null) {
            out.flush();
            out.close();
        }
    }

}
