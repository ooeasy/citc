package com.citc.Util;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Aspect
@Component
public class FolderClearAspect {

    private static final String FOLDER_PATH = "src/main/resources/static/out";

    @Test
    @Before("execution(* com.citc.controller.GeneratorController.*(..))")
    public void clearFolderBeforeMethodExecution() {
        //logger.info("Before executing a method");
        try {
            //clearFolder(new File(FOLDER_PATH));
        } catch (Exception e) {
            System.out.println("Failed to clear folder: " + e.getMessage());
        }
    }


    public static void clearFolder(File folder) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        clearFolder(file);
                    } else {
                        System.out.println(file.getName());
                        file.delete();
                    }
                }
            }
        }
    }
}
