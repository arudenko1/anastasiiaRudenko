package ua.hillel.tests.ohhttp;

import com.company.entity.StoreApi;
import org.testng.annotations.Test;

import java.io.IOException;

public class StoreTest {

    @Test
    public void storeTest() throws IOException {
        StoreApi.getInventory();
        StoreApi.postOrderForPet();
        StoreApi.getOrderById(3);
        StoreApi.deleteOrderById(3);
    }
}
