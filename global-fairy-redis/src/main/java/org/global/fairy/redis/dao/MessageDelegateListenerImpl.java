//package org.global.fairy.redis.dao;
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.commons.lang.builder.ToStringBuilder;
//
//import com.google.inject.internal.Iterators;
//
//public class MessageDelegateListenerImpl implements MessageDelegateListener {
//
//    @Override
//    public void handleMessage(Serializable message) {
//        //什么都不做,只输出
//        if(message == null){
//            System.out.println("null");
//        } else if(message.getClass().isArray()){
//            System.out.println(Arrays.toString((Object[]) message));
//        } else if(message instanceof List<?>) {
//            System.out.println(message);
//        } else if(message instanceof Iterators.Map<? , ?>) {
//            System.out.println(message);
//        } else {
//            System.out.println(ToStringBuilder.reflectionToString(message));
//            System.out.println(message);
//        }
//    }
//}