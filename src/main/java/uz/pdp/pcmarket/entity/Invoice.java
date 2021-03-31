package uz.pdp.pcmarket.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float price;

    private Date createdDate;

    private Date dueDate;

    private Integer status;

    @OneToOne
    private User user;

    @ManyToOne
    private Order order;
}
