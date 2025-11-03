package org.finos.waltz.model.database_information;

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
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EndOfLifeStatus;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.database_information.ImmutableDatabaseInformation.Builder;
import org.finos.waltz.model.database_information.ImmutableDatabaseInformation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDatabaseInformationDiffblueTest {
  /**
   * Test {@link ImmutableDatabaseInformation#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDatabaseInformation#builder()}
   *   <li>{@link ImmutableDatabaseInformation#endOfLifeDate(Date)}
   *   <li>{@link ImmutableDatabaseInformation#externalId(String)}
   *   <li>{@link ImmutableDatabaseInformation#kind(EntityKind)}
   *   <li>{@link ImmutableDatabaseInformation#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDatabaseInformation Builder.build()", "Builder Builder.endOfLifeDate(Date)",
      "Builder Builder.externalId(String)", "Builder Builder.kind(EntityKind)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableDatabaseInformation.builder();
    Builder actualExternalIdResult = actualBuilderResult
        .endOfLifeDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#databaseName(String)}.
   * <p>
   * Method under test: {@link Builder#databaseName(String)}
   */
  @Test
  @DisplayName("Test Builder databaseName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.databaseName(String)"})
  void testBuilderDatabaseName() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databaseName("Database Name"));
  }

  /**
   * Test Builder {@link Builder#dbmsName(String)}.
   * <p>
   * Method under test: {@link Builder#dbmsName(String)}
   */
  @Test
  @DisplayName("Test Builder dbmsName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dbmsName(String)"})
  void testBuilderDbmsName() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsName("Dbms Name"));
  }

  /**
   * Test Builder {@link Builder#dbmsVendor(String)}.
   * <p>
   * Method under test: {@link Builder#dbmsVendor(String)}
   */
  @Test
  @DisplayName("Test Builder dbmsVendor(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dbmsVendor(String)"})
  void testBuilderDbmsVendor() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsVendor("Dbms Vendor"));
  }

  /**
   * Test Builder {@link Builder#dbmsVersion(String)}.
   * <p>
   * Method under test: {@link Builder#dbmsVersion(String)}
   */
  @Test
  @DisplayName("Test Builder dbmsVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dbmsVersion(String)"})
  void testBuilderDbmsVersion() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsVersion("1.0.2"));
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   * <p>
   * Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenReturn("1.0.2");
    when(instance.dbmsVendor()).thenReturn("Dbms Vendor");
    when(instance.dbmsName()).thenReturn("Dbms Name");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endOfLifeDate()).thenReturn(fromResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.instanceName()).thenReturn("Instance Name");
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.databaseName()).thenReturn("Database Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).databaseName();
    verify(instance).dbmsName();
    verify(instance).dbmsVendor();
    verify(instance).dbmsVersion();
    verify(instance).endOfLifeDate();
    verify(instance).instanceName();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    ImmutableDatabaseInformation buildResult = actualFromResult.build();
    assertEquals("1.0.2", buildResult.dbmsVersion());
    assertEquals("Database Name", buildResult.databaseName());
    assertEquals("Dbms Name", buildResult.dbmsName());
    assertEquals("Dbms Vendor", buildResult.dbmsVendor());
    assertEquals("Instance Name", buildResult.instanceName());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(fromResult, builderResult.build().endOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   * <ul>
   *   <li>Given {@code 1.0.2}.</li>
   *   <li>Then return build dbmsVersion is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'; given '1.0.2'; then return build dbmsVersion is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation_given102_thenReturnBuildDbmsVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenReturn("1.0.2");
    when(instance.dbmsVendor()).thenReturn("Dbms Vendor");
    when(instance.dbmsName()).thenReturn("Dbms Name");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endOfLifeDate()).thenReturn(fromResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.instanceName()).thenReturn("Instance Name");
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.databaseName()).thenReturn("Database Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).databaseName();
    verify(instance).dbmsName();
    verify(instance).dbmsVendor();
    verify(instance).dbmsVersion();
    verify(instance).endOfLifeDate();
    verify(instance).instanceName();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    ImmutableDatabaseInformation buildResult = actualFromResult.build();
    assertEquals("1.0.2", buildResult.dbmsVersion());
    assertEquals("Database Name", buildResult.databaseName());
    assertEquals("Dbms Name", buildResult.dbmsName());
    assertEquals("Dbms Vendor", buildResult.dbmsVendor());
    assertEquals("Instance Name", buildResult.instanceName());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(fromResult, builderResult.build().endOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   * <ul>
   *   <li>Then builder build dbmsVersion is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'; then builder build dbmsVersion is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation_thenBuilderBuildDbmsVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenReturn("1.0.2");
    when(instance.dbmsVendor()).thenReturn("Dbms Vendor");
    when(instance.dbmsName()).thenReturn("Dbms Name");
    when(instance.endOfLifeDate()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.instanceName()).thenReturn("Instance Name");
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.databaseName()).thenReturn("Database Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).databaseName();
    verify(instance).dbmsName();
    verify(instance).dbmsVendor();
    verify(instance).dbmsVersion();
    verify(instance).endOfLifeDate();
    verify(instance).instanceName();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    ImmutableDatabaseInformation buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.dbmsVersion());
    assertEquals("Database Name", buildResult.databaseName());
    assertEquals("Dbms Name", buildResult.dbmsName());
    assertEquals("Dbms Vendor", buildResult.dbmsVendor());
    assertEquals("Instance Name", buildResult.instanceName());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, buildResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenThrow(new IllegalStateException("instance"));
    when(instance.dbmsVendor()).thenReturn("Dbms Vendor");
    when(instance.dbmsName()).thenReturn("Dbms Name");
    when(instance.endOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.instanceName()).thenReturn("Instance Name");
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.databaseName()).thenReturn("Database Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).databaseName();
    verify(instance).dbmsName();
    verify(instance).dbmsVendor();
    verify(instance).dbmsVersion();
    verify(instance).endOfLifeDate();
    verify(instance).instanceName();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
  }

  /**
   * Test Builder {@link Builder#from(DatabaseInformation)} with {@code DatabaseInformation}.
   * <ul>
   *   <li>When {@link DatabaseInformation} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DatabaseInformation) with 'DatabaseInformation'; when DatabaseInformation id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DatabaseInformation)"})
  void testBuilderFromWithDatabaseInformation_whenDatabaseInformationIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenReturn("1.0.2");
    when(instance.dbmsVendor()).thenReturn("Dbms Vendor");
    when(instance.dbmsName()).thenReturn("Dbms Name");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endOfLifeDate()).thenReturn(fromResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.instanceName()).thenReturn("Instance Name");
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.databaseName()).thenReturn("Database Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).databaseName();
    verify(instance).dbmsName();
    verify(instance).dbmsVendor();
    verify(instance).dbmsVersion();
    verify(instance).endOfLifeDate();
    verify(instance).instanceName();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    ImmutableDatabaseInformation buildResult = actualFromResult.build();
    assertEquals("1.0.2", buildResult.dbmsVersion());
    assertEquals("Database Name", buildResult.databaseName());
    assertEquals("Dbms Name", buildResult.dbmsName());
    assertEquals("Dbms Vendor", buildResult.dbmsVendor());
    assertEquals("Instance Name", buildResult.instanceName());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(fromResult, builderResult.build().endOfLifeDate());
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();
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
    Builder builderResult = ImmutableDatabaseInformation.builder();

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
    Builder builderResult = ImmutableDatabaseInformation.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#instanceName(String)}.
   * <p>
   * Method under test: {@link Builder#instanceName(String)}
   */
  @Test
  @DisplayName("Test Builder instanceName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.instanceName(String)"})
  void testBuilderInstanceName() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceName("Instance Name"));
  }

  /**
   * Test Builder {@link Builder#lifecycleStatus(LifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder lifecycleStatus(LifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecycleStatus(LifecycleStatus)"})
  void testBuilderLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecycleStatus(LifecycleStatus.ACTIVE));
  }

  /**
   * Test Json {@link Json#databaseName()}.
   * <p>
   * Method under test: {@link Json#databaseName()}
   */
  @Test
  @DisplayName("Test Json databaseName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.databaseName()"})
  void testJsonDatabaseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).databaseName());
  }

  /**
   * Test Json {@link Json#dbmsName()}.
   * <p>
   * Method under test: {@link Json#dbmsName()}
   */
  @Test
  @DisplayName("Test Json dbmsName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.dbmsName()"})
  void testJsonDbmsName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dbmsName());
  }

  /**
   * Test Json {@link Json#dbmsVendor()}.
   * <p>
   * Method under test: {@link Json#dbmsVendor()}
   */
  @Test
  @DisplayName("Test Json dbmsVendor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.dbmsVendor()"})
  void testJsonDbmsVendor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dbmsVendor());
  }

  /**
   * Test Json {@link Json#dbmsVersion()}.
   * <p>
   * Method under test: {@link Json#dbmsVersion()}
   */
  @Test
  @DisplayName("Test Json dbmsVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.dbmsVersion()"})
  void testJsonDbmsVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dbmsVersion());
  }

  /**
   * Test Json {@link Json#endOfLifeDate()}.
   * <p>
   * Method under test: {@link Json#endOfLifeDate()}
   */
  @Test
  @DisplayName("Test Json endOfLifeDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date Json.endOfLifeDate()"})
  void testJsonEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).endOfLifeDate());
  }

  /**
   * Test Json {@link Json#endOfLifeStatus()}.
   * <p>
   * Method under test: {@link Json#endOfLifeStatus()}
   */
  @Test
  @DisplayName("Test Json endOfLifeStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EndOfLifeStatus Json.endOfLifeStatus()"})
  void testJsonEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).endOfLifeStatus());
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
   * Test Json {@link Json#instanceName()}.
   * <p>
   * Method under test: {@link Json#instanceName()}
   */
  @Test
  @DisplayName("Test Json instanceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.instanceName()"})
  void testJsonInstanceName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).instanceName());
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
   * Test Json {@link Json#lifecycleStatus()}.
   * <p>
   * Method under test: {@link Json#lifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json lifecycleStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecycleStatus Json.lifecycleStatus()"})
  void testJsonLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lifecycleStatus());
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
}
