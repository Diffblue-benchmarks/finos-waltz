package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastAttestedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDiffblueTest {
  /**
   * Test Builder {@link Builder#basisOffset(int)}.
   * <p>
   * Method under test: {@link Builder#basisOffset(int)}
   */
  @Test
  @DisplayName("Test Builder basisOffset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.basisOffset(int)"})
  void testBuilderBasisOffset() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset(1));
  }

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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<? extends UserTimestamp> created = Optional.of(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.created(created));
  }

  /**
   * Test Builder {@link Builder#criticality(CriticalityValue)}.
   * <ul>
   *   <li>When {@link CriticalityValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#criticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test Builder criticality(CriticalityValue); when CriticalityValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.criticality(CriticalityValue)"})
  void testBuilderCriticality_whenCriticalityValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#frequency(FrequencyKindValue)}.
   * <ul>
   *   <li>When {@link FrequencyKindValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#frequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test Builder frequency(FrequencyKindValue); when FrequencyKindValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.frequency(FrequencyKindValue)"})
  void testBuilderFrequency_whenFrequencyKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequency(FrequencyKindValue.of("42")));
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.specificationId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).specificationId();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenThrow(new IllegalStateException("instance"));
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult2);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.specificationDefinitionId()).thenReturn(emptyResult);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link PhysicalFlow} {@link CreatedUserTimestampProvider#created()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; given empty; when PhysicalFlow created() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_givenEmpty_whenPhysicalFlowCreatedReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult2);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link PhysicalFlow} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; given empty; when PhysicalFlow externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_givenEmpty_whenPhysicalFlowExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult3);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link PhysicalFlow} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; given empty; when PhysicalFlow id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_givenEmpty_whenPhysicalFlowIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult2);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult3);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult5 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertNull(buildResult.description());
    assertNull(buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>Then return build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; then return build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_thenReturnBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult3);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult5 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>Then return build name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; then return build name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_thenReturnBuildNameIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult3);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult5 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult2.description());
    assertNull(buildResult.name());
    assertNull(buildResult2.name());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>When {@link PhysicalFlow} {@link LastAttestedProvider#lastAttestedAt()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; when PhysicalFlow lastAttestedAt() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_whenPhysicalFlowLastAttestedAtReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult3);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   * <ul>
   *   <li>When {@link PhysicalFlow} {@link LastAttestedProvider#lastAttestedBy()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'; when PhysicalFlow lastAttestedBy() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow_whenPhysicalFlowLastAttestedByReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult3);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult5 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult5);
    Optional<String> emptyResult = Optional.empty();
    when(instance.lastAttestedBy()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutablePhysicalFlow buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#logicalFlowId(long)}.
   * <p>
   * Method under test: {@link Builder#logicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlowId(long)"})
  void testBuilderLogicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowId(1L));
  }

  /**
   * Test Builder {@link Builder#specificationDefinitionId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#specificationDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationDefinitionId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specificationDefinitionId(long)"})
  void testBuilderSpecificationDefinitionIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specificationDefinitionId(1L));
  }

  /**
   * Test Builder {@link Builder#specificationDefinitionId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#specificationDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test Builder specificationDefinitionId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specificationDefinitionId(Optional)"})
  void testBuilderSpecificationDefinitionIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<Long> specificationDefinitionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.specificationDefinitionId(specificationDefinitionId));
  }

  /**
   * Test Builder {@link Builder#specificationId(long)}.
   * <p>
   * Method under test: {@link Builder#specificationId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specificationId(long)"})
  void testBuilderSpecificationId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specificationId(1L));
  }

  /**
   * Test Json {@link Json#basisOffset()}.
   * <p>
   * Method under test: {@link Json#basisOffset()}
   */
  @Test
  @DisplayName("Test Json basisOffset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.basisOffset()"})
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).basisOffset());
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
   * Test Json {@link Json#criticality()}.
   * <p>
   * Method under test: {@link Json#criticality()}
   */
  @Test
  @DisplayName("Test Json criticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CriticalityValue Json.criticality()"})
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).criticality());
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
   * Test Json {@link Json#frequency()}.
   * <p>
   * Method under test: {@link Json#frequency()}
   */
  @Test
  @DisplayName("Test Json frequency()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FrequencyKindValue Json.frequency()"})
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).frequency());
  }

  /**
   * Test Json {@link Json#freshnessIndicator()}.
   * <p>
   * Method under test: {@link Json#freshnessIndicator()}
   */
  @Test
  @DisplayName("Test Json freshnessIndicator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreshnessIndicator Json.freshnessIndicator()"})
  void testJsonFreshnessIndicator() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).freshnessIndicator());
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
   * Test Json {@link Json#logicalFlowId()}.
   * <p>
   * Method under test: {@link Json#logicalFlowId()}
   */
  @Test
  @DisplayName("Test Json logicalFlowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.logicalFlowId()"})
  void testJsonLogicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowId());
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
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.freshnessIndicator);
    assertNull(actualJson.criticality);
    assertNull(actualJson.frequency);
    assertNull(actualJson.transport);
    assertEquals(0, actualJson.basisOffset);
    assertEquals(0L, actualJson.logicalFlowId);
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastAttestedAt.isPresent());
    assertFalse(actualJson.lastAttestedBy.isPresent());
    assertFalse(actualJson.specificationDefinitionId.isPresent());
    assertFalse(actualJson.basisOffsetIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
    assertFalse(actualJson.logicalFlowIdIsSet);
    assertFalse(actualJson.specificationIdIsSet);
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
   * Test Json {@link Json#setBasisOffset(int)}.
   * <p>
   * Method under test: {@link Json#setBasisOffset(int)}
   */
  @Test
  @DisplayName("Test Json setBasisOffset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setBasisOffset(int)"})
  void testJsonSetBasisOffset() {
    // Arrange
    Json json = new Json();

    // Act
    json.setBasisOffset(1);

    // Assert
    assertEquals(1, json.basisOffset);
    assertTrue(json.basisOffsetIsSet);
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
   * Test Json {@link Json#setLogicalFlowId(long)}.
   * <p>
   * Method under test: {@link Json#setLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setLogicalFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setLogicalFlowId(long)"})
  void testJsonSetLogicalFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Test Json {@link Json#setSpecificationId(long)}.
   * <p>
   * Method under test: {@link Json#setSpecificationId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecificationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSpecificationId(long)"})
  void testJsonSetSpecificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#specificationDefinitionId()}.
   * <p>
   * Method under test: {@link Json#specificationDefinitionId()}
   */
  @Test
  @DisplayName("Test Json specificationDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.specificationDefinitionId()"})
  void testJsonSpecificationDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specificationDefinitionId());
  }

  /**
   * Test Json {@link Json#specificationId()}.
   * <p>
   * Method under test: {@link Json#specificationId()}
   */
  @Test
  @DisplayName("Test Json specificationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.specificationId()"})
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specificationId());
  }

  /**
   * Test Json {@link Json#transport()}.
   * <p>
   * Method under test: {@link Json#transport()}
   */
  @Test
  @DisplayName("Test Json transport()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportKindValue Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).transport());
  }
}
