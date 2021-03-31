package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Invoice;

import java.sql.Date;

@Projection(types = Invoice.class)
public interface CustomInvoice {

    Integer getId();

    Float getPrice();

    Date getCreatedDate();

    Date getDueDate();

    Integer getStatus();

    Integer userId();

    Integer getOrder();
}
