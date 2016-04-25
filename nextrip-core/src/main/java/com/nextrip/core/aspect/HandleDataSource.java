package com.nextrip.core.aspect;

/**
 * Created by EvilC on 2016/4/23.
 */
public class HandleDataSource {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String dataSource){
        holder.set(dataSource);
    }

    public static String getDataSource(){
        return holder.get();
    }

}
