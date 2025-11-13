package org.finos.waltz.service.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.actor.ActorSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.actor.ActorCreateCommand;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.actor.ImmutableActorCreateCommand;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ActorServiceDiffblueTest {
  /**
   * Test {@link ActorService#findAll()}.
   *
   * <p>Method under test: {@link ActorService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorService.findAll()"})
  void testFindAll() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ActorService actorService = new ActorService(actorDao, mock(ActorSearchDao.class));

    // Act
    List<Actor> actualFindAllResult = actorService.findAll();

    // Assert
    verify(actorDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ActorService#getById(long)}.
   *
   * <p>Method under test: {@link ActorService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorService.getById(long)"})
  void testGetById() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    ActorService actorService = new ActorService(actorDao, mock(ActorSearchDao.class));

    // Act
    Actor actualById = actorService.getById(1L);

    // Assert
    verify(actorDao).getById(1L);
    assertTrue(actualById instanceof ImmutableActor);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertTrue(actualById.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ActorService#create(ActorCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ActorDao} {@link ActorDao#create(ActorCreateCommand, String)} return one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#create(ActorCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(ActorCreateCommand, String); given ActorDao create(ActorCreateCommand, String) return one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ActorService.create(ActorCreateCommand, String)"})
  void testCreate_givenActorDaoCreateReturnOne_thenReturnLongValueIsOne() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.create(Mockito.<ActorCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    ActorService actorService = new ActorService(actorDao, mock(ActorSearchDao.class));

    // Act
    Long actualCreateResult =
        actorService.create(
            ImmutableActorCreateCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .isExternal(true)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(actorDao).create(isA(ActorCreateCommand.class), eq("janedoe"));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link ActorService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link ActorDao} {@link ActorDao#deleteIfNotUsed(long)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given ActorDao deleteIfNotUsed(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorService.delete(long)"})
  void testDelete_givenActorDaoDeleteIfNotUsedReturnFalse_thenReturnFalse() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.deleteIfNotUsed(anyLong())).thenReturn(false);
    ActorService actorService = new ActorService(actorDao, mock(ActorSearchDao.class));

    // Act
    boolean actualDeleteResult = actorService.delete(1L);

    // Assert
    verify(actorDao).deleteIfNotUsed(1L);
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link ActorService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link ActorDao} {@link ActorDao#deleteIfNotUsed(long)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given ActorDao deleteIfNotUsed(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorService.delete(long)"})
  void testDelete_givenActorDaoDeleteIfNotUsedReturnTrue_thenReturnTrue() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.deleteIfNotUsed(anyLong())).thenReturn(true);
    ActorService actorService = new ActorService(actorDao, mock(ActorSearchDao.class));

    // Act
    boolean actualDeleteResult = actorService.delete(1L);

    // Assert
    verify(actorDao).deleteIfNotUsed(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link ActorService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link ActorService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    ActorSearchDao actorSearchDao = mock(ActorSearchDao.class);
    when(actorSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());
    ActorService actorService = new ActorService(mock(ActorDao.class), actorSearchDao);

    // Act
    List<Actor> actualSearchResult = actorService.search((EntitySearchOptions) null);

    // Assert
    verify(actorSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ActorService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Given {@link ActorSearchDao} {@link ActorSearchDao#search(EntitySearchOptions)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#search(String)}
   */
  @Test
  @DisplayName(
      "Test search(String) with 'query'; given ActorSearchDao search(EntitySearchOptions) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorService.search(String)"})
  void testSearchWithQuery_givenActorSearchDaoSearchReturnArrayList_thenReturnEmpty() {
    // Arrange
    ActorSearchDao actorSearchDao = mock(ActorSearchDao.class);
    when(actorSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());
    ActorService actorService = new ActorService(mock(ActorDao.class), actorSearchDao);

    // Act
    List<EntityReference> actualSearchResult = actorService.search("Query");

    // Assert
    verify(actorSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ActorService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorService.search(String)"})
  void testSearchWithQuery_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());

    ActorSearchDao actorSearchDao = mock(ActorSearchDao.class);
    when(actorSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(actorList);
    ActorService actorService = new ActorService(mock(ActorDao.class), actorSearchDao);

    // Act
    List<EntityReference> actualSearchResult = actorService.search("Query");

    // Assert
    verify(actorSearchDao).search(isA(EntitySearchOptions.class));
    assertEquals(1, actualSearchResult.size());
    EntityReference getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ActorService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorService.search(String)"})
  void testSearchWithQuery_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());

    ActorSearchDao actorSearchDao = mock(ActorSearchDao.class);
    when(actorSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(actorList);
    ActorService actorService = new ActorService(mock(ActorDao.class), actorSearchDao);

    // Act
    List<EntityReference> actualSearchResult = actorService.search("Query");

    // Assert
    verify(actorSearchDao).search(isA(EntitySearchOptions.class));
    assertEquals(2, actualSearchResult.size());
    EntityReference getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    EntityReference getResult2 = actualSearchResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link ActorService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ActorService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorService.search(String)"})
  void testSearchWithQuery_whenEmptyString_thenReturnEmpty() {
    // Arrange
    ActorService actorService = new ActorService(mock(ActorDao.class), mock(ActorSearchDao.class));

    // Act and Assert
    assertTrue(actorService.search("").isEmpty());
  }
}
