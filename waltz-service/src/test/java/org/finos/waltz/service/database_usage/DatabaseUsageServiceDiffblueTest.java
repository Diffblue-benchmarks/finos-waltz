package org.finos.waltz.service.database_usage;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.database_usage.DatabaseUsageDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.database_usage.DatabaseUsage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseUsageServiceDiffblueTest {
  @Mock private DatabaseUsageDao databaseUsageDao;

  @InjectMocks private DatabaseUsageService databaseUsageService;

  /**
   * Test {@link DatabaseUsageService#findByDatabaseId(long)}.
   *
   * <p>Method under test: {@link DatabaseUsageService#findByDatabaseId(long)}
   */
  @Test
  @DisplayName("Test findByDatabaseId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DatabaseUsageService.findByDatabaseId(long)"})
  void testFindByDatabaseId() {
    // Arrange
    ArrayList<DatabaseUsage> databaseUsageList = new ArrayList<>();
    when(databaseUsageDao.findByDatabaseId(anyLong())).thenReturn(databaseUsageList);

    // Act
    Collection<DatabaseUsage> actualFindByDatabaseIdResult =
        databaseUsageService.findByDatabaseId(1L);

    // Assert
    verify(databaseUsageDao).findByDatabaseId(1L);
    assertTrue(actualFindByDatabaseIdResult instanceof List);
    assertTrue(actualFindByDatabaseIdResult.isEmpty());
    assertSame(databaseUsageList, actualFindByDatabaseIdResult);
  }

  /**
   * Test {@link DatabaseUsageService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link DatabaseUsageService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DatabaseUsageService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    ArrayList<DatabaseUsage> databaseUsageList = new ArrayList<>();
    when(databaseUsageDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(databaseUsageList);

    // Act
    Collection<DatabaseUsage> actualFindByEntityReferenceResult =
        databaseUsageService.findByEntityReference(null);

    // Assert
    verify(databaseUsageDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult instanceof List);
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(databaseUsageList, actualFindByEntityReferenceResult);
  }
}
