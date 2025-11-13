package org.finos.waltz.service.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindCreateCommand;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindUsageStat;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindUsageStat.Builder;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementKindServiceDiffblueTest {
  /**
   * Test {@link InvolvementKindService#findAll()}.
   *
   * <p>Method under test: {@link InvolvementKindService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindService.findAll()"})
  void testFindAll() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<InvolvementKind> actualFindAllResult =
        new InvolvementKindService(involvementKindDao).findAll();

    // Assert
    verify(involvementKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link InvolvementKindService#getById(long)}.
   *
   * <p>Method under test: {@link InvolvementKindService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindService.getById(long)"})
  void testGetById() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(involvementKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    InvolvementKind actualById = new InvolvementKindService(involvementKindDao).getById(1L);

    // Assert
    verify(involvementKindDao).getById(1L);
    assertTrue(actualById instanceof ImmutableInvolvementKind);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Permitted Role", actualById.permittedRole());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityKind.ALL, actualById.subjectKind());
    assertTrue(actualById.transitive());
    assertTrue(actualById.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link InvolvementKindService#findKeyInvolvementKindsByEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementKindService#findKeyInvolvementKindsByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementKindsByEntityKind(EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindService.findKeyInvolvementKindsByEntityKind(EntityKind)"})
  void testFindKeyInvolvementKindsByEntityKind_thenReturnEmpty() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<InvolvementKind> actualFindKeyInvolvementKindsByEntityKindResult =
        new InvolvementKindService(involvementKindDao)
            .findKeyInvolvementKindsByEntityKind(EntityKind.ALL);

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementKindsByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementKindService#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link InvolvementKindDao} {@link
   *       InvolvementKindDao#create(InvolvementKindCreateCommand, String)} return one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindService#create(InvolvementKindCreateCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); given InvolvementKindDao create(InvolvementKindCreateCommand, String) return one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindService.create(InvolvementKindCreateCommand, String)"})
  void testCreate_givenInvolvementKindDaoCreateReturnOne_thenReturnLongValueIsOne() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.create(
            Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);

    // Act
    Long actualCreateResult =
        involvementKindService.create(
            ImmutableInvolvementKindCreateCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build(),
            "janedoe");

    // Assert
    verify(involvementKindDao).create(isA(InvolvementKindCreateCommand.class), eq("janedoe"));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link InvolvementKindService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link InvolvementKindDao} {@link InvolvementKindDao#deleteIfNotUsed(long)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given InvolvementKindDao deleteIfNotUsed(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindService.delete(long)"})
  void testDelete_givenInvolvementKindDaoDeleteIfNotUsedReturnFalse_thenReturnFalse() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.deleteIfNotUsed(anyLong())).thenReturn(false);

    // Act
    boolean actualDeleteResult = new InvolvementKindService(involvementKindDao).delete(1L);

    // Assert
    verify(involvementKindDao).deleteIfNotUsed(1L);
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link InvolvementKindService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link InvolvementKindDao} {@link InvolvementKindDao#deleteIfNotUsed(long)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given InvolvementKindDao deleteIfNotUsed(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindService.delete(long)"})
  void testDelete_givenInvolvementKindDaoDeleteIfNotUsedReturnTrue_thenReturnTrue() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.deleteIfNotUsed(anyLong())).thenReturn(true);

    // Act
    boolean actualDeleteResult = new InvolvementKindService(involvementKindDao).delete(1L);

    // Assert
    verify(involvementKindDao).deleteIfNotUsed(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link InvolvementKindService#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindService#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementKindService.loadUsageStats()"})
  void testLoadUsageStats() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.loadUsageStats()).thenReturn(new HashSet<>());

    // Act
    Set<InvolvementKindUsageStat> actualLoadUsageStatsResult =
        new InvolvementKindService(involvementKindDao).loadUsageStats();

    // Assert
    verify(involvementKindDao).loadUsageStats();
    assertTrue(actualLoadUsageStatsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementKindService#loadUsageStatsForKind(Long)}.
   *
   * <p>Method under test: {@link InvolvementKindService#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindService.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);

    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(involvementKindDao.loadUsageStatsForKind(Mockito.<Long>any()))
        .thenReturn(
            builderResult
                .involvementKind(
                    ImmutableInvolvementKind.builder()
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .lastUpdatedAt(ofResult.atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .name("Name")
                        .permittedRole("Permitted Role")
                        .subjectKind(EntityKind.ALL)
                        .build())
                .build());

    // Act
    InvolvementKindUsageStat actualLoadUsageStatsForKindResult =
        new InvolvementKindService(involvementKindDao).loadUsageStatsForKind(1L);

    // Assert
    verify(involvementKindDao).loadUsageStatsForKind(1L);
    InvolvementKind involvementKindResult = actualLoadUsageStatsForKindResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableInvolvementKind);
    assertTrue(actualLoadUsageStatsForKindResult instanceof ImmutableInvolvementKindUsageStat);
    assertEquals("2020-03-01", involvementKindResult.lastUpdatedBy());
    assertEquals("Name", involvementKindResult.name());
    assertEquals("Permitted Role", involvementKindResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", involvementKindResult.description());
    assertEquals(EntityKind.ALL, involvementKindResult.kind());
    assertEquals(EntityKind.ALL, involvementKindResult.subjectKind());
    assertTrue(actualLoadUsageStatsForKindResult.breakdown().isEmpty());
    assertTrue(involvementKindResult.transitive());
    assertTrue(involvementKindResult.userSelectable());
    assertSame(ofResult, involvementKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link InvolvementKindService#getByExternalId(String)}.
   *
   * <p>Method under test: {@link InvolvementKindService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindService.getByExternalId(String)"})
  void testGetByExternalId() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(involvementKindDao.getByExternalId(Mockito.<String>any()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    InvolvementKind actualByExternalId =
        new InvolvementKindService(involvementKindDao).getByExternalId("42");

    // Assert
    verify(involvementKindDao).getByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableInvolvementKind);
    LocalDateTime lastUpdatedAtResult = actualByExternalId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualByExternalId.lastUpdatedBy());
    assertEquals("Name", actualByExternalId.name());
    assertEquals("Permitted Role", actualByExternalId.permittedRole());
    assertEquals("The characteristics of someone or something", actualByExternalId.description());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(EntityKind.ALL, actualByExternalId.subjectKind());
    assertTrue(actualByExternalId.transitive());
    assertTrue(actualByExternalId.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }
}
