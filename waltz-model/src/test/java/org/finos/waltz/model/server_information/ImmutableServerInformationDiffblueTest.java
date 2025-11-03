package org.finos.waltz.model.server_information;

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
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.server_information.ImmutableServerInformation.Builder;
import org.finos.waltz.model.server_information.ImmutableServerInformation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableServerInformationDiffblueTest {
  /**
   * Test {@link ImmutableServerInformation#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableServerInformation#builder()}
   *   <li>{@link ImmutableServerInformation#externalId(String)}
   *   <li>{@link ImmutableServerInformation#hardwareEndOfLifeDate(Date)}
   *   <li>{@link ImmutableServerInformation#kind(EntityKind)}
   *   <li>{@link ImmutableServerInformation#operatingSystemEndOfLifeDate(Date)}
   *   <li>{@link ImmutableServerInformation#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableServerInformation Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.hardwareEndOfLifeDate(Date)", "Builder Builder.kind(EntityKind)",
      "Builder Builder.operatingSystemEndOfLifeDate(Date)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableServerInformation.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    Builder actualIdResult = actualExternalIdResult2
        .hardwareEndOfLifeDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    Builder actualOperatingSystemEndOfLifeDateResult = actualKindResult.operatingSystemEndOfLifeDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(actualOperatingSystemEndOfLifeDateResult,
        actualOperatingSystemEndOfLifeDateResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#country(String)}.
   * <p>
   * Method under test: {@link Builder#country(String)}
   */
  @Test
  @DisplayName("Test Builder country(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.country(String)"})
  void testBuilderCountry() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.country("GB"));
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
    Builder builderResult = ImmutableServerInformation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
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
    Builder builderResult = ImmutableServerInformation.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   * <p>
   * Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertSame(fromResult2, buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   * <p>
   * Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation2() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(null);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertNull(actualFromResult.build().operatingSystemEndOfLifeDate());
    ImmutableServerInformation buildResult = builderResult.build();
    assertNull(buildResult.operatingSystemEndOfLifeDate());
    assertSame(fromResult, buildResult.hardwareEndOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   * <ul>
   *   <li>Then return build hardwareEndOfLifeDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'; then return build hardwareEndOfLifeDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation_thenReturnBuildHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.hardwareEndOfLifeDate()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertNull(actualFromResult.build().hardwareEndOfLifeDate());
    ImmutableServerInformation buildResult = builderResult.build();
    assertNull(buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    when(instance.operatingSystemEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.hardwareEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   * <ul>
   *   <li>When {@link ServerInformation} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'; when ServerInformation externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation_whenServerInformationExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertSame(fromResult2, buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   * <ul>
   *   <li>When {@link ServerInformation} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'; when ServerInformation id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation_whenServerInformationIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertSame(fromResult2, buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#hostname(String)}.
   * <p>
   * Method under test: {@link Builder#hostname(String)}
   */
  @Test
  @DisplayName("Test Builder hostname(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.hostname(String)"})
  void testBuilderHostname() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hostname("localhost"));
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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
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
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecycleStatus(LifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#location(String)}.
   * <p>
   * Method under test: {@link Builder#location(String)}
   */
  @Test
  @DisplayName("Test Builder location(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.location(String)"})
  void testBuilderLocation() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.location("Location"));
  }

  /**
   * Test Builder {@link Builder#operatingSystem(String)}.
   * <p>
   * Method under test: {@link Builder#operatingSystem(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystem(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operatingSystem(String)"})
  void testBuilderOperatingSystem() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystem("Operating System"));
  }

  /**
   * Test Builder {@link Builder#operatingSystemVersion(String)}.
   * <p>
   * Method under test: {@link Builder#operatingSystemVersion(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystemVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operatingSystemVersion(String)"})
  void testBuilderOperatingSystemVersion() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemVersion("1.0.2"));
  }

  /**
   * Test Builder {@link Builder#virtual(boolean)}.
   * <p>
   * Method under test: {@link Builder#virtual(boolean)}
   */
  @Test
  @DisplayName("Test Builder virtual(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.virtual(boolean)"})
  void testBuilderVirtual() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.virtual(true));
  }

  /**
   * Test Json {@link Json#country()}.
   * <p>
   * Method under test: {@link Json#country()}
   */
  @Test
  @DisplayName("Test Json country()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.country()"})
  void testJsonCountry() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).country());
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
   * Test Json {@link Json#hardwareEndOfLifeDate()}.
   * <p>
   * Method under test: {@link Json#hardwareEndOfLifeDate()}
   */
  @Test
  @DisplayName("Test Json hardwareEndOfLifeDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date Json.hardwareEndOfLifeDate()"})
  void testJsonHardwareEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hardwareEndOfLifeDate());
  }

  /**
   * Test Json {@link Json#hardwareEndOfLifeStatus()}.
   * <p>
   * Method under test: {@link Json#hardwareEndOfLifeStatus()}
   */
  @Test
  @DisplayName("Test Json hardwareEndOfLifeStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.waltz.model.EndOfLifeStatus Json.hardwareEndOfLifeStatus()"})
  void testJsonHardwareEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hardwareEndOfLifeStatus());
  }

  /**
   * Test Json {@link Json#hostname()}.
   * <p>
   * Method under test: {@link Json#hostname()}
   */
  @Test
  @DisplayName("Test Json hostname()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.hostname()"})
  void testJsonHostname() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hostname());
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
   * Test Json {@link Json#location()}.
   * <p>
   * Method under test: {@link Json#location()}
   */
  @Test
  @DisplayName("Test Json location()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.location()"})
  void testJsonLocation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).location());
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
    assertNull(actualJson.country);
    assertNull(actualJson.hostname);
    assertNull(actualJson.location);
    assertNull(actualJson.operatingSystem);
    assertNull(actualJson.operatingSystemVersion);
    assertNull(actualJson.provenance);
    assertNull(actualJson.hardwareEndOfLifeDate);
    assertNull(actualJson.operatingSystemEndOfLifeDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecycleStatus);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.virtual);
    assertFalse(actualJson.virtualIsSet);
  }

  /**
   * Test Json {@link Json#operatingSystem()}.
   * <p>
   * Method under test: {@link Json#operatingSystem()}
   */
  @Test
  @DisplayName("Test Json operatingSystem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.operatingSystem()"})
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystem());
  }

  /**
   * Test Json {@link Json#operatingSystemEndOfLifeDate()}.
   * <p>
   * Method under test: {@link Json#operatingSystemEndOfLifeDate()}
   */
  @Test
  @DisplayName("Test Json operatingSystemEndOfLifeDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date Json.operatingSystemEndOfLifeDate()"})
  void testJsonOperatingSystemEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystemEndOfLifeDate());
  }

  /**
   * Test Json {@link Json#operatingSystemEndOfLifeStatus()}.
   * <p>
   * Method under test: {@link Json#operatingSystemEndOfLifeStatus()}
   */
  @Test
  @DisplayName("Test Json operatingSystemEndOfLifeStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.waltz.model.EndOfLifeStatus Json.operatingSystemEndOfLifeStatus()"})
  void testJsonOperatingSystemEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystemEndOfLifeStatus());
  }

  /**
   * Test Json {@link Json#operatingSystemVersion()}.
   * <p>
   * Method under test: {@link Json#operatingSystemVersion()}
   */
  @Test
  @DisplayName("Test Json operatingSystemVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.operatingSystemVersion()"})
  void testJsonOperatingSystemVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystemVersion());
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
   * Test Json {@link Json#setVirtual(boolean)}.
   * <p>
   * Method under test: {@link Json#setVirtual(boolean)}
   */
  @Test
  @DisplayName("Test Json setVirtual(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setVirtual(boolean)"})
  void testJsonSetVirtual() {
    // Arrange
    Json json = new Json();

    // Act
    json.setVirtual(true);

    // Assert
    assertTrue(json.virtual);
    assertTrue(json.virtualIsSet);
  }

  /**
   * Test Json {@link Json#virtual()}.
   * <p>
   * Method under test: {@link Json#virtual()}
   */
  @Test
  @DisplayName("Test Json virtual()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.virtual()"})
  void testJsonVirtual() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).virtual());
  }
}
