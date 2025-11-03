package org.finos.waltz.model.allocation;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.allocation.ImmutableAllocation.Builder;
import org.finos.waltz.model.allocation.ImmutableAllocation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocationDiffblueTest {
  /**
   * Test {@link ImmutableAllocation#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAllocation#builder()}
   *   <li>{@link ImmutableAllocation#externalId(String)}
   *   <li>{@link ImmutableAllocation#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAllocation#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocation Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableAllocation.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);
    Builder actualLastUpdatedAtResult = actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
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
    Builder builderResult = ImmutableAllocation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(Allocation)} with {@code Allocation}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Allocation} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Allocation)}
   */
  @Test
  @DisplayName("Test Builder from(Allocation) with 'Allocation'; given empty; when Allocation externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Allocation)"})
  void testBuilderFromWithAllocation_givenEmpty_whenAllocationExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    ImmutableAllocation buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertEquals(1L, buildResult.schemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Allocation)} with {@code Allocation}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Allocation)}
   */
  @Test
  @DisplayName("Test Builder from(Allocation) with 'Allocation'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Allocation)"})
  void testBuilderFromWithAllocation_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    ImmutableAllocation buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertEquals(1L, buildResult.schemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Allocation)} with {@code Allocation}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>When {@link Allocation} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Allocation)}
   */
  @Test
  @DisplayName("Test Builder from(Allocation) with 'Allocation'; given Optional with 'foo'; when Allocation id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Allocation)"})
  void testBuilderFromWithAllocation_givenOptionalWithFoo_whenAllocationIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    ImmutableAllocation buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertEquals(1L, buildResult.schemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Allocation)} with {@code Allocation}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Allocation)}
   */
  @Test
  @DisplayName("Test Builder from(Allocation) with 'Allocation'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Allocation)"})
  void testBuilderFromWithAllocation_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.measurableRatingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(Long)}.
   * <p>
   * Method under test: {@link Builder#measurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRatingId(Long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Test Builder {@link Builder#percentage(int)}.
   * <p>
   * Method under test: {@link Builder#percentage(int)}
   */
  @Test
  @DisplayName("Test Builder percentage(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.percentage(int)"})
  void testBuilderPercentage() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.percentage(1));
  }

  /**
   * Test Builder {@link Builder#schemeId(long)}.
   * <p>
   * Method under test: {@link Builder#schemeId(long)}
   */
  @Test
  @DisplayName("Test Builder schemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.schemeId(long)"})
  void testBuilderSchemeId() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.schemeId(1L));
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
   * Test Json {@link Json#measurableRatingId()}.
   * <p>
   * Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRatingId());
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
    assertNull(actualJson.measurableRatingId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertEquals(0, actualJson.percentage);
    assertEquals(0L, actualJson.schemeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.percentageIsSet);
    assertFalse(actualJson.schemeIdIsSet);
  }

  /**
   * Test Json {@link Json#percentage()}.
   * <p>
   * Method under test: {@link Json#percentage()}
   */
  @Test
  @DisplayName("Test Json percentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.percentage()"})
  void testJsonPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).percentage());
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
   * Test Json {@link Json#schemeId()}.
   * <p>
   * Method under test: {@link Json#schemeId()}
   */
  @Test
  @DisplayName("Test Json schemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.schemeId()"})
  void testJsonSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).schemeId());
  }

  /**
   * Test Json {@link Json#setPercentage(int)}.
   * <p>
   * Method under test: {@link Json#setPercentage(int)}
   */
  @Test
  @DisplayName("Test Json setPercentage(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPercentage(int)"})
  void testJsonSetPercentage() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPercentage(1);

    // Assert
    assertEquals(1, json.percentage);
    assertTrue(json.percentageIsSet);
  }

  /**
   * Test Json {@link Json#setSchemeId(long)}.
   * <p>
   * Method under test: {@link Json#setSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSchemeId(long)"})
  void testJsonSetSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSchemeId(1L);

    // Assert
    assertEquals(1L, json.schemeId);
    assertTrue(json.schemeIdIsSet);
  }
}
