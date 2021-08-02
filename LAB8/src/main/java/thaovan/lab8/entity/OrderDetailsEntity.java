package thaovan.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details", schema = "dbo", catalog = "J6Store")
@JsonIgnoreProperties(value = {"ordersEntity"})
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsEntity productsEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsEntity that = (OrderDetailsEntity) o;

        if (id != that.id) return false;
        if (ordersEntity != that.ordersEntity) return false;
        if (productsEntity != that.productsEntity) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productsEntity, price, quantity, ordersEntity);
    }
}
