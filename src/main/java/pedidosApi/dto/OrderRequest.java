package pedidosApi.dto;

import java.util.List;

public class OrderRequest {

    private List<OrderRequestItems> items;

    public List<OrderRequestItems> getItems() {
        return items;
    }
    public void setItems(List<OrderRequestItems> items) {
        this.items = items;
    }
}
