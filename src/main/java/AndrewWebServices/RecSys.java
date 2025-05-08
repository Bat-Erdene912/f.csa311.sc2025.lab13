package AndrewWebServices;

public class RecSysStub extends RecSys {
    @Override
    public String getRecommendation(String accountName) {
        if ("Scotty".equals(accountName)) {
            return "Animal House";
        }
        return "Unknown";
    }
}
