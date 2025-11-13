package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityReferenceNameResolverDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityReferenceNameResolver entityReferenceNameResolver;

  /**
   * Test {@link EntityReferenceNameResolver#resolve(EntityReference)} with {@code ref}.
   *
   * <p>Method under test: {@link EntityReferenceNameResolver#resolve(EntityReference)}
   */
  @Test
  @DisplayName("Test resolve(EntityReference) with 'ref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional EntityReferenceNameResolver.resolve(EntityReference)"})
  void testResolveWithRef() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Optional<EntityReference> actualResolveResult =
        entityReferenceNameResolver.resolve(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertFalse(actualResolveResult.isPresent());
  }

  /**
   * Test {@link EntityReferenceNameResolver#resolve(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link Optional#get()} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceNameResolver#resolve(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test resolve(EntityReference) with 'ref'; given ArrayList() add '42'; then return get() is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional EntityReferenceNameResolver.resolve(EntityReference)"})
  void testResolveWithRef_givenArrayListAdd42_thenReturnGetIs42() throws DataAccessException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(objectList);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(dsl);

    // Act
    Optional<EntityReference> actualResolveResult =
        entityReferenceNameResolver.resolve(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertEquals("42", actualResolveResult.get());
    assertTrue(actualResolveResult.isPresent());
  }

  /**
   * Test {@link EntityReferenceNameResolver#resolve(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceNameResolver#resolve(EntityReference)}
   */
  @Test
  @DisplayName("Test resolve(EntityReference) with 'ref'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional EntityReferenceNameResolver.resolve(EntityReference)"})
  void testResolveWithRef_thenReturnNotPresent() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(dsl);

    // Act
    Optional<EntityReference> actualResolveResult =
        entityReferenceNameResolver.resolve(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertFalse(actualResolveResult.isPresent());
  }

  /**
   * Test {@link EntityReferenceNameResolver#resolve(List)} with {@code refs}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceNameResolver#resolve(List)}
   */
  @Test
  @DisplayName(
      "Test resolve(List) with 'refs'; given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityReferenceNameResolver.resolve(List)"})
  void testResolveWithRefs_givenDefaultDSLContextWithDialectIsSql99_whenArrayList() {
    // Arrange
    EntityReferenceNameResolver entityReferenceNameResolver =
        new EntityReferenceNameResolver(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(entityReferenceNameResolver.resolve(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link EntityReferenceNameResolver#resolve(List)} with {@code refs}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link DSLContext#select(SelectField, SelectField, SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceNameResolver#resolve(List)}
   */
  @Test
  @DisplayName(
      "Test resolve(List) with 'refs'; given SelectJoinStep fetch(RecordMapper) return ArrayList(); then calls select(SelectField, SelectField, SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityReferenceNameResolver.resolve(List)"})
  void testResolveWithRefs_givenSelectJoinStepFetchReturnArrayList_thenCallsSelect()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(dsl);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    List<EntityReference> actualResolveResult = entityReferenceNameResolver.resolve(refs);

    // Assert
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualResolveResult.isEmpty());
  }

  /**
   * Test {@link EntityReferenceNameResolver#resolve(List)} with {@code refs}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link DSLContext#select(SelectField, SelectField, SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityReferenceNameResolver#resolve(List)}
   */
  @Test
  @DisplayName(
      "Test resolve(List) with 'refs'; given SelectJoinStep fetch(RecordMapper) return ArrayList(); then calls select(SelectField, SelectField, SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityReferenceNameResolver.resolve(List)"})
  void testResolveWithRefs_givenSelectJoinStepFetchReturnArrayList_thenCallsSelect2()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(dsl);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    List<EntityReference> actualResolveResult = entityReferenceNameResolver.resolve(refs);

    // Assert
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualResolveResult.isEmpty());
  }
}
