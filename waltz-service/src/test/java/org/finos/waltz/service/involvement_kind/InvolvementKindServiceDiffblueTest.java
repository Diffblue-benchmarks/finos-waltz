package org.finos.waltz.service.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementKindServiceDiffblueTest {
  /**
   * Method under test: {@link InvolvementKindService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    when(involvementKindDao.findAll()).thenReturn(involvementKindList);

    // Act
    List<InvolvementKind> actualFindAllResult = (new InvolvementKindService(involvementKindDao)).findAll();

    // Assert
    verify(involvementKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(involvementKindList, actualFindAllResult);
  }

  /**
   * Method under test: {@link InvolvementKindService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.getById(anyLong())).thenReturn(null);

    // Act
    InvolvementKind actualById = (new InvolvementKindService(involvementKindDao)).getById(1L);

    // Assert
    verify(involvementKindDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link InvolvementKindService#findKeyInvolvementKindsByEntityKind(EntityKind)}
   */
  @Test
  void testFindKeyInvolvementKindsByEntityKind() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(involvementKindList);

    // Act
    List<InvolvementKind> actualFindKeyInvolvementKindsByEntityKindResult = (new InvolvementKindService(
        involvementKindDao)).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    assertTrue(actualFindKeyInvolvementKindsByEntityKindResult.isEmpty());
    assertSame(involvementKindList, actualFindKeyInvolvementKindsByEntityKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementKindService#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);

    // Act
    Long actualCreateResult = (new InvolvementKindService(involvementKindDao))
        .create(mock(InvolvementKindCreateCommand.class), "janedoe");

    // Assert
    verify(involvementKindDao).create(isA(InvolvementKindCreateCommand.class), eq("janedoe"));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test: {@link InvolvementKindService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.deleteIfNotUsed(anyLong())).thenReturn(true);

    // Act
    boolean actualDeleteResult = (new InvolvementKindService(involvementKindDao)).delete(1L);

    // Assert
    verify(involvementKindDao).deleteIfNotUsed(eq(1L));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link InvolvementKindService#delete(long)}
   */
  @Test
  void testDelete2() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.deleteIfNotUsed(anyLong())).thenReturn(false);

    // Act
    boolean actualDeleteResult = (new InvolvementKindService(involvementKindDao)).delete(1L);

    // Assert
    verify(involvementKindDao).deleteIfNotUsed(eq(1L));
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link InvolvementKindService#loadUsageStats()}
   */
  @Test
  void testLoadUsageStats() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    HashSet<InvolvementKindUsageStat> involvementKindUsageStatSet = new HashSet<>();
    when(involvementKindDao.loadUsageStats()).thenReturn(involvementKindUsageStatSet);

    // Act
    Set<InvolvementKindUsageStat> actualLoadUsageStatsResult = (new InvolvementKindService(involvementKindDao))
        .loadUsageStats();

    // Assert
    verify(involvementKindDao).loadUsageStats();
    assertTrue(actualLoadUsageStatsResult.isEmpty());
    assertSame(involvementKindUsageStatSet, actualLoadUsageStatsResult);
  }

  /**
   * Method under test: {@link InvolvementKindService#loadUsageStatsForKind(Long)}
   */
  @Test
  void testLoadUsageStatsForKind() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.loadUsageStatsForKind(Mockito.<Long>any())).thenReturn(null);

    // Act
    InvolvementKindUsageStat actualLoadUsageStatsForKindResult = (new InvolvementKindService(involvementKindDao))
        .loadUsageStatsForKind(1L);

    // Assert
    verify(involvementKindDao).loadUsageStatsForKind(eq(1L));
    assertNull(actualLoadUsageStatsForKindResult);
  }

  /**
   * Method under test: {@link InvolvementKindService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.getByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    InvolvementKind actualByExternalId = (new InvolvementKindService(involvementKindDao)).getByExternalId("42");

    // Assert
    verify(involvementKindDao).getByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }
}
