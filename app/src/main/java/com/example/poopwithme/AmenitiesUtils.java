package com.example.poopwithme;

import android.net.Uri;

import com.google.gson.Gson;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;


public class AmenitiesUtils {
    public static class row {
        public String X;
    }
    public static class test {
        public row[] data;
    }
//     throws FileNotFoundException
/*    public static Object getBathrooms() {
        Gson gson = new Gson();
        Object json;
        try {
            Log.d("results ", "  ----TRY");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            json = gson.fromJson(bufferedReader, Object.class);
        }
        catch (FileNotFoundException ex) {// insert code to run when exception occurs}
            json = null;
            Log.d("results ", "  ----CATCH");
        }

        Log.d("results ", "  -----"+json);
        return json;
    }*/
    public static double[] getLocations(int i) {
        double[][] latLongs =new double[][]{{-105.255682,40.0253808},
                {-105.2337308,40.0313801},
                {-105.2288559,40.0720445}};
        Log.d("latLong ", " "+ Arrays.deepToString(latLongs));
        return latLongs[i];
    }
}
