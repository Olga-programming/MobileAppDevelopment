package com.olga.day07customlistview.xml_json;

import android.content.Context;

import com.olga.day07customlistview.Flower;
import com.olga.day07customlistview.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Xml_Parser {

    private Context context;
    private Flower currentFlower;
    private ArrayList<Flower> flowerArrayList = new ArrayList<>();

    private String currentTag;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;

    public Xml_Parser(Context context){
        this.context = context;
    }

    public void xmlInputStream(){
        inputStream = context.getResources().openRawResource(R.raw.flowers_xml);
    }

    public ArrayList<Flower> parseXML(){
        try {

            XmlPullParserFactory xmlParserFactory= XmlPullParserFactory.newInstance();
            XmlPullParser xmlParser  = xmlParserFactory.newPullParser();

            xmlInputStream();

            xmlParser.setInput(inputStream, null);

            while( xmlParser.getEventType() != XmlPullParser.END_DOCUMENT){

                switch (xmlParser.getEventType()){
                    case XmlPullParser.START_TAG:
                        handleStartTag(xmlParser.getName());
                        break;
                    case XmlPullParser.TEXT:
                        handleText(xmlParser.getText());
                        break;
                    case XmlPullParser.END_TAG:
                        currentTag = null;
                        break;
                }
                xmlParser.next();

            }
            inputStream.close();
        } catch (XmlPullParserException | IOException e){
                e.printStackTrace();
        }

        return flowerArrayList;
    }

    private void handleStartTag(String tagName) {
        if("product".equals(tagName)){
            currentFlower = new Flower();
            flowerArrayList.add(currentFlower);
        }else {
            currentTag = tagName;
        }
    }

    private void handleText(String text) {
        if(currentFlower == null || currentTag == null) return;
         switch (currentTag){
             case "productId":
                 currentFlower.setProductId(Long.valueOf(text));
                 break;
             case "category":
                 currentFlower.setCategory(text);
                 break;
             case "name":
                 currentFlower.setName(text);
                 break;
             case "instructions":
                 currentFlower.setInstructions(text);
                 break;
             case "price":
                 currentFlower.setPrice(Double.valueOf(text));
                 break;
             case "photo":
                 currentFlower.setPhoto(text);
                 System.out.println(currentFlower);
                 break;
                 default: break;
         }
    }



}
