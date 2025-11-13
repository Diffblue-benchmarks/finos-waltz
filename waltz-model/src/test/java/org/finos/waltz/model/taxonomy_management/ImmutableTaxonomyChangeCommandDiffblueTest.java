package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#status(TaxonomyChangeLifecycleStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.status(TaxonomyChangeLifecycleStatus)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableTaxonomyChangeCommand.builder();
    ImmutableEntityReference changeDomain =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualIdResult =
        actualBuilderResult
            .changeDomain(changeDomain)
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(createdAt)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualLastUpdatedByResult =
        actualIdResult.id(id).lastUpdatedAt(lastUpdatedAt).lastUpdatedBy("2020-03-01");
    Builder actualParamsResult = actualLastUpdatedByResult.params(new HashMap<>());
    ImmutableEntityReference primaryReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualPrimaryReferenceResult = actualParamsResult.primaryReference(primaryReference);
    Builder actualPutAllParamsResult = actualPrimaryReferenceResult.putAllParams(new HashMap<>());
    ImmutableTaxonomyChangeCommand actualImmutableTaxonomyChangeCommand =
        actualPutAllParamsResult
            .putParams(new SimpleEntry<>("Key", "42"))
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableTaxonomyChangeCommand.lastUpdatedBy());
    Map<String, String> paramsResult = actualImmutableTaxonomyChangeCommand.params();
    assertEquals(1, paramsResult.size());
    assertEquals("42", paramsResult.get("Key"));
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualImmutableTaxonomyChangeCommand.createdBy());
    assertEquals(
        TaxonomyChangeLifecycleStatus.DRAFT, actualImmutableTaxonomyChangeCommand.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualImmutableTaxonomyChangeCommand.changeType());
    assertSame(createdAt, actualImmutableTaxonomyChangeCommand.createdAt());
    assertSame(lastUpdatedAt, actualImmutableTaxonomyChangeCommand.lastUpdatedAt());
    assertSame(changeDomain, actualImmutableTaxonomyChangeCommand.changeDomain());
    assertSame(primaryReference, actualImmutableTaxonomyChangeCommand.primaryReference());
  }

  /**
   * Test Builder {@link Builder#changeDomain(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changeDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder changeDomain(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeDomain(EntityReference)"})
  void testBuilderChangeDomain_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualChangeDomainResult =
        builderResult.changeDomain(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualChangeDomainResult);
  }

  /**
   * Test Builder {@link Builder#changeType(TaxonomyChangeType)}.
   *
   * <p>Method under test: {@link Builder#changeType(TaxonomyChangeType)}
   */
  @Test
  @DisplayName("Test Builder changeType(TaxonomyChangeType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeType(TaxonomyChangeType)"})
  void testBuilderChangeType() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualChangeTypeResult = builderResult.changeType(TaxonomyChangeType.ADD_PEER);

    // Assert
    assertSame(builderResult, actualChangeTypeResult);
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   *
   * <ul>
   *   <li>When {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName(
      "Test Builder createdBy(String); when 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy_whenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        builderResult
            .from(
                (CreatedProvider)
                    paramsResult
                        .primaryReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .status(TaxonomyChangeLifecycleStatus.DRAFT)
                        .build())
            .build();
    EntityReference changeDomainResult = immutableTaxonomyChangeCommand.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = immutableTaxonomyChangeCommand.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand.lastUpdatedBy());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand2 = builderResult.build();
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand2.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand.createdBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand2.createdBy());
    Map<String, String> paramsResult2 = immutableTaxonomyChangeCommand.params();
    assertEquals(1, paramsResult2.size());
    Map<String, String> paramsResult3 = immutableTaxonomyChangeCommand2.params();
    assertEquals(1, paramsResult3.size());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand.status());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand2.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand.changeType());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand2.changeType());
    assertTrue(paramsResult2.containsKey("Key"));
    assertTrue(paramsResult3.containsKey("Key"));
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException());
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        builderResult
            .from(
                (IdProvider)
                    paramsResult
                        .primaryReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .status(TaxonomyChangeLifecycleStatus.DRAFT)
                        .build())
            .build();
    EntityReference changeDomainResult = immutableTaxonomyChangeCommand.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = immutableTaxonomyChangeCommand.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand.lastUpdatedBy());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand2 = builderResult.build();
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand2.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand.createdBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand2.createdBy());
    Map<String, String> paramsResult2 = immutableTaxonomyChangeCommand.params();
    assertEquals(1, paramsResult2.size());
    Map<String, String> paramsResult3 = immutableTaxonomyChangeCommand2.params();
    assertEquals(1, paramsResult3.size());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand.status());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand2.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand.changeType());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand2.changeType());
    assertTrue(paramsResult2.containsKey("Key"));
    assertTrue(paramsResult3.containsKey("Key"));
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

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
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        builderResult
            .from(
                (LastUpdatedProvider)
                    paramsResult
                        .primaryReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .status(TaxonomyChangeLifecycleStatus.DRAFT)
                        .build())
            .build();
    EntityReference changeDomainResult = immutableTaxonomyChangeCommand.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = immutableTaxonomyChangeCommand.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand.lastUpdatedBy());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand2 = builderResult.build();
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand2.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand.createdBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand2.createdBy());
    Map<String, String> paramsResult2 = immutableTaxonomyChangeCommand.params();
    assertEquals(1, paramsResult2.size());
    Map<String, String> paramsResult3 = immutableTaxonomyChangeCommand2.params();
    assertEquals(1, paramsResult3.size());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand.status());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand2.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand.changeType());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand2.changeType());
    assertTrue(paramsResult2.containsKey("Key"));
    assertTrue(paramsResult3.containsKey("Key"));
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

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
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand instance =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTaxonomyChangeCommand actualImmutableTaxonomyChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutableTaxonomyChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   *
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    Builder actualFromResult =
        builderResult.from(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    // Assert
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand = builderResult.build();
    assertEquals("2020-03-01", immutableTaxonomyChangeCommand.lastUpdatedBy());
    Map<String, String> paramsResult2 = actualFromResult.build().params();
    assertEquals(1, paramsResult2.size());
    assertEquals("42", paramsResult2.get("Key"));
    Map<String, String> paramsResult3 = immutableTaxonomyChangeCommand.params();
    assertEquals(1, paramsResult3.size());
    assertEquals("42", paramsResult3.get("Key"));
    assertEquals("Jan 1, 2020 8:00am GMT+0100", immutableTaxonomyChangeCommand.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, immutableTaxonomyChangeCommand.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, immutableTaxonomyChangeCommand.changeType());
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#params(Map)}.
   *
   * <ul>
   *   <li>Given builder Params is {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with
   *       {@code Key} and {@code 42}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#params(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder params(Map); given builder Params is SimpleEntry(Object, Object) with 'Key' and '42'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.params(Map)"})
  void testBuilderParams_givenBuilderParamsIsSimpleEntryWithKeyAnd42_whenNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    // Act
    Builder actualParamsResult = builderResult.params(null);

    // Assert
    assertSame(builderResult, actualParamsResult);
  }

  /**
   * Test Builder {@link Builder#params(Map)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#params(Map)}
   */
  @Test
  @DisplayName("Test Builder params(Map); given builder; when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.params(Map)"})
  void testBuilderParams_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualParamsResult = builderResult.params(new HashMap<>());

    // Assert
    assertSame(builderResult, actualParamsResult);
  }

  /**
   * Test Builder {@link Builder#params(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#params(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder params(Map); given 'Key'; when HashMap() 'Key' is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.params(Map)"})
  void testBuilderParams_givenKey_whenHashMapKeyIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("Key", "42");

    // Act
    Builder actualParamsResult = builderResult.params(entries);

    // Assert
    assertSame(builderResult, actualParamsResult);
  }

  /**
   * Test Builder {@link Builder#primaryReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#primaryReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder primaryReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.primaryReference(EntityReference)"})
  void testBuilderPrimaryReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualPrimaryReferenceResult =
        builderResult.primaryReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualPrimaryReferenceResult);
  }

  /**
   * Test Builder {@link Builder#putAllParams(Map)}.
   *
   * <ul>
   *   <li>Given builder Params is {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with
   *       {@code Key} and {@code 42}.
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllParams(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder putAllParams(Map); given builder Params is SimpleEntry(Object, Object) with 'Key' and '42'; when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllParams(Map)"})
  void testBuilderPutAllParams_givenBuilderParamsIsSimpleEntryWithKeyAnd42_whenHashMap() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    // Act
    Builder actualPutAllParamsResult = builderResult.putAllParams(new HashMap<>());

    // Assert
    assertSame(builderResult, actualPutAllParamsResult);
  }

  /**
   * Test Builder {@link Builder#putAllParams(Map)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllParams(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllParams(Map); given builder; when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllParams(Map)"})
  void testBuilderPutAllParams_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualPutAllParamsResult = builderResult.putAllParams(new HashMap<>());

    // Assert
    assertSame(builderResult, actualPutAllParamsResult);
  }

  /**
   * Test Builder {@link Builder#putAllParams(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllParams(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder putAllParams(Map); given 'Key'; when HashMap() 'Key' is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllParams(Map)"})
  void testBuilderPutAllParams_givenKey_whenHashMapKeyIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("Key", "42");

    // Act
    Builder actualPutAllParamsResult = builderResult.putAllParams(entries);

    // Assert
    assertSame(builderResult, actualPutAllParamsResult);
  }

  /**
   * Test Builder {@link Builder#putParams(Entry)} with {@code entry}.
   *
   * <ul>
   *   <li>Given builder Params {@code params key} is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putParams(Entry)}
   */
  @Test
  @DisplayName(
      "Test Builder putParams(Entry) with 'entry'; given builder Params 'params key' is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putParams(Entry)"})
  void testBuilderPutParamsWithEntry_givenBuilderParamsParamsKeyIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams("params key", "42");

    // Act
    Builder actualPutParamsResult = builderResult.putParams(new SimpleEntry<>("Key", "42"));

    // Assert
    assertSame(builderResult, actualPutParamsResult);
  }

  /**
   * Test Builder {@link Builder#putParams(Entry)} with {@code entry}.
   *
   * <ul>
   *   <li>When {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code Key} and
   *       {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putParams(Entry)}
   */
  @Test
  @DisplayName(
      "Test Builder putParams(Entry) with 'entry'; when SimpleEntry(Object, Object) with 'Key' and '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putParams(Entry)"})
  void testBuilderPutParamsWithEntry_whenSimpleEntryWithKeyAnd42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualPutParamsResult = builderResult.putParams(new SimpleEntry<>("Key", "42"));

    // Assert
    assertSame(builderResult, actualPutParamsResult);
  }

  /**
   * Test Builder {@link Builder#putParams(String, String)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putParams(String, String)}
   */
  @Test
  @DisplayName(
      "Test Builder putParams(String, String) with 'key', 'value'; given builder; when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putParams(String, String)"})
  void testBuilderPutParamsWithKeyValue_givenBuilder_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act
    Builder actualPutParamsResult = builderResult.putParams("Key", "42");

    // Assert
    assertSame(builderResult, actualPutParamsResult);
  }

  /**
   * Test Builder {@link Builder#putParams(String, String)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putParams(String, String)}
   */
  @Test
  @DisplayName("Test Builder putParams(String, String) with 'key', 'value'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putParams(String, String)"})
  void testBuilderPutParamsWithKeyValue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams(new SimpleEntry<>("Key", "42"));

    // Act
    Builder actualPutParamsResult = builderResult.putParams("Key", "42");

    // Assert
    assertSame(builderResult, actualPutParamsResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#copyOf(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#copyOf(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(TaxonomyChangeCommand); then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.copyOf(TaxonomyChangeCommand)"
  })
  void testCopyOf_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand instance =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualCopyOfResult =
        ImmutableTaxonomyChangeCommand.copyOf(instance);

    // Assert
    EntityReference changeDomainResult = actualCopyOfResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualCopyOfResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualCopyOfResult.changeType());
    assertTrue(actualCopyOfResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualCopyOfResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableTaxonomyChangeCommand.createdAt()"})
  void testCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    LocalDateTime actualCreatedAtResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}, and {@link
   * ImmutableTaxonomyChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeCommand#equals(Object)}
   *   <li>{@link ImmutableTaxonomyChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand2 =
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(immutableTaxonomyChangeCommand, immutableTaxonomyChangeCommand2);
    assertEquals(
        immutableTaxonomyChangeCommand.hashCode(), immutableTaxonomyChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}, and {@link
   * ImmutableTaxonomyChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeCommand#equals(Object)}
   *   <li>{@link ImmutableTaxonomyChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(immutableTaxonomyChangeCommand, immutableTaxonomyChangeCommand);
    int expectedHashCodeResult = immutableTaxonomyChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableTaxonomyChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_CHILD)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("2020-03-01")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.put("Jan 1, 2020 8:00am GMT+0100", "42");

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder paramsResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .params(entries);
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.ABORTED)
            .build();

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeCommand,
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeCommand.equals(Object)",
    "int ImmutableTaxonomyChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build(),
        "Different type to ImmutableTaxonomyChangeCommand");
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code createdAt} is {@code 42}.
   *   <li>Then return params size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap() 'createdAt' is '42'; then return params size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenHashMapCreatedAtIs42_thenReturnParamsSizeIsOne() {
    // Arrange
    HashMap<String, String> params = new HashMap<>();
    params.put("createdAt", "42");

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setChangeType(TaxonomyChangeType.ADD_PEER);
    json.setStatus(TaxonomyChangeLifecycleStatus.DRAFT);
    json.setChangeDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPrimaryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setParams(params);

    // Act
    ImmutableTaxonomyChangeCommand actualFromJsonResult =
        ImmutableTaxonomyChangeCommand.fromJson(json);

    // Assert
    Map<String, String> paramsResult = actualFromJsonResult.params();
    assertEquals(1, paramsResult.size());
    assertEquals("42", paramsResult.get("createdAt"));
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code createdBy} is {@code createdAt}.
   *   <li>Then return params is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap() 'createdBy' is 'createdAt'; then return params is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenHashMapCreatedByIsCreatedAt_thenReturnParamsIsHashMap() {
    // Arrange
    HashMap<String, String> params = new HashMap<>();
    params.put("createdBy", "createdAt");
    params.put("createdAt", "42");

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setChangeType(TaxonomyChangeType.ADD_PEER);
    json.setStatus(TaxonomyChangeLifecycleStatus.DRAFT);
    json.setChangeDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPrimaryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setParams(params);

    // Act
    ImmutableTaxonomyChangeCommand actualFromJsonResult =
        ImmutableTaxonomyChangeCommand.fromJson(json);

    // Assert
    assertEquals(params, actualFromJsonResult.params());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return params Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashMap(); then return params Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenHashMap_thenReturnParamsEmpty() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setChangeType(TaxonomyChangeType.ADD_PEER);
    json.setStatus(TaxonomyChangeLifecycleStatus.DRAFT);
    json.setChangeDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPrimaryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setParams(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualFromJsonResult =
        ImmutableTaxonomyChangeCommand.fromJson(json);

    // Assert
    EntityReference changeDomainResult = actualFromJsonResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualFromJsonResult.changeType());
    assertTrue(actualFromJsonResult.params().isEmpty());
    assertSame(json.changeDomain, changeDomainResult);
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedPrimaryReferenceResult = json.primaryReference;
    assertSame(expectedPrimaryReferenceResult, actualFromJsonResult.primaryReference());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return params Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap(); when Json (default constructor) Id is 'null'; then return params Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenHashMap_whenJsonIdIsNull_thenReturnParamsEmpty() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setChangeType(TaxonomyChangeType.ADD_PEER);
    json.setStatus(TaxonomyChangeLifecycleStatus.DRAFT);
    json.setChangeDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPrimaryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setParams(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualFromJsonResult =
        ImmutableTaxonomyChangeCommand.fromJson(json);

    // Assert
    EntityReference changeDomainResult = actualFromJsonResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualFromJsonResult.changeType());
    assertTrue(actualFromJsonResult.params().isEmpty());
    assertSame(json.changeDomain, changeDomainResult);
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedPrimaryReferenceResult = json.primaryReference;
    assertSame(expectedPrimaryReferenceResult, actualFromJsonResult.primaryReference());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Json} (default constructor) Status is {@code null}.
   *   <li>Then return params Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap(); when Json (default constructor) Status is 'null'; then return params Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenHashMap_whenJsonStatusIsNull_thenReturnParamsEmpty() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setChangeType(TaxonomyChangeType.ADD_PEER);
    json.setStatus(null);
    json.setChangeDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPrimaryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setParams(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualFromJsonResult =
        ImmutableTaxonomyChangeCommand.fromJson(json);

    // Assert
    EntityReference changeDomainResult = actualFromJsonResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualFromJsonResult.changeType());
    assertTrue(actualFromJsonResult.params().isEmpty());
    assertSame(json.changeDomain, changeDomainResult);
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedPrimaryReferenceResult = json.primaryReference;
    assertSame(expectedPrimaryReferenceResult, actualFromJsonResult.primaryReference());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Params is {@code null}.
   *   <li>Then return params is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Params is 'null'; then return params is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonParamsIsNull_thenReturnParamsIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setChangeType(TaxonomyChangeType.ADD_PEER);
    json.setStatus(TaxonomyChangeLifecycleStatus.DRAFT);
    json.setChangeDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setPrimaryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setParams(null);

    // Act
    ImmutableTaxonomyChangeCommand actualFromJsonResult =
        ImmutableTaxonomyChangeCommand.fromJson(json);

    // Assert
    EntityReference changeDomainResult = actualFromJsonResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertNull(actualFromJsonResult.params());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualFromJsonResult.changeType());
    assertSame(json.changeDomain, changeDomainResult);
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedPrimaryReferenceResult = json.primaryReference;
    assertSame(expectedPrimaryReferenceResult, actualFromJsonResult.primaryReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeCommand#changeDomain()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#changeType()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#createdBy()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#lastUpdatedBy()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#params()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#primaryReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableTaxonomyChangeCommand.changeDomain()",
    "TaxonomyChangeType ImmutableTaxonomyChangeCommand.changeType()",
    "String ImmutableTaxonomyChangeCommand.createdBy()",
    "String ImmutableTaxonomyChangeCommand.lastUpdatedBy()",
    "Map ImmutableTaxonomyChangeCommand.params()",
    "EntityReference ImmutableTaxonomyChangeCommand.primaryReference()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    EntityReference actualChangeDomainResult = immutableTaxonomyChangeCommand.changeDomain();
    TaxonomyChangeType actualChangeTypeResult = immutableTaxonomyChangeCommand.changeType();
    String actualCreatedByResult = immutableTaxonomyChangeCommand.createdBy();
    String actualLastUpdatedByResult = immutableTaxonomyChangeCommand.lastUpdatedBy();
    Map<String, String> actualParamsResult = immutableTaxonomyChangeCommand.params();
    EntityReference actualPrimaryReferenceResult =
        immutableTaxonomyChangeCommand.primaryReference();

    // Assert
    assertTrue(actualChangeDomainResult instanceof ImmutableEntityReference);
    assertTrue(actualPrimaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(TaxonomyChangeType.ADD_PEER, actualChangeTypeResult);
    assertTrue(actualParamsResult.isEmpty());
    assertEquals(actualChangeDomainResult, actualPrimaryReferenceResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#id()}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableTaxonomyChangeCommand.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    Optional<Long> actualIdResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#changeDomain()}.
   *
   * <p>Method under test: {@link Json#changeDomain()}
   */
  @Test
  @DisplayName("Test Json changeDomain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.changeDomain()"})
  void testJsonChangeDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeDomain());
  }

  /**
   * Test Json {@link Json#changeType()}.
   *
   * <p>Method under test: {@link Json#changeType()}
   */
  @Test
  @DisplayName("Test Json changeType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeType Json.changeType()"})
  void testJsonChangeType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeType());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   *
   * <p>Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdBy());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.createdBy);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.params);
    assertNull(actualJson.changeDomain);
    assertNull(actualJson.primaryReference);
    assertNull(actualJson.status);
    assertNull(actualJson.changeType);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#params()}.
   *
   * <p>Method under test: {@link Json#params()}
   */
  @Test
  @DisplayName("Test Json params()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Json.params()"})
  void testJsonParams() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().params());
  }

  /**
   * Test Json {@link Json#primaryReference()}.
   *
   * <p>Method under test: {@link Json#primaryReference()}
   */
  @Test
  @DisplayName("Test Json primaryReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.primaryReference()"})
  void testJsonPrimaryReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().primaryReference());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableTaxonomyChangeCommand.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#status()}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeLifecycleStatus ImmutableTaxonomyChangeCommand.status()"})
  void testStatus() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertEquals(
        TaxonomyChangeLifecycleStatus.DRAFT,
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .status());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableTaxonomyChangeCommand.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertEquals(
        "TaxonomyChangeCommand{id=1, createdAt=1970-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, changeType=ADD_PEER, status=DRAFT,"
            + " changeDomain=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, primaryReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, params={}}",
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withChangeDomain(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withChangeDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test withChangeDomain(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withChangeDomain(EntityReference)"
  })
  void testWithChangeDomain() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithChangeDomainResult =
        immutableTaxonomyChangeCommand.withChangeDomain(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableTaxonomyChangeCommand, actualWithChangeDomainResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withChangeType(TaxonomyChangeType)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withChangeType(TaxonomyChangeType)}
   */
  @Test
  @DisplayName("Test withChangeType(TaxonomyChangeType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withChangeType(TaxonomyChangeType)"
  })
  void testWithChangeType() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithChangeTypeResult =
        immutableTaxonomyChangeCommand.withChangeType(TaxonomyChangeType.ADD_PEER);

    // Assert
    assertSame(immutableTaxonomyChangeCommand, actualWithChangeTypeResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withChangeType(TaxonomyChangeType)}.
   *
   * <ul>
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withChangeType(TaxonomyChangeType)}
   */
  @Test
  @DisplayName(
      "Test withChangeType(TaxonomyChangeType); then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withChangeType(TaxonomyChangeType)"
  })
  void testWithChangeType_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_CHILD)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualWithChangeTypeResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .withChangeType(TaxonomyChangeType.ADD_PEER);

    // Assert
    EntityReference changeDomainResult = actualWithChangeTypeResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithChangeTypeResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithChangeTypeResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithChangeTypeResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithChangeTypeResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithChangeTypeResult.changeType());
    assertTrue(actualWithChangeTypeResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithChangeTypeResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithChangeTypeResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithCreatedAtResult =
        immutableTaxonomyChangeCommand.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableTaxonomyChangeCommand, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withCreatedBy(String)"
  })
  void testWithCreatedBy() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithCreatedByResult =
        immutableTaxonomyChangeCommand.withCreatedBy("42");

    // Assert
    assertSame(immutableTaxonomyChangeCommand, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withCreatedBy(String)"
  })
  void testWithCreatedBy_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualWithCreatedByResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .withCreatedBy("42");

    // Assert
    EntityReference changeDomainResult = actualWithCreatedByResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithCreatedByResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithCreatedByResult.lastUpdatedBy());
    assertEquals("42", actualWithCreatedByResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithCreatedByResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithCreatedByResult.changeType());
    assertTrue(actualWithCreatedByResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithCreatedByResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithCreatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableTaxonomyChangeCommand actualWithIdResult =
        immutableTaxonomyChangeCommand.withId(optional);

    // Assert
    assertSame(immutableTaxonomyChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableTaxonomyChangeCommand actualWithIdResult =
        immutableTaxonomyChangeCommand.withId(optional);

    // Assert
    EntityReference changeDomainResult = actualWithIdResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithIdResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithIdResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithIdResult.changeType());
    assertTrue(actualWithIdResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithIdResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithIdResult = immutableTaxonomyChangeCommand.withId(1L);

    // Assert
    assertSame(immutableTaxonomyChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualWithIdResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .withId(42L);

    // Assert
    EntityReference changeDomainResult = actualWithIdResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithIdResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithIdResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithIdResult.changeType());
    assertTrue(actualWithIdResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithIdResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithLastUpdatedAtResult =
        immutableTaxonomyChangeCommand.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableTaxonomyChangeCommand, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithLastUpdatedByResult =
        immutableTaxonomyChangeCommand.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableTaxonomyChangeCommand, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualWithLastUpdatedByResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference changeDomainResult = actualWithLastUpdatedByResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithLastUpdatedByResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithLastUpdatedByResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithLastUpdatedByResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithLastUpdatedByResult.changeType());
    assertTrue(actualWithLastUpdatedByResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithLastUpdatedByResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withParams(Map)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withParams(Map)}
   */
  @Test
  @DisplayName("Test withParams(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withParams(Map)"
  })
  void testWithParams() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithParamsResult =
        immutableTaxonomyChangeCommand.withParams(new HashMap<>());

    // Assert
    assertEquals(immutableTaxonomyChangeCommand, actualWithParamsResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withParams(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeCommand#withParams(Map)}
   */
  @Test
  @DisplayName(
      "Test withParams(Map); when 'null'; then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withParams(Map)"
  })
  void testWithParams_whenNull_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualWithParamsResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .withParams(null);

    // Assert
    EntityReference changeDomainResult = actualWithParamsResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithParamsResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithParamsResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithParamsResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertNull(actualWithParamsResult.params());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithParamsResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithParamsResult.changeType());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithParamsResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithParamsResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withPrimaryReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangeCommand#withPrimaryReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withPrimaryReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withPrimaryReference(EntityReference)"
  })
  void testWithPrimaryReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithPrimaryReferenceResult =
        immutableTaxonomyChangeCommand.withPrimaryReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableTaxonomyChangeCommand, actualWithPrimaryReferenceResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withStatus(TaxonomyChangeLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangeCommand#withStatus(TaxonomyChangeLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(TaxonomyChangeLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withStatus(TaxonomyChangeLifecycleStatus)"
  })
  void testWithStatus() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand immutableTaxonomyChangeCommand =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableTaxonomyChangeCommand actualWithStatusResult =
        immutableTaxonomyChangeCommand.withStatus(TaxonomyChangeLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutableTaxonomyChangeCommand, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeCommand#withStatus(TaxonomyChangeLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then changeDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableTaxonomyChangeCommand#withStatus(TaxonomyChangeLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(TaxonomyChangeLifecycleStatus); then changeDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeCommand ImmutableTaxonomyChangeCommand.withStatus(TaxonomyChangeLifecycleStatus)"
  })
  void testWithStatus_thenChangeDomainReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act
    ImmutableTaxonomyChangeCommand actualWithStatusResult =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.ABORTED)
            .build()
            .withStatus(TaxonomyChangeLifecycleStatus.DRAFT);

    // Assert
    EntityReference changeDomainResult = actualWithStatusResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualWithStatusResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithStatusResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithStatusResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualWithStatusResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualWithStatusResult.changeType());
    assertTrue(actualWithStatusResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualWithStatusResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithStatusResult.lastUpdatedAt().toLocalDate());
  }
}
