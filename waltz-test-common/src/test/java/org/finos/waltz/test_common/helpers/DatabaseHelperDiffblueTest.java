package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.service.database_information.DatabaseInformationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class DatabaseHelperDiffblueTest {
  /**
   * Method under test: {@link DatabaseHelper#createNewDatabase(String, String)}
   */
  @Test
  void testCreateNewDatabase() {
    // Arrange
    DatabaseInformationService databaseInformationService = mock(DatabaseInformationService.class);
    when(databaseInformationService.createDatabase(Mockito.<DatabaseInformation>any())).thenReturn(1L);
    DatabaseHelper databaseHelper = new DatabaseHelper();
    ReflectionTestUtils.setField(databaseHelper, "databaseInformationService", databaseInformationService);

    // Act
    EntityReference actualCreateNewDatabaseResult = databaseHelper.createNewDatabase("Database Name", "Instance Name");

    // Assert
    verify(databaseInformationService).createDatabase(isA(DatabaseInformation.class));
    assertTrue(actualCreateNewDatabaseResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewDatabaseResult.description());
    assertEquals(1L, actualCreateNewDatabaseResult.id());
    assertEquals(EntityKind.DATABASE, actualCreateNewDatabaseResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCreateNewDatabaseResult.entityLifecycleStatus());
  }
}
