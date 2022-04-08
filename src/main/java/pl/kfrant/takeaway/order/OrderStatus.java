package pl.kfrant.takeaway.order;

public enum OrderStatus {
    NEW,IN_PREPARATION,ON_THE_WAY,DELIVERED;

    public static OrderStatus nextStatus(OrderStatus status) {
        if (status == NEW)
            return IN_PREPARATION;
        else if (status == IN_PREPARATION)
            return ON_THE_WAY;
        else if (status == ON_THE_WAY)
            return DELIVERED;
        else
            throw new IllegalArgumentException("There is no next status for provided value");
    }
}
