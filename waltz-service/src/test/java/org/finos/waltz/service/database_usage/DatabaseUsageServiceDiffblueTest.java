package org.finos.waltz.service.database_usage;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.database_usage.DatabaseUsageDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.database_usage.DatabaseUsage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DatabaseUsageServiceDiffblueTest {
  /**
   * Method under test: {@link DatabaseUsageService#findByDatabaseId(long)}
   */
  @Test
  void testFindByDatabaseId() {
    // Arrange
    DatabaseUsageDao databaseUsageDao = mock(DatabaseUsageDao.class);
    ArrayList<DatabaseUsage> databaseUsageList = new ArrayList<>();
    when(databaseUsageDao.findByDatabaseId(anyLong())).thenReturn(databaseUsageList);

    // Act
    Collection<DatabaseUsage> actualFindByDatabaseIdResult = (new DatabaseUsageService(databaseUsageDao))
        .findByDatabaseId(1L);

    // Assert
    verify(databaseUsageDao).findByDatabaseId(eq(1L));
    assertTrue(actualFindByDatabaseIdResult instanceof List);
    assertTrue(actualFindByDatabaseIdResult.isEmpty());
    assertSame(databaseUsageList, actualFindByDatabaseIdResult);
  }

  /**
   * Method under test:
   * {@link DatabaseUsageService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    DatabaseUsageDao databaseUsageDao = mock(DatabaseUsageDao.class);
    ArrayList<DatabaseUsage> databaseUsageList = new ArrayList<>();
    when(databaseUsageDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(databaseUsageList);

    // Act
    Collection<DatabaseUsage> actualFindByEntityReferenceResult = (new DatabaseUsageService(databaseUsageDao))
        .findByEntityReference(null);

    // Assert
    verify(databaseUsageDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult instanceof List);
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(databaseUsageList, actualFindByEntityReferenceResult);
  }
}
