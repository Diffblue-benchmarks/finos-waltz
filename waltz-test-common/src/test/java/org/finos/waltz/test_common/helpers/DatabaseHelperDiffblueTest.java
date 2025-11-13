package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.service.database_information.DatabaseInformationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseHelperDiffblueTest {
  @InjectMocks private DatabaseHelper databaseHelper;

  @Mock private DatabaseInformationService databaseInformationService;

  /**
   * Test {@link DatabaseHelper#createNewDatabase(String, String)}.
   *
   * <p>Method under test: {@link DatabaseHelper#createNewDatabase(String, String)}
   */
  @Test
  @DisplayName("Test createNewDatabase(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference DatabaseHelper.createNewDatabase(String, String)"})
  void testCreateNewDatabase() {
    // Arrange
    when(databaseInformationService.createDatabase(Mockito.<DatabaseInformation>any()))
        .thenReturn(1L);

    // Act
    EntityReference actualCreateNewDatabaseResult =
        databaseHelper.createNewDatabase("Database Name", "Instance Name");

    // Assert
    verify(databaseInformationService).createDatabase(isA(DatabaseInformation.class));
    assertTrue(actualCreateNewDatabaseResult instanceof ImmutableEntityReference);
    assertNull(actualCreateNewDatabaseResult.description());
    assertEquals(1L, actualCreateNewDatabaseResult.id());
    assertEquals(EntityKind.DATABASE, actualCreateNewDatabaseResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualCreateNewDatabaseResult.entityLifecycleStatus());
  }
}
