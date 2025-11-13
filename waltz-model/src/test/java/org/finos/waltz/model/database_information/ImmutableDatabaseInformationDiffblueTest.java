package org.finos.waltz.model.database_information;

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
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EndOfLifeStatus;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.database_information.ImmutableDatabaseInformation.Builder;
import org.finos.waltz.model.database_information.ImmutableDatabaseInformation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDatabaseInformationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endOfLifeDate(Date)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation Builder.build()",
    "Builder Builder.endOfLifeDate(Date)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    Date endOfLifeDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Builder actualExternalIdResult =
        actualDbmsVersionResult.endOfLifeDate(endOfLifeDate).externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableDatabaseInformation actualImmutableDatabaseInformation =
        actualIdResult
            .id(id)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableDatabaseInformation.dbmsVersion());
    assertEquals("Database Name", actualImmutableDatabaseInformation.databaseName());
    assertEquals("Dbms Name", actualImmutableDatabaseInformation.dbmsName());
    assertEquals("Dbms Vendor", actualImmutableDatabaseInformation.dbmsVendor());
    assertEquals("Instance Name", actualImmutableDatabaseInformation.instanceName());
    assertEquals("Provenance", actualImmutableDatabaseInformation.provenance());
    assertEquals(EntityKind.ALL, actualImmutableDatabaseInformation.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualImmutableDatabaseInformation.lifecycleStatus());
    assertSame(endOfLifeDate, actualImmutableDatabaseInformation.endOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#databaseName(String)}.
   *
   * <ul>
   *   <li>When {@code Database Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#databaseName(String)}
   */
  @Test
  @DisplayName("Test Builder databaseName(String); when 'Database Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.databaseName(String)"})
  void testBuilderDatabaseName_whenDatabaseName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualDatabaseNameResult = builderResult.databaseName("Database Name");

    // Assert
    assertSame(builderResult, actualDatabaseNameResult);
  }

  /**
   * Test Builder {@link Builder#dbmsName(String)}.
   *
   * <ul>
   *   <li>When {@code Dbms Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dbmsName(String)}
   */
  @Test
  @DisplayName("Test Builder dbmsName(String); when 'Dbms Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dbmsName(String)"})
  void testBuilderDbmsName_whenDbmsName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualDbmsNameResult = builderResult.dbmsName("Dbms Name");

    // Assert
    assertSame(builderResult, actualDbmsNameResult);
  }

  /**
   * Test Builder {@link Builder#dbmsVendor(String)}.
   *
   * <ul>
   *   <li>When {@code Dbms Vendor}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dbmsVendor(String)}
   */
  @Test
  @DisplayName("Test Builder dbmsVendor(String); when 'Dbms Vendor'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dbmsVendor(String)"})
  void testBuilderDbmsVendor_whenDbmsVendor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualDbmsVendorResult = builderResult.dbmsVendor("Dbms Vendor");

    // Assert
    assertSame(builderResult, actualDbmsVendorResult);
  }

  /**
   * Test Builder {@link Builder#dbmsVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dbmsVersion(String)}
   */
  @Test
  @DisplayName("Test Builder dbmsVersion(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dbmsVersion(String)"})
  void testBuilderDbmsVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualDbmsVersionResult = builderResult.dbmsVersion("1.0.2");

    // Assert
    assertSame(builderResult, actualDbmsVersionResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   *
   * <p>Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation instance =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    ImmutableDatabaseInformation actualImmutableDatabaseInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation2);
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   *
   * <p>Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation2() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    ImmutableDatabaseInformation instance =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation instance =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    ImmutableDatabaseInformation actualImmutableDatabaseInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation instance =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    ImmutableDatabaseInformation actualImmutableDatabaseInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

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
   *
   * <ul>
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();

    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation instance =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    ImmutableDatabaseInformation actualImmutableDatabaseInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation2);
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
    Builder builderResult = ImmutableDatabaseInformation.builder();

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
    Builder builderResult = ImmutableDatabaseInformation.builder();

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
    Builder builderResult = ImmutableDatabaseInformation.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation instance =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    ImmutableDatabaseInformation actualImmutableDatabaseInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    ImmutableDatabaseInformation instance =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableDatabaseInformation actualImmutableDatabaseInformation = builderResult.build();
    assertEquals(instance, actualImmutableDatabaseInformation);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableDatabaseInformation.builder();

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
    Builder builderResult = ImmutableDatabaseInformation.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#instanceName(String)}.
   *
   * <ul>
   *   <li>When {@code Instance Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#instanceName(String)}
   */
  @Test
  @DisplayName("Test Builder instanceName(String); when 'Instance Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.instanceName(String)"})
  void testBuilderInstanceName_whenInstanceName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualInstanceNameResult = builderResult.instanceName("Instance Name");

    // Assert
    assertSame(builderResult, actualInstanceNameResult);
  }

  /**
   * Test Builder {@link Builder#lifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder lifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecycleStatus(LifecycleStatus)"})
  void testBuilderLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act
    Builder actualLifecycleStatusResult = builderResult.lifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}.
   *
   * <ul>
   *   <li>Then return dbmsVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test copyOf(DatabaseInformation); then return dbmsVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.copyOf(DatabaseInformation)"
  })
  void testCopyOf_thenReturnDbmsVersionIs102() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation instance =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.dbmsVersion());
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}, and {@link
   * ImmutableDatabaseInformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDatabaseInformation#equals(Object)}
   *   <li>{@link ImmutableDatabaseInformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation2 =
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableDatabaseInformation, immutableDatabaseInformation2);
    assertEquals(immutableDatabaseInformation.hashCode(), immutableDatabaseInformation2.hashCode());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}, and {@link
   * ImmutableDatabaseInformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDatabaseInformation#equals(Object)}
   *   <li>{@link ImmutableDatabaseInformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableDatabaseInformation, immutableDatabaseInformation);
    int expectedHashCodeResult = immutableDatabaseInformation.hashCode();
    assertEquals(expectedHashCodeResult, immutableDatabaseInformation.hashCode());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Provenance")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Provenance")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Provenance")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("Provenance");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("Provenance")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(2L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Provenance")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .provenance("Provenance")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Database Name")
            .build();

    Builder dbmsVersionResult2 =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        immutableDatabaseInformation,
        dbmsVersionResult2
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseInformation.equals(Object)",
    "int ImmutableDatabaseInformation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertNotEquals(
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableDatabaseInformation");
  }

  /**
   * Test {@link ImmutableDatabaseInformation#externalId()}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDatabaseInformation.externalId()"})
  void testExternalId() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    Optional<String> actualExternalIdResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link Date#Date()}.
   *   <li>When {@link Json} (default constructor) EndOfLifeDate is {@link Date#Date()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Date(); when Json (default constructor) EndOfLifeDate is Date()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_givenDate_whenJsonEndOfLifeDateIsDate() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setProvenance("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(new Date());
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualFromJsonResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) EndOfLifeDate is {@code null}.
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) EndOfLifeDate is 'null'; then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonEndOfLifeDateIsNull_thenReturnEndOfLifeDateIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setProvenance("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(null);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualFromJsonResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ExternalId is 'null'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonExternalIdIsNull_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setProvenance("Json");
    json.setExternalId(null);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setProvenance("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setProvenance(null);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setProvenance("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return kind is {@code DATABASE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Kind is 'null'; then return kind is 'DATABASE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.fromJson(Json)"})
  void testFromJson_whenJsonKindIsNull_thenReturnKindIsDatabase() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setProvenance("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setDatabaseName("Json");
    json.setInstanceName("Json");
    json.setDbmsName("Json");
    json.setDbmsVersion("Json");
    json.setDbmsVendor("Json");
    json.setLifecycleStatus(LifecycleStatus.ACTIVE);
    json.setEndOfLifeDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setKind(null);

    // Act
    ImmutableDatabaseInformation actualFromJsonResult = ImmutableDatabaseInformation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.databaseName());
    assertEquals("Json", actualFromJsonResult.dbmsName());
    assertEquals("Json", actualFromJsonResult.dbmsVendor());
    assertEquals("Json", actualFromJsonResult.dbmsVersion());
    assertEquals("Json", actualFromJsonResult.instanceName());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.DATABASE, actualFromJsonResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualFromJsonResult.lifecycleStatus());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDatabaseInformation#databaseName()}
   *   <li>{@link ImmutableDatabaseInformation#dbmsName()}
   *   <li>{@link ImmutableDatabaseInformation#dbmsVendor()}
   *   <li>{@link ImmutableDatabaseInformation#dbmsVersion()}
   *   <li>{@link ImmutableDatabaseInformation#endOfLifeDate()}
   *   <li>{@link ImmutableDatabaseInformation#instanceName()}
   *   <li>{@link ImmutableDatabaseInformation#lifecycleStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableDatabaseInformation.databaseName()",
    "String ImmutableDatabaseInformation.dbmsName()",
    "String ImmutableDatabaseInformation.dbmsVendor()",
    "String ImmutableDatabaseInformation.dbmsVersion()",
    "Date ImmutableDatabaseInformation.endOfLifeDate()",
    "String ImmutableDatabaseInformation.instanceName()",
    "LifecycleStatus ImmutableDatabaseInformation.lifecycleStatus()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    Date endOfLifeDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(endOfLifeDate)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    String actualDatabaseNameResult = immutableDatabaseInformation.databaseName();
    String actualDbmsNameResult = immutableDatabaseInformation.dbmsName();
    String actualDbmsVendorResult = immutableDatabaseInformation.dbmsVendor();
    String actualDbmsVersionResult = immutableDatabaseInformation.dbmsVersion();
    Date actualEndOfLifeDateResult = immutableDatabaseInformation.endOfLifeDate();
    String actualInstanceNameResult = immutableDatabaseInformation.instanceName();

    // Assert
    assertEquals("1.0.2", actualDbmsVersionResult);
    assertEquals("Database Name", actualDatabaseNameResult);
    assertEquals("Dbms Name", actualDbmsNameResult);
    assertEquals("Dbms Vendor", actualDbmsVendorResult);
    assertEquals("Instance Name", actualInstanceNameResult);
    assertEquals(LifecycleStatus.ACTIVE, immutableDatabaseInformation.lifecycleStatus());
    assertSame(endOfLifeDate, actualEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#id()}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDatabaseInformation.id()"})
  void testId() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    Optional<Long> actualIdResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#databaseName()}.
   *
   * <p>Method under test: {@link Json#databaseName()}
   */
  @Test
  @DisplayName("Test Json databaseName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.databaseName()"})
  void testJsonDatabaseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().databaseName());
  }

  /**
   * Test Json {@link Json#dbmsName()}.
   *
   * <p>Method under test: {@link Json#dbmsName()}
   */
  @Test
  @DisplayName("Test Json dbmsName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.dbmsName()"})
  void testJsonDbmsName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dbmsName());
  }

  /**
   * Test Json {@link Json#dbmsVendor()}.
   *
   * <p>Method under test: {@link Json#dbmsVendor()}
   */
  @Test
  @DisplayName("Test Json dbmsVendor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.dbmsVendor()"})
  void testJsonDbmsVendor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dbmsVendor());
  }

  /**
   * Test Json {@link Json#dbmsVersion()}.
   *
   * <p>Method under test: {@link Json#dbmsVersion()}
   */
  @Test
  @DisplayName("Test Json dbmsVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.dbmsVersion()"})
  void testJsonDbmsVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dbmsVersion());
  }

  /**
   * Test Json {@link Json#endOfLifeDate()}.
   *
   * <p>Method under test: {@link Json#endOfLifeDate()}
   */
  @Test
  @DisplayName("Test Json endOfLifeDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.endOfLifeDate()"})
  void testJsonEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().endOfLifeDate());
  }

  /**
   * Test Json {@link Json#endOfLifeStatus()}.
   *
   * <p>Method under test: {@link Json#endOfLifeStatus()}
   */
  @Test
  @DisplayName("Test Json endOfLifeStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EndOfLifeStatus Json.endOfLifeStatus()"})
  void testJsonEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().endOfLifeStatus());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
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
   * Test Json {@link Json#instanceName()}.
   *
   * <p>Method under test: {@link Json#instanceName()}
   */
  @Test
  @DisplayName("Test Json instanceName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.instanceName()"})
  void testJsonInstanceName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().instanceName());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#lifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json lifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecycleStatus Json.lifecycleStatus()"})
  void testJsonLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lifecycleStatus());
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
    assertNull(actualJson.databaseName);
    assertNull(actualJson.dbmsName);
    assertNull(actualJson.dbmsVendor);
    assertNull(actualJson.dbmsVersion);
    assertNull(actualJson.instanceName);
    assertNull(actualJson.provenance);
    assertNull(actualJson.endOfLifeDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecycleStatus);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#kind()}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableDatabaseInformation.kind()"})
  void testKind() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#provenance()}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDatabaseInformation.provenance()"})
  void testProvenance() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act and Assert
    assertEquals(
        "Provenance",
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDatabaseInformation.toString()"})
  void testToString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "DatabaseInformation{id=1, provenance=Provenance, externalId=42, databaseName=Database Name,"
            + " instanceName=Instance Name, dbmsName=Dbms Name, dbmsVersion=1.0.2, dbmsVendor=Dbms Vendor,"
            + " lifecycleStatus=ACTIVE, endOfLifeStatus=NOT_END_OF_LIFE, kind=ALL}",
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDatabaseName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDatabaseName(String)}
   */
  @Test
  @DisplayName("Test withDatabaseName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDatabaseName(String)"
  })
  void testWithDatabaseName() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDatabaseNameResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDatabaseName("42");

    // Assert
    assertEquals("1.0.2", actualWithDatabaseNameResult.dbmsVersion());
    assertEquals("42", actualWithDatabaseNameResult.databaseName());
    assertEquals("Dbms Name", actualWithDatabaseNameResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithDatabaseNameResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDatabaseNameResult.instanceName());
    assertEquals("Provenance", actualWithDatabaseNameResult.provenance());
    assertEquals(EntityKind.ALL, actualWithDatabaseNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDatabaseNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDatabaseName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDatabaseName(String)}
   */
  @Test
  @DisplayName("Test withDatabaseName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDatabaseName(String)"
  })
  void testWithDatabaseName2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("42")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithDatabaseNameResult =
        immutableDatabaseInformation.withDatabaseName("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithDatabaseNameResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDatabaseName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDatabaseName(String)}
   */
  @Test
  @DisplayName("Test withDatabaseName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDatabaseName(String)"
  })
  void testWithDatabaseName3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDatabaseNameResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDatabaseName("42");

    // Assert
    assertEquals("1.0.2", actualWithDatabaseNameResult.dbmsVersion());
    assertEquals("42", actualWithDatabaseNameResult.databaseName());
    assertEquals("Dbms Name", actualWithDatabaseNameResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithDatabaseNameResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDatabaseNameResult.instanceName());
    assertEquals("Provenance", actualWithDatabaseNameResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDatabaseNameResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDatabaseNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDatabaseNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDatabaseName(String)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDatabaseName(String)}
   */
  @Test
  @DisplayName("Test withDatabaseName(String); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDatabaseName(String)"
  })
  void testWithDatabaseName_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithDatabaseNameResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDatabaseName("42");

    // Assert
    assertEquals("1.0.2", actualWithDatabaseNameResult.dbmsVersion());
    assertEquals("42", actualWithDatabaseNameResult.databaseName());
    assertEquals("Dbms Name", actualWithDatabaseNameResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithDatabaseNameResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDatabaseNameResult.instanceName());
    assertEquals("Provenance", actualWithDatabaseNameResult.provenance());
    assertNull(actualWithDatabaseNameResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDatabaseNameResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDatabaseNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDatabaseNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsName(String)}
   */
  @Test
  @DisplayName("Test withDbmsName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsName(String)"
  })
  void testWithDbmsName() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDbmsNameResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsName("42");

    // Assert
    assertEquals("1.0.2", actualWithDbmsNameResult.dbmsVersion());
    assertEquals("42", actualWithDbmsNameResult.dbmsName());
    assertEquals("Database Name", actualWithDbmsNameResult.databaseName());
    assertEquals("Dbms Vendor", actualWithDbmsNameResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDbmsNameResult.instanceName());
    assertEquals("Provenance", actualWithDbmsNameResult.provenance());
    assertEquals(EntityKind.ALL, actualWithDbmsNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsName(String)}
   */
  @Test
  @DisplayName("Test withDbmsName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsName(String)"
  })
  void testWithDbmsName2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("42")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithDbmsNameResult =
        immutableDatabaseInformation.withDbmsName("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithDbmsNameResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsName(String)}
   */
  @Test
  @DisplayName("Test withDbmsName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsName(String)"
  })
  void testWithDbmsName3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDbmsNameResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsName("42");

    // Assert
    assertEquals("1.0.2", actualWithDbmsNameResult.dbmsVersion());
    assertEquals("42", actualWithDbmsNameResult.dbmsName());
    assertEquals("Database Name", actualWithDbmsNameResult.databaseName());
    assertEquals("Dbms Vendor", actualWithDbmsNameResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDbmsNameResult.instanceName());
    assertEquals("Provenance", actualWithDbmsNameResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDbmsNameResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDbmsNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsName(String)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsName(String)}
   */
  @Test
  @DisplayName("Test withDbmsName(String); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsName(String)"
  })
  void testWithDbmsName_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithDbmsNameResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsName("42");

    // Assert
    assertEquals("1.0.2", actualWithDbmsNameResult.dbmsVersion());
    assertEquals("42", actualWithDbmsNameResult.dbmsName());
    assertEquals("Database Name", actualWithDbmsNameResult.databaseName());
    assertEquals("Dbms Vendor", actualWithDbmsNameResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDbmsNameResult.instanceName());
    assertEquals("Provenance", actualWithDbmsNameResult.provenance());
    assertNull(actualWithDbmsNameResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDbmsNameResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDbmsNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVendor(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVendor(String)}
   */
  @Test
  @DisplayName("Test withDbmsVendor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVendor(String)"
  })
  void testWithDbmsVendor() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDbmsVendorResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsVendor("42");

    // Assert
    assertEquals("1.0.2", actualWithDbmsVendorResult.dbmsVersion());
    assertEquals("42", actualWithDbmsVendorResult.dbmsVendor());
    assertEquals("Database Name", actualWithDbmsVendorResult.databaseName());
    assertEquals("Dbms Name", actualWithDbmsVendorResult.dbmsName());
    assertEquals("Instance Name", actualWithDbmsVendorResult.instanceName());
    assertEquals("Provenance", actualWithDbmsVendorResult.provenance());
    assertEquals(EntityKind.ALL, actualWithDbmsVendorResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsVendorResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVendor(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVendor(String)}
   */
  @Test
  @DisplayName("Test withDbmsVendor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVendor(String)"
  })
  void testWithDbmsVendor2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("42")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithDbmsVendorResult =
        immutableDatabaseInformation.withDbmsVendor("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithDbmsVendorResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVendor(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVendor(String)}
   */
  @Test
  @DisplayName("Test withDbmsVendor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVendor(String)"
  })
  void testWithDbmsVendor3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDbmsVendorResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsVendor("42");

    // Assert
    assertEquals("1.0.2", actualWithDbmsVendorResult.dbmsVersion());
    assertEquals("42", actualWithDbmsVendorResult.dbmsVendor());
    assertEquals("Database Name", actualWithDbmsVendorResult.databaseName());
    assertEquals("Dbms Name", actualWithDbmsVendorResult.dbmsName());
    assertEquals("Instance Name", actualWithDbmsVendorResult.instanceName());
    assertEquals("Provenance", actualWithDbmsVendorResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDbmsVendorResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDbmsVendorResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsVendorResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVendor(String)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVendor(String)}
   */
  @Test
  @DisplayName("Test withDbmsVendor(String); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVendor(String)"
  })
  void testWithDbmsVendor_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithDbmsVendorResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsVendor("42");

    // Assert
    assertEquals("1.0.2", actualWithDbmsVendorResult.dbmsVersion());
    assertEquals("42", actualWithDbmsVendorResult.dbmsVendor());
    assertEquals("Database Name", actualWithDbmsVendorResult.databaseName());
    assertEquals("Dbms Name", actualWithDbmsVendorResult.dbmsName());
    assertEquals("Instance Name", actualWithDbmsVendorResult.instanceName());
    assertEquals("Provenance", actualWithDbmsVendorResult.provenance());
    assertNull(actualWithDbmsVendorResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDbmsVendorResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDbmsVendorResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsVendorResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVersion(String)}
   */
  @Test
  @DisplayName("Test withDbmsVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVersion(String)"
  })
  void testWithDbmsVersion() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDbmsVersionResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsVersion("42");

    // Assert
    assertEquals("42", actualWithDbmsVersionResult.dbmsVersion());
    assertEquals("Database Name", actualWithDbmsVersionResult.databaseName());
    assertEquals("Dbms Name", actualWithDbmsVersionResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithDbmsVersionResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDbmsVersionResult.instanceName());
    assertEquals("Provenance", actualWithDbmsVersionResult.provenance());
    assertEquals(EntityKind.ALL, actualWithDbmsVersionResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsVersionResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVersion(String)}
   */
  @Test
  @DisplayName("Test withDbmsVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVersion(String)"
  })
  void testWithDbmsVersion2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("42");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithDbmsVersionResult =
        immutableDatabaseInformation.withDbmsVersion("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithDbmsVersionResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVersion(String)}
   */
  @Test
  @DisplayName("Test withDbmsVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVersion(String)"
  })
  void testWithDbmsVersion3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithDbmsVersionResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsVersion("42");

    // Assert
    assertEquals("42", actualWithDbmsVersionResult.dbmsVersion());
    assertEquals("Database Name", actualWithDbmsVersionResult.databaseName());
    assertEquals("Dbms Name", actualWithDbmsVersionResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithDbmsVersionResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDbmsVersionResult.instanceName());
    assertEquals("Provenance", actualWithDbmsVersionResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDbmsVersionResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDbmsVersionResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsVersionResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withDbmsVersion(String)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withDbmsVersion(String)}
   */
  @Test
  @DisplayName("Test withDbmsVersion(String); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withDbmsVersion(String)"
  })
  void testWithDbmsVersion_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithDbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withDbmsVersion("42");

    // Assert
    assertEquals("42", actualWithDbmsVersionResult.dbmsVersion());
    assertEquals("Database Name", actualWithDbmsVersionResult.databaseName());
    assertEquals("Dbms Name", actualWithDbmsVersionResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithDbmsVersionResult.dbmsVendor());
    assertEquals("Instance Name", actualWithDbmsVersionResult.instanceName());
    assertEquals("Provenance", actualWithDbmsVersionResult.provenance());
    assertNull(actualWithDbmsVersionResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithDbmsVersionResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithDbmsVersionResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithDbmsVersionResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withEndOfLifeDate(Date)"
  })
  void testWithEndOfLifeDate() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithEndOfLifeDateResult =
        immutableDatabaseInformation.withEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableDatabaseInformation, actualWithEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withEndOfLifeDate(Date)}.
   *
   * <ul>
   *   <li>Then return dbmsVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withEndOfLifeDate(Date); then return dbmsVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withEndOfLifeDate(Date)"
  })
  void testWithEndOfLifeDate_thenReturnDbmsVersionIs102() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithEndOfLifeDateResult =
        immutableDatabaseInformation.withEndOfLifeDate(
            Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1.0.2", actualWithEndOfLifeDateResult.dbmsVersion());
    assertEquals("Database Name", actualWithEndOfLifeDateResult.databaseName());
    assertEquals("Dbms Name", actualWithEndOfLifeDateResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithEndOfLifeDateResult.dbmsVendor());
    assertEquals("Instance Name", actualWithEndOfLifeDateResult.instanceName());
    assertEquals("Provenance", actualWithEndOfLifeDateResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithEndOfLifeDateResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithEndOfLifeDateResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithEndOfLifeDateResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        immutableDatabaseInformation.withExternalId(optional);

    // Assert
    assertSame(immutableDatabaseInformation, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("External Id")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        immutableDatabaseInformation.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithExternalIdResult.databaseName());
    assertEquals("Dbms Name", actualWithExternalIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithExternalIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithExternalIdResult.instanceName());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("External Id")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        immutableDatabaseInformation.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithExternalIdResult.databaseName());
    assertEquals("Dbms Name", actualWithExternalIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithExternalIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithExternalIdResult.instanceName());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnEndOfLifeDateIsNull() {
    // Arrange
    ImmutableDatabaseInformation immutableDatabaseInformation =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("External Id")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        immutableDatabaseInformation.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithExternalIdResult.databaseName());
    assertEquals("Dbms Name", actualWithExternalIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithExternalIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithExternalIdResult.instanceName());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertNull(actualWithExternalIdResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithExternalIdResult.databaseName());
    assertEquals("Dbms Name", actualWithExternalIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithExternalIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithExternalIdResult.instanceName());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithExternalIdResult.databaseName());
    assertEquals("Dbms Name", actualWithExternalIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithExternalIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithExternalIdResult.instanceName());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        immutableDatabaseInformation.withExternalId("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'; then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithExternalIdResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithExternalIdResult.databaseName());
    assertEquals("Dbms Name", actualWithExternalIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithExternalIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithExternalIdResult.instanceName());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertNull(actualWithExternalIdResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableDatabaseInformation actualWithIdResult = immutableDatabaseInformation.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithIdResult.databaseName());
    assertEquals("Dbms Name", actualWithIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithIdResult.instanceName());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(Optional)"})
  void testWithIdWithOptional2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableDatabaseInformation actualWithIdResult = immutableDatabaseInformation.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithIdResult.databaseName());
    assertEquals("Dbms Name", actualWithIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithIdResult.instanceName());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(Optional)"})
  void testWithIdWithOptional3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDatabaseInformation actualWithIdResult = immutableDatabaseInformation.withId(optional);

    // Assert
    assertSame(immutableDatabaseInformation, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(Optional)"})
  void testWithIdWithOptional_thenReturnEndOfLifeDateIsNull() {
    // Arrange
    ImmutableDatabaseInformation immutableDatabaseInformation =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableDatabaseInformation actualWithIdResult = immutableDatabaseInformation.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithIdResult.databaseName());
    assertEquals("Dbms Name", actualWithIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithIdResult.instanceName());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertNull(actualWithIdResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithIdResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithIdResult.databaseName());
    assertEquals("Dbms Name", actualWithIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithIdResult.instanceName());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(long)"})
  void testWithIdWithValue2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithIdResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithIdResult.databaseName());
    assertEquals("Dbms Name", actualWithIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithIdResult.instanceName());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(long)"})
  void testWithIdWithValue3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithIdResult = immutableDatabaseInformation.withId(1L);

    // Assert
    assertSame(immutableDatabaseInformation, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDatabaseInformation ImmutableDatabaseInformation.withId(long)"})
  void testWithIdWithValue_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithIdResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.dbmsVersion());
    assertEquals("Database Name", actualWithIdResult.databaseName());
    assertEquals("Dbms Name", actualWithIdResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithIdResult.dbmsVendor());
    assertEquals("Instance Name", actualWithIdResult.instanceName());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertNull(actualWithIdResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withInstanceName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withInstanceName(String)}
   */
  @Test
  @DisplayName("Test withInstanceName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withInstanceName(String)"
  })
  void testWithInstanceName() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithInstanceNameResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withInstanceName("42");

    // Assert
    assertEquals("1.0.2", actualWithInstanceNameResult.dbmsVersion());
    assertEquals("42", actualWithInstanceNameResult.instanceName());
    assertEquals("Database Name", actualWithInstanceNameResult.databaseName());
    assertEquals("Dbms Name", actualWithInstanceNameResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithInstanceNameResult.dbmsVendor());
    assertEquals("Provenance", actualWithInstanceNameResult.provenance());
    assertEquals(EntityKind.ALL, actualWithInstanceNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithInstanceNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withInstanceName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withInstanceName(String)}
   */
  @Test
  @DisplayName("Test withInstanceName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withInstanceName(String)"
  })
  void testWithInstanceName2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithInstanceNameResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withInstanceName("42");

    // Assert
    assertEquals("1.0.2", actualWithInstanceNameResult.dbmsVersion());
    assertEquals("42", actualWithInstanceNameResult.instanceName());
    assertEquals("Database Name", actualWithInstanceNameResult.databaseName());
    assertEquals("Dbms Name", actualWithInstanceNameResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithInstanceNameResult.dbmsVendor());
    assertEquals("Provenance", actualWithInstanceNameResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithInstanceNameResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithInstanceNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithInstanceNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withInstanceName(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withInstanceName(String)}
   */
  @Test
  @DisplayName("Test withInstanceName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withInstanceName(String)"
  })
  void testWithInstanceName3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("42")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithInstanceNameResult =
        immutableDatabaseInformation.withInstanceName("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithInstanceNameResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withInstanceName(String)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withInstanceName(String)}
   */
  @Test
  @DisplayName("Test withInstanceName(String); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withInstanceName(String)"
  })
  void testWithInstanceName_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithInstanceNameResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withInstanceName("42");

    // Assert
    assertEquals("1.0.2", actualWithInstanceNameResult.dbmsVersion());
    assertEquals("42", actualWithInstanceNameResult.instanceName());
    assertEquals("Database Name", actualWithInstanceNameResult.databaseName());
    assertEquals("Dbms Name", actualWithInstanceNameResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithInstanceNameResult.dbmsVendor());
    assertEquals("Provenance", actualWithInstanceNameResult.provenance());
    assertNull(actualWithInstanceNameResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithInstanceNameResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithInstanceNameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithInstanceNameResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithKindResult =
        immutableDatabaseInformation.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableDatabaseInformation, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withKind(EntityKind)"
  })
  void testWithKind2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithKindResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.dbmsVersion());
    assertEquals("Database Name", actualWithKindResult.databaseName());
    assertEquals("Dbms Name", actualWithKindResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithKindResult.dbmsVendor());
    assertEquals("Instance Name", actualWithKindResult.instanceName());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithKindResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withKind(EntityKind)"
  })
  void testWithKind3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithKindResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.dbmsVersion());
    assertEquals("Database Name", actualWithKindResult.databaseName());
    assertEquals("Dbms Name", actualWithKindResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithKindResult.dbmsVendor());
    assertEquals("Instance Name", actualWithKindResult.instanceName());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithKindResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithKindResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withKind(EntityKind)"
  })
  void testWithKind_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithKindResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.dbmsVersion());
    assertEquals("Database Name", actualWithKindResult.databaseName());
    assertEquals("Dbms Name", actualWithKindResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithKindResult.dbmsVendor());
    assertEquals("Instance Name", actualWithKindResult.instanceName());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertNull(actualWithKindResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithKindResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithKindResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithLifecycleStatusResult =
        immutableDatabaseInformation.withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableDatabaseInformation, actualWithLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithLifecycleStatusResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .provenance("Provenance")
            .build()
            .withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertEquals("1.0.2", actualWithLifecycleStatusResult.dbmsVersion());
    assertEquals("Database Name", actualWithLifecycleStatusResult.databaseName());
    assertEquals("Dbms Name", actualWithLifecycleStatusResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithLifecycleStatusResult.dbmsVendor());
    assertEquals("Instance Name", actualWithLifecycleStatusResult.instanceName());
    assertEquals("Provenance", actualWithLifecycleStatusResult.provenance());
    assertEquals(EntityKind.ALL, actualWithLifecycleStatusResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLifecycleStatusResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithLifecycleStatusResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .provenance("Provenance")
            .build()
            .withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertEquals("1.0.2", actualWithLifecycleStatusResult.dbmsVersion());
    assertEquals("Database Name", actualWithLifecycleStatusResult.databaseName());
    assertEquals("Dbms Name", actualWithLifecycleStatusResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithLifecycleStatusResult.dbmsVendor());
    assertEquals("Instance Name", actualWithLifecycleStatusResult.instanceName());
    assertEquals("Provenance", actualWithLifecycleStatusResult.provenance());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithLifecycleStatusResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithLifecycleStatusResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLifecycleStatusResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithLifecycleStatusResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .provenance("Provenance")
            .build()
            .withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertEquals("1.0.2", actualWithLifecycleStatusResult.dbmsVersion());
    assertEquals("Database Name", actualWithLifecycleStatusResult.databaseName());
    assertEquals("Dbms Name", actualWithLifecycleStatusResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithLifecycleStatusResult.dbmsVendor());
    assertEquals("Instance Name", actualWithLifecycleStatusResult.instanceName());
    assertEquals("Provenance", actualWithLifecycleStatusResult.provenance());
    assertNull(actualWithLifecycleStatusResult.endOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithLifecycleStatusResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithLifecycleStatusResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLifecycleStatusResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithProvenanceResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.dbmsVersion());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Database Name", actualWithProvenanceResult.databaseName());
    assertEquals("Dbms Name", actualWithProvenanceResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithProvenanceResult.dbmsVendor());
    assertEquals("Instance Name", actualWithProvenanceResult.instanceName());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithProvenanceResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withProvenance(String)"
  })
  void testWithProvenance2() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableDatabaseInformation actualWithProvenanceResult =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.dbmsVersion());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Database Name", actualWithProvenanceResult.databaseName());
    assertEquals("Dbms Name", actualWithProvenanceResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithProvenanceResult.dbmsVendor());
    assertEquals("Instance Name", actualWithProvenanceResult.instanceName());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithProvenanceResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithProvenanceResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withProvenance(String)"
  })
  void testWithProvenance3() {
    // Arrange
    Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    ImmutableDatabaseInformation immutableDatabaseInformation =
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("42")
            .build();

    // Act
    ImmutableDatabaseInformation actualWithProvenanceResult =
        immutableDatabaseInformation.withProvenance("42");

    // Assert
    assertSame(immutableDatabaseInformation, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableDatabaseInformation#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return endOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return endOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseInformation ImmutableDatabaseInformation.withProvenance(String)"
  })
  void testWithProvenance_thenReturnEndOfLifeDateIsNull() {
    // Arrange and Act
    ImmutableDatabaseInformation actualWithProvenanceResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2")
            .endOfLifeDate(null)
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.dbmsVersion());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Database Name", actualWithProvenanceResult.databaseName());
    assertEquals("Dbms Name", actualWithProvenanceResult.dbmsName());
    assertEquals("Dbms Vendor", actualWithProvenanceResult.dbmsVendor());
    assertEquals("Instance Name", actualWithProvenanceResult.instanceName());
    assertNull(actualWithProvenanceResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithProvenanceResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithProvenanceResult.lifecycleStatus());
  }
}
