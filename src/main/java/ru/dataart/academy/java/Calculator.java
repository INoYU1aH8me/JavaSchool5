package ru.dataart.academy.java;

import java.io.*;
import java.util.zip.*;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        int result=0;
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFilePath)))
        {
            ZipEntry entry;
            while((entry=zin.getNextEntry())!=null){
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    if(character==(char)c)
                    {
                        result++;
                    }
                }
                zin.closeEntry();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        int max=0;
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFilePath)))
        {
            ZipEntry entry;
            while((entry=zin.getNextEntry())!=null){
                int length=0;
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    if((char)c==' ' || (char)c== '\n' ){
                        if(max<length)
                        {
                            max=length;
                        }
                        length=0;
                    }
                    else length++;
                }
                zin.closeEntry();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return max;
    }

}
