package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.jobs.clients.c1.sc1.model.MaintenanceStatus;
import org.junit.jupiter.api.Test;

class WartungstatusToMaintenanceStatusDiffblueTest {
  /**
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo foo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo 0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo 42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foofoo0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartungfoo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartung0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartung42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo420-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung foo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung 0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung 42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoofoo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoo0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoo42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartungfoo"));
    assertEquals(MaintenanceStatus.SELF,
        WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartung0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartung42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung42foo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung420-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung4242"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42 foo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42 0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42 42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42foo0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartungfoo"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartung0-hauptwartung"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartung42"));
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42420-hauptwartung"));
  }
}
