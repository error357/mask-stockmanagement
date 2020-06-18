package Mask;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="StockManagement_table")
public class StockManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long contractId;
    private String maskType;
    private Integer qty;

    @PostPersist
    public void onPostPersist(){
        Put put = new Put();
        BeanUtils.copyProperties(this, put);
        put.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        //Mask.external.Stock stock = new Mask.external.Stock();
        // mappings goes here
        //Application.applicationContext.getBean(Mask.external.StockService.class).store(stock);


    }

    @PreRemove
    public void onPreRemove(){
        Returned returned = new Returned();
        BeanUtils.copyProperties(this, returned);
        returned.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        //Mask.external.Stock stock = new Mask.external.Stock();
        // mappings goes here
        //Application.applicationContext.getBean(Mask.external.StockService.class).cancel(stock);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
    public String getMaskType() {
        return maskType;
    }

    public void setMaskType(String maskType) {
        this.maskType = maskType;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
