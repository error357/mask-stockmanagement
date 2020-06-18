
package Mask.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Stock", url="http://Stock:8080")
public interface StockService {

    @RequestMapping(method= RequestMethod.PATCH, path="/stocks")
    public void store(@RequestBody Stock stock);

}