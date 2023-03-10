package laba.carina.demo;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.temporal.ChronoUnit;

import laba.carina.demo.api.DeleteEmployeeMethod;
import laba.carina.demo.api.GetAllEmployeesMethod;
import laba.carina.demo.api.CreateEmployeeMethod;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateEmployee() {
        CreateEmployeeMethod api = new CreateEmployeeMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUserMissingSomeFields() {
        CreateEmployeeMethod api = new CreateEmployeeMethod();
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetAllEmployees() {
        GetAllEmployeesMethod getAllEmployeesMethod = new GetAllEmployeesMethod();
        getAllEmployeesMethod.callAPIExpectSuccess();
        getAllEmployeesMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAllEmployeesMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteEmployees() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }

}
