package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    static Sandwich mSandwich;

    public static Sandwich parseSandwichJson(String json) {
        try {

            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");
            //parsing mainName
            String mainName = name.getString("mainName");
            List<String> list_alsoKnownAs = new ArrayList();
            //parsing alsoKnownAs

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");

            for (int i = 0; i < alsoKnownAs.length(); i++) {
                String item = alsoKnownAs.getString(i);
                list_alsoKnownAs.add(item);
            }
            //parsing placeOfOrigin

            String placeOfOrigin = root.getString("placeOfOrigin");
            //parsing description

            String description = root.getString("description");
            //parsing image

            String image = root.getString("image");
            //parsing ingredients
            List<String> list_ingredients = new ArrayList();


            JSONArray ingredients = root.getJSONArray("ingredients");

            for (int i = 0; i < ingredients.length(); i++) {
                String item = ingredients.getString(i);
                list_ingredients.add(item);
            }

            mSandwich = new Sandwich(mainName, list_alsoKnownAs, placeOfOrigin, description, image, list_ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return mSandwich;
    }
}
