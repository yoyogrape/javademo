package com.songjn.JSONFile;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-24 18:38
 * @desc GSON对json文件的解析
 **/
public class JSONDemo {
    @Test
    public void readJsonDemo() throws IOException {
        //读取文件msg.json
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/JSONFile/msg.json");
        readJsonStream(is);
    }

    public List<Message> readJsonStream(InputStream in)
            throws IOException {
        //获得解析器
        JsonReader reader = new JsonReader(
                new InputStreamReader(in, "UTF-8"));
        try {
            //读取msg数组
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Message> readMessagesArray(JsonReader reader)
            throws IOException {
        List<Message> messages = new ArrayList<Message>();
        //开始解析数组“[”
        reader.beginArray();
        while (reader.hasNext()) {
            //将解析出来的对象添加进数组
            messages.add(readMessage(reader));
        }
        //解析数组结束调用
        reader.endArray();
        messages.forEach(System.out::println);
        return messages;
    }

    public Message readMessage(JsonReader reader)
            throws IOException {
        long id = -1;
        String text = null;
        User user = null;
        List<Double> geo = null;
        //解析msg对象开始“[”
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextLong();
            } else if (name.equals("text")) {
                text = reader.nextString();
            } else if (name.equals("geo")
                    && reader.peek() != JsonToken.NULL) {
                //判断geo是否为空，为空跳过解析
                geo = readDoublesArray(reader);
            } else if (name.equals("user")) {
                user = readUser(reader);
            } else {
                //不满足条件，跳过继续解析
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Message(id, text, user, geo);
    }

    //对geo数组进行解析
    public List<Double> readDoublesArray(JsonReader reader)
            throws IOException {
        List<Double> doubles = new ArrayList<Double>();

        reader.beginArray();
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
    }

    public User readUser(JsonReader reader) throws IOException {
        String username = null;
        int followersCount = -1;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                username = reader.nextString();
            } else if (name.equals("followers_count")) {
                followersCount = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new User(username, followersCount);
    }
}
