package com.bootcamp;

import com.bootcamp.event.CarNotFoundEvent;
import com.bootcamp.stubs.APBStub;
import com.bootcamp.subscriber.PoliceDepartment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PoliceDepartmentTest {

  @Test
  public void testReportHasBeenFiled() throws Exception {
    int expectedReportCount = 1;
    APBStub apbStub = new APBStub();
    PoliceDepartment department = new PoliceDepartment(apbStub);
    Car missingCar = new Car("NY 12 AB 1234", Car.CarType.HATCHBACK, false);
    CarNotFoundEvent event = new CarNotFoundEvent(missingCar);

    department.notifyCarNotFound(event);

    assertEquals(expectedReportCount, apbStub.getNoOfReportsSubmitted());
  }
}