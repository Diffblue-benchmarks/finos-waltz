package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.CreatedUserTimestampProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastAttestedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowDiffblueTest {
  /**
   * Test Builder {@link Builder#created(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#created(Optional)}
   */
  @Test
  @DisplayName("Test Builder created(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.created(Optional)"})
  void testBuilderCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<? extends UserTimestamp> created = Optional.of(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.created(created));
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
    Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code CreatedUserTimestampProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code CreatedUserTimestampProvider}.
   * <ul>
   *   <li>Given {@link Optional} with {@link UserTimestamp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; given Optional with UserTimestamp")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_givenOptionalWithUserTimestamp() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code CreatedUserTimestampProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code EntityLifecycleStatusProvider}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'; given 'ACTIVE'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider_givenActive_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code EntityLifecycleStatusProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'; given 'true'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider_givenTrue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'; given 'true'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider_givenTrue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   * <p>
   * Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   * <p>
   * Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   * <p>
   * Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider3() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.lastAttestedBy()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    when(instance.lastAttestedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastAttestedBy();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlow)} with {@code LogicalFlow}.
   * <p>
   * Method under test: {@link Builder#from(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlow) with 'LogicalFlow'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlow)"})
  void testBuilderFromWithLogicalFlow() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlow)} with {@code LogicalFlow}.
   * <p>
   * Method under test: {@link Builder#from(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlow) with 'LogicalFlow'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlow)"})
  void testBuilderFromWithLogicalFlow2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    when(instance.lastAttestedBy()).thenThrow(new IllegalStateException("instance"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).isReadOnly();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlow)} with {@code LogicalFlow}.
   * <p>
   * Method under test: {@link Builder#from(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlow) with 'LogicalFlow'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlow)"})
  void testBuilderFromWithLogicalFlow3() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult2);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlow)} with {@code LogicalFlow}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlow) with 'LogicalFlow'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlow)"})
  void testBuilderFromWithLogicalFlow_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult4);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult5 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    assertTrue(builderResult.build().isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlow)} with {@code LogicalFlow}.
   * <ul>
   *   <li>When {@link LogicalFlow} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlow) with 'LogicalFlow'; when LogicalFlow id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlow)"})
  void testBuilderFromWithLogicalFlow_whenLogicalFlowIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    assertTrue(builderResult.build().isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlow)} with {@code LogicalFlow}.
   * <ul>
   *   <li>When {@link LogicalFlow} {@link LastAttestedProvider#lastAttestedAt()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlow) with 'LogicalFlow'; when LogicalFlow lastAttestedAt() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlow)"})
  void testBuilderFromWithLogicalFlow_whenLogicalFlowLastAttestedAtReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    assertTrue(builderResult.build().isRemoved());
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
    Builder builderResult = ImmutableLogicalFlow.builder();
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
    Builder builderResult = ImmutableLogicalFlow.builder();

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
    Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Test Builder {@link Builder#lastAttestedAt(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#lastAttestedAt(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastAttestedAt(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastAttestedAt(Optional)"})
  void testBuilderLastAttestedAtWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<? extends LocalDateTime> lastAttestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.lastAttestedAt(lastAttestedAt));
  }

  /**
   * Test Builder {@link Builder#lastAttestedBy(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#lastAttestedBy(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastAttestedBy(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastAttestedBy(Optional)"})
  void testBuilderLastAttestedByWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<String> lastAttestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.lastAttestedBy(lastAttestedBy));
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
    Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#created()}.
   * <p>
   * Method under test: {@link Json#created()}
   */
  @Test
  @DisplayName("Test Json created()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.created()"})
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).created());
  }

  /**
   * Test Json {@link Json#entityLifecycleStatus()}.
   * <p>
   * Method under test: {@link Json#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityLifecycleStatus Json.entityLifecycleStatus()"})
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityLifecycleStatus());
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
   * Test Json {@link Json#isReadOnly()}.
   * <p>
   * Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isReadOnly());
  }

  /**
   * Test Json {@link Json#isRemoved()}.
   * <p>
   * Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRemoved());
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
   * Test Json {@link Json#lastAttestedAt()}.
   * <p>
   * Method under test: {@link Json#lastAttestedAt()}
   */
  @Test
  @DisplayName("Test Json lastAttestedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.lastAttestedAt()"})
  void testJsonLastAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastAttestedAt());
  }

  /**
   * Test Json {@link Json#lastAttestedBy()}.
   * <p>
   * Method under test: {@link Json#lastAttestedBy()}
   */
  @Test
  @DisplayName("Test Json lastAttestedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.lastAttestedBy()"})
  void testJsonLastAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastAttestedBy());
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.source);
    assertNull(actualJson.target);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastAttestedAt.isPresent());
    assertFalse(actualJson.lastAttestedBy.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
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
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#setIsRemoved(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#source()}.
   * <p>
   * Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).source());
  }

  /**
   * Test Json {@link Json#target()}.
   * <p>
   * Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).target());
  }
}
