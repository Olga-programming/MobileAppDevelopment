package com.olga.day07customlistview.xml_json;

import android.content.Context;
import android.content.res.AssetManager;

import com.olga.day07customlistview.Flower;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Json_Parser {
    ArrayList<Flower> flowerArrayList = new ArrayList<>();

    private InputStreamReader inputStreamReader;


    public ArrayList<Flower> processJSONFile(Context context, String fileName){
        AssetManager assetManager = context.getResources().getAssets();
        try{
            inputStreamReader = new InputStreamReader(assetManager.open(fileName));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String oneLine = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((oneLine = bufferedReader.readLine()) != null){
                stringBuilder.append(oneLine);
            }

            bufferedReader.close();
            inputStreamReader.close();

            System.out.println(stringBuilder.toString());

            processJSONDate(stringBuilder.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        return flowerArrayList;
    }

    public void processJSONDate(String data) {

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i< jsonArray.length(); i++){
                JSONObject currentJSONFlowerObject = jsonArray.getJSONObject(i);

                int productId = currentJSONFlowerObject.getInt("productID");
                String category = currentJSONFlowerObject.getString("category");
                String name = currentJSONFlowerObject.getString("name");
                String instructions = currentJSONFlowerObject.getString("instructions");
                double price = currentJSONFlowerObject.getDouble("price");
                String photo = currentJSONFlowerObject.getString("photo");

                Flower currentFlower = new Flower(productId, category, name, instructions, price, photo);
                flowerArrayList.add(currentFlower);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
