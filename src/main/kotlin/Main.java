import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        convertToJsonObject();
    }

    public static void convertToJsonObject() {
        String inputData = "{MTI=0200, channel=MOBILE, destination=xml, field39=00, source=MOBILE, mode=online, field66=, field67=, field65=1425538, field26=APP, field48=Meter number lookup is Successful, field49=SBD, field24=MM, field68=Bill presentment for SOLOMON_POWER_PRESENTMENT, field69=, validationStatus=, direction=request, field127={MeterNumber: 07048787894,InitialAmount: 150.56,ConsumerAccount:C70550000,MinimumVendAmount: 5.71,Owing: 150.56,ConsumerFirstName:BEN,ConsumerSurname:HARRY\n" +
                "    }, field126=Customer Test 2, field102=6777557691001, field100=SOLOMON_POWER_PRESENTMENT, field121=6777557691, field120=6777557691, field78=, field0=0200, field32=APP, field54=, field37=100000106640, field38=100000094645, service=Bills, field57=100000094645, field3=180000, field2=6777557691, field74=SOLOMON_POWER_PRESENTMENT, field4=17\n" +
                "}"; // Paste the given input here

        // Create a Gson instance
        Gson gson = new Gson();

        // Parse the input into the Data class
        Data data = gson.fromJson(inputData, Data.class);

        // Convert Data instance to a JsonObject
        JsonObject jsonObject = gson.toJsonTree(data).getAsJsonObject();

        // Print the JsonObject
        System.out.println(jsonObject);
    }

    public static class Data {
        private String MTI;
        private String channel;
        private String destination;
        private String field39;
        private String source;
        private String mode;
        private String field66;
        private String field67;
        private String field65;
        private String field26;
        private String field48;
        private String field49;
        private String field24;
        private String field68;
        private String field69;
        private String validationStatus;
        private String direction;
        private JsonObject field127;
        private String field126;
        private String field102;
        private String field100;
        private String field121;
        private String field120;
        private String field78;
        private String field0;
        private String field32;
        private String field54;
        private String field37;
        private String field38;
        private String service;
        private String field57;
        private String field3;
        private String field2;
        private String field74;
        private String field4;

        // Getters and setters (or use Lombok for brevity)
    }

}
