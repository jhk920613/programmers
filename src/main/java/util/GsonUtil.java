package util;

import com.google.gson.Gson;

public class GsonUtil {

    private static final Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static void toJsonPrint(Object object) {

        System.out.println(gson.toJson(object));
    }

}
