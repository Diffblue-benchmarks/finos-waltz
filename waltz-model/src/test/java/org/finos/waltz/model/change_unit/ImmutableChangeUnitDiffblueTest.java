package org.finos.waltz.model.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit.Builder;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeUnitDiffblueTest {
  /**
   * Test {@link ImmutableChangeUnit#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeUnit#builder()}
   *   <li>{@link ImmutableChangeUnit#description(String)}
   *   <li>{@link ImmutableChangeUnit#externalId(String)}
   *   <li>{@link ImmutableChangeUnit#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableChangeUnit#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeUnit Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)", "Builder Builder.lastUpdatedAt(LocalDateTime)",
      "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualChangeSetIdResult = ImmutableChangeUnit.builder().changeSetId(1L);
    Optional<Long> changeSetId = Optional.<Long>of(1L);
    Builder actualExternalIdResult = actualChangeSetIdResult.changeSetId(changeSetId)
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);
    Builder actualLastUpdatedAtResult = actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#action(ChangeAction)}.
   * <p>
   * Method under test: {@link Builder#action(ChangeAction)}
   */
  @Test
  @DisplayName("Test Builder action(ChangeAction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.action(ChangeAction)"})
  void testBuilderAction() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.action(ChangeAction.ACTIVATE));
  }

  /**
   * Test Builder {@link Builder#changeSetId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#changeSetId(long)}
   */
  @Test
  @DisplayName("Test Builder changeSetId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeSetId(long)"})
  void testBuilderChangeSetIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeSetId(1L));
  }

  /**
   * Test Builder {@link Builder#changeSetId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#changeSetId(Optional)}
   */
  @Test
  @DisplayName("Test Builder changeSetId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeSetId(Optional)"})
  void testBuilderChangeSetIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    Optional<Long> changeSetId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.changeSetId(changeSetId));
  }

  /**
   * Test Builder {@link Builder#executionStatus(ExecutionStatus)}.
   * <p>
   * Method under test: {@link Builder#executionStatus(ExecutionStatus)}
   */
  @Test
  @DisplayName("Test Builder executionStatus(ExecutionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.executionStatus(ExecutionStatus)"})
  void testBuilderExecutionStatus() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.executionStatus(ExecutionStatus.PENDING));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ChangeUnit} {@link ChangeUnit#changeSetId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'; given empty; when ChangeUnit changeSetId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit_givenEmpty_whenChangeUnitChangeSetIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.changeSetId()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ChangeUnit} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'; given empty; when ChangeUnit externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit_givenEmpty_whenChangeUnitExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ChangeUnit} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'; given empty; when ChangeUnit id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit_givenEmpty_whenChangeUnitIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    when(instance.subjectEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).subjectEntity();
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   * <ul>
   *   <li>When {@link ChangeUnit} {@link DescriptionProvider#description()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'; when ChangeUnit description() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit_whenChangeUnitDescriptionReturnNull() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    when(instance.subjectEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).subjectEntity();
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#subjectEntity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#subjectEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder subjectEntity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjectEntity(EntityReference)"})
  void testBuilderSubjectEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectEntity(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#subjectInitialStatus(EntityLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#subjectInitialStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder subjectInitialStatus(EntityLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjectInitialStatus(EntityLifecycleStatus)"})
  void testBuilderSubjectInitialStatus() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectInitialStatus(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Json {@link Json#action()}.
   * <p>
   * Method under test: {@link Json#action()}
   */
  @Test
  @DisplayName("Test Json action()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChangeAction Json.action()"})
  void testJsonAction() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).action());
  }

  /**
   * Test Json {@link Json#changeSetId()}.
   * <p>
   * Method under test: {@link Json#changeSetId()}
   */
  @Test
  @DisplayName("Test Json changeSetId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.changeSetId()"})
  void testJsonChangeSetId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeSetId());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#executionStatus()}.
   * <p>
   * Method under test: {@link Json#executionStatus()}
   */
  @Test
  @DisplayName("Test Json executionStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExecutionStatus Json.executionStatus()"})
  void testJsonExecutionStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).executionStatus());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.subjectInitialStatus);
    assertNull(actualJson.subjectEntity);
    assertNull(actualJson.action);
    assertNull(actualJson.executionStatus);
    assertFalse(actualJson.changeSetId.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#subjectEntity()}.
   * <p>
   * Method under test: {@link Json#subjectEntity()}
   */
  @Test
  @DisplayName("Test Json subjectEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.subjectEntity()"})
  void testJsonSubjectEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectEntity());
  }

  /**
   * Test Json {@link Json#subjectInitialStatus()}.
   * <p>
   * Method under test: {@link Json#subjectInitialStatus()}
   */
  @Test
  @DisplayName("Test Json subjectInitialStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityLifecycleStatus Json.subjectInitialStatus()"})
  void testJsonSubjectInitialStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectInitialStatus());
  }
}
