package ua.hillel.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*-тест на логин, должен принимать имя пользователя, его пароль и роль.
Тестовые данные нужно сгенерировать через dataprovider. этот тест нужно добавить в группу

-второй тест, который зависит от группы первого теста.
тестовые данные в датапровайдере можно менять вручную так, чтобы логин-тест фейлился при определённых условиях.
посмотреть, как будет при этом запускаться этот зависимый тест.

-третий тест должен принимать параметры извне (можно задать значения через testng.xml).
имя и значение параметра - без разницы, в тесте это значение можно просто вывести в консоль

*/

public class AuthorizationTests {

    @DataProvider(name = "customer_settings")
    public Object[][] generateCustomerSettings() {
        Object[][] customer = {
                {"name", "password", "admin"}};
        return customer;
    }

    @Test(description = "Login test", dataProvider = "customer_settings", groups = {"Authorization tests"})
    public void loginTest(String name, String pass, String role) throws Exception {
        System.out.println("Customer settings: " + name + " " + pass + " " + role);
        System.out.println("Test method one belonging to group Authorization tests.");
        if (role.equals("free user")) {
            throw new Exception("Test failed");
        }
    }

    @Test(description = "Test depends on Group", dependsOnGroups = {"Authorization tests"})
    public void methodDependsOnGroup() {
        System.out.println("This method depends on Authorization tests Group");
    }

    @Parameters({"name", "password", "country", "role"})
    @Test(description = "Sign Up test")
    public void signUpTest(String name, String password, String country, String role) {
        System.out.println("User credentials are: " + name + " " + password + " " + country + " " + role);
    }
}
