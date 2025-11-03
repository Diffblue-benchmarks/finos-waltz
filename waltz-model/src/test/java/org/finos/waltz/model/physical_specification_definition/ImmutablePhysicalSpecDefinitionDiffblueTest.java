package org.finos.waltz.model.physical_specification_definition;

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
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalSpecDefinition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinition#builder()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#createdAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#delimiter(String)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalSpecDefinition Builder.build()", "Builder Builder.createdAt(LocalDateTime)",
      "Builder Builder.delimiter(String)", "Builder Builder.lastUpdatedAt(LocalDateTime)",
      "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePhysicalSpecDefinition.builder();
    Builder actualDelimiterResult = actualBuilderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .delimiter("Delimiter");
    Optional<String> delimiter = Optional.of("foo");
    Builder actualIdResult = actualDelimiterResult.delimiter(delimiter).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);
    Builder actualLastUpdatedAtResult = actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   * <p>
   * Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName("Test Builder createdBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Test Builder {@link Builder#delimiter(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#delimiter(Optional)}
   */
  @Test
  @DisplayName("Test Builder delimiter(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.delimiter(Optional)"})
  void testBuilderDelimiterWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    Optional<String> delimiter = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.delimiter(delimiter));
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinition)} with {@code PhysicalSpecDefinition}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinition) with 'PhysicalSpecDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinition)"})
  void testBuilderFromWithPhysicalSpecDefinition() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinition buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinition)} with {@code PhysicalSpecDefinition}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinition) with 'PhysicalSpecDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinition)"})
  void testBuilderFromWithPhysicalSpecDefinition2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.delimiter()).thenReturn(emptyResult);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinition buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinition)} with {@code PhysicalSpecDefinition}.
   * <ul>
   *   <li>Then builder build version is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinition) with 'PhysicalSpecDefinition'; then builder build version is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinition)"})
  void testBuilderFromWithPhysicalSpecDefinition_thenBuilderBuildVersionIs102() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult2);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinition buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinition)} with {@code PhysicalSpecDefinition}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinition) with 'PhysicalSpecDefinition'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinition)"})
  void testBuilderFromWithPhysicalSpecDefinition_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    PhysicalSpecDefinition instance = mock(PhysicalSpecDefinition.class);
    when(instance.status()).thenThrow(new IllegalStateException("instance"));
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult2);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).delimiter();
    verify(instance).specificationId();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specificationId(1L));
  }

  /**
   * Test Builder {@link Builder#status(ReleaseLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ReleaseLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(ReleaseLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Test Builder {@link Builder#type(PhysicalSpecDefinitionType)}.
   * <p>
   * Method under test: {@link Builder#type(PhysicalSpecDefinitionType)}
   */
  @Test
  @DisplayName("Test Builder type(PhysicalSpecDefinitionType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.type(PhysicalSpecDefinitionType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(PhysicalSpecDefinitionType.DELIMITED));
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   * <p>
   * Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Test Json {@link Json#createdAt()}.
   * <p>
   * Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   * <p>
   * Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdBy());
  }

  /**
   * Test Json {@link Json#delimiter()}.
   * <p>
   * Method under test: {@link Json#delimiter()}
   */
  @Test
  @DisplayName("Test Json delimiter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.delimiter()"})
  void testJsonDelimiter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).delimiter());
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
    assertNull(actualJson.createdBy);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.version);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.status);
    assertNull(actualJson.type);
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.delimiter.isPresent());
    assertFalse(actualJson.id.isPresent());
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
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }

  /**
   * Test Json {@link Json#type()}.
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalSpecDefinitionType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }

  /**
   * Test Json {@link Json#version()}.
   * <p>
   * Method under test: {@link Json#version()}
   */
  @Test
  @DisplayName("Test Json version()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.version()"})
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).version());
  }
}
