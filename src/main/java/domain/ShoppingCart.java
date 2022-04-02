package domain;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
public class ShoppingCart {

    private final UUID ownerId;
    private List<CartLineItem> cartLineItems;

    public ShoppingCart(UUID ownerId){
        this.ownerId = ownerId;
        this.cartLineItems = new LinkedList<>();
    };

    public ShoppingCart(UUID ownerId, List<CartLineItem> lineItems) {
        this.ownerId = ownerId;
        this.cartLineItems = lineItems;
    }

    public void addLineItem(CartLineItem newItem){
        for (CartLineItem item: cartLineItems) {
            if (item.equals(newItem)){
                item.changeQuantity(item.getQuantity()+ newItem.getQuantity());
                return;
            }
        }
        this.cartLineItems.add(newItem);
    }

    public void changeQuantity (CartLineItem lineItem, int quantity) {
        for (CartLineItem item: cartLineItems) {
            if (item.equals(lineItem)){
                item.changeQuantity(quantity);
                return;
            }
        }
    }
    
    public void removeLineItem (CartLineItem lineItemToRemove){
        for (CartLineItem lineItem: cartLineItems) {
            if (lineItem.equals(lineItemToRemove)){
                cartLineItems.remove(lineItemToRemove);
                return;
            }
        }
    }
}
