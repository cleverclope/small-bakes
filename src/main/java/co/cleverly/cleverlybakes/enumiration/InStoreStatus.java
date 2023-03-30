package co.cleverly.cleverlybakes.enumiration;

public enum InStoreStatus {
    ITEM_AVAILABLE("ITEM_AVAILABLE"),
    ITEM_NOT_AVAILABLE("ITEM_NOT_AVAILABLE");

    private final String inStoreStatus;

    InStoreStatus(String inStoreStatus){
        this.inStoreStatus = inStoreStatus;
    }
    public String getInStoreStatus(){
        return this.inStoreStatus;
    }
}
