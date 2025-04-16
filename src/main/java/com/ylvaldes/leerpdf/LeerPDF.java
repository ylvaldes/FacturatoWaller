package com.ylvaldes.leerpdf;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.ylvaldes.leerpdf.dao.PendingDataResponse;
import com.ylvaldes.leerpdf.service.ProcesarDataService;
import com.ylvaldes.leerpdf.utiles.LoadResourceConfLeerPDF;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeerPDF {

    private static final Logger log = LogManager.getLogger(LeerPDF.class);


    public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException {
        // Carga los recursos osososos
        LoadResourceConfLeerPDF recurso = new LoadResourceConfLeerPDF();
        recurso.loadResourceConf();


        Scanner teclado = new Scanner(System.in);
//        log.info("URL Scaneada: ");
//        String url = teclado.nextLine();
//
//		url = url.substring(47, url.length());
//		List<String> result = Arrays.asList(url.split("\\s*,\\s*"));
        List<PendingDataResponse> pendingDataResponses = new ArrayList<PendingDataResponse>(getData());

        ProcesarDataService procesarDataService = new ProcesarDataService();
        if (!pendingDataResponses.isEmpty()) {
            for (PendingDataResponse pendingDataResponse : pendingDataResponses
            ) {
                List<String> result = new ArrayList<>();
                result.add(String.valueOf(pendingDataResponse.getRut()));
                result.add(pendingDataResponse.getTipoCFE());
                result.add(pendingDataResponse.getSerie());
                result.add(pendingDataResponse.getNumero());
                result.add(String.valueOf(pendingDataResponse.getMontoTotal()));
                result.add(pendingDataResponse.getFecha());
                result.add(pendingDataResponse.getCodigoSeguridad());

                if (procesarDataService.procesarData(result, recurso)) {
                    chanegeStatus(String.valueOf(pendingDataResponse.getIdUrl()));
                }
            }
        }
    }

    public static List<PendingDataResponse> getData() throws IOException {
        List<PendingDataResponse> pendingDataResponses = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String BASE_URL = "http://localhost:8020/api/urls/data";
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        ResponseBody responses = null;
        try {
            responses = client.newCall(request).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Type listOfMyClassObject = new TypeToken<ArrayList<PendingDataResponse>>() {
        }.getType();

        Gson gson = new Gson();
        pendingDataResponses = gson.fromJson(responses.string(), listOfMyClassObject);
        return pendingDataResponses;

    }

    public static void chanegeStatus(String id) throws IOException {
        List<PendingDataResponse> pendingDataResponses = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");

        String BASE_URL = "http://localhost:8020/api/urls/setStatus?id=" + id + "&status=PROCESSED";
        Request request = new Request.Builder()
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .url(BASE_URL)
                .build();
        ResponseBody responses = null;
        try {
            responses = client.newCall(request).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
