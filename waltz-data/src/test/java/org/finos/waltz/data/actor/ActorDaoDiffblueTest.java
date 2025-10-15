package org.finos.waltz.data.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.actor.ActorChangeCommand;
import org.finos.waltz.model.actor.ActorCreateCommand;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.schema.tables.records.ActorRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.NoDataFoundException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.postgresql.util.PGTimestamp;

@ExtendWith(MockitoExtension.class)
class ActorDaoDiffblueTest {
  @InjectMocks private ActorDao actorDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link ActorDao#findAll()}.
   *
   * <p>Method under test: {@link ActorDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorDao.findAll()"})
  void testFindAll() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ActorDao#findAll()}.
   *
   * <p>Method under test: {@link ActorDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorDao.findAll()"})
  void testFindAll2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ActorDao#findAll()}.
   *
   * <p>Method under test: {@link ActorDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorDao.findAll()"})
  void testFindAll3() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ActorDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ActorDao.findAll()"})
  void testFindAll_givenSelectJoinStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Actor> actualFindAllResult = actorDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "Name",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "“",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals("\"", actualById.name());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById7() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "‘",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("'", actualById.name());
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById8() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "â€œ",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals("\"", actualById.name());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "â€",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals("\"", actualById.name());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "â€™",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("'", actualById.name());
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given SelectConditionStep fetchOneInto(Class) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_givenSelectConditionStepFetchOneIntoReturnNull() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any())).thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_thenReturnDescriptionIsNull() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L, "Name", null, new Timestamp(1L), "2020-03-01", true, "Provenance", "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("Name", actualById.name());
    assertNull(actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00:00.010}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); then return lastUpdatedAt toLocalTime toString is '00:00:00.010'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_thenReturnLastUpdatedAtToLocalTimeToStringIs000000010()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "“",
            "The characteristics of someone or something",
            new PGTimestamp(10L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.010", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals("\"", actualById.name());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return name is {@code &}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return name is '&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_thenReturnNameIsAmpersand() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "&amp;",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("&", actualById.name());
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_thenReturnNameIsEmptyString() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "​",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("", actualById.name());
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return name is space.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return name is space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_thenReturnNameIsSpace() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            " ",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            true,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals(" ", actualById.name());
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return not External.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return not External")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Actor ActorDao.getById(long)"})
  void testGetById_thenReturnNotExternal() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ActorRecord actorRecord =
        new ActorRecord(
            1L,
            "Name",
            "The characteristics of someone or something",
            new Timestamp(1L),
            "2020-03-01",
            false,
            "Provenance",
            "42");
    when(selectConditionStep.fetchOneInto(Mockito.<Class<ActorRecord>>any()))
        .thenReturn(actorRecord);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Actor actualById = actorDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableActor);
    assertEquals("00:00:00.001", actualById.lastUpdatedAt().toLocalTime().toString());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertFalse(actualById.isExternal());
  }

  /**
   * Test {@link ActorDao#create(ActorCreateCommand, String)}.
   *
   * <p>Method under test: {@link ActorDao#create(ActorCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ActorCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long ActorDao.create(ActorCreateCommand, String)"})
  void testCreate() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ActorRecord>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        NoDataFoundException.class,
        () -> actorDao.create(mock(ActorCreateCommand.class), "janedoe"));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ActorDao#create(ActorCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorCreateCommand#description()}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#create(ActorCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ActorCreateCommand, String); then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long ActorDao.create(ActorCreateCommand, String)"})
  void testCreate_thenCallsDescription() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ActorRecord>>any())).thenReturn(new ActorRecord());

    ActorCreateCommand command = mock(ActorCreateCommand.class);
    when(command.description()).thenThrow(new NoDataFoundException("An error occurred"));
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.create(command, "janedoe"));
    verify(command).description();
    verify(command).name();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ActorDao#update(ActorChangeCommand)}.
   *
   * <p>Method under test: {@link ActorDao#update(ActorChangeCommand)}
   */
  @Test
  @DisplayName("Test update(ActorChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.update(ActorChangeCommand)"})
  void testUpdate() {
    // Arrange
    ActorChangeCommand command = mock(ActorChangeCommand.class);
    when(command.lastUpdate()).thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.update(command));
    verify(command).lastUpdate();
  }

  /**
   * Test {@link ActorDao#update(ActorChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorChangeCommand#id()}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#update(ActorChangeCommand)}
   */
  @Test
  @DisplayName("Test update(ActorChangeCommand); then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.update(ActorChangeCommand)"})
  void testUpdate_thenCallsId() {
    // Arrange
    ActorChangeCommand command = mock(ActorChangeCommand.class);
    when(command.id()).thenThrow(new NoDataFoundException("An error occurred"));
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(command.lastUpdate()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.update(command));
    verify(command).id();
    verify(command).lastUpdate();
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed2() {
    // Arrange
    DeleteUsingStep<ActorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed3() {
    // Arrange
    DeleteConditionStep<ActorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    DeleteUsingStep<ActorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed4() {
    // Arrange
    DeleteConditionStep<ActorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    DeleteConditionStep<ActorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ActorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed5() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ActorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new NoDataFoundException("An error occurred"));

    DeleteConditionStep<ActorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<ActorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<ActorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> actorDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualDeleteIfNotUsedResult = new ActorDao(dsl).deleteIfNotUsed(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"actor\" where (\"actor\".\"id\" = cast(? as bigint) and not exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where (\"involvement\".\"entity_id\" = cast(? as bigint) and \"involvement\".\"entity_kind\" = cast(? as varchar))) and not exists (select \"logical_flow\".\"id\" from \"logical_flow\" where ((\"logical_flow\".\"source_entity_id\" = cast(? as bigint) and \"logical_flow\".\"source_entity_kind\" = cast(? as varchar)) or (\"logical_flow\".\"target_entity_id\" = cast(? as bigint) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar)))))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("ACTOR"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteIfNotUsedResult = new ActorDao(dsl).deleteIfNotUsed(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"actor\" where (\"actor\".\"id\" = ? and not exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where (\"involvement\".\"entity_id\" = ? and \"involvement\".\"entity_kind\" = ?)) and not exists (select \"logical_flow\".\"id\" from \"logical_flow\" where ((\"logical_flow\".\"source_entity_id\" = ? and \"logical_flow\".\"source_entity_kind\" = ?) or (\"logical_flow\".\"target_entity_id\" = ? and \"logical_flow\".\"target_entity_kind\" = ?))))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("ACTOR"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ActorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ActorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<ActorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<ActorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteIfNotUsedResult = actorDao.deleteIfNotUsed(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link ActorDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ActorDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ActorDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ActorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<ActorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<ActorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<ActorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<ActorRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteIfNotUsedResult = actorDao.deleteIfNotUsed(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualDeleteIfNotUsedResult);
  }
}
