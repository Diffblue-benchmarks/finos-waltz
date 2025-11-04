package org.finos.waltz.model.database_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;

class ImmutableDatabaseInformationDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableDatabaseInformation.Builder actualBuilderResult = ImmutableDatabaseInformation.builder();
    ImmutableDatabaseInformation.Builder actualExternalIdResult = actualBuilderResult
        .endOfLifeDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableDatabaseInformation.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableDatabaseInformation.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#databaseName(String)}
   */
  @Test
  void testBuilderDatabaseName() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databaseName("Database Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#databaseName(String)}
   */
  @Test
  void testBuilderDatabaseName2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.databaseName("Database Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#dbmsName(String)}
   */
  @Test
  void testBuilderDbmsName() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsName("Dbms Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#dbmsName(String)}
   */
  @Test
  void testBuilderDbmsName2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsName("Dbms Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#dbmsVendor(String)}
   */
  @Test
  void testBuilderDbmsVendor() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsVendor("Dbms Vendor"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#dbmsVendor(String)}
   */
  @Test
  void testBuilderDbmsVendor2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsVendor("Dbms Vendor"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#dbmsVersion(String)}
   */
  @Test
  void testBuilderDbmsVersion() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsVersion("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#dbmsVersion(String)}
   */
  @Test
  void testBuilderDbmsVersion2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.dbmsVersion("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(DatabaseInformation)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
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
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(fromResult, buildResult.endOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(DatabaseInformation)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
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
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(DatabaseInformation)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
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
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(DatabaseInformation)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
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
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(fromResult, buildResult.endOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#from(DatabaseInformation)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
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
    ImmutableDatabaseInformation.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertSame(fromResult, buildResult.endOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#instanceName(String)}
   */
  @Test
  void testBuilderInstanceName() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceName("Instance Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#instanceName(String)}
   */
  @Test
  void testBuilderInstanceName2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.instanceName("Instance Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  void testBuilderLifecycleStatus() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecycleStatus(LifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  void testBuilderLifecycleStatus2() {
    // Arrange
    ImmutableDatabaseInformation.Builder builderResult = ImmutableDatabaseInformation.builder();
    builderResult.endOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lifecycleStatus(LifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

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
    assertEquals("1.0.2", actualCopyOfResult.dbmsVersion());
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertSame(fromResult, actualCopyOfResult.endOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenReturn("instance");
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
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

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
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("instance", actualCopyOfResult.dbmsVersion());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertSame(fromResult, actualCopyOfResult.endOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    DatabaseInformation instance = mock(DatabaseInformation.class);
    when(instance.dbmsVersion()).thenReturn("1.0.2");
    when(instance.dbmsVendor()).thenReturn("Dbms Vendor");
    when(instance.dbmsName()).thenReturn("Dbms Name");
    Date fromResult = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

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
    assertEquals("1.0.2", actualCopyOfResult.dbmsVersion());
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualCopyOfResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertSame(fromResult, actualCopyOfResult.endOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

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
    assertEquals("1.0.2", actualCopyOfResult.dbmsVersion());
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.endOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualCopyOfResult.endOfLifeStatus());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
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
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

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
    assertEquals("1.0.2", actualCopyOfResult.dbmsVersion());
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertSame(fromResult, actualCopyOfResult.endOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation#copyOf(DatabaseInformation)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
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
    ImmutableDatabaseInformation actualCopyOfResult = ImmutableDatabaseInformation.copyOf(instance);

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
    assertEquals("1.0.2", actualCopyOfResult.dbmsVersion());
    assertEquals("Database Name", actualCopyOfResult.databaseName());
    assertEquals("Dbms Name", actualCopyOfResult.dbmsName());
    assertEquals("Dbms Vendor", actualCopyOfResult.dbmsVendor());
    assertEquals("Instance Name", actualCopyOfResult.instanceName());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertSame(fromResult, actualCopyOfResult.endOfLifeDate());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#databaseName()}
   */
  @Test
  void testJsonDatabaseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).databaseName());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#dbmsName()}
   */
  @Test
  void testJsonDbmsName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).dbmsName());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#dbmsVendor()}
   */
  @Test
  void testJsonDbmsVendor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).dbmsVendor());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#dbmsVersion()}
   */
  @Test
  void testJsonDbmsVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).dbmsVersion());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#endOfLifeDate()}
   */
  @Test
  void testJsonEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).endOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Json#endOfLifeStatus()}
   */
  @Test
  void testJsonEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDatabaseInformation.Json()).endOfLifeStatus());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#instanceName()}
   */
  @Test
  void testJsonInstanceName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).instanceName());
  }

  /**
   * Method under test: {@link ImmutableDatabaseInformation.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseInformation.Json#lifecycleStatus()}
   */
  @Test
  void testJsonLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDatabaseInformation.Json()).lifecycleStatus());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDatabaseInformation.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDatabaseInformation.Json actualJson = new ImmutableDatabaseInformation.Json();

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
   * Method under test: {@link ImmutableDatabaseInformation.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseInformation.Json()).provenance());
  }
}
